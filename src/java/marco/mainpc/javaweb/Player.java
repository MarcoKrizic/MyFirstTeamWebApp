/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marco.mainpc.javaweb;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * This class serve as the JavaBeans where all the information regarding
 * each individual player registered in the system is handled. The name,
 * address, team colour, role, and active status is generated using iterations
 * of this class. 
 * @author marco
 */
public class Player implements Serializable {
    
    private String name;
    private String address;
    private String team;
    private String role;
    private String active;
    
    private ArrayList<Player> players;
    
    /**
     * This class servers as the constructor for the general info each
     * time a player is registered.
     */
    public Player() {
        
    }
    
    /**
     * This class saves and stores the name information of the player.
     * @param name - Name of the player
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * This class retrieves the name data of the player for the general user.
     * @return - Name of the player
     */
    public String getName() {
        return name;
    }
    
    /**
     * This class saves and stores the address information of the player.
     * @param address - Address of the player
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * This class retrieves the address data of the player for the general user.
     * @return - Address of the player
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * This class saves and stores the team colour information of the player.
     * @param team - Colour of player's team (blue or red)
     */
    public void setTeam(String team) {
        this.team = team;
    }
    
    /**
     * This class retrieves the team colour data of the player for the general user.
     * @return  - Colour of player's team (blue or red)
     */
    public String getTeam() {
        return team;
    }
    
    /**
     * This class saves and stores the role information of the player.
     * @param role - Role of player
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    /**
     * This class retrieves the role data of the player for the general user.
     * @return - Role of player
     */
    public String getRole() {
        return role;
    }
    
    /**
     * This class saves and stores the status information of the player.
     * @param active - Active status of player
     */
    public void setActiveStatus(String active) {
        this.active = active;
    }
    
    /**
     * This class retrieves the status data of the player for the general user.
     * @return - Active status of player
     */
    public String getActiveStatus() {
        return active;
    }
    
}




