<%@ page import ="java.time.LocalDateTime" %>
<%@ page import="letscode.User"%>
<%@ page import="java.util.List" %>
<!doctype html>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
<h1>Hello JSP</h1>
<%=LocalDateTime.now()%>
<hr/>
<%
   List<User> users = (List) request.getAttribute("users");

 %>
    <table>
    <% for(User user: users){%>
        <tr>
            <td><%=user.getName()%></td>
            <td><%=user.getCountry()%></td>
            <td><%=user.getAge()%></td>
        </tr><%}%>
    </table>
</body>
</html>
