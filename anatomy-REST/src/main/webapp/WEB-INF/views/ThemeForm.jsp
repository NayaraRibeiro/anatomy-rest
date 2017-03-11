<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit Theme</title>
</head>
<body>
<div align="center">
    <h1>New/Edit Theme</h1>
    <form:form action="saveTheme" method="post" modelAttribute="theme">
        <table>
            <form:hidden path="themeId"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="themeName" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>

