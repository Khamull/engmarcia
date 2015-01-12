// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Contrato.java

package servico;


public class Contrato
{

    public Contrato()
    {
    }

    public String textoContrato()
    {
        return "SELECT * FROM contratopadrao WHERE contratoID = '" + contratoID + "'";
    }

    public String alteraContrato()
    {
        return "UPDATE contratopadrao SET contratoTexto = '" + contratoTexto + "' WHERE contratoID = '" + contratoID + "'";
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Contrato Cadastrado com Sucesso!";

        case 2: // '\002'
            return "Contrato Atualizado com Sucesso!";

        case 3: // '\003'
            return "Contrato Excluido com Sucesso!";

        case 4: // '\004'
            return "";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int contratoID;
    public String contratoTexto;
}
