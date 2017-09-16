package week_8.garden;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StrSubstitutor;

import java.util.HashMap;

/**
 * Created by clara on 9/15/17.
 */
public class InvoiceGenerator {
    
    static final String NAME = "NAME";
    static final String ADDRESS = "ADDRESS";
    static final String DATE = "DATE";
    static final String GARDEN_SIZE = "GARDEN_SIZE";
    static final String MOWING = "MOWING";
    static final String LEAVES = "LEAVES";
    static final String WEEDS = "WEEDS";
    static final String TOTAL = "TOTAL";
    
    static String invoiceTemplate;
    
    /* Provide a HashMap with the following keys, and String values.
    
    NAME
    ADDRESS
    DATE
    GARDEN_SIZE
    MOWING
    LEAVES
    WEEDS
    TOTAL
    
    Notice these Strings are provided as constants in this class.
    */
    
    
    public static String generate(HashMap<String, String> data) {
        
        StrSubstitutor sub = new StrSubstitutor(data);
        String invoice = sub.replace(invoiceTemplate);
        return invoice;
    }
    
    
  
    
    static int width = 80;
    
    static String lines[] = {
            "************ Garden Services Invoice ************",
            "Rose the Gardener, 123 Main Street, Minneapolis. Telephone 612-123-4567",
            "",
            "Customer Name: {NAME}",
            "Address of garden: {ADDRESS}",
            "",
            "Date of service: {DATE}",
            "Size of garden: {GARDEN_SIZE}",
            "",
            "Lawn mowing service charge: ${MOWING}",
            "Leaf raking service charge: ${LEAVES}",
            "Weed pulling service charge: ${WEEDS}",
            "",
            "Total: ${TOTAL}",
            "",
            "Please send payment to the address above.",
            "Thank you for your business."
    } ;
    
    
    static {
        
        // Center the lines and concatenate together
        StringBuilder builder = new StringBuilder();
        
        for (String line: lines) {
            String l = StringUtils.center(line, width);
            builder.append(l);
        }
        invoiceTemplate = builder.toString();
    }
    
    
}
