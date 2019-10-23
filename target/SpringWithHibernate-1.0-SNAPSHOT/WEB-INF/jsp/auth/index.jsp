<%-- 
    Document   : index
    Created on : Oct 19, 2019, 4:07:17 PM
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
        
        <style>
            .footer {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            background-color: red;
            color: white;
            text-align: center;
         }
        </style>
    </head>
    <body>
        <div class="container">    
            <!-- login or signup page -->
            <header id="header"></header>
            <section id="content">
                <div  id="menu"></div>
                <div id="main-content">
                    <tiles:insertAttribute name="body" />
                </div>
            </section>
            <footer class="footer">
                <tiles:insertAttribute name="footer" />
            </footer >
        </div>
    </body>
</html>
