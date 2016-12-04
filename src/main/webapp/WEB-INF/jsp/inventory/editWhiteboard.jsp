<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="editWhiteboard" action="<c:url value="/editItem"/>"
	class="editForm form-horizontal" method="post">

	<div class="form-group">
		<label for="itemName" class="col-sm-2 control-label">Name</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="itemName" name="name"
				placeholder="Enter a Name"
				value="<%= request.getParameter("name") %>">
		</div>
	</div>

	<div class="form-group">
		<label for="description" class="col-sm-2 control-label">Description</label>
		<div class="col-sm-10">
			<textarea class="form-control" name="description" id="description"
				placeholder="Enter an Item Description" rows="3"><%= request.getParameter("description") %></textarea>
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="boardWidth">Width</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="boardWidth"
				id="boardWidth" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="boardHeight">Height</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="boardHeight"
				id="boardHeight" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="boardRoomNumber">Room
			Number</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="boardRoomNumber"
				id="boardRoomNumber" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" id="availability"
					value="Availability" />Available</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" id="moveable" value="moveable" />Moveable</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<br>
		<button type="submit" class="btn btn-primary btn-block form-button">Save</button>
	</div>
</form>

<script>
	$('#editWhiteboard').validate({
		rules : {
			name : {
				required : true
			},
			description : {
				required : true
			},
			boardWidth : {
				required : true
			},
			boardHeight : {
				required : true
			},
			boardRoomNumber : {
				required : true
			}
		},
		messages : {
			name : "Name field cannot be blank.",
			description : "Description field cannot be blank.",
			boardWidth : "Please enter a value for width.",
			boardHeight : "Please enter a value for height.",
			boardRoomNumber : "Please enter a value for room number."
		},
		highlight : function(element) {
			$(element).closest('.form-group').addClass('has-error');
		},
		unhighlight : function() {
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
