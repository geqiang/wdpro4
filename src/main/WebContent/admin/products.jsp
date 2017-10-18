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
		<th style="text-align: center">商品名</th>
		<th style="text-align: center">单价</th>
		<th style="text-align: center">品牌</th>
		<th style="text-align: center">描述</th>
		<th style="text-align: center">类别号</th>
		<th style="text-align: center">库存</th>
		<th style="text-align: center">颜色</th>
		<th style="text-align: center">类型</th>
		<th style="text-align: center">类别</th>
		<th style="text-align: center">图片</th>
		
		<th>
		<input type= "submit" value = "批量删除" >
	
		<a href ="admin/add.jsp"><input type="button" value ="添加"></a></th>
	
	</tr>
	<%
		List<Product> list =(List<Product>)request.getAttribute("list");
		int i=1;
		for(Product l : list){
		%>
	<tr>
		
		<td style="vertical-align: middle">&nbsp;<input name="chkuid" type="checkbox" value="<%=l.getPid() %>"></td>
		<td style="vertical-align: middle">&nbsp;<%=i%></td>
		<td style="vertical-align: middle">&nbsp;<%=l.getPname() %></td>
		<td style="vertical-align: middle">&nbsp;<%=l.getPrice()%></td>
		<td style="vertical-align: middle">&nbsp;<%=l.getP8()%></td>
		<td style="vertical-align: middle">&nbsp;<%=l.getDescr()%></td>
		<td style="vertical-align: middle">&nbsp;<%=l.getCategory()%></td>
		<td style="vertical-align: middle">&nbsp;<%=l.getKuchun()%></td>
		<td style="vertical-align: middle">&nbsp;<%=l.getColor()%></td>
		<td style="vertical-align: middle">&nbsp;<%=l.getP6()%></td>
		<td style="vertical-align: middle">&nbsp;<%=l.getCate().getCname() %></td>
		<td style="vertical-align: middle width=100px;">&nbsp;<img src="./images/<%=l.getImg1() %>" style="width:20%"></td>
		<td style="vertical-align: middle">
		
		<a href ="javascript:if(confirm('确实要更改该内容吗?'))location='ProductServlet?op=update&id=<%=l.getPid() %>'">更改</a>&nbsp;
		<a href ="javascript:if(confirm('确实要删除该内容吗?'))location='ProductServlet?op=delete&id=<%=l.getPid() %>'">删除</a>
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