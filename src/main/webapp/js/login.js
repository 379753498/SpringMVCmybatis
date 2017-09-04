function getContextPath() {
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}

function register() {
	window.location.href = "register";
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

function getkaptcha()
{
	var time = Math.round(Math.random() * 999) + 3000;
	$('#kaptchaImage').attr('src',
			getContextPath() + "/myweb/kaptcha.jpg/" + time + ".do");
}



$(document).ready(
		function() {
			$(function() {
				$('.loginbox').css({
					'position' : 'absolute',
					'left' : ($(window).width() - 692) / 2
				});
				$(window).resize(function() {
					$('.loginbox').css({
						'position' : 'absolute',
						'left' : ($(window).width() - 692) / 2
					});
				})
			});

			getkaptcha();//获取验证码

			$('#kaptchaImage').click(
					function() {
						getkaptcha();//获取验证码
					});

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

		});

function login() {

	var username = $("#username").val();
	var password = $("#password").val();
	var kaptcha = $("#kaptcha").val();

	$.ajax({
		url : getContextPath() + "/login/login"+"?"+new Date(),
		data : {
			"username" : username,
			"kaptcha" : kaptcha,
			"password" : password
		},
		type : "post",
		async : true,

		success : function(data) {
			window.location.href = data+"?"+new Date();
		},
		error : function(xhr) {
			console.log(xhr);
			alert(xhr)
			getkaptcha();
		}
	});

	
}