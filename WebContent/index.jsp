<%@page import="com.qfedu.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.qfedu.entity.Product"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>一生只送一人</title>
<link href="css/public.css" rel="stylesheet" type="text/css" />
<link href="css/topAndFoot.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.11.3.js"></script>
<script src="js/topAndFoot.js"></script>
<script src="js/index.js"></script>
<script src="js/istrueEntry.js"></script>
</head>
<body>
	<!--*******************************************Top开始***********************************-->

	<div id="topBox">
		<div id="top">
			<img class="top_child_img" src="images/logo_03.gif" />
			<div class="top_text">roseonly一生只送一人</div>
			<ul class="top_right">
				<li class="entry"><a href="entry.html">登录</a><a
					href="register.html">注册</a></li>
				<li class="successEntry showOrHide"><a href="javascript:;">欢迎您</a>
					<a class="havaName" href="OrderServlet?op=select"></a> <a class="cancel"
					href="javascript:;">注销</a></li>
				<li><a href="GouwucheServlet?op=select" class="top_right_lastA">.
				</a></li>
			</ul>
		</div>
	</div>
	<div id="toTop">
		<a href="#"><img src="images/sic_06.jpg" /> </a>
	</div>
	<div id="toNews">
		<a href="#"><img src="images/sic_03.jpg" /></a>
	</div>
	<%
		User use = (User) session.getAttribute("u");
	%>

	<!--*******************************************Top结束***********************************-->
	<!--*******************************************bigLogo开始***********************************-->
	<div id="bigLogoBox">
		<div id="bigLogo">
			<a href="index.jsp"> roseonly.</a>
		</div>
	</div>
	<!--*******************************************bigLogo结束***********************************-->
	<!--*******************************************nav开始***********************************-->
	<div id="navBox">
		<div id="allNav">
			<div id="nav">
				<ul class="fistUl">
					<li><a href="ShangpingServlet">鲜花玫瑰</a></li>
					<li><a href="ShangpingServlet?op=select2">永生玫瑰</a></li>
					<li><a href="ShangpingServlet?op=select3">玫瑰珠宝</a></li>
					<li><a href="html/birthday.html">生日推荐</a></li>
					<li><a href="#">love&nbsp;roseonly</a></li>
					<li><a href="#">诺誓世界</a></li>
					<li><a href="#">专卖店</a></li>
				</ul>
				<ul class="ulLastLi">
					<li class="entry"><a href="entry.html">登录</a><a
						href="regist.jsp">注册</a></li>
					<li class="successEntry showOrHide"><a href="javascript:;">欢迎您</a>
						<a class="havaName" href="#"></a> <a class="cancel"
						href="javascript:;">注销</a></li>
					<li><a href="#" class="lastA">
					</a></li>
				</ul>
			</div>
			<!--*********************************二级菜单开始**************************-->
			<div class="ejcdDiv">
				<!--*****************二级菜单第一个*******************-->
				<div class="secondNavOne">
					<ul class="second_allUl">
						<li><a href="#">玫瑰长盒</a></li>
						<li><a href="#">玫瑰手捧</a></li>
					</ul>
					<dl>
						<dt>
							<a href="#">系列</a>
						</dt>
						<dd>
							<a href="#">经典持续</a>
						</dd>
						<dd>
							<a href="#">恒久真爱</a>
						</dd>
						<dd>
							<a href="#">LINE FRIENDS 专属</a>
						</dd>
						<dd>
							<a href="#">爱在满怀</a>
						</dd>
						<dd>
							<a href="#">星座经典</a>
						</dd>
						<dd>
							<a href="#">love&nbsp;oseonly</a>
						</dd>
					</dl>
					<a href="#"><img src="images/ejcdOne.jpg" /></a>

				</div>
				<!--*****************二级菜单第二个*******************-->
				<div class="secondNavOne secondNavTwo">
					<ul class="second_allUl">
						<li><a href="#">音乐玫瑰</a></li>
						<li><a href="#">玫瑰原盒</a></li>
						<li><a href="#">玫瑰方盒</a></li>
						<li><a href="#">玫瑰心形盒</a></li>
						<li><a href="#">玫瑰长盒</a></li>
					</ul>
					<dl>
						<dt>
							<a href="#">系列</a>
						</dt>
						<dd>
							<a href="#">星座经典</a>
						</dd>
						<dd>
							<a href="#">为爱而生</a>
						</dd>
						<dd>
							<a href="#">经典持续</a>
						</dd>
						<dd>
							<a href="#">满满的爱</a>
						</dd>
						<dd>
							<a href="#">love&nbsp;oseonly</a>
						</dd>
					</dl>
					<dl>
						<dt></dt>
						<dd>
							<a href="#">全世爱</a>
						</dd>
						<dd>
							<a href="#">甜蜜心动</a>
						</dd>
						<dd>
							<a href="#">一生一世</a>
						</dd>
						<dd>
							<a href="#">诗意童话</a>
						</dd>
					</dl>
					<a href="#"><img src="images/ejcdTow.jpg" /></a>
				</div>
				<!--****************二级菜单*第三个*******************-->
				<div class="secondNavOne secondNavThree">
					<ul class="second_allUl">
						<li><a href="#">项链</a></li>
						<li><a href="#">手链</a></li>
						<li><a href="#">首饰</a></li>
						<li><a href="#">对戒</a></li>
						<li><a href="#">套装</a></li>
					</ul>
					<dl>
						<dt>
							<a href="baozhu.jsp">玫瑰宝珠</a>
						</dt>
						<dd>
							<a href="#">玫瑰经典</a>
						</dd>
						<dd>
							<a href="#">星座经典</a>
						</dd>
						<dd>
							<a href="#">生辰石</a>
						</dd>
						<dd>
							<a href="#">恒久经典</a>
						</dd>
						<dd>
							<a href="#">全心全意</a>
						</dd>
						<dd>
							<a href="#">时光无痕</a>
						</dd>
					</dl>
					<dl>
						<dt>
							<a href="shiping.jsp">玫瑰饰品</a>
						</dt>
						<dd>
							<a href="#">幸运精灵</a>
						</dd>
						<dd>
							<a href="#">时光之吻</a>
						</dd>
						<dd>
							<a href="#">爱之赞礼</a>
						</dd>
						<dd>
							<a href="#">全心全意</a>
						</dd>
						<dd>
							<a href="#">心心相印</a>
						</dd>
						<dd>
							<a href="#">love&nbsp;oseonly</a>
						</dd>
					</dl>
					<a href="#"><img src="images/ejcdThree.jpg" /></a>
				</div>
				<!--****************二级菜单*第四个*******************-->
				<div class="secondNavOne secondNavFour">
					<ul class="second_allUl">
						<li><a href="#">音乐玫瑰</a></li>
						<li><a href="#">永生玫瑰</a></li>
						<li><a href="#">鲜花玫瑰</a></li>
						<li><a href="#">生辰石</a></li>
						<li><a href="#">十二生肖</a></li>
						<li><a href="#">礼品</a></li>
						<li><a href="#">男士礼品</a></li>
						<li><a href="#">送亲人朋友</a></li>
					</ul>
					<dl>
						<dt>
							<a href="#">当月星座</a>
						</dt>
						<dd>
							<a href="#">天枰座</a>
						</dd>
						<dd>
							<a href="#">水瓶座</a>
						</dd>
						<dd>
							<a href="#">射手座</a>
						</dd>
						<dd>
							<a href="#">水瓶座</a>
						</dd>
						<dd>
							<a href="#">白羊座</a>
						</dd>
						<dd>
							<a href="#">双子座</a>
						</dd>
						<dd>
							<a href="#">狮子座</a>
						</dd>
					</dl>
					<dl>
						<dt></dt>
						<dd>
							<a href="#">天蝎座</a>
						</dd>
						<dd>
							<a href="#">摩羯座</a>
						</dd>
						<dd>
							<a href="#">双鱼座</a>
						</dd>
						<dd>
							<a href="#">金牛座</a>
						</dd>
						<dd>
							<a href="#">巨蟹座</a>
						</dd>
						<dd>
							<a href="#">处女座</a>
						</dd>
					</dl>
					<a href="#"><img src="images/ejcdFour.jpg" /></a>
				</div>
				<!--*****************二级菜单第五个*******************-->
				<div class="secondNavOne secondNavFive">
					<ul class="second_allUl">
						<li><a href="#">鲜花</a></li>
						<li><a href="#">精选长盒</a></li>
					</ul>
					<dl>
						<dt>
							<a href="#">永生花</a>
						</dt>
						<dd>
							<a href="#">方盒</a>
						</dd>
						<dd>
							<a href="#">圆盒</a>
						</dd>
						<dd>
							<a href="#">六角盒</a>
						</dd>
					</dl>
					<dl>
						<dt>
							<a href="#">饰品</a>
						</dt>
						<dd>
							<a href="#">项链</a>
						</dd>
						<dd>
							<a href="#">手链</a>
						</dd>
						<dd>
							<a href="#">耳饰</a>
						</dd>
					</dl>
					<a href="#"><img src="images/ejcdFive.jpg" /></a>
				</div>
				<!--*****************二级菜单第六个*******************-->
				<div class="secondNavOne secondNavFive">
					<ul class="second_allUl">
						<li><a href="#">品牌故事</a></li>
						<li><a href="#">产品故事</a></li>
						<li><a href="#">明星时刻</a></li>
						<li><a href="#">真爱见证</a></li>
						<li><a href="#">活动咨询</a></li>
						<li><a href="#">诺誓百科</a></li>
					</ul>
					<dl>
						<dt>
							<a href="#">节日百科</a>
						</dt>
						<dd>
							<a href="#">母亲节百科</a>
						</dd>
						<dd>
							<a href="#">520百科</a>
						</dd>
						<dd>
							<a href="#">圣诞节百科</a>
						</dd>
					</dl>
					<a href="#"><img src="images/ejcdSix.jpg" /></a>
				</div>
			</div>
		</div>
	</div>
	<!--*********************************二级菜单结束**************************-->
	<!--******************************banner开始******************************************-->
	<div id="bannerBox">
		<div class="banner">
			<div class="banner_image">
				<a href="#"><img class="firstImg" src="images/banner01.jpg"></a>
				<a href="#"><img src="images/banner02.jpg"></a> <a href="#"><img
					src="images/banner03.jpg"></a> <a href="#"><img
					src="images/banner04.jpg"></a> <a href="#"><img
					src="images/banner05.jpg"></a>
			</div>
			<div class="banner_tb">
				<span class="spanAddBgC"></span> <span></span> <span></span> <span></span>
				<span></span>
			</div>
			<p class="banner_left">
				<img src="images/left.png" />
			</p>
			<p class="banner_right">
				<img src="images/right.png" />
			</p>
		</div>
	</div>
	<!--******************************banner结束******************************************-->
	<!--******************************新品热卖开始******************************************-->
	<div id="newShop">
		<div class="news_release">
			<a href="flowRose.jsp"><dl class="news_release_firstDl">
				<dt class="news_release_imgDt">
					<img src="images/14725274565658985.jpg" />
					<div class="news_release_bga">永恒蓝色之美，只有你懂</div>
				</dt></a>
				<dd>新品上新</dd>
			</dl>
			<a href="OrderServlet?op=remai"><dl class="news_release_firstDl">
				<dt class="news_release_imgDt">
					<img src="images/newShop.jpg" />
					<div class="news_release_bga">经典永恒，时光在变，你我不变</div>
				</dt></a>
				<dd>经典热卖</dd>
			</dl>
			<a href="OrderServle?op=remai">
			<dl class="news_release_firstDl">
				<dt class="news_release_imgDt">
					<img src="images/14724519049423892.jpg" />
					<div class="news_release_bga">亿万星辰中这是属于你的那个</div>
				</dt></a>
				<dd>当月星座</dd>
			</dl>
			<a href="shiping.jsp">
			<dl class="news_release_firstDl">
				<dt class="news_release_imgDt">
					<img src="images/ddd.jpg" />
					<div class="news_release_bga">她们有的，你也可以</div>
				</dt></a>
				<dd>明星同款</dd>
			</dl>
		</div>
	</div>
	<!--******************************新品热卖结束******************************************-->
	<!--******************************新品热卖页签方式展示开始******************************************-->
	<div id="hotShopBox">
		<div class="hotShop">
			<p class="hotShop_show_top">热卖单品推荐</p>
			<div class="hotShop_show">
				<ul class="hotShop_show_cen">
					<li><span class="hotShopFirst">鲜花玫瑰</span></li>
					<li><span>永生玫瑰</span></li>
					<li><span>玫瑰宝珠</span></li>
					<li><span>玫瑰饰品</span></li>
				</ul>


				<div class="hotShop_show_but">
					<div class="hotShop_show_butBox">


						<div class="hotShop_show_butOne">
							<%
								List<Product> list = (List<Product>) session.getAttribute("list");
								for (Product l : list) {
									if (1 == l.getCategory() && !"小".equalsIgnoreCase(l.getDescr())
											&& !"大".equalsIgnoreCase(l.getDescr())) {
							%>
							<dl class="hotShop_dl">
								<dt class="hotShop_dl_dt">
									<a href="ShangpingServlet?op=xiangqing&id=<%=l.getPid()%>"><img
										src="./images/<%=l.getImg1()%>">
								</dt>
								<dd class="hotShop_dl_firdd"><%=l.getPname()%></dd>
								<dd class="hotShop_dl_secdd"><%=l.getDescr()%></dd>
								<dd class="hotShop_dl_tridd"><%=l.getPrice()%></dd>
							</dl>
							<%
								}

								}
							%>

						</div>

						<div class="hotShop_show_butOne">
							<%
								for (Product l : list) {
									if (2 == l.getCategory() && !"小".equalsIgnoreCase(l.getDescr())
											&& !"大".equalsIgnoreCase(l.getDescr())) {
							%>

							<dl class="hotShop_dl">
								<dt class="hotShop_dl_dt">
									<a href="ShangpingServlet?op=xiangqing&id=<%=l.getPid()%>"><img
										src="./images/<%=l.getImg1()%>">
								</dt>
								<dd class="hotShop_dl_firdd"><%=l.getPname()%></dd>
								<dd class="hotShop_dl_secdd"><%=l.getDescr()%></dd>
								<dd class="hotShop_dl_tridd"><%=l.getPrice()%></dd>
							</dl>
							<%
								}
								}
							%>


						</div>
						<div class="hotShop_show_butOne">

							<%
								for (Product l : list) {
									if (3 == l.getCategory() && !"小".equalsIgnoreCase(l.getDescr())
											&& !"大".equalsIgnoreCase(l.getDescr())) {
							%>
							<dl class="hotShop_dl">
								<dt class="hotShop_dl_dt">
									<a href="ShangpingServlet?op=xiangqing&id=<%=l.getPid()%>">
										<img src="./images/<%=l.getImg1()%>">
								</dt>
								<dd class="hotShop_dl_firdd"><%=l.getPname()%></dd>
								<dd class="hotShop_dl_secdd"><%=l.getDescr()%></dd>
								<dd class="hotShop_dl_tridd"><%=l.getPrice()%></dd>
							</dl>

							<%
								}
								}
							%>

						</div>
						<div class="hotShop_show_butOne">

							<%
								for (Product l : list) {
									if (4 == l.getCategory() && !"小".equalsIgnoreCase(l.getDescr())
											&& !"大".equalsIgnoreCase(l.getDescr())) {
							%>
							<dl class="hotShop_dl">
								<dt class="hotShop_dl_dt">
									<a href="ShangpingServlet?op=xiangqing&id=<%=l.getPid()%>">
										<img src="./images/<%=l.getImg1()%>">
								</dt>
								<dd class="hotShop_dl_firdd"><%=l.getPname()%></dd>
								<dd class="hotShop_dl_secdd"><%=l.getDescr()%></dd>
								<dd class="hotShop_dl_tridd"><%=l.getPrice()%></dd>
							</dl>
							<%
								}
								}
							%>

						</div>
						<div class="hotShop_show_butOne">
							<%
								for (Product l : list) {
									if (1 == l.getCategory()) {
							%>

							<dl class="hotShop_dl">
								<dt class="hotShop_dl_dt">
									<a href="ShangpingServlet?op=xiangqing&id=<%=l.getPid()%>">
										<img src="images/14295239608532493.jpg">
								</dt>
								<dd class="hotShop_dl_firdd">经典永续 19支</dd>
								<dd class="hotShop_dl_secdd">鲜花玫瑰19支</dd>
								<dd class="hotShop_dl_tridd">￥1999.0</dd>
							</dl>

							<%
								}
								}
							%>

						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!--******************************新品热卖页签方式展示结束******************************************-->
	<!--**********************************热品展示开始**********************************-->
	<div id="navShopShowBox">
		<div class="navShop">
			<div class="navShop_one">
				<div class="navShop_top">
					<p class="navShop_top_left">
						<span>鲜花玫瑰</span><span>Fresh Cut Rose</span>
					</p>
					<p class="navShop_top_right">
						<a href="flowRose.jsp">More</a>
					</p>
				</div>
				<div class="navShop_center">


					<ul>
						<%
							for (Product l : list) {
								if (1 == l.getCategory() && "大".equalsIgnoreCase(l.getDescr())) {
						%>
						<li class="bigImg"><a href="flowRose.jsp"><img
								src="./images/<%=l.getImg1()%>" />
								<div class="bigImg_bga img_bga">不想当咸鱼</div> </a></li>
						<%
							}
							}
						%>
						<%
							for (Product l : list) {
								if (1 == l.getCategory() && "小".equalsIgnoreCase(l.getDescr())) {
						%>

						<li class="smallImg"><a
							href="ShangpingServlet?op=xiangqing&id=<%=l.getPid()%>"><img
								src="./images/<%=l.getImg1()%>" />
								<div class="small_bga img_bga">不想当咸鱼</div> </a></li>
						<%
							}
							}
						%>

					</ul>

				</div>
			</div>
			<div class="navShop_one">
				<div class="navShop_top">
					<p class="navShop_top_left">
						<span>永生玫瑰</span><span>Fresh Cut Rose</span>
					</p>
					<p class="navShop_top_right">
						<a href="yongsheng.jsp">More</a>
					</p>
				</div>
				<div class="navShop_center">
					<ul>
						<%
							for (Product l : list) {
								if (2 == l.getCategory() && "大".equalsIgnoreCase(l.getDescr())) {
						%>
						<li class="bigImg"><a href="yongsheng.jsp"><img
								src="./images/<%=l.getImg1()%>" />
								<div class="bigImg_bga img_bga">不想当咸鱼</div> </a></li>
						<%
							}
							}
						%>
						<%
							for (Product l : list) {
								if (2 == l.getCategory() && "小".equalsIgnoreCase(l.getDescr())) {
						%>

						<li class="smallImg"><a
							href="ShangpingServlet?op=xiangqing&id=<%=l.getPid()%>"><img
								src="./images/<%=l.getImg1()%>" />
								<div class="small_bga img_bga">不想当咸鱼</div> </a></li>
						<%
							}
							}
						%>

					</ul>
				</div>
			</div>
			<div class="navShop_one">
				<div class="navShop_top">
					<p class="navShop_top_left">
						<span>玫瑰宝珠</span><span>Fresh Cut Rose</span>
					</p>
					<p class="navShop_top_right">
						<a href="zhubao.jsp">More</a>
					</p>
				</div>
				<div class="navShop_center">
					<ul>
						<%
							for (Product l : list) {
								if (3 == l.getCategory() && "大".equalsIgnoreCase(l.getDescr())) {
						%>
						<li class="bigImg"><a href="zhubao.jsp"><img
								src="./images/<%=l.getImg1()%>" />
								<div class="bigImg_bga img_bga">不想当咸鱼</div> </a></li>
						<%
							}
							}
						%>
						<%
							for (Product l : list) {
								if (3 == l.getCategory() && "小".equalsIgnoreCase(l.getDescr())) {
						%>

						<li class="smallImg"><a
							href="ShangpingServlet?op=xiangqing&id=<%=l.getPid()%>"><img
								src="./images/<%=l.getImg1()%>" />
								<div class="small_bga img_bga">不想当咸鱼</div> </a></li>
						<%
							}
							}
						%>
					</ul>
				</div>
			</div>
			<div class="navShop_one">
				<div class="navShop_top">
					<p class="navShop_top_left">
						<span>玫瑰饰品</span><span>Fresh Cut Rose</span>
					</p>
					<p class="navShop_top_right">
						<a href="zhubao.jsp">More</a>
					</p>
				</div>
				<div class="navShop_center">
					<ul>
						<%
							for (Product l : list) {
								if (4 == l.getCategory() && "大".equalsIgnoreCase(l.getDescr())) {
						%>
						<li class="bigImg"><a href="zhubao.jsp"><img
								src="./images/<%=l.getImg1()%>" />
								<div class="bigImg_bga img_bga">不想当咸鱼</div> </a></li>
						<%
							}
							}
						%>
						<%
							for (Product l : list) {
								if (4 == l.getCategory() && "小".equalsIgnoreCase(l.getDescr())) {
						%>

						<li class="smallImg"><a
							href="ShangpingServlet?op=xiangqing&id=<%=l.getPid()%>"><img
								src="./images/<%=l.getImg1()%>" />
								<div class="small_bga img_bga">不想当咸鱼</div> </a></li>
						<%
							}
							}
						%>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--**********************************热品展示结束**********************************-->
	<!--**********************************专卖店案例开始**********************************-->
	<div id="guilbBox">
		<div class="guilb">
			<div class="guilb_left">
				<a href="#"><img src="images/14652889582596601.jpg" /></a>
			</div>
			<div class="guilb_right">
				<a href="#"><img src="images/14652889697737388.jpg" /></a>
			</div>
		</div>
	</div>
	<!--******************************底部******************************************-->
	<div id="food_topBox">
		<div class="foot_top">
			<div class="foot_top_left">
				<p>.roseonly</p>
				<div>
					<span>关注我们</span> <a href="#"><img src="images/xlwb.png" /></a> <img
						src="images/wxtb.png" />
				</div>
			</div>
			<div class="foot_top_center">
				<dl>
					<dt>新手指南</dt>
					<dd>
						<a href="#">购物流程</a>
					</dd>
					<dd>
						<a href="#">支付方式</a>
					</dd>
					<dd>
						<a href="#">常见问题</a>
					</dd>
				</dl>
				<dl>
					<dt>售后服务</dt>
					<dd>
						<a href="#">退款说明</a>
					</dd>
					<dd>
						<a href="#">保养物语</a>
					</dd>
				</dl>
				<dl>
					<dt>物流配送</dt>
					<dd>
						<a href="#">配送方式</a>
					</dd>
					<dd>
						<a href="#">配送服务</a>
					</dd>
				</dl>
				<dl>
					<dt>关于我们</dt>
					<dd>
						<a href="#">联系我们</a>
					</dd>
					<dd>
						<a href="#">加入我们</a>
					</dd>
				</dl>
			</div>
			<div class="foot_top_right">
				<img src="images/foodTopRight.jpg" />
			</div>
			<img src="images/QR-big.jpg" title="这是微信二维码图" />
		</div>
	</div>
	<div id="foot_centerBox">
		<div class="foot_center">
			<img src="images/phone.jpg" />
		</div>
	</div>
	<div id="foot_buttomBox">
		<div class="foot_buttom">京ICP备13007738号 京公网安备11010502023922
			www.roseonly.com.cn；诺誓（北京）商业股份有限公司</div>
	</div>
</body>
</html>