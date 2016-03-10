<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="contact" scope="request"
	type="com.levi9.baisec.web.controllers.models.Contact" />

<html>
<head>
<title>View Contact</title>
</head>
<body>
	<h1>View Contact</h1>
	<table border="1">
		<tbody>
			<tr>
				<td>First Name</td>
				<td>${contact.firstName}</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>${contact.lastName}</td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td>${contact.phoneNumber}</td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td>${contact.birthDay}</td>
			</tr>
		</tbody>
	</table>
	<p>
		<a href="<c:url value="/contacts/list"/>">Go to list</a>
	</p>
</body>
</html>