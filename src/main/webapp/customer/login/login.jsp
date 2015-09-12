<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.security.web.WebAttributes"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>美哪登录</title>
    <meta name="viewport" content="minimal-ui,width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta name="format-detection" content="telephone=no">
    <meta name="msapplication-tap-highlight" content="no">
    <link type="text/css" rel="stylesheet" href="/customer/login/jscss/login-m-2.0.css" />
<link rel="stylesheet" type="text/css" href="/jscss/bootstrap-3.3.5-dist/css/iconFont.css" charset="gbk"/>    
<body>
<div id="container">
    <div class="touchweb-com_header ">
        <a id="back" href="javascript: void(0);" class="left icon-back"></a>
        <h1>登录美哪</h1>
        <div class="rightBox">

            <a id="register_btn" href="/customer/login/register.html" class="right rbtn">注册
            </a>
        </div>
    </div>
<%-- <form action="/loginR.do" method="post" id="password-form"> 
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="hidden" id="logintype" value="" />
${SPRING_SECURITY_LAST_EXCEPTION.message} 
			<input type="text"  id="uname" value="" name="username" title="输入您的用户名" placeholder="输入您的用户名" />
			<input type="password"  id="pword" value="" name="password" title="输入您的密码"  autocomplete="off"placeholder="输入您的密码" />
		
				<button type="submit" id="lgbtn" >
					登录 <i class="spinner-battlenet"></i>
				</button>
		</form>  --%>

    <div class="touchweb_page-login">
        <!--
        <div id="error_tips" class="error_tips" style="display: block;">
                <span class="icon-warning icon_warning"></span>
                提示信息
        </div>
        -->
		<form action="/loginR.do" method="post" id="password-form"> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <div class="login_box">
            <div class="form_item">
                <label class="icon-user" for="uname"></label>
                <div class="input_box">
                    <input type="text" id="uname" name="username" placeholder="邮箱/手机/用户名">
                    <span class="icon_delete icon-delete"></span>
                </div>
            </div>
            <div class="form_item">
                <label class="icon-key" for="pword"></label>
                <div class="input_box">
                    <input type="password" id="pword" name="password" placeholder="请输入密码">
                    <span class="icon_delete icon-delete"></span>
                </div>
            </div>
        </div>

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
 <!--        <div class="remember_login">
            <input id="touchweb_form-checkbox" type="checkbox" checked>
            <label for="touchweb_form-checkbox">两周内记住登录</label>
            <a href="javascript: void(0);" class="forgot_password">忘记密码？</a>
        </div> -->
<!-- 
        <div class="agreement">
            <label>点击登录，表示您同意1号店<a href="javascript: void(0);" class="license-terms">《服务协议》</a></label>
        </div> -->

        <div class="login_btn">
            <!-- <a id="login-btn" href="javascript: void(0);" class="btn">登录</a> -->
                <button type="submit" id="login-btn" class="btn">
					登录 
				</button>
        </div>
    
</form>
        <div class="joint_login">
            <h2><span>合作账号登录</span></h2>
            <ul>
                <li style="width: 33.33%;">
                    <a href="javascript: void(0);" class="icon-alipay"></a>
                </li>
                <li style="width: 33.33%;">
                    <a href="javascript: void(0);" class="icon-weibo"></a>
                </li>
                <li style="width: 33.33%;">
                    <a href="javascript: void(0);" class="icon-qq"></a>
                </li>
            </ul>
        </div>
    </div>

    <div class="pop_login-error">错误信息<br>文字文字</div>

</div>

<div id="pop" class="touchweb_com-modPopup" style="display: none;">
    <div class="popup_box">
        <div class="popup_title" style = "font-size: 10px;">客官，您的密码可能有安全风险哦~</div>
        <div class="popup_con" style = "font-size: 10px;">建议您马上修改</div>
        <div class="popup_btn">
            <a id="to_update_password" href='javascript: void();' class='continue' style = "font-size: 10px;" onclick="">速速修改</a>
            <a id="to_ignore_to_update_password" href='javascript: void();' class='ignore' style = "font-size: 10px;" onclick="">残忍忽略</a>
        </div>
    </div>
    <div class="popup_bg" style="bottom: 0px; right: 0px;"></div>
</div>

</body>
</html>