<jsp:useBean id="reg" class="com.datta.project.RegBean" scope="request">
<jsp:setProperty name="reg" property="*"/>
</jsp:useBean>
<jsp:forward page="Register.do"></jsp:forward>