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
	$("#tt").tree({
		method:'post',
		url:"SelectMoKuaiShu",
		lines:"true"
		
});
} 
$(function(){
	   init();
	   
	   
	   $(function(){
			$("#tt").tree({
				onContextMenu:function(e,node){
					e.preventDefault(); 
					//查找节点
					$("#tt").tree("select",node.target);
					//显示右键菜单
					$("#mm").menu("show",{
						left:e.pageX,
						top:e.pageY
					})
				}
		});
		})
})
//删除
function remove() {
	var row=$("#tt").tree("getSelected");
	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
	    if (r){    
	    	$.post("DeleteModules", {
				id : row.id,
			}, function(res) {
				if(res>0){
					$.messager.alert('提示','删除成功!'); 
				}else{
					$.messager.alert('提示','删除失败!'); 
				}
			})
			$("#tt").tree("reload");  
	    }
	});  

	
}
//打开新增弹窗
function xinzeng(){
	$('#addwin').window("open");  
	
	
}
//新增保存
function addbaocuen(){
	var id=$("#tt").tree("getSelected").id;
	$.post("InsertModules",{
		mname:$("#mname2").val(),
		parentId:id,
		path:$("#path2").val(),
		weight:$("#weight2").val()
	},function(res){
		$("#tt").tree("reload");
		if(res>0){
			$('#addwin').window('close');
			$("#mname2").val("");
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
function xiugai(){
	var row=$("#tt").tree("getSelected");
	$("#path3").val(row.attributes.url);
	$("#weight3").val(row.attributes.weight);
	$('#updatewin').form("load",row);
	$('#updatewin').window("open");
}
//修改保存
function updatebaocuen(){
	var id=$("#tt").tree("getSelected").id;
	var fuid=$("#tt").tree("getSelected").parentid;
	$.post("UpdateModules",{
		mid:id,
		mname:$("#mname3").val(),
		parentId:fuid,
		path:$("#path3").val(),
		weight:$("#weight3").val()
	},function(res){
		$("#tt").tree("reload");
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
<div style="color:red;font-size:13px;">提示:右击节点进行操作</div>
  <hr/>
  <div>
  <ul id="tt"></ul>
  </div>
  <div id="mm" class="easyui-menu" data-options="" style="width:160px;">
  <div onclick="xinzeng()" data-options="iconCls:'icon-add'">追加</div>
  <div onclick="xiugai()" data-options="iconCls:'icon-edit'">修改</div>
  <div onclick="remove()" data-options="iconCls:'icon-remove'">移除</div>
 </div> 



<div id="addwin" class="easyui-window" title="增加" style="width:300px;height:400px"   
        data-options="iconCls:'icon-save',modal:true,closed:true"> 
        <div style="padding: 20px 150px 50px 50px">  
    <div> 
    
    <label for="name">名称:</label>  
    <input class="easyui-validatebox" type="text" id="mname2" name="mname" data-options="required:true" />
    <label for="name">路径:</label>  
    <input class="easyui-validatebox" type="text" id="path2" name="path" data-options="required:true" />   
    <label for="name">权重:</label>  
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
     <label for="name">名称:</label>  
    <input class="easyui-validatebox" type="text" id="mname3" name="text" data-options="required:true" />
    <label for="name">路径:</label>  
    <input class="easyui-validatebox" type="text" id="path3" name="url" data-options="required:true" />   
    <label for="name">权重:</label>  
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