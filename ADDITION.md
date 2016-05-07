CompSci 308: SLogo Addition
===================

## Estimation
* In total, I think it will take me around 1 hour and 15 minutes to complete this new feature. This includes some time to refamiliarize myself with the code and then plan out the best way to implement this feature.

* I project that I will need to add 3 files (one relating to the turtle, and two for the new commands) and update around 5 more (though most of these will be simple one line additions of methods)

## Review
* It took me 1 hour and 30 minutes to complete the new feature.
* I added 3 new files and made significant changes to 9 more. The additional file updates that I didn't initially estimate came from the properties file containing the translated command names, as well as the Turtle view which needed a small modification to its bounds.
* It didn't work perfectly on the first try for two reasons:
  1. I had forgotten about the dependency between the parser and the properties file containing the (translated) command names. The parser generates classes reflectively from this file, but to add new command you must add a Node for that command as well as adding it to the properties file.
  2. The bounds of the turtle display were a bit off on the first try, and I had to slightly tweak them to match how the JavaFX Canvas was settings its preferred width. This change was only necessary so that the turtle's fence bounds perfectly matched the display bounds in the view.
* Other than those two things hiccups, however, implementing the feature went quite smoothly.

## Analysis
* This exercise revealed some good things and some things that could have been improved with our SLogo design. Overall, the design and documentation was as clear and easy to understand as I remember. The classes were well named, with the purpose and structure of their methods adding to the understanding of the big picture. The structure for adding a new command node was very easy to follow, and (other than the small properties file hiccup above) was very quick to write.
* One portion of our design that could be improved is how we represented the state and actions of the Turtle. Before this feature, each action was essentially a method inside the turtle that handled any simple calculations. However, rather than implementing this border behavior with an if-else statement, I decided to use more of a visitor pattern approach. Rather than the Turtle class implementing the ability to move forward and set location, I gave each Turtle a MovementModule that handled that behavior for it. This is an approach that we generalized to all sprite behaviors in our VOOGASalad project, and is one step towards using Composition for the Turtle. For the purposes of this feature, I made the fencing behavior module extend the window behavior module, however this hierarchy could be expanded as necessary to handle more complex forms of border behavior.
* If I were not familiar with the code at all, it would have been relatively easy to learn the pattern for adding a new command node. The process is simple enough that it could be followed from the steps submitted in the last analysis, though there should be more comments in the actual classes detailing this process. The changes to the Turtle, however, would have been a bit tougher to implement if you were not familiar with the code at all. Since previously all of the Turtle actions were tied up in one class, adding new functionality would mean you would need to be familiar with this entire class. Nonetheless, I believe that if the Turtle had initially been completely implemented with the Composition/Modular design pattern I added in for this feature, this step would have been significantly simplified. 
