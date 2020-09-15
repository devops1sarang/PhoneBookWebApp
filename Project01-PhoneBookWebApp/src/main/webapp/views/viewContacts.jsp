<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deleteConfirm() {
		return confirm("Are you sure,you want to delete?");
	}
</script>
</head>
<body>
	<h2>View Contacts here</h2>

	<a href="/">+ Add New Contact</a>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Contact Number</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${contacts}" var="ctc">
			<tr>
				<td>${ctc.cname}</td>
				<td>${ctc.email}</td>
				<td>${ctc.cnum}</td>

				<td><a href="editContact?cid=${ctc.cid}">Edit</a> <a
					href="deleteContact?cid=${ctc.cid}" onclick="return deleteConfirm()">Delete</a></td>

			</tr>
		</c:forEach>
	</table>


</body>
</html>