package week_8.garden;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StrSubstitutor;

import java.util.HashMap;

/**
 * Created by clara on 9/15/17. You should not need to modify this file,
 * but you will need to call the methods here.
 */


public class InvoiceGenerator {
    
    static final String GARDENER_CONTACT = "GARDENER_CONTACT";
    
    
    static final String NAME = "NAME";
    static final String ADDRESS = "ADDRESS";
    static final String DATE = "DATE";
    static final String GARDEN_SIZE = "GARDEN_SIZE";
    static final String MOWING = "MOWING";
    static final String LEAVES = "LEAVES";
    static final String TOTAL = "TOTAL";
    
    static String invoiceTemplate;
    
    /* Provide a HashMap with the following keys, and String values.
    
    NAME
    ADDRESS
    DATE
    GARDEN_SIZE
    MOWING
    LEAVES
    TOTAL
    
    Notice these Strings are provided as constants in this class.
    
    For a price, the value should be a String number with 2 decimal places,
    and no $ or other currency symbol, e.g. "28.00" or "14.00"
    
    For a date, provide a String in the format "05-30-2017" (for May 30 2017)
     
    */
    
    
    public static String generate(HashMap<String, String> data) {
        
        // Add in the gardener info String
        data.put(GARDENER_CONTACT, GardenServiceData.gardenerContactString);
        
        // Create a String Substitutor with the HashMap
        StrSubstitutor sub = new StrSubstitutor(data);

        //Use our own template prefix
        sub.setVariablePrefix("&{");
        String invoice = sub.replace(invoiceTemplate);
        return invoice;
    }
    
    
  
    
    static int width = 80;
    
    static String lines[] = {
            StringUtils.center("************ Garden Services Invoice ************", width),
            "",
            "&{GARDENER_CONTACT}",
            "",
            "Customer Name: &{NAME}",
            "Address of garden: &{ADDRESS}",
            "",
            "Date of service: &{DATE}",
            "Size of garden: &{GARDEN_SIZE}",
            "",
            "Lawn mowing service charge: $ &{MOWING}",
            "Leaf raking service charge: $ &{LEAVES}",
            "",
            "Total: $ &{TOTAL}",
            "",
            "Please send payment to the address above.",
            "Thank you for your business."
    } ;
    
    
    static {
        
        // Center the lines and concatenate together
        StringBuilder builder = new StringBuilder();
        
        for (String line: lines) {
            builder.append(line);
            builder.append("\n");
        }
        invoiceTemplate = builder.toString();
    }
    
    
}
