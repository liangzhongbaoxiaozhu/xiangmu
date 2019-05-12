<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.min.js"></script>
   <link rel="stylesheet" href="assets/css/reset.css">
   <link rel="stylesheet" href="assets/css/supersized.css">
   <link rel="stylesheet" href="assets/css/style.css">
   <script src="assets/js/jquery-1.8.2.min.js"></script>
   <script src="assets/js/supersized.3.2.7.min.js"></script>
   <script src="assets/js/supersized-init.js"></script>
   <script src="assets/js/scripts.js"></script>
<title>Insert title here</title>
</head>

<script type="text/javascript">

	function changeCode() {
		var src = "getVerifyCode?methodName=" + new Date().getTime(); //加时间戳，防止浏览器利用缓存
		$('.verifyCode').attr("src", src); //jQuery写法
	}
	function DengLu(){
		$.post("DengLu",{
			name:$("#name").val(),
			password:$("#password").val(),
			YanZhengMa:$("#YanZhengMa").val()
		},function(res){
			if(res==1){
				alert("登录成功");
				window.location.href='ZhanShi.jsp';
			}else{
				alert("登录失败");
			}
			
		})
	}
</script>
<body>
 <div class="page-container">
            <h1>CRM系统登录</h1>
            <form>
                <input type="text" id="name" name="username" class="username" placeholder="用户名">
                <input type="password" id="password" name="password" class="password" placeholder="密码">
                
                <input type="text" id="YanZhengMa"  class="txtSearch" placeholder="验证码">
                <img class="verifyCode" style="padding-top: 10px;padding-right: 20px" onclick="changeCode()" src="getVerifyCode">
                <a href="#" onclick="changeCode()">点击图片切换</a>
                </form>
                <button  onclick="DengLu()">登录</button>
                <div class="error"><span>+</span></div>
            
            <div class="connect">
                <p>登录方式:</p>
                <p>
                    <a class="facebook" href="#"></a>
                    <a class="twitter" href="#"></a>
                </p>
            </div>
        </div>
        <!-- <div align="center">来自<a href="http://www.cssmoban.com/" target="_blank" title="">CRM</a></div> -->
	<!--验证码输入框 -->
	<!-- <input class="verifyInput" name="verifyInput" placeholder="请输入验证码"> -->


	<!-- 验证码图片 -->
	<!-- <img class="verifyCode" onclick="changeCode()" src="getVerifyCode"> -->


</body>
</html>