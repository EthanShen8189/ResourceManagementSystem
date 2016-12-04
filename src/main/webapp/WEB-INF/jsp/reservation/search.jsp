<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <div class="container-fluid">
    <div class="row">
        <div class="main">
          <h2>Search</h2>
          <form action="<c:url value="/resourceSearch"/>" method="get">
            <div class="form-group">
              <label for="resource_type">Resource Type</label>
                <select class="form-control" id="resource_type" name="resourceType">
                  <option>Computer</option>
                  <option>Room</option>
                  <option>Projector</option>
                  <option>Whiteboard</option>
                </select>
            </div>
            <div class="form-group">
              <label for="location">Location</label>
              <input type="text" class="form-control" id="location" placeholder="Location">
            </div>
            <!-- Add more attributes to search by -->
            <div class="form-group" style="width: 150px; margin: auto;">
              <button type="submit" class="btn btn-primary btn btn-block">Search</button>
            </div>
          </form>
        </div>
      </div>
      </div> <!-- /container -->