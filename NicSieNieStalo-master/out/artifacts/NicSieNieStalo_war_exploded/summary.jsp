<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="model.Match" %>
<%@ page import="java.util.List" %><%--

  Created by IntelliJ IDEA.
  User: Bartek
  Date: 26.06.2018
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:set var="matches" value= "${requestScope.matches}"> </c:set>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <title>Title</title>
</head>
<body>

<form method="post" action="matchDetails">
Opponent:<input type="text" name="opponent" id="opponent"  readonly><br>
Date:<input type="text" name="date" id="date"  readonly>
<input type="hidden" name="id" id="id"  required>
    <input type="submit" value="Show Details">
</form>

<table id="table" class="table table-bordered" style="width: 600px" >
    <thead>
    <tr>
        <th scope="col">#</th>
        <th onclick="sortTable(1)" scope="col">Opponent</th>
        <th onclick="sortTable(2)" scope="col">Date</th>
        <th onclick="sortTable(3)" scope="col">Good goals</th>
        <th onclick="sortTable(4)" scope="col">Bad goals</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${matches}" var="match">
    <tr>
        <td><c:out value="${match.idMatch}"/></td><td><c:out value="${match.opponent}"/></td><td><c:out value="${match.date}"/></td><td><c:out value="${match.goodGoals}"/></td><td><c:out value="${match.badGoals}"/></td>
    </tr>
    </c:forEach>

    </tbody>
</table>

<script>
    var table = document.getElementById('table');
    var rIndex;
    for(var i = 1; i < table.rows.length; i++){
        table.rows[i].onclick = function () {
            rIndex = this.rowIndex;
            console.log(rIndex);
            document.getElementById("opponent").value = this.cells[1].innerHTML;
            document.getElementById("date").value = this.cells[2].innerHTML;
            document.getElementById("id").value = this.cells[0].innerHTML;
        }
    }

</script>
<script>
    function sortTable(n) {
        var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
        table = document.getElementById("table");
        switching = true;
        // Set the sorting direction to ascending:
        dir = "asc";
        /* Make a loop that will continue until
        no switching has been done: */
        while (switching) {
            // Start by saying: no switching is done:
            switching = false;
            rows = table.getElementsByTagName("TR");
            /* Loop through all table rows (except the
            first, which contains table headers): */
            for (i = 1; i < (rows.length - 1); i++) {
                // Start by saying there should be no switching:
                shouldSwitch = false;
                /* Get the two elements you want to compare,
                one from current row and one from the next: */
                x = rows[i].getElementsByTagName("TD")[n];
                y = rows[i + 1].getElementsByTagName("TD")[n];
                /* Check if the two rows should switch place,
                based on the direction, asc or desc: */
                if (dir == "asc") {
                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                } else if (dir == "desc") {
                    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                        // If so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                }
            }
            if (shouldSwitch) {
                /* If a switch has been marked, make the switch
                and mark that a switch has been done: */
                rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                switching = true;
                // Each time a switch is done, increase this count by 1:
                switchcount ++;
            } else {
                /* If no switching has been done AND the direction is "asc",
                set the direction to "desc" and run the while loop again. */
                if (switchcount == 0 && dir == "asc") {
                    dir = "desc";
                    switching = true;
                }
            }
        }
    }
</script>


<a href="index.jsp">Return to Menu</a>
</body>
</html>
