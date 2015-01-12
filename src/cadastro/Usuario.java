// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Usuario.java

package cadastro;


// Referenced classes of package cadastro:
//            Funcionario, Empresa

public class Usuario
{

    public Usuario()
    {
        funcionario = new Funcionario();
        msgErro = "";
        empresa = new Empresa();
    }

    public String logar()
    {
        return "SELECT * FROM usuario WHERE usuarioLogin = '" + login + "' AND usuarioSenha = '" + senha + "' AND usuarioAtivo = 'S'";
    }

    public String logarUnidade()
    {
        String logaSis = "SELECT * FROM usuario WHERE usuarioLogin = '" + login + "' AND ";
        logaSis = logaSis + "usuarioSenha = '" + senha + "' AND empresaID = '" + empresa.empresaID + "' AND usuarioAtivo = 'S'";
        return logaSis;
    }

    public String logarAdm()
    {
        return "SELECT * FROM usuario WHERE usuarioLogin = '" + login + "' AND usuarioSenha = '" + senha + "' AND usuarioAtivo = 'S' AND usuarioNivel = '1'";
    }

    public String verificaNome()
    {
        return "SELECT usuarioLogin FROM usuario WHERE usuarioLogin = '" + login + "'";
    }

    public String verificaNomeAlterar()
    {
        return "SELECT usuarioLogin FROM usuario WHERE usuarioLogin = '" + login + "' AND usuarioID <> '" + usuarioID + "'";
    }

    public String pesquisaUsuario(String keyWord)
    {
        return "SELECT * FROM usuario WHERE usuarionome LIKE '%" + keyWord + "%' ORDER BY usuarioID DESC";
    }

    public String listaUsuarios()
    {
        return "SELECT * FROM usuario ORDER BY usuarioID DESC";
    }

    public String listaUsuariosAtivos()
    {
        return "SELECT * FROM usuario WHERE usuarioAtivo = 'S' ORDER BY usuarioID DESC";
    }

    public String usuarioPorID()
    {
        String busca = "SELECT empresa.empresaID, empresa.unidade, usuario.* ";
        busca = busca + "FROM usuario INNER JOIN empresa ON empresa.empresaID = usuario.empresaID ";
        busca = busca + "WHERE usuario.usuarioID = '" + usuarioID + "'";
        return busca;
    }

    public String usuarioPorLogin()
    {
        return "SELECT * FROM usuario WHERE usuarioLogin = '" + login + "'";
    }

    public String listaUsuariosOrdenados()
    {
        return "SELECT * FROM usuario WHERE usuarioAtivo = 'S' ORDER BY usuarioNome ASC";
    }

    public String salvaUsuario()
    {
        String inserirNaBase = "INSERT INTO usuario ";
        inserirNaBase = inserirNaBase + "(funcionarioID, usuarioNome, usuarioTelefone, usuarioEmail, usuarioLogin, usuarioSenha, usuarioNivel, empresaID) ";
        inserirNaBase = inserirNaBase + "VALUES ('" + funcionario.funcionarioID + "', '" + nome + "', '', '', '" + login + "', '" + senha + "', '" + nivel + "', '" + empresa.empresaID + "')";
        return inserirNaBase;
    }

    public String editarUsuario()
    {
        String atualizaUsuario = "UPDATE usuario ";
        atualizaUsuario = atualizaUsuario + "SET funcionarioID = '" + funcionario.funcionarioID + "', usuarioNome = '" + nome + "', usuarioLogin = '" + login + "', ";
        atualizaUsuario = atualizaUsuario + "usuarioSenha = '" + senha + "', usuarioNivel = '" + nivel + "', empresaID = '" + empresa.empresaID + "' ";
        atualizaUsuario = atualizaUsuario + "WHERE usuarioID = '" + usuarioID + "'";
        return atualizaUsuario;
    }

    public String excluiUsuario()
    {
        return "DELETE FROM usuario WHERE usuarioID = '" + usuarioID + "'";
    }

    public String statusUsuario(int numeroAcao)
    {
        if(numeroAcao == 1)
            return "UPDATE usuario SET usuarioAtivo = 'N' WHERE usuarioID = '" + usuarioID + "'";
        if(numeroAcao == 2)
            return "UPDATE usuario SET usuarioAtivo = 'S' WHERE usuarioID = '" + usuarioID + "'";
        else
            return null;
    }

    public String erro(int numeroErro)
    {
        switch(numeroErro)
        {
        case 1: // '\001'
            return "Entre com seu login ou senha!";

        case 2: // '\002'
            return "Login ou senha n\343o Existe";

        case 3: // '\003'
            return "Sess\343o Expirou, entre novamente!";
        }
        return "";
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Usu\341rio Cadstrado com Sucesso!";

        case 2: // '\002'
            return "Usu\341rio Alterado com Sucesso!";

        case 3: // '\003'
            return "Usu\341rio Excluido com Sucesso!";

        case 4: // '\004'
            return "Imposs\355vel Cadastrar! J\341 existe um usu\341rio com esse Login.";

        case 5: // '\005'
            return "Imposs\355vel Alterar! J\341 existe um usu\341rio com esse Login.";
        }
        return "";
    }

    public String nivelUsuario(int nivel)
    {
        switch(nivel)
        {
        case 1: // '\001'
            return "Nivel 1";

        case 2: // '\002'
            return "Nivel 2";

        case 3: // '\003'
            return "Nivel 3";

        case 4: // '\004'
            return "Nivel 4";

        case 5: // '\005'
            return "Nivel 5";

        case 6: // '\006'
            return "Nivel 6";
        }
        return null;
    }

    public int usuarioID;
    public Funcionario funcionario;
    public String nome;
    public String telefone;
    public String email;
    public String login;
    public String senha;
    public String nivel;
    public String msgErro;
    public Empresa empresa;
}
