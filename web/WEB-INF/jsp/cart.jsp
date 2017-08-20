<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" >购物车</h1>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>商品名称</td>
        <td>单价</td>
        <td>数量</td>
        <td>小计</td>
        <td>操作</td>
    </tr>
 
    <c:forEach items="${ois}" var="oi" varStatus="st">
        <tr>
            <td>${oi.item.name}</td>
            <td>${oi.item.price}</td>
            <td>${oi.num}</td>
            <td>${oi.item.price*oi.num}</td>
            <td><a href="${pageContext.request.contextPath}/order/delete?userid=${oi.orderid}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<div align="right"><a href="${pageContext.request.contextPath}/order/ok">返回购买页</a></div>

</body>
</html>