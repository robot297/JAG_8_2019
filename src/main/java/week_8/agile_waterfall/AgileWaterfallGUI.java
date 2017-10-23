package week_8.agile_waterfall;

import javax.swing.*;

/** The instructions are in grades/Lab 8 Questions.md  */

public class AgileWaterfallGUI extends JFrame {
    
    private JPanel mainPanel;
    
    public final static String AGILE = "Agile";
    public final static String WATERFALL = "Waterfall";
    public final static String EITHER = "either";
    
    public final static String RECOMMENDATION_TEMPLATE = "%s could use %s";
    
    AgileWaterfallGUI() {
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        //TODO any GUI configuration needed
        //TODO add event handler to read the data entered, and selections made,
        //TODO recommend a methodology, display in JLabel.
        // Use the recommendationTemplate to display a String like "Android App should use Agile"
        
    }
    
}
