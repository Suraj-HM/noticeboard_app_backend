<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./bootstrap-4.4.1-dist/css/bootstrap.min.css"/>
<script src="./bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:useBean id="hod" class="com.data.beans.HeadOfDept"></jsp:useBean>
	<form action="" method="POST">
		<label for=""></label>
		<input id="hod_name" type="text" name="hodEmail" value='<jsp:getProperty property="hodEmail" name="hod"/>' required="required"/>
		<input id="hod_pwd" type="password" name="hodPwd" value='<jsp:getProperty property="hodPwd" name="hod"/>' required="required"/>
		<input type="submit" value="Login" name="hod_login"/>
	</form>
	<jsp:setProperty property="*" name="hod"/>
	<%
	if(request.getParameter("hod_login") != null) {
		System.out.println(hod);
		if(hod.checkUser()) {
			session.setAttribute("hodEmail", hod.getHodEmail());
			response.sendRedirect("HodHomePage.jsp");
		}
	}
	%>
</body>
</html>