// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Moeda.java

package formatar;


public class Moeda
{

    public Moeda()
    {
    }

    public String valorPorExtenso(double vlr)
    {
        if(vlr == 0.0D)
            return "zero";
        long inteiro = (long)Math.abs(vlr);
        double resto = vlr - (double)inteiro;
        String vlrS = String.valueOf(inteiro);
        if(vlrS.length() > 15)
            return "Erro: valor superior a 999 trilh\365es.";
        String s = "";
        String centavos = String.valueOf((int)Math.round(resto * 100D));
        String unidade[] = {
            "", "um", "dois", "tr\352s", "quatro", "cinco", "seis", "sete", "oito", "nove", 
            "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"
        };
        String centena[] = {
            "", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"
        };
        String dezena[] = {
            "", "", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"
        };
        String qualificaS[] = {
            "", "mil", "milh\343o", "bilh\343o", "trilh\343o"
        };
        String qualificaP[] = {
            "", "mil", "milh\365es", "bilh\365es", "trilh\365es"
        };
        int i = 0;
        boolean umReal = false;
        boolean tem = false;
        while(!vlrS.equals("0")) 
        {
            int tam = vlrS.length();
            String vlrP;
            if(tam > 3)
            {
                vlrP = vlrS.substring(tam - 3, tam);
                vlrS = vlrS.substring(0, tam - 3);
            } else
            {
                vlrP = vlrS;
                vlrS = "0";
            }
            if(!vlrP.equals("000"))
            {
                String saux = "";
                if(vlrP.equals("100"))
                    saux = "cem";
                else
                if(vlrP.equals("200"))
                    saux = "duzentos";
                else
                if(vlrP.equals("300"))
                    saux = "trezentos";
                else
                if(vlrP.equals("400"))
                    saux = "quatrocentos";
                else
                if(vlrP.equals("500"))
                    saux = "quinhentos";
                else
                if(vlrP.equals("600"))
                    saux = "seiscentos";
                else
                if(vlrP.equals("700"))
                    saux = "setecentos";
                else
                if(vlrP.equals("800"))
                    saux = "oitocentos";
                else
                if(vlrP.equals("900"))
                {
                    saux = "novecentos";
                } else
                {
                    int n = Integer.parseInt(vlrP, 10);
                    int cent = n / 100;
                    int dez = (n % 100) / 10;
                    int unid = n % 100 % 10;
                    if(cent != 0)
                        saux = centena[cent];
                    if(n % 100 <= 19)
                    {
                        if(saux.length() != 0)
                            saux = saux + " e " + unidade[n % 100];
                        else
                            saux = unidade[n % 100];
                    } else
                    {
                        if(saux.length() != 0)
                            saux = saux + " e " + dezena[dez];
                        else
                            saux = dezena[dez];
                        if(unid != 0)
                            if(saux.length() != 0)
                                saux = saux + " e " + unidade[unid];
                            else
                                saux = unidade[unid];
                    }
                }
                if(vlrP.equals("1") || vlrP.equals("001"))
                {
                    if(i == 0)
                        umReal = true;
                    else
                        saux = saux + " " + qualificaS[i];
                } else
                if(i != 0)
                    saux = saux + " " + qualificaP[i];
                if(s.length() != 0)
                    s = saux + ", " + s;
                else
                    s = saux;
            }
            if((i == 0 || i == 1) && s.length() != 0)
                tem = true;
            i++;
        }
        if(s.length() != 0)
            if(umReal)
                s = s + " real";
            else
            if(tem)
                s = s + " reais";
            else
                s = s + " de reais";
        if(!centavos.equals("0"))
        {
            if(s.length() != 0)
                s = s + " e ";
            if(centavos.equals("1"))
            {
                s = s + "um centavo";
            } else
            {
                int n = Integer.parseInt(centavos, 10);
                if(n <= 19)
                {
                    s = s + unidade[n];
                } else
                {
                    int unid = n % 10;
                    int dez = n / 10;
                    s = s + dezena[dez];
                    if(unid != 0)
                        s = s + " e " + unidade[unid];
                }
                s = s + " centavos";
            }
        }
        return s;
    }
}
