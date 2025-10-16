<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculation</title>
</head>
<body>
<h1>Calculation Complete!</h1>
<p>The answer is: </p>
<h4>
    <%= request.getAttribute("result") != null ? request.getAttribute("result"):
    request.getParameter("result")%>
</h4>
</body>
</html>
