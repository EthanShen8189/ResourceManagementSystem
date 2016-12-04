<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="editComputer" action="<c:url value="/editItem"/>"
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
		<label class="control-label col-sm-2" for="machineType">Machine
			Type</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="machineType"
				id="machineType" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="hostName">Host Name</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="hostName" id="hostName" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="operatingSystem">Operating
			System</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="operatingSystem"
				id="operatingSystem" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="manufacturer">Manufacturer</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="manufacturer"
				id="manufacturer" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="model">Model</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="model" id="model" />
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
				<label><input type="checkbox" id="wirelessnetworking"
					value="Wireless" />Wireless Networking</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" id="wirednetworking"
					value="Wired" />Wired Networking</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" id="speakersincluded"
					value="Speakers" />Speakers Included</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" id="keyboardincluded"
					value="Keyboard" />Keyboard Included</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" id="mouseincluded"
					value="Mouse" />Mouse Included</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" id="hdmiout" value="HDMI" />HDMI
					Out</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" id="dviout" value="DVI" />DVI
					Out</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" id="vgaout" value="VGA" />VGA
					Out</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<br>
		<button type="submit" class="btn btn-primary btn-block form-button">Save</button>
	</div>
</form>

<script>
	$('#editComputer')
			.validate(
					{
						rules : {
							name : {
								required : true
							},
							description : {
								required : true
							},
							machineType : {
								required : true
							},
							hostName : {
								required : true
							},
							operatingSystem : {
								required : true
							},
							manufacturer : {
								required : true
							},
							model : {
								required : true
							}
						},
						messages : {
							name : "Name field cannot be blank.",
							description : "Description field cannot be blank.",
							machineType : "Please enter a type for computer.",
							hostName : "Please enter a host name for the computer.",
							operatingSystem : "Please enter an operating system for the computer.",
							manufacturer : "Please enter a manufacturer for the computer.",
							model : "Please enter a model for the computer."
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
