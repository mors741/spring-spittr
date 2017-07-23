<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>"/>
</head>
<body>
<div class="spittleMessage">
    <c:out value="${spittle.message}"/>
</div>
<div class="spittleInfo">
    <span class="spittleTime">
        <c:out value="${spittle.time}"/>
    </span>
    <span class="spittleLocation">
        (<c:out value="${spittle.latitude}"/>,
        <c:out value="${spittle.longitude}"/>)
    </span>
</div>
</body>
</html>
