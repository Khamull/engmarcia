// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VendaItem.java

package pdv;

import cadastro.Produto;

// Referenced classes of package pdv:
//            Venda

public class VendaItem
{

    public VendaItem()
    {
        venda = new Venda();
        produto = new Produto();
    }

    public String pesquisItem()
    {
        return "SELECT * FROM vendaitem WHERE itemID = '" + itemID + "'";
    }

    public String listaItensPorID()
    {
        String pesquisaItem = "SELECT produto.produtoID, produto.tipoprodutoID, produto.codigo, produto.nome, produto.unidade, ";
        pesquisaItem = pesquisaItem + "tipoproduto.tipoprodutoID, tipoproduto.tipo, ";
        pesquisaItem = pesquisaItem + "vendaitem.* ";
        pesquisaItem = pesquisaItem + "FROM vendaitem ";
        pesquisaItem = pesquisaItem + "INNER JOIN produto ON produto.produtoID = vendaitem.produtoID ";
        pesquisaItem = pesquisaItem + "INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ";
        pesquisaItem = pesquisaItem + "WHERE vendaitem.vendaID = '" + venda.vendaID + "' ";
        pesquisaItem = pesquisaItem + "ORDER BY vendaitem.itemID DESC";
        return pesquisaItem;
    }

    public String salvaItem()
    {
        String salvaItem = "INSERT INTO vendaitem ";
        salvaItem = salvaItem + "(vendaID, produtoID, quantidade, valor, total) ";
        salvaItem = salvaItem + "VALUES ";
        salvaItem = salvaItem + "('" + venda.vendaID + "', '" + produto.produtoID + "', '" + quantidade + "', '" + produto.preco + "', '" + total + "')";
        return salvaItem;
    }

    public String excluiItem()
    {
        return "DELETE FROM vendaitem WHERE itemID = '" + itemID + "'";
    }

    public String totalItem()
    {
        return "SELECT SUM(total) as subtotal FROM vendaitem WHERE vendaID = '" + venda.vendaID + "'";
    }

    public int itemID;
    public Venda venda;
    public Produto produto;
    public float quantidade;
    public float total;
}
