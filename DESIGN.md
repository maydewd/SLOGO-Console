# Introduction
David

In our SLOGO project, we hoping to effectively use API's to communicate between the front-end and the back-end, allowing both sub-groups of our team to work independently. The API's will each allow the appropriate amount of access to information within the component, and should ideally be flexible enough to permit future extensions. The primary design goals of our project are to close the implementation of the parser, so that it is flexible when implementing new commands. Additionally, our design aims to facilitate a flexible communication of information from the Model to the View, so that it is able to accurately reflect changes from a command. 

From a high-level, our project will be split into three components, the Model, the View, and the Controller. The controller will handle the parsing of commands, and the routing of information between the Model and the View. As such, both the front-end and the back-end teams will have some part in shaping the controller component. 


# Design Overview
Z

This section serves as a map of your design for other programmers to gain a general understanding of how and why the program was divided up, and how the individual parts work together to provide the desired functionality. Describe the four APIs you intend to create (their purpose with regards to the program's functionality, and how they collaborate with each other) focusing specifically on the behavior, not the internal state. Include a picture of how the components are related (these pictures can be hand drawn and scanned in, created with a standard drawing program, or screen shots from a UML design program). Discuss specific classes, methods, and data structures, but not individual lines of code.

# User Interface
Timothy and Nick

### UIManager
This class will be started and handled by our Application level class `SLogoEngine`. This class will construct the UI classes and maintain references to them. It will also distribute links between the Model and this `Controller/View`.

### UITurtleView
This class will build and manage the View that will display the results of the actions taken by the turtle by the commands entered by the user. It will receive it's direction by querying the Model every update cycle for a list of `Delta` objects that will instruct the View on how things should be updated from the last update.

* `private List<Delta> deltaList;`

### UIConsoleView
This class will gather user input and pass the new commands to the Model for parsing into `Delta` objects that will be queried by the `UITurtleView` class.

### UICommandHistoryView
This class will display the command history of the user.

This section describes how the user will interact with your program (keep it simple to start). Describe the overall appearance of program's user interface components and how users interact with these components (especially those specific to your program, i.e., means of input other than menus or toolbars). Include one or more pictures of the user interface (these pictures can be hand drawn and scanned in, created with a standard drawing program, or screen shots from a dummy program that serves as a exemplar). Describe any erroneous situations that are reported to the user (i.e., bad input data, empty data, etc.).

### UIUserCommandListView
List of commands that can be clicked on to run directly.


### UISettingsMenu
Will contain the following items in menus:
* Change background color
* Change pen color
* Change language
* Help page button
* Change turtle image

### UIErrorNotifier
This UI will generate error popups that will alert the user to problems that occur in the program running. Potential errors include:

* Incorrect Syntax
* References vars that don’t exist
* Move a turtle that doesn't exist


# API Details
David

### External Front-end API
The API of the front-end team will center around accepting packets of information that represent a change in state from a given command. As such, they will have methods that allow the controller to relay this information. This information will contain descriptions of the current state of the turtle, any new lines drawn, previous command history, variables defined, and user-defined commands. We would also like to implement some of this functionality, such as the command history and variables defined, using JavaFX property bindings, meaning that in order to properly display these modules, they will need to be given property bindings. Additionally, the front-end team will implement a method that allows the Controller to pass along any errors that have been generated during the execution of a command. 

### Internal Front-end API
In order to allow for ideal extensibility, the internal API for extending the front-end will focus on modularity of the different parts of the GUI. In essence, the responsibilities for implementing an additional feature to the front-end will involve only an additional class and a new reference in the main GUI handler. In this case, new features may require modifications to the external API, since these new modules could require additional information from the back-end. Since all of this behavior is encapsulated behind an interface, however, this internal extension does not significantly affect the exterior appearance of the component. 

### External Back-end API
The goal of the external portion of the back-end API is to allow for a simple interface that accepts a string input command, and returns the changes in state as a result of this command. The other team will not have to worry about the parsing of the command, or how the state is stored internally, but rather only the changes in state that the back-end returns. As such, the packets of information that the back-end returns must contain all of the information necessary to describe the change in state as a result of a command. Another key aspect of this API is the ability to generate helpful exceptions, primarily as a result of an invalid command. This external API will allow the other team to capture an accurate representation of why a particular error was thrown. 

### Internal Back-end API
The goal of the internal portion of the back-end API is to allow for a wide range of input commands, while being flexible with the state it returns. As such, we have decided to have the back-end API implement a variety of methods, such as moveTurtleForward() or rotate() for example, that allow all of the commands that change the state to have easy access. Another focus of this internal API is the extensibility of the parsing of input commands. To tackle this, we will implement a new class to represent each command that will handle its own execution and the parsing of its parameters, since the format of each command varies. This means that each 'command' object will implement an interface that allows for other nodes to access its return value, execute it, and parse a string into its children. 


# API Example Code
Everyone

It is especially important in helping others understand how to use your APIs to provide example code. It should be clear from this code which objects are responsible for completing each part of the task, but you do not have to implement the called functions.

* Show actual "sequence of code" that implements the following use case:
  * *The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and the command is added to the environment's history.*


* Note, clearly show the flow of calls to public methods needed to complete this example, indicating which class contains each method called. It is not necessary to understand exactly how parsing works in order to complete this example, just what the result of parsing the command will be.

* Additionally, each member of the team should create one use case of their own (and example code) for the part of the project for which they intend to take responsibility. These can still be done as a group, but should represent a variety of areas of the overall project.

# Design Considerations
Carine

* An important design decision that our program hinges upon is whether or not to abide by a simple model that merely splits up Model and View (an embeds the Controller), or to further delegate functionality to a Controller, following an MVC design paradigm or an adaption of one (perhaps, an MVA model).  The pro to separating controller functionality would be to allow for as close to isolation of the View from the Model as possible.  The Controller would take care of communications between the View and Model so to limit unnecessary sharing of or dependency on data between the two.  In this sense, extensibility of the View aspect becomes much more plausible because the Model can function regardless of what happens in the View.  The Controller would dictate its behaviors and responses rather than the View, to allow for compatibility with varied views.  A con with the MVC model is that the involvement of a third party (the Controller) between the Model and View will obviously require more complicated and careful implementation so that data that needs to be accessed gets sent over.
* Another important design decision we made for our program was on what kind of data to pass from the Model to the View so to indicate to the View what updates need to be made on the screen.  We were deciding between some kind of renderable delta object (representing a change) that contained properties indicative of what drawing patterns the screen might feature in the next frame, where those drawing patterns might take place on the screen, etc.  For example, a "forward 50" command (with the pen down) might be processed by the model to return a renderable object with properties having values that included "line," (0,0), (0,50) so that the View could interpret a line needed to be drawn between those two points.  The pro to that would be that in the case that an extension of the project might require manipulating objects on the screen by interacting with the User Interface, having the View recognize that line as a single node (not just separately colored pixels) would facilitate changing the entire node as a whole. The con, however, might be the inefficiency and impracticality of such an implementation in the View class.  The implementation would not be very flexible in the View class because it hints at a lot of conditionals with different implementation code dealing with what happens if it sees a value "line" vs. "circle," etc.  Additionally, considering drawing patterns as a "whole" would require trickier manipulation for the gradual drawing of the pattern frame by frame.  What we instead decided to do was to have the information passed from the Model to the View be a collection of objects representing pixels / cells that essentially have a property that is "on" or "off" depending on whether the next frame will present those cells as colored in or not (depending on if the turtle passes through / has passed through those cells with the pen down).  We decided that although this unfortunately does not allow for the belonging of individual cells / pixels to a larger node, we could incorporate a later necessity for that by adding a field to each cell to help indicate a root it belongs to.  Ultimately, we preferred this method of passing data because it facilitates gradual drawing of lines or shapes pixel by pixel by isolating each pixel, and additionally, it allows for less interpretation by the View for what to display on the screen.  This would reduce the inflexibility of the View having to check case by case to figure out what to do.
* Another design decision we discussed was to incorporate an XY-coordinate system upon which our display would be oriented.  Essentially, we would have a pixel at each (x,y) value--with different properties--through each of which a turtle could pass.  The pro of incorporating an XY-coordinate system is that it would be easier to locate and set an object on the display, facilitating updates such as the removal or addition of a line passing through a certain set of (x,y) points.  A con to our XY-coordinate system was that not each object on the screen (for example, the turtle object) would necessarily lay in a single pixel (i.e. (x,y) point).  Thus, the view would have to deal with understanding what a turtle object located at (0,3) means--which encompasses so much more than a sole colored pixel at (0,3)--or what thickening a line segment running from (0,5) to (0,10) means (i.e. darkening more pixels around the 5 pixels that that line segment may run through.  However, we decided that the location of an object or an object's ends could just represent the center of those objects and that the logic behind expanding the "space" that that object takes up would not be too troublesome.  Our XY-coordinate system would be a better abstraction than using a bitmap of sorts where an object (or the important ends of an object) is not represented by a sole value, but an object belongs to multiple bit objects.  That makes each object harder to isolate and locate.
* Our design also involves a parser that will pass a sort of abstract syntax tree to the controller representing the components of each "command" written by a user.  We wanted the controller to be able to handle a "command" line recursively because one "command" line might actually be composed of multiple commands that need to first be executed before the ultimate command is executed.  Thus, an abstract syntax tree would facilitate this recursive functionality because "parent" commands are still connected to "child" commands in an abstract syntax tree, but the abstraction of the tree does not require concrete source code that might not yet be determinable if child commands have not yet been executed.  A con to an abstract syntax tree is that an additional layer of code needs to be generated for the controller to be able to execute logic on the information passed from the parser.  Ultimately, however, the pros of abstraction for functionality like loops that rely on execution of other commands first.  

# Team Responsibilities

### David

* Parser
* Command Implementation

### Nick

* Turtle view
* Settings UI
* Delta objects --> Displaying Turtle
* Error UI

### Carine

* Model
* Command implementation (continued)

### Timothy

* Console
* Variable List
* Command History
* User Defined Commands List
* UIManager

### Z

* Controller
* Will Create the Delta objects
* Parse String --> Commands (Nodes)
* Execute Commands
