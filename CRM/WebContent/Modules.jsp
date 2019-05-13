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
		url:'SelectModules',  
		method:"post",
		queryParams:{
			
		}
	})
} 
$(function(){
	   init();
})
 function caozuo(value,row,index){
       return "<a href='javascript:void(0)' onclick='bianji(" + index+ ")'>编辑</a> <a  href='javascript:void(0)' onclick='shanchu("+ index + ")'>删除</a>"	   
   }
//删除
function shanchu(index) {
	var data = $("#dg").datagrid("getData");
	var row = data.rows[index];
	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
	    if (r){    
	    	$.post("DeleteModules", {
				id : row.mid,
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
	$.post("InsertModules",{
		mname:$("#mname2").val(),
		parentId:$("#parentId2").val(),
		path:$("#path2").val(),
		weight:$("#weight2").val()
	},function(res){
		$("#dg").datagrid("reload");
		$("#rname2").val("");
		
		if(res>0){
			$('#addwin').window('close');
			$("#mname2").val("");
			$("#parentId2").val("");
			$("#path2").val("");
			$("#weight2").val("");
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
//修改
function bianji(index){
	var data=$("#dg").datagrid("getData");
	var row=data.rows[index];
	$('#updatewin').form("load",row);
	$('#updatewin').window("open");
}
//修改保存
function updatebaocuen(){
	$.post("UpdateModules",{
		mid:$("#mid3").val(),
		mname:$("#mname3").val(),
		parentId:$("#parentId3").val(),
		path:$("#path3").val(),
		weight:$("#weight3").val()
	},function(res){
		$("#dg").datagrid("reload");
		if(res>0){
			$('#updatewin').window('close');
			$.messager.alert('提示','修改成功！');
		}else{
			$.messager.alert('提示','修改失败！');
		}
		
	})
}
//修改关闭
function updateguanbi(){
	$('#updatewin').window('close');
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
					<th data-options="field:'mname',width:100">名称</th>
					<th data-options="field:'parentId',width:100">父id</th>
					<th data-options="field:'path',width:100">路径</th>
					<th data-options="field:'weight',width:100">权重</th>
					<th data-options="field:'a',width:100,formatter:caozuo">操作</th>
				</tr>
			</thead>

		</table>
	</div>
	
	<div id="addwin" class="easyui-window" title="增加" style="width:300px;height:400px"   
        data-options="iconCls:'icon-save',modal:true,closed:true"> 
        <div style="padding: 20px 150px 50px 50px">  
    <div> 
    
    <label for="name">名称:</label>  
    <input class="easyui-validatebox" type="text" id="mname2" name="mname" data-options="required:true" />
    <label for="name">父id:</label>  
    <input class="easyui-validatebox" type="text" id="parentId2" name="parentId" data-options="required:true" />   
    <label for="name">路径:</label>  
    <input class="easyui-validatebox" type="text" id="path2" name="path" data-options="required:true" />   
    <label for="name">路径:</label>  
    <input class="easyui-validatebox" type="text" id="weight2" name="weight" data-options="required:true" />   
    </div>  
    
    </div>
    <div style="padding-left:80px ">
    <a onclick="addbaocuen()" href="javascript:void(0)" class="easyui-linkbutton" ">保存</a>
    <a onclick="addguanbi()" href="javascript:void(0)" class="easyui-linkbutton" ">关闭</a>
    </div>
</div>  

<div id="updatewin" class="easyui-window" title="修改" style="width:300px;height:400px"   
        data-options="iconCls:'icon-save',modal:true,closed:true"> 
        <div style="padding: 20px 150px 50px 50px">  
   <div> 
    <label for="name">id:</label>  
    <input class="easyui-validatebox" disabled="disabled" type="text" id="mid3" name="mid" data-options="required:true" />   
     <label for="name">名称:</label>  
    <input class="easyui-validatebox" type="text" id="mname3" name="mname" data-options="required:true" />
    <label for="name">父id:</label>  
    <input class="easyui-validatebox" type="text" id="parentId3" name="parentId" data-options="required:true" />   
    <label for="name">路径:</label>  
    <input class="easyui-validatebox" type="text" id="path3" name="path" data-options="required:true" />   
    <label for="name">路径:</label>  
    <input class="easyui-validatebox" type="text" id="weight3" name="weight" data-options="required:true" />   
    </div>  
    </div>
    <div style="padding-left:80px ">
    <a onclick="updatebaocuen()" href="javascript:void(0)" class="easyui-linkbutton" ">保存</a>
    <a onclick="updateguanbi()" href="javascript:void(0)" class="easyui-linkbutton" ">关闭</a>
    </div>
</div>
</body>
</html>