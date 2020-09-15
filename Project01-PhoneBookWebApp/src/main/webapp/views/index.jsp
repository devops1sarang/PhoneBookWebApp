<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome To Phone Book App!</h1>
	<font color="green">${saveMsg}</font>
	<font color="red">${errMsg}</font>

	<form:form action="saveContact" method="POST" modelAttribute="contact">
		<table>
			<tr>
				<td>Contact Name</td>
				<td><form:input path="cname" /></td>
				<form:hidden path="cid"/>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><form:input path="cnum" /></td>
			</tr>
			<tr>
				<td>Contact Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>
	<a href="viewContacts">View All Contacts</a>

</body>
</html>