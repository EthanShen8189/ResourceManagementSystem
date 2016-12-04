<h3>Add Projector</h3>
<form id="projectorForm" class="form-horizontal" method="post" action="<c:url value='/projForm'/>">
	<div class="form-group">
		<label class="control-label col-sm-2" for="projectorHeight"> Resolution
			Height:</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="projectorHeight" id="projectorHeight" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="projectorWidth"> Resolution
			Width:</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="projectorWidth" id="projectorWidth" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="projectorRoomNumber"> Room Number:</label>
		<div class="col-sm-10">
			<input class="form-control" type="number" name="projectorRoomNumber" id="projectorRoomNumber" />
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
		<div class="col-sm-offset-2 col-sm-10">
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</div>
</form>

<script>
	$('#projectorForm').validate({
		rules : {
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
			projectorWidth : "Please enter a resolution width for the projector.",
			projectorHeight : "Please enter a resolution height for the projector.",
			projectorRoomNumber: "Please enter a room number for the projector."
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
