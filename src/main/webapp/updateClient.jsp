<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.math.BigDecimal"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@page import="net.javaguides.tutorial.service.ClientCRUDService"%>

	<%
		String amountDue = request.getParameter("amountDue");
	%>

	<jsp:useBean id="client" class="net.javaguides.tutorial.model.Client">
		<jsp:setProperty property="firstName" name="client" />
		<jsp:setProperty property="lastName" name="client" />
		<jsp:setProperty property="email" name="client" />
		<jsp:setProperty property="amountDue" name="client"
			value="<%=new BigDecimal(amountDue)%>" />
		<jsp:setProperty property="id" name="client" />
	</jsp:useBean>

	<%
		int i = ClientCRUDService.update(client);
	response.sendRedirect("Clients");
	%>

</body>
</html>