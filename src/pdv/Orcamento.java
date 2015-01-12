// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Orcamento.java

package pdv;

import cadastro.*;

// Referenced classes of package pdv:
//            FormaPagamento

public class Orcamento
{

    public Orcamento()
    {
        cliente = new Cliente();
        formPag = new FormaPagamento();
        usuario = new Usuario();
        empresa = new Empresa();
    }

    public String orcamentoAberta()
    {
        return "SELECT * FROM orcamento WHERE status = '1' AND usuario = '" + usuario.login + "'";
    }

    public String clienteorcamentoID()
    {
        return "SELECT cliente.* , orcamento.* FROM orcamento LEFT JOIN cliente ON cliente.clienteID = orcamento.clienteID WHERE orcamento.orcamentoID = '" + orcamentoID + "'";
    }

    public String orcamentosFechados(String dataInicial, String dataFinal)
    {
        String busca = "SELECT formapagamento.formID, formapagamento.descricao, ";
        busca = busca + "cliente.clienteID, cliente.clienteNomeFantasia, ";
        busca = busca + "orcamento.* FROM orcamento ";
        busca = busca + "INNER JOIN formapagamento ON formapagamento.formID = orcamento.formPagID ";
        busca = busca + "LEFT JOIN cliente ON cliente.clienteID = orcamento.clienteID ";
        busca = busca + "WHERE orcamento.data BETWEEN '" + dataInicial + "' AND '" + dataFinal + "' ";
        busca = busca + "AND orcamento.status = '2' AND orcamento.empresaID = '" + empresa.empresaID + "' ";
        busca = busca + "ORDER BY data DESC";
        return busca;
    }

    public String dadosOrcamento()
    {
        return "SELECT * FROM orcamento WHERE orcamentoID = '" + orcamentoID + "'";
    }

    public String ultimoOrcamentoPorUsuario()
    {
        return "SELECT * FROM orcamento WHERE usuario = '" + usuario.login + "' AND status = '2' ORDER BY orcamentoID DESC LIMIT 1";
    }

    public String ultimoOrcamento()
    {
        return "SELECT * FROM orcamento ORDER BY orcamentoID DESC LIMIT 1";
    }

    public String somaOrcamentos(int orcamentoInicio, int orcamentoFim)
    {
        String orcamentos = "SELECT SUM(valor) as totalorcamentos ";
        orcamentos = orcamentos + "FROM orcamento ";
        orcamentos = orcamentos + "WHERE orcamentoID BETWEEN '" + orcamentoInicio + "' AND '" + orcamentoFim + "' ";
        orcamentos = orcamentos + "AND usuario = '" + usuario.login + "'";
        return orcamentos;
    }

    public String somaOrcamentosDinheiro(int orcamentoInicio, int orcamentoFim)
    {
        String orcamentos = "SELECT SUM(valor) as totalOrcamentos ";
        orcamentos = orcamentos + "FROM orcamento ";
        orcamentos = orcamentos + "WHERE orcamentoID BETWEEN '" + orcamentoInicio + "' AND '" + orcamentoFim + "' ";
        orcamentos = orcamentos + "AND usuario = '" + usuario.login + "' AND formPagID = '1'";
        return orcamentos;
    }

    public String somaOrcamentoFormaPgto(int orcamentoInicio, int orcamentoFim)
    {
        String orcamentos = "SELECT formapagamento.formID, formapagamento.descricao, ";
        orcamentos = orcamentos + "SUM(orcamento.valor) as totalOrcamentos, orcamento.formPagID ";
        orcamentos = orcamentos + "FROM orcamento ";
        orcamentos = orcamentos + "INNER JOIN formapagamento ON formapagamento.formID = orcamento.formPagID ";
        orcamentos = orcamentos + "WHERE orcamento.orcamentoID BETWEEN '" + orcamentoInicio + "' AND '" + orcamentoFim + "' ";
        orcamentos = orcamentos + "AND orcamento.usuario = '" + usuario.login + "' ";
        orcamentos = orcamentos + "GROUP BY orcamento.formPagID";
        return orcamentos;
    }

    public String cadastraOrcamento()
    {
        String insere = "INSERT INTO orcamento (clienteID, formPagID, vezes, valor, entrada, troco, desconto, notaFiscal, usuario, empresaID) ";
        insere = insere + "VALUES ('0', '0', '0', '0', '0', '0', '0', '0', '" + usuario.login + "', '" + empresa.empresaID + "')";
        return insere;
    }

    public String completaOrcamento()
    {
        String completa = "UPDATE orcamento ";
        completa = completa + "SET clienteID = '" + cliente.clienteID + "', formPagID = '" + formPag.formPagID + "', vezes = '" + vezes + "', ";
        completa = completa + "valor = '" + valor + "', entrada = '" + entrada + "', troco = '" + troco + "', desconto = '" + desconto + "', status = '2' ";
        completa = completa + "WHERE orcamentoID = '" + orcamentoID + "'";
        return completa;
    }

    public String finalizaOrcamento()
    {
        return "UPDATE orcamento SET status = '2' WHERE orcamentoID = '" + orcamentoID + "'";
    }

    public String cancelaOrcamento()
    {
        return "DELETE FROM orcamento WHERE orcamentoID = '" + orcamentoID + "'";
    }

    public int orcamentoID;
    public Cliente cliente;
    public FormaPagamento formPag;
    public int vezes;
    public float valor;
    public float entrada;
    public float troco;
    public float desconto;
    public String notaFiscal;
    public Usuario usuario;
    public String status;
    public Empresa empresa;
}
