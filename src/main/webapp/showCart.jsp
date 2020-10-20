
  Created by IntelliJ IDEA.
  User: Professional
  Date: 16.10.2020
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show cart</title>
</head>
<body>
  <%@ page import="by.pvt.home.Cart" %>
<% Cart cart = (Cart) session.getAttribute("cart");%>
  <p> Name : <%=cart.getName()%></p>
<p> Quantity : <%=cart.getQuantity()%></p>
</body>
</html>
