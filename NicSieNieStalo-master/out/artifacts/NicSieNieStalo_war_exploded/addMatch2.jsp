<%--
  Created by IntelliJ IDEA.
  User: Bartek
  Date: 26.06.2018
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%--%>
    <%--int goodGoals = (int) request.getAttribute("goodGoals");--%>
    <%--int badGoals = (int) request.getAttribute("badGoals");--%>
<%--%>--%>
<c:set var="badGoals" value= "${requestScope.badGoals}" > </c:set>
<c:set var="goodGoals" value= "${requestScope.goodGoals}"> </c:set>
<html>
<head>
    <title>Goals details</title>
</head>
<body>

<form method="post" action="addMatch2">
    <input type="hidden"  name="idmatch" value="<%=request.getAttribute("idmatch")%>"/>
    <input type="hidden"  name="goodGoals" value="<c:out value="${goodGoals}"/>"/>
    <input type="hidden"  name="badGoals" value="<c:out value="${badGoals}"/>"/>
    <h1>Good goals:</h1>

    <c:forEach begin="0" end="${goodGoals-1}" var="i">
    <input type="text" name="goodGoalShooter<c:out value="${i}"/>" placeholder="Shooter<c:out value="${i}"/>" required> <input type="number" min="1" max="140" step="1" name="goodGoalTime<c:out value="${i}"/>" placeholder="Time" required><br>
    </c:forEach>

    <h1>Bad goals:</h1>
<c:forEach begin="0" end="${badGoals-1}" var="i">
    <input type="text" name="badGoalShooter<c:out value="${i}"/>" placeholder="Shooter" required> <input type="number" min="1" max="140" step="1" name="badGoalTime<c:out value="${i}"/>" placeholder="Time" required><br>
</c:forEach>
    <input type="submit" value="Confirm">
</form>


</body>
</html>
