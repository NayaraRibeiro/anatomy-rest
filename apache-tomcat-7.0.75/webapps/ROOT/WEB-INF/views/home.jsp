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
                <td>${theme.id}</td>
                <td>${theme.name}</td>
                <td>
                    <a href="/editTheme?id=${theme.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/deleteTheme?id=${theme.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>