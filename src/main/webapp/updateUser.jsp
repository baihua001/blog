<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Baihua
  Date: 2020/11/6
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/register.css"/>
    <link rel="stylesheet" href="css/footer&cbl.css"/>
    <link rel="stylesheet" href="css/daohang.css"/>
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/templet.js"></script>
    <title>注册</title>
    <script>
        /*
				表单校验：
					1.用户名：单词字符，长度8到20位
					2.密码：单词字符，长度8到20位
					3.昵称：非空
	    */
        function checkUsername() {
            var username = $("#username").val();
            var reg_username = /\w{8,20}$/;
            var flag = reg_username.test(username);
            if(flag){
                $("#username").css("border","");
            }else{
                $("#username").css("border","1px solid red");
            }
            return flag;
        }
        function checkPassword() {
            var password = $("#password").val();
            var reg_password = /\w{8,20}$/;
            var flag = reg_password.test(password);
            if(flag){
                $("#password").css("border","");
            }else{
                $("#password").css("border","1px solid red");
            }

            return flag;
        }
        function checkNickname(){
            var nickname = $("#nickname").val();
            var flag = nickname.replace(/(^s*)|(s*$)/g, "").length !=0;
            if (flag){
                $("#nickname").css("border","");
            }else {
                $("#nickname").css("border","1px solid red");
            }
            return flag;
        }

        $(function () {
            $("#registerForm").submit(function(){
                if(checkUsername() && checkPassword() && checkNickname()){
                    $.post("updateUserServlet",$("#registerForm").serialize(),function (data) {
                        if (data == "修改成功！"){
                            alert(data);
                            window.location.href = "findBlogByPageAndreaderSeverlet";
                        }else {
                            alert(data);
                        }
                    });

                }
                //2.不让页面跳转
                return false;
                //如果这个方法没有返回值，或者返回为true，则表单提交，如果返回为false，则表单不提交
            });

            $("#username").blur(checkUsername);
            $("#password").blur(checkPassword);
            $("#nickname").blur(checkNickname);
        });

    </script>
</head>
<body>
<div id="main">
    <nav class=" navbar-inverse" id="daohang">
        <div class="daohang">
            <div class="navbar-header clearfix">
                <button type="button" class="zd" id="zd">
                    <span class="glyphicon glyphicon-align-justify"></span>
                </button>
            </div>
            <div class="collapse navbar-collapse" id="daohangtiao">
                <span class="close"><a href="index.html"><i></i></a></span>
            </div>
        </div>

    </nav>
    <div class="main">
        <div class="container  ">
            <div class="c2">
                <a href=""></a><span>
						<img src="img/qifeiye.png"/>
					</span></a>

            </div>
            <div class="c3">
                <form id="registerForm" >
                    <div class="form-group">
                        <label for="username">用户名 *</label>
                        <input type="text" class="form-control" id="username" name="username"  readonly="true" value="${user.username}">
                        <span class="pp hide">禁止修改</span>
                    </div>
                    <div class="form-group">
                        <label for="password">密码 *</label>
                        <input type="text" class="form-control" id="password" name="password" value="${user.password}">
                        <span class="pp hide">此项必须填写</span>
                    </div>
                    <div class="form-group">
                        <label for="nickname">昵称 *</label>
                        <input type="text" class="form-control" id="nickname" name="nickname" value="${user.nickname}">
                        <span class="pp hide">此项必须填写</span>
                    </div>
                    <div class="form-group">
                        <c:if test="${user.headPort=='img/headPortrait/1.jpg'}">
                            <input type="radio"  name="headPort" value="img/headPortrait/1.jpg" checked="checked"><img src="img/headPortrait/1.jpg" width="80px" height="80px"/>
                            <input type="radio"  name="headPort" value="img/headPortrait/2.jpg" ><img src="img/headPortrait/2.jpg" width="80px" height="80px"/>
                            <input type="radio"  name="headPort" value="img/headPortrait/3.jpg" ><img src="img/headPortrait/3.jpg" width="80px" height="80px"/>
                        </c:if>
                        <c:if test="${user.headPort=='img/headPortrait/2.jpg'}">
                            <input type="radio"  name="headPort" value="img/headPortrait/1.jpg" ><img src="img/headPortrait/1.jpg" width="80px" height="80px"/>
                            <input type="radio"  name="headPort" value="img/headPortrait/2.jpg" checked="checked"><img src="img/headPortrait/2.jpg" width="80px" height="80px"/>
                            <input type="radio"  name="headPort" value="img/headPortrait/3.jpg" ><img src="img/headPortrait/3.jpg" width="80px" height="80px"/>
                        </c:if>
                        <c:if test="${user.headPort=='img/headPortrait/3.jpg'}">
                            <input type="radio"  name="headPort" value="img/headPortrait/1.jpg" ><img src="img/headPortrait/1.jpg" width="80px" height="80px"/>
                            <input type="radio"  name="headPort" value="img/headPortrait/2.jpg" ><img src="img/headPortrait/2.jpg" width="80px" height="80px"/>
                            <input type="radio"  name="headPort" value="img/headPortrait/3.jpg" checked="checked"><img src="img/headPortrait/3.jpg" width="80px" height="80px"/>
                        </c:if>
                    </div>

                    <div class="c3-1">
                        <button type="submit" class="btn btn-default btn1">修改</button>
                    </div>
                    <strong>123</strong>

                </form>
            </div>
        </div>
    </div>

</div>
</body>


</html>
