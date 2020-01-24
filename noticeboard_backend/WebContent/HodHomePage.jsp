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
	<%!
	String hodEmail = null;
	%>

	<%
	hodEmail = (String)session.getAttribute("hodEmail");
	if(hodEmail == null) {
		response.sendRedirect("HodLoginPage.jsp");
	} else {
		out.println("Hello : " + hodEmail.substring(0, hodEmail.indexOf('@')));
	%>
		<jsp:useBean id="notice" class="com.data.beans.Notice"></jsp:useBean>
		<form action="" method="GET">
			<label for="notice_message"> New Notice : </label>
			<input id="notice_message" type="text" name="noticeMessage" value='<jsp:getProperty name="notice" property = "noticeMessage"/>' required="required"/>
			<br/>
			<label> Notice Department : </label> <br/>
				<label for="noticeDeptId">ISE : </label>
				<input type="radio" name="noticeDeptId" value="2" /> <br/>
				<label for="noticeDeptId">ALL : </label>
				<input type="radio" name="noticeDeptId" value="0" /> <br/>
			<input id="addNotice" type="submit" name="add_hod" value="add_hod"/>
		</form>
		<jsp:setProperty property="*" name="notice"/>
	<%
		if(request.getAttribute("add_hod") != null) {
			if(notice.insertEntity()) {
				request.removeAttribute("add_hod");
			} else {
				%>
				<script type="text/javascript">
					alert("Not inserted")
				</script> 
				<%
			}
		}
	}
	%>
</body>
</html>