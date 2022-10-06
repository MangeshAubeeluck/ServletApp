<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Actions Example</title>
</head>
<body>

<h1> Displaying clients in the database</h1>

<table border =1>
    <th>id</th><th>firstName</th><th>lastName</th><th>email</th><th>amountDue</th><th>Update</th><th>Delete</th>
    <c:forEach items="${clients}" var="client">
        <tr>
            <td>${client.id }</td>
            <td>${client.firstName }</td>
            <td>${client.lastName }</td>
            <td>${client.email }
            <td>${client.amountDue }</td>
            <td><a href="editClient.jsp?id=${client.getId()}">Update</a></td>
            <td><a href="deleteuser.jsp?id=${client.getId()}">Delete</a></td></tr> 
        
            
       </tr>
    </c:forEach>
</table>
</body>
</html>