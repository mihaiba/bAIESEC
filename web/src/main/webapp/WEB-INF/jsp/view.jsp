<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="contact" scope="request" type="com.levi9.baisec.web.controllers.models.Contact"/>

<html>
<head>
  <title>View Contact</title>
</head>
<body>
<h1>View Contact</h1>

<h2>${contact.firstName} ${contact.lastName}</h2>

<p>Phone Number: ${contact.phoneNumber}</p>

<p>Date of Birth: ${contact.birthDay}</p>
<p><a href="<c:url value="/contacts/list"/>">Go to list</a></p>
</body>
</html>