// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Cheques.java

package financeiro;

import cadastro.Cliente;

// Referenced classes of package financeiro:
//            Receber

public class Cheques
{

    public Cheques()
    {
        receber = new Receber();
        cliente = new Cliente();
    }

    public String cadastraCheque()
    {
        String cadastra = "INSERT INTO cheques (receberID, clienteID, valorCheque, numeroCheque, vencimentoCheque, observacoes) ";
        cadastra = cadastra + "VALUES ('" + receber.receberID + "', '" + cliente.clienteID + "', '" + valor + "', '" + numero + "', '" + vencimento + "', '" + observacoes + "')";
        return cadastra;
    }

    public String listaCheques()
    {
        String busca = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, cliente.clienteTelefone, ";
        busca = busca + "cheques.* ";
        busca = busca + "FROM cheques ";
        busca = busca + "INNER JOIN cliente ON cliente.clienteID = cheques.clienteID ";
        busca = busca + "ORDER BY cheques.chequeID DESC";
        return busca;
    }

    public String buscaCheques(String numeroCheque)
    {
        String busca = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, cliente.clienteTelefone, ";
        busca = busca + "cheques.* ";
        busca = busca + "FROM cheques ";
        busca = busca + "INNER JOIN cliente ON cliente.clienteID = cheques.clienteID ";
        busca = busca + "WHERE numeroCheque = '" + numeroCheque + "'";
        return busca;
    }

    public String chequePorReceberID()
    {
        String busca = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, cliente.clienteTelefone, ";
        busca = busca + "cheques.* ";
        busca = busca + "FROM cheques ";
        busca = busca + "INNER JOIN cliente ON cliente.clienteID = cheques.clienteID ";
        busca = busca + "WHERE cheques.receberID = '" + receber.receberID + "'";
        return busca;
    }

    public String excluiCheque()
    {
        return "DELETE FROM cheques WHERE chequeID = '" + chequeID + "'";
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Cheque Devolvido ao Contas a Receber com Sucesso!";

        case 2: // '\002'
            return "Registro Excluido com Sucesso";

        case 3: // '\003'
            return "";

        case 4: // '\004'
            return "";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int chequeID;
    public Receber receber;
    public Cliente cliente;
    public float valor;
    public String numero;
    public String vencimento;
    public String observacoes;
}
