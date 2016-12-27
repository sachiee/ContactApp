<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="ccff66">
<center><h1><font color="red">Edit or Delete Contacts</font></h1></center>
<center>
<table border="1"  cellpadding="10" >
<tr>
<td>Name</td>
<td>Email ID</td>
<td>PhoneNum</td>
<td>Tags</td>
<td>Date Of Birth</td>
<td>Gender</td>
<td>EDIT</td>
<td>DELETE</td>
</tr>
<d:forEach items="${editablelist }" var="temp">
<tr>
<td>${temp.conname}</td>
<td>${temp.email }</td>
<td>${temp.ph }</td>
<td>${temp.tag }</td>
<td>${temp.dob }</td>
<td>${temp.gender }</td>
<td><a href="updateContactView.do?phonenum=${temp.ph }"><input type="button" value="Edit"></input></a></td>
<td><a href="deleteContactView.do?phonenum=${temp.ph }"><input type="button" value="Delete"></input></a></td>
</tr>
</d:forEach>
</table>
${msguu }
</center>
</body>
</html>