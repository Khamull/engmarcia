// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Empresa.java

package cadastro;


public class Empresa
{

    public Empresa()
    {
    }

    public String dadosEmpresa()
    {
        return "SELECT * FROM empresa WHERE empresaID = '1'";
    }

    public String dadosGerais()
    {
        return "SELECT * FROM empresa WHERE empresaID = '" + empresaID + "'";
    }

    public String listaEmpresas()
    {
        return "SELECT * FROM empresa WHERE empresaAtiva = 'S' ORDER BY empresaID DESC";
    }

    public String listaTodasEmpresas()
    {
        return "SELECT * FROM empresa ORDER BY empresaID DESC";
    }

    public String contaEmpresas()
    {
        return "SELECT COUNT(*) as qtdd FROM empresa WHERE empresaAtiva = 'S'";
    }

    public String alterarEmpresa()
    {
        String altEmpresa = "UPDATE empresa SET unidade = '" + unidade + "', nomeFantasia = '" + nomeFantasia + "', razaoSocial = '" + razaoSocial + "', ramo = '" + ramo + "', ";
        altEmpresa = altEmpresa + "cnpj = '" + cnpj + "', inscEstadual = '" + inscEstadual + "', inscMunicipal = '" + inscMunicipal + "', cep = '" + cep + "', ";
        altEmpresa = altEmpresa + "rua = '" + rua + "', numero = '" + numero + "', bairro = '" + bairro + "', cidade = '" + cidade + "', uf = '" + uf + "', ";
        altEmpresa = altEmpresa + "complemento = '" + complemento + "', responsavel = '" + responsavel + "', telefone = '" + telefone + "', fax = '" + fax + "', ";
        altEmpresa = altEmpresa + "celular = '" + celular + "', operadora = '" + operadora + "', email = '" + email + "', site = '" + site + "' ";
        altEmpresa = altEmpresa + "WHERE empresaID = '" + empresaID + "'";
        return altEmpresa;
    }

    public String salvaEmpresa()
    {
        String cadastraEmpresa = "INSERT INTO empresa ";
        cadastraEmpresa = cadastraEmpresa + "(unidade, nomeFantasia, razaoSocial, ramo, cnpj, inscEstadual, inscMunicipal, cep, rua, numero, bairro, cidade, uf, ";
        cadastraEmpresa = cadastraEmpresa + "complemento, responsavel, telefone, fax, celular, operadora, email, site) ";
        cadastraEmpresa = cadastraEmpresa + "VALUES ";
        cadastraEmpresa = cadastraEmpresa + "('" + unidade + "', '" + nomeFantasia + "', '" + razaoSocial + "', '" + ramo + "', '" + cnpj + "', '" + inscEstadual + "', '" + inscMunicipal + "', ";
        cadastraEmpresa = cadastraEmpresa + "'" + cep + "', '" + rua + "', '" + numero + "', '" + bairro + "', '" + cidade + "', '" + uf + "', '" + complemento + "', ";
        cadastraEmpresa = cadastraEmpresa + "'" + responsavel + "', '" + telefone + "', '" + fax + "', '" + celular + "', '" + operadora + "', '" + email + "', '" + site + "')";
        return cadastraEmpresa;
    }

    public String statusEmpresa(int numeroAcao)
    {
        if(numeroAcao == 1)
            return "UPDATE empresa SET empresaAtiva = 'N' WHERE empresaID = '" + empresaID + "'";
        if(numeroAcao == 2)
            return "UPDATE empresa SET empresaAtiva = 'S' WHERE empresaID = '" + empresaID + "'";
        else
            return null;
    }

    public String mensagem(int numeroMsg)
    {
        switch(numeroMsg)
        {
        case 1: // '\001'
            return "Nova Filial cadastrada com Sucesso!";

        case 2: // '\002'
            return "Dados da Empresa Alterado com Sucesso!";

        case 3: // '\003'
            return "";

        case 4: // '\004'
            return "";

        case 5: // '\005'
            return "";
        }
        return "";
    }

    public int empresaID;
    public String unidade;
    public String nomeFantasia;
    public String razaoSocial;
    public String ramo;
    public String cnpj;
    public String inscEstadual;
    public String inscMunicipal;
    public String cep;
    public String rua;
    public String numero;
    public String bairro;
    public String cidade;
    public String uf;
    public String complemento;
    public String responsavel;
    public String telefone;
    public String fax;
    public String celular;
    public String operadora;
    public String email;
    public String site;
}
