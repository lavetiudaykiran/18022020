<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr style="text-align:right"><td></td><td><a href="home">Home</a></td><td><a href="addpet">Add Pet</a></td><td><a href="logout">Logout </a></td></tr>
</table>
<h3>Pet Information</h3>
<form action="updatepet">
<table>
<tr><td>PetName:</td><td><input type="text" name="petname"></td></tr>
<tr><td>PetAge:</td><td><input type="text" name="petage"></td></tr>
<tr><td>PetPlace:</td><td><input type="text" name="petplace"></td></tr>
<tr><td><input type="submit" value="save"></td></tr>
</table>
</form>
</body>
</html>