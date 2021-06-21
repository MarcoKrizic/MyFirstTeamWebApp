Hello, and welcome to my Team Web App program!

This is a program I also made as an assignment for my Java course. Like all the Java projects I've done, I made use of the Netbeans IDE to program and set up
the file structure. I also used Apachye Tomcat 10 to launch the program as a localhost web app. The program is a multi-page web app coded in Java in which
users are given two teams (Red and Blue) to add and delete players at their will, effectively assembling their own teams. Users can also edit the information
previously entered for each added team member if they want to. 

hough I am sure there are ways to make use of this file structure without Netbeans and
Apache Tomcat, this is the way I am familiar with and would be happy to answer any questions if you need my help.

In order to get this program running as a web app, I set up a private Apache Tomcat 10 server. To do this:

1. Go to the Apache Tomcat website (or search it on Google) and download the Apache Tomcat 10 installer (.exe option) for your OS. Follow instructions
as specified during the installation process.

2. In Netbeans, right-click Tools ---> Servers ---> Add Server... and type in the corresponding credentials for the fields asked (Server Location, Username, Password)

3. If you get an error saying localhost:8080 is in use, open up your command terminal and use the following commands:

netstat -ano | findstr 8080 -- views the list of all the processes running on the 8080 port with each one represented by an ID number on the very right side
taskkill /F /pid x -- with x representing the corresponding ID number of the process you want to end.

---

You may also get another error where the PlayerControllerServlet file may throw a RuntimeException (represented by an HTTP 500 Internal Server Error). When using Netbeans, make 
sure you have the nb=javac plugin installed in Netbeans to avoid this happening. To do this, right-click on Tools, go to Plugins, and you should be able to install it there.



Now, here are some important files for reference:


//-----index.jsp-----//

This is the first page of the Java web program.
Here, you can select a team from the dropdown menu before adding new players.

//-----addPlayer.jsp-----//

This is the page of the Jave web program that lets you add a new player.


//-----editPlayer.jsp-----//
 
This is the page of the Java web program that lets you edit a new player.
The mechanics are virtually the same as the "Add Player" page.


//-----viewPlayers.jsp-----//

This is the page that lets you view all the registered players.
The program immediately transfers to this page every time a new player is added or changed.


//-----Player.java-----//

This is the Java class file that sets up the data structure for each new grade added in the program.

//-----PlayerControllerServlet.java-----//

This is the Java class file that sets up the server redirects between the different web pages as needed. Every Java web app needs a servlet file to handle the data
managed and transferred in the web app.


---

LASTLY, don't forget that if you want your player to join a certain team, you MUST have the team selected before you proceed with adding a player -- by default, any new player
added will join the team you ALREADY HAVE selected. This is also the case for any edited players; any edited players will move to the team you currently have selected, even
if they were previously on the opposite team! Keep this in mind, make sure you use the "Select Team" option effectively, and there should not be any problems on that front!

Thank you, and enjoy.