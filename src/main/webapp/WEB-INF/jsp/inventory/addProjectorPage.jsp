<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h4>Add Projector</h4>
<form id="projectorForm" class="form-horizontal" method="post" action="<c:url value='/AddProjForm'/>">
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
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label> <input type="checkbox" name="hdmiin" value="HDMI" />HDMI
					In
				</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label> <input type="checkbox" name="dviin" value="DVI" />DVI In
				</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label> <input type="checkbox" name="vgain" value="VGA" />VGA In
				</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<div class="checkbox">
				<label><input type="checkbox"  name="projectorMovable" />Movable</label>
			</div>
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
			<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</div>
</form>