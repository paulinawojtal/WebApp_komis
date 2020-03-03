<%-- 
    Document   : vehiclesList
    Created on : 2020-02-27, 10:55:46
    Author     : PaulinaMaciej
--%>

<%@page import="model.Vehicle"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles.css"
    </head>
    <body>
        <h1>Vehicle list</h1>
        <table class="table_class">
            <tr>
                <th>ID</th>
                <th>Brand</th>
                <th>Type</th>
                <th>Year</th>
                <th>Mileage</th>
                <th>Registration Number</th>
                <th>vinNumber</th>
                <th>registation Date</th>
            </tr>

            <% Object objVehicles = request.getAttribute("vehiclesList"); %>
            <% List vehicles = (List) objVehicles; %>
            <% for (Object o : vehicles) { %>
                <% Vehicle v = (Vehicle) o;%>
                <tr>
                    <td><%= v.getId() %></td>
                    <td><%= v.getBrand() %></td>
                    <td><%= v.getType() %></td>
                    <td><%= v.getYear() %></td>
                    <td><%= v.getMileage() %></td>
                    <td><%= v.getRegNumber() %></td>
                    <td><%= v.getVin() %></td>
                    <td><%= v.getRegDate() %></td>
                    <td>
                        
                        <form action="deleteVehicleById">
                            <input type="hidden" name="id" value="<%= v.getId() %>"/>
                            <input type="submit" value="Delete"/>
                        </form>
                    </td>
                    <td>
                        <form action="updateVehicleById">
                            <input type="hidden" name="id" value="<%= v.getId() %>"/>
                            <input type="submit" value="Update"/>
                        </form>
                    </td>
                </tr>
                <% }%>
        </table>
        <table class="table_small">
            <tr>
                <td><input type="button" onclick="location.href='newVehicle.jsp';" value="Add new vehicle" /><br></td>
            </tr>
            <tr>
                <td><a href="start.jsp">Back to menu</a></td>
            </tr>
        </table>
        
    </body>
</html>
