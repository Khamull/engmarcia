// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ContasPagar.java

package financeiro;

import cadastro.Empresa;
import pdv.FormaPagamento;

public class ContasPagar
{

    public ContasPagar()
    {
        formPag = new FormaPagamento();
        empresa = new Empresa();
    }

    public String cadastraConta()
    {
        String cadastrar = "INSERT INTO contapagar ";
        cadastrar = cadastrar + "(formPagID, favorecido, valor, vezes, intervalo, data, usuario, empresaID) ";
        cadastrar = cadastrar + "VALUES ('" + formPag.formPagID + "', '" + favorecido + "', '" + valor + "', '" + vezes + "', '" + intervalo + "', '" + data + "', '" + usuario + "', '" + empresa.empresaID + "')";
        return cadastrar;
    }

    public String ultimaConta()
    {
        return "SELECT * FROM contapagar ORDER BY contapagarID DESC LIMIT 1";
    }

    public String contaPorId()
    {
        return "SELECT * FROM contapagar WHERE contapagarID = '" + contaID + "'";
    }

    public String detalhePagamento()
    {
        String pesquisa = "SELECT formapagamento.formID, formapagamento.descricao, ";
        pesquisa = pesquisa + "contapagar.contapagarID, contapagar.favorecido, contapagar.valor as total, ";
        pesquisa = pesquisa + "lancamentos.valor as pago, lancamentos.desconto, lancamentos.acrescimo, lancamentos.observacao, ";
        pesquisa = pesquisa + "pagar.*";
        pesquisa = pesquisa + "FROM pagar ";
        pesquisa = pesquisa + "INNER JOIN lancamentos ON lancamentos.pagarID = pagar.pagarID ";
        pesquisa = pesquisa + "INNER JOIN formapagamento ON formapagamento.formID = pagar.formID ";
        pesquisa = pesquisa + "INNER JOIN contapagar ON contapagar.contapagarID = pagar.contapagarID ";
        pesquisa = pesquisa + "WHERE contapagar.contapagarID = '" + contaID + "' ";
        return pesquisa;
    }

    public int contaID;
    public FormaPagamento formPag;
    public String favorecido;
    public float valor;
    public int vezes;
    public int intervalo;
    public String data;
    public String usuario;
    public Empresa empresa;
}
