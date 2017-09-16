
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


For all programs: Your GUI does not need to follow any particular design. It should be logical and obvious how to use. I'm not grading you on style. But if you want to improve the appearance of your GUI above the default, feel free. 

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
**JSlider peopleOnTeam**  This should take values between 1 and 300. Add JLabels "1" and "300" to indicate the start and end values.
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


### Problem 3: Gardener Invoices

You have been hired by a gardener to write a program to generate invoices. For this program, your program will generate text file invoices for some sample gardening services.

The gardener offers 3 services: mowing, leaf raking, and weed pulling.
The price structure is based on the size of the garden. To keep it simple, gardens may be small, medium, or large.

The prices for a small garden are mowing = $15 ; leaf raking = $12 ; weed pulling $14

The price for each service on a medium garden is 2x that of a small garden.  (So leaf raking in a medium garden is $24).
The price for each service on a large garden is 3x that of a small garden.   (So weed pulling in a large garden is $42)

 The invoices need to have:
 
 *The customer name
 *Address
 *Date of service
 *The size of the garden
 *The mowing charge 
 *The leaf raking charge
 *The weed pulling charge
 *The total 
 *Contact information for the gardener
 
 
Build a GUI that allows the gardener to enter data about a customer and garden services performed. The program will generate a preview on an invoice. The gardener can review this, and then save it to a file.  

The GUI needs these components:

A JPanel containing the following components:

JTextField, customer name. This has been created for you.
JTextField, customer address. This has been created for you.
JSpinner to select date. This has been created and configured for you
JComboBox to select small, medium, large. Populate this rom GardenServiceData's size array
JCheckBox - if mowing was done. You need to create this. 
JLabel - to display the total cost for mowing services.
JCheckBox - if leaf raking was done. You need to create this. Call it leafRakingCB
JCheckBox - if weed pulling was done. You need to create this. Call it weedPullingCB
JLabel: total cost of all services. You need to create this. 
JButton to generate invoice preview. This has been created.


Another JPanel containing the following components

JTextArea to display the invoice preview. 
JButton to save invoice to disk

These have been created for you. 

The user should be able to enter all information. Your program will calculate the totals. 

On clicking the Invoice Preview button, use the methods in the Invoice Generator class to create a String. Display this in the JTextArea.  The user will be able to make edits to this text.

On clicking the Save Invoice button, use the methods in InvoiceWriter to write the invoice to disk. Alert the user if they will overwrite an existing file. 
