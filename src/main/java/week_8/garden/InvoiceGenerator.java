package week_8.garden;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StrSubstitutor;

import java.util.HashMap;

/**
 * Created by clara on 9/15/17.
 */
public class InvoiceGenerator {
    
    
    static String invoiceTemplate;
    
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
            "Size of garden: {SIZE}",
            "",
            "Lawn mowing service charge: {LAWN}",
            "Leaf raking service charge: {LEAVES}",
            "Weed pulling service charge: {WEEDs}",
            "",
            "Total: {TOTAL}",
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
