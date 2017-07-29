<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/CSS/radio-button.css">
    <script src="/resources/javascript/date.js"></script>


    <script>

        function showDoc(spec) {
            document.getElementById("place1").innerHTML = "";
            <c:forEach var="doctor" items="${docList}">
            if (${doctor.getSpecialization()} === spec)
            {
                document.getElementById("place1").innerHTML += '<p>';
                document.getElementById("place1").innerHTML +=
                    '<input type="radio" name="docId" value="${doctor.getId()}" />';
                document.getElementById("place1").innerHTML += " ";
                document.getElementById("place1").innerHTML +=
                    "${doctor.getFirstName()} ${doctor.getLastName()}";
                document.getElementById("place1").innerHTML += '</p>';
            }
            </c:forEach>
        }

        function calendar() {
            today = new Date();
            lastday = new Date();
            lastday.setDate(today.getDate() + 30);
            day = new Date();
            day.setDate(today.getDate() - today.getDay() + 1);

            for (i = 1; i < 7; i++)
            {
                document.writeln('<tr>');
                for (j = 1; j < 8; j++)
                {
                    document.writeln('<td>');

                    if (day >= today && day <= lastday)
                    {

                        document.writeln('<input type=radio name="dateStr" value="');
                        document.writeln(makeStr(day));
                        document.writeln('" id="');
                        document.writeln(makeStr(day));
                        document.writeln('" />');
                        document.writeln('<label for="');
                        document.writeln(makeStr(day));
                        document.writeln('" >');
                        document.writeln(day.getDate());
                        document.writeln('</label>');

                    } else {
                        document.writeln(day.getDate());
                    }


                    document.writeln('</td>');
                    day.setDate(day.getDate() + 1);
                }
                document.writeln('</tr>');
            }
        }

        function makeStr(day) {
            str = day.getFullYear() + "-" + day.getMonth() + "-" + day.getDate();
            return str;
        }

    </script>


</head>
<body>

    <form method="post" >

        <table>

            <td width="10%">
                <div>
                    <c:forEach var="dep" items="${depList}">
                        <p>
                            <input type="radio" name="depId" onclick="showDoc(${dep.getId()})"/>
                                ${dep.getName()}
                        </p>
                    </c:forEach>
                </div>
            </td>

            <td width="20%">
                <div id="place1" />
            </td>

            <td width="70%">
                <div class="calendar">
                    <table>
                        <tr>
                            <th>monday</th>
                            <th>tuesday</th>
                            <th>wednesday</th>
                            <th>thursday</th>
                            <th>friday</th>
                            <th>saturday</th>
                            <th>sunday</th>
                        </tr>

                        <script>
                            calendar();
                        </script>
                    </table>
                </div>
            </td>

        </table>

        <p><input type="submit"></p>

    </form>




</body>
</html>
