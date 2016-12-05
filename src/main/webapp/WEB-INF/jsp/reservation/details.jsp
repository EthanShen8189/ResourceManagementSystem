<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-fluid">
    <div class="row">
      <!--
      <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar">
          <li>
            <a href="index.html">Catalog</a></li>
            <li class="active"><a href="#">Reservations <span class="sr-only">(current)</span></a></li>
          </ul>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">-->
          <h4 class="page-header">Resource Details</h4>
          <div>
            <table class="table table-striped table-responsive table-bordered">
             <thead>
              <tr>
                <th>Resource ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Movable</th>
                  <th></th>
              </tr>
             </thead>
              <tbody>
              <c:forEach items="${resourceList}" var="resource">
                <form action="<c:url value="/reservePrepare"/>" method="post">
                    <tr>
                    <td><c:out value="${resource.id}"/></td>
                    <td><c:out value="${resource.name}"/></td>
                    <td><c:out value="${resource.description}"/></td>
                    <td><c:out value="${resource.movable}"/></td>
                    <td><button class="btn btn-default" name="resourceParam" value="${resource.id}/${resource.resourceUID}" type="submit">
                      <i class="fa fa-pencil" aria-hidden="true">Reserve</i></button></td>
                  </tr>
                </form>
              </c:forEach>
              </tbody>
            </table>
            </div>
        <c:if test="${resourceUID !=''}">
            <div class="box-group">
              <h2>Reservation</h2>
              <h4>for Resource ID: ${resourceId}, Resource Name: ${resourceName}</h4>
              <form action="<c:url value="/reserveResource"/>" method="post">
                <input type="hidden" name="resourceId" value="${resourceId}">
                <input type="hidden" name="resourceUID" value="${resourceUID}">
                  <input type="hidden" name="username" value="${username}">
                <div>
                  <div class="form-group">
                    <label for="start_date">Date</label>
                    <input class="form-control" id="start_date" type="date" name="start_date">
                  </div>
                  <div class="form-group">
                    <label for="start_time">Start Time</label>
                    <input class="form-control" id="start_time" type="time" name="start_time" min="08:00:00" max="23:00:00">
                  </div>
                    <!--
                  <div class="form-group">
                    <label for="end_date">End Date</label>
                    <input class="form-control" id="end_date" type="date" name="end_date">
                  </div>
                  -->
                  <div class="form-group">
                    <label for="end_time">End Time</label>
                    <input class="form-control" id="end_time" type="time" name="end_time" min="08:00:00" max="23:00:00">
                  </div>
                  <input class="btn btn-primary" type="submit" value="Reserve">
                </div>
              </form>
            </div>
        </c:if>
          </div>
      <!--  </div> -->
        </div> <!-- /container -->