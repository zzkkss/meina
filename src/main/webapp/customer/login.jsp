<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.security.web.WebAttributes"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<sec:csrfMetaTags />
<script type="text/javascript">
if(top.location != location){ 
    top.location.href= location.href; 
}  
</script>
<title>商户登陆</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="/shop/css/style.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<!-- <link href='http://fonts.googleapis.com/css?family=Open+Sans:700,300,600,800,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Marvel:400,700' rel='stylesheet' type='text/css'> -->
<!--//webfonts-->

</head>
<body>
	<h1>欢迎来到美哪</h1>
	<div class="registration">
		<h2>欢迎使用商户管理系统</h2>
		<div class="avtar">
			<img src="/shop/images/color.jpg" />
		</div>
		<div class="form-info">


			<%-- <form action="/loginR.do" method="post" id="password-form" class=" username-required input-focus"> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="hidden" id="logintype" value="" />
${SPRING_SECURITY_LAST_EXCEPTION.message} 
			<div class="control-group">
				<label id="accountName-label" class="control-label" for="accountName">输入您的用户名</label>
				<div class="controls">
					<input type="text" aria-labelledby="accountName-label" id="uname" value="" name="username" title="输入您的用户名" maxlength="320" tabindex="1" class="input-block input-large" placeholder="输入您的用户名" />
				</div>
			</div>
			<div class="control-group">
				<label id="password-label" class="control-label" for="password">输入您的密码</label>
				<div class="controls">
					<input type="password" aria-labelledby="password-label" id="pword" value="" name="password" title="输入您的密码" maxlength="16" tabindex="1" class="input-block input-large" autocomplete="off"
						placeholder="输入您的密码" />
				</div>
			</div>
			<div class="persistWrapper">
				<label id="persistLogin-label" class="checkbox-label css-label  checked" for="persistLogin"> <input type="checkbox" aria-labelledby="persistLogin-label" id="persistLogin"
					name="persistLogin" checked="checked" tabindex="1" /> <span class="input-checkbox"></span> 保持登录状态
				</label>
			</div>
			<div class="control-group submit ">
				<button type="submit" id="lgbtn" class="btn btn-primary btn-large btn-block " data-loading-text="" tabindex="1">
					登录 <i class="spinner-battlenet"></i>
				</button>
				<img alt="" src="/captcha.do" />
			</div>
			<br>
			<div id="wxlo" class="control-group submit "></div>
		</form>  --%>


			<form action="/loginCustomer.do" method="post" > 
			  <div id="msg" style="display: none" ><h2 style="color: red">${msg} </h2> </div>
    <script type="text/javascript">
    var msg='${msg}';
    if(msg!=null){
    	//$("#msg").css("display","");
    	 document.getElementById('msg').style.display="";  
    }
    </script>
		<%-- 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
				<input  id="uname"  name="username"  type="text" class="text" value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}">
				 <input id="pword"  name="password"  type="text" class="text" value="密码" onfocus="this.value = '';this.type='password'" onblur="if (this.value == '') {this.type='text';this.value = '密码';}"> 
				
				 <!--    <div class="form_box form_verification none">
            <div class="form_item">
                <div class="input_box">
                    <input id="validateSig" type="hidden"/>
                    <input id="register_form-phone-verification" class="text_verification" type="text" placeholder="请输入验证码" maxlength="4">
                    <img class="pic_verification" alt="" width="105" height="43">
                    <span class="icon_refresh icon-refresh"></span>
                </div>
            </div>
        </div> -->
				 <img src="/captcha.do" />
				<input  id="captcha"  name="captcha"  type="text" class="text" value="验证码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '验证码';}"> 
				
<!-- 				 <script type="text/javascript">  
        function reImg(){  
            var img = document.getElementById("Img");  
            img.src = "Img?rnd=" + Math.random();  
        }   -->
    </script>  
				
				<!-- <textarea type="text"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message...';}" required="">Message...</textarea> -->
				<input type="submit"  value="登录">
			</form>
		</div>
 		<ul class="bottom-sc-icons">
 		<li><a href="/customerRegister.do" class="register">还没有账号？点击注册</a></li>
			<!-- <li><a href="#" class="facebook"><img src="/shop/images/fb.png" />Facebook</a></li>
			<li><a href="#" class="twitter"><img src="/shop/images/tw.png" />Twitter</a></li>
			<div class="sc-icons">
				<li><a href="#" class="google-p"><img src="/shop/images/gp.png" />Google +</a></li>
				<li><a href="#" class="in"><img src="/shop/images/in.png" />Linkedin</a></li>
			</div> -->
		</ul> 
		<div class="clear"></div>
	</div>
<!-- 	 <div class="copy-rights">
		<p>
			Design by <a href="#" target="_blank">zks</a>
		</p>
	</div>  -->
</body>
</html>