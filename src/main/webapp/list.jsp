<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="styles.css" type="text/css"/>
<head>
    <title>Title</title>
</head>
<body>
<div class="mainContainer">
    <%
        List<String> titles = (List<String>) request.getAttribute("products");
        if (titles != null && !titles.isEmpty()) {
            out.println("<ui>");

            for (String title : titles) {
                out.println("<li>" + title + "</li>");
            }
            out.println("</ui>");
        } else out.println("<p>There is nothing yet!</p>");
    %>
</div>
<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
