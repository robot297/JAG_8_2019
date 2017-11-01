package week_8.garden;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

/**
 * See grades/Lab 8 Questions.md for the instructions.
 */

public class GardenGUI extends JFrame{
    JPanel mainPanel;
    JPanel dataEntryPanel;
    JPanel invoicePreviewPanel;
    
    JTextArea invoicePreviewTextArea;
    JButton saveInvoiceButton;
    JTextField customerNameTextField;
    JTextField customerAddressTextField;
    JButton generateInvoicePreviewButton;
    JSpinner serviceDateSpinner;
    JCheckBox mowingServiceCheckBox;
    JLabel mowingServiceCost;
    
    
    GardenGUI() {
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(1000, 600));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        configureDateSpinner();   // Sets up the date spinner for you.
        
        
        // TODO add event handlers here
        // Don't write all of your code in this constructor. You should create methods for different tasks.
        
    }
    
    
    // TODO use this method to show an alert dialog
    // type can be JOptionPane.ERROR_MESSAGE, or JOptionPane.INFORMATION_MESSAGE
    void showMessageDialog(String message, String title, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }
    
    // TODO use this method to show a 'enter new String' dialog. The text will be initialized to initialValue
    String getStringWithDialog(String message, String initialValue) {
        return JOptionPane.showInputDialog(this, message, initialValue);
    }
    
    // You don't need to modify this method.
    private void configureDateSpinner() {
        
        // Dates between Jan 1, 1970 and some time in 2920. I don't suppose this program will be around this long though...
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(new Date(), new Date(0), new Date(30000000000000L), Calendar.DAY_OF_YEAR);
        serviceDateSpinner.setModel(spinnerDateModel);
        // Create a DateEditor to configure the way dates are displayed and edited
        // Define format the dates will have
        JSpinner.DateEditor editor = new JSpinner.DateEditor(serviceDateSpinner, "MM-dd-yyyy");
        DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();
        // Attempt to prevent invalid input
        formatter.setAllowsInvalid(false);
        // Allow user to type as well as use up/down buttons
        formatter.setOverwriteMode(true);
        // And tell the serviceDataSpinner to use this Editor
        serviceDateSpinner.setEditor(editor);
        
    }
    
    
}
