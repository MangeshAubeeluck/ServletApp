<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>  
<body>  
<%@page import="net.javaguides.tutorial.service.ClientCRUDService,net.javaguides.tutorial.model.Client,
net.javaguides.tutorial.controller.ClientCRUDServlet"%>  
  
<%  
String id=request.getParameter("id");  
Client client=ClientCRUDService.getRecordById(Long.parseLong(id));   
%>  
<h1><%=id%></h1>
<h1>Edit Form</h1>  
<form action="updateClient.jsp" method="post">  
<input type="hidden" name="id" value="<%=client.getId()%>"/>  
<table>  
<tr><td>FirstName:</td><td>  
<input type="text" name="firstName" value="<%=client.getFirstName()%>"/></td></tr>  
<tr><td>LastName:</td><td>  
<input type="text" name="lastName" value="<%=client.getLastName()%>"/></td></tr>  
<tr><td>Email:</td><td>
<input type="email" name="email" value="<%=client.getEmail()%>"/></td></tr>  
<tr><td>AmountDue:</td><td>  
<input type="text" name="amountDue" value="<%=client.getAmountDue()%>"/></td></tr> 
</td> </tr>  
<tr><td colspan="2"><input type="submit" value="Update Client"/></td></tr>  
</table>  
</form> 

  
</body>  
</html>