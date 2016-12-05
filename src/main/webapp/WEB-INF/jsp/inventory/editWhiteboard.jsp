<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty whiteboard}">
	<c:forEach items="${whiteboard}" var="whiteboard">
<form id="editWhiteboard" action="<c:url value="/updatewhiteboard"/>"
	class="editForm form-horizontal" method="post">
	<input type="hidden" name="whiteBoardID" value="${whiteboard.id}">
	<input type="hidden" name="resourceID" value="${resourceId}">
	<div class="form-group">
		<label for="itemName" class="col-sm-2 control-label">Name</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="itemName" name="name"
				placeholder="Enter a Name"
				value="White Board" disabled>
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="boardWidth">Width</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="boardWidth"
				id="boardWidth" value="${whiteboard.width}" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="boardHeight">Height</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="boardHeight"
				id="boardHeight"  value="${whiteboard.height}"/>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" id="moveable" value="moveable"  name="movable" <c:if test="${movableCheck == true}">checked="checked"</c:if>/>Movable</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<br>
		<button type="submit" class="btn btn-primary btn-block form-button">Save</button>
	</div>
</form>

		<form class="form-horizontal" action="<c:url value="/manageInventory"/>">
			<div class="form-group">
				<button type="submit" class="btn btn-block btn-default">Back</button>
			</div>
		</form>
	</c:forEach>
</c:if>

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