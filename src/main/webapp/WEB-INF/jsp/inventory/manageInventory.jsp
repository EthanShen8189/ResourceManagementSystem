<!-- 
	managementInventory.jsp
	Author: Sean-Frankel Gaon Canlas 27390467
	Date: October 30, 2016 - 1.0
 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
        <h4>Manage Inventory</h4>
        <div class="form-group form-inline">
            <form class="form-inline" action="<c:url value="/searchInv"/>" method="get">
                    <input id="searchID" name="search" type="number" class="form-control" placeholder="Search Resource ID">
	                	<button type="submit" class="btn btn-primary form-control">
	                    	  <i class="fa fa-search" aria-hidden="true"></i>
	               	 	</button>
            </form>
            <form class="form-inline" action="<c:url value="/searchAllResource"/>" method="get">
                <button type="submit" class="btn btn-default form-control">See All Resource</button>
            </form>
        </div>
</div>

<c:if test="${not empty resourceList}">
    <div class="container">
        <h4>Resource Detail</h4>
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Resource UID</th>
                <th>Description</th>
                <th>Movable</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${resourceList}" var="resource">
            <form action="<c:url value="/editResource"/>" method="post">
                <input type="hidden" name="resourceId" value="${resource.id}">
                <tr>
                    <td><c:out value="${resource.name}"/></td>
                    <td><c:out value="${resource.resourceUID}"/></td>
                    <td><c:out value="${resource.description}"/></td>
                    <td><c:out value="${resource.movable}"/></td>
                    <td><button class="btn btn-default btn-sm" name="editParam" value="${resource.description}/${resource.resourceUID}" type="submit">
                        <i class="fa fa-pencil" aria-hidden="true"></i>Book</button></td>
                </tr>
            </form>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>
<p><font color="red">${errorMsg}</font></p>

<script>
    $('.searchForm').validate({
        rules: {
            search: {
                required: true
            }
        },
        messages: {
            search: "This cannot be blank, you must search for a resource."
        },
        highlight: function() {
            $(".form-div-primary").addClass("has-error");
            $(".search-btn").addClass("btn-danger");
        },
        unhighlight: function() {
            $(".form-div-primary").removeClass("has-error");
            $(".search-btn").removeClass("btn-danger");
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function(error, element) {
            if(element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        }
    });
</script>