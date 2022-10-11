<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>Login Form</h3>
<form action="Login" method="post">
	AdminName:<input type="text" name="admin" /><br /> <br />
	AdminPassword:<input type="password" name="password" /><br /> <br />
	<input type="submit" value="login" />
</form>