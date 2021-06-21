<%-- 
    Document   : index
    Created on : Nov. 26, 2020, 2:27:06 p.m.
    Author     : Marco
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="marco.sheridancollege.mainpc.javaweb.Player"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My First Team Web App</title>
    </head>
    <body>
        <%
            ArrayList<Player> players = (ArrayList<Player>) session.getAttribute("players");
        %>

        <h1>Welcome to the Hockey League Registration Web App!</h1>
        <br><br>
        

        <form action="PlayerControllerServlet" method="POST"> 
            <label for "team" style="font-size: 16px">Team: </label>
            <select id="team" name="team" value="team">
                <option value="Red">Red</option>
                <option value="Blue">Blue</option>            
            </select>
            <br><br>
            <input type="submit" name="addplayer" value="Add Player">&nbsp;&nbsp;
            <input type="submit" name="addplayer" value="View Players">
        </form>
    </body>
</html>
