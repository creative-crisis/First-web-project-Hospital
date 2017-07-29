<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" cols="2" width="100%">
    <td>
        <div style="width: 100%; height: 100%; overflow: auto">
            <p><img src="/resources/images/scrubs.jpg" width="100%"></p>
            <h1 align="right">Add new doctor
            <a href="/add">
                <img src="/resources/images/add-button.png" width="5%">
            </a></h1>

            <form method="get" action="/list/{id}">
                <h3>Select the specialization:</h3>
                <br> <input type="radio" name="id" value="0" /> all </br>
                <br>
                 <c:forEach var="department" items="${depList}">
                     <input type="radio" name="id" value="${department.getId()}" /> ${department.getName()}
                 </c:forEach>
                </br>
                <p><input type="submit"></p>
            </form>

        </div>
    </td>
    <td>
        <div style="width: 100%; height: 400pt; overflow: auto">
        <table border="1" width="100%">
            <c:forEach var="doctor" items="${docList}">
                <tr>
                    <td>${doctor.getFirstName()} ${doctor.getLastName()}</td>
                    <td>${doctor.getSpecialization()}</td>
                    <td>
                        <form method="get" action="/edit/{id}">
                        <input name="id" value="${doctor.getId()}" hidden />
                        <input type="submit" value="редактировать" />
                        </form>
                    </td>
                    <td>
                        <form method="post">
                        <input  name="id" value="${doctor.getId()}" hidden />
                        <input type="submit"  name="change" value="уволить" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </td>
</table>

</body>
</html>
