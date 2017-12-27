<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<jsp:include page="../userHeader.jsp"/>

<jsp:include page="userMenu.jsp"/>

Moje zamówienia

<table>
    TODO : praca domowa Lista zamówień użytkownika:
    NA TEJ STRONIE:
    1.Dane użytkownika można pobrać z sesji
    2.Na dole URL do szczegółów (strona orderDetails)

    STRONA ORDER DETAILS:
    Wyswietli widok z produktami w zamówieniu ORAZ wyświetli sumaryczną wartość zamówienia

    STRONA basket (koszyk) która wyświetli wszystkie obiekty w koszyku (jest w sesji, patrz AnonymousUserController)

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
                    <c:param name="productId" value="${product.id}"/>
                </c:url>
                <a href="<c:out value="${basketUrl}"/>">Do Koszyka</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
