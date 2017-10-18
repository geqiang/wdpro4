<%@page import="com.qfedu.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="//apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">

	a{text-decoration:none
		
	}
</style>
<script type="text/javascript">
function allUid(){
	
	var uids = document.getElementsByName("chkuid");
	var ui = document.getElementById('chkAll');
	for(var i = 0; i < uids.length; i++){
		if(ui.checked){
			
			uids[i].checked = true;
			
		}else{
			uids[i].checked = false;
		}
		
	}
}


</script>
</head>
<body>
<form action ="Userservlet">
<input type ="hidden" name = "op" value="delete2">
<table class="table table-hover table-striped table-bordered">
	<tr class="warning">
		<th><input id="chkAll" type="checkbox" value="all" onclick="allUid()"><a href="UserServlet"></a></th>
		<th>编号</th>
		<th>姓名</th>
		<th>邮箱</th>
		<th>联系方式</th>
		<th >
		<input type= "submit" value = "批量删除" >&nbsp;
		<a href ="admin/adduser.jsp"><input type="button" value="增加"></a>
		</th>
	
	</tr>
	<%
		List<User> list =(List<User>)request.getAttribute("list");
		int i=1;
		for(User l : list){
		%>
	<tr>
		
		<td>&nbsp;<input name="chkuid" type="checkbox" value="<%=l.getUid() %>"></td>
		<td>&nbsp;<%=i%></td>
		<td>&nbsp;<%=l.getName() %></td>
		<td>&nbsp;<%=l.getMail()%></td>
		<td>&nbsp;<%=l.getTele() %></td>
		<td>
		
		<a href ="Userservlet?op=xiugai&id=<%=l.getName() %>">修改</a>&nbsp;
		<a href ="javascript:if(confirm('确实要删除该内容吗?'))location='Userservlet?op=delete&id=<%=l.getUid() %>'">删除</a></td>
	</tr>

<% 

		i++;}%>
	<tr align="center">
	<td colspan="7" >
		<a href ="">首页 </a>&nbsp;
		
		<a href ="">上一页 </a>&nbsp;

		<a href ="">下一页 </a>&nbsp;
			
		<a href ="">末页 </a>&nbsp;
	</td>

	</tr>
</table>
<form>
</body>
</html>