<jsp:useBean id="log" class="com.datta.project.LoginBean" scope="request">
<jsp:setProperty name="log" property="*"/>
</jsp:useBean>
<jsp:forward page="Login.do"></jsp:forward>