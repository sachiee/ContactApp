<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="ccff66">
<center>
<h1><font color="red">Welcome to Register</font></h1>
<br />
<form action="RegInt.jsp" method="post">
Enter Name :     <input type="text" name="uname" value='${ param.uname}'required placeholder="Enter Name" ><br/><br/>
Enter Email:     <input type="email" name="email" value='${param.email}'placeholder="Enter Email"><br/><br/>
Enter Password:  <input type="password" name="pwd" value='${param.pwd}'placeholder="Enter password"><br/><br/>
Repeat Password: <input type="password" name="rpwd" value='${param.rpwd}'placeholder="Repeat Password"/><br/>
	<br/><br/>
<input type="submit"/>
</form>
<h4>${ErrorMsg}</h4>  
</center>

</body>
</html>