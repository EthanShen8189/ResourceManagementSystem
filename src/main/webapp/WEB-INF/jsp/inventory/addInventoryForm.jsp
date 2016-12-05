<%--
    addInventoryForm.jsp
    Author: Martin Nafekh 27423993
--%>
<style>
    .dropbtn {
        background-color: #4286f4;
        color: white;
        padding: 16px;
        font-size: 14px;
        font-family: Arial, monospace;
        border: none;
        border-radius: 10px;
        cursor: pointer;
        height: 50px;
        width: 130px;
    }
    .dropdown {
        position: relative;
        display: inline-block;
    }
    .dropdown-content {
        display: none;
        position: static;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    }
    .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }
    .dropdown-content a:hover {background-color: #f1f1f1}
    .dropdown:hover .dropdown-content {
        display: block;
    }
    .dropdown:hover .dropbtn {
        background-color: #4286f4;
    }
</style>
<div class="container">
    <div class="dropdown">
        <button class="dropbtn">Add Inventory</button>
        <div class="dropdown-content">
            <a href="${pageContext.request.contextPath}/addComputerPage">Computer</a>
            <a href="${pageContext.request.contextPath}/addWhiteboardPage">Whiteboard</a>
            <a href="${pageContext.request.contextPath}/addRoomPage">Room</a>
            <a href="${pageContext.request.contextPath}/addProjectorPage">Projector</a>
        </div>
    </div>
    <div>
        <font color="#228b22">${insertMsg}</font>
    </div>
    <div>
        <c:if test="${not empty addInventoryPage}">
            <jsp:include page="${addInventoryPage}"/>
        </c:if>
    </div>

</div>

<script>
    $(document).ready(function() {
        $('#resource li').click(function(){
            var form = $(this).attr("id") + "form";
            $("[style]").hide();
            $("#" + form).show();
        });
    });
</script>

