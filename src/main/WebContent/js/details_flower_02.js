/**
 * Created by Administrator on 2016/10/4.
 */
$(function(){
    var callBackJson=null;
    $(window).load(goServer);
    //发送请求函数
    function goServer(){
        $.get(
           "http://10.35.164.48:8080/myWeb/getGoodsInfo.jsp",
            {
                stuId:644348022,
                goodsId:"f101101001110111"
            },
            callBackFunction
        )
    }
    //回调函数
    function callBackFunction(responseStr,status){
        if(status=="success"){
            callBackJson = eval("("+responseStr+")");
            addTwoWeb()
        }
    }
//动态添加（添加几个的函数）

//添加每个的函数
    function addTwoWeb(){
        var itemShowLeft = $("<div class='itemShow_left'></div>").appendTo(".itemShow");
        var itemShowCenter = $("<div class='itemShow_center'></div>").appendTo(".itemShow");
        var itemShowRight = $("<div class='itemShow_right'></div>").appendTo(".itemShow");
        //左边部分
        $("<dd></dd>").appendTo($("<dl></dl>").appendTo(itemShowLeft).append("<dt></dt>")).append(
            "<span>经典</span>"
        ).append(
            "<span class='itemShow_left_left'></span>"
        ).append(
            "<span class='itemShow_left_center'>"+callBackJson.goodsColor+"</span>"
        ).append(
            "<span class='itemShow_left_right'></span>"
        );
        //中间部分
        $("<div class='small-wrapper'></div>").appendTo(itemShowCenter).append(
            "<img src='"+callBackJson.goodsImg+"'/>"
        ).append(
            "<div class='filter'></div>"
        );
        $("<div class='large-wrapper'></div>").appendTo(itemShowCenter).append(
            "<img class='img-show' src='"+callBackJson.goodsImg+"' />"
        );
        // 右边部分
        $("<p class='itemShow_right_p1'>"+callBackJson.goodsName+"</p>").appendTo(itemShowRight);
        $("<p class='itemShow_right_p2'>鲜花玫瑰 19支  </p>").appendTo(itemShowRight).append(
            "<span>&nbsp;"+callBackJson.goodsId+"</span>");
        $("<div class='itemShow_right_money'>￥"+callBackJson.goodsPrice+"</div>").appendTo(itemShowRight);
        $("<div class='itemShow_right_color'></div>").appendTo(itemShowRight).append(
            "<p>可选颜色</p>"
        ).append(
            "<span style='background:cornflowerblue'></span>"
        );
        $("<div class='itemShow_right_num'></div>").appendTo(itemShowRight).append(
            "<p class='itemShow_right_nump1'>购买数量：</p>"
        ).append(
            $("<a href='javascript:;'></a>").append("<span class='itemShow_right_cut'>-</span>")
        ).append(
            "<p class='itemShow_right_nump2'>1</p>"
        ).append(
            $("<a href='javascript:;'></a>").append("<span class='itemShow_right_add'>+</span>")
        );
        $(" <div class='itemShow_right_by'><p class='itemShow_right_nowby'>立即购买</p><p class='itemShow_right_waitby'>加入购物车</p></div>").appendTo(itemShowRight)
        newZoom();
    }
    var zoom=null;
    var changeNum = null;
    var addShoppingCart = null
    function newZoom(){
         zoom = {
            sWrapper:$(".small-wrapper"),
            lWrapper:$('.large-wrapper'),
            filter: $('.small-wrapper .filter'),
            imgShow: $('.large-wrapper .img-show'),
            //获取小图距离文档的距离
            offset: $('.small-wrapper').offset(),
            //初始化数据及方法调用
            init: function(){
                this.hover();
                this.mousemove();
            },
            //鼠标进入图片区域
            hover: function(){
                var that = this;
                this.sWrapper.hover(function(e){
                    //显示放大镜（滤镜）
                    that.filter.show();
                    that.lWrapper.show();
                    that.getPos(e);
                    that.filterMove();
                },function(){
                    that.filter.hide();
                    that.lWrapper.hide();
                });
            },
            mousemove: function(){
                var that = this;
                this.sWrapper.mousemove(function(e){
                    that.getPos(e);
                    that.filterMove();
                    that.imgShowMove();
                });
            },
            filterMove: function(){
                //console.log(e.offsetX,e.offsetY);
                this.filter.css({
                    top: this.y - 50,
                    left: this.x - 50
                });
            },
            imgShowMove: function(){
                this.imgShow.css({
                    top: -(this.y - 50) * 3, // 大图是小图的3倍
                    left: -(this.x - 50) * 3
                });
            },
            getPos: function(e){
                //获取鼠标距离小图盒子的距离
                var posX = e.pageX - this.offset.left;
                var posY = e.pageY - this.offset.top;
                this.x = (posX > 350 ? 350 : (posX < 50 ? 50 : posX));
                this.y = (posY > 350 ? 350 : (posY < 50 ? 50 : posY));
            }
        };
        zoom.init();
        changeNum = {
            changeSpanText$:(".itemShow_right_nump2"),
            addSpan:$(".itemShow_right_add"),
            cutSpan:$(".itemShow_right_cut"),
            changeSpan:$(".itemShow_right_nump2"),
            init:function(){
                this.addNum();
                this.cutNum();
            },
            addNum:function(){
                var that = this;
                that.addSpan.click(function(){
                    that.changeSpan.text(function(index,value){
                        return Number(value)+1;
                    })
                })
            },
            cutNum:function(){
                var that = this;
                that.cutSpan.click(function(){
                    that.changeSpan.text(function(index,value){
                        if(that.changeSpan.text()>1){
                            return Number(value)-1;
                        }
                    })
                })
            }
        };
        changeNum.init();
        addShoppingCart = {
            stuId:644348022, //id
            RequestMode:"get",//请求方式
            sendAddress:"http://10.35.164.48:8080/myWeb/addShoppingCart.jsp",//url
            userName:$(".havaName"),//用户名
            goodsId:$(".itemShow_right_p2 span"),//物品编号
            goodsCount:$(".itemShow_right_nump2"), //商品数量
            clickInp:$(".itemShow_right_waitby"),//点击的地方
            callBackJson:null,//传回来的数据
            shoppNum:$(".lastA span"),//要改变的购物车旁边的那个数据
            init:function(){
                this.getToServer();
            },
            //发送请求
            getToServer:function(){
                var that = this;
                this.clickInp.on("click",function(){
                    $.get(
                        that.sendAddress,
                        {
                            stuId:that.stuId,
                            userName:that.userName.html(),
                            goodsId:that.goodsId.html(),
                            goodsCount:Number(that.goodsCount.html())
                        },
                        //回调函数
                        function(responseStr,status){
                            if(status=="success"){
                                that.callBackJson=responseStr;
                                that.callBackJsonFun(that);
                            }
                        }
                    )
                })
            },
            //对传回来的数据的处理
            callBackJsonFun:function(that){
                if(that.callBackJson.indexOf("true")>-1){
                    that.shoppNum.html(Number(that.shoppNum.html())+1);
                }
            }
        };
        addShoppingCart.init();
    }
    // 加入购物车



});