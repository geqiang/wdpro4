/**
 * Created by Administrator on 2016/9/22.
 */
$(function(){
    $(".foot_top_left img").last().hover(showImg,hideImg);
    function showImg(){
        $(".foot_top_right").next().css("display","block");
    }
    function hideImg(){
        $(".foot_top_right").next().css("display","none");
    }
});
$(function(){
/*------------------------------------------------二级菜单开始------------------------------------*/
    $("#nav li").hover(secondNav,hidSecondNav);
    $(".ejcdDiv>div").hover(secondN,hidSecond);
        /*--------------------------------鼠标移入二级菜单------*/
    function secondN(){
        var index=$(".ejcdDiv>div").index(this);
        $("#nav li").not($(".ulLastLi")).children().eq(index).addClass("changeNavColor");
        $(this).stop(true).animate({
            paddingTop:"24px",
            paddingRight:"67px",
            minHeight:"320px"
        },300);
        $(".ejcdDiv>div").eq(index).stop(true).slideDown(1000);
    }
    /*----------------------------------------------鼠标移出二级菜单--*/
    function hidSecond(){
        var index=$(".ejcdDiv>div").index(this);
        if(index<($("#nav li").length-1)){
            $("#nav li").children().eq(index).removeClass("changeNavColor");
            $(this).stop(true).animate({
                paddingTop:"0px",
                paddingRight:"0px",
                minHeight:"0"
            },300);
        }
    }
    /*--------------------------------鼠标移入Nav------*/
    function secondNav(){
        var ind=$("#nav li").index(this);
        $("#nav a").eq(ind).addClass("changeNavColor");
       // $(".ejcdDiv>div").eq(ind).slideDown(1000);
        $(".ejcdDiv>div").eq(ind).css("display","block");
       if(ind<6){
           $(".ejcdDiv>div").eq(ind).stop(false).animate({
               paddingTop:"24px",
               paddingRight:"67px",
               minHeight:"320px"
           },300);
           // $(".ejcdDiv>div").eq(ind).stop(true).slideUp(1000);
      }
    }
    /*----------------------------------------------鼠标移出Nav----*/
    function hidSecondNav(){
        $(this).children().removeClass("changeNavColor");
        var index=$("#nav li").index(this);
            $(".ejcdDiv>div").eq(index).stop(false).animate({
                minHeight:"0",
                paddingTop:"0px",
                paddingRight:"0px"
            },300);
        // $(".ejcdDiv>div").eq(index).stop(true).slideUp(1000);

    }
    /*------------------------------------------------二级菜单结束------------------------------------*/
});
    //滚动条滚动 改变定位方式
 $(function(){
     $(window).scroll(stopTop);
        var offY=$("#allNav").offset().top;
        function stopTop() {
            var temp=true;
            var scrollTop = $(document).scrollTop();
            if (offY <= scrollTop) {
                $("#allNav").css("position", "fixed");
                temp=true;
            }
            if (offY >= scrollTop){
                $("#allNav").css("position", "static");
                temp=false;
            }
            if(temp){
                $(".ulLastLi").css("display","block");
                $(".fistUl a").css("width","144px");
                $(".fistUl").css("min-width","1020px");
            }else{
                $(".ulLastLi").css("display","none");
                $(".fistUl a").css("width","175px");
            }
        }
 });
/*-------------------foot_top大微信图---------------------------*/

