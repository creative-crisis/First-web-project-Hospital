<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<img src="/resources/images/love.jpg" width="100%" />

<form  method="post" >
    <p><input  name="id" value="${doctor.getId()}" hidden /></p>
    <p><input  name="firstName" value="${doctor.getFirstName()}" /></p>
    <p><input  name="lastName" value="${doctor.getLastName()}" /></p>
    <p><input  name="specialization" value="${doctor.getSpecialization()}" /></p>
    <p><input type="submit"></p>
</form>

</body>
</html>