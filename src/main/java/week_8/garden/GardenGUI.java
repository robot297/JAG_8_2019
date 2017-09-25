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
    JTextField addressTextField;
    JButton generateInvoicePreviewButton;
    JSpinner serviceDateSpinner;
    JCheckBox mowingServiceCheckBox;
    JLabel mowingServiceCost;
    
    
    GardenGUI() {
        setContentPane(mainPanel);
        setPreferredSize(new Dimension(700, 500));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        configureDateSpinner();
        
        
        // TODO add event handlers here
        
        /* Checkboxes and JComboBox should cause their associated JLabels and the total to update.
         Example: user clicks the mowingServiceCheckBox and has 'small' selected for the garden size JComboBox.
         The mowingServiceCost JLabel should show $14.    The total JLabel should show $14.
         Then, if the user changes the JComboBox to 'large'. This should cause the JLabel to change to $42. The total JLabel should update to $42.
         Then, if the user selects another service, that service's JLabel should update, and so should the total.
        
         Clicking the report preview should validate that a name and address have been entered, and at least one garden service.
         Use InvoiceGenerator's method to create the report text. You'll need to create a HashMap with the keys specified in InvoiceGenerator.
         Show the text of the report in invoicePreviewTextArea.
        
         Clicking the saveInvoiceButton will generate a filename for the invoice, using the methods in InvoiceWriter.
         Save the contents of the invoicePreviewTextArea to this file. The user may have edited it, so save whatever is in this JTextArea.
         Check if the file already exists before writing. If the file does exist, prompt user for a new file name, or
         the option to cancel so they may remove the existing file if desired.  You can use a JOptionDialog for this.
         
         Don't write all of your code in this constructor. You should create methods for different tasks.
         
        */
        
    }
    
    
    // TODO use this method to show an alert dialog
    // type can be JOptionPane.ERROR_MESSAGE, or JOptionPane.INFORMATION_MESSAGE,
    void showMessageDialog(String message, String title, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }
    
    // TODO use this method to show a 'enter new String' dialog. The text will be initialized to initialValue
    String getStringWithDialog(String message, String initialValue) {
        return JOptionPane.showInputDialog(this, message, initialValue);
    }
    
    
    
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
