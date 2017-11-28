package week_8.garden;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Handles writing invoices to disk. Invoices are saved in the
 * directory given by INVOICE_DIRECTORY.
 *
 * You should not need to modify this file, but you will need to call methods.
 */

public class InvoiceWriter {
    
    static final String INVOICE_DIRECTORY = "GardeningInvoices";
    
    private static String dateFormatString = "MMM_dd_yyyy";   // e.g. "sep_09_2017"
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatString);
    
    
    static {
        
        File invoiceDir = new File(INVOICE_DIRECTORY);
        try {
            invoiceDir.mkdir();
        } catch (SecurityException e) {
            if (!invoiceDir.exists()) {
                System.out.println("ERROR - could not create Invoice Directory.  " + INVOICE_DIRECTORY);
            }
            
            // Otherwise, if it exists, presumably it has already been created, so no problem.
        }
    }
    
    
    /*
     Create a valid filename from a date, and the customer's name.
     Names may have characters that are not permitted in filenames, these must be removed or replaced.
     This is a very basic solution: remove all characters from customer name that are not A-Z or a-z.
     This could definitely be improved. There are many names that would be distorted by this method.
     This would perform poorly on names with characters outside A-Z and a-z. What if a customer has several characters removed from their name?
     Many characters outside A-Z and a-z range are valid filename characters.
     
     A more exhaustive solution to preserve names and create valid filenames would be more work, and more testing.
     Looking into a 3rd party library to handle this would be recommended in a real program; it's a fairly common problem.
     You are not required to improve this method; but you are welcome to contribute an improved version if you like :)
      */
    
    public static String createFileName(String customer, Date date) {
        
        String name = removeBannedCharacters(customer);
        if (name.length() == 0) {
            name = "Customer";   // Something, if there are no valid filename characters. Can you think of a better solution? Ask the user for a name?
        }
        
        // Format the date into a String
        String dateString = simpleDateFormat.format(date);
        
        String filename = String.format("%s_%s_invoice.txt", name, dateString);
        
        return filename;
        
    }
    
    
    protected static String removeBannedCharacters(String st) {
        return st.replaceAll("[^A-Za-z]", "");
    }
    
    
    /* Warning! This method overwrites an existing file. A real program
    * should warn the user that a file with the proposed name exists, and offer them
    * the choice to overwrite or give a new name. */
    
    public static boolean writeToFile(String filename, String text) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(INVOICE_DIRECTORY, filename)))) {
            
            writer.write(text);
            writer.close();
            return true;
            
        } catch (IOException e) {
            System.out.println("Unable to write to file " + filename + ". Error message:\n" + e.getMessage());
            return false;
        }
    }
}
