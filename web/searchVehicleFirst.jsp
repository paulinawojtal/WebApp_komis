<%-- 
    Document   : searchVehicle
    Created on : 2020-02-28, 14:08:10
    Author     : PaulinaMaciej
--%>

<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search vehicle</title>
        <link rel="stylesheet" href="styles.css">
        <script type="text/javascript" src="js/searchVehicle.js"></script>
    </head>
    <body>
        <form class="table_small">
            <input type="text" list="columns"/>
            <datalist id="columns">
                <option value="Honda"></option>
                <option value="Mazda"></option>
                <option value="Hyiundai"></option>
            </datalist>
        <button id="search" type="button">Search</button>
        <span id="selectedCol"></span>
        <select name="searchSelecte"d id="searchSelected">
            
        </select>
        </form>
        
    </body>
</html>