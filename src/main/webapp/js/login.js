function getContextPath() {
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}

$(document).ready(function() {
	$(function() {
		$('.loginbox').css({ 'position': 'absolute', 'left': ($(window).width() - 692) / 2 });
		$(window).resize(function() {
			$('.loginbox').css({ 'position': 'absolute', 'left': ($(window).width() - 692) / 2 });
		})
	});

	$.ajax({
		type: "POST",
		url: getContextPath() + "/login/getmssge.do",
		success: function(data) {
			$('#kaptchaImage').attr('src', getContextPath() + data);
		}
	});

	$('#kaptchaImage').click(function() {

		var time = Math.round(Math.random() * 999) + 3000;
		$(this).attr('src', getContextPath() + "/myweb/kaptcha.jpg/" + time + ".do");

	});

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
					
					var sqe=data;
					
					if(sqe=="error")
					{
						$('#smail').html("验证码输入错误");
					
					}
					if(sqe=="success")
					{
						$('#smail').html("验证码正确");
					
					}
					
					
					
				}
			});
		}
	});

});

function login() {

	var username = $("#username").val();
	var password = $("#password").val();
	var kaptcha = $("#kaptcha").val();

	$.ajax({
		url: getContextPath() + "/login/check.do",
		data: { "username": username, "kaptcha": kaptcha, "username": username },
		type: "post",
		async: true,

		success: function(data) {


		},
		error: function(xhr) {
			console.log(xhr);
			alert(xhr)
		}
	});

	var time = Math.round(Math.random() * 999) + 3000;
	$('#kaptchaImage').attr('src', getContextPath() + "/myweb/kaptcha.jpg/" + time + ".do");
}