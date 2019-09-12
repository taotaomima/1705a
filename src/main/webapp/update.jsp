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
	var eid=${param.eid};
	$.post("toupdate.do",{"eid":eid},function(da){
		var map = da.map;
		var list=da.list;
		var str="<option value=''>请选择专业</option>";
		for(var i in list){
			str+="<option value='"+list[i].pid+"'>"+list[i].pname+"</option>";			
		}
		$("#sid1").append(str);
		$("#sid2").append(str);
		
		$("[name='eid']").val(map.eid);
		$("[name='ename']").val(map.ename);
		$("[name='sex']").val(map.sex);
		$("[name='area']").val(map.area);
		$("[name='registname']").val(map.registname);
		$("[name='study']").val(map.study);
		$("[name='sid1']").val(map.sid1);
		$("[name='sid2']").val(map.sid2);
		$("[name='zycode']").val(map.zycode);
		$("[name='recode']").val(map.recode);
		$("[name='edate']").val(map.edate);
	},"json");
	
});


function update(){
	$.post("update.do",$("form").serialize(),function(da){
		if(da){
			alert("修改成功");
			location.href="list.do";
		}
	});
}
</script>
</head>
<body>
	
	<form action="#">
	<input type="hidden" name="eid">
	姓名：<input type="text" name="ename"><br>
	性别：<input type="text" name="sex" ><br>	
	省市：<input type="text" name="area"><br>
	申请注册单位：<input type="text" name="registname" ><br>
	所学专业：<input type="text" name="study" ><br>
	申请注册专业1：
	<select name="sid1" id="sid1">
		
	</select><br>
	
	申请注册专业2：<select name="sid2" id="sid2">
		
	</select><br>
	执业资格证书编号：<input type="text" name="zycode" ><br>
	注册号：<input type="text" name="recode"><br>
	有效期：<input type="date" name="edate" ><br>

	<input type="button" value="提交修改" onclick="update()">
	</form>
</body>
</html>