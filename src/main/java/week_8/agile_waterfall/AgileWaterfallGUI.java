package week_8.agile_waterfall;

import javax.swing.*;

/** The instructions are in grades/Lab 8 Questions.md  */

public class AgileWaterfallGUI extends JFrame {
    
    private JPanel mainPanel;
    
    public final String AGILE = "Agile";
    public final String WATERFALL = "Waterfall";
    public final String EITHER = "either";
    
    public final String recommendationTemplate = "%s could use %s";
    
    AgileWaterfallGUI() {
        this.setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        //TODO add event handler to read the data entered, and selections made, and recommend a methodology.
        
    }
    
}
