<%@ page import="db.ConnectionDB" %>
<%@ page import="dao.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="text-align: right;">
    <h4>Welcome,
            <%
            UserDao userDao = new UserDao();
        if (session.getAttribute("name").equals(userDao.getAllUsers().get(0).getName()) &&
                session.getAttribute("login").equals(userDao.getAllUsers().get(0).getLogin())){
            out.print("<a href=\"/dataAdmin\">" + session.getAttribute("name") + "</a></h4>");
        } else {
            out.print("<a href=\"/data\">" + session.getAttribute("name") + "</a></h4>");
        }
        %>
</div>
<div style="text-align: center;">
    <h2>You have to take your order by address:</h2><br>
    Minsk, Pritysky str, some were else...
    <p><a href="/mainWindowShop">back to the Shop</a></p>
</div>

</body>
</html>
