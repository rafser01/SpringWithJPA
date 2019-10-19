<%-- 
    Document   : index
    Created on : Oct 16, 2019, 5:34:41 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="static/styles/bootstrap.css" var="bootstrap"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="${bootstrap}" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" /></title>
    </head>
    <body class="container">
    <spring:message code="lbl.id"  text="Em" />
    <h4>Success</h4>
     <tiles:insertAttribute name="body"/>
    </body>
</html>

 
 
 