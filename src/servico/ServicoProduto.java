// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ServicoProduto.java

package servico;

import cadastro.Produto;

// Referenced classes of package servico:
//            Servico

public class ServicoProduto
{

    public ServicoProduto()
    {
        servico = new Servico();
        produto = new Produto();
    }

    public String listaProdutos()
    {
        String pesquisaProd = "SELECT produto.produtoID, produto.nome, servicoproduto.* ";
        pesquisaProd = pesquisaProd + "FROM servicoproduto INNER JOIN produto ON produto.produtoID = servicoproduto.produtoID ";
        pesquisaProd = pesquisaProd + "WHERE servicoproduto.servicoID = '" + servico.servicoID + "'";
        return pesquisaProd;
    }

    public String listaProdutosCupom()
    {
        String pesquisaProd = "SELECT produto.produtoID, produto.nome, produto.codigo, produto.tipoprodutoID, produto.unidade, ";
        pesquisaProd = pesquisaProd + "tipoproduto.tipoprodutoID, tipoproduto.tipo, ";
        pesquisaProd = pesquisaProd + "servicoproduto.* ";
        pesquisaProd = pesquisaProd + "FROM servicoproduto INNER JOIN produto ON produto.produtoID = servicoproduto.produtoID ";
        pesquisaProd = pesquisaProd + "INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ";
        pesquisaProd = pesquisaProd + "WHERE servicoproduto.servicoID = '" + servico.servicoID + "'";
        return pesquisaProd;
    }

    public String pequisaProduto()
    {
        return "SELECT * FROM servicoproduto WHERE servicoprodutoID = '" + servicoProdutoID + "'";
    }

    public String salvaProduto()
    {
        String salvaProd = "INSERT INTO servicoproduto (servicoID, produtoID, valor) VALUES ";
        salvaProd = salvaProd + "('" + servico.servicoID + "', '" + produto.produtoID + "', '" + valor + "')";
        return salvaProd;
    }

    public String excluiProduto()
    {
        return "DELETE FROM servicoproduto WHERE servicoprodutoID = '" + servicoProdutoID + "'";
    }

    public int servicoProdutoID;
    public Servico servico;
    public Produto produto;
    public float valor;
}
