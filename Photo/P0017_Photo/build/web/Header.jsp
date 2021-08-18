<%-- 
    Document   : Header
    Created on : Jun 14, 2021, 9:19:04 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/Header.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="header">
            <div class="menu">
                <div class="menutop5">
                    <div class="menutitle">
                        <a href="HomeControl">My front page</a>
                    </div>
                    <c:forEach items="${listgallery}" var="i">
                        <a href="GalleryControl?id=${i.id}&name=${i.name}&index=1">${i.name}</a>
                    </c:forEach>
                    <a href="ContactControl">Contact</a>
                </div>
            </div>
            <div class="photographer">
                <div class="headercover">
                    <div>
                        <div class="headerimg"></div> 
                    </div>
                    <div class="headerinfor">
                        <div class="tittle">
                            <a href="#">PHOTOGRAPHER</a>
                        </div>
                        <div class="headersubtitile">Welcome to this website</div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
