<%@page import="java.sql.ResultSet"%>
<%@page import="com.database.DatabaseConnction"%>
<%@page import="com.dao.DAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<link rel="stylesheet" href="./bootstrap-4.4.1-dist/css/bootstrap.min.css"/>
<script src="./bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
	
	<%!
	String adminName = null;
	String adminId = null;
	%>

	<%
	// adminName = (String)session.getAttribute("adminName");
	adminName = "admin";
	if(adminName == null) {
		response.sendRedirect("AdminLoginPage.jsp");
	} else {
	%>
		<jsp:useBean id="hod" class="com.data.beans.HeadOfDept"></jsp:useBean>
		<div>
			<h3>Hello Admin <%= adminName %> </h3>
		</div>
		<div>
			<form action="" method="GET">
				<label for="hodName"> HOD Name : </label>
				<input id="hodName" type="text" name="hodName" value='<jsp:getProperty name="hod" property = "hodName"/>' required="required"/>
				<br/>
				<label for="hodPwd"> HOD Password : </label>
				<input id="hodPwd" type="password" name="hodPwd" value='<jsp:getProperty name="hod" property = "hodPwd"/>' required="required"/>
				<br/>
				<label for="hodEmail"> HOD Email : </label>
				<input id="hodEmail" type="email" name="hodEmail" value='<jsp:getProperty name="hod" property = "hodEmail"/>' required="required"/>
				<br/>
				<label for="hodDeptId"> HOD Department : </label>
				<select id="hodDeptId" name="hodDeptId" required="required">
					<option value="none" selected disabled hidden="true"> SELECT DEPT </option>
					<%
					DAO dao = new DatabaseConnction();
					ResultSet rs = dao.getData(
						"SELECT * FROM departments WHERE dept_name != 'ALL' AND dept_id NOT IN " + 
						"(SELECT hod_dept_id FROM head_of_dept)"
						);
					 do {
						%>
							<option value="<%= rs.getString("dept_id") %>"> <%=rs.getString("dept_name") %></option>
						<%
					} while(rs.next());
					%>
				</select>
				<br/>
				<input id="" type="submit" name="add_hod" value="add_hod"/>
			</form>
			<jsp:setProperty property="*" name="hod"/>
			<%
				System.out.println(hod);
			%>
			<%
			if(request.getParameter("add_hod") != null) {
				if(hod.insertEntity()) {
					System.out.println("inserted");
					response.sendRedirect("AdminHomePage.jsp");
				} else {
					System.out.println("fail");
					response.sendRedirect("AdminHomePage.jsp");
				}
			}
			%>
		</div>
	<%
	}
	%>
</body>
</html>