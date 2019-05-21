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
			loginName:$("#loginName").val(),
			isLoginData:$("#isLoginData").combobox("getValue"),
			cuanjiankaishi:$("#cuanjiankaishi").datebox('getValue'),
			cuanjianjieshu:$("#cuanjianjieshu").datebox('getValue'),
			paixu:$("#paixu").combobox("getValue")
		}
	})
	$("#ff").form("clear");
} 
$(function(){
	   init();
})
 function caozuo(value,row,index){
       return "<a href='javascript:void(0)' onclick='bianji(" + index+ ")'>编辑</a>   <a  href='javascript:void(0)' onclick='shanchu("+ index + ")'>删除</a>"	   
   }
   //锁定
   function suodings(value,row,index){
	   return "<a href='javascript:void(0)' onclick='suoding(" + index+ ")'>锁定</a>  <a href='javascript:void(0)' onclick='jiesuo(" + index+ ")'>解锁</a>"   
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
		email:$("#email2").val(),
		mtel:$("#mtel2").val()
		
	},function(res){
		$("#dg").datagrid("reload");
		
		if(res>0){
			$('#addwin').window('close');
			$("#loginName2").val("");
			$("#passWord2").val("");
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
	var xuanzhong=$('#dg2').datagrid('getSelected');
	
	$.post("InsertUserRoles",{
		userId:uid,
		roleId:xuanzhong.rid
	},function(res){
		if(res>0){
			$("#dg3").datagrid("reload");
		}else{
			$.messager.alert('提示','添加失败！');
		}
		
	})
}
function jueseshanchu(){
var xuanzhong=$('#dg3').datagrid('getSelected');
	
	$.post("deleteUserRoles",{
		userId:uid,
		roleId:xuanzhong.rid
	},function(res){
		if(res>0){
			$("#dg3").datagrid("reload");
		}else{
			$.messager.alert('提示','删除失败！');
		}
		
	})
}
//修改
var id=0;
function bianji(index){
	var data=$("#dg").datagrid("getData");
	var row=data.rows[index];
	id=row.uid;
	$('#updatewin').form("load",row);
	$('#updatewin').window("open");
}
//修改保存

function updatebaocuen(){
	$.post("updateUser",{
		uid:id,
		loginName:$("#loginName3").val(),
		email:$("#email3").val(),
		mtel:$("#mtel3").val()
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
function chongzhi(value,row,index){
	 return "<a href='javascript:void(0)' onclick='ChongZhi(" + index+ ")'>重置密码</a>"	   
}
function ChongZhi(index){
	var data=$("#dg").datagrid("getData");
	var row=data.rows[index];
	id=row.uid;
	$.post("updateMiMa",{
		id:id
	},function(res){
		$("#dg").datagrid("reload");
		if(res>0){
			$.messager.alert('提示','修改密码成功！');
		}else{
			$.messager.alert('提示','修改密码失败！');
		}
		
	})
}
//把锁定的0和1换成是否
function zhanshi(value,row,index){
	return value==0?"否":"是";
}
//权重
function quanzhong(value,row,index){
	return "<a href='javascript:void(0)' onclick='quanzhongguanli(" + index+ ")'>权重</a>";
}
var zid;
function quanzhongguanli(index){
	var data=$("#dg").datagrid("getData");
	var row=data.rows[index];
	zid=row.uid;
	$('#updatewinquanzhong').form("load",row);
	$('#updatewinquanzhong').window("open");
}

function updatequanzhongbaocuen(){
	$.post("UpdateQuanZhong",{
		uid:zid,
		weight:$("#weight4").val(),
		remarks:$("#remarks4").val()
	},function(res){
		$("#dg").datagrid("reload");
		if(res>0){
			alert("权重修改成功");
			$('#updatewinquanzhong').window('close');
		}else{
			alert("权重修改失败");
		}
	})
}
function updatequanzhongguanbi(){
	$('#updatewinquanzhong').window('close');
	
}
function zidong(){
	$('#zidongfenpei').window("open");
	$.post("selectzidongfen",{
		
	},function(res){
		if(res=="true"){
			$('#sb').switchbutton("check");
		}else{
			$('#sb').switchbutton("uncheck");
		}
		 
	})
	
	
	$('#sb').switchbutton({ 
	      onChange: function(checked){ 
	        if(checked){
	        	$.post("kaiqizidong",{
	        		
	        	},function(res){
	        		if(res<1){
	        			alert("修改失败");
	        		}
	        	})
	        }else{
				$.post("guanbizidong",{
	        		
	        	},function(res){
	        		if(res<1){
	        			alert("修改失败");
	        		}
	        	})
	        }
	      } 
	    }) 

}
</script>
<body>
<div id="tool">
<form id="ff">   
        <label for="name">名称:</label>   
        <input class="easyui-validatebox" style="width: 150px;" type="text" id="loginName"   />   
        <label for="name">是否锁定:</label>   
        <select id="isLoginData" class="easyui-combobox" name="dept" style="width:150px;">   
         <option value="">--请选择--</option>   
         <option value="0">否</option>   
         <option value="1">是</option>   
        </select> 
        <label for="name">创建开始时间:</label>   
        <input  id="cuanjiankaishi"  type= "text" class= "easyui-datebox" > </input>   
        <label for="name">创建结束时间:</label>   
		<input  id="cuanjianjieshu"  type= "text" class= "easyui-datebox" > </input>   
		<label for="name">排序方式:</label>   
        <select id="paixu" class="easyui-combobox" name="dept" style="width:150px;">   
         <option value="">--请选择--</option>   
         <option value="0">创建时间</option>   
         <option value="1">最后登录时间</option>   
        </select> <br/>
		<a  href="javascript:void(0)" class="easyui-linkbutton" onclick="init()" data-options="iconCls:'icon-search'">搜索</a>
		<a  href="javascript:void(0)" class="easyui-linkbutton" onclick="xinzeng()" data-options="iconCls:'icon-add'">新增</a>
		<a  href="javascript:void(0)" class="easyui-linkbutton" onclick="zidong()" data-options="iconCls:'icon-add'">变量自动分配</a>  
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
					<th data-options="field:'isLoginData',width:100,formatter:zhanshi">锁定</th>
					<th data-options="field:'lastLoginData',width:100">最后登录时间</th>
					<th data-options="field:'createData',width:100">创建时间</th>
					<th data-options="field:'email',width:100">邮箱</th>
					<th data-options="field:'mtel',width:100">电话</th>
					<th data-options="field:'weight',width:100">分量</th>
					<th data-options="field:'remarks',width:100">备注</th>
					<th data-options="field:'e',width:100,formatter:suodings">锁定</th>
					<th data-options="field:'a',width:100,formatter:caozuo">操作</th>
					<th data-options="field:'c',width:100,formatter:chongzhi">重置密码</th>
					<th data-options="field:'D',width:100,formatter:quanzhong">权重</th>
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


<div id="addjuese" class="easyui-window" title="角色" style="width:334px;height:400px"   
        data-options="iconCls:'icon-save',modal:true,closed:true"> 
   
   <table>
			<thead>
				<tr>
					<th>
					 <table id="dg2" class="easyui-datagrid" style="width: 140px; height: 300px;"
			             data-options="fitColumns:true,singleSelect:true,rownumbers:true,scrollbarSize:0">
		                	<thead>
			                	<tr>
					              <th data-options="field:'rname',width:120">名称</th>
				                </tr>
			                </thead>

		           </table>
					</th>
					<th>
					<a onclick="juesetianjia()" href="javascript:void(0)" class="easyui-linkbutton" ">>></a><br/><br/>
                    <a onclick="jueseshanchu()" href="javascript:void(0)" class="easyui-linkbutton" ><<</a>
					</th>
					 <th>
					<table id="dg3" class="easyui-datagrid" style="width: 140px; height: 300px"
			             data-options="fitColumns:true,singleSelect:true,rownumbers:true,scrollbarSize:0">
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
</div>  


<div id="updatewin" class="easyui-window" title="修改" style="width:300px;height:400px"   
        data-options="iconCls:'icon-save',modal:true,closed:true"> 
        <div style="padding: 20px 150px 50px 50px">  
    <div> 
    
    <label for="name">名称:</label>  
    <input class="easyui-validatebox" disabled="disabled" type="text" id="loginName3" name="loginName" data-options="required:true" />
    
    <label for="name">邮箱:</label>  
    <input class="easyui-validatebox" type="text" id="email3" name="email" data-options="required:true" />   
    <label for="name">电话:</label>  
    <input class="easyui-validatebox" type="text" id="mtel3" name="mtel" data-options="required:true" />   
    </div>  
    
    </div>
    <div style="padding-left:80px ">
    <a onclick="updatebaocuen()" href="javascript:void(0)" class="easyui-linkbutton" ">保存</a>
    <a onclick="updateguanbi()" href="javascript:void(0)" class="easyui-linkbutton" ">关闭</a>
    </div>
</div>  


<div id="updatewinquanzhong" class="easyui-window" title="修改权重" style="width:300px;height:400px"   
        data-options="iconCls:'icon-save',modal:true,closed:true"> 
        <div style="padding: 20px 150px 50px 50px">  
    <div> 
    <label for="name">权重:</label>  
    <input class="easyui-validatebox"  type="text"  id="weight4" name="weight" data-options="required:true" />
    <label for="name">备注:</label>  
    <input class="easyui-validatebox" type="text" id="remarks4" name="remarks" data-options="required:true" />   
    </div>  
    
    </div>
    <div style="padding-left:80px ">
    <a onclick="updatequanzhongbaocuen()" href="javascript:void(0)" class="easyui-linkbutton" ">保存</a>
    <a onclick="updatequanzhongguanbi()" href="javascript:void(0)" class="easyui-linkbutton" ">关闭</a>
    </div>
</div>  
<div id="zidongfenpei" class="easyui-window" title="变量自动分配" style="width:300px;height:120px"   
        data-options="iconCls:'icon-save',modal:true,closed:true"> 
        <div style="padding: 20px 10px 10px 50px">  
        
        <input id="sb" style="width:200px;height:30px"> 
   
        </div>
</div>
</body>
</html>