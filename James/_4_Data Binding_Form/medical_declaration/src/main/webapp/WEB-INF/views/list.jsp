<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        #main {
            background-image: linear-gradient(to right, #00a3ff, #90ceb7);
            border-radius: 10px;
            margin: auto;
            width: 100%;
            font-family: Arial, serif;
            padding: 10px;
        }
    </style>
</head>
<body>
<div id="main">
    <table border="1px" style="width: 100%">
        <tr>
            <th>Name</th>
            <th>Birthday year</th>
            <th>Gender</th>
            <th>Country</th>
            <th>Id card number</th>
            <th>Vehicle</th>
            <th>Vehicle number</th>
            <th>Vehicle slot number</th>
            <th>Day start</th>
            <th>Day end</th>
            <th>City visited</th>
        </tr>
        <c:forEach var="temp" items="${medicalFormList}">
            <tr>
                <th>${temp.name}</th>
                <th>${temp.birthYear}</th>
                <th>${temp.gender}</th>
                <th>${temp.country}</th>
                <th>${temp.idCardNumber}</th>
                <th>${temp.verhice}</th>
                <th>${temp.verhiceNumber}</th>
                <th>${temp.verhiceNumberSlot}</th>
                <th>${temp.dayStart}</th>
                <th>${temp.dayEnd}</th>
                <th>${temp.city}</th>
            </tr>
        </c:forEach>
        <tr>
            <th colspan="11">
                <a href="/create">Create New Medical Form</a>
            </th>
        </tr>
    </table>
</div>
</body>
</html>