// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Fornecedor.java

package cadastro;


// Referenced classes of package cadastro:
//            Endereco, Usuario, Empresa

public class Fornecedor
{

    public Fornecedor()
    {
        endereco = new Endereco();
        usuario = new Usuario();
        empresa = new Empresa();
    }

    public String listaFornecedores()
    {
        return "SELECT * FROM fornecedor ORDER BY fornecedorID DESC";
    }

    public String listaFornecedoresAtivos()
    {
        return "SELECT * FROM fornecedor WHERE fornAtivo = 'S' ORDER BY fornecedorID DESC";
    }

    public String fornecedorPorID()
    {
        return "SELECT * FROM fornecedor WHERE fornecedorID = '" + fornecedorID + "'";
    }

    public String pesquisaFornecedor(String keyWord)
    {
        return "SELECT * FROM fornecedor WHERE fornAtivo = 'S' AND fornNomeFantasia LIKE '%" + keyWord + "%' ORDER BY fornecedorID DESC";
    }

    public String listaFornecedoresOrdenados()
    {
        return "SELECT * FROM fornecedor ORDER BY fornNomeFantasia ASC";
    }

    public String verificaCnpj()
    {
        return "SELECT fornCnpj FROM fornecedor WHERE fornCnpj = '" + cnpj + "'";
    }

    public String verificaCnpjAlterar()
    {
        return "SELECT fornCnpj FROM fornecedor WHERE fornCnpj = '" + cnpj + "' AND fornecedorID <> '" + fornecedorID + "'";
    }

    public String salvarFornecedor()
    {
        String salvaCli = "INSERT INTO fornecedor (fornNomeFantasia, fornRazaoSocial, fornCnpj, fornInscEstadual, ";
        salvaCli = salvaCli + "fornInscMunicipal, fornEndereco, fornNumero, fornBairro, fornCep, fornCidade, fornUf, ";
        salvaCli = salvaCli + "fornComplemento, fornContato, fornTelefone, fornFax, fornRadio, fornCelular, operadoraCelular, ";
        salvaCli = salvaCli + "fornEmail, fornSite, fornUsuario, empresaID) VALUES ('" + nomeFantasia + "', '" + razaoSocial + "', ";
        salvaCli = salvaCli + "'" + cnpj + "', '" + inscEstadual + "', '" + inscMunicipal + "', '" + endereco.logradouro + "', '" + endereco.numero + "', ";
        salvaCli = salvaCli + "'" + endereco.bairro + "', '" + endereco.cep + "', '" + endereco.cidade + "', '" + endereco.uf + "', '" + endereco.complemento + "', ";
        salvaCli = salvaCli + "'" + contato + "', '" + telefone + "', '" + fax + "', '" + radio + "', '" + celular + "', ";
        salvaCli = salvaCli + "'" + operadoraCelular + "', '" + email + "', '" + site + "', '" + usuario + "', '" + empresa.empresaID + "')";
        return salvaCli;
    }

    public String alteraFornecedor()
    {
        String editaForn = "UPDATE  fornecedor SET  ";
        editaForn = editaForn + "fornNomeFantasia =  '" + nomeFantasia + "', ";
        editaForn = editaForn + "fornRazaoSocial =  '" + razaoSocial + "', ";
        editaForn = editaForn + "fornCnpj =  '" + cnpj + "', ";
        editaForn = editaForn + "fornInscEstadual =  '" + inscEstadual + "', ";
        editaForn = editaForn + "fornInscMunicipal =  '" + inscMunicipal + "', ";
        editaForn = editaForn + "fornEndereco =  '" + endereco.logradouro + "', ";
        editaForn = editaForn + "fornNumero =  '" + endereco.numero + "', ";
        editaForn = editaForn + "fornBairro =  '" + endereco.bairro + "', ";
        editaForn = editaForn + "fornCep =  '" + endereco.cep + "', ";
        editaForn = editaForn + "fornCidade =  '" + endereco.cidade + "', ";
        editaForn = editaForn + "fornUf =  '" + endereco.uf + "', ";
        editaForn = editaForn + "fornComplemento =  '" + endereco.complemento + "', ";
        editaForn = editaForn + "fornContato =  '" + contato + "', ";
        editaForn = editaForn + "fornTelefone =  '" + telefone + "', ";
        editaForn = editaForn + "fornFax =  '" + fax + "', ";
        editaForn = editaForn + "fornRadio =  '" + radio + "', ";
        editaForn = editaForn + "fornCelular =  '" + celular + "', ";
        editaForn = editaForn + "operadoraCelular =  '" + operadoraCelular + "', ";
        editaForn = editaForn + "fornEmail =  '" + email + "', ";
        editaForn = editaForn + "fornSite =  '" + site + "', ";
        editaForn = editaForn + "fornUsuario =  '" + usuario.nome + "', ";
        editaForn = editaForn + "empresaID = '" + empresa.empresaID + "' ";
        editaForn = editaForn + "WHERE  fornecedorID = '" + fornecedorID + "'";
        return editaForn;
    }

    public String excluirFornecedor()
    {
        return "DELETE FROM fornecedor WHERE fornecedorID = '" + fornecedorID + "'";
    }

    public String statusFornecedor(int numeroAcao)
    {
        if(numeroAcao == 1)
            return "UPDATE fornecedor SET fornAtivo = 'N' WHERE fornecedorID = '" + fornecedorID + "'";
        if(numeroAcao == 2)
            return "UPDATE fornecedor SET fornAtivo = 'S' WHERE fornecedorID = '" + fornecedorID + "'";
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Fornecedor Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Fornecedor Alterado com Sucesso!";

        case 3: // '\003'
            return "Fornecedor Excluido com Sucesso!";

        case 4: // '\004'
            return "Imposs\355vel Cadastrar! J\341 existe um fornecedor cadastrado com esse CNPJ.";

        case 5: // '\005'
            return "Imposs\355vel Alterar! J\341 existe um fornecedor cadastrado com esse CNPJ.";
        }
        return "";
    }

    public int fornecedorID;
    public String nomeFantasia;
    public String razaoSocial;
    public String cnpj;
    public String inscEstadual;
    public String inscMunicipal;
    public Endereco endereco;
    public String contato;
    public String telefone;
    public String fax;
    public String radio;
    public String celular;
    public String operadoraCelular;
    public String email;
    public String site;
    public Usuario usuario;
    public Empresa empresa;
}
