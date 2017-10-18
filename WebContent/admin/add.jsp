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
<form action="../UploadServlet" method="post" enctype="multipart/form-data" role="form" >
	<div class="form-group">
		<%
			
		Product pro =(Product)request.getAttribute("emp");
		%>
		<table class="table table-hover table-striped table-bordered">
		
			<tr>
				<th>商品名</th>
				<td><input class="form-control " name="pname"/></td>
			</tr>
			<tr>
				<th>价格</th>
				<td><input class="form-control" name="price"/></td>
			</tr>
			<tr>
				<th>品牌</th>
				<td><input class="form-control" name="p8"/></td>
			</tr>
			<tr>
				<th>描述</th>
				<td><input class="form-control" name="descr"/></td>
			</tr>
			<tr>
				<th>库存</th>
				<td><input  class="form-control" name="kuchun"/></td>
			</tr>
			<tr>
				<th>颜色</th>
				<td><input  class="form-control" name="color"/></td>
			</tr>
			<tr>
				<th>类型</th>
				<td><input  class="form-control" name="p6"/></td>
			</tr>
			<tr>
				<th>类别</th>
				<td>
				<select name ="leibie">
					<option>请选择类别</option>
					<option value="1">鲜花玫瑰</option>
					<option value="2">永生玫瑰</option>
					<option value="3">玫瑰宝珠</option>
					<option value="4">玫瑰饰品</option>
				
				</select>
				</td>
			</tr>
			<tr>
			<th>图片1</th>
			<td>&nbsp;<input  name="img1" type="file" /></td>
			</tr>
						<tr>
			<th>图片2</th>
			<td>&nbsp;<input name="img2" type="file" /></td>
			</tr>
						<tr>
			<th>图片3</th>
			<td>&nbsp;<input name="img3" type="file" /></td>
			</tr>
						<tr>
			<th>图片4</th>
			<td>&nbsp;<input name="img4" type="file" /></td>
			</tr>
						<tr>
			<th>图片5</th>
			<td>&nbsp;<input name="img5" type="file" /></td>
			</tr>
			<tr>
			<th>图片6</th>
			<td>&nbsp;<input name="p7" type="file" /></td>
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