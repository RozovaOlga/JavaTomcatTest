<%@ page import="java.util.Date" pageEncoding="UTF-8" %>
<html>
<body>
<h1 align="center">Testing JSP</h1>
<p>
        <%="Текущее время " + new Date() %>

<p>
<h4><a href="servlet1" title="Можно тыкать">servlet</a>
    <a href="servlet2" title="Можно тыкать тоже">servlet2</a>
    <a href="servlet3" title="Можно тыкать,но попадешь не сюда">servlet3</a>
</h4>
<p>
<h3 align="center"><%! private int accessCount = 0; %>
    Количество обращений к странице с момента загрузки сервера:
    <%= ++accessCount %>
</h3>
</body>
</html>