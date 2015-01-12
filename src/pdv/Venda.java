// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Venda.java

package pdv;

import cadastro.*;

// Referenced classes of package pdv:
//            FormaPagamento

public class Venda
{

    public Venda()
    {
        cliente = new Cliente();
        formPag = new FormaPagamento();
        usuario = new Usuario();
        empresa = new Empresa();
    }

    public String vendaAberta()
    {
        return "SELECT * FROM venda WHERE status = '1' AND usuario = '" + usuario.login + "'";
    }

    public String clienteVendaID()
    {
        return "SELECT cliente.* , venda.* FROM venda LEFT JOIN cliente ON cliente.clienteID = venda.clienteID WHERE venda.vendaID = '" + vendaID + "'";
    }

    public String vendasFechadas(String dataInicial, String dataFinal)
    {
        String busca = "SELECT formapagamento.formID, formapagamento.descricao, ";
        busca = busca + "cliente.clienteID, cliente.clienteNomeFantasia, ";
        busca = busca + "venda.* FROM venda ";
        busca = busca + "INNER JOIN formapagamento ON formapagamento.formID = venda.formPagID ";
        busca = busca + "LEFT JOIN cliente ON cliente.clienteID = venda.clienteID ";
        busca = busca + "WHERE venda.data BETWEEN '" + dataInicial + "' AND '" + dataFinal + " 23:59:59" + "' ";
        busca = busca + "AND venda.status = '2' AND venda.empresaID = '" + empresa.empresaID + "' ";
        busca = busca + "ORDER BY data DESC";
        return busca;
    }

    public String listaVendasRelatorio(String dataInicial, String dataFinal)
    {
        String busca = "SELECT formapagamento.formID, formapagamento.descricao, ";
        busca = busca + "cliente.clienteID, cliente.clienteNomeFantasia, ";
        busca = busca + "venda.* FROM venda ";
        busca = busca + "INNER JOIN formapagamento ON formapagamento.formID = venda.formPagID ";
        busca = busca + "LEFT JOIN cliente ON cliente.clienteID = venda.clienteID ";
        busca = busca + "WHERE venda.data BETWEEN '" + dataInicial + "' AND '" + dataFinal + " 23:59:59" + "' ";
        busca = busca + "AND venda.status = '2' ";
        busca = busca + "ORDER BY data ASC";
        return busca;
    }

    public String listaVendasRelatorioTotal(String dataInicial, String dataFinal)
    {
        String busca = "SELECT formapagamento.formID, formapagamento.descricao, ";
        busca = busca + "cliente.clienteID, cliente.clienteNomeFantasia, ";
        busca = busca + "venda.vendaID, venda.formPagID, venda.clienteID, SUM(valor) AS totalVenda FROM venda ";
        busca = busca + "INNER JOIN formapagamento ON formapagamento.formID = venda.formPagID ";
        busca = busca + "LEFT JOIN cliente ON cliente.clienteID = venda.clienteID ";
        busca = busca + "WHERE venda.data BETWEEN '" + dataInicial + "' AND '" + dataFinal + " 23:59:59" + "' ";
        busca = busca + "AND venda.status = '2' ";
        busca = busca + "ORDER BY data ASC";
        return busca;
    }

    public String listaVendasRelatorioPorFormaPagmento(String dataInicial, String dataFinal)
    {
        String busca = "SELECT formapagamento.formID, formapagamento.descricao, ";
        busca = busca + "cliente.clienteID, cliente.clienteNomeFantasia, ";
        busca = busca + "venda.* FROM venda ";
        busca = busca + "INNER JOIN formapagamento ON formapagamento.formID = venda.formPagID ";
        busca = busca + "LEFT JOIN cliente ON cliente.clienteID = venda.clienteID ";
        busca = busca + "WHERE venda.data BETWEEN '" + dataInicial + "' AND '" + dataFinal + " 23:59:59" + "' ";
        busca = busca + "AND venda.status = '2' AND venda.formPagID = '" + formPag.formPagID + "' ";
        busca = busca + "ORDER BY data ASC";
        return busca;
    }

    public String listaVendasRelatorioPorFormaPagmentoTotal(String dataInicial, String dataFinal)
    {
        String busca = "SELECT formapagamento.formID, formapagamento.descricao, ";
        busca = busca + "cliente.clienteID, cliente.clienteNomeFantasia, ";
        busca = busca + "venda.vendaID, venda.formPagID, venda.clienteID, SUM(valor) AS totalVenda FROM venda ";
        busca = busca + "INNER JOIN formapagamento ON formapagamento.formID = venda.formPagID ";
        busca = busca + "LEFT JOIN cliente ON cliente.clienteID = venda.clienteID ";
        busca = busca + "WHERE venda.data BETWEEN '" + dataInicial + "' AND '" + dataFinal + " 23:59:59" + "' ";
        busca = busca + "AND venda.status = '2' AND venda.formPagID = '" + formPag.formPagID + "' ";
        busca = busca + "ORDER BY data ASC";
        return busca;
    }

    public String dadosVenda()
    {
        return "SELECT * FROM venda WHERE vendaID = '" + vendaID + "'";
    }

    public String ultimaVendaPorUsuario()
    {
        return "SELECT * FROM venda WHERE usuario = '" + usuario.login + "' AND status = '2' ORDER BY vendaID DESC LIMIT 1";
    }

    public String ultimaVenda()
    {
        return "SELECT * FROM venda ORDER BY vendaID DESC LIMIT 1";
    }

    public String somaVendas(int vendaInicio, int vendaFim)
    {
        String vendas = "SELECT SUM(valor) as totalVendas ";
        vendas = vendas + "FROM venda ";
        vendas = vendas + "WHERE vendaID BETWEEN '" + vendaInicio + "' AND '" + vendaFim + "' ";
        vendas = vendas + "AND usuario = '" + usuario.login + "'";
        return vendas;
    }

    public String somaVendasDinheiro(int vendaInicio, int vendaFim)
    {
        String vendas = "SELECT SUM(valor) as totalVendas ";
        vendas = vendas + "FROM venda ";
        vendas = vendas + "WHERE vendaID BETWEEN '" + vendaInicio + "' AND '" + vendaFim + "' ";
        vendas = vendas + "AND usuario = '" + usuario.login + "' AND formPagID = '1'";
        return vendas;
    }

    public String somaVendaFormaPgto(int vendaInicio, int vendaFim)
    {
        String vendas = "SELECT formapagamento.formID, formapagamento.descricao, ";
        vendas = vendas + "SUM(venda.valor) as totalVendas, venda.formPagID ";
        vendas = vendas + "FROM venda ";
        vendas = vendas + "INNER JOIN formapagamento ON formapagamento.formID = venda.formPagID ";
        vendas = vendas + "WHERE venda.vendaID BETWEEN '" + vendaInicio + "' AND '" + vendaFim + "' ";
        vendas = vendas + "AND venda.usuario = '" + usuario.login + "' ";
        vendas = vendas + "GROUP BY venda.formPagID";
        return vendas;
    }

    public String cadastraVenda()
    {
        String insere = "INSERT INTO venda (clienteID, formPagID, vezes, valor, entrada, troco, desconto, notaFiscal, usuario, empresaID) ";
        insere = insere + "VALUES ('0', '0', '0', '0', '0', '0', '0', '0', '" + usuario.login + "', '" + empresa.empresaID + "')";
        return insere;
    }

    public String completaVenda()
    {
        String completa = "UPDATE venda ";
        completa = completa + "SET clienteID = '" + cliente.clienteID + "', formPagID = '" + formPag.formPagID + "', vezes = '" + vezes + "', ";
        completa = completa + "valor = '" + valor + "', entrada = '" + entrada + "', troco = '" + troco + "', desconto = '" + desconto + "', status = '2' ";
        completa = completa + "WHERE vendaID = '" + vendaID + "'";
        return completa;
    }

    public String finalizaVenda()
    {
        return "UPDATE venda SET status = '2' WHERE vendaID = '" + vendaID + "'";
    }

    public String cancelaVenda()
    {
        return "DELETE FROM venda WHERE vendaID = '" + vendaID + "'";
    }

    public int vendaID;
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
