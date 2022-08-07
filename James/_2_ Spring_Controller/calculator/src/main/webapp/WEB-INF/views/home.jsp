<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/home" method="post">
    <input type="number" id="firstInput" name="firstInput" placeholder="First Input" value="${firstInput}">
    <input type="number" id="secondInput" name="secondInput" placeholder="Second Input" value="${secondInput}">
    <br>
    <select name="calculation">
        <option value="Add">Addition(+)</option>
        <option value="Sub">Subtraction(-)</option>
        <option value="Mul">Multiplication(*)</option>
        <option value="Div">Division(/)</option>
    </select>

<%--    <button type="button" value="Add">Addition(+)</button>--%>
<%--    <button type="button" value="Sub">Subtraction(-)</button>--%>
<%--    <button type="button" value="Mul">Multiplication(*)</button>--%>
<%--    <button type="button" value="Div">Division(/)</button>--%>

    <br>
    <h2>Result Division: <input type="number" value="${result}" placeholder="Result" readonly></h2>
    <button type="submit">RESULT</button>
</form>
</body>
</html>
