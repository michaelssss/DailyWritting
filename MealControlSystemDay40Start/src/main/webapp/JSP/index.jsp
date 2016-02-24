<%@ page import="MyMealControlSystem.BackGroundService.FoodListCache" %>
<%@ page import="MyMealControlSystem.POJO.FoodlistEntity" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: michaelssss
  Date: 16-2-18
  Time: 上午12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
<a href="./ListAllMealRecord">饮食日志</a>
<a href="./FoodListSetup">食物种类</a>
</br>
<%
    out.println("当前食物种类统计</br>");

    Map<String, FoodlistEntity> map = FoodListCache.foodlist;
    Iterator<Map.Entry<String, FoodlistEntity>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
        Map.Entry<String, FoodlistEntity> entry = iterator.next();
        out.println(entry.getValue().toString().replace("\n", "</br>"));
    }
%>
<form action="./login" method="post">
    <input type="text" name="username" id="username" placeholder="UserName"/>
    <input type="password" name="password" id="password" placeholder="PassWord"/>
    <input type="submit" value="提交"/>
</form>
<b>用户名：<%=(String) request.getSession().getAttribute("username")%>
</b>
<b>密码：<%=(String) request.getSession().getAttribute("password")%>
</b>
<form action="./logout" method="get">
    <input type="submit" value="提交"/>
</form>
</body>
</html>
