<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Report</title>
</head>
<body background="back.jpg" style="color:white">

<h1 style="text-align:center;color:white">Employee management system</h1></br>
<h1 style="text-align:center;color:white">List View</h1>

 <%@ page language="java" %>
        <%@ page import="java.sql.*" %>
         <%@ page import="java.io.*" %>
         
         <%
     	try
     	{
     		String SQL="select * from emp_details where reporting_man='-'";
     		Class.forName("com.mysql.jdbc.Driver");
     		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ems", "root","root");
     		Statement stmt=con.createStatement();
     		ResultSet rs=stmt.executeQuery(SQL);
     		rs.next();
     		String empname=rs.getString(2);
     		String sql="select * from emp_details where reporting_man='"+empname+"'";
 			ResultSet r1=stmt.executeQuery(sql);
     	%><ul>	
     		<li><%= empname %>
     		<ul>
     	<%	while(r1.next())
     		{
     	%>	
     	<li><%= r1.getString(2) %>
     		<% 
     		String sql1="select * from emp_details where reporting_man='"+r1.getString(2)+"'";
     			ResultSet r11=stmt.executeQuery(sql1);
     		%>
     		<ul><%
     			while(r11.next()){
     			%>
     			<li><%= r11.getString(2) %>
     			<%} %>
     	</li>	
     	</ul>	
     	<%		
     			}
     	%></ul>
         </li>
        </ul> 
         
         <%
     	rs.close();
     	stmt.close();
     	con.close();
     	}
     catch(Exception e){
    	 e.printStackTrace();
     }
     %>
     </form></br></br>
     <a href="home.html"><button>Back</button></a>
     
     </div>
</body>
</html>	