<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h4>Add Computer</h4>
<form id="computerForm" class="form-horizontal" method="post" action="<c:url value="/addCompForm"/>">

	<div class="form-group">
		<label class="control-label col-sm-2" for="machineType">Machine
			Type:</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="machineType" id="machineType" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="hostName">Host
			Name:</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="hostName" id="hostName" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="operatingSystem">Operating
			System:</label>
		<div class="col-sm-10">
			<select class="form-control input-sm" name="operatingSystem" id="operatingSystem">
				<c:if test="${not empty osList}">
					<c:forEach items="${osList}" var="os">
						<option><c:out value="${os.id}. ${os.license} ${os.os_type} ${os.version}"/> </option>
					</c:forEach>
				</c:if>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="manufacturer">Manufacturer:</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="manufacturer" id="manufacturer" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="model">Model:</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="model" id="model" />
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
				<label><input type="checkbox" name="wirelessnetworking"
					value="Wireless" />Wireless Networking</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" name="wirednetworking"
					value="Wired" />Wired Networking</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" name="speakersincluded"
					value="Speakers" />Speakers Included</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" name="keyboardincluded"
					value="Keyboard" />Keyboard Included</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" name="mouseincluded"
					value="Mouse" />Mouse Included</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" name="hdmiout" value="HDMI" />HDMI
					Out</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" name="dviout" value="DVI" />DVI
					Out</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" name="vgaout" value="VGA" />VGA
					Out</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox" name="movable"/>Movable</label>
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
	$('#computerForm').validate({
		rules : {
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
			machineType : "Please enter a type for computer.",
			hostName : "Please enter a host name for the computer.",
			operatingSystem : "Please enter an operating system for the computer.",
			manufacturer : "Please enter a manufacturer for the computer.",
			model : "Please enter a model for the computer."
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
