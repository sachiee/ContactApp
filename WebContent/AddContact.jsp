<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="ccff66">
<center><h1><font color="red">Add Contact</font></h1></center><br /><br />
<center>
<form action="AddContactInt.jsp" method="post">
Enter Name :  <input type="text" name="conname" value="${param.conname }" placeholder="Name of Contact"/><br /><br />
Enter Email:  <input type="email" name="email" value="${param.email }"placeholder="Email id"/><br /><br />
Phone Numb :  <input type="text" name="ph" value="${param.ph }"placeholder="phone number"/><br /><br />
Enter Tags :  <input type="text" name="tag" value="${param.tag }"placeholder="Name of tags"/><br /><br />
Enter Dateof Birth :     <input type="date" name="dob" value="${param.dob }"/><br /><br />
Gender: 
 Female <input type="radio" name="gender" value="female"/>
 Male <input type="radio" name="gender" value="male"/>
 <br />
 <br />
 <input type="submit"/>
</form>
</center>

<h4>${errormsg}</h4>
</body>
</html>