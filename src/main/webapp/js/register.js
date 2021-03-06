function getContextPath() {
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}
function isEmail(strEmail) {
	if (strEmail
			.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1) {
		return true;
	} else {
		return false;
	}

}

function gettoken() {
	// 获取token 访问后后台会给页面返回一个key token的变量
	$.ajax({
		type : "POST",
		url : getContextPath() + "/token.do",
		data : {},
		success : function(data) {

			$('#token').attr('value', data);
		}

	});
}

function check() {

	if (isEmail($("#Email").val()) && checkeusername() && passwordcheck()
			&& checkekaptchacode()) {
		alert("注册成功，请登录");
		return true;

	} else {
		alert("您的输入不符合规范，请重新输入正确信息再次提交");
		return false;
	}

}

function getkaptcha()
{
	var time = Math.round(Math.random() * 999) + 3000;
	$('#kaptchaImage').attr('src',
			getContextPath() + "/myweb/kaptcha.jpg/" + time + ".do");
}


function checkeusername() {
	var username = $("#username").val();
	var checke;

	$.ajax({
		type : "POST",
		url : getContextPath() + "/checkUser.do",
		data : {
			'username' : username
		},
		async : false,
		success : function(data) {
			var sqe = data;

			if (sqe == "error") {
				$("#username").nextAll().remove();
				$("#username").after("<p>用户名已经存在</p>");
				checke = false;

			}
			if (sqe == "success") {
				$("#username").nextAll().remove();
				$("#username").after("<p>用户名可用</p>");
				checke = true;
			}

		}
	});
	return checke;
}

function passwordcheck() {

	$("#passwordto").nextAll().remove();
	$("#password").nextAll().remove();
	var password = $('#password').val();

	var passwordto = $('#passwordto').val();

	if (password != passwordto) {

		$("#password").after("<p>密码不一致</p>");
		return false;
	}
	return true;
}

function checkekaptchacode() {
	var kaptcha = $('#kaptcha').val();
	var checkekaptchacode;
	$.ajax({
		type : "POST",
		url : getContextPath() + "/login/check.do",
		data : {
			"kaptcha" : kaptcha
		},
		async : false,
		success : function(data) {

			var sqe = data;

			if (sqe == "error") {
				
				checkekaptchacode = false;
			}
			if (sqe == "success") {
				
				checkekaptchacode = true;
			}

		}
	});
	return checkekaptchacode;

}

$(document).ready(
		function() {
			$('#formuser').attr('action', getContextPath() + '/register.do');// 动态设置注册提交的控制器
			gettoken();// 请求表单token值 默认页面加载完毕就进行请求
			getkaptcha();// 获取验证码请求
			// 用户名合法性监听事件
			$('#username').bind({
				focus : function() {
					$("#username").nextAll().remove();
					$("#username").after("<p>鼠标点击空白处可立即检测用户名合法性</p>");
				},
				blur : function() {
					checkeusername();
				}
			})
			// 验证码点击更换功能模块
			$('#kaptchaImage').click(
					function() {
						getkaptcha();
					});
			// 验证码输入框绑定事件
			$('#kaptcha').bind({

				focus : function() {

					$('#smail').html("看不清，点击换一张");
				},
				blur : function() {
					 var check=checkekaptchacode();//验证验证码是否正确
					
					if (check) {
						$('#smail').html("     验证码正确");
					}
					else {
						$('#smail').html("  验证码输入错误");
					}
				}
			});

			// 设置移动到注册按钮后进行检测是否可以进行注册 暂时无需求

			$("#button").mouseenter(function() {

			});

			// 检测密码和输入是否一致passwordto、 password
			$('#password').bind({

				focus : function() {
					$("#password").nextAll().remove();
				},
				blur : function() {
					passwordcheck();
				}
			});
			// 检测密码和输入是否一致passwordto、 password

			$('#passwordto').bind({

				focus : function() {
					$("#passwordto").nextAll().remove();
				},
				blur : function() {
					passwordcheck();
				}
			});

			// 验证邮箱是否合法

			$("#Email").bind(

			{

				focus : function() {
					$("#Email").nextAll().remove();
				},
				blur : function() {
					var email = $("#Email");
					var isemmail = isEmail(email.val());
					if (!isemmail) {
						$("#Email").after("<p>邮箱格式错误</p>");

					}

				}

			})

		});