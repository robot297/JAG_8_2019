package week_8.blood_donor;

import javax.swing.*;

/** The instructions are in grades/Lab 8 Questions.md  */


public class DonorGUI extends JFrame {
    
    public static final String ELIGIBLE = "Eligible!";
    public static final String NOT_ELIGIBLE = "Sorry, not eligible.";
    public static final String INPUT_ERROR = "Error - enter positive numbers";
    
    private JPanel mainPanel;
    
    DonorGUI() {
        this.setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        // TODO add a listener for the checkEligibilityButton
        // This should verify that the user has entered a positive number
        // in both the weightTextField and ageTextField JTextField
        // If either or both are not valid, the resultLable should
        // display the INPUT_ERROR text.
        
        // If both weight and age are positive numbers, use the data
        // to decide if the user is eligible to be a blood donor.
        // To be eligible, a person must be 17 or older,
        // AND weigh 110 lbs or more.
    
        // Display the ELIGIBLE text if they are eligible.
        // Display the NOT_ELIGIBLE text if they are not eligible.
        
    }
    
}
