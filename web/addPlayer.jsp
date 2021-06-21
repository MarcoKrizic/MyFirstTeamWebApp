<%-- 
    Document   : addPlayers
    Created on : Nov. 26, 2020, 4:01:52 p.m.
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My First Team Web App</title>
    </head>
    <body>
        <h3>Enter the information below to add a new player.</h3>
        <br><br>
        <%
            String team = (String) session.getAttribute("team"); //Keep team colour registered for reference
        %>
        <form action="PlayerControllerServlet" method="POST">
            
        <label for "name" name="name" style="font-size: 16px">Name: </label>
            <input id="name" type="text" name="name" value="name" size='30'> <br>
        <label for "address" name="address" style="font-size: 16px">Address: </label>
            <input id="address" type="text" name="address" value="address" size='30'> <br>
        <label for "role" name="role" style="font-size: 16px">Role: </label>
            <input id="role" type="text" name="role" value="role" size='30'> <br>
        <label for "active" name="active" style="font-size: 16px">Active: </label>
        <input id="active" type="checkbox" name="active" value="active"> <br>
        <input type="hidden" name="team" value="<%=team%>">
        <input type="submit" name="addplayer" value="Save" onclick="window.location='viewPlayers.jsp'">
        <input type="submit" name="addplayer" value="Cancel" onclick="window.location='index.jsp'">

        </form>
        
               
    </body>
</html>
