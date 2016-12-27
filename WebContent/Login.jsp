<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="ccff66">
<center><h1><font color="red">Login to Your Account</font></h1>
<form action="LoginInt.jsp" method="post">
Enter Email id: <input type="text" name="email" value="${param.email }"placeholder="Email id"><br/> <br/>     
Enter PassWord: <input type="password" name="pwd" value="${param.pwd }"placeholder="Pass Word"><br/>    <br/>
<br/>
<input type="submit" value="Submit to login"/>
</form>
<h2>${errormsg}</h2>  
<h2>${msg}</h2> 
</center>
</body>
</html>