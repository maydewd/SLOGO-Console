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

This section describes any issues which need to be addressed or resolved before attempting to devise a complete design solution. Include any design decisions that the group discussed at length (include pros and cons from all sides of the discussion) as well as any ambiguities, assumptions, or dependencies regarding the program that impact the overall design.

# Team Responsibilities
Nick

This section describes the program components each team member plans to take primary and secondary responsibility for and a high-level plan of how the team will complete the program.
