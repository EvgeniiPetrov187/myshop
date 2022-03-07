<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="styles.css" type="text/css"/>
<head>
    <title>Title</title>
</head>
<body>
<div class="mainContainer">
    <%
        if (request.getAttribute("title") != null) {
            out.println("<p>Product '" + request.getAttribute("title") + "' added!</p>");
        }
    %>

    <form method="post">
        <label>
            Name:
            <input type="text" name="title"><br/>
            Category:
            <input type="number" name="category"><br/>
        </label>
        <button type="submit">Agree</button>
    </form>
</div>
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
