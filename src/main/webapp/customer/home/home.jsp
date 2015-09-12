<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>

    <title>
       个人中心
    </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" type="text/css" href="/customer/home/jscss/myhome1.01.css" charset="gbk"/>
    <link rel="stylesheet" type="text/css" href="/customer/home/jscss/list.css" charset="gbk"/>
    <link rel="stylesheet" type="text/css" href="/jscss/bootstrap-3.3.5-dist/css/iconFont.css" charset="gbk"/>
  <script type="text/javascript" src="/jscss/jquery-2.1.4.min.js"></script>
     <script src="/jscss/jquery.cookie.js"></script>
<sec:authentication property="principal" var="authentication"/>
<script type="text/javascript">
document.cookie = "username=${authentication.username }";
var info=eval("(" + '${info}' + ")");
document.cookie = "userid="+info.id;
var customer=eval("(" + '${info.customer}' + ")");
$.cookie('customer', customer); // 存储 cookie 
$.cookie('userid', customer.usersid); // 存储 cookie 
if(customer.phone==null||customer.phone==""){
	alert("请尽快完善信息！");
};
$(document).ready(function () {
	var url="/uploadimg/"+customer.img.substring(1,customer.img.length-1);
	$("#myimg").attr("src",url);
});
</script>
<style type="text/css">
</style>
</head>

<body id="body">
<a name="top"></a>


<style type="text/css">
    .current-half-width li{width:33% !important;}
    .menu-list li {
        width: 33%;
    }
</style>
<script type="text/javascript">
</script>
<div class="common-wrapper">

    <div class="head-img">
        <span class="my-img" ><img alt="" src="" id="myimg" /></span>
        <p>${authentication.username }</p>
    </div>

  <!--  <ul class="padding-list current-half-width">
        <li>
            <a id="waite4Payment" href="/user/waite4Payment.action?sid=35ffce6367c4426c163591885be17779">
                <p id="waite4PaymentSum">&nbsp;</p>
                <p>我的订单</p>
            </a>
        </li>
        <li>
            <a id="waitDeliveryOrderList" href="/user/waitDeliveryOrderList.action?sid=35ffce6367c4426c163591885be17779">
                <p id="waitDeliveryOrderListSum">&nbsp;</p>
                <p>预约订单</p>
            </a>
        </li>
        <li>
            <a id="waitDeliveryOrderList" href="/user/waitDeliveryOrderList.action?sid=35ffce6367c4426c163591885be17779">
                <p id="waitDeliveryOrderListSum">&nbsp;</p>
                <p>我的钱包</p>
            </a>
        </li>
    </ul>-->

    <ul class="menu-list">
        <li>
            <a id="quanbudingdan" href="/customer/home/orderlist.html">
                <img src="/customer/home/img/dingdan.png" alt=""/>
                <p>全部订单</p>
            </a>
        </li>

        <!--
                <li>
                    <a id="wodeguanzhu" href="/myJd/myFocus/focusWare.action?functionId=wodeguanzhu&sid=35ffce6367c4426c163591885be17779">
                        <img src="http://img30.360buyimg.com/mobilecms/jfs/t535/111/664109451/3395/3c18f3cb/547bc6eaN6c97383c.png" alt=""/>
                        <p>我的收藏</p>
                    </a>
                </li>

                <li>
                    <a id="liulanjilu" href="/myJd/history/wareHistory.action?functionId=liulanjilu&sid=35ffce6367c4426c163591885be17779">
                        <img src="http://img30.360buyimg.com/mobilecms/jfs/t571/182/648860482/3266/f4f4ed01/547bc70aNf7e3462a.png" alt=""/>
                        <p>浏览记录</p>
                    </a>
                </li>

                <li>
                    <a id="fuwuguanjia" href="/user/services.action?functionId=fuwuguanjia&sid=35ffce6367c4426c163591885be17779">
                        <img src="http://img30.360buyimg.com/mobilecms/jfs/t547/103/678884525/2510/c82066d7/547bc727Nde7da59c.png" alt=""/>
                        <p>服务管家</p>
                    </a>
                </li>

                <li>
                    <a id="zhanghuguanli" href="/user/accountCenter.action?functionId=zhanghuguanli&sid=35ffce6367c4426c163591885be17779">
                        <img src="http://img30.360buyimg.com/mobilecms/jfs/t448/16/669601077/3241/d50da28d/547bc742N95a14876.png" alt=""/>
                        <p>账户管理</p>
                    </a>
                </li>
        -->
        <li>
            <a id="wodeyuyue" href="/customer/home/orderlist.html?t=1">
                <img src="/customer/home/img/yuyue.png" alt=""/>
                <p>我的预约</p>
            </a>
        </li>

        <li>
            <a id="wodeqianbao" href="">
                <img src="/customer/home/img/qianbao.png" alt=""/>
                <p>我的钱包</p>
            </a>
        </li>
 <!--       <li>
            <a id="yingyongtuijian" href="//m.jd.com/download/downApp.html?functionId=yingyongtuijian&sid=35ffce6367c4426c163591885be17779">
                <img src="http://img30.360buyimg.com/mobilecms/jfs/t619/235/660356215/2788/5b40e4c9/547bc772Nbdf299f1.png" alt=""/>
                <p>应用推荐</p>
            </a>
        </li>-->

    </ul>
    <ul class="couponIn-list">
        <li>
        <a id="wodedingdan" href="">
            <div class="couponIn-item">
                <div class="couponIn-icon"><i class="icon-amazon"></i></div>
                <div class="couponIn-item-info">
                    <span class="info-title">我的订单</span>
                    <span class="info-hint"></span>
                </div>
            </div>
        </a>
    </li>
        <li>
            <a id="wodeyouhuiquan" href="/customer/home/couponslist.html">
                <div class="couponIn-item">
                    <div class="couponIn-icon"><i class="icon-gift"></i></div>
                    <div class="couponIn-item-info">
                        <span class="info-title">我的优惠券</span>
                        <span class="info-hint"></span>
                    </div>
                </div>
            </a>
        </li>
        <li>
            <a id="wodexinxi" href="">
                <div class="couponIn-item">
                    <div class="couponIn-icon"><i class="icon-mail"></i></div>
                    <div class="couponIn-item-info">
                        <span class="info-title">我的消息</span>
                        <span class="info-hint"></span>
                    </div>
                </div>
            </a>
        </li>
			<li><a id="wodedianhua" href="tel:18688888888">
					<div class="couponIn-item">
						<div class="couponIn-icon">
							<i class="icon-phone"></i>
						</div>
						<div class="couponIn-item-info">
							<span class="info-title">一键电话服务</span> <span class="info-hint"></span>
						</div>
					</div>
			</a></li>
		</ul>
</div>

</body>
</html>

