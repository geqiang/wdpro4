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
	width:20%;
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
<input type ="hidden" name = "op" value="delete2">
<table class=" table table-hover table-striped table-bordered">
	<tr class="warning">
		<th style="text-align: center"><input id="chkAll" type="checkbox" value="all" onclick="allUid()"><a href="UserServlet"></a></th>
		<th style="text-align: center">编号</th>
		<th style="text-align: center">订单号</th>
		<th style="text-align: center">商品名</th>
		<th style="text-align: center">用户</th>
		<th style="text-align: center">联系方式</th>
		<th style="text-align: center">地址</th>
		<th style="text-align: center">邮编</th>
		<th style="text-align: center">总价</th>
		<th style="text-align: center">状态</th>

		
		
		<th>
		
	
	</tr>
	<%
		List<OrderCartitem> list =(List<OrderCartitem>)session.getAttribute("list");
		int i=1;
		for(OrderCartitem l : list){
			int num1= l.getOid();
		%>
	<tr>
		
		<td style="vertical-align: middle">&nbsp;<input name="chkuid" type="checkbox" value="<%=l.getPid() %>"></td>
		<td style="vertical-align: middle">&nbsp;<%=i%></td>
		<td style="vertical-align: middle">&nbsp;<%=l.getTime() %></td>
		<td style="vertical-align: middle">&nbsp;<img src="./images/<%=l.getO2() %>" style="width:20%"><%=l.getO1()%></td>
	
		<td style="vertical-align: middle">&nbsp;<%=l.getOname()%></td>
		<td style="vertical-align: middle">&nbsp;<%=l.getOtele()%></td>
		<td style="vertical-align: middle">&nbsp;<%=l.getAddr()%></td>
		<td style="vertical-align: middle">&nbsp;<%=l.getPoset()%></td>

		<td style="vertical-align: middle">&nbsp;<%=l.getPrices()%></td>
		<td style="vertical-align: middle">&nbsp;<%=l.getStatus()%></td>
		<td style="vertical-align: middle">
		<a href ="javascript:if(confirm('确实要更改该内容吗?'))location='DingServlet?op=update&id=<%=num1%>'">更改</a>&nbsp;
		
		</td>
	</tr>

<% 

		i++;}%>
	<tr align="center">
	<td colspan="15" >
		<a href ="">首页 </a>&nbsp;
		
		<a href ="">上一页 </a>&nbsp;

		<a href ="">下一页 </a>&nbsp;
			
		<a href ="">末页 </a>&nbsp;
	</td>

	</tr>
</table>
</form>

</body>
</html>