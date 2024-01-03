<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!Connection conn;

	public void jspInit() {
		try {
			Class.forName("org.h2.Driver");
			String url = "jdbc:h2:tcp://localhost/~/training";
			String user = "john";
			String password = "secret";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void jspDestroy() {
		try {
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer list</title>
</head>
<body>
	<h1>Customer list</h1>
	<hr>
	<p>Powered by JSP</p>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>City</th>
				<th>Email id</th>
				<th>Phone number</th>
			</tr>
		</thead>
		<tbody>
			<%
			try {
				PreparedStatement stmt = conn.prepareStatement("select * from customers");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt("id")%></td>
				<td><%=rs.getString("name")%></td>
				<td><%=rs.getString("city")%></td>
				<td><%=rs.getString("email")%></td>
				<td><%=rs.getString("phone")%></td>
			</tr>
			<%
			}
			rs.close();
			stmt.close();
			} catch (Exception ex) {
			ex.printStackTrace();
			}
			%>
		</tbody>
	</table>
</body>
</html>