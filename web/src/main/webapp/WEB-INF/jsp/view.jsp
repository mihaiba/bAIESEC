<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="contact" scope="request" type="com.levi9.baisec.web.controllers.models.Contact"/>

<html>
<head>
  <title>View Contact</title>
</head>
<body>
<h1>View Contact</h1>

<h2><c:out value="${contact.name}"/></h2>

<p>Phone Number: ${contact.phone}</p>

<p>Address: ${contact.address}</p>

<p>Date of Birth: ${contact.dateOfBirth}</p>
</body>
</html>