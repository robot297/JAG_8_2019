package week_8.blood_donor;

import org.junit.Test;

import javax.swing.*;
import java.lang.reflect.Field;


import static org.junit.Assert.*;

/**
 * Created by clara on 8/5/17.
 */
public class Question_1_BloodDonor_Test {

    private DonorGUI gui;
    private JButton submitButton;
    private Field ageText, weightText, button, res;

    @Test
    public void testDonorGUI() throws Exception {
        
        // Find all relevant components
        
        gui = new DonorGUI();
        Class guiClass = Class.forName("week_8.blood_donor.DonorGUI");
        ageText = guiClass.getDeclaredField("ageTextField");
        weightText = guiClass.getDeclaredField("weightTextField");
        ageText.setAccessible(true);
        weightText.setAccessible(true);
    
        button = guiClass.getDeclaredField("submitButton");
        button.setAccessible(true);
    
        submitButton = (JButton)button.get(gui);
        
        res = guiClass.getDeclaredField("resultLabel");
        res.setAccessible(true);
        
        // Eligible
    
        donorValues("30", "160", DonorGUI.ELIGIBLE);
        donorValues("30", "110", DonorGUI.ELIGIBLE);   // At weight limit
        donorValues("17", "150", DonorGUI.ELIGIBLE);   // At age limit
        donorValues("17", "110", DonorGUI.ELIGIBLE);   // At age and weight limit
    
    
        // Not eligible
    
        donorValues("16", "110", DonorGUI.NOT_ELIGIBLE);   // Too young
        donorValues("16", "170", DonorGUI.NOT_ELIGIBLE);
        donorValues("16", "100", DonorGUI.NOT_ELIGIBLE);
        donorValues("0", "120", DonorGUI.NOT_ELIGIBLE);
    
        donorValues("20", "100", DonorGUI.NOT_ELIGIBLE);  // too light
        donorValues("17", "100", DonorGUI.NOT_ELIGIBLE);
        donorValues("15", "100", DonorGUI.NOT_ELIGIBLE);
        donorValues("20", "0", DonorGUI.NOT_ELIGIBLE);
        
        
        // Validation errors, only accept positive double values
    
        donorValues("120", "-1", DonorGUI.INPUT_ERROR);
        donorValues("120", "2sfs", DonorGUI.INPUT_ERROR);
        donorValues("120", "sdff", DonorGUI.INPUT_ERROR);
        
        donorValues("pizza", "150", DonorGUI.INPUT_ERROR);
        donorValues("6qwe", "150", DonorGUI.INPUT_ERROR);
        donorValues("-4", "150", DonorGUI.INPUT_ERROR);
    
        donorValues("1a", "2b", DonorGUI.INPUT_ERROR);
    
    
    
    }

    private void donorValues(String age, String weight, String expected) throws Exception {
        
        JTextField ageField = (JTextField) ageText.get(gui);
        ageField.setText(age);
    
        JTextField weightField = (JTextField) weightText.get(gui);
        weightField.setText(weight);
    
        submitButton.doClick();
        JLabel results = (JLabel) res.get(gui);
        
        String message = String.format("For age %s and weight %s your GUI result label should show %S",
                age, weight, expected);
        assertEquals(message, expected, results.getText());
    
    }

}

