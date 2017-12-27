<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>

<html>
<body>
<c:choose>
    <c:when test="${error eq 'INCORRECT_CREDENTIALS'}">
        <span style="color: red">Niepoprawny user/hasło</span>
    </c:when>
    <c:otherwise>
        Zaloguj się !!!
    </c:otherwise>
</c:choose>


<br/>
<br/>
<form method="post">
    Email: <input type="text" name="email"/><br/>
    Password:&nbsp; <input type="password" name="password"/><br/>
    <input type="submit" value="Login"></br>
    Ciekawostka: &lt;&gt;
</form>


</body>
</html>
