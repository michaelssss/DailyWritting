<%@ page import="MyMealControlSystem.POJO.FoodlistEntity" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: michaelssss
  Date: 16-2-22
  Time: 下午5:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>食物种类管理</title>
    <%
        List<FoodlistEntity> foodlistEntityList = (List<FoodlistEntity>) request.getAttribute("list");
    %>
</head>
<body>
<button onclick="javascript:window.location.href='<%=request.getContextPath()%>';">
    返回首页
</button>
<form action="./FoodListSetup/save" method="post" id="addObject" name="addObject">
    <table>
        <tr>
            <td>
                食物名称：
            </td>
            <td>
                <input name="foodName" id="foodName" type="text"/>
            </td>
        </tr>
        <tr>
            <td>
                种类：
            </td>
            <td>
                <input name="type" id="type" type="text"/>
            </td>
        </tr>
        <tr>
            <td>
                食物热量（单位：卡路里）：
            </td>
            <td>
                <input name="calories" id="calories" type="number"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交"/>
            </td>

        </tr>
    </table>
</form>
<%
    for (FoodlistEntity foodlistEntity : foodlistEntityList) {
%>
<table border="1">
    <tr>
        <td>
            食物名称：
        </td>
        <td>
            <%=foodlistEntity.getFoodName()%>
        </td>
    </tr>
    <tr>
        <td>
            种类：
        </td>
        <td>
            <%=foodlistEntity.getType()%>
        </td>
    </tr>
    <tr>
        <td>
            食物热量（单位：卡路里）：
        </td>
        <td>
            <%=foodlistEntity.getCalories()%>
        </td>
    </tr>
</table>
<%
    }
%>
</body>
</html>
