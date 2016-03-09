<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:choose>
<c:when test="${mode == 'edit'}">
  <title>Edit Contact</title>
 </c:when>
 <c:otherwise>
 <title>Add Contact</title>
 </c:otherwise>
</c:choose>
</head>
<body>
<h1>Edit Contact</h1>
<form:form commandName="contact">
  <form:input path="firstName"/><br />
  <form:input path="lastName"/><br />
  <form:input path="phoneNumber"/><br />
  <form:input path="birthDay"/><br />
  <form:hidden path="id"/>
  <input type="submit" value="Update"/>
</form:form>
<p><a href="<c:url value="/contacts/list"/>">Cancel</a></p>
</body>
</html>