// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Transferencias.java

package financeiro;

import cadastro.Empresa;

public class Transferencias
{

    public Transferencias()
    {
        empresa = new Empresa();
    }

    public String ultimaTransferencia()
    {
        return "SELECT * FROM transferencias ORDER BY transferenciaID DESC LIMIT 1";
    }

    public String transferenciaPorID()
    {
        String pesquisaTransf = "SELECT empresa.empresaID, empresa.unidade, transferencias.* ";
        pesquisaTransf = pesquisaTransf + "FROM transferencias INNER JOIN empresa ON empresa.empresaID = transferencias.empresaID ";
        pesquisaTransf = pesquisaTransf + "WHERE transferencias.transferenciaID = '" + transferenciaID + "'";
        return pesquisaTransf;
    }

    public String cadastraTransferencia()
    {
        String cadastro = "INSERT INTO transferencias ";
        cadastro = cadastro + "(bancoDe, bancoPara, valor, observacoes, empresaID) ";
        cadastro = cadastro + "VALUES ('" + bancoDe + "', '" + bancoPara + "', '" + valor + "', '" + observacoes + "', '" + empresa.empresaID + "')";
        return cadastro;
    }

    public String listaTranferenciasPorData(String dataInicio, String dataFim)
    {
        String busca = "SELECT * FROM transferencias ";
        busca = busca + "WHERE data BETWEEN '" + dataInicio + "' AND '" + dataFim + " 23:59:59" + "'";
        busca = busca + "ORDER BY data ASC";
        return busca;
    }

    public int transferenciaID;
    public int bancoDe;
    public int bancoPara;
    public float valor;
    public String observacoes;
    public String data;
    public Empresa empresa;
}
