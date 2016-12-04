<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h4>Add Room</h4>
<form id="roomForm" class="form-horizontal" method="post" action="<c:url value='/addRoomform'/>">

	<div class="form-group">
		<label class="control-label col-sm-2" for="roomNumber"> Room
			Number:</label>
		<div class="col-sm-10">
			<input class="form-control" type="text" name="roomNumber"
				id="roomNumber"/>
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-sm-2" for="building">
			Building:</label>
		<div class="col-sm-10">
			<select class="form-control input-sm" name="building" id="building">
				<c:if test="${not empty buildingList}">
					<c:forEach items="${buildingList}" var="building">
						<option><c:out value="${building.id}. ${building.address}"/> </option>
					</c:forEach>
				</c:if>
			</select>
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