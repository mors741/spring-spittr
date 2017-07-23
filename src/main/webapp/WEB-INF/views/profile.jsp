<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>"/>
</head>
<body>
<h1>Your profile</h1>
<c:out value="${spitter.username}" /> <br>
<c:out value="${spitter.firstName}" />
<c:out value="${spitter.lastName}" />
</body>
</html>
