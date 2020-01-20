<%@page import="java.sql.ResultSet"%>
<%@page import="com.database.DatabaseConnction"%>
<%@page import="com.dao.DAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
</head>
<body>
	
	<%!
	String adminName = null;
	String adminId = null;
	%>

	<%
	adminName = "admin";
	if(adminName == null) {
		response.sendRedirect("AdminLoginPage.jsp");
	} else {
	%>
		<jsp:useBean id="hod" class="com.data.beans.HeadOfDept"></jsp:useBean>
		<div>
			<h3>Hello <%= adminName %> </h3>
		</div>
		<div>
			<form action="" method="GET">
				<label for="hodName"> HOD Name : </label>
				<input id="hodName" type="text" name="hodName" value='<jsp:getProperty name="hod" property = "hodName"/>'/>
				<br/>
				<label for="hodPwd"> HOD Password : </label>
				<input id="hodPwd" type="password" name="hodPassword"value='<jsp:getProperty name="hod" property = "hodPwd"/>'/>
				<br/>
				<label for="hodEmail"> HOD Email : </label>
				<input id="hodEmail" type="email" name="hodEmail" value='<jsp:getProperty name="hod" property = "hodEmail"/>'/>
				<br/>
				<label for="hodDeptId"> HOD Department : </label>
				<select id="hodDeptId" name="hodDeptId">
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

				<input id="" type="submit" name="add_hod"/>
			</form>
			<jsp:setProperty property="*" name="hod"/>
			<%
				System.out.println(hod);
			%>
		</div>
	<%
	
	}
	%>
</body>
</html>