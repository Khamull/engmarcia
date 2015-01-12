// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Funcionario.java

package cadastro;


// Referenced classes of package cadastro:
//            Endereco, Empresa

public class Funcionario
{

    public Funcionario()
    {
        endereco = new Endereco();
        empresa = new Empresa();
    }

    public String listaFuncionario()
    {
        return "SELECT * FROM funcionario ORDER BY funcionarioNome ASC";
    }

    public String listaFuncionarioAtivos()
    {
        return "SELECT * FROM funcionario WHERE funcionarioAtivo = 'S' ORDER BY funcionarioNome ASC";
    }

    public String pesquisaFuncionario(String keyWord)
    {
        return "SELECT * FROM funcionario WHERE funcionarioAtivo = 'S' AND funcionarioNome LIKE '%" + keyWord + "%' ORDER BY funcionarioID DESC";
    }

    public String listaFuncionariosOrdenados()
    {
        String dadosFunc = "SELECT cargo.cargoID, cargo.cargoTitulo, funcionario.* FROM funcionario ";
        dadosFunc = dadosFunc + "INNER JOIN cargo ON cargo.cargoID = funcionario.cargoID ";
        dadosFunc = dadosFunc + "WHERE funcionario.funcionarioAtivo = 'S' ORDER BY funcionario.funcionarioNome ASC";
        return dadosFunc;
    }

    public String funcionarioPorId()
    {
        String dadosFunc = "SELECT cargo.cargoID, cargo.cargoTitulo, funcionario.* FROM funcionario ";
        dadosFunc = dadosFunc + "INNER JOIN cargo ON cargo.cargoID = funcionario.cargoID ";
        dadosFunc = dadosFunc + "WHERE funcionario.funcionarioID = '" + funcionarioID + "'";
        return dadosFunc;
    }

    public String salvarFuncionario()
    {
        String salvaFuncionario = "INSERT INTO funcionario ";
        salvaFuncionario = salvaFuncionario + "(funcionarioNome, cargoID, funcionarioNascimento, funcionarioRg, ";
        salvaFuncionario = salvaFuncionario + "funcionarioCpf, funcionarioEndereco, funcionarioNumero, funcionarioBairro, ";
        salvaFuncionario = salvaFuncionario + "funcionarioCep, funcionarioCidade, funcionarioUf, funcionarioComplemento, ";
        salvaFuncionario = salvaFuncionario + "funcionarioTelefone, funcionarioCelular, operadoraCelular, funcionarioEmail, ";
        salvaFuncionario = salvaFuncionario + "funcionarioUsuario, empresaID) VALUES ";
        salvaFuncionario = salvaFuncionario + "('" + nome + "', '" + cargo + "', '" + nascimento + "', '" + rg + "', '" + cpf + "', '" + endereco.logradouro + "', ";
        salvaFuncionario = salvaFuncionario + "'" + endereco.numero + "', '" + endereco.bairro + "', '" + endereco.cep + "', ";
        salvaFuncionario = salvaFuncionario + "'" + endereco.cidade + "', '" + endereco.uf + "', '" + endereco.complemento + "', ";
        salvaFuncionario = salvaFuncionario + "'" + telefone + "', '" + celular + "', '" + operadoraCelular + "', '" + email + "', '" + funcionarioUsuario + "', '" + empresa.empresaID + "')";
        return salvaFuncionario;
    }

    public String alterarFuncionario()
    {
        String alteraFunc = "UPDATE funcionario SET cargoID = '" + cargo + "', funcionarioNome = '" + nome + "', funcionarioNascimento = '" + nascimento + "', ";
        alteraFunc = alteraFunc + "funcionarioRg = '" + rg + "', funcionarioCpf = '" + cpf + "', funcionarioEndereco = '" + endereco.logradouro + "', ";
        alteraFunc = alteraFunc + "funcionarioNumero = '" + endereco.numero + "', funcionarioBairro = '" + endereco.bairro + "', funcionarioCep = '" + endereco.cep + "', ";
        alteraFunc = alteraFunc + "funcionarioCidade = '" + endereco.cidade + "', funcionarioUf = '" + endereco.uf + "', funcionarioComplemento = '" + endereco.complemento + "', ";
        alteraFunc = alteraFunc + "funcionarioTelefone = '" + telefone + "', funcionarioCelular = '" + celular + "', operadoraCelular = '" + operadoraCelular + "', ";
        alteraFunc = alteraFunc + "funcionarioEmail = '" + email + "' WHERE funcionarioID = '" + funcionarioID + "'";
        return alteraFunc;
    }

    public String excluirFuncionario()
    {
        return "DELETE FROM funcionario WHERE funcionarioID = '" + funcionarioID + "'";
    }

    public String verificaCpf()
    {
        return "SELECT * FROM funcionario WHERE funcionarioCpf = '" + cpf + "'";
    }

    public String verificaCpfAlterar()
    {
        return "SELECT * FROM funcionario WHERE funcionarioCpf = '" + cpf + "' AND funcionarioID <> '" + funcionarioID + "'";
    }

    public String statusFuncionario(int numeroAcao)
    {
        if(numeroAcao == 1)
            return "UPDATE funcionario SET funcionarioAtivo = 'N' WHERE funcionarioID = '" + funcionarioID + "'";
        if(numeroAcao == 2)
            return "UPDATE funcionario SET funcionarioAtivo = 'S' WHERE funcionarioID = '" + funcionarioID + "'";
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Funcionario Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Funcionario Alterado com Sucesso!";

        case 3: // '\003'
            return "Funcionario Excluido com Sucesso!";

        case 4: // '\004'
            return "Imposs\355vel Cadastrar! J\341 existe um funcionario cadastrado com esse CPF.";

        case 5: // '\005'
            return "Imposs\355vel Alterar! J\341 existe um funcionario cadastrado com esse CPF.";
        }
        return "";
    }

    public int funcionarioID;
    public String cargo;
    public String nome;
    public String nascimento;
    public String rg;
    public String cpf;
    public Endereco endereco;
    public String telefone;
    public String celular;
    public String operadoraCelular;
    public String email;
    public String funcionarioUsuario;
    public Empresa empresa;
}
