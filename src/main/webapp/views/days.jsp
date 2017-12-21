<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<form method="get">
    Select days: <input type="number" value="<c:out value="${param.days}"/>" name="days"><br/>
    <input type="submit" value="Show">
</form>

<br/>
<c:choose>
    <c:when test="${dupa == null}">
        List is empty
    </c:when>
    <c:otherwise>
        <c:forEach items="${dupa}" var="day">
            Date after: <c:out value="${day.daysAfter}"/> days: <c:out value="${day.after}"/><br/>
        </c:forEach>
    </c:otherwise>
</c:choose>

</body>
</html>
