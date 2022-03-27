<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="styles.css" type="text/css"/>
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
    <div>
        <button onclick="location.href='/'">Back to main</button>
    </div>
</div>
</body>
</html>
