package week_8.garden;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * See grades/Lab 8 Questions.md for the instructions.
 */
public class GardenerGUI extends JFrame{
    private JPanel mainPanel;
    private JPanel dataEntryPanel;
    private JPanel invoicePreviewPanel;
    
    private JTextArea invoicePreviewtextArea;
    private JButton saveInvoiceButton;
    private JTextField customerNameTextField;
    private JTextField addressTextField;
    private JButton generateInvoicePreviewButton;
    private JSpinner serviceDateSpinner;
    
    GardenerGUI() {
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        // TODO
        
        configureDateSpinner();
        
    }
    
    private void configureDateSpinner() {
    
        // Dates between Jan 1, 1970 and some time in 2920. I don't suppose this program will be around this long though...
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel(new Date(), new Date(0), new Date(30000000000000L), Calendar.DAY_OF_YEAR);
        serviceDateSpinner.setModel(spinnerDateModel);
        // Define format the dates will have
        JSpinner.DateEditor editor = new JSpinner.DateEditor(serviceDateSpinner, "MM-dd-yyyy");
        DateFormatter formatter = (DateFormatter) editor.getTextField().getFormatter();
        // Attempt to prevent invalid input
        formatter.setAllowsInvalid(false);
        // Allow user to type as well as use up/down buttons
        formatter.setOverwriteMode(true);
        serviceDateSpinner.setEditor(editor);
    
    }
    
    
}
