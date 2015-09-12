<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>管理</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/jscss/bootstrap-3.3.5-dist/css/bootstrap.min.css">

    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="/jscss/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">

     <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
   <!--  <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script> -->
     <script src="/jscss/jquery-2.1.4.min.js"></script> 
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/jscss/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <!-- Custom CSS -->
    <link href="/jscss/bootstrap-3.3.5-dist/dist/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Theme JavaScript -->
    <link rel="stylesheet" href="/jscss/jquery-ui-1.10.4.custom/css/ui-lightness/jquery-ui-1.10.4.custom.min.css">
    <script src="/jscss/jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <base target="myiframe" />
<script type="text/javascript">
	$(document).ready(
			function() {
				var info = eval("(" + '${info}' + ")");
				$("#navbar-brand").append(info.shopTitle);
				console.info(info.id);
				console.info(info.shopid);
				/* shopid = info.id; */
				/* $("#shopinfo").attr("href",
						"/shop/shopInfo.html?userid=" + info.id); */
			/* 	$("#productAdmin").attr("href",
						"/shop/productAdmin.html?shopid=" + info.shopid);
				//$("#customerAdmin").attr("href","/shop/customerAdmin.html?shopid="+info.shopid);
				$("#couponAdmin").attr("href",
						"/shop/couponAdmin.html?shopid=" + info.shopid);
				$("#orderAdmin").attr("href",
						"/shop/orderAdmin.html?shopid=" + info.shopid); */
						
						
				$(function() {
				    $( "#dialog" ).dialog({
				      autoOpen: false,
				      show: {
				        effect: "blind",
				        duration: 1000
				      },
				      hide: {
				        effect: "explode",
				        duration: 1000
				      }
				    });
				 
				    $( "#xiugaimima" ).click(function() {
				      $( "#dialog" ).dialog( "open" );
				    });
				  });
						
						
			});
	/* var shopid; */
</script>
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top " id="top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand" href="index.html">管理系统</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
            <li class="">
                    <btn class="btn btn-link" href="" id="xiugaimima">
                        <i class="glyphicon glyphicon-edit"> 修改密码</i>
                    </btn>
                    <!-- /.dropdown-messages -->
                </li>
                <li class="dropdown">
                    <a href="/admin.do?logout=1" target="_parent">
                        <i class="glyphicon glyphicon-log-out">退出登录</i>
                    </a>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" id="right" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                      <li>
                            <a href="/admin/info.html"><i class="fa fa-dashboard fa-fw"></i> 企业信息管理</a>
                        </li>
                        <li>
                            <a href="/admin/shopAdmin.html"><i class="fa fa-dashboard fa-fw"></i> 商户管理</a>
                        </li>
                        <li>
                            <a href="/admin/productAdmin.html"><i class="fa fa-table fa-fw"></i> 产品管理</a>
                        </li>
                        <li>
                            <a href="/admin/customerAdmin.html"><i class="fa fa-edit fa-fw"></i> 客户管理</a>
                        </li>
                       
                        <li>
                            <a href="/admin/orderAdmin.html"><i class="fa fa-edit fa-fw"></i> 订单管理</a>
                        </li>
                         <li>
                            <a href="/admin/couponAdmin.html"><i class="fa fa-edit fa-fw"></i> 优惠券管理</a>
                        </li>
                       
                   
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper" >
            <iframe src="" id="myiframe" name="myiframe" style="border: none;" height="100%" width="100%"></iframe>
        </div>
        <script type="text/javascript">
        $("#page-wrapper").height($("body").height()-55);
        $("#myiframe").width($("#page-wrapper").width());
        $("#myiframe").height($("#page-wrapper").height());
        </script>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->




<div id="dialog" class="panel panel-default" title="      修改密码">
   <div class="panel-body">
      <form role="form" >
   <div class="form-group">
      <label for="name">新密码</label>
      <input type="password" class="form-control" id="pas1" 
         placeholder="请输入新密码">
   </div>
   <div class="form-group">
      <label for="name">确认新密码</label>
      <input type="password" class="form-control" id="pas2" 
         placeholder="请重新输入新密码">
   </div>
   <button type="button" id="xiugaimimabtn" class="btn btn-default">提交</button>
</form>
<script type="text/javascript">
$("#xiugaimimabtn").click(function () {
	if($("#pas1").val()==$("#pas2").val()){
		var params = {  
	    		"password":$("#pas2").val(),
	    };  
	    var actionUrl = "/background/changePassword.do";  
	    $.ajax({  
	    	 type:"get",
	        url : actionUrl,  
	        data : params,  
	        dataType : "text",  
	        cache : false,  
	        error : function(textStatus, errorThrown) {  
	            alert("系统ajax交互错误: " + textStatus);  
	        },  
	        success : function(data, textStatus) {  
	            if (data == "success") {  
	            	 alert("修改成功!");  
	            	$( "#dialog" ).dialog( "close" );
	            } else {  
	                alert("操作失败!");  
	            }  
	        }  
	    });  
	}else{
		alert("密码输入不一致，请重新输入！");
	}
});
</script>
   </div>
</div>

</body>

</html>
