


******************
*****************
****************
****************** FIX GRADES.JSON

*****************
*****************
*****************
*****************
*****************

And, please paste a screenshot of your application running.

Screenshots on a Mac: Command+Shift+4 lets you select an area of screen on a Mac, by default the screenshot is dropped on your desktop. Drag it here to add it to this worksheet, or Insert menu > Photo/Picture.

Screenshots on Windows with Word 2010 or above, Insert > Screenshot > Screen Clipping to add a screenshot. Or you can use Window's Snipping Tool).

Problem 2:

Complete the Credit Card validation program from the slides.

Push your code to GitHub and paste the link here

And, please paste a screenshot of your application running.

Problem 3:

Create a GUI for your Agile or Waterfall program from Lab 3.

Please provide a JTextField to enter the project name. You’ll need checkboxes for all the questions to ask. Your program can re-use the method you wrote in Lab 3. Have a “Recommend” button to recommend your opinion of Waterfall or Agile for a development method for the project.

You can add a JTextField from the component palette. In your code, you can read the text and store in a String like this, assuming your JTextField is called projectName,

String myProjectName = projectName.getText();

Your GUI program should use a JLabel to display something like “Big IBM Project should use Waterfall” or “My assignment should use Agile”. Or, you can use a JOptionPane to create a popup box with the suggestion.

Please push code to GitHub and paste a link to your repo:

And, please paste a screenshot of your application running.

Advanced

Finish any incomplete Essentials problems first.

Problem 1:

Fork and then download this this GitHub repository to create a new project in IntelliJ.

HYPERLINK "https://github.com/minneapolis-edu/MinimalSnake" https://github.com/minneapolis-edu/MinimalSnake

It’s a simple game called Snake which became popular on Nokia cellphones from the 1990’s. Use the arrow keys to move the red snake around the screen to ‘eat’ the blue kibble blocks. Every time the snake eats, it grows, so the game gets harder. If the snake hits the edge of the screen or its tail, game over. You win by eating so much that the snake fills the screen.

This application doesn't use many Swing GUI components, except JFrame and JPanel. JFrame is the main window, and it contains a JPanel that fills the JFrame.

It does use event handlers, and custom painting to draw the game components.

JPanel's superclass has a method called paintComponent(Graphics G) which is automatically called on all JPanels when they are created. If you override paintComponent for your application's JPanel, then your JPanel's version of paintComponent gets called. Use the Graphics object, g, to do the custom drawing and painting. Here, ‘drawing’ means drawing circles, lines, rectangles, text…

HYPERLINK "http://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html" http://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html

Please review this code. Research TimerTask and KeyListener and Graphics. What do these classes do?

Look at how the code uses a timer and updates the display every time the timer ticks.

What data structure is used to store the position of the snake? Can you think of another way of doing this?

Please add the following features:

Change the color of the snake, kibble, and game messages to different colors of your choice.

Change the screen size, so the snake has more squares in the grid

Challenge! In the original versions of the snake game, the snake had ‘warp walls’ – instead of hitting the wall, the snake would leave one side of the screen and reappear on the other side. Can you implement warp walls in this program? Before you do this, it’s important that you understand how the snake square positions are represented in the code, and how they are updated as the snake moves.

Describe how you would use, or would not use, classes to organize the code better.

Push your code to your own GitHub repository and paste the link here.