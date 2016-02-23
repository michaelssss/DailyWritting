<%@ page import="MyMealControlSystem.POJO.MealEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: michaelssss
  Date: 16-2-22
  Time: 下午3:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<MealEntity> list = (List<MealEntity>) request.getAttribute("list");

%>
<html>
<head>
    <title>每日饮食日志记录清单</title>
</head>
<body>
<table>
    这里列出所有我记录的饮食日志的清单</br>
    <%
        for (MealEntity mealEntity : list) {
            out.println(mealEntity + "</br>");
        }
    %>
</table>
</body>
</html>
