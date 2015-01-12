// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Lancamentos.java

package financeiro;

import cadastro.Empresa;
import cadastro.Usuario;
import pdv.FormaPagamento;
import pdv.Venda;

// Referenced classes of package financeiro:
//            Receber, Pagar, Transferencias, ContasPagar, 
//            LivroCaixa

public class Lancamentos
{

    public Lancamentos()
    {
        receber = new Receber();
        pagar = new Pagar();
        venda = new Venda();
        transferencia = new Transferencias();
        contaPagar = new ContasPagar();
        livro = new LivroCaixa();
        formaPag = new FormaPagamento();
        usuario = new Usuario();
        empresa = new Empresa();
    }

    public String insereEntrada()
    {
        String salvaValor = "INSERT INTO lancamentos ";
        salvaValor = salvaValor + "(receberID, vendaID, livroID, formID, valor, tipo, usuario, empresaID) ";
        salvaValor = salvaValor + "VALUES ('" + receber.receberID + "', '" + venda.vendaID + "', '1', '1', '" + valor + "', 'R', '" + usuario.login + "', '" + empresa.empresaID + "')";
        return salvaValor;
    }

    public String insereEntradaServico()
    {
        String salvaValor = "INSERT INTO lancamentos ";
        salvaValor = salvaValor + "(receberID, vendaID, livroID, formID, valor, tipo, usuario, empresaID) ";
        salvaValor = salvaValor + "VALUES ('" + receber.receberID + "', '" + venda.vendaID + "', '1', '1', '" + valor + "', 'S', '" + usuario.login + "', '" + empresa.empresaID + "')";
        return salvaValor;
    }

    public String insereEntradaServicoObs()
    {
        String salvaValor = "INSERT INTO lancamentos ";
        salvaValor = salvaValor + "(receberID, vendaID, livroID, formID, valor, observacao, tipo, usuario, empresaID) ";
        salvaValor = salvaValor + "VALUES ('" + receber.receberID + "', '" + venda.vendaID + "', '1', '1', '" + valor + "', '" + observacao + "', 'S', ";
        salvaValor = salvaValor + "'" + usuario.login + "', '" + empresa.empresaID + "')";
        return salvaValor;
    }

    public String pagaContaReceber()
    {
        String salvaValor = "INSERT INTO lancamentos ";
        salvaValor = salvaValor + "(receberID, vendaID, livroID, formID, valor, desconto, acrescimo, observacao, tipo, usuario, empresaID) ";
        salvaValor = salvaValor + "VALUES ('" + receber.receberID + "', '" + venda.vendaID + "', '" + livro.livroID + "', '" + formaPag.formPagID + "', ";
        salvaValor = salvaValor + "'" + valor + "', '" + desconto + "', '" + acrescimo + "', '" + observacao + "', 'R', '" + usuario.login + "', '" + empresa.empresaID + "')";
        return salvaValor;
    }

    public String pagaContaReceberServico()
    {
        String salvaValor = "INSERT INTO lancamentos ";
        salvaValor = salvaValor + "(receberID, vendaID, livroID, formID, valor, desconto, acrescimo, observacao, tipo, usuario, empresaID) ";
        salvaValor = salvaValor + "VALUES ('" + receber.receberID + "', '" + venda.vendaID + "', '" + livro.livroID + "', '" + formaPag.formPagID + "', ";
        salvaValor = salvaValor + "'" + valor + "', '" + desconto + "', '" + acrescimo + "', '" + observacao + "', 'S', '" + usuario.login + "', '" + empresa.empresaID + "')";
        return salvaValor;
    }

    public String pagaContaPagar()
    {
        String salvaValor = "INSERT INTO lancamentos ";
        salvaValor = salvaValor + "(pagarID, contaPagarID, livroID, formID, valor, desconto, acrescimo, favorecido, observacao, tipo, usuario, empresaID) ";
        salvaValor = salvaValor + "VALUES ('" + pagar.pagarID + "', '" + contaPagar.contaID + "', '" + livro.livroID + "', '" + formaPag.formPagID + "', '" + valor + "', ";
        salvaValor = salvaValor + "'" + desconto + "', '" + acrescimo + "', '" + favorecido + "', '" + observacao + "', 'P', '" + usuario.login + "', '" + empresa.empresaID + "')";
        return salvaValor;
    }

    public String transfere()
    {
        String transf = "INSERT INTO lancamentos (transferenciaID, livroID, valor, formID, tipo, usuario, empresaID) ";
        transf = transf + "VALUES ('" + transferencia.transferenciaID + "', '" + livro.livroID + "', '" + valor + "', '1', 'T', '" + usuario.login + "', '" + empresa.empresaID + "')";
        return transf;
    }

    public String deposito()
    {
        String transf = "INSERT INTO lancamentos (transferenciaID, livroID, valor, formID, tipo, usuario, empresaID) ";
        transf = transf + "VALUES ('" + transferencia.transferenciaID + "', '" + livro.livroID + "', '" + valor + "', '1', 'D', '" + usuario.login + "', '" + empresa.empresaID + "')";
        return transf;
    }

    public String chequeVoltou()
    {
        String cheque = "INSERT INTO lancamentos (receberID, vendaID, livroID, formID, valor, observacao, tipo, usuario, empresaID) ";
        cheque = cheque + "VALUES ('" + receber.receberID + "', '" + venda.vendaID + "', '" + livro.livroID + "', '" + formaPag.formPagID + "', '" + valor + "', ";
        cheque = cheque + "'" + observacao + "', 'C', '" + usuario.login + "', '" + empresa.empresaID + "')";
        return cheque;
    }

    public String listaRecebimentos(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, lancamentos.* FROM lancamentos ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = lancamentos.formID ";
        pesquisa = pesquisa + "WHERE lancamentos.livroID = '" + livro.livroID + "' ";
        pesquisa = pesquisa + "AND lancamentos.data BETWEEN '" + dataInicio + "' AND '" + dataFim + " 23:59:59" + "'";
        return pesquisa;
    }

    public String listaRecebimentosPorEmpresa(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, lancamentos.* FROM lancamentos ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = lancamentos.formID ";
        pesquisa = pesquisa + "WHERE lancamentos.livroID = '" + livro.livroID + "' AND lancamentos.empresaID = '" + empresa.empresaID + "' ";
        pesquisa = pesquisa + "AND lancamentos.data BETWEEN '" + dataInicio + "' AND '" + dataFim + " 23:59:59" + "'";
        return pesquisa;
    }

    public String dividasQuitadasTotal(String dataBusca, String clienteID)
    {
        String pesquisa = "SELECT venda.vendaID, venda.clienteID, cliente.clienteID, cliente.clienteNomeFantasia, lancamentos.vendaID, lancamentos.valor, SUM(lancamentos.valor) as total, lancamentos.formID ";
        pesquisa = pesquisa + "FROM lancamentos INNER JOIN venda ON venda.vendaID = lancamentos.vendaID ";
        pesquisa = pesquisa + "INNER JOIN cliente ON cliente.clienteID = venda.clienteID ";
        pesquisa = pesquisa + "WHERE lancamentos.data LIKE '" + dataBusca + "%' AND formID = '7' AND venda.clienteID = '" + clienteID + "'";
        return pesquisa;
    }

    public String dividasQuitadas(String dataBusca, String clienteID)
    {
        String pesquisa = "SELECT venda.vendaID, venda.clienteID, venda.data AS dataVenda, cliente.clienteID, cliente.clienteNomeFantasia, lancamentos.* ";
        pesquisa = pesquisa + "FROM lancamentos INNER JOIN venda ON venda.vendaID = lancamentos.vendaID ";
        pesquisa = pesquisa + "INNER JOIN cliente ON cliente.clienteID = venda.clienteID ";
        pesquisa = pesquisa + "WHERE lancamentos.data LIKE '" + dataBusca + "%' AND formID = '7' AND venda.clienteID = '" + clienteID + "'";
        return pesquisa;
    }

    public String ultimoLancamento()
    {
        return "SELECT * FROM lancamentos ORDER BY lancamentoID DESC LIMIT 1";
    }

    public String somaLancamentos(int lancamentoInicio, int lancamentoFim)
    {
        String soma = "SELECT SUM(valor) as totalLancamentos FROM lancamentos ";
        soma = soma + "WHERE lancamentoID BETWEEN '" + lancamentoInicio + "' AND '" + lancamentoFim + "' ";
        soma = soma + "AND formID = '7' AND livroID = '1' AND tipo = 'R' AND usuario = '" + usuario.login + "' ";
        soma = soma + "OR formID = '6' AND livroID = '1' AND tipo = 'R' AND usuario = '" + usuario.login + "' ";
        soma = soma + "OR formID = '5' AND livroID = '1' AND tipo = 'R' AND usuario = '" + usuario.login + "' ";
        soma = soma + "OR formID = '4' AND livroID = '1' AND tipo = 'R' AND usuario = '" + usuario.login + "'";
        return soma;
    }

    public String somaLancamentosCheque(int lancamentoInicio, int lancamentoFim)
    {
        String soma = "SELECT receber.receberID, receber.formID, receber.status, ";
        soma = soma + "SUM(lancamentos.valor) as totalLancamentos, lancamentos.receberID ";
        soma = soma + "FROM lancamentos ";
        soma = soma + "INNER JOIN receber ON receber.receberID = lancamentos.receberID ";
        soma = soma + "WHERE lancamentos.formID = '7' AND receber.formID = '4' ";
        soma = soma + "AND lancamentos.lancamentoID BETWEEN '" + lancamentoInicio + "' AND '" + lancamentoFim + "' ";
        soma = soma + "AND lancamentos.usuario = '" + usuario.login + "'";
        return soma;
    }

    public String contasRecebidas()
    {
        String busca = "SELECT livrocaixa.livroID, livrocaixa.banco, lancamentos.* ";
        busca = busca + "FROM lancamentos ";
        busca = busca + "INNER JOIN livrocaixa ON livrocaixa.livroID = lancamentos.livroID ";
        busca = busca + "WHERE receberID = '" + receber.receberID + "'";
        return busca;
    }

    public String contasPagas()
    {
        String busca = "SELECT livrocaixa.livroID, livrocaixa.banco, lancamentos.* ";
        busca = busca + "FROM lancamentos ";
        busca = busca + "INNER JOIN livrocaixa ON livrocaixa.livroID = lancamentos.livroID ";
        busca = busca + "WHERE pagarID = '" + pagar.pagarID + "'";
        return busca;
    }

    public int lancamentoID;
    public Receber receber;
    public Pagar pagar;
    public Venda venda;
    public Transferencias transferencia;
    public ContasPagar contaPagar;
    public LivroCaixa livro;
    public FormaPagamento formaPag;
    public float valor;
    public float desconto;
    public float acrescimo;
    public String favorecido;
    public String observacao;
    public String tipo;
    public Usuario usuario;
    public Empresa empresa;
}
