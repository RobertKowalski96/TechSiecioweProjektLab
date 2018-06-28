<%@ page import="java.util.List" %>
<%@ page import="model.Goal" %><%--
  Created by IntelliJ IDEA.
  User: Bartek
  Date: 26.06.2018
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="goals" value= "${requestScope.goals}"> </c:set>

<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>

<table id="table" class="table table-bordered" style="width: 600px" >
    <thead>
    <tr>
        <th scope="col">Shooter</th>
        <th scope="col">Minute</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${goals}" var="goal">
    <tr>
        <td><c:out value="${goal.shooter}"/></td> <td><c:out value="${goal.minute}"/>'</td>
    </tr>
    </c:forEach>
    </tbody>
</table>



<a href="index.jsp">Return to Menu</a>
</body>
</html>
