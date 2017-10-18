<%@page import="com.qfedu.entity.Product"%>
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
	img{
	width:100%;
	margin-bottom:20px;
	
	
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
<form action ="ProductServlet">
<input type ="hidden" name ="op" value ="update2">
<table class="table table-hover table-striped table-bordered">
	<%
		Product pro =(Product)request.getAttribute("pro");
		%>
	
		<input type="hidden" name="id" value="<%=pro.getPid() %>">
			<tr>
				<td rowspan="9" style="width:400px;height:400px">&nbsp;<img class="img-responsive img-thumbnail" src="./images/<%=pro.getImg1() %>"></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">商品名</th>
				<td style="vertical-align: middle"><input name="pname" value="<%=pro.getPname() %>" /></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">价格</th>
				<td style="vertical-align: middle"><input name="price" value="<%=pro.getPrice() %>" /></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">品牌</th>
				<td style="vertical-align: middle"><input name="p8" value="<%=pro.getP8() %>" /></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">描述</th>
				<td style="vertical-align: middle"><input name="descr" value="<%=pro.getDescr() %>" /></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">库存</th>
				<td style="vertical-align: middle"><input name="kuchun" value="<%=pro.getKuchun() %>" /></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">颜色</th>
				<td style="vertical-align: middle"><input name="color" value="<%=pro.getColor() %>" /></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">类型</th>
				<td style="vertical-align: middle"><input name="p6" value="<%=pro.getP6() %>" /></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">类别</th>
				<td style="vertical-align: middle">
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
				<td style="vertical-align: middle"><input type="reset" value="reset"  /></td>
				<td style="vertical-align: middle"><input type="submit" value="submit"  /></td>
			</tr>
		</table>
	</form>

</body>
</html>