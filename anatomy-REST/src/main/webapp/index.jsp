<%@ page import="db.JdbcConnection" %>
<html>
<body>
<h3 class="message"> <%= JdbcConnection.getMessage() %> </h3>
</body>
</html>