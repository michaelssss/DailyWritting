<%@ page import="MyMealControlSystem.BackGroundService.FoodListCache" %>
<%@ page import="MyMealControlSystem.POJO.FoodlistEntity" %>
<%@ page import="MyMealControlSystem.POJO.MealEntity" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%--
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
<button onclick="javascript:window.location.href='<%=request.getContextPath()%>';">
    返回首页
</button>
<br>
<table>
    这里列出所有我记录的饮食日志的清单</br>
    <%
        for (MealEntity mealEntity : list) {
            FoodlistEntity foodlistEntity = FoodListCache.foodlist.get(String.valueOf(mealEntity.getCategory()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("</br>记录时间： " + mealEntity.getTimestamp().toString() + "</br> 食物类别：");
            stringBuilder.append(foodlistEntity != null ? foodlistEntity.getType() : mealEntity.getCategory());
            stringBuilder.append("</br>食用量：" + mealEntity.getVolume() + "%(当前食用量占全天比重) </br>");
            out.println(stringBuilder.toString());
        }
    %>
</table>
<form name="mealEntity" id="mealEntity" action="ListAllMealRecord/save" method="post">
    <table>
        <tr>
            <td>
                <input type="datetime" id="timestamp" name="timestamp" placeholder="<%=new Date().getTime()%>"
                       value="<%=new Date().getTime()%>"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="text" id="category" name="category" placeholder="种类"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="number" id="volume" name="volume" placeholder="数量"/>
            </td>
        </tr>

    </table>

    <input type="submit" value="提交"/>
</form>
</body>
</html>
