// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LivroCaixa.java

package financeiro;


public class LivroCaixa
{

    public LivroCaixa()
    {
    }

    public String listaTodosBancos()
    {
        return "SELECT * FROM livrocaixa ORDER BY status DESC, banco ASC";
    }

    public String listaBancos()
    {
        return "SELECT * FROM livrocaixa WHERE status = 'S' ORDER BY banco ASC";
    }

    public String pesquisaBancoPorNomeEditar()
    {
        return "SELECT * FROM livrocaixa WHERE banco = '" + banco + "' AND livroID <> '" + livroID + "'";
    }

    public String pesquisaBancoPorNome()
    {
        return "SELECT * FROM livrocaixa WHERE banco = '" + banco + "'";
    }

    public String bancoPorID()
    {
        return "SELECT * FROM livrocaixa WHERE livroID = '" + livroID + "'";
    }

    public String saldoEmCaixa()
    {
        return "SELECT saldo FROM livrocaixa WHERE livroID = '" + livroID + "'";
    }

    public String saldoTotal()
    {
        return "SELECT SUM(saldo) as total FROM livrocaixa WHERE status = 'S'";
    }

    public String saldoTotalBancos()
    {
        return "SELECT SUM(saldo) as total FROM livrocaixa WHERE livroID <> '1' AND status = 'S'";
    }

    public String cadastraBanco()
    {
        String cadastra = "INSERT INTO livrocaixa (banco, descricao, valorInicial, dataInicio, saldo) ";
        cadastra = cadastra + "VALUES ('" + banco + "', '" + descricao + "', '" + valorInicial + "', '" + dataInicio + "', '" + valorInicial + "')";
        return cadastra;
    }

    public String atualizaSaldo()
    {
        return "UPDATE livrocaixa SET saldo = '" + saldo + "' WHERE livroID = '" + livroID + "'";
    }

    public String alteraBanco()
    {
        return "UPDATE livrocaixa SET banco = '" + banco + "', descricao = '" + descricao + "' WHERE livroID = '" + livroID + "'";
    }

    public String statusBanco(int numeroAcao)
    {
        if(numeroAcao == 1)
            return "UPDATE livrocaixa SET status = 'N' WHERE livroID = '" + livroID + "'";
        if(numeroAcao == 2)
            return "UPDATE livrocaixa SET status = 'S' WHERE livroID = '" + livroID + "'";
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Novo Banco Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Nome do Banco Alterado com Sucesso!!";

        case 3: // '\003'
            return "IMPOSSIVEL CADASTRAR! J\301 EXISTE UM BANCO CADASTRADO COM ESSE NOME.";

        case 4: // '\004'
            return "IMPOSSIVEL ALTERAR! J\301 EXISTE UM BANCO CADASTRADO COM ESSE NOME.";

        case 5: // '\005'
            return "Trasferencia Realizada com Sucesso!";
        }
        return "";
    }

    public int livroID;
    public String banco;
    public String dataInicio;
    public float valorInicial;
    public float saldo;
    public String descricao;
}
