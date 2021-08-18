<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Css/Contact.css" rel="stylesheet" type="text/css"/>
        <title>Contact Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="content">
                    <div class="left">
                        <div class="heading">
                            <h1>Contact</h1>
                        </div>
                        <div class="information">
                            <h2>PHOTOGRAPHER</h2>
                            <P>
                                Address: ${address}
                                <br>
                                City: ${city}
                                <br>
                                Country: ${country}
                            </P>
                        </div>
                        <div class="phone">
                            Tel:
                            <a href="tel:${phone}">${phone}</a>
                        </div>
                        <div class="Email">
                            Email:
                            <a href="mailto:${email}">${email}</a>
                        </div>
                        <div class="map">
                            ${map}
                        </div>
                    </div>
                    <jsp:include page="Right.jsp"/>
                </div>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
