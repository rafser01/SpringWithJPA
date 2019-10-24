<%-- 
    Document   : index.jsp
    Created on : Oct 24, 2019, 3:44:25 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/static/styles/bootstrap.css" var="bootstrap"/>
<spring:url value="/static/styles/styles.css" var="styles"/>
<spring:url value="/static/js/bootstrap.js" var="bootstrapjs"/>
<spring:url value="/static/js/jquery.js" var="jquery"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="${bootstrap}" rel="stylesheet">
        <link href="${styles}" rel="stylesheet">
        <script src="${jquery}"></script>
        <script src="${bootstrapjs}"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" /></title>
    </head>
    <body>
        <div class="container">    
            <!-- dashboard/admin page -->
            <header id="header"></header>
            <section id="content">
                <div  id="menu"></div>
                <div class="row" id="main-content">
                    <div class="col-xl-12">
                         <tiles:insertAttribute name="body" />
                    </div>
                    
                </div>
            </section>
            <footer class="footer">
                <tiles:insertAttribute name="footer" />
            </footer >
        </div>
    </body>
</html>
