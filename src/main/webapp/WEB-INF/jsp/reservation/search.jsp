<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <div class="container-fluid">
    <font color="green">${msg}</font>
    <div class="row">
        <div class="main">
          <h2>Search</h2>
          <form action="<c:url value="/resourceSearch"/>" method="post">
            <div class="form-group">
              <label for="resourceID">Search Resource by ID</label>
              <input type="text" class="form-control" id="resourceID" name="resourceID" placeholder="resourceID">
            </div>
            <!--
            <div class="form-group">
              <label for="location">Location</label>
              <input type="text" class="form-control" id="location" placeholder="Location">
            </div>
            -->
            <!-- Add more attributes to search by -->
            <div class="form-group" style="width: 150px; margin: auto;">
              <button type="submit" class="btn btn-primary btn btn-block">Search</button>
            </div>
          </form>
          <br>
          <form class="form-group" style="width: 150px; margin: auto;" action="<c:url value="/reservePrepare"/>" method="post">
            <button type="submit" class="btn btn-primary btn btn-block">View All Resource</button>
          </form>
        </div>
      </div>
    <div>
      <c:if test="${not empty resourceList}">
        <jsp:include page="${resultPage}"/>
      </c:if>
    </div>

  </div> <!-- /container -->