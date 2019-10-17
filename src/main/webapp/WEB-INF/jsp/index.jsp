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
        <title>JSP Page</title>
    </head>
    <body class="container">
    <spring:message code="lbl.id"  text="Em" />
        <h1 >Hello World---------!${count}</h1>
    <button type="button" class="btn btn-primary">Basic</button>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="content" />
    <div style="background-color: red">
        <tiles:insertAttribute name="body"/>
    </div>
    
    </body>
</html>
