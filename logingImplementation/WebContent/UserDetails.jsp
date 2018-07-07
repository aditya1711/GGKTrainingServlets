<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@
	page import = "java.util.*"
 %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%!
		
	%>
	<%
			ArrayList<String[]> active = (ArrayList<String[]>)(request.getAttribute("modelActive"));
			ArrayList<String[]> inActive = (ArrayList<String[]>)(request.getAttribute("modelInActive"));
	%>
	
	ACTIVE
	<br>
	
	<table style ="width=100%">
		<tr>
			<th>Username</th>
			<th>Active Since</th>
			<th>Request Count</th>
			<th>Error Count</th>
		</tr>
		<%
			if(active.size()>0){
				for(int i=0;i< active.size();i++){
					out.print("<tr>");
					out.print("<td>" + active.get(i)[0] + "</td");
					out.print("<td>" + active.get(i)[1] + "</td>");
					out.print("<td>" + active.get(i)[2] + "</td>");
					out.print("<td>" + active.get(i)[3] + "</td>");
					out.print("</tr>");
				}
			}
			
		%>
	</table>
	<br>
	
	INACTIVE
	<br>
	
	<table style ="width=100%">
		<tr>
			<th>Username</th>
			<th>Last Seen</th>
			<th>Request Count</th>
			<th>Error Count</th>
		</tr>
		<%
			if(inActive.size()>0){
				for(int i=0;i< inActive.size();i++){
					out.print("<tr>");
					out.print("<td>" + inActive.get(i)[0] + "</td");
					out.print("<td>" + inActive.get(i)[1] + "</td>");
					out.print("<td>" + inActive.get(i)[2] + "</td>");
					out.print("<td>" + inActive.get(i)[3] + "</td>");
					out.print("</tr>");
				}
			}
			
		%>
	</table>
	
	
</body>
</html>