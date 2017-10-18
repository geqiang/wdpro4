/**
 * Created by Administrator on 2016/10/5.
 */
$(function(){
// 加入购物车
var addShoppingCart = {
    stuId:644348022, //id
    RequestMode:"get",//请求方式
    sendAddress:"http://10.35.164.48:8080/myWeb/addShoppingCart.jsp",//url
    userName:$(".havaName"),//用户名
    goodsId:$(".itemShow_right_p2 span"),//物品编号
    goodsCount:$(".itemShow_right_nump2"), //商品数量
    clickInp:$(".itemShow_right_waitby"),//点击的地方
    callBackJson:null,//传回来的数据
    shoppNum:$(".top_right_lastA span"),//要改变的购物车旁边的那个数据
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


});