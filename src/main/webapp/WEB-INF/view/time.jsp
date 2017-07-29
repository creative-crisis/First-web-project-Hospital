<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/CSS/time.css">

    <script>

        function printTime1() {
            for (i = 9; i < 19; i++) {
                document.writeln('<tr>');
                for (j = 0; j < 4; j += 3) {
                    document.writeln('<td>');
                    document.writeln(i + "." + j + "0");
                    document.writeln('<input type=radio name="time" value="');
                    document.writeln("t_" + i + "_" + j);
                    document.writeln('" />');
                    document.writeln('</td>');
                }
                document.writeln('</tr>');
            }
        }

        function printTime2(t) {
            if (t === null) {
                document.writeln('<td>');
                document.writeln("wow");
                document.writeln('<input type=radio name="time" value="');
                document.writeln("wow");
                document.writeln('" />');
                document.writeln('</td>');
            }

            function printTime() {
                i = 0;
                document.getElementById("place1").innerHTML = "";
                <c:forEach var="t" items="${timetab}">
                if (t === null)
                {
                    document.getElementById("place1").innerHTML += '<p>';
                    document.getElementById("place1").innerHTML +=
                        '<input type="radio" name="time" value="';
                    document.getElementById("place1").innerHTML += ++i;
                    document.getElementById("place1").innerHTML += '" />';
                    document.getElementById("place1").innerHTML += " " + i;
                    document.getElementById("place1").innerHTML += '</p>';
                }
                </c:forEach>
            }

        }

    </script>

</head>
<body>

<form method="post" action="/patient/time">

    <table>

        <td>
            <div class="calendar" >
                <table>
                    <c:forEach var="t" items="${timeList}">
                        <c:if test="${t.getTime() % 4 == 0}"><tr></c:if>
                        <td>
                            <c:if test="${t.getTicket() == NULL}">
                                <input type="radio" name="time" value="${t.getId()}" id="${t.getId()}">
                                <label for="${t.getId()}"> ${(t.getTime() / 4) - (t.getTime() % 4) * 0.1} </label>
                            </c:if>

                        </td>
                        <c:if test="${t.getTime() % 4 == 3}"></tr></c:if>
                    </c:forEach>
                </table>
            </div>
        </td>

        <td>

            <p><input  name="name" /></p>
            <p><input  name="message" /></p>
            <p><input type="submit"/></p>

        </td>

    </table>

</form>

</body>
</html>
