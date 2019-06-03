<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
<title>Insert title here</title>

<script type="text/javascript">
       $(function(){
    	   $("#menuTree").tree({
   			method:'post',
   			url:"SelectModul",
   			queryParams:{
   				uid:<%=session.getAttribute("Uid")%>    <%--  --%>
   			}

   	});
    	   tixingxiaoxi(); 
       })
       //查询个人签到状态
       $.post("SelectGeRenQianDaoZhuangTai",{
    	   uid:<%=session.getAttribute("Uid")%>
       },function(res){
    	   var qianda = document.getElementById("qiandao");
   		   var qiantu = document.getElementById("qiantui");
    	   if(res==1||res==2){
    		qiantu.style.display = "block"; //style中的display属性
   			qianda.style.display = "none";
    	   }
    	   if(res==0){
    		qianda.style.display = "block"; //style中的display属性
    		qiantu.style.display = "none";
    	   }
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
  function qiandao(){
	$.post("Qian",{
		uid:<%=session.getAttribute("Uid")%>
	},function(res){
		$("#dg").datagrid("reload");
		var qianda = document.getElementById("qiandao");
		var qiantu = document.getElementById("qiantui");
		if(res.search("签到成功")!=-1){
			qiantu.style.display = "block"; //style中的display属性
			qianda.style.display = "none";
			$.messager.alert('提示','签到成功！');
		}else{
			$.messager.alert('提示','签到失败！');
		}
	})
}  
		function tixingxiaoxi(){
			$.post("SelectXiaoXi",{
				tid:<%=session.getAttribute("Uid")%>
			},function(res){
				if(res!=null){
					$.messager.show({
						title:'我的消息',
						msg:res[0].tips,
						timeout:4000,
						showType:'show',
						
					});
					
					 var len = $(".messager-body").length;  
					 setTimeout("tixingxiaoxi()",5000);
				}
				 
				

			},"json")
		}
		
		$(function(){
			window.setInterval(tixingxiaoxi(),5000);
		})
		
		function tuichu(){
			window.location="http://localhost:8081/CRM/index.jsp";  
		}
		//签退
		function qiantui(){
			   $.post("UpdateQianTui",{
				   uid:<%=session.getAttribute("Uid")%>
			   },function(res){
				   $("#dg").datagrid("reload");
				   var qianda = document.getElementById("qiandao");
				   var qiantu = document.getElementById("qiantui");
				   if(res.search("签退成功")!=-1){
					   qianda.style.display = "block"; //style中的display属性
					   qiantu.style.display = "none";
					   alert(res);  
				   }else{
					   alert(res);  
				   }
				   
			   })
		   }
		
		/* 
		  入参是目标时间的小时数，取值0-23，当然可以根据需要拓展成分钟数，这里主要是提供思路所以从简
		 */
		function setRegular(targetHour){
		  var timeInterval,nowTime,nowSeconds,targetSeconds 
		 
		  nowTime = new Date()
		  // 计算当前时间的秒数
		  nowSeconds = nowTime.getHours() * 3600 + nowTime.getMinutes() * 60 + nowTime.getSeconds()
		 
		  // 计算目标时间对应的秒数
		  targetSeconds =  targetHour * 3600
		 
		  //  判断是否已超过今日目标小时，若超过，时间间隔设置为距离明天目标小时的距离
		  timeInterval = targetSeconds > nowSeconds ? targetSeconds - nowSeconds: targetSeconds + 24 * 3600 - nowSeconds 
		  setTimeout(getProductFileList,timeInterval * 1000)
		}
		 
		function getProductFileList(){
		  $.post("KuangBan",{},function(res){
			  if(res<1){
				  alert("出现错误，请找管理员进行修改！");
			  }
		  })//你自己的数据处理函数
		  setTimeout(getProductFileList,24*3600 * 1000)//之后每天调用一次
		}
		setRegular(9);//比如目标是每天早上8点
		
		
		
	</script>

</head>
<body>
	<div class="easyui-layout" style="width: 100%; height: 700px;">
		<div data-options="region:'north'" style="height: 50px">
			<h2>
				CRM系统欢迎您！<%=session.getAttribute("name")%>
				<a 
					href="javascript:void(0)" 
					onclick="tuichu()" data-options="">退出</a>
				<a style="float: right;" id="qiandao"
					href="javascript:void(0)" class="easyui-linkbutton"
					onclick="qiandao()" data-options="iconCls:'icon-ok'">签到</a>
				<a style="float: right;display:none;" id="qiantui"
					href="javascript:void(0)" class="easyui-linkbutton"
					onclick="qiantui()" data-options="iconCls:'icon-ok'">签退</a>
			</h2>

		</div>

		<div data-options="region:'south',split:true" style="height: 50px;"></div>
		<!--<div data-options="region:'east',split:true" title="East" style="width:100px;"></div>-->
		<div data-options="region:'west',split:true" title="导航应用"
			style="width: 150px;">
			<div id="menuTree">
				<!--这个地方显示树状结构-->

			</div>
		</div>
		<div id="centerTabs" data-options="region:'center',iconCls:'icon-ok'"
			style="width: 530px;">
			<div id="tt" class="easyui-tabs">
				<!--这个地方采用tabs控件进行布局-->

			</div>
		</div>
	</div>
</body>
</html>