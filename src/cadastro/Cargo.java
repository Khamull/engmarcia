// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Cargo.java

package cadastro;


public class Cargo
{

    public Cargo()
    {
    }

    public String listaCargos()
    {
        return "SELECT * FROM cargo ORDER BY cargoTitulo ASC";
    }

    public String listaCargosAtivos()
    {
        return "SELECT * FROM cargo WHERE cargoAtivo = 'S' ORDER BY cargoTitulo ASC";
    }

    public String pesquisaCargo(String keyWord)
    {
        return "SELECT * FROM cargo WHERE cargoAtivo = 'S' AND cargoTitulo LIKE '%" + keyWord + "%' ORDER BY cargoTitulo ASC";
    }

    public String cargoPorId()
    {
        return "SELECT * FROM cargo WHERE cargoID = '" + cargoID + "'";
    }

    public String verificaCargo()
    {
        return "SELECT * FROM cargo WHERE cargoTitulo = '" + titulo + "'";
    }

    public String verificaCargoAlterar()
    {
        return "SELECT * FROM cargo WHERE cargoTitulo = '" + titulo + "' AND cargoID <> '" + cargoID + "'";
    }

    public String salvarCargo()
    {
        return "INSERT INTO cargo (cargoTitulo, cargoDescricao) VALUES ('" + titulo + "', '" + descricao + "')";
    }

    public String alteraCargo()
    {
        return "UPDATE cargo SET cargoTitulo = '" + titulo + "', cargoDescricao = '" + descricao + "' WHERE cargoID = '" + cargoID + "'";
    }

    public String excluiCargo()
    {
        return "DELETE FROM cargo WHERE cargoID = '" + cargoID + "'";
    }

    public String statusCargo(int numeroAcao)
    {
        if(numeroAcao == 1)
            return "UPDATE cargo SET cargoAtivo = 'N' WHERE cargoID = '" + cargoID + "'";
        if(numeroAcao == 2)
            return "UPDATE cargo SET cargoAtivo = 'S' WHERE cargoID = '" + cargoID + "'";
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Cargo Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Cargo Alterado com Sucesso!";

        case 3: // '\003'
            return "Cargo Excluido com Sucesso!";

        case 4: // '\004'
            return "Imposs\355vel Cadastrar! J\341 existe esse Cargo.";

        case 5: // '\005'
            return "Imposs\355vel Alterar! J\341 existe esse Cargo.";
        }
        return "";
    }

    public int cargoID;
    public String titulo;
    public String descricao;
}
