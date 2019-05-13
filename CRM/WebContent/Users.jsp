<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.5/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.5/themes/default/easyui.css"/>
<script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
</head>
<script type="text/javascript">
function init(){
	$("#dg").datagrid({
		url:'SelectUsers',  
		method:"post",
		queryParams:{
			
		}
	})
} 
$(function(){
	   init();
})
 function caozuo(value,row,index){
       return "<a href='javascript:void(0)' onclick='suoding(" + index+ ")'>锁定</a>  <a href='javascript:void(0)' onclick='jiesuo(" + index+ ")'>解锁</a> <a  href='javascript:void(0)' onclick='shanchu("+ index + ")'>删除</a>"	   
   }
//删除
function shanchu(index) {
	var data = $("#dg").datagrid("getData");
	var row = data.rows[index];
	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
	    if (r){    
	    	$.post("DeleteUsers", {
				id : row.uid,
			}, function(res) {
				if(res>0){
					$.messager.alert('提示','删除成功!'); 
				}else{
					$.messager.alert('提示','删除失败!'); 
				}
			})
			$("#dg").datagrid("reload");  
	    }
	});  

	
}
//打开新增弹窗
function xinzeng(){
	$('#addwin').window("open");  
	
}
//新增保存
function addbaocuen(){
	$.post("InsertUsers",{
		loginName:$("#loginName2").val(),
		passWord:$("#passWord2").val(),
		createData:$("#createData2").val(),
		email:$("#email2").val(),
		mtel:$("#mtel2").val()
	},function(res){
		$("#dg").datagrid("reload");
		$("#rname2").val("");
		
		if(res>0){
			$('#addwin').window('close');
			$("#loginName2").val("");
			$("#passWord2").val("");
			$("#createData2").val("");
			$("#email2").val("");
			$("#mtel2").val("");
			$.messager.alert('提示','增加成功！');
		}else{
			$.messager.alert('提示','增加失败！');
		}
		
	})
}
//新增关闭
function addguanbi(){
	
	$('#addwin').window('close');
}
//锁定
function suoding(index){
	var data = $("#dg").datagrid("getData");
	var row = data.rows[index];
	$.post("isShuoDing",{
		id:row.uid,
	},function(res){
		if(res>0){
			$("#dg").datagrid("reload");
			$.messager.alert('提示','锁定成功！');
		}else{
			$.messager.alert('提示','锁定失败！');
		}
		
	})
}
//解锁
function jiesuo(index){
	var data = $("#dg").datagrid("getData");
	var row = data.rows[index];
	$.post("noShuoDing",{
		id:row.uid,
	},function(res){
		if(res>0){
			$("#dg").datagrid("reload");
			$.messager.alert('提示','解锁成功！');
		}else{
			$.messager.alert('提示','解锁失败！');
		}
		
	})
}
function guanli(value,row,index){
    return "<a href='javascript:void(0)' onclick='guanlia(" + index+ ")'>管理</a>"	   
}
var uid=0;
function guanlia(index){
	var data = $("#dg").datagrid("getData");
	uid = data.rows[index].uid;
	$("#dg2").datagrid({
		url:'SelectURoles',  
		method:"post",
		queryParams:{
			
		}
	})
	$("#dg3").datagrid({
		url:'SelectRolesUsers',  
		method:"post",
		queryParams:{
			id:uid
		}
	})
	$('#addjuese').window('open');
}
function juesetianjia(){
	alert("123");
	var xuanzhong=$('#dg2').datagrid('getSelected');
	
	$.post("InsertUserRoles",{
		userId:uid,
		roleId:xuanzhong.rid
	},function(res){
		if(res>0){
			$("#dg3").datagrid("reload");
		}else{
			$.messager.alert('提示','解锁失败！');
		}
		
	})
}
function jueseshanchu(){
	
}
</script>
<body>
<div id="tool">
<form id="ff">   
        
		<a  href="javascript:void(0)" class="easyui-linkbutton" onclick="init()" data-options="iconCls:'icon-search'">搜索</a>
		<a  href="javascript:void(0)" class="easyui-linkbutton" onclick="xinzeng()" data-options="iconCls:'icon-add'">新增</a>  
</form>  

</div>
	<div>
		<table id="dg" class="easyui-datagrid"
			style="width: 100%; height: 400px"
			data-options="toolbar:'#tool',fitColumns:true,singleSelect:true,pagination:true,pageSize:10,rownumbers:true">
			<thead>
				<tr>
					<th data-options="field:'loginName',width:100">名称</th>
					<th data-options="field:'passWord',width:100">密码</th>
					<th data-options="field:'isLoginData',width:100">锁定</th>
					<th data-options="field:'lastLoginData',width:100">最后登录时间</th>
					<th data-options="field:'createData',width:100">创建时间</th>
					<th data-options="field:'email',width:100">邮箱</th>
					<th data-options="field:'mtel',width:100">电话</th>
					<th data-options="field:'weight',width:100">分量</th>
					<th data-options="field:'a',width:100,formatter:caozuo">操作</th>
				    <th data-options="field:'b',width:100,formatter:guanli">管理</th>
				</tr>
			</thead>

		</table>
	</div>
	
	<div id="addwin" class="easyui-window" title="增加" style="width:300px;height:400px"   
        data-options="iconCls:'icon-save',modal:true,closed:true"> 
        <div style="padding: 20px 150px 50px 50px">  
    <div> 
    
    <label for="name">名称:</label>  
    <input class="easyui-validatebox" type="text" id="loginName2" name="loginName" data-options="required:true" />
    <label for="name">密码:</label>  
    <input class="easyui-validatebox" type="text" id="passWord2" name="passWord" data-options="required:true" />   
    <label for="name">创建时间:</label>  
    <input class="easyui-validatebox" type="text" id="createData2" name="createData" data-options="required:true" />   
    <label for="name">邮箱:</label>  
    <input class="easyui-validatebox" type="text" id="email2" name="email" data-options="required:true" />   
    <label for="name">电话:</label>  
    <input class="easyui-validatebox" type="text" id="mtel2" name="mtel" data-options="required:true" />   
    </div>  
    
    </div>
    <div style="padding-left:80px ">
    <a onclick="addbaocuen()" href="javascript:void(0)" class="easyui-linkbutton" ">保存</a>
    <a onclick="addguanbi()" href="javascript:void(0)" class="easyui-linkbutton" ">关闭</a>
    </div>
</div>  


<div id="addjuese" class="easyui-window" title="角色" style="width:500px;height:400px"   
        data-options="iconCls:'icon-save',modal:true,closed:true"> 
   
   <table>
			<thead>
				<tr>
					<th>
					 <table id="dg2" class="easyui-datagrid" style="width: 130px; height: 300px"
			             data-options="fitColumns:true,singleSelect:true,rownumbers:true">
		                	<thead>
			                	<tr>
					              <th data-options="field:'rname',width:100">名称</th>
				                </tr>
			                </thead>

		           </table>
					</th>
					<th>
					<a onclick="juesetianjia()" href="javascript:void(0)" class="easyui-linkbutton" ">>></a><br/>
                    <a onclick="jueseshanchu()" href="javascript:void(0)" class="easyui-linkbutton" ><<</a>
					</th>
					 <th>
					<table id="dg3" class="easyui-datagrid" style="width: 150px; height: 300px"
			             data-options="fitColumns:true,singleSelect:true,rownumbers:true">
		                	<thead>
			                	<tr>
					              <th data-options="field:'rname',width:100">名称</th>
				                </tr>
			                </thead>

		           </table>
					</th> 
				</tr>
			</thead>

		</table>
   
    <!-- <div style="padding-left:80px ">
    <a onclick="addbaocuen()" href="javascript:void(0)" class="easyui-linkbutton" ">保存</a>
    <a onclick="addguanbi()" href="javascript:void(0)" class="easyui-linkbutton" ">关闭</a>
    </div> -->
</div>  
</body>
</html>