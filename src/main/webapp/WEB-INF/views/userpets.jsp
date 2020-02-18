<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr style="text-align:right"><td></td><td><a href="home">Home</a></td><td><a href="mypet">My Pets</a></td><td><a href="addpet">Add Pet</a></td><td><a href="logout">Logout </a></td></tr>

</table>
<table border="1">
<tr>
<th>#</th>
<th>Pet Name</th>
<th>Pet Age</th>
<th>Pet Place</th>

</tr>


<c:forEach var="pets" items="${ userpetlist }">
<tr>
<td>${pets.getId() }</td>
<td>${pets.getPetname() }</td>
<td>${pets.getPetage() }</td>
<td>${pets.getPetplace() }</td>
</tr>
</c:forEach>


</table>
</body>
</html>