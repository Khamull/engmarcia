// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Retiradas.java

package caixaloja;

import cadastro.Empresa;
import cadastro.Usuario;

// Referenced classes of package caixaloja:
//            Caixa

public class Retiradas
{

    public Retiradas()
    {
        caixa = new Caixa();
        usuario = new Usuario();
        responsavel = new Usuario();
        empresa = new Empresa();
    }

    public String ultimaRetirada()
    {
        return "SELECT * FROM retiradas ORDER BY retiradaID DESC LIMIT 1";
    }

    public String somaRetiradas()
    {
        return "SELECT SUM(valor) as totalRetiradas FROM retiradas WHERE caixaID = '" + caixa.caixaID + "'";
    }

    public String buscaRetiradas()
    {
        return "SELECT * FROM retiradas WHERE caixaID = '" + caixa.caixaID + "'";
    }

    public String retirar()
    {
        String cadastra = "INSERT INTO retiradas ";
        cadastra = cadastra + "(caixaID, valor, usuario, responsavel, observacao, empresaID) ";
        cadastra = cadastra + "VALUES ";
        cadastra = cadastra + "('" + caixa.caixaID + "', '" + valor + "', '" + usuario.login + "', '" + responsavel.login + "', '" + observacao + "', '" + empresa.empresaID + "')";
        return cadastra;
    }

    public int retiradaID;
    public Caixa caixa;
    public float valor;
    public Usuario usuario;
    public Usuario responsavel;
    public String observacao;
    public Empresa empresa;
}
