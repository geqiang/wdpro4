/**
 * Created by 那城 on 2016/10/1.
 */
$(function(){
    var colorArr=["#941b1e","#d1d1cb","#e45959","#941b1e","#da87a5","#dd2a3f"];
    //点击颜色更换图片 图片内容库
    // var allImgAndText=[
    //     {
    //         flowName:"朱砂",
    //         flowNameTow:"经典初心",
    //         clolr:"#941b1e",
    //         flowId:"R010101121",
    //         flowpice:"￥1999.0",
    //         flowImg1:"../images/14701945928768231.png",
    //         flowImg2:"../images/14697834422372911.png",
    //         flowImg3:"../images/14697834422837817.png",
    //         flowImg4:"../images/14697834423151620.png",
    //         flowImg5:"../images/14697834423632274.png"
    //     },
    //     {
    //         flowName:"情动",
    //         flowNameTow:"经典情动",
    //         clolr:"#dd2a3f",
    //         flowId:"R010101131",
    //         flowpice:"￥1999.0",
    //         flowImg1:"../images/14352182232678477.png",
    //         flowImg2:"../images/14371044178771361.png",
    //         flowImg3:"../images/14371044179361651.png",
    //         flowImg4:"../images/14371044179959421.png",
    //         flowImg5:"../images/14401497219486362.png"
    //     },
    //     {
    //         flowName:"惊艳",
    //         flowNameTow:"经典惊艳",
    //         clolr:"#dd2a3f",
    //         flowId:"R010101122",
    //         flowpice:"￥1999.0",
    //         flowImg1:"../images/14585439727298952.png",
    //         flowImg2:"../images/14371044178771361.png",
    //         flowImg3:"../images/14371044179361651.png",
    //         flowImg4:"../images/14371044179959421.png",
    //         flowImg5:"../images/14401497219486362.png"
    //     },
    //     {
    //         flowName:"情动",
    //         flowNameTow:"经典情动",
    //         clolr:"#dd2a3f",
    //         flowId:"R010101131",
    //         flowpice:"￥1999.0",
    //         flowImg1:"../images/14352182232678477.png",
    //         flowImg2:"../images/14371044178771361.png",
    //         flowImg3:"../images/14371044179361651.png",
    //         flowImg4:"../images/14371044179959421.png",
    //         flowImg5:"../images/14401497219486362.png"
    //     },
    //     {
    //         flowName:"情动",
    //         flowNameTow:"经典情动",
    //         clolr:"#dd2a3f",
    //         flowId:"R010101131",
    //         flowpice:"￥1999.0",
    //         flowImg1:"../images/14352182232678477.png",
    //         flowImg2:"../images/14371044178771361.png",
    //         flowImg3:"../images/14371044179361651.png",
    //         flowImg4:"../images/14371044179959421.png",
    //         flowImg5:"../images/14401497219486362.png"
    //     },
    //     {
    //         flowName:"情动",
    //         flowNameTow:"经典情动",
    //         clolr:"#dd2a3f",
    //         flowId:"R010101131",
    //         flowpice:"￥1999.0",
    //         flowImg1:"../images/14352182232678477.png",
    //         flowImg2:"../images/14371044178771361.png",
    //         flowImg3:"../images/14371044179361651.png",
    //         flowImg4:"../images/14371044179959421.png",
    //         flowImg5:"../images/14401497219486362.png"
    //     }
    // ];
    $(window).load(function(){
        $(".itemShow_right_color span").each(function(i){
            $(this).css("background",colorArr[i]);
        })
    });
    var changeThisImg = function(clickImg, ImgChange){
        $(clickImg).click(function(){
            ImgChange.attr("src",$(this).attr("src"));
        })
    };
    var clickImgChange={
        allImg:$(".itemShow_right_smallImg img"), //获取所有的需要点击的图片
        changeImg:$(".itemShow_center img"),    //需要改变的图片
        changeImgStyle:"changeImgStyle", //给改变图片添加的样式
        toChange:changeThisImg,
        init:function(){
            this.toChange(this.allImg,this.changeImg);
            this.changeBorder();
        },
        changeBorder:function(){
            var that = this;
            that.allImg.click(function(){
                $(this).addClass(that.changeImgStyle).siblings().removeClass(that.changeImgStyle);
            })
        }
    };
   clickImgChange.init();
    // 个数
    var changeNum = {
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
                $(".count1").val($(".itemShow_right_nump2").text());
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
                $(".count1").val($(".itemShow_right_nump2").text());
            })
        }
    };
    changeNum.init();
//放大镜效果
    $(function(){
        var zoom = {
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
    });
});
//购物车特效开始

