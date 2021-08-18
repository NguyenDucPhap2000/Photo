<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/Home.css" rel="stylesheet" type="text/css"/>
        <title>Home Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="content">
                    <div class="left">
                        <div class="imgandsubtitle">
                            <div class="imghome">
                                <img src="${image}/${imageHome}" alt=""/>
                            </div>
                            <div class="imgsubtitle">
                                ${imagetitle}
                            </div>
                        </div>
                        <div class="categrory">
                            <h1>${error}</h1>
                            <div class="categroryimg">
                                <c:forEach begin="0" end="2" items="${gallery}" var="c">
                                    <div class="img">
                                        <img src="${image}/${c.imagePath}" alt=""/>
                                        <div>
                                            <a href="GalleryControl?id=${c.id}&index=1">${c.title}</a>
                                            <p>
                                                ${c.desc}
                                            </p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="paging">
                                <c:forEach begin="1" end="${endpage}" var="c">
                                    <a class="${index == c?"active":""}" href="HomeControl?index=${c}">${c}</a>
                                </c:forEach>
                            </div>
                            <div class="moreinfor">
                                <div class="aboutme">
                                    <h3>About me</h3>
                                </div>
                                <div class="shortinfor">
                                    <span> 
                                        ${about}
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <jsp:include page="Right.jsp"/>
                </div>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
