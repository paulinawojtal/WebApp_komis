<%-- 
    Document   : newVehicle
    Created on : 2020-02-27, 13:11:32
    Author     : PaulinaMaciej
--%>

<%@page import="model.Vehicle"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <fieldset class="select-class">
            <legend>Vehicle form</legend>
            <% Object objV = request.getAttribute("vehicle"); %>
            <% Vehicle vehicle = (Vehicle) objV;  %>
            <form method="post" action="saveVehicle" title="New vehicle form">
                Brand:</br>
                <input type="text" name="brand" value="<%= vehicle.getBrand() %>"/><p/>
                Type<br/>
                <input type="text" name="type" value="<%= vehicle.getType() %>"/><p/>
                Year:<br/>
                <select name="year">
                    <% for (int i = LocalDateTime.now().getYear(); i > 1960; i--) {%>
                        <% if(vehicle.getYear() == i) { %>
                            <option selected="selected"><%= i%></option>
                        <% } else { %>
                            <option><%=i%></option>
                        <% } %>
                    <% } %>
                </select><p/>
                Mileage:<br/>
                <select name="mileage">
                    <% for (int i = 1000000; i > 0; i-=50000) {%>
                        <% if(vehicle.getMileage() == i) { %>
                            <option selected="selected"><%= i %></option>
                        <% }else{ %>
                            <option><%= i%></option>
                        <% }%>
                    <% }%>
                </select><p/>
                Registration number:<br/>
                <input type="text" name="regNumber" value="<%= vehicle.getRegNumber() %>"/><p/>
                VIN number:<br/>
                <input type="text" name="vinNumber" value="<%= vehicle.getVin() %>"/><p/>
                Date of first registration:<br/>
                <input type="date" name="regDate" value="<%= vehicle.getRegDate() %>"
       min="1960-01-01" max="<%= LocalDate.now() %>"/><p/>
<!--                <input type="text" value="<%= vehicle.getRegDate() %>"></p>-->
                <input type="submit" value="Save vehicle" />
            </form>
        </fieldset>
        
        <a href="index.html">Back to menu</a>
    </body>
</html>
