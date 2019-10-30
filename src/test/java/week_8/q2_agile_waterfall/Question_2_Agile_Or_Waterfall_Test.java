package week_8.q2_agile_waterfall;

import org.junit.Before;
import org.junit.Test;
import test_utils.ReflectionUtils;

import javax.swing.*;
import java.lang.reflect.Field;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;


public class Question_2_Agile_Or_Waterfall_Test {
    
    private AgileWaterfallGUI gui;
    private Field recommendMethodology;
    private Field firmDeadlines, experienceAllPhases, qualityControl, earlyIntegration, earlyWorkingModels;
    private Field projectNameText;
    private Field peopleOnTeam;
    private Field recommendation;
    
    private JSlider peopleSlider;
    
    private  String projectName = "Example Project";
    
    
    @Before()
    public void findGUIComponents() throws Exception {
        gui = new AgileWaterfallGUI();
    
        Class guiClass = Class.forName("week_8.q2_agile_waterfall.AgileWaterfallGUI");
    
        try {
            recommendMethodology =  ReflectionUtils.getPrivateField(guiClass, "recommendMethodology");
            firmDeadlines = ReflectionUtils.getPrivateField( guiClass, "firmDeadlines");
            experienceAllPhases = ReflectionUtils.getPrivateField(guiClass, "experienceAllPhases");
            qualityControl = ReflectionUtils.getPrivateField(guiClass, "qualityControl");
            earlyIntegration = ReflectionUtils.getPrivateField(guiClass, "earlyIntegration");
            earlyWorkingModels = ReflectionUtils.getPrivateField(guiClass, "earlyWorkingModels");
            projectNameText = ReflectionUtils.getPrivateField(guiClass, "projectName");
            peopleOnTeam = ReflectionUtils.getPrivateField(guiClass, "peopleOnTeam");
            recommendation = ReflectionUtils.getPrivateField(guiClass, "recommendation");
    
            peopleSlider = (JSlider) peopleOnTeam.get(gui);
    
    
        } catch (NoSuchFieldException ne) {
            fail("Create the GUI components with names and types given in the instructions. This component was not found: " + ne.getMessage());
        }
    
    }
    
    @Test(timeout = 3000)
    public void testSliderConfigured() {
    
        // Check max and min for slider, should be 1 to 300
        assertEquals("The minimum value for the peopleOnTeam JSlider should be 1", 1, peopleSlider.getMinimum());
        assertEquals("The maximum value for the peopleOnTeam JSlider should be 300", 300, peopleSlider.getMaximum());
    
    }
    
    
    @Test(timeout=3000)
    public void testAgileWaterfallGUIWaterfallOptions() throws Exception {
    
        // Example combos that should return Waterfall
        String rec = getRecommendation(50, true, false, true, false, false, projectName);  // All for waterfall
        assertEquals("Team of 50, true, false, true, false, false should recommend Waterfall (all factors in favor of waterfall). \n" +
                "Use the recommendationTemplate String to build the text for recommendation JLabel", "Example Project could use Waterfall", rec);
    
        rec = getRecommendation(50, true, false, true, true, true, projectName);  // 4 out of 6 for waterfall
        assertEquals("Team of 50, true, false, true, true, true should recommend Waterfall (4 out of 5 factors in favor of waterfall).\n" +
                "Use the recommendationTemplate String to build the text for recommendation JLabel", "Example Project could use Waterfall", rec);
    
    }
    
    @Test(timeout=3000)
    public void testAgileWaterfallGUIAgileOptions() throws Exception {
    
        // Combos that should return Agile
        String rec = getRecommendation(10, false, true, false, true, true, projectName);  // All for agile
        assertEquals("Team of 10, false, true, false, true, true should recommend Agile (all factors in favor of agile).\n" +
                "Use the recommendationTemplate String to build the text for recommendation JLabel", "Example Project could use Agile", rec);
    
        rec = getRecommendation(40, true, true, false, true, true, projectName);  // 4 our of 6 for agile
        assertEquals("Team of 40, true, true, false, true, true should recommend Agile (4 out of 6 factors in favor of agile).\n" +
                "Use the recommendationTemplate String to build the text for recommendation JLabel", "Example Project could use Agile", rec);
    }
    
    @Test(timeout=3000)
    public void testAgileWaterfallGUIEitherOptions() throws Exception {
        
        // Combos that should return Either
        String rec = getRecommendation(10, true, false, true, true, true, projectName);   // 3 for each
        assertEquals("Team of 10, true, false, true, true, true should recommend either (3 factors for waterfall, 3 for agile).\n" +
                "Use the recommendationTemplate String to build the text for recommendation JLabel", "Example Project could use either", rec);
        
        rec = getRecommendation(50, false, true, true, false, true, projectName);  // 3 for each
        assertEquals("Team of 50, false, true, true, false, true should recommend either (3 factors for waterfall, 3 for agile).\n" +
                "Use the recommendationTemplate String to build the text for recommendation JLabel", "Example Project could use either", rec);
        
    }
    
    
    /* Returns the String that the program creates, e.g. something like 'My Android app should use Agile" */
    private String getRecommendation(int people, boolean deadlines, boolean experience, boolean qc, boolean earlyInt, boolean earlyModel, String projName) throws Exception {
        
        JSlider peopleSlider = (JSlider) peopleOnTeam.get(gui);
        peopleSlider.setValue(people);
        
        ((JCheckBox) firmDeadlines.get(gui)).setSelected(deadlines);
        ((JCheckBox) experienceAllPhases.get(gui)).setSelected(experience);
        ((JCheckBox) qualityControl.get(gui)).setSelected(qc);
        ((JCheckBox) earlyIntegration.get(gui)).setSelected(earlyInt);
        ((JCheckBox) earlyWorkingModels.get(gui)).setSelected(earlyModel);
        
        ((JTextField) projectNameText.get(gui)).setText(projName);
        
        JLabel recommendationLabel = (JLabel) recommendation.get(gui);
        
        JButton recommendMethodologyButton = (JButton) recommendMethodology.get(gui);
        recommendMethodologyButton.doClick();
        
        return recommendationLabel.getText();
        
    }
    
    
}