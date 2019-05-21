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
<script type="text/javascript" src="js/jquery-easyui-1.4.5/datagrid-transposedview.js"></script>
<script type="text/javascript">
function init(){
	$("#dg").datagrid({
		url:'SelectGe',  
		method:"post",
		view:transposedview,
		queryParams:{
			uid:1
		}
	})
	
} 
$(function(){
	   init();
})
function qiandao(){
	$.post("Qian",{
		uid:1
	},function(res){
		$("#dg").datagrid("reload");
		if(res>0){
			$.messager.alert('提示','签到成功！');
		}else{
			$.messager.alert('提示','签到失败！');
		}
	})
}
</script>
</head>
<body>
<div>
<div id="tool">
<form id="ff">   
		<!-- <a  href="javascript:void(0)" class="easyui-linkbutton" onclick="qiandao()" data-options="iconCls:'icon-ok'">签到</a> -->
</form>  
</div>
		<table id="dg" class="easyui-datagrid"
			style="width:100%; height: 200px"
			data-options="toolbar:'#tool',fitColumns:true,singleSelect:true,rownumbers:true">
			<thead>
				<tr>
					<th data-options="field:'loginName',width:200">名称</th>
					<th data-options="field:'passWord',width:200">密码</th>
					<th data-options="field:'isLoginData',width:200">锁定</th>
					<th data-options="field:'lastLoginData',width:200">最后登录时间</th>
					<th data-options="field:'createData',width:200">创建时间</th>
					<th data-options="field:'email',width:200">邮箱</th>
					<th data-options="field:'mtel',width:200">电话</th>
					<th data-options="field:'weight',width:200">分量</th>
					
				</tr>
			</thead>

		</table>
	</div>  

</body>
</html>