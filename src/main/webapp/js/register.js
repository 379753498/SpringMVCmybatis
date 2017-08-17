function getContextPath() {
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}
function isEmail(strEmail) {
if (strEmail.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1)
return true;
else
return false;
}

$(document).ready(
	function() {

		//		$("#button").attr({	"disabled": "disabled"}); // 设置注册按钮不可用状态
		// 用户名合法性检测
		$('#username').bind({

			focus: function() {
				$("#username").nextAll().remove();
				$("#username").after("<p>鼠标点击空白处可立即检测用户名合法性</p>");

			},
			blur: function() {
				var username = {
					username: this.value
				};

				$("#username").nextAll().remove();
				$.ajax({
					type: "POST",
					url: getContextPath() + "/checkUser.do",
					data: username,
					success: function(data) {
						var sqe = data;

						if(sqe == "error") {
							$('#smail').html("验证码输入错误");
							$("#username").after("<p>用户名已经存在</p>");

						}
						if(sqe == "success") {
							$("#username").after("<p>用户名可用</p>");

						}

					}
				});
			}
		})
		// 动态设置注册提交的控制器
		$('#formuser').attr('action', getContextPath() + '/register.do');

		// 第一次访问页面请求验证码
		$.ajax({
			type: "POST",
			url: getContextPath() + "/login/getmssge.do",
			success: function(data) {
				$('#kaptchaImage').attr('src', getContextPath() + data);
			}
		});

		//验证码点击更换功能模块
		$('#kaptchaImage').click(
			function() {

				var time = Math.round(Math.random() * 999) + 3000;
				$(this).attr(
					'src',
					getContextPath() + "/myweb/kaptcha.jpg/" + time +
					".do");

			});
		//验证码输入框绑定事件
		$('#kaptcha').bind({

			focus: function() {

				$('#smail').html("看不清，点击换一张");
			},
			blur: function() {
				var paramsTime = {
					kaptcha: this.value
				};
				$.ajax({
					type: "POST",
					url: getContextPath() + "/login/check.do",
					data: paramsTime,
					success: function(data) {

						var sqe = data;

						if(sqe == "error") {
							$('#smail').html("  验证码输入错误");

						}
						if(sqe == "success") {
							$('#smail').html("     验证码正确");

						}

					}
				});
			}
		});

		//设置移动到注册按钮后进行检测是否可以进行注册 暂时无需求

		$("#button").mouseenter(function() {

		});

		//检测密码和输入是否一致passwordto、		password
		$('#password').bind({

			focus: function() {
				$("#password").nextAll().remove();
			},
			blur: function() {

				$("#passwordto").nextAll().remove();
				$("#password").nextAll().remove();
				var password = $('#password').val();

				var passwordto = $('#passwordto').val();

				if(password != passwordto) {

					$("#password").after("<p>密码不一致</p>");

				}

			}
		});
		//检测密码和输入是否一致passwordto、		password

		$('#passwordto').bind({

			focus: function() {
				$("#passwordto").nextAll().remove();
			},
			blur: function() {

				$("#passwordto").nextAll().remove();
				$("#password").nextAll().remove();
				var password = $('#password').val();
				var passwordto = $('#passwordto').val();
				if(password != passwordto) {
					$("#passwordto").after("<p>密码不一致</p>");
				}
			}
		});


//验证邮箱是否合法

$("#Email").bind(
	
	{

			focus: function() {
				$("#Email").nextAll().remove();
			},
			blur: function() {
			var email=	$("#Email");
			 var  isemmail=isEmail(email.val());
			 if(!isemmail)
				 {
				 $("#Email").after("<p>邮箱格式错误</p>");
				 }
			 
			 
				}
			
		
	}
)

	



	});