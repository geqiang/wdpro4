/**
 * Created by Administrator on 2016/9/28.
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
                $(this).parent().css({border:"2px solid #ccc"})
            });
            this.allInp.blur(function(){
                $(this).parent().css({border:"1px solid #ccc"});
            });
        }
    };
   inpBorder.init();
    //注册验证
    var isTrueNumber={
        allIsTrue:[],
        Inp:$(".rigis_inp_text input"),//获取输入的手机号码
        newsPrompt:"请输入合法的手机号码",//要显示的提示信息
        newsPromptDiv:$(".provingFalse"),//显示手机号码合法性的地方
        inpEmail:$(".rigis_inp_Email input"), //获取输入的邮箱
        EmailPrompt:"请输入合法的邮箱",//提示信息
        showEmailPrompt:$(".provingEmail"),//显示提示信息的地方
        init:function(){
            this.isPhoneTrue();
            this.EmailIsTrue();
            this.clickChangeimgCode();
            this.getImgCode();
            this.isTrueImgCode();
            this.testPassword();
          //  this.isTrueZhm();
        },
        //手机号码合法性验证
        isPhoneTrue:function(){
            var that = this;
            this.Inp.blur(function(){
                phoneTrue(that);
            });
        },

        //邮箱合法性验证
        EmailIsTrue:function(){
            var that = this;
          that.inpEmail.on("blur",function(){
            var reg = /^\w{6,20}@[a-zA-Z0-9]+(\.(com|cn|net))+$/;
            if(reg.test(that.inpEmail.val())){
                that.showEmailPrompt.html("");
                return true;
            }else{
                that.showEmailPrompt.html(that.EmailPrompt);
                return false;
            }
          });
        },
        //图片验证码
            //生成图片验证码
        allCodeImage:['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9'],
         imageCodeNumber:2,   //验证码的数量
        codeImage:"",//每次抽取到的验证码拼起来
        showImageCode:$(".img_code"),//显示验证码的地方
        getInpCode:$(".rigis_img_code input"),//获取输入的信息
        showPromptText:"验证码错误",   //要显示的提示内容
        showPrompt:$(".provingImgCode"), //显示提示内容的地方
        clickImg:$(".rigis_changeCode"),    //点击更换验证码的地方
        clickChangeimgCode:function(){
            var that = this;
            that.clickImg.on("click",function(){
                that.getImgCode();
            })
        },
        //获取验证码
        getImgCode:function(){
            this.codeImage="";
            for(var i=0; i<this.imageCodeNumber; i++){
              this.codeImage = this.codeImage+this.allCodeImage[parseInt(Math.random()*this.allCodeImage.length)];
            }
            this.showImageCode.html(this.codeImage);
        },
        //判断输入的验证码是否有效
       isTrueImgCode:function(){
           var that = this;
           this.getInpCode.blur(function(){
               that.showPrompt.html(" ");
               if(that.getInpCode.val().toLowerCase()==that.showImageCode.html().toLowerCase()){
                   return true;
               }else{
                   that.showPrompt.html(that.showPromptText);
                   return false;
               }

           });
       },
       	//两次密码判断
       
		
        //密码合法性判断
        passInp:$(".rigis_password input"),//密码所在的文本框
        showFalsePrompt:$(".provingPassword"), //提示信息显示的地方
        promptNews:"密码格式不对，只能由6到16位英文字母组成",//要提示的信息
        testPassword:function(){
            var that = this;
            this.passInp.blur(function(){
                that.showFalsePrompt.html("");
                var reg =/^[a-zA-Z]{6,16}$/;
                if(reg.test($(this).val())){
                    return true;
                }else{
                    that.showFalsePrompt.html(that.promptNews);
                    return false;
                }
            });
        },
        //账号合法性判断
        textInp:$(".rigis_inp_zhm input"),//获取账号文本框
        outText:"账号名只能由应为6~16字母组成",//需要显示的内容
        outTextEmt:$(".provingzhm"), //显示提示信息的地方
        isTrueZhm:function(){
            var that = this;
                that.outTextEmt.html("");
                var reg=/^[a-zA-Z]{6,16}$/;
                if(reg.test(that.textInp.val())){
                    return true;
                }else{
                    that.outTextEmt.html(that.outText);
                    return false;
                }
            }
    };
    isTrueNumber.init();
    function phoneTrue(that){
        var reg=/^1[3|4|5|7|8]\d{9}$/;
         that.newsPromptDiv.html(" ");
        if(reg.test(that.Inp.val())){
            return true;
        }else{
            that.newsPromptDiv.html(that.newsPrompt);
            return false;
        }
    }
    //ajax请求

    $(".rigis_inp_zhm input").blur(
        function(){
            if(isTrueNumber.isTrueZhm()) {
                $.get(
                    "Userservlet?op=zhucheTest",
                    {stuId: "644348022", userName: $(".rigis_inp_zhm input").val()},
                    function (responseStr, status) {
                        if (status == "success") {
                            if (responseStr.indexOf("0") > -1) {
                                $(".provingzhm").html("好棒的用户名，赶紧设置密码吧");
                                isTrueNumber.allIsTrue.push(1);
                            } else {
                                $(".provingzhm").html("亲，该用户名已经被使用，请更换用户名");
                                isTrueNumber.allIsTrue.push(0);
                            }
                        } else {
                            $("#userNameSpan").html("系统繁忙");
                        }
                    }
                );
            }
        }
    );
    
    //注册
    /* 
    $(".rigis_submit").click(
        function() {
            if (true){
                $.post(
                    "http://10.35.164.48:8080/myWeb/reg.jsp",
                    {
                        stuId: "644348022",
                        userName: $(".rigis_inp_zhm input").val(),
                        userPass: $(".rigis_password input").val(),
                        userEmail: $(".rigis_inp_Email input").val()
                    },
                    function (responseStr, status){
                        if (status == "success") {
                            if (responseStr.indexOf("true") > -1) {
                                alert("注册成功");
                                location.href = "entry.html";
                            } else {
                                alert("亲，不好意思，注册失败");
                            }
                        } else {
                            alert.html("系统繁忙");
                        }
                    }
                );
            }
        }
    );
*/

});