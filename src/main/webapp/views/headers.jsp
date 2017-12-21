<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<c:forEach items="${dupa}" var ="hdr">
    <c:out value="${hdr.key}"/>:<c:out value="${hdr.value}"/> </br>
</c:forEach>

</body>
</html>