<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/Gallery.css" rel="stylesheet" type="text/css"/>
        <title>Gallery Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="content">
                    <div class="left">
                        <h1>${NotFound}</h1>
                        <div class="slideshow">
                            <h1>${nameGallery}</h1>
                            <div class="mainImage">
                                <img id="bigImg" src="${image}${mainImage}" alt=""/>
                            </div>
                        </div>
                        <div class="imagegallery">
                            <div class="imgrow12">
                                <c:forEach begin="0" end="7" items="${listImg}" var="c">
                                    <div>
                                        <div class="smallimg">
                                            <!--this here is img tag-->
                                            <img id="imgpath" onclick="changeImage(this.src)" src="${image}${c.path}" alt=""/>
                                        </div>
                                        <div class="shadow"></div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="paging">
                            <c:forEach begin="1" end="${endpage}" var="c">
                                <a class="${index == c?"active":""}" href="GalleryControl?index=${c}&id=${gallerId}">${c}</a>
                            </c:forEach>
                        </div>
                    </div>
                    <jsp:include page="Right.jsp"/>
                </div>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
        <script src="js/JSGalery.js" type="text/javascript"></script>
    </body>
</html>
