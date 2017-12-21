<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>


<c:choose>
<c:when test="${not empty sessionScope.user}">
  Witaj  <c:out value="${sessionScope.user.name}" escapeXml="true"/>
</c:when>
    <c:otherwise>
        <a href="login">Zaloguj się</a>
    </c:otherwise>


</c:choose>
</br>




