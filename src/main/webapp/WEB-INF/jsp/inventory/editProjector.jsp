<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty projector}">
	<c:forEach items="${projector}" var="projector">
<form id="editProjector" action="<c:url value="/updateProjector"/>"
	class="editForm form-horizontal" method="post">
	<input type="hidden" name="projectorID" value="${projector.id}">
	<input type="hidden" name="resourceID" value="${resourceId}">
	<div class="form-group">
		<label for="itemName" class="col-sm-2 control-label">Name</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="itemName" name="name"
				placeholder="Enter a Name"
				value="Projector" disabled>
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="projectorHeight">Resolution Height</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="projectorHeight"
				id="projectorHeight" value="${projector.height}" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="projectorWidth">Resolution Width</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="projectorWidth"
				   id="projectorWidth" value="${projector.width}" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" id="moveable" name="projectorMovable" <c:if test="${movableCheck == true}">checked="checked"</c:if>/>Moveable</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label> <input type="checkbox" id="hdmiin" name="hdmiin" <c:if test="${projector.hdmi_input == true}">checked="checked"</c:if> />HDMI In
				</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label> <input type="checkbox" id="dviin" name="dviin" <c:if test="${projector.dvi_input == true}">checked="checked"</c:if> />DVI In
				</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label> <input type="checkbox" id="vgain" name="vgain" <c:if test="${projector.vga_input == true}">checked="checked"</c:if>/>VGA In
				</label>
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
