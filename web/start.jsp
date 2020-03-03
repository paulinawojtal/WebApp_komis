<%-- 
    Document   : start
    Created on : 2020-02-27, 09:08:36
    Author     : PaulinaMaciej
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Komis start page</title>
    </head>
    <body>
        <table class="table_small">
            <tr>
                <th>Client management</th>
                <th>Vehicle management</th>
            </tr>
            <tr>
                <th><%@include file="clientManagement.html"%></th>
                <th><%@include file="vehicleManagement.html"%></th>
            </tr> 
        </table>
        <%@include file="footer.html" %>
    </body>
</html>
