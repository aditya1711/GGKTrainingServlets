<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! String user; %>
<%
	Cookie[] cookies = request.getCookies();

	for(int i=0;i<cookies.length;i++){
		if(cookies[i].getName().equals("username")){
			user = cookies[i].getValue();
		}
	}
	
%>
<%= "Hi " + user %>
<br>
<%= "Not you? Enter Credentials:" %>

<br><br>
<form action="LogingValidation" method="post">

Username: <input type="text" name="username">
<br>
Password: <input type="password" name="password">
<br>
<input type="submit" value="Login">
</form>
</body>
</html>