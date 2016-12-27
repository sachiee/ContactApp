<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
<!DOCTYPE html><!--  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="ccff66">


<center><h1><font color="red">Updating Of Contact</font></h1>

<form action="updateContactInt.jsp">
Name:<input type="text" name="conname" value="${temp.conname}"/placeholder="Name of Contact"><br/><br/>
Email:<input type="email" name="email" value="${temp.email }"/placeholder="Email id"><br/><br/>
Phone:<input type="text" name="ph" value="${temp.ph }"placeholder="Phone num"/><br/><br/>
Tags:<input type="text" name="tag" value="${temp.tag }"placeholder="Name of Tags"/><br/><br/>
DOB:<input type="date" name="dob" value="${temp.dob }"/><br/><br/>
<input type="submit">
</form>

<h1>${updation }</h1>
</center>



</body>
</html>