<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="viewport" content="width=device-width,initial-scale=1.0">
<style type="text/css">
body,html,#l-map {
	width: 100%;
	height: 100%;
	overflow: hidden; hidden;
	margin: 0;
}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=tHkUgRj9hHQ26hHlBf20X9jg"></script>
<!-- <script type="text/javascript"
	src="http://api.map.baidu.com/api?type=quick&ak=tHkUgRj9hHQ26hHlBf20X9jg&v=1.0"></script> -->
<script type="text/javascript"
	src="http://developer.baidu.com/map/jsdemo/demo/convertor.js"></script>
<script type="text/javascript"
	src="http://libs.useso.com/js/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
	function GetQueryString(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	}
	var ll = GetQueryString("ll");
	//ll="116.404, 39.915";

	//http://api.map.baidu.com/geoconv/v1/?coords=114.21892734521,29.575429778924;114.21892734521,29.575429778924&from=1&to=6&ak=Txi1ql9KsypdAAushOYuEA0k&callback=dealResult
	//                         http://api.map.baidu.com/geoconv/v1/?coords=114.21892734521,29.575429778924&from=1&to=6&ak=gdi9Bzx1zw9EHZSKlSIogCq4&callback=dealResult
	//var u = 'http://api.map.baidu.com/geoconv/v1/?coords=114.21892734521,29.575429778924&from=1&to=6&ak=gdi9Bzx1zw9EHZSKlSIogCq4&callback=dealResult';
	$(document).ready(function() {

		var map = new BMap.Map("l-map");
		//119.01253352549,39.006879467739
		var p = new BMap.Point(ll.split(",")[0], ll.split(",")[1]);
	/* 	map.centerAndZoom(p, 14);

		// 百度地图API功能
		var marker = new BMap.Marker(p); // 创建标注
		map.addOverlay(marker); */

		//坐标转换完之后的回调函数
		translateCallback = function (point){
			var marker = new BMap.Marker(point);
			map.addOverlay(marker);
			/* var label = new BMap.Label("我是百度标注哦",{offset:new BMap.Size(20,-10)});
			marker.setLabel(label); //添加百度label */
			map.centerAndZoom(point,14);
		}
		
		
			BMap.Convertor.translate(p,0,translateCallback);     //真实经纬度转成百度坐标

		/*      	 var params = {
		     			"coordinate" : ll
		     		}; 
		 $.ajax({
		 	url: "BaiduCoordinate.do",//http://localhost:8080/hongqitech/BaiduCoordinate.do?coordinate=119.123,39.123
		 	type : "post",
			data : params,
			cache : false,
			dataType : "json",
		 	success : function(e) {
				var map = new BMap.Map("l-map");  
				//119.01253352549,39.006879467739
				var p=new BMap.Point(e.result[0].x,e.result[0].y);
				map.centerAndZoom(p, 14);  
				
				
				// 百度地图API功能
				var marker = new BMap.Marker(p);  // 创建标注
				map.addOverlay(marker);               // 将标注添加到地图中
				}
		 }); */
	});
	
</script>
<title>显示地图</title>
</head>
<body>
<div>asasajjjjjjjjjjjjjjjjjjjjjjaa "${username}"</div>
	<div id="l-map"></div>
</body>
<script type="text/javascript">
/* var map = new BMap.Map("l-map");  
map.centerAndZoom(new BMap.Point(116.404, 39.915), 14);   */

</script>
</html>
