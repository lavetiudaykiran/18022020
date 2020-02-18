<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
    function myFunction() {
        var pass1 = document.getElementById("password").value;
        var pass2 = document.getElementById("cp").value;
        if (pass1 != pass2) {
            alert("Passwords Do not match");
           // document.getElementById("userregn.jsp").submit();
            document.getElementById("password").style.borderColor = "#E34234";
            document.getElementById("cp").style.borderColor = "#E34234";
        }
        else {
            alert("Passwords Match!!!");
            document.getElementById("ureg").submit();
        }
    }
</script>
</head>
<body>
 
<form onsubmit="return myFunction()" action="ureg">
<table>
<tr style="text-align:right"><td></td><td><a href="home">Home</a></td><td><a href="login">Login</a></td><td><a href="userregn">User Registration</a></td></tr>
<tr><td><h3>User Registration:<hr></h3></td></tr>
<tr><td>User Name:</td><td><input type="text" name="username" id="username"></td></tr>
<tr><td>PassWord:</td><td><input type="text" name="password" id="password"></td></tr>
<tr><td>Conform Password:</td><td><input type="text" name="cp" id="cp"></td></tr>
<tr><td></td><td><input type="submit" value="submit"><input type="reset" value="reset"></td></tr>
</table>

</form>
</body>
</html>