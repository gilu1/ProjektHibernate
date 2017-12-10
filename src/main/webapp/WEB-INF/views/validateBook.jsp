<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot</title>
</head>
<body>

<style>
.error{
	text-decoration:underline; 
	color: red; 
	font-size: 15px;
}
</style>

  <h1>Spring Boot - MVC web application example</h1>
  
  	<form:form method="post" action="validBook" modelAttribute="book">
  		Title:
		<form:input path="title" />
		<form:errors path="title" cssClass="error" /></br>
		
		Rating:
		<form:input path="rating" />
		<form:errors path="rating" cssClass="error" /></br>
		
		Desc:
		<form:input path="description" />
		<form:errors path="description" cssClass="error" /></br>
		
		Author:
		<form:input path="author" />
		<form:errors path="author" cssClass="error" /></br>
		
		Publisher:
		<form:input path="publisher" />
		<form:errors path="publisher" cssClass="error" /></br>
		
		<input type="submit" value="Save">
	</form:form>
  
</body>
</html>