<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty computer}">
    <c:forEach items="${computer}" var="computer">
        <h4>Edit Computer</h4>
        <form id="editComputer" action="<c:url value="/updateComputer"/>" class="form-horizontal" method="post">
            <input type="hidden" name="computerID" value="${computer.id}">
            <input type="hidden" name="resourceID" value="${resourceId}">
            <div class="form-group">
                <label for="itemName" class="col-sm-2 control-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="itemName" name="name"
                           value="Computer" disabled>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="hostName">Host Name</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="hostName" id="hostName" value="${computer.hostname}" />
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="machineType">Machine Type</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="machineType" id="machineType" value="${computer.machine_type}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="operatingSystem">Operating System</label>
                <div class="col-sm-10">
                        <select class="form-control input-sm" name="operatingSystem" id="operatingSystem">
                            <c:if test="${not empty osList}">
                            <c:forEach items="${osList}" var="os">
                                <option><c:out value="${os.id}. ${os.license} ${os.os_type} ${os.version}"/> </option>
                            </c:forEach>
                            </c:if>
                        </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="manufacturer">Manufacturer</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="manufacturer"
                           id="manufacturer" value="${computer.manufacturer}" />
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="model">Model</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="model" id="model" value="${computer.model}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label><input type="checkbox" name="moveable" <c:if test="${movableCheck == true}">checked="checked"</c:if>/>Movable</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label><input type="checkbox" name="wirelessnetworking"
                                      <c:if test="${computer.wireless_networking == true}">checked="checked"</c:if>/>Wireless Networking</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label><input type="checkbox" name="wirednetworking" <c:if test="${computer.wired_networking == true}">checked="checked"</c:if>/>Wired Networking</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label><input type="checkbox" name="speakersincluded" <c:if test="${computer.speakers == true}">checked="checked"</c:if>/>Speakers Included</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label><input type="checkbox" name="keyboardincluded" <c:if test="${computer.keyboard == true}">checked="checked"</c:if>/>Keyboard Included</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label><input type="checkbox" name="mouseincluded" <c:if test="${computer.mouse == true}">checked="checked"</c:if>/>Mouse Included</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label><input type="checkbox" name="hdmiout" <c:if test="${computer.hdmi_output == true}">checked="checked"</c:if>/>HDMI Out</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label><input type="checkbox" name="dviout" <c:if test="${computer.dvi_output == true}">checked="checked"</c:if>/>DVI Out</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label><input type="checkbox" name="vgaout" <c:if test="${computer.vga_output == true}">checked="checked"</c:if>/>VGA Out</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-block btn-primary">Save</button>
            </div>
        </form>
        <form class="form-horizontal" action="<c:url value="/manageInventory"/>">
            <div class="form-group">
                <button type="submit" class="btn btn-block btn-default">Back</button>
            </div>
        </form>
    </c:forEach>
</c:if>


<script>
    $('#editComputer')
            .validate(
                    {
                        rules : {
                            name : {
                                required : true
                            },
                            description : {
                                required : true
                            },
                            machineType : {
                                required : true
                            },
                            hostName : {
                                required : true
                            },
                            operatingSystem : {
                                required : true
                            },
                            manufacturer : {
                                required : true
                            },
                            model : {
                                required : true
                            }
                        },
                        messages : {
                            name : "Name field cannot be blank.",
                            description : "Description field cannot be blank.",
                            machineType : "Please enter a type for computer.",
                            hostName : "Please enter a host name for the computer.",
                            operatingSystem : "Please enter an operating system for the computer.",
                            manufacturer : "Please enter a manufacturer for the computer.",
                            model : "Please enter a model for the computer."
                        },
                        highlight : function(element) {
                            $(element).closest('.form-group').addClass(
                                    'has-error');
                        },
                        unhighlight : function() {
                            $(element).closest('.form-group').removeClass(
                                    'has-error');
                        },
                        errorElement : 'span',
                        errorClass : 'help-block',
                        errorPlacement : function(error, element) {
                            if (element.parent('.form-group').length) {
                                error.insertAfter(element.parent());
                            } else {
                                error.insertAfter(element);
                            }
                        }
                    });
</script>
