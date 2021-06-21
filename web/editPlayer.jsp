<%-- 
    Document   : editPlayers
    Created on : Nov. 26, 2020, 3:06:47 p.m.
    Author     : Marco
--%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="marco.sheridancollege.mainpc.javaweb.Player"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My First Team Web App</title>
    </head>
    <body>
        <% 
            String team = (String) session.getAttribute("team");
            String name = (String) session.getAttribute("name");
            String address = (String) session.getAttribute("address");
            String role = (String) session.getAttribute("role");
            String active = (String) session.getAttribute("active");

        %>
        
        <h3>Edit Player <%=name%></h3><br><br>
        
        <h4>Warning: Your edited player will be registered to whichever team you currently have selected
            from the main menu. <br> If you want your player to register on the other team, you will have to <br>
            go back to the team selection menu and access the player roster after re-selecting your team.</h4>

        
        <form action="PlayerControllerServlet" method="POST">
            
        <label for "name" name="name" style="font-size: 16px">Name: </label>
            <input id="name" type="text" name="name" value="<%=name%>" size='30'> <br>
        <label for "address" name="address" style="font-size: 16px">Address: </label>
            <input id="address" type="text" name="address" value="<%=address%>" size='30'> <br>
        <label for "role" name="role" style="font-size: 16px">Role: </label>
            <input id="role" type="text" name="role" value="<%=role%>" size='30'> <br>
        <label for "active" name="active" style="font-size: 16px">Active: </label>
            <input id="active" type="checkbox" name="active" value="<%=active%>"> <br>
        <input type="hidden" name="oldName" value="<%=name%>">
        <input type="hidden" name="team" value="<%=team%>">  
        <input type='submit' name="addplayer" value='Change' onclick="window.location='viewPlayers.jsp'">
        <input type='submit' name="addplayer" value='Go Back' onclick="window.location='viewPlayers.jsp'">

        </form>
    </body>
</html>
