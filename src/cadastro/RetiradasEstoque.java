// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RetiradasEstoque.java

package cadastro;


// Referenced classes of package cadastro:
//            Produto, Usuario, Empresa

public class RetiradasEstoque
{

    public RetiradasEstoque()
    {
        produto = new Produto();
        usuario = new Usuario();
        empresa = new Empresa();
    }

    public String retiradasPorProdutoID()
    {
        return "SELECT * FROM retiradasestoque WHERE produtoID = '" + produto.produtoID + "'";
    }

    public String retiradasEntreDatas(String dataInicio, String dataFim)
    {
        String busca = "SELECT * FROM retiradasestoque ";
        busca = busca + "WHERE produtoID = '" + produto.produtoID + "' ";
        busca = busca + "AND data BETWEEN '" + dataInicio + "' AND '" + dataFim + " 23:59:59" + "'";
        return busca;
    }

    public String retiradasEntreDatasDetalhada(String dataInicio, String dataFim)
    {
        String busca = "SELECT usuario.usuarioID, usuario.usuarioLogin, usuario.usuarioNome, retiradasestoque.* ";
        busca = busca + "FROM retiradasestoque ";
        busca = busca + "LEFT JOIN usuario ON usuario.usuarioID = retiradasestoque.usuario ";
        busca = busca + "WHERE retiradasestoque.produtoID = '" + produto.produtoID + "' ";
        busca = busca + "AND retiradasestoque.data BETWEEN '" + dataInicio + "' AND '" + dataFim + " 23:59:59" + "' ";
        busca = busca + "GROUP BY retiradasestoque.retiradaID ";
        busca = busca + "ORDER BY retiradasestoque.data DESC";
        return busca;
    }

    public String retiradasEntreDatasRelatorio(String dataInicio, String dataFim)
    {
        String busca = "SELECT usuario.usuarioID, usuario.usuarioLogin, usuario.usuarioNome, produto.produtoID, produto.nome, produto.unidade, retiradasestoque.* ";
        busca = busca + "FROM retiradasestoque ";
        busca = busca + "LEFT JOIN usuario ON usuario.usuarioID = retiradasestoque.usuario ";
        busca = busca + "INNER JOIN produto ON produto.produtoID = retiradasestoque.produtoID  ";
        busca = busca + "WHERE retiradasestoque.data BETWEEN '" + dataInicio + "' AND '" + dataFim + " 23:59:59" + "' ";
        busca = busca + "GROUP BY retiradasestoque.retiradaID ";
        busca = busca + "ORDER BY retiradasestoque.data ASC";
        return busca;
    }

    public String quantidadeRetirada(String dataInicio, String dataFim)
    {
        String busca = "SELECT SUM(quantidade) as totalRetirada FROM retiradasestoque ";
        busca = busca + "WHERE produtoID = '" + produto.produtoID + "' ";
        busca = busca + "AND data BETWEEN '" + dataInicio + "' AND '" + dataFim + "'";
        return busca;
    }

    public String cadastraRetirada()
    {
        String cadastra = "INSERT INTO retiradasestoque ";
        cadastra = cadastra + "(produtoID, quantidade, motivo, usuario, empresaID) VALUES";
        cadastra = cadastra + "('" + produto.produtoID + "', '" + quantidade + "', '" + motivo + "', '" + usuario.login + "', '" + empresa.empresaID + "')";
        return cadastra;
    }

    public int retiradaID;
    public Produto produto;
    public float quantidade;
    public String motivo;
    public Usuario usuario;
    public Empresa empresa;
}
