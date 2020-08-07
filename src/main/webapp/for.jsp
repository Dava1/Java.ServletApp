<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <title>Title</title>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<%
    String[] times = new String[]{"summer","autum","winter","spring"};
    request.setAttribute("items",times);
%>
<h3>For each loop</h3>
<ul>
    <c:forEach var="item" items="${items}">
        <li>${item}</li>
    </c:forEach>
</ul>
</body>
</html>
