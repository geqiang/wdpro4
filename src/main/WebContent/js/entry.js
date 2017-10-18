/**
 * Created by Administrator on 2016/9/27.
 */
$(function(){
    var inpBorder = {
        allInp:$("input"),
        init:function(){
            this.addBorder();
        },
        addBorder:function(){
            var that = this;
            this.allInp.focus(function(){
               $(this).parent().css({border:"2px solid #ccc",padding:"11px 0"})
            });
            this.allInp.blur(function(){
               $(this).parent().css({border:"1px solid #ccc",padding:"12px 0"});
            });
        }
    };
    inpBorder.init();
    //手机号码或者邮箱的合法性验证
    var isTrueNumber={
        Inp:$(".rigis_inp_text input"),
        //iphoneReg:new RegExp("^1\d{10}$"),
        // EmailTReg:new RegExp("^\w+@\w+(\.(net|com|cn))+$"),
        newsPrompt:"请输入合法用户名",
        newsPromptDiv:$(".isPrompt"),
        passThrough:true,
        init:function(){
            this.isTrue();
        },
        isTrue:function(){
            var that = this;
            this.Inp.blur(function(){
                var reg=/^[a-zA-Z]{6,16}$/;
                if(reg.test(that.Inp.val())){
                    that.newsPromptDiv.html(" ");
                }else{
                    that.newsPromptDiv.html(that.newsPrompt);
                    that.passThrough=false;
                }
            });
        }
        //登录不通过不允许想服务器发送请求
    };
    isTrueNumber.init();
    window.localStorage.a=false;
    $(".rigis_sub").click(
        function(){
            $.post(
                "Userservlet?op=denglu",
                {stuId:"644348022",userName:$(".rigis_inp_text input").val(),userPass:$(".rigis_inp_password input").val()},
                function(responseStr,status){
                    if(status=="success"){
                        if(responseStr.indexOf("true")>-1){
                           window.localStorage.a=true;
                           window.localStorage.haveName= $(".rigis_inp_text input").val();
                            location.href="index.jsp";
                        }else{
                            alert("账号或者密码有错");
                        }
                    }else{
                        alert.html("系统繁忙");
                    }
                }
            );
        }
    );
        //将登陆和注册换成欢迎您。。。

});