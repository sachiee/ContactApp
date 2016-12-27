<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="ccff66">
<center><h1><font color="red">Search Contact</font></h1></center>
<center>
<form action="Search.do">
<input type="text" name="searchitem"placeholder="Enter Wt to search,.."/>
<input type="submit"/>
</form>
<h1>${error }</h1>
</center>

</body>
</html>