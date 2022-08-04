<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/4/2022
  Time: 8:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Conversion</title>
</head>
<body>
<div>
    <table style="margin: auto">
        <form action="/CurrencyConversionController" method="post">
            <tr>
                <th colspan="2">
                    <h1 style="color: white">CONVERT MONEY </h1>
                </th>
            </tr>
            <tr>
                <th><input type="text" placeholder="Input your money" name="amountMoney"
                           value="${oldValue}"></th>
                <th><input type="text" readonly placeholder="Result" value="${newValue}"></th>
            </tr>
            <tr>
                <th colspan="2">
                    <button type="submit">
                        CALCULATOR
                    </button>
                </th>
            </tr>
        </form>
    </table>
</div>
</body>
</html>