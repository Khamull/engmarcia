<%//@ page errorPage="index.jsp?erro=3" %>
<%@ page import="java.sql.*" %>
<%@ include file="inc/conexao.jsp" %>
<%@ include file="inc/seguranca.jsp" %>


<jsp:useBean id="empresa" class="cadastro.Empresa" scope="page"></jsp:useBean>

<jsp:useBean id="servico" class="servico.Servico" scope="page"></jsp:useBean>

<jsp:useBean id="servicoitem" class="servico.ServicoItem" scope="page"></jsp:useBean>

<jsp:useBean id="servicoproduto" class="servico.ServicoProduto" scope="page"></jsp:useBean>

<jsp:useBean id="servicometroquadrado" class="servico.ServicoMetroQuadrado" scope="page"></jsp:useBean>

<jsp:useBean id="servicoporcentagem" class="servico.ServicoPorcentagem" scope="page"></jsp:useBean>

<jsp:useBean id="data" class="formatar.Datas" scope="page"></jsp:useBean>
<%
//Instancia um objeto do tipo Statemenet para auxiliar na query
Statement st01 = con.createStatement();
Statement st02 = con.createStatement();
Statement st03 = con.createStatement();
Statement st04 = con.createStatement();
Statement st05 = con.createStatement();
%>

<%
//Instancia um objeto do tipo Resultset para receber o resultado de uma consulta
ResultSet rs = null;
ResultSet rs01 = null;
ResultSet rs02 = null;
ResultSet rs03 = null;
ResultSet rs04 = null;
ResultSet rs05 = null;
%>


<%
//Recupera o ID do Serviço trazido via URL e atribui ao objeto servico
servico.servicoID = Integer.parseInt(request.getParameter("servicoID"));
%>


<%
//Pesquisa informaçoes sobre o Serviço
rs = st.executeQuery(servico.pesquisaServico());
%>


<%
//Psquisa todos os itens adicionados ao Serviço
servicoitem.servico.servicoID = servico.servicoID;
rs01 = st01.executeQuery(servicoitem.listaItens());
%>


<%
//Pesquisa todos os produtos adicionados ao Servico
servicoproduto.servico.servicoID = servico.servicoID;
rs02 = st02.executeQuery(servicoproduto.listaProdutos());
%>


<%
//Pesquisa todos os servicos por metro quadrado adicionados ao Servico
servicometroquadrado.servico.servicoID = servico.servicoID;
rs03 = st03.executeQuery(servicometroquadrado.listaItens());
%>

<%
//Pesquisa todos os servicos por porcentagem adicionados ao Servico
servicoporcentagem.servico.servicoID = servico.servicoID;
rs04 = st04.executeQuery(servicoporcentagem.listaItens());
%>

<%
//Pesquisa os dados da Empresa para colocar no Cupom
empresa.empresaID = Integer.parseInt((String)session.getAttribute("empresaID"));
rs05 = st05.executeQuery(empresa.dadosGerais());
%>


<%
//Usado para formatar Valores
Currency currency = Currency.getInstance("BRL");     
DecimalFormat formato = new DecimalFormat("R$ #,##0.00");
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Currency"%>
<%@page import="java.text.DecimalFormat"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Imprimir Cupom</title>

<script type="text/javascript">

function imprimirCupom(){
	window.print();
	//fechar();
}

function fechar(){
	window.location.href="sis_view_orcamento_servicos.jsp";	
}

</script>

</head>
<body bgcolor="#EEEEEE" onLoad="javascript: imprimirCupom()">

<div id="cupom" style="background-color:#FFFFFF; width:630px; font-family:Verdana, Geneva, sans-serif; font-size:11px; margin-left:auto; margin-right:auto">

<table width="590" align="center">

<tr bgcolor="#EEEEEE">
  <td height="20" colspan="3" align="center"><font size="6"><strong>O R &Ccedil; A M E N T O</strong></font></td>
</tr>
<%if(rs05.next()){ %>
<tr>
  <td width="142" height="20" rowspan="7" align="left" valign="top"><img src="relatorios/images/logo_relatorio.png" border="0" title="Iprimir Relatorio"></td>
  <td colspan="2" width="737" height="9" align="center"><strong><%=rs05.getString("razaoSocial") %></strong></td>
  </tr>
<tr>
  <td colspan="2" height="9" align="center"><%=rs05.getString("rua") %>, <%=rs05.getString("numero") %> - CEP:<%=rs05.getString("cep") %> </td>
  </tr>
<tr>
  <td colspan="2" height="9" align="center"><%=rs05.getString("bairro") %>, <%=rs05.getString("cidade") %> - <%=rs05.getString("uf") %></td>
  </tr>
<tr>
  <td colspan="2" height="20" align="center">CNPJ: <%=rs05.getString("cnpj") %> - Insc. Estadual: <%=rs05.getString("inscEstadual") %></td>
  </tr>
<tr>
  <td colspan="2" height="20" align="center">Tel:<%=rs05.getString("telefone") %>&nbsp;&nbsp;Cel:<%=rs05.getString("celular") %></td>
  </tr>
<tr>
  <td colspan="2" height="20" align="center">E-mail:<%=rs05.getString("email") %></td>
  </tr>
<tr>
  <td colspan="2" height="20" align="center"><%=rs05.getString("site") %></td>
  </tr>
<%}%>
<tr>
 <td colspan="3" height="20"></td>
</tr>


<tr>
  <td align="center" colspan="3">
  <%if(rs.next()){%>
    <table width="577" align="center" cellpadding="2" cellspacing="2">
      <tr bgcolor="#EEEEEE">
        <td colspan="4" align="center"><strong>DETALHES</strong></td>
      </tr>
      <tr>
        <td width="116" align="left">N&deg; Or&ccedil;amento</td>
        <td width="152" align="left"><%=rs.getString("orcamento") %>/<%=rs.getString("dataInicio").substring(0,4)%></td>
        <td width="40" align="left">Cliente</td>
        <td width="241" align="left"><%=rs.getString("clienteNomeFantasia") %></td>
      </tr>
      <tr>
        <td align="left">Inicio</td>
        <td align="left"><%=data.converteDeData(rs.getString("dataInicio")) %></td>
        <td colspan="2" align="left">&Uacute;ltima Altera&ccedil;&atilde;o&nbsp; &nbsp; <%=data.converteDeData(String.valueOf(rs.getDate("dataFim"))) %></td>
      </tr>
      <tr bgcolor="#F9F6F2">
        <td align="left">VALOR TOTAL</td>
        <td align="left"><font color="#009900"><strong><%=formato.format(rs.getDouble("valor")+rs.getDouble("entradaAd")) %></strong></font></td>
        <td colspan="2" align="right">&nbsp;</td>
      </tr>
      <%if(rs.getString("tipo").equals("C")){%>
      <tr bgcolor="#F9F6F2">
        <td align="left">ADIANTAMENTO</td>
        <td align="left"><font color="#009900"><strong><%=formato.format(rs.getDouble("entradaAd")) %></strong></font></td>
        <td colspan="2" align="left">SALDO DEVEDOR &nbsp;<font color="#FF0000"><%=formato.format(rs.getDouble("valor")-rs.getDouble("pagoNaAprovacao"))%></font> &nbsp;|&nbsp;PAGO NA ASSINATURA&nbsp;<font color="#009900"><%=formato.format(rs.getDouble("pagoNaAprovacao"))%></font></td>
      </tr>
      <%}%>
      <tr bgcolor="#66FF99">
        <td colspan="4" align="center">N&uacute;mero ART <strong><%=rs.getString("numeroART")%></strong></td>
      </tr>
      <tr bgcolor="#FFFF99">
        <td colspan="4" align="center">Descri&ccedil;&atilde;o do Servi&ccedil;o</td>
      </tr>
      <tr>
        <td colspan="4" align="center"><pre style="white-space:pre-line; width:500px; text-align:left"><%=rs.getString("descricao")%></pre>
        </td>
      </tr>
      <tr>
        <td colspan="4" align="center"><hr color="#FFFF99" /></td>
      </tr>
      <tr>
        <td colspan="4" align="center" bgcolor="#52658C"><font color="#FFFFFF">Servi&ccedil;o por m&sup2; (metro quadrado)</font></td>
      </tr>
      <tr>
        <td colspan="4" align="center"><table width="540" align="center">
            <%while(rs03.next()){%>
            <tr>
              <td align="left"><%=rs03.getString("descricao") %></td>
              <td align="right"><%=formato.format(rs03.getDouble("valor")) %></td>
              </tr>
            <tr>
              <td align="center" colspan="2"><hr style="border:1px solid #CCCCCC" /></td>
            </tr>
            <%} %>
        </table></td>
      </tr>
      <tr>
        <td align="left">&nbsp;</td>
        <td align="left">&nbsp;</td>
        <td align="left">&nbsp;</td>
        <td align="left">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="4" align="center" bgcolor="#52658C"><font color="#FFFFFF">Servi&ccedil;o por % (porcentagem)</font></td>
      </tr>
      <tr>
        <td colspan="4" align="center"><table width="540" align="center">
            <%while(rs04.next()){%>
            <tr>
              <td align="left"><%=rs04.getString("descricao")%></td>
              <td align="right"><%=formato.format(rs04.getDouble("valor"))%></td>
              </tr>
            <tr>
              <td align="center" colspan="2"><hr style="border:1px solid #CCCCCC" /></td>
            </tr>
            <%}%>
        </table></td>
      </tr>
      <tr>
        <td align="left">&nbsp;</td>
        <td align="left">&nbsp;</td>
        <td align="left">&nbsp;</td>
        <td align="left">&nbsp;</td>
      </tr>
      <tr valign="middle">
        <td colspan="4" align="center" bgcolor="#52658C"><font color="#FFFFFF">O</font><font color="#FFFFFF">utros Servi&ccedil;os</font></td>
      </tr>
      <tr>
        <td colspan="4" align="center"><table width="540" align="center">
            <%
        while (rs01.next()) {
        %>
            <tr>
              <td align="left"><%=rs01.getString("descricao")%></td>
              <td align="right"><%=formato.format(rs01.getDouble("valor"))%></td>
              </tr>
            <tr>
              <td align="center" colspan="2"><hr style="border:1px solid #CCCCCC" /></td>
            </tr>
            <%
         }
         %>
        </table></td>
      </tr>
      <tr>
        <td align="left">&nbsp;</td>
        <td align="left">&nbsp;</td>
        <td align="left">&nbsp;</td>
        <td align="left">&nbsp;</td>
      </tr>
      <tr align="center" valign="middle" bgcolor="#52658C">
        <td colspan="4"><font color="#FFFFFF">Adicionar Produto</font></td>
      </tr>
      <tr>
        <td colspan="4" align="center"><table width="540" align="center">
            <%
        while (rs02.next()) {
        %>
            <tr>
              <td align="left"><%=rs02.getString("nome")%></td>
              <td align="right"><%=formato.format(rs02.getDouble("valor"))%></td>
              </tr>
            <tr>
              <td align="center" colspan="2"><hr style="border:1px solid #CCCCCC" /></td>
            </tr>
            <%
         }
         %>
        </table></td>
      </tr>
      <tr>
        <td align="left">&nbsp;</td>
        <td align="left">&nbsp;</td>
        <td align="left">&nbsp;</td>
        <td align="left">&nbsp;</td>
      </tr>
    </table>  
    <%}%>
    
    </td>
</tr>
<tr>
  <td align="left" colspan="3"><hr></td>
</tr>
<tr>
  <td colspan="3"><a href="sis_view_orcamento_servicos.jsp" title="Fechar">[x]</a></td>
</tr>
</table>

</div>

</body>
</html>