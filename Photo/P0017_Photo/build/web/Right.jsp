<%-- 
    Document   : Right
    Created on : Jun 14, 2021, 9:30:37 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/Right.css" rel="stylesheet" type="text/css"/>
        <title>Right Page</title>
    </head>
    <body>
        <div class="right">
            <div class="rightimg">
                <div class="Share">
                    Share this page
                </div>
                <div class="facebook">
                    <img src="images/face.png" alt=""/>
                    <a href="${facebook}">Share on Facebook</a>
                </div>
                <div class="twitter">
                    <img src="images/twitter.png" alt=""/>
                    <a href="${twitter}">Share on Twitter</a>
                </div>
                <div class="google">
                    <img src="images/google.png" alt=""/>
                    <a href="${google}">Share on Google+</a>
                </div>
            </div>
        </div>
    </body>
</html>
