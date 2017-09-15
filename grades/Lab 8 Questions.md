
# Lab 8: First Swing GUI Programs

******************
*****************
****************
****************** FIX GRADES.JSON

*****************
*****************
*****************
*****************
*****************

### Problem 1: Blood Donor Eligibility

Add these components to DonorGUI.form. Ensure that you use these names.
 
**JButton checkEligibilityButton**        User will click this to check eligbility 
**JTextField weightTextField**            for the user's weight in pounds
**JTextField ageTextField**               For the user's age in years 
**JLabel resultLabel**                    Will display if the user is eligible to be a blood donor or not

In DonorGUI, add a click listener for the checkEligibilityButton. 
In the listener's onClick method, verify that the user has entered a positive number in both the weightTextField and ageTextField JTextField
If either or both are not valid, the resultLabel should display the INPUT_ERROR text.

If both weight and age are positive numbers, use the data to decide if the user is eligible to be a blood donor.
To be eligible, a person must be 17 or older, AND weigh 110 lbs or more.

Display the ELIGIBLE text if they are eligible.
Display the NOT_ELIGIBLE text if they are not eligible.

Run and test your application. 

Take a screenshot of your application running and add it to the **screenshots** directory in this project. 

Screenshots on a Mac: Command+Shift+4 lets you select an area of screen on a Mac. Select an area, and the screenshot will be saved your desktop. 
Screenshots on Windows: use Window's Snipping Tool.


### Problem 2: Agile or Waterfall?

Create a GUI for your Agile or Waterfall program from Lab 3.

Add these components to AgileWaterfallGUI.form. Again, use these names.

**JTextField projectName**
**JSlider peopleOnTeam**  This should take values between 1 and 300.
**JCheckBox firmDeadlines**
**JCheckBox experienceAllPhases**
**JCheckBox qualityControl**
**JCheckBox earlyIntegration**
**JCheckBox earlyWorkingModels**
**JButton recommendMethodology**
**JLabel recommendation**

Add more JLabels as appropriate, for example, to label the JTextField and JSlider name and max and min values. 

Your program can re-use the agileOrWaterfall method you wrote in Lab 3. 

Add a click event listener to the `recommendMethodology` button. When clicked, this button will read the data entered, and recommend Waterfall or Agile or Either for a development method for the project. Display the recommendation in the `recommendation` JLabel

Your GUI program should use a JLabel and the recommendationTemplate format String provided to display something like “Big IBM Project could use Waterfall” or “My assignment could use Agile” or "Banking App could use either"

Take a screenshot of your application running and add it to the **screenshots** directory in this project. 


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