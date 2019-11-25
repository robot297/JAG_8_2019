# Lab 8: First Swing GUI Programs

For all programs: Your GUI does not need to follow any particular design. It should be logical and obvious how to use. I'm not grading you on style. But if you want to improve the appearance of your GUI above the default, go ahead. 

If a variable name is specified for a component, you should use it. The tests expect you to use these names.

If you are not asked to show a dialog (e.g. a message dialog), don't show one. Your tests will hang or timeout because they are not expecting to need to dismiss the dialog(s).

For the last question, you do need to show dialogs. See instructions for how to do that. 

To take a screenshot on a Mac: Command+Shift+4 lets you select an area of screen on a Mac. Select an area, and the screenshot will be saved your desktop. 
Screenshots on Windows: use Window's Snipping Tool.


### Problem 1: Blood Donor Eligibility

To donate blood in the US, a donor must be at least 17, and weigh at least 110lbs. (You must also meet various other requirements, which we will ignore for this program).
gs
Add these components to DonorGUI.form. Ensure that you use these names.
 
* JButton `checkEligibilityButton`        User will click this to check eligibility   
* JTextField `weightTextField`            For the user's weight, in pounds  
* JTextField `ageTextField`               For the user's age, in years   
* JLabel `resultLabel`                    Will display if the user is eligible to be a blood donor or not  

Note that there are three final Strings defined in DonorGUI.java. The autograder expects you to use these to generate text for the resultLabel.

In DonorGUI, add an ActionListener to listen for click events on `checkEligibilityButton`. 
In the listener's `actionPerformed` method, verify that the user has entered a positive number in both the `weightTextField` and `ageTextField` JTextFields.
 
If either or both inputs are not valid (negative or not a number), the `resultLabel` JLabel should display the `INPUT_ERROR` text.

If both weight and age are positive numbers, use the data entered to decide if the user is eligible to be a blood donor.
To be eligible, a person must be 17 or older, AND weigh 110 lbs or more.

Display the `ELIGIBLE` text in the `resultLabel` JLabel if they are eligible.
Display the `NOT_ELIGIBLE` text in the `resultLabel` JLabel if they are not eligible.

Do not show any dialog, message, or alert boxes. 

Run and test your application. 

Take some screenshots of your application running and add to the **screenshots** directory in this project. 


### Problem 2: Agile or Waterfall?

Create a GUI for your Agile or Waterfall program from Lab 3.

Add these components to AgileWaterfallGUI.form. Again, use these names.

* JTextField `projectName`  
* JSlider `peopleOnTeam`  This should take values between 1 and 300. Add JLabels with the text "1" at the start, and "300" at the end, to indicate the start and end values.  
* JCheckBox `firmDeadlines`  
* JCheckBox `experienceAllPhases`  
* JCheckBox `qualityControl`  
* JCheckBox `earlyIntegration`  
* JCheckBox `earlyWorkingModels`  
* JButton `recommendMethodology`   
* JLabel `recommendation`    

Add more JLabels as appropriate, for example, to indicate what to type into the JTextField, and label the JSlider with a name, and max and min values. 

Your program may re-use the `agileOrWaterfall` method you wrote in Lab 3. 

Add a ActionListener (click) event listener to the `recommendMethodology` button. When clicked, this button will read the data entered, and recommend Waterfall or Agile or either for a development method for the project. Display the recommendation in the `recommendation` JLabel.

Use the provided Strings `AGILE`, `WATERFALL` and `EITHER` and `RECOMMENDATION_TEMPLATE` to display the result.

Your GUI program should use a JLabel and the `recommendationTemplate` format String provided to display something like “Big IBM Project could use Waterfall” or “My assignment could use Agile” or "Banking App could use either"

Take some screenshots of your application running and add to the **screenshots** directory in this project. 


### Problem 3: Gardener Invoices

You have been hired by a gardener to write a program to generate invoices. For this program, your program will generate text file invoices for some sample gardening services.

The gardener offers two services: mowing, and leaf raking.
The price structure is based on the size of the garden. To keep it simple, gardens may be small, medium, or large.

The prices for a small garden are mowing = $15 ; leaf raking = $12 

The price for each service for a medium garden is 2x that of a small garden.  (So leaf raking in a medium garden is $24).
The price for each service for a large garden is 3x that of a small garden.   (So leaf raking in a large garden is $36).

 The invoices need to have:
 
 * The customer name
 * Address
 * Date of service
 * The size of the garden
 * The mowing charge 
 * The leaf raking charge
 * The total for all services
 * Contact information for the gardener
 
 
Build a GUI that allows the gardener to enter data about a customer and garden services performed. The program will generate a preview on an invoice. The gardener can review this invoice, and then save it to a file.  

The GUI needs these components. Things you need to create are in **bold**.

A JPanel dataEntryPanel, containing the following components:

* JTextField, customerNameTextField. This has been created for you.
* JTextField, customerAddressTextField. This has been created for you.
* JSpinner, serviceDateSpinner, to select date the garden service was done. This has been created and configured for you
* **JComboBox** to select small, medium, large. Populate this from GardenServiceData's `size` array. Call it `gardenSizeComboBox`
JCheckBox mowingServiceCheckBox - if mowing was done. This has been created.
JLabel mowingServiceCost - to display the total cost for mowing services.
* **JCheckBox** - if leaf raking was done. You need to create this. Call it `leafRakingCheckBox`.
* **JLabel** - to display the total cost for leaf raking services. Call it `leafRakingCost`.
* **JLabel** displays the total cost of all services. You need to create this. Call it `invoiceTotal`
* JButton, generateInvoicePreviewButton, to generate invoice preview. This has been created for you.


Another JPanel, invoicePreviewPanel, containing the following components

* JTextArea, invoicePreviewTextArea, to display the invoice preview. This has been created for you.
* JButton, saveInvoiceButton, to save invoice to disk. This has been created for you.

You will not need to work with the JScrollPanel or JLabel in this JPanel. 

The user should be able to enter all information about services provided. Your program will calculate the totals based on what services are selected, and the size of the garden.

As the user modifies the garden size JComboBox, and/or checks and un-checks CheckBoxes, the price for each service, and the total, should update automatically. **Use an Item Changed listener** (not an action listener) for the JCheckBox components. 

If a service is not selected, the GUI should show "0.00" for the cost for that service.

If no services are selected, the GUI should show "0.00" for the total cost. 

Totals should be displayed as numbers in the JLabels with 2 decimal places. You may add a $ or other currency symbol if desired. So "$14.00" and "14.00" are both acceptable in the GUI. 

Currencies in the invoice should be displayed to two decimal places with a $ symbol, for example, $14.00. 

Dates in the invoice should be displayed as MM-dd-YYYY, for example, May 30 2017 would be "05-30-2017".  Look at `InvoiceWriter.createFileName` for an example of creating a formatted String from a date object.

On clicking the Invoice Preview button, use the methods in the `InvoiceGenerator` class to create a String, with the entire invoice. Display this in the JTextArea.  The user will be able to make edits to this text.

If the user does not select any services, and clicks the `invoicePreview` button, show a message dialog using the `showMessageDialog` method. Clear the `invoicePreviewTextArea`.

If the user does not enter a customer name or customer address, show a message dialog using the `showMessageDialog` method. Clear `invoicePreviewTextArea`.

On clicking the `saveInvoice button`, check to see if an invoice preview has been generated by checking if there is text in the `invoicePreviewTextArea`. If there is no text in `invoicePreviewTextArea`, display a message dialog.

If an invoice preview is shown in `invoicePreviewTextArea`, use the methods in `InvoiceWriter` to write the invoice to disk. Since the user is permitted to edit the invoice text, for example, to add some extra information, the text in the `invoicePreviewTextArea` should be written to the invoice file. 
  
Usually, you'd warn the user that they are about to overwrite an existing file, but for this program, you can create the file if it does not exist, or overwrite if it does exist.  

Use the `InvoiceWriter.createFileName` method to generate an appropriate invoice file name from the customer's name and the service date.

Use the `InvoiceWriter.writeToFile` method to write the invoice.

**If you need to show a message dialog**, use the `showMessageDialog` method in GardenGUI. Why? otherwise your tests will time out and fail, because the test doesn't have a way to click on the buttons in the JOptionPanes. Instead, it replaces the showMessageDialog and getStringWithDialog methods with a testing version that doesn't actually show the dialog, but still returns expected information to your program.   If your tests are failing with timeout errors, check that you are showing dialogs with this method.

Take some screenshots of your application running and add to the **screenshots** directory in this project. 
