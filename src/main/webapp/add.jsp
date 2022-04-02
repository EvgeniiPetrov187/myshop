<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="styles.css" type="text/css"/>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="styles.css" type="text/css"/>
</head>
<body>



<div class="main-container">
    <%
        if (request.getAttribute("title") != null) {
            out.println("<p>Product '" + request.getAttribute("title") + "' added!</p>");
        }
    %>
    <form method="post">
        <div id="popup" class="pop-up-window">
            <h2>Вы уверены, сто хотите сохранить?</h2>
            <span class="close">&times;</span>
            <button type="submit" class="close">Ок</button>
            <button type="reset" onclick="closePopUp()">Отмена</button>
        </div>
        <label>
            Name:
            <input type="text" name="title"><br/>
            Category:
            <select name="category">
                <option></option>
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
    </form>
    <button id="pop-button">Agree</button>
    <button onclick="location.href='/'">Back to main</button>
</div>
<div>

</div>
</body>

<script>
    function www() {
        let container = document.getElementById('main');
        container.style.width = '55px'
        alert("HELP");
    }


    let popup = document.getElementById('popup');
    let popButton = document.getElementById('pop-button');
    let popupClose = document.querySelector('.close');

    popButton.onclick = function () {
        popup.style.display = "block";
    };
    popupClose.onclick = function () {
        popup.style.display = "none"
    };

    function closePopUp() {
        popup.style.display = "none";
    }
</script>

</html>
