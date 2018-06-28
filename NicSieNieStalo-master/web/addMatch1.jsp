<%--
  Created by IntelliJ IDEA.
  User: Bartek
  Date: 26.06.2018
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Match result</title>
</head>
<body>

<form method="post" action="addMatch1">
    <input type="text" name="opponent" placeholder="Opponent" required><br>
    <input type="date" name="date" placeholder="Date" required><br>
    <input type="number" name="goodGoals" placeholder="Good Goals" min="0" step="1" required><br>
    <input type="number" name="badGoals" placeholder="Bad Goals" min="0" step="1" required><br>
    <input type="submit" value="Confirm">
</form>


<a href="add.jsp">Return to Menu</a>
</body>
</html>
