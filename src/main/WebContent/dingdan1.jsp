<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.qfedu.entity.Product"%>
<%@page import="com.qfedu.Dao.Impl.CartitemImpl"%>
<%@page import="com.qfedu.Dao.Icartitem"%>
<%@page import="com.qfedu.entity.Cartitem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.qfedu.entity.OrderCartitem"%>
<%@page import="java.util.List"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Cache-Control" content="no-cache,must-revalidate" />
<title>一生只送一人</title>
<meta name="keywords" content="鲜花，国外进口鲜花，国外玫瑰" />
<meta name="description" content="中国高端品牌花店roseonly" />
<meta content="all" name="robots" />
<link href="http://www.roseonly.com.cn/assets/roseonly/css/public.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="http://orders.roseonly.com.cn/resources/usercenter/css/infor.css?g" />
<link href="http://orders.roseonly.com.cn/resources/css/pay_address_ceng.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="http://orders.roseonly.com.cn/resources/jquery/jquery.min.js"></script>
<script type="text/javascript" src="http://orders.roseonly.com.cn/resources/js/qyutil.js"></script>
<script type="text/javascript" src="http://orders.roseonly.com.cn/resources/My97DatePicker/WdatePicker.js"></script>	
<script type="text/javascript" src="http://orders.roseonly.com.cn/resources/order/pay_address.js?v=32"></script>
<script src="js/istrueEntry.js"></script>
<script type="text/javascript">
	var isCartRoseonly = "0";//roseonly:1,zhuanai:0
	var send_time_1 = "2017-09-28";
</script>
    <link href="css/public.css" rel="stylesheet" type="text/css" />
    <link href="css/topAndFoot.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="css/shoppingCart.css">
    <script src="js/istrueEntry.js"></script>
    <script src="js/shoppingCart.js"></script>

<style type="text/css">
.shuaixuan{
	margin:20px 0;
	padding-left: 6px;
}
.shuaixuan > select{
	border:1px solid #83847e;
	background-color: #fff;
    width: 220px;
    height: 35px;
    line-height: 35px;
   }

</style>
</head>
<body>
<div id="topBox"> 
    <div id="top">
        <img class="top_child_img" src="images/logo_03.gif"/>
        <div class="top_text">roseonly一生只送一人</div>
        <ul class="top_right">
            <li class="entry"><a href="entry.html">登录</a><a href="register.html">注册</a></li>
            <li class="successEntry showOrHide">
                <a href="javascript:;">欢迎您</a>
                <a class="havaName" href="#"></a>
                <a class="cancel" href="javascript:;" style="width : 15px; margin-top:1px ; background-color:white;">注销</a>
            </li>
            <li><a href="GouwucheServlet?op=select" class="top_right_lastA"></a> </li>
        </ul>
    </div>
</div>

<div class="logo-container">
	<a href="IndexServlet" class="logo_nbtn">
		<img title="roseonly官网" alt="roseonly官网" src="http://www.roseonly.com.cn/upload/syspic_new/14871272268992899.jpg" />	
	</a>
	
</div>
 


<!--头部end-->
	
	<!--内容部分开始--> 
	<div class="container">
		<div>
			<div class="nav-container">
				<div class="main_view_line2"></div>
			</div>
		</div>
		<form>
		<div class="shopping">
	
				<!--收货人信息 start-->	
				<div id="address_mylist_1"  >
					<div id="address_mylist_2"></div>
					<div class="order-per" id="address_mylist">
						
					</div>
				</div>
	<div class="shoppingCart_center">
            <table Cellspacing="0">
                <tbody>
                   <tr class="shoppingCart_center_first_tr">
                        <td class="shoppingCart_center_td1">编号</td>

                        <td class="shoppingCart_center_td3">商品名称</td>
                        <td class="shoppingCart_center_td4">价格</td>
						<td class="shoppingCart_center_td4">数量</td>
                        
                    </tr>
<%
		List<Cartitem> list =(List<Cartitem>)session.getAttribute("list");
		int i=1;
		double num= 0;
		String shanchu=null;
		for(Cartitem l : list){
			num +=l.getPrice() * l.getCount();
		%>
                    
                    
                          <tr class="shoppingCart_center_second_tr">
                             <td class="shoppingCart_center_td1"><%=i%></td>

 							<td class="shoppingCart_center_td3"><img src="./images/<%=l.getImg1() %>"><span><%=l.getPname() %>-经典-朱砂-19支</span></td>
                             <td class="shoppingCart_center_td4"><%=l.getPrice() %></td>
                             <td class="shoppingCart_center_td5"><%=l.getCount() %></td>
                         </tr>
             <% shanchu=l.getName(); %>
                                <% 

		i++;}%> 
                </tbody>
            </table>    <p class="allMoney"><span>元</span><i><%=num %></i><span>合计：</span></p>
            <a style="margin-left:800px;font-size: 20px" href="#">点我支付</a>
            
           
         
            
      

            </form>

<script type="text/javascript" src="http://orders.roseonly.com.cn/resources/order/userinfo_ceng.js"></script>
<script type="text/javascript" src="http://www.roseonly.com.cn/assets/jquery/Base.js"></script>
<link href="http://www.roseonly.com.cn/index/style/new_style/other.css" rel="stylesheet" type="text/css" /> 	
	
	<!-- http://www.roseonly.com.cn/index/include/footer1.jsp -->
<script type="text/javascript" src="http://www.roseonly.com.cn/index/js/fdj.js"></script>
<div class="footer">
	<div class="four_nav">
		<a class="four_nav_a bg1">
			<div class="four_nav_div">全场包邮<span class="f14 f_wg_box">特殊礼品除外</span></div>
		</a>	
		<a class="four_nav_a bg2">
			<div class="four_nav_div">同城速递<span class="f14 f_wg_box">支持当日送达</span></div>
		</a>
		<a class="four_nav_a bg3">
			<div class="four_nav_div">爱的留言<span class="f14 f_wg_box">支持语音与文字，可随时查阅</span></div>
		</a>
		<a class="four_nav_a bg4">
			<div class="four_nav_div">保养物语<span class="f14 f_wg_box">悉心保养，恒久保存爱意</span></div>
		</a>		
		<div class="clear"></div>
	</div>
    <div class="footer_box">
        <div class="new_l">
            <a href=""><img src="http://www.roseonly.com.cn/upload/syspic_new/14652903297966422.jpg" alt="">
            </a>
            <div style="position:relative;margin-top:30px">
                <a>关注我们</a>
                <a style="position:absolute;left:80px;top:-2px" onMouseOver="showPic(this)" onMouseOut="closeShow(this)"><img src="http://www.roseonly.com.cn/upload/syspic_new/14652897662274880.jpg" alt="">
                </a>
                <a style="position:absolute;left:125px;top:-4px" href=""http://weibo.com/u/3206773285><img src="http://www.roseonly.com.cn/upload/syspic_new/14652897713466258.png" alt="">
                </a>
            </div>
        </div>
        <ul>
            <p>新手指南</p>
            <li><a href="http://www.roseonly.com.cn/about/gouwuliucheng.html" target="_blank">购物流程</a></li>
            <li><a href="http://www.roseonly.com.cn/about/zhifufangshi.html" target="_blank">支付方式</a></li>
            <li><a href="http://www.roseonly.com.cn/about/changjianwenti.html" target="_blank">常见问题</a></li>
            <li><a href="http://www.roseonly.com.cn/about/zhiquanceliang.html" target="_blank">指圈测量</a></li>
        </ul>
        <ul>
            <p>售后服务</p>
            <li><a href="http://www.roseonly.com.cn/about/tuihuantiaoli.html" target="_blank">退款说明</a></li>
            <li><a href="http://www.roseonly.com.cn/about/huhuatiaoli.html" target="_blank">保养物语</a></li>
        </ul>
        <ul>
            <p>物流配送</p>
            <li><a href="http://www.roseonly.com.cn/about/peisongfangshi.html" target="_blank">配送方式</a></li>
            <li><a href="http://www.roseonly.com.cn/about/peisongfuwu.html" target="_blank">配送服务</a></li>
        </ul>
        <ul style="background:none">
            <p>关于我们</p>
            <li><a href="http://www.roseonly.com.cn/about/pinpaijieshao.html" target="_blank">品牌介绍</a></li>
            <li><a href="http://www.roseonly.com.cn/about/xiaoshouqudao.html" target="_blank">销售渠道</a></li>
            <li><a href="http://www.roseonly.com.cn/about/guanyuwomen.html" target="_blank">联系我们</a></li>
            <li><a href="http://www.roseonly.com.cn/about/jiaruwomen.html" target="_blank">加入我们</a></li>
        </ul>
        <div class="new_r" style="margin-left:35px;">
            <a ><img src="http://www.roseonly.com.cn/upload/syspic_new/14925880608342709.png" style="width:120px" alt=""></a>
				<p>roseonly官网</p>
        </div>  
        <div class="new_r">
            <a ><img src="http://www.roseonly.com.cn/upload/syspic_new/14925880778895795.png" style="width:120px" alt=""></a>
				<p>微信关注roseonly</p>
        </div>   
    </div>
	<div class="foot-nav">
		京ICP备13007738号 京公网安备11010502023922 www.roseonly.com.cn；诺誓（北京）商业股份有限公司
	</div>
</div>
<div id='preview' class='previewShowWindow' style="display:none;">
    <img id='pi' src='http://www.roseonly.com.cn/index/images/QR-big.jpg' alt="扫描二维码" />
</div>
<div id="back-to-top">
        <!--<a href="http://im.roseonly.com.cn/" target="_blank"><img src="http://www.roseonly.com.cn/index/images/right_tb01.png" alt="在线咨询"  /></a>-->
        <!--<img src="http://www.roseonly.com.cn/index/images/right_tb02.png" alt="二维码" path="http://www.roseonly.com.cn/index/images/QR-big.jpg" onMouseOver="showPic(this)" onMouseOut="closeShow(this);" />-->
        <a class="go_top" href="javascript:;"><img src="http://www.roseonly.com.cn/upload/syspic_new/14703637041003761.svg" />
        </a>
    </div>
	<!--客服开始-->
<div id="zhichiBtnBox">
	<a id="zhichiBtn" href="javascript:;" target="_blank">
		<img  src="http://www.roseonly.com.cn/upload/syspic_new/14703636967439422.svg">
	</a>
	<div class="mes_content">
		<div class="mes_icon">
			<div class="tel_sj"><img src="http://www.roseonly.com.cn/upload/syspic_new/14769441969842358.png" alt="">
			</div>
			<div class="tel_icon">
				<p class="tel_txt">联系电话</p>
				<p class="tel_phone">400-1314-520</p>
			</div>
			<div class="tel_line"></div>
			<div class="zxkf_txt">
				<a href="http://www.sobot.com/chat/pc/index.html?sysNum=1fe87079144a4587872a516c25aabd86">在线客服</a>
			</div>
		</div>
	</div>
</div>
<!--二维码开始-->
<div id="ewmBox">
	<a id="ewm" href="javascript:;" target="_blank">
		<img  src="http://www.roseonly.com.cn/upload/syspic_new/14945591270622918.svg">
	</a>
	<div class="ewm_content"><img src="http://www.roseonly.com.cn/upload/syspic_new/14945591218222010.png" /></div>
</div>
<script type="text/javascript">

$("#ewmBox").hover(function () {
	$(".ewm_content").css({
		display: 'block'
	})
}, function () {
	$(".ewm_content").css({
		display: 'none'
	})
});

</script>


<!-- 亿玛代码 -->		
<script type="text/javascript"> 
(function(){
	window.lessThenIE8 = function () {
	    var UA = navigator.userAgent,
	        isIE = UA.indexOf('MSIE') > -1,
	        v = isIE ? /\d+/.exec(UA.split(';')[1]) : 'no ie';
	    return v < 9;
	}();
	
	//小于ie9执行
	if(lessThenIE8){
		$(window).ready(function(){thrid_codes();});
	}else{
		window.onload = thrid_codes;
	} 
}());

function thrid_codes(){
	//console.log("thrid code load start");
	var _oztime = "?tm"+(new Date()).getTime();
	//聚胜万合
	window._mvq = window._mvq || [];
	_mvq.push(['$setAccount', 'm-23932-1']);
	_mvq.push(['$logConversion']);
	(function() {
		var mvl = document.createElement('script');
		mvl.type = 'text/javascript'; mvl.async = true;
		mvl.src = ('https:' == document.location.protocol ? 'https://static-ssl.mediav.com/mvl.js'+_oztime : 'http://static.mediav.com/mvl.js'+_oztime);
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(mvl, s); 
	})();	
	
	//亿玛声明adwq
	window._adwq = window._adwq || [];
	_adwq.push(['_setAccount', 'xlvtr']);
	_adwq.push(['_setDomainName', '.roseonly.com.cn']);
	_adwq.push(['_trackPageview']);
	(function() {
		var adw = document.createElement('script');
		adw.type = 'text/javascript';
		adw.async = true;
		adw.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://s') + '.emarbox.com/js/adw.js'+_oztime;
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(adw, s);
	})();
	
	//百度
	window._hmt = window._hmt || [];
	-function (d) {
		var s = d.createElement('script'),
		e = d.getElementsByTagName('script')[0];
		e.parentNode.insertBefore(s, e);
		var f = (("https:" == document.location.protocol) ? " https://" : " http://");
		s.src = f+'hm.baidu.com/hm.js?0f3247ac99d901bc088d0950da260ebf';
	}(document);
	//推送百度代码 新页面推送百度 加快收录速度
	window._ozuid = App.util.getCookie('index_cookiename');
	(function () {
		var bp = document.createElement('script');
		bp.src = '//push.zhanzhang.baidu.com/push.js'+_oztime;
		var s = document.getElementsByTagName("script")[0];
		s.parentNode.insertBefore(bp, s);
	})();
	
	//无双代码
	(function(a,b,c,d,e){
	    var s= b.createElement(c);s.async=1;s.src='//t.agrantsem.com/tg.js?c='+d+'&t='+e;
	    var r= b.getElementsByTagName(c)[0];r.parentNode.insertBefore(s,r);
	})(window,document,'script','AG_131112_MXDJ','1');
	
	
	//click99代码
	-function (d) {
		var s = d.createElement('script'),
		e = d.getElementsByTagName('script')[0];
		e.parentNode.insertBefore(s, e);
		if(location.pathname === "/userAddressinfoShop/payAddress/1"){
			s.src = 'http://orders.roseonly.com.cn/resources/js/seo/click99/o_code_stdpc.js';			
		}else{
			s.src = 'http://orders.roseonly.com.cn/resources/js/seo/click99/o_code_pc.js';			
		}
	}(document);
	var click99userid='';
	var arrStr = document.cookie.split("; ");
	for(var i = 0;i < arrStr.length;i ++){
		var temp = arrStr[i].split("=");
		if(temp[0] == 'index_cookiename') {
			click99userid =temp[1];
		}
	}
	window._ozuid=click99userid;
	
	//品友代码
	if(location.href.indexOf('item')<0){
		window._py = window._py || [];
		_py.push(['a', 't5s..QA4PSdkyvq6N0CHHXwj6f0']);
		_py.push(['domain','stats.ipinyou.com']);
		_py.push(['e','']);
		-function(d) {
			var s = d.createElement('script'),
			e = d.getElementsByTagName('script')[0]; 
			e.parentNode.insertBefore(s, e);
			var f = 'https:' == location.protocol;
			s.src = (f ? 'https' : 'http') + '://'+(f?'fm.ipinyou.com':'fm.p0y.cn')+'/j/adv.js'+_oztime;
		}(document);
	}	

	//GA用户分析网站数据代码
	(function(i,s,o,g,r,a,m){
		i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
			(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
			m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	})(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
	ga('create', 'UA-102444605-1', 'auto');
	ga('send', 'pageview');

	if(typeof _thirdTP === "function"){
    	_thirdTP();
    }
	
	//console.log("thrid code load end");
}



</script>
<div class="wg_add_layer">
	<div>
		<p>您确定要删除收货地址吗？</p>
		<div>
			<span class="btn_ok">确定</span>
			<span class="btn_cancel">取消</span>
		</div>
	</div>
</div>

<!-- modify by fanhaijian 订单确定页统计代码-->
<script type="text/javascript">
(function(){	
	//获取userAgent信息
	if(navigator && navigator.userAgent){
		$("#browser").val(navigator.userAgent);
	}
	
	//获取赠品
	var _html = '';
	
	$("#div_zengpin").html(_html);
	
	$.ajax({
		type:'get',
		url:'http://www.roseonly.com.cn/pages/ProProducts/getShop_1.htm',
		dataType:'jsonp',
		success:function(result){
			if(result && result.provinces){
				var _html = "";
				var _arr = result.provinces;
				for(var i=0;i<_arr.length;i++){
					_html += "<option value='"+_arr[i].id+"'>"+_arr[i].name+"</option>";
				}
				$("#ddl_privince").html(_html);
				privincebind();
			}
		}
	});
	
	//实体店自提选择省份显示对应的实体店
	function privincebind(){
		$("#ddl_privince").bind("change",function(){
			var _pid = $(this).val();
			$(".wg_listshop").hide();
			$(".wg_listshop_"+_pid).show();
			$(".wg_listshop_"+_pid).eq(0).find("input").click();
			var shopid = $(".wg_listshop_"+_pid).eq(0).find("input").val();
			$("#address_select_shop_id").text(shopid);
		});
		$(".wg_listshop").hide();
		$(".wg_listshop_1").show();
		var shopid = $(".wg_listshop_1").eq(0).find("input").val();
		$("#address_select_shop_id").text(shopid);
		if($("#gettypezt")[0] && $("#gettypezt")[0].checked){
			//$("#ddl_privince").change();
			fun_select_ordertype('1');
		}		
	}
}());

function _thirdTP(){
	var _mvq = window._mvq || []; 
	window._mvq = _mvq;
	_mvq.push(['$setAccount', 'm-23932-1']);

	var smvquserid=App.util.getCookie('index_cookiename');

	_mvq.push(['$setGeneral', 'checkout', '', /*用户名*/ '', /*用户id*/ smvquserid]);
	_mvq.push(['$logConversion']);
	
		_mvq.push(['$addCartGoods',/*商品id*/ '3850',/*商品名称*/ '玫瑰熊-嫣红-花球版-大型球形', /*商品价格*/ '1520.0', /*商品数量*/ '1']);
	
	_mvq.push(['$logData']);	
}
</script>
</div>
</body>
</html>