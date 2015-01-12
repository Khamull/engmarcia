// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TransferenciaEstoque.java

package financeiro;

import cadastro.Empresa;
import cadastro.Usuario;

public class TransferenciaEstoque
{

    public TransferenciaEstoque()
    {
        usuario = new Usuario();
        empresa = new Empresa();
    }

    public String salvaTransferencia()
    {
        String salvar = "INSERT INTO transferenciaestoque ";
        salvar = salvar + "(usuarioID, empresaID, origemID, destinoID, quantidade) ";
        salvar = salvar + "VALUES ";
        salvar = salvar + "('" + usuario.usuarioID + "','" + empresa.empresaID + "','" + origemID + "','" + destinoID + "','" + quantidade + "')";
        return salvar;
    }

    public int transferenciaID;
    public Usuario usuario;
    public Empresa empresa;
    public int origemID;
    public int destinoID;
    public float quantidade;
}
