package week_8.agile_waterfall;

import org.junit.Test;

import javax.swing.*;
import java.lang.reflect.Field;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;


public class Question_2_Agile_Or_Waterfall_Test {
    
    private AgileWaterfallGUI gui;
    private Field recommendMethodology;
    private Field firmDeadlines, experienceAllPhases, qualityControl, earlyIntegration, earlyWorkingModels;
    private Field projectName;
    private Field peopleOnTeam;
    private Field recommendation;
    
    @Test
    public void testAgileWaterfallGUI() throws Exception {
    
        AgileWaterfallGUI gui = new AgileWaterfallGUI();
        
        Class guiClass = Class.forName("week_8.agile_waterfall.AgileWaterfallGUI");
        
        try {
            recommendMethodology = guiClass.getDeclaredField("recommendMethodology");
            firmDeadlines = guiClass.getDeclaredField("firmDeadlines");
            experienceAllPhases = guiClass.getDeclaredField("experienceAllPhases");
            qualityControl = guiClass.getDeclaredField("qualityControl");
            earlyIntegration = guiClass.getDeclaredField("earlyIntegration");
            earlyWorkingModels = guiClass.getDeclaredField("earlyWorkingModels");
            projectName = guiClass.getDeclaredField("projectName");
            peopleOnTeam = guiClass.getDeclaredField("peopleOnTeam");
            recommendation = guiClass.getDeclaredField("recommendation");
        } catch (NoSuchFieldException ne) {
            fail("Create the GUI components with names and types given in the instructions. This component was not found: " + ne.getMessage());
        }
    
        // Check max and min for slider, should be 1 to 300
        JSlider peopleSlider = (JSlider) peopleOnTeam.get(gui);
        assertEquals("The minimum value for the peopleOnTeam JSlider should be 1", 1, peopleSlider.getMinimum());
        assertEquals("The maximum value for the peopleOnTeam JSlider should be 300", 300, peopleSlider.getMaximum());
    
    
        // Some example data, check the correct recommendation is made
        
        String projectName = "Example Project";
        // Example combos that should return Waterfall
        String rec = String.format(gui.recommendationTemplate, projectName, checkRecommendation(50, true, false, true, false, false, projectName));  // All for waterfall
        assertEquals("Team of 50, true, false, true, false, false should return Waterfall (all factors in favor of waterfall). \n" +
                "Use the recommendationTemplate String to build the text for recommendation JLabel", AgileWaterfallGUI.WATERFALL, rec);
    
        rec = String.format(gui.recommendationTemplate, projectName, checkRecommendation(50, true, false, true, true, true, projectName));  // 4 out of 6 for waterfall
        assertEquals("Team of 50, true, false, true, true, true should return Waterfall (4 out of 5 factors in favor of waterfall).\n" +
                "Use the recommendationTemplate String to build the text for recommendation JLabel", AgileWaterfallGUI.WATERFALL, rec);
    
    
        // Combos that should return Agile
        rec = String.format(gui.recommendationTemplate, projectName, checkRecommendation(10, false, true, false, true, true, projectName));  // All for agile
        assertEquals("Team of 10, false, true, false, true, true should return Agile (all factors in favor of agile).\n" +
                "Use the recommendationTemplate String to build the text for recommendation JLabel", AgileWaterfallGUI.AGILE, rec);
    
        rec = String.format(gui.recommendationTemplate, projectName, checkRecommendation(40, true, true, false, true, true, projectName));  // 4 our of 6 for agile
        assertEquals("Team of 40, true, true, false, true, true should return  Agile (4 out of 6 factors in favor of agile).\n" +
                "Use the recommendationTemplate String to build the text for recommendation JLabel", AgileWaterfallGUI.AGILE, rec);
    
    
        // Combos that should return Either
        rec = String.format(gui.recommendationTemplate, projectName, checkRecommendation(10, true, false, true, true, true, projectName));   // 3 for each
        assertEquals("Team of 10, true, false, true, true, true should return either (3 factors for waterfall, 3 for agile).\n" +
                "Use the recommendationTemplate String to build the text for recommendation JLabel", AgileWaterfallGUI.EITHER, rec);
    
        rec = String.format(gui.recommendationTemplate, projectName, checkRecommendation(50, false, true, true, false, true, projectName));  // 3 for each
        assertEquals("Team of 50, false, true, true, false, true should return either (3 factors for waterfall, 3 for agile).\n" +
                "Use the recommendationTemplate String to build the text for recommendation JLabel", AgileWaterfallGUI.EITHER, rec);
    
    
    }
    
    
    private String checkRecommendation(int people, boolean deadlines, boolean experience, boolean qc, boolean earlyInt, boolean earlyModel, String projName) throws Exception {
    
        JSlider peopleSlider = (JSlider) peopleOnTeam.get(gui);
        peopleSlider.setValue(people);
        
        ((JCheckBox) firmDeadlines.get(gui)).setSelected(deadlines);
        ((JCheckBox) experienceAllPhases.get(gui)).setSelected(experience);
        ((JCheckBox) qualityControl.get(gui)).setSelected(qc);
        ((JCheckBox) earlyIntegration.get(gui)).setSelected(earlyInt);
        ((JCheckBox) earlyWorkingModels.get(gui)).setSelected(earlyModel);
        
        ((JTextField) projectName.get(gui)).setText(projName);
        
        JLabel recommendationLabel = (JLabel) recommendation.get(gui);
        
        JButton recommendMethodologyButton = (JButton) recommendMethodology.get(gui);
        recommendMethodologyButton.doClick();
        
        return recommendationLabel.getText();
        
        
    }


}