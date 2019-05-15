<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.5/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.5/themes/default/easyui.css"/>
<script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
<title>Insert title here</title>

<script type="text/javascript">

       $(function(){
    	   $("#menuTree").tree({
   			method:'post',
   			url:"SelectModul",
   			queryParams:{
   				uid:<%=1%>  <%-- <%=session.getAttribute("Uid")%> --%>
   			}

   	});
    	   
    	  
       })
        $(function(){
        	   $("#menuTree").tree({
     		  onClick: function(node){
     				var flag = $("#tt").tabs('exists',node.text);
     							var isLeaf = $('#menuTree').tree('isLeaf', node.target); //是否是叶子节点
     							if(isLeaf) { //只有叶子节点才会在选项卡中创建选项页（每个选项页对应1个功能）
     								if(!flag) {
     									$('#tt').tabs('add', { //在选项卡中，创建1个选项页
     										title: node.text, //选项卡中，选项页的标题（在同一个选项卡中，选项页需要保持一致）。
     										closable: true,
     										content: "<iframe src='" + node.attributes.url + "' style='width:99%;height:500px;'/>" //此处做了调整，推荐使用iframe的方式实现
     									});
     								} else {
     									$("#tt").tabs('select', node.text); //直接选中title对应的选项卡
     								}
     						}
     			}

   		});
        })	  
        	  
		
	</script>
	
</head>
<body>
<div class="easyui-layout" style="width:100%;height:700px;">
			<div data-options="region:'north'"  style="height:50px">
				<h2>CRM系统欢迎您！<%=session.getAttribute("name")%></h2>
			</div>
			
			<div data-options="region:'south',split:true" style="height:50px;"></div>
			<!--<div data-options="region:'east',split:true" title="East" style="width:100px;"></div>-->
			<div data-options="region:'west',split:true" title="导航应用" style="width:150px;">
				<div id="menuTree">
					<!--这个地方显示树状结构-->

				</div>
			</div>
			<div id="centerTabs" data-options="region:'center',iconCls:'icon-ok'" style="width: 530px;">
				<div id="tt" class="easyui-tabs" >
					<!--这个地方采用tabs控件进行布局-->

				</div>
			</div>
		</div>
</body>
</html>