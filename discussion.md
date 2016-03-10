# Peer Code Review
Authors: David Maydew, Nick Lockett, Carine Torres

For our peer code review, we chose to work through the errors listed in output of Professor Duvall's simple script. These included problems with long methods (and poorly divided classes) as well as issues with error handling. This involved extracting methods and removing printStackTrace() calls with proper error display.

We chose to refactor these sections of code because they were in conflict with the fundamental design principles of readability and Indescriptive Naming (from STUPID code design). The long methods in the FileSelector class obfuscated the functions of the class, and would have made it significantly more difficult to add additional functionality. Additionally, the silent error handling in the parser meant that a user would have no idea that their XML file was not properly read in, and the program would continue with a malformed XML file. 
