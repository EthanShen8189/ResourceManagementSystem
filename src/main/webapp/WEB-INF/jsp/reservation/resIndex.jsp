<%--
  Created by IntelliJ IDEA.
  User: EthanShen
  Date: 2016-12-03
  Time: 12:05 PM
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
                        <li class=${homeTabActive}><a href="${pageContext.request.contextPath}/homeTab">Home</a></li> <!-- inventoryIndex.jsp -->
                        <li class=${manageInventoryTabActive}><a href="${pageContext.request.contextPath}/manageInventoryTab">Manage Inventory</a></li> <!-- manageInventory.jsp -->
                        <li class=${accountSettingsTabActive}><a href="${pageContext.request.contextPath}/accountSettingsTab">Account Settings</a></li> <!-- accountSettings.jsp -->
                        <li class=${addInventoryTabActive}><a href="${pageContext.request.contextPath}/addInventoryTab">Add Inventory</a></li> <!-- addInventory.jsp -->
                        <li class=${editItemTabActive}><a href="${pageContext.request.contextPath}/editItemTab">Edit Item</a></li> <!-- editItem.jsp -->
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
        <div>
            <c:if test="${not empty selectedTab}">
                <jsp:include page="${selectedTab}"/>
            </c:if>
        </div>
        <p><font color="red">${errorMsg}</font></p>
    </div>
</div>

<%@ include file="../../includes/footer.jsp"%>
