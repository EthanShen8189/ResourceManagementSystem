<%@ include file="../includes/header.jsp"%>
<div class="jumbotron">
    <div class="container">
        <h3>Please Login</h3>
        <form class="input-group" action="<c:url value="/home"/>" method="post">
            <div class="input-group form-inline">
                <label for="employeeType">Type</label>
                <select class="form-control input-sm" name="employeeType" id="employeeType">
                    <option>IT Admin</option>
                    <option>Employee</option>
                </select>
            </div>
            <div class="input-group">
                <span class="input-group-addon" id="username-addon">User Name:</span>
                <input class="form-control" type="text" name="username" id="username" aria-describedby="username-addon"/>
            </div>

            <div class="input-group">
                <span class="input-group-addon" id="password-addon">Password: </span>
                <input class="form-control" type="password" name="password" id="password" aria-describedby="password-addon"/>
            </div>

            <div class="input-group">
                <button class="btn btn-primary" type="submit">Login</button>
            </div>

            <p><font color="red">${errorMsg}</font></p>
        </form>
    </div>
</div>

<%@ include file="../includes/footer.jsp"%>
