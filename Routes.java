/**
 * @author Abdul Wahab Abass 
 */

class Routes{
    private String airlineCode;
    private String airlineID ;
    private String sourceairportCode;
    private String sourceairportID;
    private String destinationAirportcode;


    private Integer stops;
    
/**
 * This function returns the number of stops
 * 
 * @return The stops variable is being returned.
 */
    public Integer getStops() {
        return stops;
    }

/**
 * It returns the airline code.
 * 
 * @return The airline code.
 */
    public String getAirlineCode() {
        return airlineCode;
    }

/**
 * It returns the airlineID.
 * 
 * @return The airlineID is being returned.
 */
    public String getAirlineID() {
        return airlineID;
    }

/**
 * It returns the sourceairportCode.
 * 
 * @return The sourceairportCode is being returned.
 */
    public String getSourceairportCode() {
        return sourceairportCode;
    }

/**
 * This function returns the sourceairportID of the flight
 * 
 * @return The sourceairportID is being returned.
 */
    public String getSourceairportID() {
        return sourceairportID;
    }

/**
 * This function returns the destination airport code.
 * 
 * @return The destination airport code.
 */
    public String getDestinationAirportcode() {
        return destinationAirportcode;
    }

// A getter method for the destinationAairportID.
    private String destinationAairportID;
    public String getDestinationAairportID() {
        return destinationAairportID;
    }

// A constructor.
    public Routes(String airlineCode, String airlineID, String sourceairportCode, String sourceairportID,
            String destinationAirportcode, String destinationAairportID, Integer stops) {
        this.airlineCode = airlineCode;
        this.airlineID = airlineID;
        this.sourceairportCode = sourceairportCode;
        this.sourceairportID = sourceairportID;
        this.destinationAirportcode = destinationAirportcode;
        this.destinationAairportID = destinationAairportID;
        this.stops = stops;
    }

    private String codeshare;

    private String equipment;

// Overriding the toString method.
    @Override
    public String toString() {
        return "Routes [airlineCode=" + airlineCode + ", airlineID=" + airlineID + ", codeshare=" + codeshare
                + ", destinationAairportID=" + destinationAairportID + ", destinationAirportcode="
                + destinationAirportcode + ", equipment=" + equipment + ", sourceairportID=" + sourceairportID
                + ", sourceairportCode=" + sourceairportCode + ", stops=" + stops + "]";}


    }