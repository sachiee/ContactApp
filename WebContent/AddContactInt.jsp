<jsp:useBean id="addcontactu" class="com.datta.project.AddContactBean" scope="request">
<jsp:setProperty name="addcontactu" property="*"/>
</jsp:useBean>
<jsp:forward page="AddContact.do"></jsp:forward>