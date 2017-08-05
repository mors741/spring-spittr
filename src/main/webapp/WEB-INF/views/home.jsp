<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<s:url value="/resources/style.css"/>"/>
</head>
<body>
<h1><s:message code="spittr.message"/></h1>
<a href="<s:url value="/spittles"/>">Spittles</a>
<a href="<s:url value="/spitter/register"/>">Register</a>
</body>
</html>
