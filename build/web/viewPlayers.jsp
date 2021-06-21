<%-- 
    Document   : viewPlayers
    Created on : Nov. 26, 2020, 3:06:22 p.m.
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
            ArrayList<Player> players = (ArrayList<Player>) session.getAttribute("players");
            String name = (String) session.getAttribute("name");

            if (players == null) {
            %><h3>There are no players currently registered.</h3><%
            } else {

            //Display title for "Red Team" only if there are players on the red team to display
            for (Player red : players) {
                if (red.getTeam().equals("Red")) {
        %>     <h3>Red Team</h3>              
        <%          break;
                }
            }
            
            //For each player in the "players" array, find the ones that are registered on the red team and display all their information
            for (Player p : players) {
                if (p.getTeam().equals("Red")) {
        %>      
                <tr>
                <td><b>Name</b></td>&nbsp;&nbsp;
                <td><%=p.getName()%></td>&nbsp;&nbsp;
                <td><b>Address</b></td>&nbsp;&nbsp;
                <td><%=p.getAddress()%></td>&nbsp;&nbsp;
                <td><b>Role</b></td>&nbsp;&nbsp;
                <td><%=p.getRole()%></td>&nbsp;&nbsp;
                <td><b>Active</b></td>&nbsp;&nbsp;
                <td><%=p.getActiveStatus()%></td>&nbsp;&nbsp;
                <td> 
                <form action="PlayerControllerServlet" method="POST">
                    <input type="hidden" name="name" value="<%=p.getName()%>">
                    <input type="hidden" name="address" value="<%=p.getAddress()%>">
                    <input type="hidden" name="role" value="<%=p.getRole()%>">
                    <input type="hidden" name="active" value="<%=p.getActiveStatus()%>">
                    <input type="hidden" name="team" value="<%=p.getTeam()%>">
                    <input type="submit" name="addplayer" value="Edit">
                    <input type="submit" name="addplayer" value="Delete">
                </form>
                </td>
                </tr><br><br>
        <%      }
            }
            
            //Display title for "Blue Team" only if there are players on the red team to display
            for (Player blue : players) {
                if (blue.getTeam().equals("Blue")) {
        %>      <h3>Blue Team</h3>
        <%          break;
                }
            }

            //For each player in the "players" array, find the ones that are registered on the blue team and display all their information
            for (Player b : players) {
                if (b.getTeam().equals("Blue")) {

        %>      
                <tr>
                <td><b>Name</b></td>&nbsp;&nbsp;
                <td><%=b.getName()%></td>&nbsp;&nbsp;
                <td><b>Address</b></td>&nbsp;&nbsp;
                <td><%=b.getAddress()%></td>&nbsp;&nbsp;
                <td><b>Role</b></td>&nbsp;&nbsp;
                <td><%=b.getRole()%></td>&nbsp;&nbsp;
                <td><b>Active</b></td>&nbsp;&nbsp;
                <td><%=b.getActiveStatus()%></td>&nbsp;&nbsp;
                <td> 
                <form action="PlayerControllerServlet" method="POST">
                    <input type="hidden" name="name" value="<%=b.getName()%>">
                    <input type="hidden" name="address" value="<%=b.getAddress()%>">
                    <input type="hidden" name="role" value="<%=b.getRole()%>">
                    <input type="hidden" name="active" value="<%=b.getActiveStatus()%>">
                    <input type="hidden" name="team" value="<%=b.getTeam()%>">
                    <input type="submit" name="addplayer" value="Edit">
                    <input type="submit" name="addplayer" value="Delete">
                </form>
                </td>
                </tr>
        <%      }
              }
            }
        %>
    <br><br>
    <a href="addPlayer.jsp">add new player</a><br><br>
    <a href="index.jsp">select team</a><br><br>

</body>
</html>


