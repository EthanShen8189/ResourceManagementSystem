<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="editRoom" action="<c:url value="/editItem"/>"
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
		<label class="control-label col-sm-2" for="roomNumber"> Room
			Number</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="roomNumber"
				id="roomNumber" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="roomBuilding">
			Building</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="roomBuilding" id="roomBuilding" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="roomCapacity">
			Capacity</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="roomCapacity"
				id="roomCapacity" />
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
	$('#editRoom').validate({
		rules : {
			name : {
				required : true
			},
			description : {
				required : true
			},
			roomNumber : {
				required : true
			},
			roomBuilding : {
				required : true
			},
			roomCapacity : {
				required : true
			}
		},
		messages : {
			name : "Name field cannot be blank.",
			description : "Description field cannot be blank.",
			roomNumber : "Please enter a room number",
			roomBuilding : "Please enter a value for building.",
			roomCapacity : "Please enter a value for capacity."
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
