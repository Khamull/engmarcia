<table align="center">
<tr>
 <td height="25"></td>
</tr>
<tr>
 <td>
<div class="dock" id="dock">
  <div class="dock-container">
  <a class="dock-item" href="../sis_menu.jsp"><img src="../ico/ico_menu.png" alt="Principal" /><span>Menu Principal</span></a> 
  <a class="dock-item" href="../sis_view_usuarios.jsp"><img src="../ico/ico_usuarios.png" alt="Usuarios" /><span>Usu�rios</span></a> 
  <a class="dock-item" href="../sis_insert_orcamento_servico.jsp"><img src="../ico/ico_orcamentos.png" alt="Or�amentos" /><span>Or�amento</span></a>
  <a class="dock-item" href="../sis_view_contratos.jsp"><img src="../ico/ico_contrato.png" alt="Contratos" /><span>Contratos</span></a>
  <a class="dock-item" href="../sis_view_servicos.jsp"><img src="../ico/ico_servicos.png" alt="Servi�os" /><span>Servi�os</span></a>
  <a class="dock-item" href="../sis_view_clientes.jsp"><img src="../ico/ico_clientes.png" alt="Clientes" /><span>Clientes</span></a> 
  <%if(request.getQueryString() != null){%>
  	<a class="dock-item" href="<%=request.getRequestURL()+"?"+request.getQueryString()%>"><img src="../ico/ico_atualizar.png" alt="Atualizar" /><span>Atualizar</span></a> 
  <%}else{%>
  	<a class="dock-item" href="<%=request.getRequestURL()%>"><img src="../ico/ico_atualizar.png" alt="Atualizar" /><span>Atualizar</span></a>
  <%}%> 
  <a class="dock-item" href="../sis_menu.jsp?sair=ok"><img src="../ico/ico_sair.png" alt="Sair" /><span>Sair do Sistema</span></a> 
</div>
</div>
 </td>
</tr>
</table>