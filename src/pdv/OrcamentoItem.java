// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   OrcamentoItem.java

package pdv;

import cadastro.Produto;

// Referenced classes of package pdv:
//            Orcamento

public class OrcamentoItem
{

    public OrcamentoItem()
    {
        orcamento = new Orcamento();
        produto = new Produto();
    }

    public String pesquisItem()
    {
        return "SELECT * FROM orcamentoitem WHERE itemID = '" + itemID + "'";
    }

    public String listaItensPorID()
    {
        String pesquisaItem = "SELECT produto.produtoID, produto.tipoprodutoID, produto.codigo, produto.nome, produto.unidade, ";
        pesquisaItem = pesquisaItem + "tipoproduto.tipoprodutoID, tipoproduto.tipo, ";
        pesquisaItem = pesquisaItem + "orcamentoitem.* ";
        pesquisaItem = pesquisaItem + "FROM orcamentoitem ";
        pesquisaItem = pesquisaItem + "INNER JOIN produto ON produto.produtoID = orcamentoitem.produtoID ";
        pesquisaItem = pesquisaItem + "INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ";
        pesquisaItem = pesquisaItem + "WHERE orcamentoitem.orcamentoID = '" + orcamento.orcamentoID + "' ";
        pesquisaItem = pesquisaItem + "ORDER BY orcamentoitem.itemID DESC";
        return pesquisaItem;
    }

    public String salvaItem()
    {
        String salvaItem = "INSERT INTO orcamentoitem ";
        salvaItem = salvaItem + "(orcamentoID, produtoID, quantidade, valor, total) ";
        salvaItem = salvaItem + "VALUES ";
        salvaItem = salvaItem + "('" + orcamento.orcamentoID + "', '" + produto.produtoID + "', '" + quantidade + "', '" + produto.preco + "', '" + total + "')";
        return salvaItem;
    }

    public String excluiItem()
    {
        return "DELETE FROM orcamentoitem WHERE itemID = '" + itemID + "'";
    }

    public String removeItens()
    {
        return "DELETE FROM orcamentoitem WHERE orcamentoID = '" + orcamento.orcamentoID + "'";
    }

    public String totalItem()
    {
        return "SELECT SUM(total) as subtotal FROM orcamentoitem WHERE orcamentoID = '" + orcamento.orcamentoID + "'";
    }

    public int itemID;
    public Orcamento orcamento;
    public Produto produto;
    public float quantidade;
    public float total;
}
