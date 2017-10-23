package week_8.garden;

/**
 * Constants to represent price of each service.
 * A future program would read these from a data store, and/or permit modification
 */
public class GardenServiceData {
    
    static String[] gardenSizes = {"Small", "Medium", "Large"};
    
    // Prices of services
    
    static final double MOWING = 15;
    static final double LEAF_RAKING = 12;
    
    static final double MEDIUM_PRICE_MULTIPLY = 2;
    static final double LARGE_PRICE_MULTIPLY = 3;
    
    // Example gardener contact String, used when generating invoices
    
    static final String gardenerContactString = "Rose the Gardener, 123 Main Street, Minneapolis. Telephone 612-123-4567";
    
}
