<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.4.5/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.4.5/themes/default/easyui.css" />
<script type="text/javascript"
	src="js/jquery-easyui-1.4.5/jquery.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
</head>
<script type="text/javascript">
function init(){
	$("#dg").datagrid({
		url:'SelectRoles',  
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
	$.messager.confirm('确认','您确认想要删除角色吗？',function(r){    
	    if (r){    
	    	$.post("DeleteRoles", {
				id : row.rid,
			}, function(res) {
					$.messager.alert('提示','删除'+res+'!'); 
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
	$.post("InsertRoles",{
		rname:$("#rname2").val(),
	},function(res){
		$("#dg").datagrid("reload");
		$("#rname2").val("");
		
		if(res>0){
			$('#addwin').window('close');
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
	$.post("UpdateRoles",{
		rid:$("#rid3").val(),
		rname:$("#rname3").val(),
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

function quanxian(value,row,index){
    return "<a href='javascript:void(0)' onclick='quanxianshezhi(" + index+ ")'>权限设置</a>"	   
}
var rid;
function quanxianshezhi(index){
				var data=$("#dg").datagrid("getData");
				var row=data.rows[index];
				rid=row.rid;
					$("#menuTree").tree({
						url:"SelectShu",
						checkbox:true,
						queryParams:{
							id:rid
						}
				}
			); 
			
	$('#updatequanxian').window("open");
}
function updateQXBC(){
	var a=$("#menuTree").tree("getChecked"); 
	var b="";
	for(var i=0;i<a.length;i++){
		/* alert(a[i].id); */
		var node = $('#menuTree').tree('find', a[i].id);
         /* alert(a[i].id+","+node.attributes.weight); */
        if(node.attributes.weight!="1"){
        	var fuid=$("#menuTree").tree("getParent",a[i].target);
        	if(fuid.parentid==null){
        		
    		}else{
    			if(b!=""){
        			if(fuid.attributes.weight!="1"){
        		        b=b+","+fuid.id;
        			}
        		}else{
        			if(fuid.attributes.weight!="1"){
        	            b=fuid.id;	
        			}
        		}
    		}
        	}
        	
		if(b!=""){
			if(node.attributes.weight!="1"){
		        b=b+","+a[i].id;
			}
		}else{
			if(node.attributes.weight!="1"){
	            b=a[i].id;	
			}
		}
	}
	/* alert(b);  */
	 $.post("InsertRoleModule",{
		Mid:b,
		Rid:rid
	},function(){
		$('#updatequanxian').window('close');
	}) 
}
function updateQXGB(){
	$('#updatequanxian').window('close');
}
</script>
<body>
<div id="tool">
<form id="ff">   
        
		
		<a  href="javascript:void(0)" class="easyui-linkbutton" onclick="xinzeng()" data-options="iconCls:'icon-add'">新增</a>  
</form>  

</div>
	<div>
		<table id="dg" class="easyui-datagrid"
			style="width: 100%; height: 400px"
			data-options="toolbar:'#tool',fitColumns:true,singleSelect:true,pagination:true,pageSize:10,rownumbers:true">
			<thead>
				<tr>
					<th data-options="field:'rname',width:100">名称</th>
					<th data-options="field:'a',width:100,formatter:caozuo">操作</th>
					<th data-options="field:'b',width:100,formatter:quanxian">权限</th>
					
				</tr>
			</thead>

		</table>
	</div>
	
	<div id="addwin" class="easyui-window" title="增加" style="width:300px;height:400px"   
        data-options="iconCls:'icon-save',modal:true,closed:true"> 
        <div style="padding: 20px 150px 50px 50px">  
    <div> 
    
    <label for="name">名称:</label>  
    <input class="easyui-validatebox" type="text" id="rname2" name="rname" data-options="required:true" />   
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
    <input class="easyui-validatebox" disabled="disabled" type="text" id="rid3" name="rid" data-options="required:true" />   
    <label for="name">名称:</label>  
    <input class="easyui-validatebox" type="text" id="rname3" name="rname" data-options="required:true" />   
    </div>  
    </div>
    <div style="padding-left:80px ">
    <a onclick="updatebaocuen()" href="javascript:void(0)" class="easyui-linkbutton" ">保存</a>
    <a onclick="updateguanbi()" href="javascript:void(0)" class="easyui-linkbutton" ">关闭</a>
    </div>
</div>

<div id="updatequanxian" class="easyui-window" title="权限修改" style="width:200px;height:300px"   
        data-options="iconCls:'icon-save',modal:true,closed:true"> 
        <div style="padding-left:25px;padding-top: 30px ">
        <div id="menuTree">
					<!--这个地方显示树状结构-->

		</div>
		</div>
		<div style="padding-left:50px;padding-top: 30px ">
    <a onclick="updateQXBC()" href="javascript:void(0)" class="easyui-linkbutton" ">保存    </a>
    <a onclick="updateQXGB()" href="javascript:void(0)" class="easyui-linkbutton" ">关闭</a>
</div>
</body>
</html>