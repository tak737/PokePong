# COS126 Final Project: Implementation

Please complete the following questions and upload this `implementation.md`
file to the TigerFile assignment for the "Final Project Implementation".

**Do not alter the formatting**
(e.g. write your answer after the asterisks ** FIELD NAME ** or on the next
line after the header ### HEADER NAME). We have filled in a dummy response
for the first question in the first two sections as an example.

## Basic Information

You may copy and paste your answers from questions 1-8 in the status update.

1. **Name 1:** Tommy Kim


2. **NetID 1:** takim


3. **Name 2 (include if pair project):**


4. **NetID 2 (include if pair project):**


5. **Project preceptor name:** Tara Shankar


6. **Project title:** Poke-Pong


7. **CodePost link for proposal:**
https://codepost.io/code/570658

8. **CodePost link for revised proposal (include if submitted):**
https://codepost.io/code/575848

9. **CodePost link for status update:**
https://codepost.io/code/581964

10. **Link to project video:**
https://drive.google.com/drive/folders/1gGpyA78P3wgxkmqxjmgKrG_q91wfRW4s?usp=sharing

11. **Number of hours to complete implementation:** 32


## Required Questions

### A. Describe your implemented project in a few sentences below.

My final project, Poke-pong, is a Pokemon-themed, four-player game of pong that
includes some twists to the original game. Each player has three lives in the
form of three pokemon, and there are obstacles that the ball interacts with.

### B. Describe your three features.
*Be specific in your description of each feature.
In particular, specify **where** they are implemented
(e.g. .java file name, starting and ending line numbers, method names, etc.).*

  1. The first feature includes rendering the pokeball, the pokemon, and
  the paddles. This feature also includes the movement of the paddles.
  This feature is implemented in Game.java from line 24 through 194, excluding
  lines 115 through 170 and uses the randomize and drawTarget methods from
  Scoring.java and StdDraw.isKeyPressed() from the StdDraw library.
  The other methods used from lines 24 through 194 are not part of this first feature.

  2. The second feature adds interactions with the paddless and the pokemon.
  This also happens in Game.java, on lines 115 through 170, and the methods
  slowDown, speedUp, fling, and catchPokemon from Scoring.java are used.

  3. The final feature is the scoring system, which also occurs in Gama.java from
  lines 5, 7, and 115 through 118. This feature uses the catchPokemon method and
  the createGame method to remove lives and .png files and keep track of how many
  lives a player has. When a player runs out of pokemon, their paddle stops moving.


### C. Describe in detail how to compile and run your program.
*Include a few example run commands and the expected results of running your program.
For non-textual outputs (e.g. graphical or auditory), feel free to describe in
words what the output should be or reference output files (e.g. images, audio files)
of the expected output.*

Since the output for this project is a standard draw window, running the program
is quite simple. Compiling requires these two lines:

javac-introcs Game.java
javac-introcs Scoring.java

To play the game, Game.java just needs to be run:
java-introcs Game

To test the two methods that I tested, Scoring.java neesd to be run:
java-introcs Scoring

### D. Describe how your program accepts user input
*Mention the line number(s) at which your program accepts user input.*

My program accepts user input through the pressing of keys
(z, c, m, ., ;, -, 2, and a).
This occurs on lines 50, 58, 66, 74, 82, 90, 98, and 106 of Game.java

### E. Describe how your program produces output based on user input
*Mention the line number(s) at which your program produces output.*

The program outputs images from .png files that move in response to keyboard
presses. The StdDraw.picture() methods for these files output occurs on lines
185 to 188, and StdDraw.show() is on line 192.

### F. Describe the data structure your program uses
*Also describe how it supports your program's functionality.
Include the variable name and the line number(s) at which it is declared
and initialized).*

My project uses multiple symbol tables to keep track of the number of lives
each player has and which .png files to draw in standard draw.
playerLives, which keeps track of the numbers of players' lives, is declared
and initialized on line 7. targets, which keeps track of the .png files, is
declared and initialized on line 9.





### G. List the two custom methods written by your project group
*Include method signatures and line numbers.
If your project group wrote more than two custom functions, choose the
two functions that were most extensively tested.*

1. randomize(), on line 16 of Scoring.java

2. drawTarget(), on line 246 of Scoring.java

### H. List the line numbers where you test each of your two custom methods twice.
*For each of the four tests (two for each method), explain what was being
tested and the expected result. For non-textual results (e.g. graphical or
auditory), you may describe in your own words what the expected result
should be or reference output files (e.g. images, audio files).*
1. line 319 of Scoring.java: testing random double output

2. line 321 of Scoring.java: testing random double output

3. line 334-335 of Scoring.java: testing StdDraw location

4. line 341-342 of Scoring.java: testing StdDraw location


## Citing Resources

### A. List below *EVERY* resource your project group looked at
*Bullet lists and links suffice.*

https://introcs.cs.princeton.edu/java/15inout/MouseFollower.java.html
https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html?is-external=true
https://docs.google.com/document/d/1t_3faRPgonwt78eM7tthA_bsjbKy6kn22cLVv4S0Bn0/edit
https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html
https://introcs.cs.princeton.edu/java/11cheatsheet/#Math
https://introcs.cs.princeton.edu/java/12types/
https://edstem.org/us/courses/18194/lessons/29233/slides/167347

Below is a list of attributions that I give for the .png files that I used:
Orange Paddle: <a href="https://www.flaticon.com/free-icons/line" title="line
icons">Line icons created by Smashicons - Flaticon</a>
Ball:
Pokeball PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Those Icons - Flaticon</a>
Slowing Image:
Snorlax PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Roundicons Freebies - Flaticon</a>
Speeding Image:
Voltorb PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Darius Dan - Flaticon</a>
Direction Change Image:
Ditto PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Darius Dan - Flaticon</a>
Psyduck PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Roundicons Freebies - Flaticon</a>
Dratini PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Roundicons Freebies - Flaticon</a>
Basic Player:
Pikachu PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Those Icons - Flaticon</a>
Eevee PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Roundicons Freebies - Flaticon</a>
Squirtle PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Roundicons Freebies - Flaticon</a>
Water Type Player:
Staryu PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Darius Dan - Flaticon</a>
Marill PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Darius Dan - Flaticon</a>
Psyduck PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Roundicons Freebies - Flaticon</a>
Ghost/Psychic Type Player:
Duskull PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Darius Dan - Flaticon</a>
Gastly PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Darius Dan - Flaticon</a>
Abra PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Roundicons Freebies - Flaticon</a>
Grass Type Player:
Exeggcute <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Darius Dan - Flaticon</a>
Chikorita PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Darius Dan - Flaticon</a>
Bellsprout PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Darius Dan - Flaticon</a>
Weakling Player:
Zubat: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Roundicons Freebies - Flaticon</a>
Pidgey PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Roundicons Freebies - Flaticon</a>
Rattata PNG: <a href="https://www.flaticon.com/free-icons/pokemon" title="pokemon
icons">Pokemon icons created by Roundicons Freebies - Flaticon</a>

### B. Did you cite every resource that influenced your code in the code itself?
*Every resource that informed your code should be cited in a comment at/near the
line(s) of code that it informed.*

**Yes or No?**

Yes

### C. Did you receive help from classmates, past COS 126 students, or anyone else?
*If so, please list their names. ("A Sunday lab TA" or "Office hours on
Thursday" is ok if you don't know their name.)*

**Yes or No?**

Meetings with Tara Shankar and Donna Gabai

### D. Did you encounter any serious problems? If so, please describe.

**Yes or No?**

No


### E. List any other comments here. ###

This program represents my own work in accordance with University regulations. /s/


## Submission Checklist
*Please mark that you’ve done all of the following steps
(fill in square bracket with x, i.e. [x]):*

* [X] Created a project.zip file, unzipped its contents, and checked that our
    compile and run commands work on the unzipped contents. Ensure that the .zip
    file is under 50MB in size.
* [ ] Created and uploaded a Loom or YouTube video that...
  * [ ] is maximum 2 minutes in length
  * [ ] demonstrates live your program's input(s) and output(s)
  * [ ] demonstrates live your 3 features
  * [ ] does **not** reveal any code
  * [ ] includes your project name and the name of each student
  * [ ] has its thumbnail and/or starting frame set to an image of your program
        or a title slide
  * [ ] is publicly viewable (check in an incognito browser)
  * [ ] is linked to in this `implementation.md` file (Q10 under Basic Information)
* [X] Uploaded all .java files to TigerFile. Each .java file should be uploaded
      separately as an additional file.
* [X] Uploaded project.zip file to TigerFile.

*After you’ve submitted the above on TigerFile, **remember to do the following**:*
* [X] Complete and upload this `implementation.md` file to TigerFile.
* [ ] Complete and submit this Google Form
    (https://forms.cs50.io/27ca51e0-4d81-4d97-8621-ba1e5d26cd78).


## Partial Credit: Bug Report(s)
*For partial credit for buggy features, you may include a bug report for at
most 4 bugs that your project group was not able to fix before the submission
deadline. For each bug report, copy and paste the following questions and
answer them in full. Your bug report should be detailed enough for the grader
to reproduce the bug.*

***Note:** if your code appears bug-free, you should **not** submit any bug reports.*

### BUG REPORT #1:
**1. Describe in a sentence or two the bug below.**




**2. Describe in detail how to reproduce the bug (e.g. run commands, user input,
etc.).**




**3. Describe the resulting effect of bug and provide evidence
(e.g. copy-and-paste the buggy output, reference screenshot files and/or buggy
output files, include a Loom video of reproducing and showing the effects of
the bug, etc.).**




**4. Describe where in your program code you believe the bug occurs (e.g. line
numbers).**




**5. Please describe what steps you tried to fix the bug.**





## Extra Credit

### A. Going above and beyond the scope of COS126

#### Did your program go above and beyond the scope of COS126?

**Yes or No?**

*If yes, please answer the following question.*

#### Describe in detail how your program went above and beyond the scope of COS126.



### B. Runtime Analysis

#### Did you analyze the efficiency of a substantial component of your project?

**Yes or No?**

*If yes, please answer the following questions.*

**1. Specify the scope of the component you are analyzing
(e.g. function name, starting and ending lines of specific .java file).**




**2. What is the estimated runtime (e.g. big-O complexity) of this component?
Provide justification for this runtime (i.e. explain in your own words why
you expect this component to have this runtime performance).**




**3. Provide experimental evidence in the form of timed analysis supporting this
runtime estimate. (Hint: you may find it helpful to use command-line
arguments/flags to run just the specified component being analyzed).**




### C. Packaging project as an executable .jar file

#### Did you package your project as an executable .jar file?

**Yes or No?**

*If yes, please answer the following question.*

#### Describe in detail how to execute your .jar application (e.g. what execution command to use on the terminal).
*Include a few example execution commands and the expected results of running
your program. For non-textual outputs (e.g. graphical or auditory), feel free
to describe in words what the output should be or reference output files
(e.g. images, audio files) of the expected output.*



