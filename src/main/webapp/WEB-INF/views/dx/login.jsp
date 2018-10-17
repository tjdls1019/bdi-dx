<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
</head>
<script>
	var dxForm,dxWin;
	var loginFormData = [
		{type:'fieldset', name:'login', label:'login', inputWidth:'auto',
			list:[
				{type:'input',name:'id',label:'ID',validate:'ValidAplhaNumeric',required:true},
				{type:'password',name:'pwd',label:'PWD',validate:'ValidAplhaNumeric',required:true},
				{type:'button',name:'loginbtn',value:'LOGIN'}
			]	
		}
	];
	var joinFormData = [
		{type:'fieldset', name:'join', label:'join', inputWidth:'auto',
			list:[
				{type:'input',name:'name',label:'NAME',required:true},
				{type:'input',name:'id',label:'ID',validate:'ValidAplhaNumeric',required:true},
				{type:'password',name:'pwd',label:'PWD',validate:'ValidAplhaNumeric',required:true},
				{type:'password',name:'pwdcheck',label:'PWD CHECK',validate:'ValidAplhaNumeric',required:true},
				{type:'input',name:'email',label:'EMAIL',required:true},
				{type:'input',name:'address',label:'ADDRESS',required:true},
				{type:'input',name:'sex',label:'SEX',
					list:[
						{type:'radio',name:'gender',label:'여'},
						{type:'radio',name:'gender',label:'남'},
					],required:true},
				{type:'input',name:'birth',label:'BIRTH',required:true},
				{type:'input',name:'recommender',label:'RECOMMENDER'},
				{type:'button',name:'joinbtn',value:'JOIN'}
			]	
		}
	];
	function doInit() {
		var forms = [
			{type:'button',value:'회원가입', name:'join'},
			{type:'button',value:'로그인', name:'login'}
		]
		
		var dxForm = new dhtmlXForm('dxForm',forms)
		dxForm.attachEvent('onButtonClick',function(name) {
			if(name=='join'){
				if(!dxWin){
					dxWin = new dhtmlXWindows();
					dxWin.createWindow('w1',0,0,250,450);
					dxWin.window('w1').centerOnScreen();
					var joinForm = new dhtmlXForm('joinForm', joinFormData);
					dxWin.window('w1').attachObject('joinForm');
					joinForm.attachEvent('onButtonClick',function(name){
						if(name=='joinbtn'){
							if(joinForm.validate()){
							var id = joinForm.getItemValue('id');
							var pwd = joinForm.getItemValue('pwd');
							var conf = {
									url:'/login',
									method:'POST',
									param:JSON.stringify({id:id,pwd:pwd}),
									success : function(res){
										res = JSON.parse(res);
										alert(res.msg);
									}
							}
							au.send(conf);
							}
						}
					})
				}
			}else if(name=='login'){
				if(!dxWin){
					dxWin = new dhtmlXWindows();
					dxWin.createWindow('w1',0,0,250,200);
					dxWin.window('w1').centerOnScreen();
					var loginForm = new dhtmlXForm('loginForm', loginFormData);
					dxWin.window('w1').attachObject('loginForm');
					loginForm.attachEvent('onButtonClick',function(name){
						if(name=='loginbtn'){
							if(loginForm.validate()){
							var id = loginForm.getItemValue('id');
							var pwd = loginForm.getItemValue('pwd');
							var conf = {
									url:'/login',
									method:'POST',
									param:JSON.stringify({id:id,pwd:pwd}),
									success : function(res){
										res = JSON.parse(res);
										alert(res.msg);
									}
							}
							au.send(conf);
							}
						}
					})
				}
			}
		})
	}
	window.addEventListener('load',doInit);
</script>
<body>
<div id="dxForm" style="height:100px"></div>
<div id="loginForm" style="width:240px; height:200px"></div>
<div id="joinForm" style="width:240px; height:200px"></div>
</body>
</html>