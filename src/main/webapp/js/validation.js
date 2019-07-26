$(document).ready(function() {
	$('#loginForm').submit(function(e) {
		var first_name = $('#userName').val();
		var last_name = $('#password').val();
		if (first_name != "") {
			$("#userName").html("");
			if (password != "") {
				$("#password").html("");
				return true;
			} else {
				var error_name = $('#error_username').val();
				$("#error_username").html("password should not be empty");
				return false;
			}
		} else {
			var error_name = $('#error_username').val();
			$("#error_password").html("password should not be empty");
			return false;
		}
	})
})
