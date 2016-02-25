<jsp:useBean id="contact" class="com.levi9.baisec.web.controllers.Contact"/>
<html>
<head>
  <title>View Contact</title>
</head>
<body>
<h1>View Contact</h1>

<h2>${contact.name}</h2>

<p>Phone Number: ${contact.phone}</p>

<p>Address: ${contact.address}</p>

<p>Date of Birth: ${contact.dateOfBirth}</p>
</body>
</html>