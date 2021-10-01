/*$(function() {*/
	alert("d");
	var loginDialog, loginForm;
	var adminLoginDialog, adminLoginForm;
	
	var userId = $("#userId"), password = $("#password"), 
	allField = $([]).add(userId).add(password);
	
	function checkLength(o, min, max) {
		console
		if (o.val().length > max || o.val().length < min) {
			o.addClass("ui-state-error");
			return false;
		} else {
			return true;
		}
	}
	
	loginDialog = $("#login-dialog-form").dialog({
		autoOpen : false,
		height : 500,
		width : 420,
		modal : true,
		buttons : {
			"확인" : function() {
				loginForm.trigger("submit");
			},
			"취소" : function() {
				loginDialog.dialog("close");
			}
		},
		close : function() {
			//			confirmForm[ 0 ].reset();
			allField.removeClass("ui-state-error");
		}
	});
	adminLoginDialog = $("#admin-login-dialog-form").dialog({
		autoOpen : false,
		height : 500,
		width : 500,
		modal : true,
		buttons : {
			"확인" : function() {
				adminLoginForm.trigger("submit");
			},
			"취소" : function() {
				adminLoginDialog.dialog("close");
			}
		},
		close : function() {
			//			confirmForm[ 0 ].reset();
			allField.removeClass("ui-state-error");
		}
	});
	
	adminLoginForm = adminLoginDialog.find("form").on("submit", function(event) {
		var valid = true;
		allField.removeClass("ui-state-error");
		
		valid = valid && checkLength(userId, 5, 15);
		valid = valid && checkLength(password, 4, 20);
		if (valid) {
			adminLoginDialog.dialog("close");
		}
		return valid;
	});
	
	loginForm = loginDialog.find("form").on("submit", function(event) {
		var valid = true;
		allField.removeClass("ui-state-error");
		
		valid = valid && checkLength(userId, 5, 15);
		valid = valid && checkLength(password, 4, 20);
		if (valid) {
			loginDialog.dialog("close");
		}
		return valid;
	});
	$("#studioBtn").on("click", function() {
		//loginDialog.dialog("open");
		alert("d");
	});
	$("#admin-icon").on("click", function() {
		adminLoginDialog.dialog("open");
	});
/*});*/