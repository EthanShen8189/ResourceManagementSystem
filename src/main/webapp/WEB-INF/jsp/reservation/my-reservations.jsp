<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
    <div class="row">
      <!--
      <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar">
          <li><a href="index.html">Catalog</a></li>
          <li class="active"><a href="search.html">Reservations <span class="sr-only">(current)</span></a></li>
        </ul>
      </div>
      -->
      <div class="main">
        <h2 class="page-header">My Reservations</h2>
        <font color="red">${noFoundMsg}</font>
        <c:if test="${not empty myReservations}">
        <div>
          <table class="table table-striped table-responsive table-bordered">
            <thead>
            <tr>
              <th>Resource ID</th>
              <th>Name</th>
              <th>Description</th>
              <th>Date</th>
              <th>Start Time</th>
              <th>End Time</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${myReservations}" var="myReservation">
                <tr>
                  <td><c:out value="${myReservation.resourceId}"/></td>
                  <td><c:out value="${myReservation.name}"/></td>
                  <td><c:out value="${myReservation.description}"/></td>
                  <td><c:out value="${myReservation.date}"/></td>
                  <td><c:out value="${myReservation.start_time}"/></td>
                  <td><c:out value="${myReservation.end_time}"/></td>
                </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
        </c:if>
      </div>
    </div>
</div> <!-- /container -->