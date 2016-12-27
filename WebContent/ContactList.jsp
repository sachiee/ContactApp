<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="ccff66">
<center><font color="red"><h1>Select the List Of Contacts</h1></font>
<br />
<br />
<form action="ContactList.do">
ListBy:
<select name="option">
<option value="name">Contact Name</option>
<option value="email">Email ID</option>
<option value="tag">Tags</option>
<option value="din">Date Of Birth</option>
</select>
<input type="submit">
</form>
</center>

</body>
</html>