<%--
  Created by IntelliJ IDEA.
  User: EthanShen
  Date: 2016-11-17
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Resource Management</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <spring:url value="/resources/core/js/jquery-3.1.1.min.js" var="jqueryJs" />
    <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
    <spring:url value="/resources/core/font-awesome-4.7.0/css/font-awesome.min.css" var="faCss" />
    <link href="${jqueryJs}" rel="script"/>
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${bootstrapJs}" rel="script"/>
    <link href="${faCss}" rel="stylesheet"/>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand">Resource Management System</a>
        </div>
        <p class="navbar-text navbar-right"><c:if test="${not empty name}">
            Welcome ${name}
            <a class="btn btn-primary btn-xs" href="${pageContext.request.contextPath}/" role="button">Log out</a>
        </c:if>
        </p>
    </div>
</nav>
