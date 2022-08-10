<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
    <style>
        #main {
            background-image: linear-gradient(to right, #00a3ff, #90ceb7);
            border-radius: 10px;
            margin: auto;
            margin-top: 100px;
            width: 90%;
            font-family: Arial, serif;
            padding: 10px;
        }
    </style>
</head>
<body>
<div id="main">
    <form:form modelAttribute="medicalForm" action="/create" method="post">
        <h1 style="text-align: center">MEDICAL FORM</h1>
        <table width="100%">
            <tr>
                <th colspan="6">
                    <p><b>This is a important, your information will help health authorities contact to infectious
                        disease prevention</b></p>
                </th>
            </tr>
            <tr>
                <th colspan="6">
                    <p style="color: red"><b>Caution: Your will be in jail if the information is wrong</b></p>
                </th>
            </tr>
            <tr>
                <td colspan="6">
                    Your Name
                    <form:input cssStyle="width: 100%" path="name"></form:input>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    Year of Birthday
                    <form:select cssStyle="width: 100%" colspan="2" path="birthYear" items="${listYear}">
                        <form:option value="${listYear}">value="${listYear}</form:option>
                    </form:select>
                </td>
                <td colspan="2">
                    Gender
                    <form:select cssStyle="width: 100%" colspan="2" path="gender" items="${listGender}">
                        <form:option value="${listYear}">value="${listYear}</form:option>
                    </form:select>
                </td>
                <td colspan="2">
                    Country
                    <form:select cssStyle="width: 100%" colspan="2" path="country" items="${listCountry}">
                        <form:option value="${listYear}">value="${listYear}</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="6">
                    Your ID Card Number
                    <form:input cssStyle="width: 100%" path="idCardNumber"></form:input>
                </td>
            </tr>
            <tr>
                <td colspan="6">
                    Choose your vehicle:
                    <form:radiobuttons items="${listVehicle}" path="verhice" required="required"/>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    Vehicle Number
                    <form:input cssStyle="width: 100%" path="verhiceNumber"></form:input>
                </td>
                <td colspan="3">
                    Vehicle Slot Number
                    <form:input cssStyle="width: 100%" path="verhiceNumberSlot"></form:input>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    Date Start:
                    <form:input type="date" cssStyle="width: 100%" path="dayStart"></form:input>
                </td>
                <td colspan="3">
                    Date End:
                    <form:input type="date" cssStyle="width: 100%" path="dayEnd"></form:input>
                </td>
            </tr>
            <tr>
                <td colspan="6">
                    City visited:
                    <form:input type="text" cssStyle="width: 100%" path="city"></form:input>
                </td>
            </tr>
            <tr>
                <th colspan="3">
                    <form:button type="submit">SUBMIT</form:button>
                </th>
                <th colspan="3">
                    <a href="/list">SHOW LIST</a>
                </th>
            </tr>

        </table>
    </form:form>
</div>
</body>
</html>