<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商户注册</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="/jscss/bootstrap-3.3.5-dist/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="/jscss/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/jscss/jquery-ui-1.10.4.custom/css/ui-lightness/jquery-ui-1.10.4.custom.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="/jscss/jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/jscss/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<style type="text/css">
.ui-dialog {
	z-index: 9999;
}
</style>
</head>
<body>
	<div id="page-wrapper" class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">商户注册</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">请填写商户信息。</div>
					<div class="panel-body">
						<div class="row">
							<form role="form"  action="/registerShop.do" method="post" > 
										  <div id="msg" style="display: none" ><h2 style="color: red">${msg} </h2> </div>
    <script type="text/javascript">
    var msg='${msg}';
    if(msg!=null){
    	//$("#msg").css("display","");
    	 document.getElementById('msg').style.display="";  
    }
    </script>
								<div class="col-xs-12">
									<div class="form-group">
										<label>登陆账号</label> <input type="text" class="form-control" id="username" name="username" placeholder="请输入登陆账号">
										<p class="help-block">登陆账号</p>
									</div>
									<div class="form-group">
										<label>登陆密码</label> <input type="text" class="form-control" id="password"   name="password" placeholder="请输入登陆密码">
										<p class="help-block">登陆密码</p>
									</div>
									<div class="form-group">
										<label>商户名称</label> <input type="text" class="form-control" id="title"  name="title"  placeholder="请输入商户名称">
										<p class="help-block">商户名称</p>
									</div>
									<div class="form-group">
										<label>联系电话</label> <input type="text" class="form-control"   id="phone"   name="phone"  placeholder="请输入联系电话">
										<p class="help-block">联系电话</p>
									</div>
									<div class="form-group">
										<label>验证码</label> <img src="/captcha.do" /> <input id="captcha" name="captcha" type="text" class="text" value="验证码" onfocus="this.value = '';"
											onblur="if (this.value == '') {this.value = '验证码';}">

										<p class="help-block">验证码</p>

									</div>
									<div class="form-group">
										<input class="btn btn-lg" type="submit"  value="注册账户">

								</div> 
								<!-- /.col-lg-6 (nested) -->
							</form>
						</div>
						<!-- /.row (nested) -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /#page-wrapper -->





</body>

</html>