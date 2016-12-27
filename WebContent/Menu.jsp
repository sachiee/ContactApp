<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="ccff66">
<center><h1><font color="red">WelCome to Contact Menu ${loggedin.email}</font></h1></center>
<br/>
<br/>
<h2 style="float: left;"><a href="OpenEditView.do">Click here to Edit Your Account </a></h2>
<h2 style="float: right;"><a href="Logout.do">Click here to Logout</a></h2>
<br/>
<br/>
<center>
<br />
<br />
<h2><a href="openAddContactView.do"> Add Contact</a><br/><br/></h2>
<h2><a href="openContactListView.do"> Contact List</a><br/><br/></h2>
<h2><a href="openSearchView.do"> Search Contact</a><br/><br/></h2>
<h2><a href="openEditContactView.do"> Edit Contact</a><br/><br/></h2>
</center>

</body>
</html>