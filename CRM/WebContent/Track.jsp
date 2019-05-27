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
     /*  alert($("#TrackStartData2").datebox("getValues"));  */
	$("#dg").datagrid({
		url:'TrackList',  
		method:"post",
		queryParams:{
			studentName:$("#Studentid2").val(),
			userName:$("#UserId2").val(),
			trackStartData:$("#TrackStartData2").datebox("getValues").toString(),
			trackEndData:$("#TrackEndData2").datebox("getValues").toString(),
			returnVisit:$("#ReturnVisit2").combobox("getValues").toString(),
			trackingMode:$("#Content2").combobox("getValues").toString()
		}
	})
	$("#ff").form("clear");
} 
$(function(){
	   init();
})
 function caozuo(value,row,index){
       return "<a  href='javascript:void(0)' onclick='chakan("+ index + ")'>查看</a>"	   
   }
 function chakan(index){
	 var data=$("#dg").datagrid("getData");
		var row=data.rows[index];
		$('#updatewin').form("load",row);
		$('#updatewin').window("open");
 }
 function updateguanbi(){
	 $('#updatewin').window("close");
 }
</script>
<body>

<div>
<div id="tool">
<form id="ff">   
        <label for="name">学生名称:</label>   
        <input class="easyui-textbox" style="width: 150px;"  id="Studentid2"   />   
        <label for="name">跟踪者:</label>   
        <input class="easyui-textbox" style="width: 150px;"  id="UserId2"   />
        <label for="name">跟踪开始时间:</label>   
        <input  id="TrackStartData2"  class= "easyui-datebox" > </input>   
        <label for="name">跟踪结束时间:</label>   
		<input  id="TrackEndData2"   class= "easyui-datebox" > </input>  <br/> 
		<label for="name">回访情况:</label>   
        <select id="ReturnVisit2" class="easyui-combobox" name="dept" style="width:150px;">   
         <option value="">--请选择--</option>   
         <option value="未回访">未回访</option>   
         <option value="已回访">已回访</option>   
        </select> 
        <label for="name">跟踪方式:</label>   
        <select id="Content2" class="easyui-combobox" name="dept" style="width:150px;">   
         <option value="">--请选择--</option>   
         <option value="电话">电话</option>   
         <option value="微信">微信</option> 
         <option value="QQ">QQ</option>     
        </select> 
		<a  href="javascript:void(0)" class="easyui-linkbutton" onclick="init()" data-options="iconCls:'icon-search'">搜索</a>
		<!-- <a  href="javascript:void(0)" class="easyui-linkbutton" onclick="xinzeng()" data-options="iconCls:'icon-add'">新增</a> -->  
</form>  

</div>
 <table id="dg" class="easyui-datagrid" style="width:100%;height:400px"   
        data-options="fitColumns:true,singleSelect:true,pagination:true,pageSize:10">   
    <thead>   
        <tr>   
            <th data-options="field:'tid',width:100">跟踪Id</th>   
            <th data-options="field:'studentName',width:100">学生</th>
            <th data-options="field:'usersName',width:100">员工</th>      
            <th data-options="field:'trackStartData',width:100">跟踪开始时间</th>
            <th data-options="field:'trackEndData',width:100">跟踪结束时间</th>   
            <th data-options="field:'returnVisit',width:100">回访情况</th> 
            <th data-options="field:'trackingMode',width:100">跟踪方式</th> 
            <th data-options="field:'content',width:100">内容</th> 
            <th data-options="field:'a',width:100,formatter:caozuo">操作</th>    
        </tr>   
    </thead>   

</table>  
</div>


<div id="updatewin" class="easyui-window" title="修改" style="width:260px;height:400px"   
        data-options="iconCls:'icon-save',modal:true,closed:true"> 
        <div style="padding: 20px 150px 50px 50px">  
    <div> 
    <label for="name">学生:</label>  
    <input class="easyui-validatebox" disabled="disabled" type="text" name="studentName" data-options="required:true" />
    <label for="name">员工:</label>  
    <input class="easyui-validatebox" disabled="disabled" type="text"  name="usersName" data-options="required:true" />
    <label for="name">开始:</label>  
    <input class="easyui-validatebox" disabled="disabled" type="text"  name="trackStartData" data-options="required:true" />
    <label for="name">结束:</label>  
    <input class="easyui-validatebox" disabled="disabled" type="text"  name="trackEndData" data-options="required:true" />
    <label for="name">回访:</label>  
    <input class="easyui-validatebox" disabled="disabled" type="text"  name="returnVisit" data-options="required:true" />
    <label for="name">跟踪:</label>  
    <input class="easyui-validatebox" disabled="disabled" type="text"  name="trackingMode" data-options="required:true" />
    <label for="name">内容:</label>  
    <input class="easyui-validatebox" disabled="disabled" type="text"  name="content" data-options="required:true" />
    </div>  
    
    </div>
    <div style="padding-left:80px ">
    <a onclick="updateguanbi()" href="javascript:void(0)" class="easyui-linkbutton" ">关闭</a>
    </div>
</div>  
</body>
</html>