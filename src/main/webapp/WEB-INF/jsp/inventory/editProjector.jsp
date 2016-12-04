<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="editProjector" action="<c:url value="/editItem"/>"
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
		<label class="control-label col-sm-2" for="projectorHeight">Resolution
			Height</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="projectorHeight"
				id="projectorHeight" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="projectorWidth">Resolution
			Width</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="projectorWidth"
				id="projectorWidth" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="projectorRoomNumber">Room
			Number</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="projectorRoomNumber"
				id="projectorRoomNumber" />
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
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label> <input type="checkbox" id="hdmiin" value="HDMI" />HDMI
					In
				</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label> <input type="checkbox" id="dviin" value="DVI" />DVI
					In
				</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label> <input type="checkbox" id="vgain" value="VGA" />VGA
					In
				</label>
			</div>
		</div>
	</div>
	<div class="form-group">
		<br>
		<button type="submit" class="btn btn-primary btn-block form-button">Save</button>
	</div>
</form>

<script>
	$('#editProjector')
			.validate(
					{
						rules : {
							name : {
								required : true
							},
							description : {
								required : true
							},
							projectorWidth : {
								required : true
							},
							projectorHeight : {
								required : true
							},
							projectorRoomNumber : {
								required : true
							}
						},
						messages : {
							name : "Name field cannot be blank.",
							description : "Description field cannot be blank.",
							projectorWidth : "Please enter a resolution width for the projector.",
							projectorHeight : "Please enter a resolution height for the projector.",
							projectorRoomNumber : "Please enter a room number for the projector."
						},
						highlight : function(element) {
							$(element).closest('.form-group').addClass(
									'has-error');
						},
						unhighlight : function() {
							$(element).closest('.form-group').removeClass(
									'has-error');
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
