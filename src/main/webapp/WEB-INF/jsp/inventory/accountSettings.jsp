<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container" style="width: 400px !important;">
	<div class="pageTitle">
		<h4>Reset Password</h4>
	</div>
	<div class="row">
		<div>
			<font color="#228b22">${successMsg}</font>
			<font color="red">${errorMsg}</font>
		</div>
		<div class="col-md-offset-2">
			<form id="passwordForm" class="form-horizontal" action="<c:url value="/changePassword"/>" method="post">
				<input type="hidden" name="username" value="${username}">
				<input type="hidden" name="departmentId" value="${departmentId}">
				<div class="form-group">
					<label for="oldPassword" class="cols-sm-2 control-label">Enter
						current password:</label>
					<div class="cols-sm-10">
						<input type="password" class="form-control" name="oldPassword"
							id="oldPassword">
					</div>
				</div>
				<div class="form-group">
					<label for="newPassword" class="cols-sm-2 control-label">Enter
						new password:</label>
					<div class="cols-sm-10">
						<input type="password" class="form-control" name="newPassword"
							id="newPassword">
					</div>
				</div>
				<div class="form-group">
					<label for="confirmPassword" class="cols-sm-2 control-label">Confirm
						new password:</label>
					<div class="cols-sm-10">
						<input type="password" class="form-control" name="confirmPassword"
							id="confirmPassword">
					</div>
				</div>
				<br/>
				<div class="form-group" style="width: 150px; margin: auto;">
					<button type="submit" class="btn btn-primary btn btn-block">Submit</button>
				</div>
			</form>
		</div>
	</div>
</div>


<script>
	$('#passwordForm').validate({
		rules : {
			oldPassword : {
				required : true
			},
			newPassword : {
				required : true,
				minlength : 6
			},
			confirmPassword : {
				required : true,
				minlength : 6,
				equalTo : "#newPassword"
			}
		},
		messages : {
			oldPassword : "Please enter your old password.",
			newPassword : {
				required : "Please enter a new password.",
				minlength : "Your password must be at least 6 characters long"
			},
			confirmPassword : {
				required : "Please enter a new password.",
				minlength : "Your password must be at least 6 characters long",
				equalTo : "Passwords must match."
			},
		},
		highlight : function(element) {
			$(element).closest('.form-group').addClass('has-error');
		},
		unhighlight : function(element) {
			$(element).closest('.form-group').removeClass('has-error');
		},
		errorElement : 'span',
		errorClass : 'help-block',
		errorPlacement : function(error, element) {
			if (element.parent('.form-group').length) {
				error.insertAfter(element.parent());
			} else {
				error.insertAfter(element);
			}
		}
	});
</script>