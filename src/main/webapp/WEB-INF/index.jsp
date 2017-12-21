<%@ page import="java.time.LocalDateTime" %>
<html>
<body>
<h2>Hello World!</h2>

<%
    Integer days = Integer.valueOf(request.getParameter("days"));
    LocalDateTime dt = LocalDateTime.now();


    for(int i=1; i<=days; i++){
    LocalDateTime after = dt.plusDays(i);


%>
Date after <%=i%> days: <%=after.toString()%><br/>

</body>
</html>
