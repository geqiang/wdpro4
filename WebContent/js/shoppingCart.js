$(function(){
    var callBackJsonArr=[];
    //显示加入了购物车的 商品
    $(window).load(function(){
        $.get(
            "http://10.35.164.48:8080/myWeb/getShoppingCart.jsp",
            {
                stuId:644348022,
                userName:$(".havaName").html()
            },
            callBackFun
        )
    });
    function callBackFun(responseStr,status){
        if(status=="success"){
            callBackJsonArr=eval("("+responseStr+")");
            addArrNumber();
        }
    }
    function addArrNumber(){
        for(var i=0; i<callBackJsonArr.length;i++){
            addHTML(i);
        }
        zheceshi();
    }
    function addHTML(i){
        $(".shoppingCart_center tbody").append(
            "<tr class='shoppingCart_center_second_tr'>" +
            "<td class='shoppingCart_center_td1'>"+(i+1)+"</td>" +
            "<td class='shoppingCart_center_td2'>roseonly</td>" +
            "<td class='shoppingCart_center_td3'><img src='"+callBackJsonArr[i].goodsImg+"'><span>"+callBackJsonArr[i].goodsName+"</span></td> " +
            "<td class='shoppingCart_center_td4'>"+callBackJsonArr[i].goodsPrice+"</td>" +
            "<td class='shoppingCart_center_td5'><span class='cutNum'>-</span><p class='shoppNUmber'>"+callBackJsonArr[i].goodsCount+"</p><span class='addNum'>+</span></td> " +
            "<td class='shoppingCart_center_td6'>删除</td>" +
            "<td class='hidGoodId'>"+callBackJsonArr[i].goodsId+"</td>"+
            "</tr>")
    }
    //显示加入购物车的商品结束
    var addOrCut = null;
    var allMoney = null;
    function zheceshi(){
        addOrCut = {
            addNumber:$(".addNum"),//增加按钮
            cutNumber:$(".cutNum"),//减少按钮
            changeInpText:$(".shoppNUmber"),//需要改变的文本框
            userNames:$(".havaName"),//用户名
            goodId:$(".hidGoodId"),//商品编号
            deleteThis:$(".shoppingCart_center_td6"),//删除
            responseCon:null,
            allTr:$(".shoppingCart_center tr"),//所有的tr
            init:function(){
                this.addInpTextFun();
                this.cutNumberTextFun();
                this.deleteShop();
            },
            addInpTextFun:function(){
                var that = this;
                this.addNumber.click(function(){
                    var index = that.addNumber.index(this);
                    $.get(
                        "http://10.35.164.48:8080/myWeb/updateGoodsCount.jsp",
                        {
                            stuId:644348022,
                            userName:that.userNames.html(),
                            goodsId:that.goodId.eq(index).html(),
                            goodsCount:Number(that.changeInpText.eq(index).html())+1
                        },
                        function(responseStr,status){
                            if(status=="success"){
                                that.responseCon=responseStr;
                                if(!(that.responseCon.indexOf("true")>-1)){
                                    alert("库存不足或者达到购买上线了");
                                    return;
                                }else{
                                    that.changeInpText.eq(index).html(Number(that.changeInpText.eq(index).html())+1);
                                    allMondyNumAdd();
                                }
                            }
                        }
                    );


                })
            },
            cutNumberTextFun:function(){
                var that = this;
                this.cutNumber.click(function(){
                    var index = that.cutNumber.index(this);
                    if(that.changeInpText.eq(index).html()<=1){
                        that.changeInpText.eq(index).html(1)
                    }else{
                        $.get(
                            "http://10.35.164.48:8080/myWeb/updateGoodsCount.jsp",
                            {
                                stuId:644348022,
                                userName:that.userNames.html(),
                                goodsId:that.goodId.eq(index).html(),
                                goodsCount:Number(that.changeInpText.eq(index).html())-1
                            },
                            function(responseStr,status){
                                if(status=="success"){
                                    that.responseCon=responseStr;
                                    if(!(that.responseCon.indexOf("true")>-1)){
                                        alert("系统繁忙");
                                        return;
                                    }else{
                                        
                                        that.changeInpText.eq(index).html(Number(that.changeInpText.eq(index).html())-1);
                                        allMondyNumAdd();
                                       
                                    }
                                }
                            }
                        );
                    }

                })
            },
            deleteShop:function(){
                var that = this;
                this.deleteThis.click(function(){
                    var index = that.deleteThis.index($(this));
                    $.get(
                        "http://10.35.164.48:8080/myWeb/deleteGoods.jsp",
                        {
                            stuId:644348022,
                            userName:that.userNames.html(),
                            goodsId:that.goodId.eq(index-1).html(),
                            t:new Date()
                        },
                        function(a,b){
                            if(b=="success"){
                                if(a.indexOf(true)>-1){
                                  if(confirm("你确定要删除吗")){
                                   that.allTr.eq(index).detach();
                                    allMondyNumAdd();
                                  }
                                }
                            }
                        }
                    );

                })
            }

        };
        addOrCut.init();
        $(window).load(allMondyNumAdd());
        function allMondyNumAdd(){
            var sum =0;
            for(var i=0; i<$(".shoppNUmber").length;i++){
               sum =sum+Number($(".shoppNUmber").eq(i).html())*Number($(".shoppingCart_center_td4").eq(i+1).html())
            }
            $(".allMoney i").html(sum);
         }
     /*   function allMondyNumCut(){
            for(var i=0; i<$(".shoppNUmber").length;i++){
                sum =Number($(".shoppNUmber").eq(i).html())*Number($(".shoppingCart_center_td4").eq(i+1).html())
            }
            $(".allMoney i").html(sum);
        }
        function allMondyNumDelete(){
            for(var i=0; i<$(".shoppNUmber").length;i++){
                var sum =Number($(".shoppNUmber").eq(i).html())*Number($(".shoppingCart_center_td4").eq(i+1).html())
            }
            $(".allMoney i").html(sum);
        }*/


    }
    $(function(){
        $(".foot_top_left img").last().hover(showImg,hideImg);
        function showImg(){
            $(".foot_top_right").next().css("display","block");
        }
        function hideImg(){
            $(".foot_top_right").next().css("display","none");
        }
    });
});