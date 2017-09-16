package week_8.garden;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class GardenInvoiceTest {
    @Test
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