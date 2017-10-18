/**
 * Created by Administrator on 2016/10/8.
 */
$(function(){
      var   magnifyImg={
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
});