<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="./bootstrap-4.4.1-dist/css/bootstrap.min.css"/>
<script src="./bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:useBean id="admin" class="com.data.beans.Admin"></jsp:useBean>
	<form action="" method="POST">
		<label for=""></label>
		<input id="admin_name" type="text" name="adminName" value='<jsp:getProperty property="adminName" name="admin"/>' required="required"/>
		<input id="admin_pwd" type="password" name="adminPwd" value='<jsp:getProperty property="adminPwd" name="admin"/>' required="required"/>
		<input type="submit" value="Login" name="admin_login"/>
	</form>
	<jsp:setProperty property="*" name="admin"/>
	
	<%
	if(request.getParameter("admin_login") != null) {
		System.out.println(admin);
		if(admin.checkUser()) {
			session.setAttribute("adminName", admin.getAdminName());
			response.sendRedirect("AdminHomePage.jsp");
		}
	}
	%>
</body>
</html>