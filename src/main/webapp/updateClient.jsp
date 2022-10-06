<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="net.javaguides.tutorial.service.ClientCRUDService"%>  
<jsp:useBean id="client" class="net.javaguides.tutorial.model.Client"></jsp:useBean>  
<jsp:setProperty property="*" name="client"/>  
<%  
int i=ClientCRUDService.update(client);  
response.sendRedirect("client.jsp");  
%> 

</body>
</html>