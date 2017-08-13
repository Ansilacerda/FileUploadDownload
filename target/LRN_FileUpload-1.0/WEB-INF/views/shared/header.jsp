<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload</title>
        <link href="${SITE_URL}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="${SITE_URL}/static/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <link href="${SITE_URL}/static/css/header.css" rel="stylesheet" type="text/css"/>
        <script src="${SITE_URL}/static/js/jquery.min.js" type="text/javascript"></script>
        <script src="${SITE_URL}/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container" align="center">
            <a href="${SITE_URL}">Home</a> | <a href="${SITE_URL}/viewall">View all files</a>