<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
<title>Simple Example</title>
</head>
<body>

<c:set var="browser" value="${header['User-Agent']}"/>
<c:out value="${browser}"/>

</body>
</html>