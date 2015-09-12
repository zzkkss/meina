<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.security.web.WebAttributes"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>商户登陆</title>
<script type="text/javascript">
if(top.location != location){ 
    top.location.href= location.href; 
}  
</script>
<sec:csrfMetaTags />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/shop/css/styles.css" rel='stylesheet' type='text/css' />
</head>

<body>
<div class="htmleaf-container">
	<div class="wrapper">
		<div class="container">
			<h1>欢迎使用美哪商铺管理系统</h1>
			
			<form class="form" action="/loginShop.do" method="post">
			  <div id="msg" style="display: none" ><h2 style="color: red">${msg} </h2> </div>
    <script type="text/javascript">
    var msg='${msg}';
    if(msg!=null){
    	//$("#msg").css("display","");
    	 document.getElementById('msg').style.display="";  
    }
    </script>
							<input  id="uname"  name="username"  type="text" class="text" value="用户名" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '用户名';}">
				 <input id="pword"  name="password"  type="text" class="text" value="密码" onfocus="this.value = '';this.type='password'" onblur="if (this.value == '') {this.type='text';this.value = '密码';}"> 
				
				 <img src="/captcha.do" />
				<input  id="captcha"  name="captcha"  type="text" class="text" value="验证码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '验证码';}"> 
				
				<button type="submit" id="login-button">登录</button>
				<br/><br/><a href="/shopRegister.do" class="register">还没有账号？点击注册</a>
			</form>
		</div>
		
		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ul>
	</div>
</div>


</body>
</html>