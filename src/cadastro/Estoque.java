// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Estoque.java

package cadastro;


// Referenced classes of package cadastro:
//            Fornecedor, Produto, Empresa

public class Estoque
{

    public Estoque()
    {
        fornecedor = new Fornecedor();
        produto = new Produto();
        empresa = new Empresa();
    }

    public String pesquisaEstoque()
    {
        return "SELECT estoque FROM produto WHERE produtoID = '" + produto.produtoID + "'";
    }

    public String salvaEstoque()
    {
        String salvarEst = "INSERT INTO estoque ";
        salvarEst = salvarEst + "(fornecedorID, produtoID, quantidade, precoCusto, preco, lucro, unidade, usuario, empresaID) ";
        salvarEst = salvarEst + "VALUES ";
        salvarEst = salvarEst + "('" + fornecedor.fornecedorID + "', '" + produto.produtoID + "', '" + quantidade + "', '" + produto.precoCusto + "', ";
        salvarEst = salvarEst + "'" + produto.preco + "', '" + produto.lucro + "', '" + produto.unidade + "', '" + usuario + "', '" + empresa.empresaID + "')";
        return salvarEst;
    }

    public String alteraEstoqueProduto()
    {
        String alteraEst = "UPDATE produto SET precoCusto = '" + produto.precoCusto + "', preco = '" + produto.preco + "', estoque = '" + quantidade + "', ";
        alteraEst = alteraEst + "lucro = '" + produto.lucro + "', unidade = '" + produto.unidade + "' ";
        alteraEst = alteraEst + "WHERE produtoID = '" + produto.produtoID + "'";
        return alteraEst;
    }

    public String alteraEstoque()
    {
        return "UPDATE produto SET estoque = '" + produto.estoque + "' WHERE produtoID = '" + produto.produtoID + "'";
    }

    public String qtdTotalEstoque()
    {
        return "SELECT SUM(estoque) AS produtoEstoque, precoCusto FROM produto WHERE produtoAtivo = 'S'";
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "";

        case 2: // '\002'
            return "";

        case 3: // '\003'
            return "";

        case 4: // '\004'
            return "";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int estoqueID;
    public Fornecedor fornecedor;
    public Produto produto;
    public float quantidade;
    public String usuario;
    public Empresa empresa;
}
