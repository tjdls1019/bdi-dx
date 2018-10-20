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
		
		dxGrid.attachEvent("onEditCell", function(stage,rId,cInd,nValue,oValue){
			var keyArr= ['linum','liname','liid','liemail','liaddress','lisex','libirth','lire'];
		   if(stage==2){	
			   var data ={};
			   var key = keyArr[cInd];//'lilsex'
			 
			   
			   data[key] = nValue;
			
			   	console.log(dxGrid.cellById(rId, cInd));
			  // console.log(data);// {lisex:"남",linum:"1(숫자)"}
			   var conf = {
						url:'/login',
						method:'PUT',
						param:JSON.stringify(data),
						success : function(res){ // {"uiid":"df"}
							res = JSON.parse(res);
							console.log(res.success);
						}
				};
				au.send(conf); //a(); a;
		   }
		   return true;
		});
	});
		
</script>
<body>
	<div id="dxGrid" style="width:100%;height:100%"></div>
	<div><button onclick="goDelete()">회원정보수정</button> <button onclick="goUpdate()">회원정보삭제</button> </div>
	<script>
	function goUpdate(){
		
		
	}
	
	function goDelete(){
		alert("gd");
		
	}
	</script>
</body>
</html>