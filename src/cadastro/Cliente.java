// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Cliente.java

package cadastro;


// Referenced classes of package cadastro:
//            Endereco, Usuario

public class Cliente
{

    public Cliente()
    {
        endereco = new Endereco();
        usuario = new Usuario();
    }

    public String listaClientes()
    {
        return "SELECT * FROM cliente ORDER BY clienteID DESC";
    }

    public String listaClientesaAtivos()
    {
        return "SELECT * FROM cliente WHERE clienteAtivo = 'S' ORDER BY clienteID DESC";
    }

    public String listaClientesOrdenados()
    {
        return "SELECT * FROM cliente WHERE clienteAtivo = 'S' ORDER BY clienteNomeFantasia ASC";
    }

    public String clientePorID()
    {
        return "SELECT * FROM cliente WHERE clienteID = '" + clienteID + "'";
    }

    public String pesquisaCliente(String keyWord)
    {
        return "SELECT * FROM cliente WHERE clienteAtivo = 'S' AND clienteNomeFantasia LIKE '%" + keyWord + "%' ORDER BY clienteID DESC";
    }

    public String verificaCnpj()
    {
        return "SELECT clienteCnpj FROM cliente WHERE clienteCnpj = '" + cnpj + "'";
    }

    public String verificaCnpjAlterar()
    {
        return "SELECT clienteCnpj FROM cliente WHERE clienteCnpj = '" + cnpj + "' AND clienteID <> '" + clienteID + "'";
    }

    public String salvarCliente()
    {
        String salvaCli = "INSERT INTO cliente (tipoPessoa, clienteNomeFantasia, clienteRazaoSocial, clienteCnpj, clienteInscEstadual, ";
        salvaCli = salvaCli + "clienteInscMunicipal, clienteEndereco, clienteNumero, clienteBairro, clienteCep, clienteCidade, clienteUf, ";
        salvaCli = salvaCli + "clienteComplemento, clienteContato, clienteTelefone, clienteFax, clienteRadio, clienteCelular, operadoraCelular, ";
        salvaCli = salvaCli + "clienteEmail, clienteSite, clienteUsuario, limiteCredito) VALUES ('" + tipoPessoa + "', '" + nomeFantasia + "', '" + razaoSocial + "', ";
        salvaCli = salvaCli + "'" + cnpj + "', '" + inscEstadual + "', '" + inscMunicipal + "', '" + endereco.logradouro + "', '" + endereco.numero + "', ";
        salvaCli = salvaCli + "'" + endereco.bairro + "', '" + endereco.cep + "', '" + endereco.cidade + "', '" + endereco.uf + "', '" + endereco.complemento + "', ";
        salvaCli = salvaCli + "'" + contato + "', '" + telefone + "', '" + fax + "', '" + radio + "', '" + celular + "', ";
        salvaCli = salvaCli + "'" + operadoraCelular + "', '" + email + "', '" + site + "', '" + usuario + "', '" + limiteCredito + "')";
        return salvaCli;
    }

    public String alteraCliente()
    {
        String editaCli = "UPDATE  cliente SET  ";
        editaCli = editaCli + "tipoPessoa = '" + tipoPessoa + "', ";
        editaCli = editaCli + "clienteNomeFantasia =  '" + nomeFantasia + "', ";
        editaCli = editaCli + "clienteRazaoSocial =  '" + razaoSocial + "', ";
        editaCli = editaCli + "clienteCnpj =  '" + cnpj + "', ";
        editaCli = editaCli + "clienteInscEstadual =  '" + inscEstadual + "', ";
        editaCli = editaCli + "clienteInscMunicipal =  '" + inscMunicipal + "', ";
        editaCli = editaCli + "clienteEndereco =  '" + endereco.logradouro + "', ";
        editaCli = editaCli + "clienteNumero =  '" + endereco.numero + "', ";
        editaCli = editaCli + "clienteBairro =  '" + endereco.bairro + "', ";
        editaCli = editaCli + "clienteCep =  '" + endereco.cep + "', ";
        editaCli = editaCli + "clienteCidade =  '" + endereco.cidade + "', ";
        editaCli = editaCli + "clienteUf =  '" + endereco.uf + "', ";
        editaCli = editaCli + "clienteComplemento =  '" + endereco.complemento + "', ";
        editaCli = editaCli + "clienteContato =  '" + contato + "', ";
        editaCli = editaCli + "clienteTelefone =  '" + telefone + "', ";
        editaCli = editaCli + "clienteFax =  '" + fax + "', ";
        editaCli = editaCli + "clienteRadio =  '" + radio + "', ";
        editaCli = editaCli + "clienteCelular =  '" + celular + "', ";
        editaCli = editaCli + "operadoraCelular =  '" + operadoraCelular + "', ";
        editaCli = editaCli + "clienteEmail =  '" + email + "', ";
        editaCli = editaCli + "clienteSite =  '" + site + "', ";
        editaCli = editaCli + "clienteUsuario =  '" + usuario.nome + "', ";
        editaCli = editaCli + "limiteCredito =  '" + limiteCredito + "' ";
        editaCli = editaCli + "WHERE  clienteID = '" + clienteID + "'";
        return editaCli;
    }

    public String excluirCliente()
    {
        return "DELETE FROM cliente WHERE clienteID = '" + clienteID + "'";
    }

    public String statusCliente(int numeroAcao)
    {
        if(numeroAcao == 1)
            return "UPDATE cliente SET clienteAtivo = 'N' WHERE clienteID = '" + clienteID + "'";
        if(numeroAcao == 2)
            return "UPDATE cliente SET clienteAtivo = 'S' WHERE clienteID = '" + clienteID + "'";
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Cliente Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Cliente Alterado com Sucesso!";

        case 3: // '\003'
            return "Cliente Excluido com Sucesso!";

        case 4: // '\004'
            return "Imposs\355vel Cadastrar! J\341 existe um cliente cadastrado com esse CPF / CNPJ.";

        case 5: // '\005'
            return "Imposs\355vel Alterar! J\341 existe um cliente cadastrado com esse CPF / CNPJ.";
        }
        return "";
    }

    public int clienteID;
    public String tipoPessoa;
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
    public String limiteCredito;
}
