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
      			$.post("SelectModul", {
      					id:<%=session.getAttribute("Uid")%>
      				},
      				function(res) { //res是返回的html代码
      					$("#menuTree").html(res);
      					$("#menuTree ul").tree(); //让easyUI引擎重新将treeUIId中的html代码转变成树并显示
      				}
      			);
      		} );
        	 
         
         
		
		//树状结构的节点是否已在中部显示，参数re是标题，html 是路径
		 function navTab(re, html) {
			
			var flag = $("#tt").tabs('exists', re);
			for(var i=0;i<<%=session.getAttribute("shu")%>;i++){
				$('#treeUlId'+(i+1)).tree({ //和前边加载数据的代码中的"treeUIId"参数,保持一致即可
					onSelect: function(node) {
						var isLeaf = $('#treeUlId'+(i+1)).tree('isLeaf', node.target); //是否是叶子节点
						if(isLeaf) { //只有叶子节点才会在选项卡中创建选项页（每个选项页对应1个功能）
							if(!flag) {
								$('#tt').tabs('add', { //在选项卡中，创建1个选项页
									title: re, //选项卡中，选项页的标题（在同一个选项卡中，选项页需要保持一致）。
									closable: true,
									content: "<iframe src='" + html + "' style='width:99%;height:500px;'/>" //此处做了调整，推荐使用iframe的方式实现
								});
							} else {
								$("#tt").tabs('select', re); //直接选中title对应的选项卡
							}
						}
					}
				});
			}
			
		} 
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