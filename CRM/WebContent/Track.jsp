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
		url:'TrackList',  
		method:"post",
		queryParams:{
			
		}
	})
} 
$(function(){
	   init();
})
</script>
<body>

<div>
 <table id="dg" class="easyui-datagrid" style="width:100%;height:400px"   
        data-options="fitColumns:true,singleSelect:true,pagination:true,pageSize:10">   
    <thead>   
        <tr>   
            <th data-options="field:'tid',width:100">跟踪Id</th>   
            <th data-options="field:'studentid',width:100">学生Id</th>
            <th data-options="field:'userId',width:100">员工Id</th>      
            <th data-options="field:'trackStartData',width:100">跟踪开始时间</th>
            <th data-options="field:'trackEndData',width:100">跟踪结束时间</th>   
            <th data-options="field:'returnVisit',width:100">回访情况</th> 
            <th data-options="field:'trackingMode',width:100">跟踪方式</th> 
            <th data-options="field:'content',width:100">内容</th>    
        </tr>   
    </thead>   

</table>  
</div>
</body>
</html>