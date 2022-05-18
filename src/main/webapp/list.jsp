<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="styles.css" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="main-container">
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
    <br>
    <div>
        <form method="post">
            <button>Send message</button>
        </form>
    </div>
</div>
<div class="messages">
        <%
            List<String> messagesFirst = (List<String>) request.getAttribute("messages-first");
            if (messagesFirst != null && !messagesFirst.isEmpty()) {
                for (String message : messagesFirst) {
                    out.println("<h2>" + message + "</h2>");
                }
            }
        %>
        <%
            List<String> messagesSecond = (List<String>) request.getAttribute("messages-second");
            if (messagesSecond != null && !messagesSecond.isEmpty()) {
                for (String message : messagesSecond) {
                    out.println("<h2>" + message + "</h2>");
                }
            }
        %>
</div>
</body>
</html>
