<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
	String path=request.getContextPath();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="<%=path%>/css/css.css"/> 
<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#qx").toggle(function(){
		$(":checkbox").attr("checked",true);
	},function(){
		$(":checkbox").attr("checked",false);	
	});
	
	
	$.post("selectprofession.do",function(da){
		var str="";
		for(var i in da){
			str+="<option value='"+da[i].pid+"'>"+da[i].pname+"</option>";			
		}
		$("#pid").append(str);
	});
	
});

function del(){
	var ids=$(":checkbox:checked").map(function(){
		return $(this).val();
	}).get().join();
	
	alert(ids);
	
	$.post("deleteAll.do",{"eid":ids},function(da){
		if(da){
			alert("删除成功");
			location.href="list.do";
		}
	});
}
</script>
</head>
<body>
	
	
	<form action="list.do" method="post">
	姓名：<input type="text" name="ename">
	省市：<input type="text" name="area">	
	申请注册专业：<select name="pid" id="pid">
	<option value="0">请选择专业</option>
	</select>
	<input type="submit" value="搜素">
	<input type="button" value="批量删除" onclick="del()">
	</form>
	<table>
	<tr>
	<td><input type="checkbox" id="qx">编号</td>
	<td>姓名</td>
	<td>性别</td>
	<td>省市</td>
	<td>申请注册单位</td>
	<td>所学专业</td>
	<td>申请注册专业1</td>
	<td>申请注册专业2</td>
	<td>执业资格证书编号</td>
	<td>注册号</td>
	<td>有效期</td>
	<td>操作</td>
	</tr>
	
	<c:forEach items="${page.list }" var="e">
		<tr>
		<td><input type="checkbox" name="eid" value="${e.eid }">${e.eid }</td>
		<td>${e.ename }</td>
		<td>${e.sex }</td>
		<td>${e.area }</td>
		<td>${e.registname }</td>
		<td>${e.study }</td>
		<td>${e.pname1 }</td>
		<td>${e.pname2 }</td>
		<td>${e.zycode }</td>
		<td>${e.recode }</td>
		<td>${e.edate }</td>
		<td><a href="update.jsp?eid=${e.eid }"><input type="button" value="编辑"></a></td>
		</tr>
		
	</c:forEach>
	
	<tr>
		<td colspan="15">
		<a href="?pageNum=1">首页</a>
		<a href="?pageNum=${page.pageNum-1<1?page.pageNum:page.pageNum-1 }">上一页</a>
		<a href="?pageNum=${page.pageNum+1>page.pages?page.pageNum:page.pageNum+1 }">下一页</a>
		<a href="?pageNum=${page.pages }">尾页</a>
		</td>
	</tr>
	
	</table>
</body>
</html>