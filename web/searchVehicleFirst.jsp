<%-- 
    Document   : searchVehicle
    Created on : 2020-02-28, 14:08:10
    Author     : PaulinaMaciej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search vehicle</title>
        <link rel="stylesheet" href="styles.css"
    </head>
    <body>
        <form action="searchVehicle" class="select-class">
            <select>
                <option name="brand">Brand</option>
                <option name="type">Type</option>
                <option name="year">Year</option>
                <option name="mileage">Mileage</option>
                <option name="regNumber">Registraion Number</option>
                <option name="vin">VIN Number</option>
                <option name="regDate">Registration Date</option>
            </select>
             
           <input type="submit" value="Search Vehicle"/>
        </form>
        
    </body>
</html>
