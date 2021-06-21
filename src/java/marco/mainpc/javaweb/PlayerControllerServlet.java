/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marco.mainpc.javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import marco.mainpc.javaweb.Player;
import jakarta.servlet.annotation.WebServlet;

/**
 *
 * @author Marco
 */
public class PlayerControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            //Store all transferring data from all button inputs of program via this session
            HttpSession session = request.getSession();
           
            //Create and hold array of players for easy access, if array does not exist make one
            ArrayList<Player> players = (ArrayList<Player>) session.getAttribute("players");
            if (players == null) {
                players = new ArrayList<Player>();
            }  
          
            //("addplayer") serves as general event listener for buttons in the web program
            String playerAdd = request.getParameter("addplayer");
            
            //if ("Add Player") button is clicked in ("index.jsp")
            if (playerAdd.equals("Add Player")) {
                
                //The team colour is registered into the session
                //Any player created while this team colour is assigned will end up on this team.
                //This also includes any edited players. Players on the red team
                //will end up on blue if team colour "Blue" is stored in the session
                String team = request.getParameter("team");
                session.setAttribute("team", team);
                response.sendRedirect("addPlayer.jsp");  //go to "Add Player" page  
            }
            
            //if ("View Players") button is clicked in ("index.jsp")
            if (playerAdd.equals("View Players")) {
                
                //The team colour selected will be registered on this page as well.
                //This mechanic is useful if you want to put players on an opposing team.
                String team = request.getParameter("team");
                session.setAttribute("team", team);
                response.sendRedirect("viewPlayers.jsp");  //go to "View Players" page
            }
        
            //if ("Save") button is clicked in ("addPlayers.jsp")
            if (playerAdd.equals("Save")) {  
                
                Player newPlayer = new Player();  //new player is created
                newPlayer.setName(request.getParameter("name"));   //new player's name is registered
                newPlayer.setAddress(request.getParameter("address"));  //new player's address is registered
                newPlayer.setRole(request.getParameter("role"));    //new player's role is registered
                newPlayer.setTeam(request.getParameter("team"));    //new player's team is registered
                
                //new player's active status is registered
                if((request.getParameter("active")) == null) {
                   newPlayer.setActiveStatus("No");
                }
                else {
                   newPlayer.setActiveStatus("Yes");
                }
                
                //Player is stored in the system with saved names integrated into the session for future reference
                players.add(newPlayer); //player is added to the array of players that will be managed
                session.setAttribute("name", newPlayer.getName());  
                session.setAttribute("address", newPlayer.getAddress());
                session.setAttribute("role", newPlayer.getRole());
                session.setAttribute("active", newPlayer.getActiveStatus());
                
                session.setAttribute("players", players);
                response.sendRedirect("viewPlayers.jsp"); //go to "View Players" page
            }
            
            //if ("Cancel") button is clicked in ("addPlayers.jsp")
            else if (playerAdd.equals("Cancel")) {    
                response.sendRedirect("index.jsp");  //Go back to original screen (team selection)
            }
            
            //if ("Delete") button is clicked in ("viewPlayers.jsp")
            else if (playerAdd.equals("Delete")) {
                
            //Obtain saved player name for reference
            String name = request.getParameter("name");
            session.setAttribute("name", name);
            
            //Program will select from list of created players to see if name in session
            //matches any of the pre-existing users
            for (int i = 0; i < players.size(); i++) {
                if (name.equals(players.get(i).getName())) {
                    players.remove(players.get(i));  //Delete specified user
                }
                }
                session.setAttribute("players", players); //Update players array
                response.sendRedirect("viewPlayers.jsp");  //Go to "View Players" page
            }
            
            //if ("Edit") button is clicked in ("viewPlayers.jsp")
            else if (playerAdd.equals("Edit")) {
                
                //Obtain saved player name for reference
                String name = request.getParameter("name");
                session.setAttribute("name", name);
                
                //Program will select from list of created players to see if name in session
                //matches any of the pre-existing users
                for (int i = 0; i < players.size(); i++) {
                    if (name.equals(players.get(i).getName())) {
                        response.sendRedirect("editPlayer.jsp");  //A corresponding edit page will be created for specified player
                    }
                }
            }
            
            //if ("Change") button is clicked in ("editPlayer.jsp")
            else if (playerAdd.equals("Change")) {
                
                //Obtain previous stored name for reference and tie it to a separate session variable
                String oldName = request.getParameter("oldName");
                session.setAttribute("oldName", oldName);
                
                //Program will select from list of created players to see if old name in session
                //matches any of the pre-existing users
                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).getName().equals(oldName)) {
                        players.remove(players.get(i));  //Delete the user that will be replaced in the edit  
                    }
                }         
                
                Player newPlayer = new Player();  //Create replacing player
                newPlayer.setName(request.getParameter("name"));   //Replace old name with new name
                newPlayer.setAddress(request.getParameter("address"));  //Replace old address with new address
                newPlayer.setRole(request.getParameter("role"));  //Replace old role with new role
                newPlayer.setTeam(request.getParameter("team"));  //Replace old team with team currently registered in session
                
                //Replace old active status with new active status
                if((request.getParameter("active")) == null) {
                   newPlayer.setActiveStatus("No");
                }
                else {
                   newPlayer.setActiveStatus("Yes");
                }
                
                //Player is stored in the system with saved names integrated into the session for future reference
                players.add(newPlayer);  //player is added to the array of players that will be managed
                session.setAttribute("name", newPlayer.getName());
                session.setAttribute("address", newPlayer.getAddress());
                session.setAttribute("role", newPlayer.getRole());
                session.setAttribute("active", newPlayer.getActiveStatus());
                session.setAttribute("team", newPlayer.getTeam());
                
                session.setAttribute("players", players);  //Update the array
                response.sendRedirect("viewPlayers.jsp");  //Go to "View Players" page
            }
            
            //if ("Go Back") is clicked in ("editPlayer.jsp")
            else if (playerAdd.equals("Go Back")) {
                response.sendRedirect("viewPlayers.jsp"); //Return to "View Players" page with no changes
            }
    }
    

   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

        
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>My First Web App</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PlayerControllerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/


        /*else if (teamSelect.equals("Blue")) {
            HttpSession session = request.getSession();
            ArrayList<Player> blueTeam = (ArrayList<Player>)  session.getAttribute("blueTeam");
   
            String playerAdd = request.getParameter("addplayer");
            if (playerAdd.equals("Save")) {
                Player newPlayer = new Player();
                newPlayer.setTeam("Blue");
                newPlayer.setName(request.getParameter("name"));
                newPlayer.setAddress(request.getParameter("address"));
                newPlayer.setRole(request.getParameter("role"));
                newPlayer.setActiveStatus(request.getParameter("active"));
                    if(("active")==null) {
                       newPlayer.setActiveStatus("No");
                    }
                    else {
                       newPlayer.setActiveStatus("Yes");
                    }
                blueTeam.add(newPlayer);
                session.setAttribute("blueTeam", blueTeam);
                response.sendRedirect("viewPlayers.jsp");                
            }
            else if (playerAdd.equals("Cancel")) {
                response.sendRedirect("index.jsp");
            }
            
            String playerRemove = request.getParameter("editaction");
            if(playerRemove.equals("delete")) {
                for (int i = 0; i>blueTeam.size(); i++) {
                    Player p = blueTeam.get(i);
                    String playerDelete = request.getParameter("name");
                    if (p.getName().equals(playerDelete)) {
                        blueTeam.remove(p);
                    }
                }
                session.setAttribute("blueTeam", blueTeam);
                response.sendRedirect("viewPlayers.jsp");
            }
            else if (playerRemove.equals("edit")) {
                for (int i = 0; i>blueTeam.size(); i++) {
                    Player p = blueTeam.get(i);
                    String playerRedo = request.getParameter("name");
                    if (p.getName().equals(playerRedo)) {
                    session.setAttribute("player", p);
                    response.sendRedirect("editPlayer.jsp");
                    }
                }
            }
            
            String playerEdit = request.getParameter("editplayer");
            if(playerEdit.equals("save")) {

            }
            
        }*/