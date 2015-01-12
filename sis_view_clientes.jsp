<%@ page errorPage="index.jsp?erro=3" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.*" %>
<%@ page import = "java.util.Date,java.text.SimpleDateFormat,java.text.ParseException"%>
<%@ include file="inc/seguranca.jsp" %>
<%@ include file="inc/conexao.jsp" %>
<%@ include file="inc/acesso_nivel.jsp" %>

<jsp:useBean id="cliente" class="cadastro.Cliente" scope="page"></jsp:useBean>

<%
//Instancia um objeto do tipo ResultSet para receber resultado de uma Consulta
ResultSet rs = null;
%>

<%
//Recupera o Nivel do Usu�rio
String nivel = String.valueOf(session.getAttribute("nivel"));
%>

<%
//Pesquisa Todos os Clientes ou busca por nome
if(request.getParameter("nome") != null){
	rs = st.executeQuery(cliente.pesquisaCliente(request.getParameter("nome")));
}else{
	rs = st.executeQuery(cliente.listaClientes());
}
%>

<%
//Trata A��es
//variaveis que ser�o utilizadas para verifica��o
String acao = "";
int numeroAcao;
//verifica se passado alguma acao via URL
if(request.getParameter("acao") != null){
	cliente.clienteID = Integer.parseInt(request.getParameter("clienteID"));
	numeroAcao = Integer.parseInt(request.getParameter("acao"));
	st.execute(cliente.statusCliente(numeroAcao));
	response.sendRedirect("sis_view_clientes.jsp");
}
%>

<%
//Trata mensagens
//variaveis que ser�o utilizadas para verifica��o
String msg = "";
int numeroMsg;
//verifica se foi passado alguma mensagem via URL
if(request.getParameter("msg") != null){
	numeroMsg = Integer.parseInt(request.getParameter("msg"));
	msg = cliente.mensagem(numeroMsg);
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>FORTE SYSTEM</title>

<script type="text/javascript">
 function excluir(clienteID){
	if(confirm("Tem certeza que deseja Excluir esse cliente?")){
		window.location.href="sis_delete_manager_cliente.jsp?clienteID="+clienteID;
	}
 }
</script>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/interface.js"></script>

<!--[if lt IE 7]>
 <style type="text/css">
 .dock img { behavior: url(iepngfix.htc) }
 </style>
<![endif]-->

<link type="text/css" href="css/paging.css" rel="stylesheet" />	
<script type="text/javascript" src="js/paging.js"></script>

<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/geral.css" rel="stylesheet" type="text/css" />

</head>
<body>

<div id="container">

<div id="topo">
 <jsp:include page="inc/menu_superior.jsp" />
</div>


<div id="corpo">

<table width="985" align="center" height="440">
<tr>
 <td height="25" bgcolor="#EEEEEE">
 <input type="button" class="botao" onclick="javascript: window.location.href='sis_insert_cliente.jsp'" value="+ Novo Cliente" />
 </td>
</tr>
<tr>
 <td valign="top">
 <br />
  <table width="810" align="center" cellpadding="0" cellspacing="0">
   <tr>
    <td colspan="8" align="center"><strong>LISTA DE CLIENTES</strong></td>
   </tr>
   <tr>
     <td colspan="8" height="15"></td>
   </tr>
   <tr>
    <td colspan="8" height="40" align="left" valign="middle">
    
    <form name="formBusca" method="post">
     <table width="335" style="border:1px solid #333; height:30px" align="left" cellpadding="0" cellspacing="0">
      <tr>
       <td width="259" align="right">
       <input type="text" name="nome" maxlength="100" size="50" style="background-image:url(images/busca.png); height:18px; border:none"  onclick="this.style.backgroundImage = 'none'" onblur="if(this.value == '')this.style.backgroundImage = 'url(images/busca.png)'"/>
       </td>
       <td width="74" align="left"><input type="submit" class="botao" style="height:22px" name="BUSCAR" value="Buscar" /></td>
      </tr>
     </table>
    </form>
    
    </td>
   </tr>
   <tr bgcolor="#EEEEEE">
    <td width="230" align="left"><strong>Nome</strong></td>
    <td width="180" align="left"><strong>CPF / CNPJ</strong></td>
    <td width="100" align="center"><strong>Telefone</strong></td>
    <td width="60" align="center"><strong>Vs</strong></td>
    <td width="60" align="center"><strong>Ed</strong></td>
    <td width="60" align="center"><strong>At</strong></td>
    <td width="60" align="center"><strong>Dv</strong></td>
    <td width="60" align="center">
    <%if(nivel.equals("1") || nivel.equals("2")){ %>
    <strong>Ex</strong>
    <%}%>
    </td>
   </tr>
   <tr>
    <td colspan="8">
     <table id="tb1" width="810" align="center" cellpadding="0" cellspacing="0">  
      <tr>
       <td colspan="8" height="5"></td>
      </tr> 
<%
//Enquanto a Consulta retonar um resultada, Liste os Usu�rios do Sistema
while (rs.next()){
%>
   
   <tr>
    <td height="30" width="230" align="left"><%=rs.getString("clienteNomeFantasia")%></td>
    <td height="30" width="180" align="left"><%=rs.getString("clienteCnpj")%></td>
    <td height="30" width="100" align="left"><%=rs.getString("clienteTelefone")%></td>
    <td height="30" width="60" align="center"><a href="sis_detalhe_cliente.jsp?clienteID=<%=rs.getString("clienteID")%>"><img src="ico/ico_visualizar.png" width="20" height="20" border="0" title="Visualizar <%=rs.getString("clienteNomeFantasia")%>" /></a></td>
    <td height="30" width="60" align="center"><a href="sis_update_cliente.jsp?clienteID=<%=rs.getString("clienteID")%>"><img src="ico/ico_editar.png" width="20" height="20" border="0" title="Editar <%=rs.getString("clienteNomeFantasia")%>" /></a></td>
    <%
	//Verifica o status se est� ativo ou n�o
	String status = rs.getString("clienteAtivo");
	if(status.equals("S")){
	%>
    <td height="30" width="60" align="center"><a href="sis_view_clientes.jsp?acao=1&clienteID=<%=rs.getString("clienteID")%>"><img src="ico/ico_ativo.png" width="20" height="20" border="0" title="Desativar <%=rs.getString("clienteNomeFantasia")%>" /></a></td>
    <%}else if(status.equals("N")){%>
    <td height="30" width="60" align="center"><a href="sis_view_clientes.jsp?acao=2&clienteID=<%=rs.getString("clienteID")%>"><img src="ico/ico_inativo.png" width="20" height="20" border="0" title="Ativar <%=rs.getString("clienteNomeFantasia")%>" /></a></td>
    <%}%>
    
    <td height="30" width="60" align="center"><a href="sis_divida_cliente.jsp?clienteID=<%=rs.getString("clienteID")%>"><img src="ico/ico_calculadora.png" width="20" height="20" border="0" title="Saldo Devedor" /></a></td>
    <td height="30" width="60" align="center">
    <%if(nivel.equals("1") || nivel.equals("2")){ %>
    <a href="javascript:excluir(<%=rs.getString("clienteID")%>)"><img src="ico/ico_excluir.png" width="20" height="20" border="0" title="Excluir <%=rs.getString("clienteNomeFantasia")%>" /></a>
    <%}%>
    </td>
   </tr>
   <tr>
    <td colspan="8" align="center" style="height:1px"><hr style="border:1px solid #333333" /></td>
   </tr>

<%
}
%>
   </table>
   </td>
   </tr>
	
	<tr>
	 <td colspan="8" align="center"><font color="#ff0000"><%=msg %></font></td>
	</tr>
    <tr>
     <td colspan="8" align="center">
      <!-- div onde ser� criados os links da pagina�ao -->
	  <div id="pageNav"></div>
     </td>
    </tr>

  </table>
 
 </td>
</tr>
</table>

</div>


<div id="rodape"><jsp:include page="inc/rodape.jsp" /></div>

</div>


<script type="text/javascript">
	
	$(document).ready(
		function()
		{
			$('#dock').Fisheye(
				{
					maxWidth: 50,
					items: 'a',
					itemsText: 'span',
					container: '.dock-container',
					itemWidth: 40,
					proximity: 50,
					halign : 'center'
				}
			)
		}
	);

</script>

	<script>
        var pager = new Pager('tb1', 12); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNav'); 
        pager.showPage(1);
    </script>

</body>
</html>

<%
 //fecha a consulta
 st.close();
 rs.close();
%>