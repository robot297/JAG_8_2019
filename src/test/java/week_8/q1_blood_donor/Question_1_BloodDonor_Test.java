package week_8.q1_blood_donor;

import org.junit.Before;
import org.junit.Test;
import test_utils.ReflectionUtils;

import javax.swing.*;


import static junit.framework.TestCase.fail;
import static org.junit.Assert.*;

/**
 * Created by clara on 8/5/17.
 */
public class Question_1_BloodDonor_Test {
    
    private JButton checkEligibilityButton;
    private JTextField ageText, weightText;
    private JLabel resultLabel;
    
    @Before
    public void findGUIComponents() throws Exception{
    
        // Find all relevant components
    
        DonorGUI gui = new DonorGUI();
        Class guiClass = Class.forName("week_8.q1_blood_donor.DonorGUI");
    
        try {
            ageText = (JTextField) ReflectionUtils.getPrivateField(guiClass, "ageTextField").get(gui);
            weightText = (JTextField) ReflectionUtils.getPrivateField(guiClass, "weightTextField").get(gui);
            checkEligibilityButton = (JButton) ReflectionUtils.getPrivateField(guiClass, "checkEligibilityButton").get(gui);
            resultLabel = (JLabel) ReflectionUtils.getPrivateField(guiClass, "resultLabel").get(gui);
        } catch (NoSuchFieldException nsf) {
            fail("Create the GUI components required, use the names given. Could not find " + nsf.getMessage());
        }
    
    }
    
    
    @Test(timeout=3000)
    public void testDonorGUIEligible() throws Exception {
    
        // Eligible
    
        checkInputCombos("30", "160", DonorGUI.ELIGIBLE);
        checkInputCombos("30", "110", DonorGUI.ELIGIBLE);   // At weight limit
        checkInputCombos("17", "150", DonorGUI.ELIGIBLE);   // At age limit
        checkInputCombos("17", "110", DonorGUI.ELIGIBLE);   // At age and weight limit
    
    }
    
    @Test(timeout=3000)
    public void testDonorGUIEligibleNotEligible() throws Exception {
    
    
        // Not eligible
    
        checkInputCombos("16", "110", DonorGUI.NOT_ELIGIBLE);   // Too young
        checkInputCombos("16", "170", DonorGUI.NOT_ELIGIBLE);
        checkInputCombos("16", "100", DonorGUI.NOT_ELIGIBLE);
        checkInputCombos("0", "120", DonorGUI.NOT_ELIGIBLE);
    
        checkInputCombos("20", "100", DonorGUI.NOT_ELIGIBLE);  // too light
        checkInputCombos("17", "100", DonorGUI.NOT_ELIGIBLE);
        checkInputCombos("15", "100", DonorGUI.NOT_ELIGIBLE);
        checkInputCombos("20", "0", DonorGUI.NOT_ELIGIBLE);
    
    }
    
    @Test(timeout=3000)
    public void testDonorGUIInputErrors() throws Exception {
        
        // Validation errors, only accept positive double values
        
        checkInputCombos("120", "-1", DonorGUI.INPUT_ERROR);
        checkInputCombos("120", "2sfs", DonorGUI.INPUT_ERROR);
        checkInputCombos("120", "sdff", DonorGUI.INPUT_ERROR);
        
        checkInputCombos("pizza", "150", DonorGUI.INPUT_ERROR);
        checkInputCombos("6qwe", "150", DonorGUI.INPUT_ERROR);
        checkInputCombos("-4", "150", DonorGUI.INPUT_ERROR);
        
        checkInputCombos("1a", "2b", DonorGUI.INPUT_ERROR);
        
    }
    
    private void checkInputCombos(String age, String weight, String expected) throws Exception {
        
        ageText.setText(age);
        
        weightText.setText(weight);
        
        checkEligibilityButton.doClick();
        
        String result = resultLabel.getText();
        
        String message = String.format("For age %s and weight %s your GUI resultLabel JLabel should show %s",
                age, weight, expected);
        assertEquals(message, expected, result);
        
    }
    
    @Test
    public void testHasScreenshots() {
        fail("Take some screenshots of your GUI and add them to the screenshots directory. " +
                "\nThis test will always fail and will be graded manually.");
    }
}

