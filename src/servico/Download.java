// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Download.java

package servico;

import cadastro.Cliente;

public class Download
{

    public Download()
    {
        cliente = new Cliente();
    }

    public String pesquisaDownload()
    {
        String busca = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, download.* ";
        busca = busca + "FROM download INNER JOIN cliente ON cliente.clienteID = download.clienteID ";
        busca = busca + "ORDER BY download.downloadID DESC";
        return busca;
    }

    public String downloadPorCliente()
    {
        String busca = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, download.* ";
        busca = busca + "FROM download INNER JOIN cliente ON cliente.clienteID = download.clienteID ";
        busca = busca + "WHERE cliente.clienteID = '" + cliente.clienteID + "' ";
        busca = busca + "ORDER BY download.downloadID DESC";
        return busca;
    }

    public String pesquisaPorCliente(String keyword)
    {
        String busca = "SELECT cliente.clienteID, cliente.clienteNomeFantasia, download.* ";
        busca = busca + "FROM download INNER JOIN cliente ON cliente.clienteID = download.clienteID ";
        busca = busca + "WHERE cliente.clienteNomeFantasia LIKE '%" + keyword + "%' ";
        busca = busca + "ORDER BY download.downloadID DESC";
        return busca;
    }

    public String insereDownload()
    {
        return "INSERT INTO download (clienteID, arquivo, titulo, contrato) VALUES ('" + cliente.clienteID + "', '" + arquivo + "', '" + titulo + "', '" + contrato + "')";
    }

    public int downloadID;
    public Cliente cliente;
    public String arquivo;
    public String titulo;
    public String contrato;
}
