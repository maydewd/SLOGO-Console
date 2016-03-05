##API Review 
###Part 1
1. I worked on the front end of the program, and so the flexibility of my design can be shown through how many different pieces of data can be displayed without any changes to code. In my case, because all of the actual modules were implemented through an interface, the Manager class could be swapped as is into a different program with entirely different backend and information and it would still run.  Furthermore,  the individual modules spacing is flexibly allocated through the preferred sizing, which lets them bend to accommodate as many modules as needed in the display.

2. Our encapsulation is excellent in that non of the features know anything about each other, or even the backend of the project.  All interactions between classes are handled through either the UIView Interface or a backend interface. THis prohibits knowledge being shared and allows them to be completely swiped out without any trouble. Specifically, the UISettingsView takes control of all of its own sizing and logic information, simply returning the preferred information to the new class. 

3. The primary exceptions that arise in the frontend are a result of bad values being passed in from the backend.  This suggests that the best way to handle errors is to install checks at these interaction points, and then inform the user through a dialog box of any problems that could arise. All other intrinsic to frontend errors should be handled internally, although there should be few.

4. I believe that a good API design is one that is easy to understand, completely represents the functionality, and cleanly and efficiently handles its execution and error reporting.  My API does all of these things because it has a low number of clearly labeled methods, is completely hidden and encapsulated so that it can be easily extended later,  is complete in its implementation of the assignment, and handles all errors in a simple and clean manner.
 
 
###Part 2
1. Project was demod, but there was some issues with backend interaction.
2.  a. Changing background Color
		- UISettingsView.
	b. Changing Pen Color
	c. Entering a Command
	d. Catching a Syntax error
		- Controller calls UIErrorNotifier.syntaxError();
3.  I am most excited to get the bindings working with the backend well.  I look forward to exploring this new technique and implementing it in a useful, simple way.  
4.  I am most worried about this small bug that I have experienced in changing the settings for the 