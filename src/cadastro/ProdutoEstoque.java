// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ProdutoEstoque.java

package cadastro;


// Referenced classes of package cadastro:
//            Produto, Empresa

public class ProdutoEstoque
{

    public ProdutoEstoque()
    {
        produto = new Produto();
        empresa = new Empresa();
    }

    public String pesquisaEstoque()
    {
        return "SELECT * FROM produtoestoque WHERE produtoID = '" + produto.produtoID + "' AND empresaID = '" + empresa.empresaID + "'";
    }

    public String salvaQuantidade()
    {
        String salvaQtdd = "INSERT INTO produtoestoque ";
        salvaQtdd = salvaQtdd + "(produtoID, empresaID, quantidade) ";
        salvaQtdd = salvaQtdd + "VALUES ";
        salvaQtdd = salvaQtdd + "('" + produto.produtoID + "', '" + empresa.empresaID + "', '" + quantidade + "')";
        return salvaQtdd;
    }

    public String alteraEstoque()
    {
        String alteraQtdd = "UPDATE produtoestoque SET ";
        alteraQtdd = alteraQtdd + "quantidade = '" + quantidade + "' ";
        alteraQtdd = alteraQtdd + "WHERE produtoID = '" + produto.produtoID + "' AND empresaID = '" + empresa.empresaID + "'";
        return alteraQtdd;
    }

    public int produtoEstoqueID;
    public Produto produto;
    public Empresa empresa;
    public float quantidade;
}
