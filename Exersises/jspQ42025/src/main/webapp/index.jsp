<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Calculator</title>
</head>
<body>
<h1><%= "Welcome to JSP Calculator!" %>
</h1>
<br/>
<form method="POST" action="/add">
    <input type="text" name="a">
    +
    <input type="text" name="b">
    <input type="submit" value="Add"/>
</form>
<form method="POST" action="/subtract">
    <input type="text" name="a">
    -
    <input type="text" name="b">
    <input type="submit" value="Subtract"/>
</form>
<form method="POST" action="/multiply">
    <input type="text" name="a">
    *
    <input type="text" name="b">
    <input type="submit" value="Multiply"/>
</form>
<form method="POST" action="/divide">
    <input type="text" name="a">
    /
    <input type="text" name="b">
    <input type="submit" value="Divide"/>
</form>
</body>
</html>