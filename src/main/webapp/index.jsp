<%@ page language="java"  pageEncoding="utf-8"%>  
<html>
	<head>
		<meta charset="UTF-8">
		<title>注册页面</title>
		<script type="text/javascript" src="../js/jquery.1.11.3.min.js"></script>	
	<script  type="text/javascript">
		
		function login1()
		{
			
			var username = $("#username").val();debugger;

		
			var password = $("#password").val();
		

		$.ajax(	{
			url:"/login",
			data:{"username":username,"password":password},
			type:"post",
			async:false,
			
			success: function(data){
				debugger;
				alert(data);
				window.location.href="/login";
				
				}
			});


		}
		
		
		function loginone()
		{
			

			var a = $("#username").val();
		
			var b = $("#password").val();
		

		$.ajax(	{
			url:"/loginone",
		
			type:"get",
			async:true,
			
		
			});


		}
		
		
	</script>
	</head>

	<body>


	
	
<center>
	<h2>欢迎来到测试注册系统</h2>
	
	
	<form action="/user/login" id="form" method="get">
		<center>
			用户名:<input type="text" id="username" name="username"/>
		</center>
		<br/>
		<center>
			密码  : <input type="password"  id="password" name="password"/>
		</center>
		<br/>
		<button id="login" onclick="login1()"> 登录</button>
		<!--<button id="zhuce" onclick="loginone()"> 注册</button>-->
		<input type="submit" value="提交" />
	</form>

</center>

	
	
	</body>
</html>
