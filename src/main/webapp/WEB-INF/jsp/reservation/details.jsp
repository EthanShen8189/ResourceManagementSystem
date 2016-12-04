  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-3 col-md-2 sidebar">
        <ul class="nav nav-sidebar">
          <li>
            <a href="index.html">Catalog</a></li>
            <li class="active"><a href="#">Reservations <span class="sr-only">(current)</span></a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Resource Details</h1>
          <div>
            <table class="table table-striped table-responsive table-bordered">
              <tr>
                <td>ID</td>
                <td>1000</td>
              </tr>
              <tr>
                <td>Attribute</td>
                <td>Value</td>
              </tr>
              <tr>
                <td>Attribute</td>
                <td>Value</td>
              </tr>
              <tr>
                <td>Attribute</td>
                <td>Value</td>
              </tr>
              <tr>
                <td>Attribute</td>
                <td>Value</td>
              </tr>
            </table>
            <div class="box-group">
              <h2>Reservation</h2>
              <form action="summary.html">
                <div>
                  <div class="form-group">
                    <label for="start_date">Start Date</label>
                    <input class="form-control" id="start_date" type="date" name="start_date">
                  </div>
                  <div class="form-group">
                    <label for="start_time">Start Time</label>
                    <input class="form-control" id="start_time" type="time" name="start_time">
                  </div>
                  <div class="form-group">
                    <label for="end_date">End Date</label>
                    <input class="form-control" id="end_date" type="date" name="end_date">
                  </div>
                  <div class="form-group">
                    <label for="end_time">End Time</label>
                    <input class="form-control" id="end_time" type="time" name="end_time">
                  </div>
                  <input class="btn btn-primary" type="submit" value="Reserve">
                  <a class="btn btn-default" href="results.html">Cancel</a>
                </div>
              </form></div>
            </div>
          </div>
        </div>
        </div> <!-- /container -->