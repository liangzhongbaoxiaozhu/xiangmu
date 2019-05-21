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
<script type="text/javascript" src="zjs/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.5/test.js"></script>
<script type="text/javascript">
$(function(){
	init();
})
function init(){
	$('#stutab').datagrid({    
	    url:'GeRen',    
	    method:'post',
	    toolbar:"#stubar",
	    queryParams: {
	    	uid:"1",
	    	sname:$("#Sname2").val(),
	        smtel:$("#Smtel2").val(),
	        zixunshi:$("#zixunshi2").val(),
	        QQ:$("#QQ2").val(),
	        startData:$("#StartData2").datebox("getValues").toString(),
	        endData:$("#EndData2").datebox("getValues").toString(),
	        isPay:$("#IsPay2").combobox("getValues").toString(),
	        isEffective:$("#IsEffective2").combobox("getValues").toString(),
	        isReturnVisit:$("#IsReturnVisit2").combobox("getValues").toString()
		}
	});  
     $("#ffs").form("reset");
}

function formatterCaozuo(value,row,index){
	return "<a href='javascript:void(0)' onclick='genzong("+index+")' class='easyui-linkbutton' >添加跟踪日志</a>    <a href='javascript:void(0)' onclick='edit("+ index +")'>修改</a>   <a href='javascript:void(0)' onclick='del("+ index +")'>删除</a>   <a href='javascript:void(0)' onclick='updateUU("+ index +")'>查看</a>    <a href='javascript:void(0)' onclick='ck_genzong("+ index +")'>查看日志</a>"
}
function edit(index){
	
	var arrs=$('#stutab').datagrid("getData").rows[index];
	$("#frm1").form("load",arrs);
	$("#upds").dialog("open");
}
/* 修改 */
 
function saveEdit1(){
	$("updateStu",{
	    Sid:$("#sid4").val(),
		Sname:$("#sname4").val(),
		Sex:$("#sex4").combobox("getValues").toString(),
		Age:$("#age4").val(),
		Smtel:$("#smtel4").val(),
		Education:$("#education4").val(),
		State:$("#state4").val(),
		Channel:$("#channel4").val(),
		Website:$("#website4").val(),
		KeyWord:$("#keyWord4").val(),
		Department:$("#department4").val(),
		NameConsultation:$("#nameConsultation4").val(),
		Region:$("#region4").val(),
		IsReport:$("#isReport4").combobox("getValues").toString(),
		Curriculum:$("#curriculum4").val(),
		IsEffective:$("#isEffective4").combobox("getValues").toString(),
		Scoring:$("#scoring4").val(),
		IsReturnVisit:$("#isReturnVisit4").val(),
		ReturnVisitData:$("#returnVisitData4").val(),
		Door:$("#door4").combobox("getValues").toString(),
		DoorData:$("#doorData4").val(),
		Reason:$("#reason4").val(),
		IsPay:$("#isPay4").combobox("getValues").toString(),
		PayData:$("#payData4").val(),
		Money:$("#money4").val(),
		IsRefund:$("#isRefund4").combobox("getValues").toString(),
		IsClassEntry:$("#isClassEntry4").combobox("getValues").toString(),
		ClassEntryData:$("#classEntryData4").val(),
		ClassEntryRemarks:$("#classEntryRemarks4").val(),
		ReasonsRefund:$("#reasonsRefund4").val(),
		EarnestMoney:$("#earnestMoney4").val(),
		EarnestMoneyData:$("#earnestMoneyData4").val(),
		Follow:$("#follow4").val(),
		QQ:$("#qQ4").val(),
		WeiXin:$("#weiXin4").val(),
		/* IsEnroll:$("#isEnroll4").combobox("getValues").toString(), */
		Remarks:$("#remarks4").val(),
		ConsultantId:$("#consultantId4").val(),
		NetworkConsultantId:$("#networkConsultantId4").val(),
		EntryPersonId:$("#entryPersonId4").val(),
		ConsultantRemarks:$("#consultantRemarks4").val()
    	
	},function(res){
		if(res>0){
			$("#stutab").form("clear");
			$("#upds").dialog("close");
			$.messager.alert('警告','修改成功');
		}else{
			$.messager.alert('警告','修改失败');
		}
	},"json")
}
function updsguanbi(){
	$("#upds").dialog("close");
}


/* 添加 */
function insertStu(){
	$("#inse").window("open");
}
function addb(){
	$.post("addStu",{
		sname:$("#sname1").val(),
		sex:$("#sex1").val(),
		age:$("#age1").val(),
		smtel:$("#smtel1").val(),
		education:$("#education1").combobox("getValues").toString(),
		state:$("#state1").combobox("getValues").toString(),
		channel:$("#channel1").combobox("getValues").toString(),
		website:$("#website1").combobox("getValues").toString(),
		keyWord:$("#keyWord1").val(),
		qq:$("#qq1").val(),
		weiXin:$("#weiXin1").val(),
		isEnroll:$("#isEnroll1").combobox("getValues").toString(),
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
    	$("#remarks1").val(""),
    	$("#keyWord1").val("")
		if(res>0){
			$("#inse").window("close");
			$.messager.alert("提示",'新增成功');
		}else{
			$.messager.alert("提示",'新增失败');
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



/* 添加跟踪信息 */
 
 var gzid=0;
function genzong(index) {
	var arrs=$('#stutab').datagrid("getData").rows[index];
	gzid=arrs.sid;
	$("#frm4").form("reset");
	$("#genzongStudent").dialog("open");
}
function genzongGuanbi() {
	$("#genzongStudent").dialog("close");
}

<%-- <%=session.getAttribute("Uid")%>  --%>
function genzongBaoCun() {
	$.post("Insertrizhi", {
		studentid : gzid,
		userId:<%=session.getAttribute("Uid")%>,      <%-- <%=1%> --%>               
		trackStartData : $("#trackStartData5").datetimebox("getValue"),
		returnVisit : $("#returnVisit5").val(),
		trackingMode : $("#trackingMode5").textbox("getValue"),
		content : $("#content5").val(),
		nextTrackingData : $("#nextTrackingData5").datetimebox("getValue")
	},function(res) {
		if (res == 1) {
			//alert('添加成功');
			$.messager.show({
				title : '我的消息',
				msg : '添加跟踪成功',
				timeout : 1000,
				showType : 'slide',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
				}
			});
			$("#genzongStudent").dialog("close");
			$("#stutab").datagrid("reload");
			$("#frm4").form("reset");
		} else {
			//alert('添加失败');
			$.messager.show({
				title : '我的消息',
				msg : '添加跟踪失败',
				timeout : 1000,
				showType : 'slide',
				style : {
					top : document.body.scrollTop
							+ document.documentElement.scrollTop,
				}
			});
			$("#genzongStudent").dialog("close");
			$("#frm4").form("reset");
		}
	}, 'json')
}

/*查看  */
function updateUU(index) {
	var data = $("#stutab").datagrid("getData");
	var row = data.rows[index];
	$("#frm2").form("load", row);
	$("#chakanStudent").dialog("open");
}
function updateUUGuanbi() {
	$("#chakanStudent").dialog("close");
}


function ck_genzong(index){
	$("#ck_gzrz_tt").datagrid(
			{
				url : 'selectrizi',
				method : 'post',
				pagination : true,
				queryParams : {
					uid : $("#stutab").datagrid("getData").rows[index].sid
				}

			});
	$("#ck_gzrz_win").window("open");
}
</script>
</head>
<body>

   <!-- 搜索表单 -->
   <div id="stubar">
     <form id="ffs" >   
       <label for="name">姓名:</label>   
       <input class="easyui-validatebox" type="text" id="Sname2" />
       <label for="name">电话:</label>   
       <input class="easyui-validatebox" type="text" id="Smtel2" />
       <label for="name">咨询师:</label>   
       <input class="easyui-validatebox" type="text" id="zixunshi2" />
       <label for="name">QQ:</label>   
       <input class="easyui-validatebox" type="text" id="QQ2" /> 
       <label for="name">首次回访开始时间:</label>   
        <input  id="StartData2"  class= "easyui-datebox" > </input>   
        <label for="name">首次回访结束时间:</label>   
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
            <th data-options="field:'keyWord'">来源关键词</th> 
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
            <th data-options="field:'zixunshi'">咨询师</th>   
           <!--  <th data-options="field:'networkConsultantId'">网络咨询师</th>    -->
            <th data-options="field:'entryPersonId'">录入人</th>
            <th data-options="field:'consultantRemarks'">咨询师备注</th>
            <th data-options="field:'caozuo',formatter:formatterCaozuo">操作</th>   
        </tr>   
    </thead>   
</table>  
<!-- 修改表单 -->
<div id="upds" class="easyui-dialog" 
 style="width: 700px; height: 550px"
		data-options="title:'修改',modal:true,closed:true,
			buttons:[{
				text:'保存',
				handler:function(){
				    saveEdit1();
				}
			},{
				text:'关闭',
				handler:function(){
				updsguanbi();
				}
			}]">
	<form id="frm1" class="easyui-form">
			<input disabled="disabled" type="text" id="sid4" name="sid"
				style="display: none;" />
			<div style="float: left;">
				<table>
					<tr>
						<td>
							<h3>在线录入</h3>
						</td>
					</tr>
					<tr>
						<td>姓名:</td>
						<td><input class="easyui-textbox" type="text" id="sname4"
							name="sname" /></td>
					</tr>
					<tr>
						<td>性别:</td>
						<td><select id="sex4" class="easyui-combobox"
							name="sex" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">男</option>
								<option value="2">女</option>
						</select></td>
					</tr>
					<tr>
						<td>年龄:</td>
						<td><input class="easyui-textbox" type="text"
							id="age4" name="age" /></td>
					</tr>
					<tr>
						<td>电话:</td>
						<td><input class="easyui-textbox" type="text"
							id="smtel4" name="smtel" /></td>
					</tr>
					<tr>
						<td>学历:</td>
						<td><input class="easyui-textbox" type="text" id="education4"
							name="education" /></td>
					</tr>
					<tr>
						<td>状态:</td>
						<td><input class="easyui-textbox" type="text"
							id="state4" name="state" /></td>
					</tr>
					<tr>
						<td>来源渠道:</td>
						<td><input class="easyui-textbox" type="text"
							id="channel4" name="channel" /></td>
					</tr>
					<tr>
						<td>来源网站:</td>
						<td><input class="easyui-textbox" type="text"
							id="website4" name="website" /></td>
					</tr>
					<tr>
						<td>来源关键字:</td>
						<td><input class="easyui-textbox" type="text"
							id="keyWord4" name="keyWord" /></td>
					</tr>
					<tr>
						<td>来源部门:</td>
						<td><input class="easyui-textbox" type="text"
							id="department4" name="department" /></td>
					</tr>
					<tr>
						<td>所在区域:</td>
						<td><input class="easyui-textbox" type="text"
							id="region4" name="region" /></td>
					</tr>
					<tr>
						<td>学员关注:</td>
						<td><input class="easyui-textbox" type="text"
							id="follow4" name="follow" /></td>
					</tr>
					<tr>
						<td>学员QQ:</td>
						<td><input class="easyui-textbox" type="text" id="qQ4"
							name="qQ" /></td>
					</tr>
					<tr>
						<td>微信号:</td>
						<td><input class="easyui-textbox" type="text" id="weiXin4"
							name="weiXin" /></td>
					</tr>
					<tr>
						<td>是否报备(是,否):</td>
						<td><select id="isReport4" class="easyui-combobox"
							name="isReport" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">是</option>
								<option value="2">否</option>
						</select></td>
					</tr>
					<tr>
						<td>咨询师:</td>
						<td><input class="easyui-textbox" type="text"
							id="consultantId4" name="consultantId" /></td>
					</tr>
					<tr>
						<td>录入人:</td>
						<td><input class="easyui-textbox" type="text"
							id="entryPersonId4" name="entryPersonId" /></td>
					</tr>
				</table>


			</div>


			<div style="float: right;">
				<table>
					<tr>
						<td>
							<h3>咨询师录入</h3>
						</td>
					</tr>
					<tr>
						<td>姓名咨询:</td>
						<td><input class="easyui-textbox" type="text"
							id="nameConsultation4" name="nameConsultation" /></td>
					</tr>
					<tr>
						<td>课程方向:</td>
						<td><input class="easyui-textbox" type="text"
							id="curriculum4" name="curriculum" /></td>
					</tr>
					<tr>
						<td>打分:</td>
						<td><input class="easyui-textbox" type="text" id="scoring4"
							name="scoring" /></td>
					</tr>
					<tr>
						<td>是否有效(是,否):</td>
						<td><select id="isEffective4" class="easyui-combobox" 
							name="isEffective" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">是</option>
								<option value="2">否</option>
								<option value="3">待定</option>
						</select></td>
					</tr>
					<tr>
						<td>无效原因:</td>
						<td><input class="easyui-textbox" type="text"
							id="reason4" name="reason" /></td>
					</tr>
					<tr>
						<td>是否回访(是,否):</td>
						<td><select id="isReturnVisit4" class="easyui-combobox"
							name="isReturnVisit" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">已回访</option>
								<option value="2">未回访</option>
						</select></td>
					</tr>
					<tr>
						<td>首访时间:</td>
						<td><input class="easyui-textbox" type="text"
							id="returnVisitData4" name="returnVisitData" /></td>
					</tr>
					<tr>
						<td>是否上门(是,否):</td>
						<td><select id="door4" class="easyui-combobox"
							name="door" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">已上门</option>
								<option value="2">未上门</option>
						</select></td>
					</tr>
					<tr>
						<td>上门时间:</td>
						<td><input class="easyui-textbox" type="text"
							id="doorData4" name="doorData" /></td>
					</tr>
					<tr>
						<td>定金金额:</td>
						<td><input class="easyui-textbox" type="text"
							id="earnestMoney4" name="earnestMoney" /></td>
					</tr>
					<tr>
						<td>定金时间:</td>
						<td><input class="easyui-textbox" type="text"
							id="earnestMoneyData4" name="earnestMoneyData" /></td>
					</tr>
					<tr>
						<td>是否缴费(是,否):</td>
						<td><select id="isPay4" class="easyui-combobox"
							name="isPay" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">已缴费</option>
								<option value="2">未缴费</option>
						</select></td>
					</tr>
					<tr>
						<td>缴费时间:</td>
						<td><input class="easyui-textbox" type="text"
							id="payData4" name="payData" /></td>
					</tr>
					<tr>
						<td>缴费金额:</td>
						<td><input class="easyui-textbox" type="text" id="money4"
							name="money" /></td>
					</tr>
					<tr>
						<td>是否退费(是,否):</td>
						<td><select id="isRefund4" class="easyui-combobox"
							name="isRefund" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">已退费</option>
								<option value="2">未退费</option>
						</select></td>
					</tr>
					<tr>
						<td>退费原因:</td>
						<td><input class="easyui-textbox" type="text"
							id="reasonsRefund4" name="reasonsRefund" /></td>
					</tr>
					<tr>
						<td>是否进班(是,否):</td>
						<td><select id="isClassEntry4" class="easyui-combobox"
							name="isClassEntry" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">已进班</option>
								<option value="2">未进班</option>
						</select></td>
					</tr>
					<tr>

						<td>进班时间:</td>
						<td><input class="easyui-textbox" type="text"
							id="classEntryData4" name="classEntryData" /></td>
					</tr>
					<tr>

						<td>进班备注:</td>
						<td><input class="easyui-textbox" type="text"
							id="classEntryRemarks4" name="classEntryRemarks" /></td>
					</tr>
					<tr>
						<td>咨询师 备注:</td>
						<td><input class="easyui-textbox" type="text"
							id="consultantRemarks4" name="consultantRemarks" /></td>
					</tr>
				</table>
			</div>
		</form>
            
</div>    
<!-- 添加表单 -->
<div id="inse" class="easyui-window" title="添加" data-options="iconCls:'icon-save',modal:true,closed:true">   
     <div style="padding: 20px 150px 50px 50px">  
    <div> 
    <div>
          <label for="name">姓名:</label>   
          <input class="easyui-validatebox" type="text" id="sname1" name="sname1" data-options="required:true"/>
   </div> <div><br/><label for="name">性别:</label>   
          <input class="easyui-validatebox" type="text" id="sex1" name="sex1" data-options="required:true"/>   
    </div> <div>      <br/><label for="name">年龄:</label>   
          <input class="easyui-validatebox" type="text" id="age1" name="age1" data-options="required:true"/>   
    </div> <div>      <br/><label for="name">电话:</label>   
          <input class="easyui-validatebox" type="text" id="smtel1" name="smtel1" data-options="required:true"/> 
    </div> <div>      <br/><label for="name">学历:</label>   
          <select id="education1" class="easyui-combobox" name="dept" style="width:150px;">   
            <option value="">--请选择--</option>   
            <option value="未知">未知</option>   
            <option value="大专">大专</option>
            <option value="高中">高中</option>  
            <option value="中专">中专</option>
            <option value="初中">初中</option>
            <option value="本科">本科</option> 
            <option value="其它">其它</option> 
          </select> 
     </div> <div>     <br/><label for="name">状态:</label>   
          <select id="state1" class="easyui-combobox" name="dept" style="width:150px;">   
            <option value="">--请选择--</option>   
            <option value="未知">未知</option>   
            <option value="待业">待业</option>
            <option value="在职">在职</option>  
            <option value="在读">在读</option>
          </select>
     </div> <div>     <br/><label for="name">来源渠道:</label>   
          <select id="channel1" class="easyui-combobox" name="dept" style="width:150px;">   
	         <option value="">--请选择--</option>   
	         <option value="未知">未知</option>   
	         <option value="百度">百度</option>
	         <option value="百度移动端">百度移动端</option>  
	         <option value="360">360</option>
	         <option value="360移动端">360移动端</option>
	         <option value="搜狗">搜狗</option>
	         <option value="搜狗移动端">搜狗移动端</option>
	         <option value="UC移动端">UC移动端</option>
	         <option value="直接输入">直接输入</option>
	         <option value="自然流量">自然流量</option>
	         <option value="直电">直电</option>
	         <option value="微信">微信</option>
	         <option value="QQ">QQ</option>
          </select> 
     </div> <div>     <br/><label for="name">来源网站:</label>
          <select id="website1" class="easyui-combobox" name="dept" style="width:150px;">   
            <option value="">--请选择--</option>   
            <option value="其它">其它</option>   
            <option value="高考站">高考站</option>
            <option value="职英A站">职英A站</option>  
          </select>          
     </div> <div>     <br/><label for="name">来源关键词:</label>
          <input class="easyui-validatebox" type="text" id="keyWord1" name="keyWord1" data-options="required:true"/>  
    </div> <div>      <br/><label for="name">QQ:</label>   
          <input class="easyui-validatebox" type="text" id="qq1" name="qq1" data-options="required:true"/>
     </div> <div>     <br/><label for="name">微信:</label>   
          <input class="easyui-validatebox" type="text" id="weiXin1" name="weiXin1" data-options="required:true"/>
      </div> <div>    <br/><label for="name">是否报名:</label>   
          <select id="isEnroll1" class="easyui-combobox" name="dept" style="width:150px;">   
            <option value="">--请选择--</option>   
            <option value="是">是</option>
            <option value="否">否</option>  
          </select>
    </div>      <br/><label for="name">在线备注:</label>   
          <input class="easyui-validatebox" type="text" id="remarks1" name="remarks1" data-options="required:true"/>
     </div>
      </div>
        <div style="padding-left:80px">
           <a href="javascript:void(0)" class="easyui-linkbutton" onclick="addb()">保存</a>
           <a href="javascript:void(0)" class="easyui-linkbutton" onclick="addc()">关闭</a>
        </div>
</div> 


<!--  跟踪-->
	<div id="genzongStudent" class="easyui-dialog"
		style="width: 400px; height: 300px"
		data-options="title:' 添加跟踪信息 ',modal:true,closed:true,
			buttons:[{
				text:'保存',
				handler:function(){
				genzongBaoCun();
				}
			},{
				text:'关闭',
				handler:function(){
				genzongGuanbi();
				}
			}]">

		<form id="frm4" class="easyui-form" style="align: center;">
			<div style="text-align: center;">
				<table style="width: 70%; margin: auto;">
					<tr>
						<td>回访时间:</td>
						<td><input class="easyui-datetimebox" type="text"
							id="trackStartData5" /></td>
					</tr>
					<tr>
						<td>回访情况:</td>
						<td><input class="easyui-textbox" type="text"
							id="returnVisit5" /></td>
					</tr>
					<tr>
						<td>跟踪方式:</td>
						<td><input class="easyui-textbox" type="text"
							id="trackingMode5" /></td>
					</tr>
					<tr>
						<td>下次跟踪时间:</td>
						<td><input class="easyui-datetimebox" type="text"
							id="nextTrackingData5" /></td>
					</tr>
					<tr>
						<td>备注:</td>
						<td><input class="easyui-textbox" type="text" 
						id="content5" /></td>
					</tr>

				</table>
			</div>
		</form>
	</div>
	
	
	<!--查看  -->
	<div id="chakanStudent" class="easyui-dialog"
		style="width: 700px; height: 550px"
		data-options="title:' 查看 ',modal:true,closed:true,
			buttons:[{
				text:'关闭',
				handler:function(){
				updateUUGuanbi();
				}
			}]">

		<form id="frm2" class="easyui-form">

			<div style="float: left;">
				<table>
					<tr>
						
					</tr>
					<tr>
						<td>姓名:</td>
						<td><input class="easyui-textbox" type="text" id="sname6"
							name="sname" /></td>
					</tr>
					<tr>
						<td>性别:</td>
						<td><select id="sex6" class="easyui-combobox"
							name="sex" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">男</option>
								<option value="2">女</option>
						</select></td>
					</tr>
					<tr>
						<td>年龄:</td>
						<td><input class="easyui-textbox" type="text"
							id="age6" name="age" /></td>
					</tr>
					<tr>
						<td>电话:</td>
						<td><input class="easyui-textbox" type="text"
							id="smtel6" name="smtel" /></td>
					</tr>
					<tr>
						<td>学历:</td>
						<td><input class="easyui-textbox" type="text" id="education6"
							name="education" /></td>
					</tr>
					<tr>
						<td>状态:</td>
						<td><input class="easyui-textbox" type="text"
							id="state6" name="state" /></td>
					</tr>
					<tr>
						<td>来源渠道:</td>
						<td><input class="easyui-textbox" type="text"
							id="channel6" name="channel" /></td>
					</tr>
					<tr>
						<td>来源网站:</td>
						<td><input class="easyui-textbox" type="text"
							id="website6" name="website" /></td>
					</tr>
					<tr>
						<td>来源关键字:</td>
						<td><input class="easyui-textbox" type="text"
							id="keyWord6" name="keyWord" /></td>
					</tr>
					<tr>
						<td>来源部门:</td>
						<td><input class="easyui-textbox" type="text"
							id="department6" name="department" /></td>
					</tr>
					<tr>
						<td>所在区域:</td>
						<td><input class="easyui-textbox" type="text"
							id="region6" name="region" /></td>
					</tr>
					<tr>
						<td>学员关注:</td>
						<td><input class="easyui-textbox" type="text"
							id="follow6" name="follow" /></td>
					</tr>
					<tr>
						<td>学员QQ:</td>
						<td><input class="easyui-textbox" type="text" id="qQ6"
							name="qQ" /></td>
					</tr>
					<tr>
						<td>微信号:</td>
						<td><input class="easyui-textbox" type="text" id="weiXin6"
							name="weiXin" /></td>
					</tr>
					<tr>
						<td>是否报备(是,否):</td>
						<td><select id="isEnroll6" class="easyui-combobox"
							name="isEnroll" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">是</option>
								<option value="2">否</option>
						</select></td>
					</tr>
					<tr>
						<td>咨询师:</td>
						<td><input class="easyui-textbox" type="text"
							id="consultantId6" name="consultantId" /></td>
					</tr>
					<tr>
						<td>录入人:</td>
						<td><input class="easyui-textbox" type="text"
							id="entryPersonId6" name="entryPersonId" /></td>
					</tr>
				</table>

			</div>

			<div style="float: right;">
				<table>
					
					<tr>
						<td>姓名咨询:</td>
						<td><input class="easyui-textbox" type="text"
							id="nameConsultation6" name="nameConsultation" /></td>
					</tr>
					<tr>
						<td>课程方向:</td>
						<td><input class="easyui-textbox" type="text"
							id="curriculum6" name="curriculum" /></td>
					</tr>
					<tr>
						<td>打分:</td>
						<td><input class="easyui-textbox" type="text" id="scoring6"
							name="scoring" /></td>
					</tr>
					<tr>
						<td>是否有效(是,否):</td>
						<td><select id="xs_isyouxiao6" class="isEffective"
							name="isEffective" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">是</option>
								<option value="2">否</option>
								<option value="3">待定</option>
						</select></td>
					</tr>
					<tr>
						<td>无效原因:</td>
						<td><input class="easyui-textbox" type="text"
							id="reason6" name="reason" /></td>
					</tr>
					<tr>
						<td>是否回访(是,否):</td>
						<td><select id="isReturnVisit6" class="easyui-combobox"
							name="isReturnVisit" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">已回访</option>
								<option value="2">未回访</option>
						</select></td>
					</tr>
					<tr>
						<td>首访时间:</td>
						<td><input class="easyui-textbox" type="text"
							id="returnVisitData6" name="returnVisitData" /></td>
					</tr>
					<tr>
						<td>是否上门(是,否):</td>
						<td><select id="door6" class="easyui-combobox"
							name="door" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">已上门</option>
								<option value="2">未上门</option>
						</select></td>
					</tr>
					<tr>
						<td>上门时间:</td>
						<td><input class="easyui-textbox" type="text"
							id="doorData6" name="doorData" /></td>
					</tr>
					<tr>
						<td>定金金额:</td>
						<td><input class="easyui-textbox" type="text"
							id="earnestMoney6" name="earnestMoney" /></td>
					</tr>
					<tr>
						<td>定金时间:</td>
						<td><input class="easyui-textbox" type="text"
							id="earnestMoneyData6" name="earnestMoneyData" /></td>
					</tr>
					<tr>
						<td>是否缴费(是,否):</td>
						<td><select id="isPay6" class="easyui-combobox"
							name="isPay" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">已缴费</option>
								<option value="2">未缴费</option>
						</select></td>
					</tr>
					<tr>
						<td>缴费时间:</td>
						<td><input class="easyui-textbox" type="text"
							id="payData6" name="payData" /></td>
					</tr>
					<tr>
						<td>缴费金额:</td>
						<td><input class="easyui-textbox" type="text" id="money6"
							name="money" /></td>
					</tr>
					<tr>
						<td>是否退费(是,否):</td>
						<td><select id="xs_istuifei1" class="easyui-combobox"
							name="xs_istuifei" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">已退费</option>
								<option value="2">未退费</option>
						</select></td>
					</tr>
					<tr>
						<td>退费原因:</td>
						<td><input class="easyui-textbox" type="text"
							id="isRefund6" name=""isRefund"" /></td>
					</tr>
					<tr>
						<td>是否进班(是,否):</td>
						<td><select id="isClassEntry6" class="easyui-combobox"
							name="isClassEntry" style="width: 159px;">
								<option value="">— —请输入— —</option>
								<option value="1">已进班</option>
								<option value="2">未进班</option>
						</select></td>
					</tr>
					<tr>

						<td>进班时间:</td>
						<td><input class="easyui-textbox" type="text"
							id="classEntryData6" name="classEntryData" /></td>
					</tr>
					<tr>

						<td>进班备注:</td>
						<td><input class="easyui-textbox" type="text"
							id="classEntryRemarks6" name="classEntryRemarks" /></td>
					</tr>
					<tr>
						<td>咨询师 备注:</td>
						<td><input class="easyui-textbox" type="text"
							id="consultantRemarks6" name="consultantRemarks" /></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	
	
	<div id="ck_gzrz_win" class="easyui-window" title="查看跟踪日志"
		style="width: 600px; height: 400px; text-align: center;"
		data-options="iconCls:'icon-save',modal:true,closed:true">
		<h3>跟踪日志</h3>
			<table id="ck_gzrz_tt" class="easyui-datagrid" style="width:100%;height:250px">
		<thead>
			<tr>
				<th data-options="field:'studentName',width:100">学生</th>
				<th data-options="field:'trackStartData',width:100">跟踪时间</th>
				<th data-options="field:'trackStartData',width:100">内容</th>
				<th data-options="field:'trackStartData',width:100">下次跟踪时间</th>
				<th data-options="field:'gzcz',width:100">操作</th>
			</tr>
		</thead>
	</table>
	</div>
</body>
</html>