<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
</head>
<script>
	var dxGrid,conf;
	var conf;
	window.addEventListener('load', function() {
		dxGrid = new dhtmlXGridObject('dxGrid');
		dxGrid.setImagePath('${gridPath}');
		dxGrid.setHeader('번호,이름,아이디,이메일,주소,성별,생년월일,추천인');
		dxGrid.setColumnIds('linum,liname,liid,liemail,liaddress,lisex,libirth,lire');
		dxGrid.setColTypes('ro,ed,ed,ed,ed,ed,ed,ro');
		dxGrid.setColSorting('int,str,str,str,str,str,int,str')
		dxGrid.init();
		au.send({url:'/login',success:function(res){
			res = JSON.parse(res);
			dxGrid.parse(res,'js')
		}})
	});
	setTimeout(function(e){
		
		dxGrid.attachEvent('onEditCell',function(stage,rId,cInd,nValue,oValue){
			var linum =dxGrid.cells(rId,0).getValue();
			var keys =  ['linum','liname','liid','liemail','liaddress','lisex','libirth','lire'];
			var data={};
			data[keys[cInd]]=nValue
			data[keys[0]]=linum
			if(stage==2){		
				conf={url:'/login',
				method:'PUT',
				param :JSON.stringify(data),
				success:function(res){
					res=JSON.parse(res);
					alert(res.msg);
				location.href="/uri/dx/list";} //이쪽은 주소확인할 것 //이쪽은 확인할 것//이쪽은 확인할 것//이쪽은 확인할 것
				};
				au.send(conf)
				return true; //트루면 바뀐 것이 들어가고  false면 안바뀌고 고대로 있음.
			};
							
		});
		dxGrid.attachEvent("onRowSelect",function(rId,cInd){
			var linum =dxGrid.cells(rId,0).getValue();
			//alert('row번호는'+rId+'uinum은'+uinum+'입니다.');
			conf={url:'/login/'+linum,
				method:'DELETE',
				success:function(res){
				res=JSON.parse(res);
				alert(res.msg);
				location.href="/uri/dx/list";} //이쪽은 주소확인할 것 //이쪽은 확인할 것//이쪽은 확인할 것//이쪽은 확인할 것
				};
			var dbtn =document.getElementById('deleteData');
			dbtn.setAttribute('onclick','deleteData()');
		
		});
		
		
		},1000)//close 23번째 줄 닫음.
		function deleteData(){
			if(confirm('선택하신 row를 삭제하시겠습니까?')){
		    	au.send(conf);	
		   	 };
		};
	
		
		
</script>
<body>

	<div id="dxGrid" style="width:100%;height:100%"></div>
	<div><button id="deleteData">회원정보삭제</button> </div>
	
</body>
</html>