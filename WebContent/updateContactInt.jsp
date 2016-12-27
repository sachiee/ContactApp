<jsp:useBean id="conedit" class="com.datta.project.AddContactBean" scope="request">
<jsp:setProperty name="conedit" property="*"/>
</jsp:useBean>
<jsp:forward page="editContact.do"></jsp:forward>