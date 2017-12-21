<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<jsp:include page="userHeader.jsp"/>
Top 20 produktów
<table>
<c:forEach items="${topProducts}" var="product" varStatus="productStatus">
    <tr>

        <td>
            <c:out value="${productStatus.index}"/>
        </td>
        <td>
            <c:out value="${product.name}"/>
        </td>
        <td>
            <c:out value="${product.price}"/>
        </td>
        <td>
            <c:url value="addToBasket" var="basketUrl">
                <c:param name ="productId" value="${product.id}"/>
            </c:url>
            <a href="<c:out value="${basketUrl}"/>">Dodaj do koszyka</a>
        </td>
    </tr>

</c:forEach>

</table>
</body>
</html>
