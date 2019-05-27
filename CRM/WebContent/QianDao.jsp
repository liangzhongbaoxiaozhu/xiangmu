<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.5/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.5/themes/default/easyui.css"/>
<script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function init(){
	$("#dg").datagrid({
		url:'SelectQianDao',  
		method:"post",
		queryParams:{
			loginName:$("#loginName").val(),
			signIn:$("#SignIn").combobox("getValue"),
			cuanjiankaishi:$("#cuanjiankaishi").datebox('getValue'),
			cuanjianjieshu:$("#cuanjianjieshu").datebox('getValue')
		}
	})
	$("#ff").form("clear");
} 

$(function(){
	   init();
})
 function caozuo(value,row,index){
       return "<a href='javascript:void(0)' onclick='qiantui(" + index+ ")'>签退</a>"	   
   }
   function pilian(){
	   var data = $("#dg").datagrid("getData").rows;
	   var uid=null;
	   for(var i=0;i<data.length;i++){
		   if(data[i].signIn==1){
			   if(uid==null){
				   uid=data[i].uid;
			   }else{
				   uid=uid+","+data[i].uid;  
			   } 
		   }
		   
	   }
	  /*  alert(uid); */
	   $.post("UpdateQianTui",{
		   uid:uid
	   },function(res){
		   $("#dg").datagrid("reload");  
		   if(res.search("签退成功")!=-1){
			  
			   alert(res);  
		   }else{
			   alert(res);  
		   }
		   
	   })
   }
   function qiantui(index){
	   var data = $("#dg").datagrid("getData");
		var row = data.rows[index];
	   $.post("UpdateQianTui",{
		   uid:row.uid
	   },function(res){
		   $("#dg").datagrid("reload"); 
		   if(res.search("签退成功")!=-1){
			   
			   alert(res);  
		   }else{
			   alert(res);  
		   }
		   
	   })
   }
   function zhuangtai(value,row,index){
	   return value==0?"签退":(value==1?"签到":(value==2?"迟到":(value==3?"早退":"旷班")))
   }
</script>
</head>
<body>
<div id="tool">
<form id="ff">   
        <label for="name">名称:</label>   
        <input class="easyui-textbox" style="width: 150px;" type="text" id="loginName"   />   
        <label for="name">签退:</label>   
        <select id="SignIn" class="easyui-combobox" name="dept" style="width:150px;">   
         <option value="">--请选择--</option>   
         <option value="0">签退</option>   
         <option value="1">签到</option>   
        </select> 
        <label for="name">签到开始时间:</label>   
        <input  id="cuanjiankaishi"  type= "text" class= "easyui-datebox" > </input>   
        <label for="name">签到结束时间:</label>   
		<input  id="cuanjianjieshu"  type= "text" class= "easyui-datebox" > </input>   
		<a  href="javascript:void(0)" class="easyui-linkbutton" onclick="init()" data-options="iconCls:'icon-search'">搜索</a>
		<a  href="javascript:void(0)" class="easyui-linkbutton" onclick="pilian()" data-options="iconCls:'icon-add'">批量签退</a>  
</form>  

</div>
	<div>
		<table id="dg" class="easyui-datagrid"
			style="width: 100%; height: 400px"
			data-options="toolbar:'#tool',fitColumns:true,singleSelect:true,pagination:true,pageSize:10,rownumbers:true">
			<thead>
				<tr>
					<th data-options="field:'loginName',width:100">名称</th>
					<th data-options="field:'signIn',width:100,formatter:zhuangtai">签到状态</th>
					<th data-options="field:'signInData',width:100">签到时间</th>
					<th data-options="field:'a',width:100,formatter:caozuo">操作</th>
				</tr>
			</thead>

		</table>
	</div>
</body>
</html>