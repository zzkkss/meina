<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.security.web.WebAttributes"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width,initial-scale=1.0">
<meta name="Author" content="zks" />
<script type="text/javascript">
if(top.location != location){ 
    top.location.href= location.href; 
}  
</script>
<sec:csrfMetaTags />
<title>登录</title>
<script type="text/javascript" src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js"></script>
<style type="text/css">
* {
	overflow: hidden;
	font-size: 9pt;
}

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(background/images/login-background.jpg);
	height: 100%;
	width: 100%;
}

.input-container {
	margin-left: 30%;
	margin-top: 10%;
	width: 500px;
}

#password-form {
	margin-left: auto;
	margin-right: auto;
	width: 360px;
	padding-top: 10%
}

.control-group:after {
	clear: both;
}

.btn-large {
	font-size: 17px;
	height: 40px;
	line-height: 20px;
	margin: 0;
	padding: 9px 30px;
}

.btn-block {
	display: block;
	padding-left: 0;
	padding-right: 0;
	width: 100%;
}

.btn-primary {
	background-color: #098cc8;
	background-image: linear-gradient(to bottom, #0f9ada, #0076ad);
	border: 0 none;
	border-radius: 2px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.3), 0 0 0 1px rgba(255, 255, 255, 0.15) inset;
	color: #fff;
	transition: background-color 0.2s ease 0s, box-shadow 0.2s ease 0s, background-color 0.2s ease 0s, border-color 0.2s ease 0s, color 0.2s ease 0s;
}

.btn-wx {
	background-color: #3eb94e;
	background-image: url("https://open.weixin.qq.com/zh_CN/htmledition/res/assets/res-design-download/icon48_wx_button.png");
	background-repeat: no-repeat;
	background-position: center;
	border: 0 none;
	border-radius: 2px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.3), 0 0 0 1px rgba(255, 255, 255, 0.15) inset;
	color: #fff;
	transition: background-color 0.2s ease 0s, box-shadow 0.2s ease 0s, background-color 0.2s ease 0s, border-color 0.2s ease 0s, color 0.2s ease 0s;
}

.control-group:before,.control-group:after {
	content: ".";
	display: block;
	font-size: 0;
	height: 0;
	line-height: 0;
	overflow: hidden;
	visibility: hidden;
	width: 0;
}

input.input-large {
	font-size: 17px;
	height: 40px;
	line-height: 20px;
	margin: 5px 0;
	padding: 0 10px;
}

input:invalid,input:valid,input:required {
	box-shadow: inherit;
}

.uneditable-input.input-block,select.input-block,textarea.input-block,input.input-block[type="color"],input.input-block[type="date"],input.input-block[type="datetime"],input.input-block[type="datetime-local"],input.input-block[type="email"],input.input-block[type="month"],input.input-block[type="number"],input.input-block[type="password"],input.input-block[type="search"],input.input-block[type="tel"],input.input-block[type="text"],input.input-block[type="time"],input.input-block[type="url"],input.input-block[type="week"]
	{
	width: 100%;
}

.persistWrapper {
	color: #fff;
	margin-top: 10px;
}

.checkbox-label {
	font-size: 16px;
}
/* 微信窗口样式 */
.impowerBox .qrcode {width: 100px;}
.impowerBox .title {display: none;}
.impowerBox .info {width: 100px;}
.status_icon {display：none}
.impowerBox .status {text-align: center;} 
#wxlo{
}
</style>

</head>

<body>
<div>
		 <form action="/loginAdmin.do" method="post" id="password-form" class=" username-required input-focus">   
		<!-- <form action="/loginR.do" method="post" id="password-form" class=" username-required input-focus">   -->
	<!-- <form action="/j_spring_security_checks" method="post" id="password-form" class=" username-required input-focus"> -->
 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="hidden" id="logintype" value="" />

    <h2 id="msg" style="color:red" class="control-label" > ${msg} </h2>
    <script type="text/javascript">
    var msg='${msg}';
    if(msg!=null){
    	$("#msg").css("display","");
    }
    </script>
    <input id="error" type="hidden" value="${error}">  
    <input id="asass" type="hidden" value="${SPRING_SECURITY_LAST_EXCEPTION.message} ">  
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
			<div class="control-group">
				<label id="password-label" class="control-label" for="password">输入验证码</label>
				<div class="controls">
					
				 <img src="/captcha.do" />
				<input  id="captcha"  name="captcha" class="input-block input-large"  tabindex="1" type="text" class="text" placeholder="输入验证码"> 
		
				</div>
			</div>
		<!-- 	<div class="persistWrapper">
				<label id="persistLogin-label" class="checkbox-label css-label  checked" for="persistLogin"> <input type="checkbox" aria-labelledby="persistLogin-label" id="persistLogin"
					name="persistLogin" checked="checked" tabindex="1" /> <span class="input-checkbox"></span> 保持登录状态
				</label>
			</div> -->
			<div class="control-group submit ">
				<button type="submit" id="lgbtn" class="btn btn-primary btn-large btn-block " data-loading-text="" tabindex="1">
					登录 <i class="spinner-battlenet"></i>
				</button>
			</div>
			<br>
			<!-- <div class="control-group submit ">
				<button type="submit" id="wxbtn" onclick="/weixin/wxlogin.do"
					class="btn btn-wx btn-large btn-block " data-loading-text=""
					tabindex="1">
					 <i class="spinner-battlenet"></i>
				</button>
			</div> -->
			<div id="wxlo" class="control-group submit "></div>
		</form> 

	</div>
	

</body>
</html>