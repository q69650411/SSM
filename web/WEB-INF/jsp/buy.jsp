<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
    function check(){
    	 var num1 = document.getElementById("num").value;
    	alert(num1.value);
    	if(num1.value!=""){
    		var form = document.forms.buy;
    	       var url ="${pageContext.request.contextPath}/order/add.action";
    	       form.action=url;
    	       form.method="post";// post请求
    	       form.submit();   
    	}
    	else{
    		alert("数量不能为空");
    	}
    	
    	
    }
    
</script>
<title>Insert title here</title>
</head>
<body>

<c:if test="${!empty user}">
  <div align="center">
    当前用户: ${user.username}
  </div>
</c:if>
 
<table align='center' border='1' cellspacing='0'>
    <tr>
    <td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>购买</td>
    </tr>
    <c:forEach items="${itemsList}" var="item" varStatus="st">
        <tr>
            <td>${item.name}</td>
	<td>${item.price }</td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${item.detail }</td>
            <td>
             
            <form id="buy" action="${pageContext.request.contextPath}/order/add" method="post">
             
               数量<input type="text" value="1" id="num" name="num">
            <input type="hidden" name="id" value="${item.id}">
            <input type="hidden" name="userid" value="${userid }">
           <!--  <input type="button" value="购买" onclick="check()"> -->
            <input type="submit" value="购买">
            </form>
              </td>
        </tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath }/order/cart.action?userid=${userid}">购物车</a>
<div align="right"><a href="${pageContext.request.contextPath }/items/queryItems">返回首页</a> </div>


</body>
</html>