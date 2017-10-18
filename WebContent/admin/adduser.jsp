<%@page import="com.qfedu.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="//apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<form action="../Userservlet?op=zhuche1" method="post" role="form" >
	<div class="form-group">
		<table class="table table-hover table-striped table-bordered">
		
			<tr>
				<th>姓名</th>
				<td><input class="form-control " name="uid"/></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input class="form-control" name="pass1"/></td>
			</tr>
			<tr>
				<th>联系方式</th>
				<td><input class="form-control" name="tele"/></td>
			</tr>
			<tr>
				<th>邮箱</th>
				<td><input class="form-control" name="mail"/></td>
			</tr>
			
			
			
			<tr>
				<td><input  type="reset" value="reset"  /></td>
				<td><input  type="submit" value="submit"  /></td>
			</tr>
		</table>
		</div>
	</form>
</body>
</html>