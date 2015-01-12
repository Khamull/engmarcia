// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ServicoItem.java

package servico;


// Referenced classes of package servico:
//            Servico

public class ServicoItem
{

    public ServicoItem()
    {
        servico = new Servico();
    }

    public String listaItens()
    {
        return "SELECT * FROM servicoitem WHERE servicoID = '" + servico.servicoID + "'";
    }

    public String pesquisaItem()
    {
        return "SELECT * FROM servicoitem WHERE servicoitemID = '" + servicoItemID + "'";
    }

    public String salvaItem()
    {
        String salvaItem = "INSERT INTO servicoitem (servicoID, descricao, valor) VALUES ";
        salvaItem = salvaItem + "('" + servico.servicoID + "', '" + descricao + "', '" + valor + "')";
        return salvaItem;
    }

    public String excluiItem()
    {
        return "DELETE FROM servicoitem WHERE servicoitemID = '" + servicoItemID + "'";
    }

    public int servicoItemID;
    public Servico servico;
    public String descricao;
    public float valor;
}
