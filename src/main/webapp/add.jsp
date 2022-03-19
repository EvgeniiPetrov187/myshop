<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="styles.css" type="text/css"/>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="styles.css" type="text/css"/>
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
            <select name="category">
                <%
                    List<String> categories = (List<String>) request.getAttribute("categories");
                    if (categories != null && !categories.isEmpty()) {
                        out.println("<option></option>");
                        for (String category : categories) {
                            out.println("<option>" + category + "</option>");
                        }
                    } else {
                        out.println("<p>There is nothing yet!</p>");
                    }
                %>
            </select>
        </label>
        <button type="submit">Agree</button>
    </form>
</div>
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
