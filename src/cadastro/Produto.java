// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Produto.java

package cadastro;


// Referenced classes of package cadastro:
//            TipoProduto, Fornecedor

public class Produto
{

    public Produto()
    {
        tipo = new TipoProduto();
        fornecedor = new Fornecedor();
    }

    public String listaProdutos()
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = pesquisaProduto + "FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ";
        pesquisaProduto = pesquisaProduto + "INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ";
        pesquisaProduto = pesquisaProduto + "ORDER BY produto.nome ASC";
        return pesquisaProduto;
    }

    public String listaProdutosAtivos()
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = pesquisaProduto + "FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ";
        pesquisaProduto = pesquisaProduto + "INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ";
        pesquisaProduto = pesquisaProduto + "WHERE produtoAtivo = 'S' ";
        pesquisaProduto = pesquisaProduto + "ORDER BY produto.nome ASC";
        return pesquisaProduto;
    }

    public String listaProdutosPorID()
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = pesquisaProduto + "FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ";
        pesquisaProduto = pesquisaProduto + "INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID WHERE produto.produtoID = '" + produtoID + "' ";
        pesquisaProduto = pesquisaProduto + "ORDER BY produto.nome ASC";
        return pesquisaProduto;
    }

    public String pesquisaProdutoPorCodigo(String cod)
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = pesquisaProduto + "FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ";
        pesquisaProduto = pesquisaProduto + "INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ";
        pesquisaProduto = pesquisaProduto + " WHERE produto.codigo = '" + cod + "' ORDER BY produto.nome ASC";
        return pesquisaProduto;
    }

    public String pesquisaProdutos(String keyWord)
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = pesquisaProduto + "FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ";
        pesquisaProduto = pesquisaProduto + "INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ";
        pesquisaProduto = pesquisaProduto + " WHERE nome LIKE '%" + keyWord + "%' ORDER BY produto.nome ASC";
        return pesquisaProduto;
    }

    public String produtoPorFT()
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = pesquisaProduto + "FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ";
        pesquisaProduto = pesquisaProduto + "INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ";
        pesquisaProduto = pesquisaProduto + "WHERE produto.fornecedorID = '" + fornecedor.fornecedorID + "' ";
        pesquisaProduto = pesquisaProduto + "AND produto.tipoprodutoID = '" + tipo.tipoProdutoID + "' ";
        pesquisaProduto = pesquisaProduto + "ORDER BY produto.nome ASC";
        return pesquisaProduto;
    }

    public String produtoPorF()
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = pesquisaProduto + "FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ";
        pesquisaProduto = pesquisaProduto + "INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ";
        pesquisaProduto = pesquisaProduto + "WHERE produto.fornecedorID = '" + fornecedor.fornecedorID + "' ";
        pesquisaProduto = pesquisaProduto + "ORDER BY produto.nome ASC";
        return pesquisaProduto;
    }

    public String produtoPorT()
    {
        String pesquisaProduto = "SELECT fornecedor.fornecedorID, fornecedor.fornNomeFantasia, tipoproduto.tipoprodutoID, tipoproduto.tipo, produto.* ";
        pesquisaProduto = pesquisaProduto + "FROM produto INNER JOIN fornecedor ON fornecedor.fornecedorID = produto.fornecedorID ";
        pesquisaProduto = pesquisaProduto + "INNER JOIN tipoproduto ON tipoproduto.tipoprodutoID = produto.tipoprodutoID ";
        pesquisaProduto = pesquisaProduto + "WHERE produto.tipoprodutoID = '" + tipo.tipoProdutoID + "' ";
        pesquisaProduto = pesquisaProduto + "ORDER BY produto.nome ASC";
        return pesquisaProduto;
    }

    public String produtoNome()
    {
        return "SELECT * FROM produto WHERE nome = '" + nome + "'";
    }

    public String produtoNomeEditar()
    {
        return "SELECT * FROM produto WHERE nome = '" + nome + "' AND produtoID <> '" + produtoID + "'";
    }

    public String produtoCodigo()
    {
        return "SELECT * FROM produto WHERE codigo = '" + codigo + "'";
    }

    public String produtoCodigoEditar()
    {
        return "SELECT * FROM produto WHERE codigo = '" + codigo + "' AND produtoID <> '" + produtoID + "'";
    }

    public String produtoPorFornecedor(String fornID)
    {
        return "SELECT * FROM produto WHERE fornecedorID = '" + fornID + "' ORDER BY nome ASC";
    }

    public String salvaProduto()
    {
        String salvaProd = "INSERT INTO produto ";
        salvaProd = salvaProd + "(tipoprodutoID, fornecedorID, nome, codigo, unidade, precoCusto, preco, estoqueminimo, estoque, lucro) VALUES";
        salvaProd = salvaProd + "('" + tipo.tipoProdutoID + "', '" + fornecedor.fornecedorID + "', '" + nome + "', '" + codigo + "', '" + unidade + "', '" + precoCusto + "', '" + preco + "', '" + estoqueMinimo + "', '" + estoque + "', '" + lucro + "' ) ";
        return salvaProd;
    }

    public String alteraProduto()
    {
        String alterProd = "UPDATE produto SET ";
        alterProd = alterProd + "tipoprodutoID = '" + tipo.tipoProdutoID + "', fornecedorID = '" + fornecedor.fornecedorID + "', nome = '" + nome + "', codigo = '" + codigo + "', ";
        alterProd = alterProd + "unidade = '" + unidade + "', precoCusto = '" + precoCusto + "', preco = '" + preco + "', estoqueminimo = '" + estoqueMinimo + "', ";
        alterProd = alterProd + "estoque = '" + estoque + "', lucro = '" + lucro + "' ";
        alterProd = alterProd + "WHERE produtoID = '" + produtoID + "'";
        return alterProd;
    }

    public String alteraEstoqueProduto()
    {
        return "UPDATE produto SET estoque = '" + estoque + "' WHERE produtoID = '" + produtoID + "'";
    }

    public String excluiProduto()
    {
        return "DELETE FROM produto WHERE produtoID = '" + produtoID + "'";
    }

    public String statusProduto(int numeroAcao)
    {
        if(numeroAcao == 1)
            return "UPDATE produto SET produtoAtivo = 'N' WHERE produtoID = '" + produtoID + "'";
        if(numeroAcao == 2)
            return "UPDATE produto SET produtoAtivo = 'S' WHERE produtoID = '" + produtoID + "'";
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Produto Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Produto Alterado com Sucesso!";

        case 3: // '\003'
            return "Produto Excluido com Sucesso!";

        case 4: // '\004'
            return "Imposs\355vel Cadastrar! J\341 existe um produto cadastrado com esse Nome.";

        case 5: // '\005'
            return "Imposs\355vel Alterar! J\341 existe um produto cadastrado com esse Nome.";

        case 6: // '\006'
            return "Estoque Alterado com Sucesso!";

        case 7: // '\007'
            return "Imposs\355vel Cadastrar! J\341 existe um produto cadastrado com esse C\363digo.";

        case 8: // '\b'
            return "Imposs\355vel Alterar! J\341 existe um produto cadastrado com esse C\363digo.";
        }
        return "";
    }

    public int produtoID;
    public TipoProduto tipo;
    public Fornecedor fornecedor;
    public String nome;
    public String codigo;
    public String unidade;
    public double precoCusto;
    public double preco;
    public int estoqueMinimo;
    public float estoque;
    public String lucro;
}
