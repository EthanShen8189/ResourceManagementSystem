<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h4>Add Whiteboard</h4>
<form id="boardForm" class="form-horizontal" method="post" action="<c:url value='/addBoardform'/>">
	<div class="form-group">
		<label class="control-label col-sm-2" for="boardWidth">Width:</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="boardWidth" id="boardWidth" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="boardHeight">Height:</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="boardHeight" id="boardHeight" />
		</div>
	</div>

	<div class="form-group">
		<label for="description" class="col-sm-2 control-label">Description</label>
		<div class="col-sm-10">
			<textarea class="form-control" name="description" id="description"
					  placeholder="Enter Description" rows="3"></textarea>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" name="movable" />Movable</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</div>
</form>

<script>
	$('#boardForm').validate({
		rules: {
			boardWidth: {
				required: true
			},
			boardHeight: {
				required: true
			},
			boardRoomNumber: {
				required: true
			}
		},
		messages: {
			boardWidth: "Please enter a value for width.",
			boardHeight: "Please enter a value for height.",
			boardRoomNumber: "Please enter a value for room number."
		},
		highlight: function(element) {
			$(element).closest.('.form-group').addClass('has-error');
		},
		unhighlight: function() {
			$(element).closest.('.form-group').removeClass('has-error');
		},
		errorElement: 'span',
		errorClass: 'help-block',
		errorPlacement: function(error, element) {
			if(element.parent('.form-group').length) {
				error.insertAfter(element.parent());
			} else {
				error.insertAfter(element);
			}
		}
	});

</script>
