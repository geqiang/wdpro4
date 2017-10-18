/**
 * Created by 那城 on 2016/9/27.
 */
$(function(){
    //向服务器请求
    var callBackJson =null;
    $(window).load(toTwoCarte);
    function toTwoCarte(){
        $.get(
            "http://10.35.164.48:8080/myWeb/getGoodsList.jsp",
            {stuId:"644348022"},
            callBackFun
        )
    }
    function callBackFun(responseStr,status){
        if(status=="success"){
            callBackJson=eval("("+responseStr+")");
            toWebLength();
        }
    }
    function toWebLength(){
        for(var i=0; i<callBackJson.length; i++){
            addToWeb(i);
        }
        voluation();
    }
    function addToWeb(i){
        var dlObj=$("<dl></dl>");
        var dtObj = $("<dt></dt>").append($("<a href='details_flower_0"+(i+1)+".html'></a>").append("<img src='"+callBackJson[i].goodsImg+"' />"));
        var ddFirst =$("<dd></dd>").append("<a href='details_flower_0"+(i+1)+".html'>"+callBackJson[i].goodsName+"</a>");
        var ddSec = $("<dd></dd>").append("<a href='details_flower_0"+(i+1)+".html'>"+callBackJson[i].goodsContent+callBackJson[i].goodsCount+"支</a>")
        var ddthirty = $("<dd></dd>").append("<a href='details_flower_0"+(i+1)+".html'>"+callBackJson[i].goodsPrice+"</a>");
        $(dlObj).prependTo(".showShop").append(dtObj).append(ddFirst).append(ddSec).append(ddthirty);
    }
    var clickLi={
        allLi:$(".toolLeft li"),
        init:function(){
            this.changeLi();
        },
        changeLi:function(){
            var that = this;
            that.allLi.click(function(){
                $(this).addClass("addLiBga").siblings().removeClass("addLiBga");
            })
        }
    };
    clickLi.init();
    //添加放大效果
    var magnifyImg={
        allImg:$(".showShop img"),
        allDl:$(".showShop dl"),
        init:function(){
            this.toBig();
            this.toSmall();
        },
        toBig:function(){
            var that = this;
            that.allImg.mouseenter(function(){
                that.allDl.eq(that.allImg.index(this)).addClass("showShopBgC");
                $(this).stop(true).animate({
                    width:"350px",
                    height:"350px",
                    left:"-25px",
                    top:"-25px"
                });
            });
        },
        toSmall:function() {
            var that = this;
            that.allImg.mouseleave(function () {
                that.allDl.eq(that.allImg.index(this)).removeClass("showShopBgC");
                $(this).stop(true).animate({
                    width: "300px",
                    height: "300px",
                    left: "0",
                    top: "0"
                });
            });
        }
    };
    magnifyImg.init();
    function  voluation(){
        magnifyImg={
            allImg:$(".showShop img"),
            allDl:$(".showShop dl"),
            init:function(){
                this.toBig();
                this.toSmall();
            },
            toBig:function(){
                var that = this;
                that.allImg.mouseenter(function(){
                    that.allDl.eq(that.allImg.index(this)).addClass("showShopBgC");
                    $(this).stop(true).animate({
                        width:"350px",
                        height:"350px",
                        left:"-25px",
                        top:"-25px"
                    });
                });
            },
            toSmall:function() {
                var that = this;
                that.allImg.mouseleave(function () {
                    that.allDl.eq(that.allImg.index(this)).removeClass("showShopBgC");
                    $(this).stop(true).animate({
                        width: "300px",
                        height: "300px",
                        left: "0",
                        top: "0"
                    });
                });
            }
        };
        magnifyImg.init();
    }

























});