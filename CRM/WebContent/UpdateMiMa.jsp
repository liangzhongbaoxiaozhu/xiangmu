<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
        <link rel="stylesheet" type="text/css" href="js/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="js/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="js/css/demo.css" />
		<link rel="stylesheet" type="text/css" href="js/css/component.css" />
		<script type="text/javascript" src="js/jquery-easyui-1.4.5/jquery.min.js"></script>
		<script src="js/js/classie.js"></script>
		
</head>

		<script>
			(function() {
				// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
				if (!String.prototype.trim) {
					(function() {
						// Make sure we trim BOM and NBSP
						var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
						String.prototype.trim = function() {
							return this.replace(rtrim, '');
						};
					})();
				}

				[].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
					// in case the input is already filled..
					if( inputEl.value.trim() !== '' ) {
						classie.add( inputEl.parentNode, 'input--filled' );
					}

					// events:
					inputEl.addEventListener( 'focus', onInputFocus );
					inputEl.addEventListener( 'blur', onInputBlur );
				} );

				function onInputFocus( ev ) {
					classie.add( ev.target.parentNode, 'input--filled' );
				}

				function onInputBlur( ev ) {
					if( ev.target.value.trim() === '' ) {
						classie.remove( ev.target.parentNode, 'input--filled' );
					}
				}
			})();
			
			
			
		</script>
		<style>
.login-button { /* 按钮美化 */
	width: 270px; /* 宽度 */
	height: 40px; /* 高度 */
	border-width: 0px; /* 边框宽度 */
	border-radius: 3px; /* 边框半径 */
	background: #1E90FF; /* 背景颜色 */
	cursor: pointer; /* 鼠标移入按钮范围时出现手势 */
	outline: none; /* 不显示轮廓线 */
	font-family: Microsoft YaHei; /* 设置字体 */
	color: white; /* 字体颜色 */
	font-size: 17px; /* 字体大小 */
	margin-right: 20px;
	
	
}
.login-button:hover { /* 鼠标移入按钮范围时改变颜色 */
	background: #5599FF;
</style>
<body>
      <div class="container" style="width:100%;height:600px;">
      <section class="content" >
				<!-- <h2>Kaede</h2> -->
				<span class="input input--kaede" >
					<input class="input__field input__field--kaede" type="text" id="input-35" />
					<label class="input__label input__label--kaede" for="input-35">
						<span id="jiumima" class="input__label-content input__label-content--kaede">旧密码</span>
					</label>
				</span>
				<span class="input input--kaede">
					<input class="input__field input__field--kaede" type="text" id="input-36" />
					<label class="input__label input__label--kaede" for="input-36">
						<span id="xinmima" class="input__label-content input__label-content--kaede">新密码</span>
					</label>
				</span>
				<span  class="input input--kaede">
					<input class="input__field input__field--kaede" type="text" id="input-37" />
					<label class="input__label input__label--kaede" for="input-37">
						<span  class="input__label-content input__label-content--kaede">再次输入新密码</span>
					</label>
				</span>
				<input onclick="updatea()" class="login-button" type="button"  value="修改"/>
			</section> 
			
			
			<div/>
</body>
<script type="text/javascript">
		function updatea(){
			var jiu=document.getElementById("input-35").value;
			var xin=document.getElementById("input-36").value;
			var yanzheng=document.getElementById("input-37").value;
			
			if(xin==yanzheng){
				$.post("UpdateGeReMiMa",{
					uid: <%=session.getAttribute("Uid")%>,<%-- <%=1%> --%>
					passWord:jiu,
					mima:yanzheng
				},function(res){
					if(res>0){
						alert("修改成功！");
					}else{
						alert("修改失败！请重新修改");
					}
				});
			}else{
				alert("新密码输入不同！请重新输入");
			}
			
		}
		</script>
</html>