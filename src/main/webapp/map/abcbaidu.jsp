<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
body,html,#l-map {
	width: 100%;
	height: 100%;
	overflow: hidden; hidden;
	margin: 0;
}
#ptitle{
position: absolute;
z-index: 999;
background-color: #ffffff;

}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=tHkUgRj9hHQ26hHlBf20X9jg"></script>
<!-- <script type="text/javascript"
	src="http://api.map.baidu.com/api?type=quick&ak=tHkUgRj9hHQ26hHlBf20X9jg&v=1.0"></script> -->
<script type="text/javascript" src="http://developer.baidu.com/map/jsdemo/demo/convertor.js"></script>
<script type="text/javascript" src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
	var map;
	var markers = new Array();
	$(document).ready(function() {

		// 百度地图API功能
		map = new BMap.Map("l-map"); // 创建Map实例
		map.centerAndZoom(new BMap.Point(116.404, 39.915), 11); // 初始化地图,设置中心点坐标和地图级别
		map.addControl(new BMap.MapTypeControl()); //添加地图类型控件
		map.setCurrentCity("北京"); // 设置地图显示的城市 此项是必须设置的
		map.enableScrollWheelZoom(true); //开启鼠标滚轮缩放

		connect();

		console.info(eval("(" + '${t}' + ")"));
		var tt = new Array();
		tt = eval("(" + '${t}' + ")").t;

		for (var m = 0; m < tt.length; m++) {
			var pp = new Object();
			pp.nickname = tt[m].nn;
			pp.tname = tt[m].tn;
			var p = new BMap.Point(0, 0);
			pp.mark = new BMap.Marker(p);
			var label = new BMap.Label(tt[m].nn,{offset:new BMap.Size(20,-10)});
			pp.mark.setLabel(label);
			markers[m] = pp;
			map.addOverlay(pp.mark);
		}
		 var a=eval('('+$("#hid").html()+')');
		console.info("abcd"+a.nn); 
		$("#ptitle").html($("#ptitle").html()+a.nn);
	});
</script>
<title>显示地图</title>
</head>
<body>
	<div id="hid" style="display: none" ><sec:authentication property="name"/></div>
	<div id="ptitle">
		欢迎使用红旗胜利系统平台：
	</div>
	<div id="l-map"></div>
</body>
<script type="text/javascript">
	var ws = null;
	var url = null;
	url = 'ws://' + window.location.host + '/websocket.do';
	//  url = 'wss://' + window.location.host + urlPath;  
	var transports = [];

	function connect() {
		//alert("url:"+url);  
		if (!url) {
			alert('Select whether to use W3C WebSocket or SockJS');
			return;
		}

		ws = new WebSocket(url);

		ws.onopen = function() {
			console.info('Info: connection opened.');
		};
		ws.onmessage = function(event) {

			console.info('Received: ' + event.data);
			var d = eval("(" + event.data + ")");
			var p = new BMap.Point(d.lng, d.lat);
			//var myIcon = new BMap.Icon("http://developer.baidu.com/map/jsdemo/img/fox.gif", new BMap.Size(300,157));

			//坐标转换完之后的回调函数
			translateCallback = function(point) {
				for (var n = 0; n < markers.length; n++) {
					if (markers[n].tname == d.tname) {
						//var marker = new BMap.Marker(point,{icon:myIcon});
						markers[n].mark.setPosition(point);
						markers[n].mark.setTitle(d.nickname);
						map.addOverlay(markers[n]);
						/* var label = new BMap.Label("我是百度标注哦",{offset:new BMap.Size(20,-10)});
						marker.setLabel(label); //添加百度label */
					}

				}

			}
				BMap.Convertor.translate(p, 0, translateCallback); //真实经纬度转成百度坐标
		};
		ws.onclose = function(event) {
			console.info('Info: connection closed.');
			console.info(event);
		};
	}

	function disconnect() {
		if (ws != null) {
			ws.close();
			ws = null;
		}
	}

	function echo() {
		if (ws != null) {
			var message = document.getElementById('message').value;
			log('Sent: ' + message);
			ws.send(message);
		} else {
			alert('connection not established, please connect.');
		}
		;
	}

	function updateTransport(transport) {
		alert(transport);
		transports = (transport == 'all') ? [] : [ transport ];
	};
</script>
</html>
