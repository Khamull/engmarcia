// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Receber.java

package financeiro;

import cadastro.Cliente;
import cadastro.Empresa;
import pdv.FormaPagamento;
import pdv.Venda;
import servico.Servico;

public class Receber
{

    public Receber()
    {
        venda = new Venda();
        servico = new Servico();
        cliente = new Cliente();
        forma = new FormaPagamento();
        empresa = new Empresa();
    }

    public String salvarReceber()
    {
        String salvaReceber = "INSERT INTO receber (vendaID, formID, clienteID, valor, vencimento, parcela, de, status, servico, empresaID) ";
        salvaReceber = salvaReceber + "VALUES ('" + venda.vendaID + "', '" + forma.formPagID + "', '" + cliente.clienteID + "', '" + valor + "', '" + vencimento + "', ";
        salvaReceber = salvaReceber + "'" + parcela + "', '" + de + "', 'D', 'N', '" + empresa.empresaID + "')";
        return salvaReceber;
    }

    public String salvarReceberServico()
    {
        String salvaReceber = "INSERT INTO receber (vendaID, formID, clienteID, valor, vencimento, parcela, de, status, servico, empresaID) ";
        salvaReceber = salvaReceber + "VALUES ('" + servico.servicoID + "', '" + forma.formPagID + "', '" + cliente.clienteID + "', '" + valor + "', '" + vencimento + "', ";
        salvaReceber = salvaReceber + "'" + parcela + "', '" + de + "', 'D', 'S', '" + empresa.empresaID + "')";
        return salvaReceber;
    }

    public String cadastraEntrada(float entrada)
    {
        String salvaReceber = "INSERT INTO receber (vendaID, formID, clienteID, valor, vencimento, parcela, de, status, servico, empresaID) ";
        salvaReceber = salvaReceber + "VALUES ('" + venda.vendaID + "', '" + forma.formPagID + "', '" + cliente.clienteID + "', '" + entrada + "', '" + vencimento + "', ";
        salvaReceber = salvaReceber + "'1', '1', 'P', 'N', '" + empresa.empresaID + "')";
        return salvaReceber;
    }

    public String cadastraEntradaServico(float entrada)
    {
        String salvaReceber = "INSERT INTO receber (vendaID, formID, clienteID, valor, vencimento, parcela, de, status, servico, empresaID) ";
        salvaReceber = salvaReceber + "VALUES ('" + servico.servicoID + "', '" + forma.formPagID + "', '" + cliente.clienteID + "', '" + entrada + "', '" + vencimento + "', ";
        salvaReceber = salvaReceber + "'1', '1', 'P', 'S', '" + empresa.empresaID + "')";
        return salvaReceber;
    }

    public String ultimoReceberID()
    {
        return "SELECT receberID FROM receber WHERE vendaID = '" + venda.vendaID + "' ORDER BY receberID DESC LIMIT 1";
    }

    public String ultimoReceberIDServico()
    {
        return "SELECT receberID FROM receber WHERE vendaID = '" + servico.servicoID + "' ORDER BY receberID DESC LIMIT 1";
    }

    public String receberPorID()
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "receber.*";
        pesquisa = pesquisa + "FROM receber ";
        pesquisa = pesquisa + "LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = receber.formID ";
        pesquisa = pesquisa + "WHERE receberID = '" + receberID + "'";
        return pesquisa;
    }

    public String pesquisaConta(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "receber.*";
        pesquisa = pesquisa + "FROM receber ";
        pesquisa = pesquisa + "LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = receber.formID ";
        pesquisa = pesquisa + "WHERE status = 'D' ";
        pesquisa = pesquisa + "AND receber.vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        pesquisa = pesquisa + "ORDER BY receber.vencimento ASC, receber.receberID  ASC";
        return pesquisa;
    }

    public String pesquisaContaFC(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "receber.*";
        pesquisa = pesquisa + "FROM receber ";
        pesquisa = pesquisa + "LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = receber.formID ";
        pesquisa = pesquisa + "WHERE status = 'D' ";
        pesquisa = pesquisa + "AND receber.formID = '" + forma.formPagID + "' ";
        pesquisa = pesquisa + "AND receber.clienteID = '" + cliente.clienteID + "' ";
        pesquisa = pesquisa + "AND receber.vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        pesquisa = pesquisa + "ORDER BY receber.vencimento ASC, receber.receberID  ASC";
        return pesquisa;
    }

    public String pesquisaContaC(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "receber.*";
        pesquisa = pesquisa + "FROM receber ";
        pesquisa = pesquisa + "LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = receber.formID ";
        pesquisa = pesquisa + "WHERE status = 'D' ";
        pesquisa = pesquisa + "AND receber.clienteID = '" + cliente.clienteID + "' ";
        pesquisa = pesquisa + "AND receber.vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        pesquisa = pesquisa + "ORDER BY receber.vencimento ASC, receber.receberID  ASC";
        return pesquisa;
    }

    public String pesquisaContaF(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "receber.*";
        pesquisa = pesquisa + "FROM receber ";
        pesquisa = pesquisa + "LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = receber.formID ";
        pesquisa = pesquisa + "WHERE status = 'D' ";
        pesquisa = pesquisa + "AND receber.formID = '" + forma.formPagID + "' ";
        pesquisa = pesquisa + "AND receber.vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        pesquisa = pesquisa + "ORDER BY receber.vencimento ASC, receber.receberID  ASC";
        return pesquisa;
    }

    public String contaRecebida(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "receber.*";
        pesquisa = pesquisa + "FROM receber ";
        pesquisa = pesquisa + "LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = receber.formID ";
        pesquisa = pesquisa + "WHERE status = 'P' ";
        pesquisa = pesquisa + "AND receber.vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        pesquisa = pesquisa + "ORDER BY receber.vencimento ASC, receber.receberID  ASC";
        return pesquisa;
    }

    public String contaRecebidaFC(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "receber.*";
        pesquisa = pesquisa + "FROM receber ";
        pesquisa = pesquisa + "LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = receber.formID ";
        pesquisa = pesquisa + "WHERE status = 'P' ";
        pesquisa = pesquisa + "AND receber.formID = '" + forma.formPagID + "' ";
        pesquisa = pesquisa + "AND receber.clienteID = '" + cliente.clienteID + "' ";
        pesquisa = pesquisa + "AND receber.vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        pesquisa = pesquisa + "ORDER BY receber.vencimento ASC, receber.receberID  ASC";
        return pesquisa;
    }

    public String contaRecebidaC(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "receber.*";
        pesquisa = pesquisa + "FROM receber ";
        pesquisa = pesquisa + "LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = receber.formID ";
        pesquisa = pesquisa + "WHERE status = 'P' ";
        pesquisa = pesquisa + "AND receber.clienteID = '" + cliente.clienteID + "' ";
        pesquisa = pesquisa + "AND receber.vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        pesquisa = pesquisa + "ORDER BY receber.vencimento ASC, receber.receberID  ASC";
        return pesquisa;
    }

    public String contaRecebidaF(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "receber.*";
        pesquisa = pesquisa + "FROM receber ";
        pesquisa = pesquisa + "LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = receber.formID ";
        pesquisa = pesquisa + "WHERE status = 'P' ";
        pesquisa = pesquisa + "AND receber.formID = '" + forma.formPagID + "' ";
        pesquisa = pesquisa + "AND receber.vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        pesquisa = pesquisa + "ORDER BY receber.vencimento ASC, receber.receberID  ASC";
        return pesquisa;
    }

    public String detalheReceber()
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "lancamentos.receberID, lancamentos.valor AS recebido, lancamentos.desconto, lancamentos.acrescimo, lancamentos.observacao, ";
        pesquisa = pesquisa + "venda.vendaID , venda.valor AS total, venda.data, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "receber.*";
        pesquisa = pesquisa + "FROM receber ";
        pesquisa = pesquisa + "INNER JOIN venda ON venda.vendaID = receber.vendaID ";
        pesquisa = pesquisa + "INNER JOIN lancamentos ON lancamentos.receberID = receber.receberID ";
        pesquisa = pesquisa + "LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = receber.formID ";
        pesquisa = pesquisa + "WHERE receber.receberID = '" + receberID + "'";
        return pesquisa;
    }

    public String detalheReceberServico()
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "lancamentos.receberID, lancamentos.valor AS recebido, lancamentos.desconto, lancamentos.acrescimo, lancamentos.observacao, ";
        pesquisa = pesquisa + "servico.servicoID , servico.valor AS total, servico.dataFim, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "receber.*";
        pesquisa = pesquisa + "FROM receber ";
        pesquisa = pesquisa + "INNER JOIN servico ON servico.servicoID = receber.vendaID ";
        pesquisa = pesquisa + "INNER JOIN lancamentos ON lancamentos.receberID = receber.receberID ";
        pesquisa = pesquisa + "LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = receber.formID ";
        pesquisa = pesquisa + "WHERE receber.receberID = '" + receberID + "'";
        return pesquisa;
    }

    public String detalheReceberChequeVoltou()
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "lancamentos.receberID, lancamentos.valor AS recebido, lancamentos.desconto, lancamentos.acrescimo, lancamentos.observacao, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "cheques.receberID, cheques.numeroCheque, cheques.valorCheque as valor, cheques.observacoes, ";
        pesquisa = pesquisa + "receber.valor as total, receber.vencimento, receber.parcela, receber.de ";
        pesquisa = pesquisa + "FROM lancamentos ";
        pesquisa = pesquisa + "INNER JOIN cheques ON cheques.receberID = lancamentos.receberID ";
        pesquisa = pesquisa + "INNER JOIN cliente ON cliente.clienteID = cheques.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = lancamentos.formID ";
        pesquisa = pesquisa + "INNER JOIN receber ON cheques.receberID = receber.receberID ";
        pesquisa = pesquisa + "WHERE lancamentos.receberID = '" + receberID + "' AND lancamentos.tipo = 'C'";
        return pesquisa;
    }

    public String detalheReceberCheque()
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "lancamentos.receberID, lancamentos.valor AS recebido, lancamentos.desconto, lancamentos.acrescimo, lancamentos.observacao, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "cheques.receberID, cheques.numeroCheque, cheques.valorCheque as valor, cheques.observacoes, ";
        pesquisa = pesquisa + "receber.valor as total, receber.vencimento, receber.parcela, receber.de ";
        pesquisa = pesquisa + "FROM lancamentos ";
        pesquisa = pesquisa + "INNER JOIN cheques ON cheques.receberID = lancamentos.receberID ";
        pesquisa = pesquisa + "INNER JOIN cliente ON cliente.clienteID = cheques.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = lancamentos.formID ";
        pesquisa = pesquisa + "INNER JOIN receber ON cheques.receberID = receber.receberID ";
        pesquisa = pesquisa + "WHERE lancamentos.receberID = '" + receberID + "' AND lancamentos.tipo = 'R'";
        return pesquisa;
    }

    public String pesquisaContaCliente()
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "receber.*";
        pesquisa = pesquisa + "FROM receber ";
        pesquisa = pesquisa + "LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = receber.formID ";
        pesquisa = pesquisa + "WHERE receber.status = 'D' AND receber.formID = '7' AND receber.clienteID = '" + cliente.clienteID + "'";
        pesquisa = pesquisa + "ORDER BY receber.vencimento ASC";
        return pesquisa;
    }

    public String totalReceber(String dataInicio, String dataFim)
    {
        String total = "SELECT SUM(valor) as faltaPagar FROM receber ";
        total = total + "WHERE status = 'D' AND vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "'";
        return total;
    }

    public String totalReceberVale()
    {
        String total = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, SUM(valor) as faltaPagar ";
        total = total + "FROM receber INNER JOIN cliente ON cliente.clienteID = receber.clienteID ";
        total = total + "WHERE receber.status = 'D' AND receber.formID = '7' AND receber.clienteID = '" + cliente.clienteID + "'";
        return total;
    }

    public String pesquisaContaPorEmpresa(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, ";
        pesquisa = pesquisa + "formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "receber.*";
        pesquisa = pesquisa + "FROM receber ";
        pesquisa = pesquisa + "LEFT JOIN cliente ON cliente.clienteID = receber.clienteID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = receber.formID ";
        pesquisa = pesquisa + "WHERE status = 'D' ";
        pesquisa = pesquisa + "AND receber.vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        pesquisa = pesquisa + "AND receber.empresaID = '" + empresa.empresaID + "'";
        pesquisa = pesquisa + "ORDER BY receber.vencimento ASC, receber.receberID  ASC";
        return pesquisa;
    }

    public String totalReceberPorEmpresa(String dataInicio, String dataFim)
    {
        String total = "SELECT SUM(valor) as faltaPagar FROM receber ";
        total = total + "WHERE status = 'D' AND vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' AND empresaID = '" + empresa.empresaID + "'";
        return total;
    }

    public String contaReceberPorVendaID()
    {
        String pesquisa = "SELECT * FROM receber ";
        pesquisa = pesquisa + "WHERE vendaID = '" + venda.vendaID + "' AND SUBSTRING(dataInclusao,1,10) = '" + dataInclusao + "' AND status = 'D'";
        return pesquisa;
    }

    public String alteraReceber()
    {
        return "UPDATE receber SET valor = '" + valor + "', vencimento = '" + vencimento + "' WHERE receberID = '" + receberID + "'";
    }

    public String alteraStatus()
    {
        return "UPDATE receber SET status = 'P' WHERE receberID = '" + receberID + "'";
    }

    public String alteraFormaPgto()
    {
        return "UPDATE receber SET formID = '" + forma.formPagID + "' WHERE receberID = '" + receberID + "'";
    }

    public String excluiContaReceber()
    {
        return "DELETE FROM receber WHERE receberID = '" + receberID + "'";
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Valor Recebido com Sucesso!";

        case 2: // '\002'
            return "Conta a Receber Alterada com Sucesso!";

        case 3: // '\003'
            return "Conta a Receber Excluida com Sucesso!";

        case 4: // '\004'
            return "";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int receberID;
    public Venda venda;
    public Servico servico;
    public Cliente cliente;
    public FormaPagamento forma;
    public float valor;
    public String vencimento;
    public int parcela;
    public int de;
    public String status;
    public String tipoServico;
    public Empresa empresa;
    public String dataInclusao;
}
