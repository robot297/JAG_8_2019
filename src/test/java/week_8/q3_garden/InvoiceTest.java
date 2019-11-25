package week_8.q3_garden;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by clara on 11/13/19.
 * These tests should pass already. They are not part of your grade.
 */

public class InvoiceTest {
    
    @Test(timeout = 3000)
    public void testInvoiceGenerator() {
        
        Map<String, String> map = new HashMap<>();
        map.put("NAME", "Bob Ross");
        map.put("ADDRESS", "123 Lyndale");
        map.put("DATE", "12/12/12");
        map.put("GARDEN_SIZE", "Medium");
        map.put("MOWING", "11.11");
        map.put("LEAVES", "22.22");
        map.put("TOTAL", "33.33");
        
        
        String expectedOut = "************ Garden Services Invoice ************\n" +
                "\n" +
                GardenServiceData.gardenerContactString + "\n" +
                "\n" +
                "Customer Name: Bob Ross\n" +
                "Address of garden: 123 Lyndale\n" +
                "\n" +
                "Date of service: 12/12/12\n" +
                "Size of garden: Medium\n" +
                "\n" +
                "Lawn mowing service charge: $ 11.11\n" +
                "Leaf raking service charge: $ 22.22\n" +
                "\n" +
                "Total: $ 33.33\n" +
                "\n" +
                "Please send payment to the address above.\n" +
                "Thank you for your business.";
        
        String out = InvoiceGenerator.generate(map);
        
        assertEquals(expectedOut.trim(), out.trim());
    }
    
    
    @Test(timeout = 3000)
    public void removeBannedCharacters() throws Exception {
        
        assertEquals(InvoiceWriter.removeBannedCharacters("Nenê"), "Nen");
        assertEquals(InvoiceWriter.removeBannedCharacters("Teller"), "Teller");
        assertEquals(InvoiceWriter.removeBannedCharacters("Lady Gaga"), "LadyGaga");
        assertEquals(InvoiceWriter.removeBannedCharacters("Beyoncé Giselle Knowles-Carter"), "BeyoncGiselleKnowlesCarter");
        assertEquals(InvoiceWriter.removeBannedCharacters("Jacqueline Kennedy Onassis"), "JacquelineKennedyOnassis");
        assertEquals(InvoiceWriter.removeBannedCharacters("Rosie O'Donnell"), "RosieODonnell");
        
        assertEquals(InvoiceWriter.removeBannedCharacters("Rihanna6"), "Rihanna");
        assertEquals(InvoiceWriter.removeBannedCharacters("Rih^anna6"), "Rihanna");
        assertEquals(InvoiceWriter.removeBannedCharacters("34535Rihanna6"), "Rihanna");
        assertEquals(InvoiceWriter.removeBannedCharacters("Rihann$%^*a6"), "Rihanna");
        
        assertEquals(InvoiceWriter.removeBannedCharacters("4645665"), "");
        assertEquals(InvoiceWriter.removeBannedCharacters(""), "");
        assertEquals(InvoiceWriter.removeBannedCharacters("%^&$^"), "");
        
    }
    
}
