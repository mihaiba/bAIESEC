<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Edit Contact</title>
</head>
<body>
<h1>Edit Contact</h1>
<form:form commandName="contact">
  <form:input path="name"/><br />
  <form:input path="phone"/><br />
  <form:input path="address"/><br />
  <form:input path="dateOfBirth"/><br />
  <input type="submit" value="Update"/>
</form:form>
</body>
</html>