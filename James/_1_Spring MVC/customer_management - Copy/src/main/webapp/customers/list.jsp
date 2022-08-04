<%@ page import="cg.wbd.grandemonstration.service.CustomerService" %>
<%@ page import="cg.wbd.grandemonstration.service.CustomerServiceFactory" %>
<%@ page import="cg.wbd.grandemonstration.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
    private CustomerService customerService = CustomerServiceFactory.getInstance();
%>
<%
    long count = customerService.count();
    List<Customer> customers = customerService.findAll();
%>
<%--<style>--%>
<%--    table {--%>
<%--        border: 1px solid #000;--%>
<%--    }--%>

<%--    th, td {--%>
<%--        border: 1px dotted #555;--%>
<%--    }--%>
<%--</style>--%>
<%--&lt;%&ndash;There are <%= count %> customer(s) in list.&ndash;%&gt;--%>

<%--<%--%>
<%--    List<Customer> customers = (List<Customer>) request.getAttribute("customers");--%>
<%--%>--%>
<%--&lt;%&ndash;There are <%= customers.size() %> customer(s) in list.&ndash;%&gt;--%>
<%--There are ${requestScope.customers.size()} customer(s) in list.--%>
<%--<table>--%>
<%--    <caption>Customers List</caption>--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>Id</th>--%>
<%--        <th>Name</th>--%>
<%--        <th>Email</th>--%>
<%--        <th>Address</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <c:forEach var="c" items="${requestScope.customers}">--%>
<%--&lt;%&ndash;    <% for (Customer c : customers) { %>&ndash;%&gt;--%>
<%--    <tr>--%>
<%--&lt;%&ndash;        <td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <%= c.getId() %>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <a href="info.jsp?id=<%= c.getId() %>"><%= c.getName() %></a>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <%= c.getEmail() %>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </td>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <td>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <%= c.getAddress() %>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </td>&ndash;%&gt;--%>
<%--    <td>--%>
<%--        <c:out value="${c.id}"/>--%>
<%--    </td>--%>
<%--    <td>--%>
<%--        <a href="info.jsp?id=${c.id}">${c.name}</a>--%>
<%--    </td>--%>
<%--    <td>--%>
<%--        <c:out value="${c.email}"/>--%>
<%--    </td>--%>
<%--    <td>--%>
<%--        <c:out value="${c.address}"/>--%>
<%--    </td>--%>

<%--    </tr>--%>
<%--&lt;%&ndash;    <% } %>&ndash;%&gt;--%>
<%--    </c:forEach>--%>
<%--    </tbody>--%>
<%--</table>--%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<style>
    table {
        border: 1px solid #000;
    }

    th, td {
        border: 1px dotted #555;
    }
</style>
There are ${requestScope.customers.size()} customer(s) in list.
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="c" items="${requestScope.customers}">
        <tr>
            <td>
                <c:out value="${c.id}"/>
            </td>
            <td>
                <a href="/customers/info.jsp?id=${c.id}">${c.name}</a>
            </td>
            <td>
                <c:out value="${c.email}"/>
            </td>
            <td>
                <c:out value="${c.address}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>