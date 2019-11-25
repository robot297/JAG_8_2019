package week_8.q3_garden;

import org.junit.Before;
import org.junit.Test;
import test_utils.FileUtils;
import test_utils.ReflectionUtils;

import javax.swing.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static test_utils.FileUtils.fileContentsSameAsString;


public class GardenInvoiceTest {
    
    // Mock methods to override the behavior of dialogs. Otherwise test will hang waiting for click in dialog.
    private class GardenGuiWithNoDialogs extends GardenGUI {
        
        String userText;   // set this before a dialog is expected to be shown
        
        private boolean wasMsgDialogCalled = false;
        
        boolean getMessageDialogWasCalled() {
            boolean returnVal = wasMsgDialogCalled;
            wasMsgDialogCalled = false;
            return returnVal;
        }
        
        @Override
        void showMessageDialog(String message, String title, int type) {
            wasMsgDialogCalled = true;
        }
    
        @Override
        String getStringWithDialog(String message, String initialValue) {
            return userText;
        }
    
    }
    
    
    
    // Global components, configured in @Before method
    
    private GardenGuiWithNoDialogs gui;
    private JCheckBox leafCB, mowCB;
    private JLabel leafTotal, mowTotal;
    private JLabel invoiceTotal;
    private JComboBox sizeCombo;
    private JTextField customerName, customerAddress;
    private JSpinner dateSpinner;
    private JButton invoicePreview, saveInvoice;
    
    private String toPrice(double p) {
        return String.format("%.2f", p);
    }
    
    
    @Before
    public void findComponents() {
        
        gui = new GardenGuiWithNoDialogs();
        
        try {
            
            Class guiClass = Class.forName("week_8.q3_garden.GardenGUI");
            
            leafCB = (JCheckBox) ReflectionUtils.getPrivateField(guiClass, "leafRakingCheckBox").get(gui);
            mowCB = gui.mowingServiceCheckBox;
            
            leafTotal = (JLabel) ReflectionUtils.getPrivateField(guiClass, "leafRakingCost").get(gui);
            mowTotal = gui.mowingServiceCost;
            
            invoiceTotal = (JLabel) ReflectionUtils.getPrivateField(guiClass, "invoiceTotal").get(gui);
            
            sizeCombo = (JComboBox) ReflectionUtils.getPrivateField(guiClass, "gardenSizeComboBox").get(gui);
            
            customerAddress = (JTextField) ReflectionUtils.getPrivateField(guiClass, "customerAddressTextField").get(gui);
            customerName = (JTextField) ReflectionUtils.getPrivateField(guiClass, "customerNameTextField").get(gui);
            
            dateSpinner = gui.serviceDateSpinner;
            
            invoicePreview = gui.generateInvoicePreviewButton;
            saveInvoice = gui.saveInvoiceButton;
            
            
            
            
        }  catch (NoSuchFieldException ne) {
            fail("Create the GUI components with the names and types given. Could not find " + ne.getMessage());
        }
        catch (ClassNotFoundException cnfe) {
            fail("The GUI class in your program should be named GardenGUI and it should be in the week_8.garden package");
        }  catch (IllegalAccessException iae) {
            fail("Illegal access exception to your field. This may be a bug in the test, please report to Clara");
        }
        
    }
    
    
    @Test(timeout = 3000)
    public void testJComboBoxConfiguredCorrectly() {
        String msg ="Add 3 options to the JComboBox, small, medium and large, in that order. " +
                "Use the array in GardenServiceData as the source of data.";
        
        assertEquals(msg, GardenServiceData.gardenSizes.length, sizeCombo.getItemCount());
        for (int x = 0 ; x < sizeCombo.getItemCount() ; x++) {
            assertEquals(msg, GardenServiceData.gardenSizes[x], sizeCombo.getItemAt(x));
        }
        
    }
    
    
    @Test(timeout=3000)
    public void testTotalCalculationMathIndividually() {
        
        // Selecting items makes totals update?
        
        // Individually...
        
        individualTotal(leafCB, leafTotal, sizeCombo, GardenServiceData.LEAF_RAKING);
        individualTotal(mowCB, mowTotal, sizeCombo, GardenServiceData.MOWING);
    }
    
    
    @Test(timeout=3000)
    public void testTotalCalculationMathCombos() {
        
        // Some combinations
        
        leafCB.setSelected(true);
        mowCB.setSelected(true);
        
        // Medium garden, all services
        sizeCombo.setSelectedItem(GardenServiceData.gardenSizes[1]);
        double total = (GardenServiceData.LEAF_RAKING + GardenServiceData.MOWING) * GardenServiceData.MEDIUM_PRICE_MULTIPLY;
        assertTrue(invoiceTotal.getText().contains(toPrice(total)));
        
        // Small garden, all services
        sizeCombo.setSelectedItem(GardenServiceData.gardenSizes[0]);
        total = (GardenServiceData.LEAF_RAKING + GardenServiceData.MOWING);
        assertTrue(invoiceTotal.getText().contains(toPrice(total)));
        
        // Large garden, all services
        sizeCombo.setSelectedItem(GardenServiceData.gardenSizes[2]);
        total = (GardenServiceData.LEAF_RAKING + GardenServiceData.MOWING) * GardenServiceData.LARGE_PRICE_MULTIPLY;
        assertTrue(invoiceTotal.getText().contains(toPrice(total)));
        
        
        // Un-select leaves; currently at large
        leafCB.setSelected(false);
        total = (GardenServiceData.MOWING) * GardenServiceData.LARGE_PRICE_MULTIPLY;
        assertTrue(invoiceTotal.getText().contains(toPrice(total)));
        
        // Set to small
        sizeCombo.setSelectedItem(GardenServiceData.gardenSizes[0]);
        total = GardenServiceData.MOWING;
        assertTrue(invoiceTotal.getText().contains(toPrice(total)));
        
        // Un-select mowing, select leaves ; currently at small
        leafCB.setSelected(true);
        mowCB.setSelected(false);
        total = GardenServiceData.LEAF_RAKING;
        assertTrue(invoiceTotal.getText().contains(toPrice(total)));
        
        // Set to medium
        sizeCombo.setSelectedItem(GardenServiceData.gardenSizes[1]);
        total = GardenServiceData.LEAF_RAKING * GardenServiceData.MEDIUM_PRICE_MULTIPLY;
        assertTrue(invoiceTotal.getText().contains(toPrice(total)));
        
        // Set to large
        sizeCombo.setSelectedItem(GardenServiceData.gardenSizes[2]);
        total = GardenServiceData.LEAF_RAKING * GardenServiceData.LARGE_PRICE_MULTIPLY;
        assertTrue(invoiceTotal.getText().contains(toPrice(total)));
        
    }
    
    @Test(timeout=3000)
    public void testZerosShownWhenNothingSelected() {
        
        // Un-select all services. Totals should be zero
        
        leafCB.setSelected(false);
        mowCB.setSelected(false);
        
        String msg = "When no services are selected, the total shown in invoiceTotal JLabel should be 0.00 or $0.00, with 2 decimal places.";
        assertTrue(msg, invoiceTotal.getText().contains("0.00"));
        
        sizeCombo.setSelectedItem(GardenServiceData.gardenSizes[1]);
        assertTrue(msg, invoiceTotal.getText().contains("0.00"));
        
        sizeCombo.setSelectedItem(GardenServiceData.gardenSizes[0]);
        assertTrue(msg, invoiceTotal.getText().contains("0.00"));
        
        sizeCombo.setSelectedItem(GardenServiceData.gardenSizes[2]);
        assertTrue(msg, invoiceTotal.getText().contains("0.00"));
        
    }
    
    
    @Test
    public void testValidInvoiceCreation() {
        
        // Invoice generation
        
        leafCB.setSelected(true);
        mowCB.setSelected(true);
        sizeCombo.setSelectedItem(GardenServiceData.gardenSizes[1]);
        gui.generateInvoicePreviewButton.doClick();
        
        customerName.setText("Bob Ross");
        customerAddress.setText("123 Lyndale");
        
        dateSpinner.getModel().setValue(new Date());
        
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-YYYY");
        String dateString = format.format(new Date());
        
        invoicePreview.doClick();
        
        // Assert JTextArea contains expected invoice
        
        HashMap<String, String> map = new HashMap<>();
        map.put("NAME", "Bob Ross");
        map.put("ADDRESS", "123 Lyndale");
        map.put("DATE", dateString);
        map.put("GARDEN_SIZE", "Medium");
        map.put("MOWING", "30.00");
        map.put("LEAVES", "24.00");
        map.put("TOTAL", "54.00");
        
        String invoiceTxt = InvoiceGenerator.generate(map);
        
        assertEquals("Check that the invoice follows the format requested. Check the date and numbers are in the right format. " +
                "Click the  <Click to see difference> link to see what is different.", invoiceTxt, gui.invoicePreviewTextArea.getText());
    }
    
    
    @Test
    public void testNoInvoiceCreatedWithoutValidData() {
        
        // Nothing entered - no services selected. An error dialog should be shown, and the invoice preview should be cleared
        
        leafCB.setSelected(false);
        mowCB.setSelected(false);
        invoicePreview.doClick();
        
        // Assert error dialog is shown
        assertTrue("If no services are selected, show an error dialog when the generateInvoicePreviewButton is clicked. Use the method provided in GardenGUI", gui.getMessageDialogWasCalled());
        assertEquals("If no services are selected, clear the invoice preview. There should be no text in the invoicePreviewTextArea", "", gui.invoicePreviewTextArea.getText().trim());
        
        customerName.setText("Test");
        customerAddress.setText("");
        invoicePreview.doClick();
        
        assertTrue("If no customer address is provided, show an error dialog when the generateInvoicePreviewButton is clicked. Use the method provided in GardenGUI", gui.getMessageDialogWasCalled());
        assertEquals("If no customer address is provided, clear the invoice preview. There should be no text in the invoicePreviewTextArea", "", gui.invoicePreviewTextArea.getText().trim());
        
        
        customerName.setText("");
        customerAddress.setText("Test");
        invoicePreview.doClick();
        
        assertTrue("If no customer name is provided, show an error dialog when the generateInvoicePreviewButton is clicked. Use the method provided in GardenGUI", gui.getMessageDialogWasCalled());
        assertEquals("If no customer name is provided, clear the invoice preview. There should be no text in the invoicePreviewTextArea", "", gui.invoicePreviewTextArea.getText().trim());
    }
    
    
    private void individualTotal(JCheckBox cb, JLabel total, JComboBox sizeCombo, double basePrice) {
        
        cb.setSelected(true);
        
        sizeCombo.getModel().setSelectedItem(GardenServiceData.gardenSizes[0]);  // small
        assertTrue("When " + cb.getText() + " checkbox is selected and size is small, total JLabel should contain " + basePrice,
                total.getText().contains("" + basePrice));
        
        sizeCombo.getModel().setSelectedItem(GardenServiceData.gardenSizes[1]);  // medium
        assertTrue("When " + cb.getText() + " checkbox is selected and size is medium, total JLabel should contain " + basePrice * GardenServiceData.MEDIUM_PRICE_MULTIPLY,
                total.getText().contains("" + basePrice * GardenServiceData.MEDIUM_PRICE_MULTIPLY));
        
        sizeCombo.getModel().setSelectedItem(GardenServiceData.gardenSizes[2]);  // lg
        assertTrue("When " + cb.getText() + " checkbox is selected and size is large, total JLabel should contain " + basePrice  * GardenServiceData.LARGE_PRICE_MULTIPLY,
                total.getText().contains("" + basePrice * GardenServiceData.LARGE_PRICE_MULTIPLY));
        
        
        cb.setSelected(false);
        
        sizeCombo.getModel().setSelectedItem(GardenServiceData.gardenSizes[0]);  // small
        assertTrue("When checkbox is not selected and size is small, total JLabel should read 0.00 ", total.getText().contains("0.00"));
        
        sizeCombo.getModel().setSelectedItem(GardenServiceData.gardenSizes[1]);  // medium
        assertTrue("When checkbox is not selected and size is medium, total JLabel should read 0.00 ", total.getText().contains("0.00"));
        
        sizeCombo.getModel().setSelectedItem(GardenServiceData.gardenSizes[2]);  // lg
        assertTrue("When checkbox is not selected and size is large, total JLabel should read 0.00 ", total.getText().contains("0.00"));
        
        
        
    }
    
    @Test(timeout = 3000)
    public void testInvoiceNotSavedIfNoInvoice() {
        
        gui.invoicePreviewTextArea.setText("");
        saveInvoice.doClick();
        
        assertTrue("Show a message dialog if invoice preview area is empty", gui.wasMsgDialogCalled );
        
    }
    
    
    @Test(timeout = 3000)
    public void testInvoiceSaving() {
        
        String[] exampleInvoiceText = { "This is some example invoice text", "1234567", "Moo Baa Quack"};
        String exampleCustomerName = "Jackie Kennedy";
        Date exampleServiceDate = new Date();
        
        gui.invoicePreviewTextArea.setText("This is some example invoice text\n1234567\nMoo Baa Quack\n");
        
        gui.customerNameTextField.setText(exampleCustomerName);
        
        gui.serviceDateSpinner.getModel().setValue(exampleServiceDate);
        
        String expectedFilename = InvoiceWriter.createFileName(exampleCustomerName, exampleServiceDate);
        
        // Click the save button
        
        gui.saveInvoiceButton.doClick();
        
        // This file should exist
        
        File invoiceFile = new File(InvoiceWriter.INVOICE_DIRECTORY, expectedFilename);
        assertTrue("For a customer called " + exampleCustomerName + " service on " + exampleServiceDate +
                " the invoice should be saved at " + expectedFilename , invoiceFile.exists());
        
        assertTrue("Ensure that the exact text in the invoicePreviewTextArea is written to the invoice file" , fileContentsSameAsString(invoiceFile, exampleInvoiceText));
        
        // Move file generated in test to temp file storage.
        FileUtils.moveToTemporaryTestFolder(invoiceFile);
        
    }
    
    @Test
    public void testHasScreenshots() {
        fail("Take some screenshots of your GUI and add them to the screenshots directory. " +
                "\nThis test will always fail and will be graded manually.");
    }
}