<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
</head>
<script>
	var dxGrid;
	function doInit() {
		dxGrid = new dhtmlXGridObject('dxGrid');
		dxGrid.setImagePath('${gridPath}');
		dxGrid.setHeader('번호,이름,아이디,이메일,주소,성별,생년월일,추천인');
		dxGrid.setColumnIds('linum,liname,liid,liemail,liaddress,lisex,libirth,lire');
		dxGrid.setColTypes('ro,ed,ed,ed,ed,ed,ed,ro');
		jpGrid.setColSorting('int,str,str,str,str,str,int,str')
		dxGrid.init();
		au.send({url:'/login',success:function(res){
			res = JSON.parse(res);
			dxGrid.parse(res,'js')
		}})
	});
</script>
<body>
	<div id="dxGrid" style="width:400px;height:300px"></div>
</body>
</html>