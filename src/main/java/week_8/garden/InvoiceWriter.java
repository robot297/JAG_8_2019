package week_8.garden;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Handles writing invoices to disk.
 */

public class InvoiceWriter {
    
    private static String dateFormatString = "mmm_dd_yyyy";   // e.g. "sep_09_2017"
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatString);
    
    
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
    
    
    /* Check to see if a file with the given filename or path exists. */
    public static boolean doesFileExist(String filepath) {
        File f = new File(filepath);
        return f.exists();
    }
    
    
    public static boolean writeToFile(String filename, String text) {
    
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(filename))) {
            
            writer.write(text);
            writer.close();
            return true;
            
        } catch (IOException e) {
            System.out.println("Unable to write to file " + filename + ". Error message:\n" + e.getMessage());
            return false;
        }
    }
}
