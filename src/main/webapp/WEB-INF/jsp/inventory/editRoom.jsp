<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty room}">
	<c:forEach items="${room}" var="room">
<form id="editRoom" action="<c:url value="/updateRoom"/>"
	class="editForm form-horizontal" method="post">
		<input type="hidden" name="roomID" value="${room.id}">
		<input type="hidden" name="resourceID" value="${resourceId}">
	<div class="form-group">
		<label for="itemName" class="col-sm-2 control-label">Name</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="itemName" name="name"
				placeholder="Enter a Name"
				value="Room" disabled>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2" for="roomNumber"> Room
			Number</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="roomNumber"
				id="roomNumber"  value="${room.room_number}"/>
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