// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Caixa.java

package caixaloja;

import cadastro.Funcionario;
import cadastro.Usuario;

public class Caixa
{

    public Caixa()
    {
        usuario = new Usuario();
        funcionario = new Funcionario();
    }

    public String verificaCaixa()
    {
        return "SELECT * FROM caixa WHERE status = 'A' and usuario = '" + usuario.login + "'";
    }

    public String caixaPorID()
    {
        return "SELECT * FROM caixa WHERE caixaID = '" + caixaID + "'";
    }

    public String abreCaixa()
    {
        String cadastra = "INSERT INTO caixa ";
        cadastra = cadastra + "(usuario, funcionario, valorInicial, valorFinal, vendaInicial, vendaFinal, lancamentoInicial, lancamentoFinal, ";
        cadastra = cadastra + "retiradaInicial, retiradaFinal, dataInicio) ";
        cadastra = cadastra + "VALUES ";
        cadastra = cadastra + "( '" + usuario.login + "', '" + funcionario.nome + "', '" + valorInicial + "', '0.00', '" + vendaInicial + "', '0', '" + lancamentoInicial + "', '0', ";
        cadastra = cadastra + "'" + retiradaInicial + "', '0', CURRENT_TIMESTAMP)";
        return cadastra;
    }

    public String fechaCaixa()
    {
        String fechamento = "UPDATE caixa SET ";
        fechamento = fechamento + "valorFinal = '" + valorFinal + "', vendaFinal = '" + vendaFinal + "', lancamentoFinal = '" + lancamentoFinal + "', ";
        fechamento = fechamento + "retiradaFinal = '" + retiradaFinal + "', status = 'F' ";
        fechamento = fechamento + "WHERE caixaID = '" + caixaID + "'";
        return fechamento;
    }

    public String listaFechamentos(String dataInicio, String dataFim)
    {
        String lista = "SELECT funcionario.funcionarioID, funcionario.funcionarioNome, caixa.* ";
        lista = lista + "FROM caixa ";
        lista = lista + "INNER JOIN funcionario ON funcionario.funcionarioID = caixa.funcionario ";
        lista = lista + "WHERE caixa.status = 'F' AND data BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        lista = lista + "ORDER BY caixa.caixaID DESC";
        return lista;
    }

    public String listaFechamentosPorUsuario(String dataInicio, String dataFim)
    {
        String lista = "SELECT funcionario.funcionarioID, funcionario.funcionarioNome, caixa.* ";
        lista = lista + "FROM caixa ";
        lista = lista + "INNER JOIN funcionario ON funcionario.funcionarioID = caixa.funcionario ";
        lista = lista + "WHERE caixa.status = 'F' AND usuario = '" + usuario.login + "' AND data BETWEEN '" + dataInicio + "' AND '" + dataFim + "' ";
        lista = lista + "ORDER BY caixa.caixaID DESC";
        return lista;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Caixa Aberto!";

        case 2: // '\002'
            return "Caixa Fechado!";

        case 3: // '\003'
            return "";

        case 4: // '\004'
            return "";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int caixaID;
    public Usuario usuario;
    public Funcionario funcionario;
    public float valorInicial;
    public float valorFinal;
    public int vendaInicial;
    public int vendaFinal;
    public int lancamentoInicial;
    public int lancamentoFinal;
    public int retiradaInicial;
    public int retiradaFinal;
}
