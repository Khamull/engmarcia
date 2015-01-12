// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pagar.java

package financeiro;

import cadastro.Empresa;
import pdv.FormaPagamento;

// Referenced classes of package financeiro:
//            ContasPagar

public class Pagar
{

    public Pagar()
    {
        conta = new ContasPagar();
        forma = new FormaPagamento();
        empresa = new Empresa();
    }

    public String cadastraPagar()
    {
        String inserePagar = "INSERT INTO pagar ";
        inserePagar = inserePagar + "(contapagarID, formID, valor, vencimento, parcela, de, status, empresaID) ";
        inserePagar = inserePagar + "VALUES ('" + conta.contaID + "', '" + forma.formPagID + "', '" + valor + "', '" + vencimento + "', '" + parcela + "', '" + de + "', '" + status + "', '" + empresa.empresaID + "')";
        return inserePagar;
    }

    public String pesquisaConta(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "contapagar.contapagarID, contapagar.favorecido, ";
        pesquisa = pesquisa + "pagar.*";
        pesquisa = pesquisa + "FROM pagar ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ";
        pesquisa = pesquisa + "INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ";
        pesquisa = pesquisa + "WHERE status = 'D' ";
        pesquisa = pesquisa + "AND pagar.vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        pesquisa = pesquisa + "ORDER BY pagar.vencimento ASC, pagar.pagarID  ASC";
        return pesquisa;
    }

    public String pesquisaContaPorForma(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "contapagar.contapagarID, contapagar.favorecido, ";
        pesquisa = pesquisa + "pagar.*";
        pesquisa = pesquisa + "FROM pagar ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ";
        pesquisa = pesquisa + "INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ";
        pesquisa = pesquisa + "WHERE status = 'D' ";
        pesquisa = pesquisa + "AND pagar.formID = '" + forma.formPagID + "' ";
        pesquisa = pesquisa + "AND pagar.vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        pesquisa = pesquisa + "ORDER BY pagar.vencimento ASC, pagar.pagarID  ASC";
        return pesquisa;
    }

    public String contaPaga(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "contapagar.contapagarID, contapagar.favorecido, ";
        pesquisa = pesquisa + "pagar.*";
        pesquisa = pesquisa + "FROM pagar ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ";
        pesquisa = pesquisa + "INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ";
        pesquisa = pesquisa + "WHERE status = 'P' ";
        pesquisa = pesquisa + "AND pagar.vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        pesquisa = pesquisa + "ORDER BY pagar.vencimento ASC, pagar.pagarID  ASC";
        return pesquisa;
    }

    public String contaPagasPorForma(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "contapagar.contapagarID, contapagar.favorecido, ";
        pesquisa = pesquisa + "pagar.*";
        pesquisa = pesquisa + "FROM pagar ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ";
        pesquisa = pesquisa + "INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ";
        pesquisa = pesquisa + "WHERE status = 'P' ";
        pesquisa = pesquisa + "AND pagar.formID = '" + forma.formPagID + "' ";
        pesquisa = pesquisa + "AND pagar.vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        pesquisa = pesquisa + "ORDER BY pagar.vencimento ASC, pagar.pagarID  ASC";
        return pesquisa;
    }

    public String pagarPorID()
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "contapagar.contapagarID, contapagar.favorecido, ";
        pesquisa = pesquisa + "pagar.*";
        pesquisa = pesquisa + "FROM pagar ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ";
        pesquisa = pesquisa + "INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ";
        pesquisa = pesquisa + "WHERE pagarID = '" + pagarID + "'";
        return pesquisa;
    }

    public String detalhePagamento()
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "contapagar.contapagarID, contapagar.favorecido, contapagar.valor as total, ";
        pesquisa = pesquisa + "lancamentos.valor as pago, lancamentos.desconto, lancamentos.acrescimo, lancamentos.observacao, lancamentos.data, ";
        pesquisa = pesquisa + "pagar.*";
        pesquisa = pesquisa + "FROM pagar ";
        pesquisa = pesquisa + "INNER JOIN lancamentos ON lancamentos.pagarID = pagar.pagarID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ";
        pesquisa = pesquisa + "INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ";
        pesquisa = pesquisa + "WHERE pagar.pagarID = '" + pagarID + "' ";
        return pesquisa;
    }

    public String totalPagar(String dataInicio, String dataFim)
    {
        String total = "SELECT SUM(valor) as faltaPagar FROM pagar ";
        total = total + "WHERE status = 'D' AND vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "'";
        return total;
    }

    public String pesquisaContaPorEmpresa(String dataInicio, String dataFim)
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "contapagar.contapagarID, contapagar.favorecido, ";
        pesquisa = pesquisa + "pagar.*";
        pesquisa = pesquisa + "FROM pagar ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ";
        pesquisa = pesquisa + "INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ";
        pesquisa = pesquisa + "WHERE status = 'D' ";
        pesquisa = pesquisa + "AND pagar.vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        pesquisa = pesquisa + "AND pagar.empresaID = '" + empresa.empresaID + "'";
        pesquisa = pesquisa + "ORDER BY pagar.vencimento ASC, pagar.pagarID  ASC";
        return pesquisa;
    }

    public String totalPagarPorEmpresa(String dataInicio, String dataFim)
    {
        String total = "SELECT SUM(valor) as faltaPagar FROM pagar ";
        total = total + "WHERE status = 'D' AND vencimento BETWEEN '" + dataInicio + "' AND '" + dataFim + "' AND empresaID = '" + empresa.empresaID + "'";
        return total;
    }

    public String alteraPagar()
    {
        return "UPDATE pagar SET valor = '" + valor + "', vencimento = '" + vencimento + "' WHERE pagarID = '" + pagarID + "'";
    }

    public String alteraStatus()
    {
        return "UPDATE pagar SET status = 'P' WHERE pagarID = '" + pagarID + "'";
    }

    public String excluiPagar()
    {
        return "DELETE FROM pagar WHERE pagarID = '" + pagarID + "'";
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Valor Pago com Sucesso!";

        case 2: // '\002'
            return "Conta a Pagar Alterada com Sucesso!";

        case 3: // '\003'
            return "Conta Cadastrada com Sucesso!";

        case 4: // '\004'
            return "Conta a Pagar Excluida com Sucesso!";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int pagarID;
    public ContasPagar conta;
    public FormaPagamento forma;
    public float valor;
    public String vencimento;
    public int parcela;
    public int de;
    public String status;
    public Empresa empresa;
}
