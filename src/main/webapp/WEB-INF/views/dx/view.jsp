<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
</head>
<script>
function UpdateAndDelete(){
	var	liFormData = [{type:'fieldset',name:'sign',label:'',inputwidth:'auto',
			list:[
				{type:'input',name:'id',label:'ID',value:'${li.liid}',validate:'ValidAplhaNumeric',required:true},
				{type:'input',name:'name',label:'NAME',value:'${li.liname}',required:true},
				{type:'password',name:'pwd1',label:'PASSWORD',value:'${li.lipwd1}' ,validate:'ValidAplhaNumeric',required:true},
				{type:'password',name:'pwd2',label:'PASSWORDD',value:'${li.lipwd2}' ,validate:'ValidAplhaNumeric',required:true},
				{type:'input',name:'email',label:'e-Mail',value:'${li.liemail}',validate:'ValidAplhaNumeric',required:true},
				{type:'input',name:'address',label:'Address',value:'${li.liaddress}',validate:'ValidAplhaNumeric',required:true},
				{type:'input',name:'sex',label:'sex',value:'${li.lisex}',validate:'ValidAplhaNumeric',required:true},
				{type:'input',name:'birth',label:'BIRTH',value:'${li.libirth}',validate:'ValidAplhaNumeric',required:true},
				{type:'input',name:'re',label:'R.E',value:'${li.lire}',validate:'ValidAplhaNumeric',required:true},
				{type:'button',name:'update',value:'수정하기'},
				{type:'button',name:'delete',value:'삭제하기'},
			]
		}];
	var	liForm;
	scForm = new dhtmlXForm('divFormData',liFormData);
	scForm.attachEvent('onButtonClick',function(name){
		var id = scForm.getItemValue('id');
		if(name=='update'){
			if(scForm.validate()){
				var id = liForm.getItemValue('id');
				var name = liForm.getItemValue('name');
				var pwd1 = liForm.getItemValue('pwd1');
				var pwd2 = liForm.getItemValue('pwd2');
				var email = liForm.getItemValue('email');
				var address = liForm.getItemValue('address');
				var sex = liForm.getItemValue('sex');
				var birth = liForm.getItemValue('birth');
				var rec = liForm.getItemValue('rec');
				var	conf = {
					url:'/dx/'+id,
					method:'PUT',
					param:JSON.stringify({
						liid:id,liname:name,lipwd1:pwd1,lipwd2:pwd2,
						liemail:email,liaddress:address,lisex:sex,
						libirth:birth,lire:rec
					}),
					success:function(res){
						if(res=="1"){
							alert('수정에 성공하였습니다.');
							location.href='/uri/dx/list';
						}else{
							alert('수정에 실패하였습니다.');
						}
					}
				};
				au.send(conf);
			}
		}else if(name=='delete'){
			au.send({url:'/dx/'+id,method:'DELETE',success:function(res){
				if(res=="1"){
					alert('삭제에 성공하였습니다.');
					location.href='/uri/dx/list';
				}else{
					alert('삭제에 실패하였습니다.');
				}
			}});
	});
	
}
window.addEventListener('load',UpdateAndDelete);
</script>
<body>
	<div id="divFormData"></div>
</body>
</html>