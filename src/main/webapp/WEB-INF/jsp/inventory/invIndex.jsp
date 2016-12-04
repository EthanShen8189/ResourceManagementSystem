<%--
  Created by IntelliJ IDEA.
  User: EthanShen
  Date: 2016-12-03
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../../includes/header.jsp"%>
<div class="jumbotron">
    <div class="container">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <span class="navbar-brand">Select Action:</span>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class=${manageInventoryTabActive}><a href="${pageContext.request.contextPath}/manageInventory">Manage Inventory</a></li>
                        <li class=${addInventoryTabActive}><a href="${pageContext.request.contextPath}/addInventory">Add Inventory</a></li>
                        <li class=${accountSettingsTabActive}><a href="${pageContext.request.contextPath}/accountSetting">Account Settings</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div>
            <c:if test="${not empty selectedTab}">
                <jsp:include page="${selectedTab}"/>
            </c:if>
        </div>
    </div>
</div>

<%@ include file="../../includes/footer.jsp"%>