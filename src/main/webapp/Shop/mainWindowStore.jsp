<%@ page import="dao.UserDao" %>
<%@ page import="dao.GoodsDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="text-align: right;">
    <h4>Welcome,
        <a href="/dataCheck">${name}</a>
        <p><a href="/basket">You basket here</a></p></h4>
</div>
<div style="text-align: center;">
<table border="1" align="center">

    <caption>List of Goods</caption>
    <br>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Enter your order</th>
    </tr>
    <form name="test" method="post" action="/basket">
<%
    GoodsDao goodsDao = new GoodsDao();
    for (int i = 0; i < goodsDao.getAllGoods().size(); i++){
        if (goodsDao.getAllGoods().get(i).getQuantity()>0){
        out.print("<tr><td>" + goodsDao.getAllGoods().get(i).getName() + "</td>");
        out.print("<td>" + goodsDao.getAllGoods().get(i).getDescription() + "</td>");
        out.print("<td>" + goodsDao.getAllGoods().get(i).getQuantity() + "</td>");
        out.print("<td>" + goodsDao.getAllGoods().get(i).getPrice() + "</td>");
        out.print("<td><input type=\"text\" name = \"goods " + i + "\"" + "size=\"10\"></td></tr>");
        }
        }
%>
</table>
    <br>
<input type="submit" size="100" value="Add Goods to the basket">
</form>
</div>
</body>
</html>
