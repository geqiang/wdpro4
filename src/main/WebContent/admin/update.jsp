<%@page import="com.qfedu.entity.OrderCartitem"%>
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
<form action ="DingServlet">
<input type ="hidden" name ="op" value ="update2">
<table class="table table-hover table-striped table-bordered">
	<%
	OrderCartitem ord=(OrderCartitem)session.getAttribute("ord");
		%>
	
		<input type="hidden" name="id" value="<%=ord.getOid() %>">
			
			<tr>
				<th style="vertical-align: middle">订单号</th>
				<td style="vertical-align: middle"><%=ord.getTime()%></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">商品名</th>
				<td style="vertical-align: middle"><%=ord.getO1()%></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">价格</th>
				<td style="vertical-align: middle"><input name="prices" value="<%=ord.getPrices() %>" /></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">商品编号</th>
				<td style="vertical-align: middle"><%=ord.getPid() %></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">收货人</th>
				<td style="vertical-align: middle"><input name="oname" value="<%=ord.getOname() %>" /></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">联系方式</th>
				<td style="vertical-align: middle"><input name="otele" value="<%=ord.getOtele() %>" /></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">地址</th>
				<td style="vertical-align: middle"><input name="addr" value="<%=ord.getAddr() %>" /></td>
			</tr>
			<tr>
				<th style="vertical-align: middle">邮编</th>
				<td style="vertical-align: middle"><input name="poset" value="<%=ord.getPoset() %>" /></td>
			</tr>

			<tr>
				<th style="vertical-align: middle">订单状态</th>
				<td style="vertical-align: middle">
				<select name ="leibie">
					<option>请选择状态</option>
					<option value="已支付">已支付</option>
					<option value="未支付">未支付</option>
					<option value="配送中">配送中</option>
					<option value="已完成">已完成</option>
				
				
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