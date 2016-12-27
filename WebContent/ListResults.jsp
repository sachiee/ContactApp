<%@page import="java.lang.annotation.Target"%>
<%@page import="javax.servlet.descriptor.TaglibDescriptor"%>
<%@page import="com.datta.project.AddContactBean" import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="ccff66">

<center><h1><font color="red">List Of Contacts</font></h1></center>
<br />
<br />
<%-- <%

List<AddContactBean> list=(List<AddContactBean>)request.getAttribute("showlist");

for(AddContactBean ab:list)
{
out.println(ab);

out.println("<hr>");
}
%> --%>
<center>
<table border="1"  cellpadding="10" >
<tr>
<td>Name</td>
<td>Email ID</td>
<td>PhoneNum</td>
<td>Tags</td>
<td>Date Of Birth</td>
<td>Gender</td>
</tr>

<d:forEach items="${requestScope.showlist}" var="bean">
<tr>
<td>${bean.conname }</td>
<td>${bean.email }</td>
<td>${bean.ph }</td>
<td>${bean.tag }</td>
<td>${bean.dob }</td>
<td>${bean.gender }</td>
</tr>
</d:forEach>
</table>
</center>


</body>
</html>