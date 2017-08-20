<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
    function deleteItems(){ 
    if(window.confirm("确定删除该记录？")){ 
       var form = document.forms.ac;
       var url ="${pageContext.request.contextPath}/items/deleteItems.action";
       form.action=url;
       form.method="post";// post请求
         form.submit();   
    }  
   return false;      
} 
    function check(){
    	var s="<%=session.getAttribute("user")%>"; 
        if(s=='null')
        {
           alert('请先登录');
           return false;
         }
    	var num1 = document.getElementById("num");
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
    
    function checklogin(){
    	var s="<%=session.getAttribute("user")%>"; 
        if(s=='null')
        {
           alert('请先登录');
           return false;
         }
        window.location.href="${pageContext.request.contextPath}/order/ok";
    }
    
</script>
<title>查询商品列表</title>
</head>
<body> 
<c:if test="${empty user}">
 <form action="${pageContext.request.contextPath }/user/login" method="post">
 <div align="left">
     username: <input type="text" name="username">
     password: <input type="password" name ="password">
     <input type="submit" value="登录">
     ${error}
    </div>
 </form>
</c:if>


<c:if test="${!empty user}">
    <div align="center">
       当前用户:${user.username}
       <a href="${pageContext.request.contextPath }/user/logout">退出登录</a>
    </div>
</c:if>

<%-- <form name="ac" action="${pageContext.request.contextPath}/items/queryItem.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="submit" value="查询"/></td>
</tr> --%>

<!-- </table> -->
商品列表：
<table width="100%" border=1>
<tr>
    <td colspan="2" align="center">商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td align="center">操作</td>
<!-- 	<td>购买</td> -->
</tr>
<c:forEach items="${itemsList}" var="item">
<tr>
   <td><input type="checkbox" name="selected_id" value="${item.id}"> </td>
	<td>${item.name}</td>
	<td>${item.price }</td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd"/></td>
	<td>${item.detail }</td>
	<td><a href="${pageContext.request.contextPath }/items/editItems.action?id=${item.id}">修改</a></td>
<%-- 	<td>
             
            <form name="buy" method="post">
               数量<input type="text" value="1" id="num" name="num">
            <input type="hidden" name="userid" value="${user.userid}">
            <input type="hidden" name="id" id="id" value="${item.id}">
            
            <input type="button" value="购买" onclick="check()">
            </form>
  </td> --%>
</tr>
</c:forEach>
</table>
 <div style="text-align:center">
        <a href="?start=0">首  页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末  页</a>
    </div>

<input type="button" value="批量删除" onclick="deleteItems()">
<!-- </form> -->
  <a href="${pageContext.request.contextPath }/items/editItemsList">批量修改</a>
<div align="right"><input type="button" value="购买商品" onclick="checklogin()"></div>


</body>

</html>