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

</head>
<body>
<form action ="Userservlet">
<input type ="hidden" name ="op" value ="xiugai1">
<table class="table table-hover table-striped table-bordered">
	<%
		User user =(User)request.getAttribute("u");
		%>
	
		<input type="hidden" name="id" value="<%=user.getUid() %>">
			
			<tr>
				<th style="vertical-align: middle">编号</th>
				<td style="vertical-align: middle"><%=user.getUid() %></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">姓名</th>
				<td style="vertical-align: middle"><input name="name" value="<%=user.getName() %>" /></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">密码</th>
				<td style="vertical-align: middle"><input name="password" value="<%=user.getPassword() %>" /></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">邮箱</th>
				<td style="vertical-align: middle"><input name="mail" value="<%=user.getMail() %>" /></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">联系方式</th>
				<td style="vertical-align: middle"><input name="tele" value="<%=user.getTele() %>" /></td>
			</tr>
			
			
			<tr>
				<td style="vertical-align: middle"><input type="reset" value="reset"  /></td>
				<td style="vertical-align: middle"><input type="submit" value="submit"  /></td>
			</tr>
		</table>
	</form>

</body>
</html>