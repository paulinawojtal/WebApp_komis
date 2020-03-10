<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css">
        <title>New client</title>
    </head>
    <body>
        <!--<h1>New client form</h1>-->
        <fieldset class="select-class">
            <legend>New client form</legend>
            <form method="post" action="saveClient" title="New client form">
                First name:</br>
                <input type="text" name="name"/><p/>
                Surname:<br/>
                <input type="text" name="surname"/><p/>
                Age:<br/>
                <select name="age">
                    <% for (int i = 18; i < 110; i++) {%>
                    <option><%= i%></option>
                    <% }%>
                </select><p/>
                Region:<br/>
                <select name="region"s>
                    <option id="europe">Europe</option>
                    <option id="asia">Asia</option>
                    <option id="northAmerica">North America</option>
                    <option id="southAmerica">South America</option>
                    <option id="africa">Africa</option>
                </select><p/>
                Gender:<br/>
                <input type="radio" name="gender" value="male">Male<br>
                <input type="radio" name="gender" value="female">Female<p/>
                <input type="submit" value="Save Client" />
            </form>
        </fieldset>
        
        <a href="start.jsp">Back to menu</a>
    </body>
</html>
