<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Theme Manager Home</title>
</head>
<body>
<div align="center">
    <h1>Theme List</h1>
    <h3><a href="/newTheme">New Theme</a></h3>
    <table border="1">
        <th>Id</th>
        <th>Name</th>

        <c:forEach var="theme" items="${listTheme}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${theme.themeId}</td>
                <td>${theme.themeName}</td>
                <td>
                    <a href="/editTheme?themeId=${theme.themeId}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/deleteTheme?themeId=${theme.themeId}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>