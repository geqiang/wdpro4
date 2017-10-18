/**
 * Created by Administrator on 2016/9/24.
 */
$(function(){
    /*淡入淡出轮播图*/
    var banner= {
        imgAll: $(".banner_image img"),
        spanAll: $(".banner_tb span"),
        bannerCon: $(".banner"),
        bannerLeftImg: $(".banner_left"),
        bannerRightImg: $(".banner_right"),
        now: 0,
        next: 0,
        tir: null,
        inti: function () {
            this.startImgMove();
            this.stopImgMove();
            this.againMoveImg();
            this.clickSpanShowImg();
            this.clickLeftImgRemove();
            this.clickRightImgRemove();
            this.changeImg();
        },
        //开始移动
        startImgMove: function () {
            var that = this;
            clearInterval(this.tir);
            this.tir = setInterval(function () {
                that.next++;
                that.moveImg();
            }, 1500);
        },
        //当前图片隐藏，下一个图片显示
        moveImg: function () {
            this.next %= this.imgAll.length;
            this.spanAll.eq(this.now).removeClass("spanAddBgC");
            this.spanAll.eq(this.next).addClass("spanAddBgC");
            this.imgAll.eq(this.now).animate({
                opacity: 0
            }, 1000);
            this.imgAll.eq(this.next).animate({
                opacity: 1
            }, 1000);
            this.now = this.next;
        },
        //鼠标放在banner上面停止移动
        stopImgMove: function () {
            var that = this;
            this.bannerCon.on("mouseover", function () {
                that.bannerLeftImg.css("display", "block");
                that.bannerRightImg.css("display", "block");
                clearInterval(that.tir);
            });
        },
        //鼠标移开，再次开始
        againMoveImg: function () {
            var that = this;
            this.bannerCon.on("mouseout", function () {
                that.startImgMove();
                that.bannerLeftImg.css("display", "none");
                that.bannerRightImg.css("display", "none");
            })
        },
        //鼠标放在原点上，跳转到对应的图片
        clickSpanShowImg: function () {
            var that = this;
            that.spanAll.click(function () {
                that.now = that.spanAll.index(this);
                that.next = that.now;
                that.changeImg();
            });
            this.spanAll.mouseover(function () {
                that.startImgMove();
            });
        },
        //点击左侧图片跳转上一个
        clickLeftImgRemove: function () {
            var that = this;
            this.bannerLeftImg.on("click",function(event){
                that.now = that.now-1;
                if(that.now<0){
                    that.now=that.imgAll.length-1;
                }
                that.next=that.now;
                that.changeImg();
                event.stopPropagation();
            });
        },
        //点击右侧图片跳转下一个
        clickRightImgRemove:function(){
            var that = this;
            this.bannerRightImg.on("click",function(event){
                that.now ++;
                if(that.now>that.imgAll.length-1){
                    that.now=0
                }
                that.next = that.now;
                that.changeImg();
                event.stopPropagation();
            })
        },
        changeImg:function(){
            var that = this;
            that.spanAll.eq(that.now).addClass("spanAddBgC").siblings().removeClass("spanAddBgC");
            that.imgAll.css("opacity", 0);
            that.imgAll.eq(that.now).css("opacity", 1);
        }
    };
    banner.inti();
    //新品热卖中间特效
    var newsRelease={
        bga:$(".news_release_bga"),
        Imgs:$(".news_release_imgDt"),
        oldHeight:"0",
        oldWidth:"0",
        oldLeft:"144px",
        oldTop:"140px",
        newHeight:"280px",
        newWidth:"288px",
        newLeft:"0",
        newTop:"0",
        init:function(){
            this.bgaToBig();
            this.bgaToSmall();
        },
        bgaToBig:function(){
            //变大
            var that = this;
            that.Imgs.mouseenter(function(){
                var index = that.Imgs.index(this);
                that.bga.eq(index).stop(true).animate({
                    height:that.newHeight,
                    width:that.newWidth,
                    left:that.newLeft,
                    top:that.newTop
                },500);
          });
        },
        bgaToSmall:function(){
            var that = this;
            that.Imgs.mouseleave(function(){
                var index = that.Imgs.index(this);
                that.bga.eq(index).stop(true).animate({
                    height:that.oldHeight,
                    width:that.oldWidth,
                    left:that.oldLeft,
                    top:that.oldTop
                },500);
            });
        }

    };
    newsRelease.init();
    /*------------------页签和轮播开始----------------*/
    var TableCarousel={
        stopTime:null,
        index:0,
        addTop:"4px",
        moveDiv:$(".hotShop_show_butBox"),
        everyDiv:$(".hotShop_show_butOne"),
        allLi:$(".hotShop_show_cen li"),
        allDl:$(".hotShop_dl"),
        init:function(){
            this.moveTab();
            this.onTimemoveTab();
            this.stopMove();
            this.enterLi();
            this.leaveLi();
            this.enterDl();
        },
        //定时更换
        onTimemoveTab:function(){
            var that=this;
            clearInterval(that.stopTime);
           that.stopTime=setInterval(function(){
                    that.moveTab();
            },2000);
        },
        moveTab:function(){
            var that=this;
            that.index++;
            if(that.index==5){
                that.index=1;
                that.moveDiv.css("left","0");
            }
            if(that.index==4){
                that.allLi.eq(0).addClass("changeBorder").siblings().removeClass("changeBorder");
            }
            that.allLi.eq(that.index).addClass("changeBorder").siblings().removeClass("changeBorder");
            that.moveDiv.stop(true).animate({
                left:(that.index)*(that.everyDiv).eq(that.index).width()*(-1)+"px"
            },1000);
        },
        stopMove:function(){
            var that = this;
            that.moveDiv.mouseenter(function(){
                    clearInterval(that.stopTime);
            });
            that.moveDiv.mouseleave(function(){
                that.onTimemoveTab();
            });
        },
        enterLi:function(){
            var that = this;
            that.allLi.mouseenter(function(){
               that.index=that.allLi.index(this)-1;
                that.moveTab();
                clearInterval(that.stopTime);
            });
        },
        leaveLi:function(){
            var that = this;
            that.allLi.mouseleave(function(){
                that.onTimemoveTab();
            })
        },
        enterDl:function(){
        var that = this;
            that.allDl.mouseenter(function(){
                $(this).addClass("changeDlBgC").siblings().removeClass("changeDlBgC");
                $(this).find("img").stop(true).animate({
                    opacity:"0.8"
                },500)
            });
            that.allDl.mouseleave(function(){
                $(this).removeClass("changeDlBgC");
                $(this).find("img").stop(true).animate({
                    opacity:"1"
                },500)
            });
        }
    };
    TableCarousel.init();
    /*------------------------------------------------- 热品展示-------------------------------------------*/
    var hotShow={
        allImg:$(".navShop_center li"),
        imgBga:$(".img_bga"),
        index:0,
        init:function(){
            this.changeBoxShadow();
        },
        changeBoxShadow:function(){
            var that = this;
            that.allImg.mouseenter(function(){
               $(this).stop(true).animate({
                   "bottom":"0"
               },500);
                that.index=that.allImg.index(this);
               // that.imgBga.eq(that.index).stop(true).slideDown(300);
                $(this).addClass("changeYinYing").siblings().removeClass("changeYinYing");
            });
            that.allImg.mouseleave(function(){
                $(this).removeClass("changeYinYing");
                $(this).stop(true).animate({
                    "bottom":"-10px"
                },500);
                that.index=that.allImg.index(this);
               // that.imgBga.eq(that.index).stop(true).slideUp(300);
            })
        }
    };
    hotShow.init();
});




