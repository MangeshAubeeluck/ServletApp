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

<h1> Displaying</h1>
<table>
    <c:forEach items="${clients}" var="client">
        <tr>
            <td>${client.id}</td>
            <td><c:out value="${client.firstName}" /></td>
            <td><c:out value="${client.lastName}" /></td>
            <td><c:out value="${client.email}" /></td>
            <td><c:out value="${client.amountDue}" /></td>
            
        </tr>
    </c:forEach>
</table>
</body>
</html>