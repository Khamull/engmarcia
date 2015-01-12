// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TipoProduto.java

package cadastro;


public class TipoProduto
{

    public TipoProduto()
    {
    }

    public String listaTipos()
    {
        return "SELECT * FROM tipoproduto ORDER BY tipo ASC";
    }

    public String listaTiposAtivos()
    {
        return "SELECT * FROM tipoproduto WHERE tipoAtivo = 'S' ORDER BY tipo ASC";
    }

    public String tipoPorId()
    {
        return "SELECT * FROM tipoproduto WHERE tipoprodutoID = '" + tipoProdutoID + "'";
    }

    public String tipoPorNome()
    {
        return "SELECT * FROM tipoproduto WHERE tipo = '" + tipo + "'";
    }

    public String tipoPorNomeEditar()
    {
        return "SELECT * FROM tipoproduto WHERE tipo = '" + tipo + "' AND tipoprodutoID <> '" + tipoProdutoID + "'";
    }

    public String pesquisaTipos(String keyWord)
    {
        return "SELECT * FROM tipoproduto WHERE tipo LIKE '%" + keyWord + "%'";
    }

    public String salvaTipo()
    {
        return "INSERT INTO tipoproduto (tipo) VALUES ('" + tipo + "')";
    }

    public String alteraTipo()
    {
        return "UPDATE tipoproduto SET tipo = '" + tipo + "' WHERE tipoprodutoID = '" + tipoProdutoID + "'";
    }

    public String excluiTipo()
    {
        return "DELETE FROM tipoproduto WHERE tipoprodutoID = '" + tipoProdutoID + "'";
    }

    public String statusTipo(int numeroAcao)
    {
        if(numeroAcao == 1)
            return "UPDATE tipoproduto SET tipoAtivo = 'N' WHERE tipoprodutoID = '" + tipoProdutoID + "'";
        if(numeroAcao == 2)
            return "UPDATE tipoproduto SET tipoAtivo = 'S' WHERE tipoprodutoID = '" + tipoProdutoID + "'";
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Tipo Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Tipo Alterado com Sucesso!";

        case 3: // '\003'
            return "Tipo Excluido com Sucesso!";

        case 4: // '\004'
            return "Imposs\355vel Cadastrar! J\341 existe um tipo cadastrado com esse Nome.";

        case 5: // '\005'
            return "Imposs\355vel Alterar! J\341 existe um tipo cadastrado com esse Nome.";
        }
        return "";
    }

    public int tipoProdutoID;
    public String tipo;
}
