package week_8.blood_donor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by clara on 9/12/17.
 */
public class DonorGUI extends JFrame {
    
    public static final String ELIGIBLE = "Eligible!";
    public static final String NOT_ELIGIBLE = "Sorry, not eligible.";
    public static final String INPUT_ERROR = "Error - enter positive numbers";
    
    private JPanel mainPanel;
    private JButton submitButton;
    private JTextField weightTextField;
    private JTextField ageTextField;
    private JLabel resultLabel;
    
    DonorGUI() {
        this.setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        
                double age, weight;
                try {
                     weight = Double.parseDouble(weightTextField.getText());
                     age = Double.parseDouble(ageTextField.getText());
                } catch (NumberFormatException ex) {
                    resultLabel.setText(INPUT_ERROR);
                    return;
                }
                
                
                if (weight < 0 || age < 0) {
                    resultLabel.setText(INPUT_ERROR);
                    return;
                }
                
                
                if (weight >= 110 && age >= 17) {
                    resultLabel.setText(ELIGIBLE);
                }
                
                else {
                    resultLabel.setText(NOT_ELIGIBLE);
                }
                
            }
        });
        
    }
    
}
