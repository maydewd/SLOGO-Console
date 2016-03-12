# slogo API Changes
Duke CompSci 308 Cell Society Project

Names:
David Maydew, Carine Torres, Nick Lockett, Zdravko Paskalev, Timothy Blumberg

Date started:
2/18/15

Date finished:
3/12/15

Hours worked:
Average 30 Hours per person, per week

Individual Roles:
In the initial grouping, David, Carine, and Zdravko were the "back-end" team, whereas Nick and Timothy were the "front-end" team. As the project continued, however, those roles became increasingly fluid. Nick worked primarily on the turtle display and menu bar selectors, and Timothy worked on the side panel displays. Zdravko worked on the Library import/export and console controller. David worked on the parser/nodes and the model representation. Carine worked on the model representation and the command interpreters.

Resources used:
Lots of resources on properties and bindings, as well as others on how to implement specific JavaFX view elements.

Main class file:
Main.java

Testing files:
For testing, users can import/export their own API's or workspace settings. If they want to modify the default start up, they can edit the default.xml file in the resources folder.

Data (non Java) files needed:
resources.*

Keys/Mouse input:
To execute a command, type it in the console and press enter to execute. Press shift-enter to put a new line while typing. Click on turtles to view their information and/or select them. Use the menu bars to change the properties of the pen & turtle. Use the accordion expander to view information about the state of execution, and double-click on commands in the command history to re-execute them.

Known bugs:
* User commands must be defined before being referenced in the body of another command. 
* Some error conditions are not handled with checked exceptions, such as setting the palette.

Impressions/Suggestions:
Overall, this project was great for learning the benefits of specifying an API, as well as the practical steps that have to be taken to adapt along the way. As a suggestion, learning about Properties/Bindings before the initial design would have been very helpful for our initial design, rather than having to go back and tweak it later. 
