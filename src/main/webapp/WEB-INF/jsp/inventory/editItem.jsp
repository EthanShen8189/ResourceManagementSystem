<!-- 
	editItem.jsp
	Author: Trisha Dimayuga 26922287
	Created on: October 30, 2016
 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container">
	<div class="pageTitle">
		<h2>Edit Item</h2>
	</div>

	<br>

	<c:choose>
		<c:when test="${param.type == 'computer'}">
			<jsp:include page="editComputer.jsp"></jsp:include>
		</c:when>
		<c:when test="${param.type == 'projector'}">
			<jsp:include page="editProjector.jsp"></jsp:include>
		</c:when>
		<c:when test="${param.type == 'whiteboard'}">
			<jsp:include page="editWhiteboard.jsp"></jsp:include>
		</c:when>
		<c:when test="${param.type == 'room'}">
			<jsp:include page="editRoom.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<h4>Item is invalid.</h4>
		</c:otherwise>
	</c:choose>

</div>
