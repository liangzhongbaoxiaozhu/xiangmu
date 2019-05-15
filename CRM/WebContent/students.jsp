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
<script type="text/javascript" src="js/jquery-easyui-1.4.5/test.js"></script>
<script type="text/javascript">
$(function(){
	init();
})
function init(){
	$('#stutab').datagrid({    
	    url:'aaa',    
	    method:'post',
	    toolbar:"#stubar",
	    queryParams: {
	    	sname:$("#Sname2").val(),
	        Smtel:$("#Smtel2").val(),
	        zixunshi:$("#zixunshi2").val(),
	        QQ:$("#QQ2").val(),
	        StartData:$("#StartData2").datebox("getValues").toString(),
	        EndData:$("#EndData2").datebox("getValues").toString(),
	        IsPay:$("#IsPay2").combobox("getValues").toString(),
	        IsEffective:$("#IsEffective2").combobox("getValues").toString(),
	        IsReturnVisit:$("#IsReturnVisit2").combobox("getValues").toString()
		}
	});  
     $("#ffs").form("reset");
}

function formatterCaozuo(value,row,index){
	return "<a href='javascript:void(0)' onclick='edit("+ index +")'>修改</a>   <a href='javascript:void(0)' onclick='del("+ index +")'>删除</a>"
}
function edit(index){
	
	var arrs=$('#stutab').datagrid("getData").rows[index];
	$("#fors").form("load",arrs);
	$("#upds").dialog("open");
}
/* 修改 */
function saveEdit1(){
	$("updateStu",{
		sid:$("#usid").val(),
		sname:$("#usname").val(),
		sex:$("#usex").val(),
		smtel:$("#usmtel").val(),
		channel:$("#uchannel").val(),
		website:$("#uwebsite").val(),
		department:$("#udepartment").val(),
		nameConsultation:$("#unameConsultation").val(),
		region:$("#uregion").val(),
		curriculum:$("#ucurriculum").val(),
		scoring:$("#uscoring").val(),
		isEffective:$("#uisEffective").val(),
		isReturnVisit:$("#uisReturnVisit").val(),
		door:$("#udoor").val(),
		reason:$("#ureason").val(),
		isPay:$("#uisPay").val(),
		payData:$("#upayData").val(),
		isRefund:$("#uisRefund").val(),
		isClassEntry:$("#uisClassEntry").val(),
		classEntryData:$("#uclassEntryData").val(),
		classEntryRemarks:$("#uclassEntryRemarks").val(),
		reasonsRefund:$("#ureasonsRefund").val(),
    	follow:$("#ufollow").val(),
    	isEnroll:$("#uisEnroll").val(),
    	remarks:$("#uremarks").val(),
    	consultantId:$("#uconsultantId").val(),
    	networkConsultantId:$("#unetworkConsultantId").val(),
    	entryPersonId:$("#uentryPersonId").val(),
    	consultantRemarks:$("#uconsultantRemarks").val()
    	
	},function(res){
		if(res>0){
			$("#stutab").form("clear");
			$("#upds").dialog("close");
			$.messager.alert('警告','修改成功');
		}else{
			$.messager.alert('警告','修改失败');
		}
	},"text")
}



/* 添加 */
function insertStu(){
	$("#inse").window("open");
}
function addb(){
	alert(sname+sex);
	$.post("addStu",{
		sname:$("#sname1").val(),
		sex:$("#sex1").val(),
		age:$("#age1").val(),
		smtel:$("#smtel1").val(),
		education:$("#education1").val(),
		state:$("#state1").val(),
		channel:$("#channel1").val(),
		website:$("#website1").val(),
		qq:$("#qq1").val(),
		weiXin:$("#weiXin1").val(),
		isEnroll:$("#isEnroll1").val(),
    	remarks:$("#remarks1").val()
    	
	},function(res){
		$("#stutab").datagrid("reload");
		$("#sname1").val(""),
		$("#sex1").val(""),
		$("#age1").val(""),
		$("#smtel1").val(""),
		$("#education1").val(""),
		$("#state1").val(""),
		$("#channel1").val(""),
		$("#website1").val(""),
		$("#qq1").val(""),
		$("#weiXin1").val(""),
		$("#isEnroll1").val(""),
    	$("#remarks1").val("")
    	
		if(res>0){
			$("#inse").window("close");
			$.messager.alert('新增成功');
		}else{
			$.messager.alert('新增失败');
		}
	})
}
function addc(){
	$("#adds").window("close");
}

/* 删除  */
function del(index){
	var sid=$("#stutab").datagrid("getData").rows[index].sid;
	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
	    if (r){    
	        $.post("deleteStu",{
	        	sid:sid
	        },function(res){
	        	if(res>0){
	        		$("#stutab").datagrid("reload");
	        		$.messager.alert('警告','删除成功');    
	        	}else{
	        		$.messager.alert('警告','删除失败');
	        	}
	        },"text")   
	        
	    }    
	});  
}

</script>
</head>
<body>

   <!-- 搜索表单 -->
   <div id="stubar">
     <form id="ffs" method="post">   
       <label for="name">姓名:</label>   
       <input class="easyui-validatebox" type="text" id="Sname2" />
       <label for="name">电话:</label>   
       <input class="easyui-validatebox" type="text" id="Smtel2" />
       <label for="name">咨询师:</label>   
       <input class="easyui-validatebox" type="text" id="zixunshi2" />
       <label for="name">QQ:</label>   
       <input class="easyui-validatebox" type="text" id="QQ2" /> 
       <label for="name">创建时间开始时间:</label>   
        <input  id="StartData2"  class= "easyui-datebox" > </input>   
        <label for="name">创建时间结束时间:</label>   
		<input  id="EndData2"   class= "easyui-datebox" > </input>
       <label for="name">是否缴费:</label>   
        <select id="IsPay2" class="easyui-combobox" name="dept" style="width:150px;">   
         <option value="">--请选择--</option>   
         <option value="已缴费">已缴费</option> 
         <option value="未缴费">未缴费</option>
        </select> 
        <label for="name">是否有效:</label>   
        <select id="IsEffective2" class="easyui-combobox" name="dept" style="width:150px;">   
         <option value="">--请选择--</option>   
         <option value="是">是</option>   
         <option value="否">否</option>
         <option value="待定">待定</option>   
        </select> 
        <label for="name">回访情况:</label>   
        <select id="IsReturnVisit2" class="easyui-combobox" name="dept" style="width:150px;">   
         <option value="">--请选择--</option>   
         <option value="未回访">未回访</option>   
         <option value="已回访">已回访</option>   
        </select> 
       <a href="javascript:void(0)" onclick="init()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>  
       <a href="javascript:void(0)" onclick="insertStu()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>  
     </form>  
   </div>
    
    
    <!-- 数据表格 -->
    <table id="stutab" class="easyui-datagrid" style="width:100%;height:400px" data-options="fitColumns:true,singleSelect:true,pagination:true">   
    <thead>   
        <tr>   
            <!-- <th data-options="field:'sid'">ID</th>    -->
            <th data-options="field:'sname'">姓名</th>   
            <th data-options="field:'sex'">性别</th>
            <th data-options="field:'age'">年龄</th>   
            <th data-options="field:'smtel'">电话</th>   
            <th data-options="field:'education'">学历</th>
            <th data-options="field:'state'">个人状态</th>   
            <th data-options="field:'channel'">来源渠道</th>   
            <th data-options="field:'website'">来源网站</th>
            <th data-options="field:'department'">来源部门</th>   
            <th data-options="field:'nameConsultation'">咨询姓名</th>   
            <th data-options="field:'region'">所在区域</th>
            <th data-options="field:'isReport'">是否报备</th>   
            <th data-options="field:'curriculum'">课程方向</th>   
            <th data-options="field:'scoring'">打分</th>
            <th data-options="field:'isEffective'">是否有效</th>   
            <th data-options="field:'returnVisitData'">首次回访时间</th>   
            <th data-options="field:'isReturnVisit'">是否回访</th>
            <th data-options="field:'door'">是否上门</th>   
            <th data-options="field:'doorData'">上门时间</th>   
            <th data-options="field:'reason'">无效原因</th>
            <th data-options="field:'isPay'">是否缴费</th>   
            <th data-options="field:'payData'">缴费时间</th>   
            <th data-options="field:'money'">金额</th>
            <th data-options="field:'isRefund'">是否退费</th>   
            <th data-options="field:'isClassEntry'">是否进班</th>   
            <th data-options="field:'classEntryData'">进班时间</th>
            <th data-options="field:'classEntryRemarks'">进班备注</th> 
            <th data-options="field:'reasonsRefund'">退费原因</th>
            <th data-options="field:'earnestMoney'">定金金额</th>
            <th data-options="field:'earnestMoneyData'">定金时间</th>  
            <th data-options="field:'follow'">学员关注</th>   
            <th data-options="field:'qq'">QQ</th>
            <th data-options="field:'weiXin'">微信</th>   
            <th data-options="field:'isEnroll'">是否报名</th>   
            <th data-options="field:'remarks'">在线备注</th> 
            <th data-options="field:'consultantId'">咨询师</th>   
           <!--  <th data-options="field:'networkConsultantId'">网络咨询师</th>    -->
            <th data-options="field:'entryPersonId'">录入人</th>
            <th data-options="field:'consultantRemarks'">咨询师备注</th>
            <th data-options="field:'caozuo',formatter:formatterCaozuo">操作</th>   
        </tr>   
    </thead>   
</table>  
<!-- 修改表单 -->
<div id="upds" class="easyui-dialog" 
		data-options="title:'修改',modal:true,closed:true,
			buttons:[{
				text:'保存',
				handler:function(){
				    saveEdit1();
				}
			},{
				text:'关闭',
				handler:function(){}
			}]">
	<form id="fors" class="easyui-form" method="post"> 
	<table>
	    <tr>
          <td>
              在线录入
          </td> 
          <td>
              
          </td>
          
          <td>
             咨询师录入 
          </td> 
          <td>
              
          </td>
       </tr>
        <tr>
          <td>
              在线录入
          </td> 
          <td>
              
          </td>
          <td>
             咨询师录入 
          </td> 
          <td>
              
          </td>
       </tr>
	</table>   
       
            
        
     </form>
</div>    
<!-- 添加表单 -->
<div id="inse" class="easyui-window" title="添加" data-options="iconCls:'icon-save',modal:true,closed:true">   
     <div style="padding: 20px 150px 50px 50px">
         <div>
           <label for="name">姓名:</label>   
        <input class="easyui-validatebox" type="text" id="sname1" name="sname1" data-options="required:true"/>
       </div> 
        <div>
          <label for="name">性别:</label>   
          <input class="easyui-validatebox" type="text" id="sex1" name="sex1" data-options="required:true"/>   
       </div> 
      <div>
          <label for="name">年龄:</label>   
          <input class="easyui-validatebox" type="text" id="age1" name="age1" data-options="required:true"/>   
       </div> 
        <div>
           <label for="name">电话:</label>   
        <input class="easyui-validatebox" type="text" id="smtel1" name="smtel1" data-options="required:true"/> 
       </div>
       <div>
           <label for="name">学历:</label>   
        <input class="easyui-validatebox" type="text" id="education1" name="education1" data-options="required:true"/> 
       </div>
       <div>
           <label for="name">状态:</label>   
        <input class="easyui-validatebox" type="text" id="state1" name="state1" data-options="required:true"/> 
       </div>
        <div>
           <label for="name">来源渠道:</label>   
          <input class="easyui-validatebox" type="text" id="channel1" name="channel1" data-options="required:true"/>
       </div>
        <div>
            <label for="name">来源网站:</label>
        <input class="easyui-validatebox" type="text" id="website1" name="website1" data-options="required:true"/>   
       </div>
        
        <div>
           <label for="name">QQ:</label>   
          <input class="easyui-validatebox" type="text" id="qq1" name="qq1" data-options="required:true"/>
       </div>
        <div>
          <label for="name">微信:</label>   
          <input class="easyui-validatebox" type="text" id="weiXin1" name="weiXin1" data-options="required:true"/>
       </div>

        <div>
          <label for="name">是否报名:</label>   
        <input class="easyui-validatebox" type="text" id="isEnroll1" name="isEnroll1" data-options="required:true"/>
       </div>
        
        <div>
          <label for="name">在线备注:</label>   
        <input class="easyui-validatebox" type="text" id="remarks1" name="remarks1" data-options="required:true"/>
       </div> 
        
     </div>
        <div style="padding-left:80px">
           <a href="javascript:void(0)" class="easyui-linkbutton" onclick="addb()">保存</a>
           <a href="javascript:void(0)" class="easyui-linkbutton" onclick="addc()">关闭</a>
        </div>
</div> 

</body>
</html>