// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ServicoPorcentagem.java

package servico;


// Referenced classes of package servico:
//            Servico, Servicos

public class ServicoPorcentagem
{

    public ServicoPorcentagem()
    {
        servico = new Servico();
        servicos = new Servicos();
    }

    public String listaItens()
    {
        return "SELECT * FROM servicoporcentagem WHERE servicoID = '" + servico.servicoID + "'";
    }

    public String servicoPorID()
    {
        return "SELECT * FROM servicoporcentagem WHERE servicoporcentagemID = '" + servicoporcentagemID + "'";
    }

    public String salvaServico()
    {
        String salvaServ = "INSERT INTO servicoporcentagem (servicoID, servicosID, descricao, valor, quantidade) ";
        salvaServ = salvaServ + "VALUES ('" + servico.servicoID + "', '" + servicos.servicoID + "', '" + descricao + "', '" + valor + "', '" + quantidade + "')";
        return salvaServ;
    }

    public String excluirServico()
    {
        return "DELETE FROM servicoporcentagem WHERE servicoporcentagemID = '" + servicoporcentagemID + "'";
    }

    public int servicoporcentagemID;
    public Servico servico;
    public Servicos servicos;
    public String descricao;
    public float valor;
    public float quantidade;
}
