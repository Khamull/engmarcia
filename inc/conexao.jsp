<%
Connection con = null;
Statement st = null;

//CONEXAO PARA HOSPEDAGEM
//Class.forName("org.gjt.mm.mysql.Driver");
//con = DriverManager.getConnection("jdbc:mysql://mysql.fortesystem.net.br/fortesystem06", "fortesystem06", "eng123");
//st=con.createStatement();


//CONEXAO PARA PC-ALMIR
Class.forName("org.gjt.mm.mysql.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/engmarcia","root","");
st=con.createStatement();

%>