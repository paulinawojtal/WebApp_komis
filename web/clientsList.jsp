<%@page import="model.Client"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
        <title>Person list</title>
    </head>
    <body>
        <h1>Client list</h1>
        <table class="table_class">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Age</th>
                <th>Region</th>
                <th>Gender</th>
                <th>Action</th>
            </tr>

            <% Object objClients = request.getAttribute("clientsList"); %>
            <% List clients = (List) objClients; %>
            <% for (Object o : clients) { %>
                <% Client c = (Client) o;%>
                <tr>
                    <td><%= c.getId()%></td>
                    <td><%= c.getName()%></td>
                    <td><%= c.getSurname()%></td>
                    <td><%= c.getAge()%></td>
                    <td><%= c.getRegion()%></td>
                    <td><%= c.getGender()%></td>
                    <td>
                        <form action="deleteClientById">
                            <input type="hidden" name="id" value="<%= c.getId()%>">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
                <% }%>
        </table>
        <p><a href="start.jsp">Back to menu</a></p>
    </body>
</html>
