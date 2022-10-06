<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Actions Example</title>
</head>
<body>

<h1> Adding new Client Entries Page</h1>
 <form action="<%= request.getContextPath() %>/Clients" method="post">
  id: <input type="text" name="id">
  <br> <br> 
  
  First Name: <input type="text" name="firstName">
  <br> <br> 
  
  Last Name: <input type="text" name="lastName">
  <br> <br> 
  
  Email: <input type="email" name="email">
  <br> <br> 
  
  AmountDue : <input type="text" name="amountDue">
  <br> <br> 
  
  <input type="submit" value="Add">
 </form>
</body>
</html>
