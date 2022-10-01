import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    
    /**
     * It reads a csv file and returns an object of type Airports if the airportId or airportCode matches
     * the airportId or airportCode in the csv file
     * 
     * @param airportId The IATA code of the airport
     * @param airportCode "1"
     * @return The method is returning an object of type Airports.
     */
    public static Airports getAirports(String airportId, String airportCode) throws IOException{
        System.out.println(airportId);
        FileReader airportReader = new FileReader("airports.csv");
        BufferedReader airportData = new BufferedReader(airportReader);
        String line;
        while((line = airportData.readLine()) != null){
            String[] lineList = line.split(",");
            Integer airportId2 = Integer.parseInt(lineList[0]);
            String airportName = lineList[1];
            String airportCity = lineList[2];
            String airportCountry = lineList[3];
            String iata = lineList[4];


            if(iata.equals(airportId)){
                return new Airports(airportId2, airportName, airportCity, airportCountry, iata);
            }

            if(Integer.toString(airportId2).equals(airportCode)){
                return new Airports(airportId2, airportName, airportCity, airportCountry, iata);
            }
            
        }
        return null;

        
    }

    /**
 * It reads the routes.csv file and returns a list of routes that start from the airport with the given
 * airportId
 * 
 * @param airportId The airport id of the airport you want to get the routes from.
 * @return A list of routes
 */
public static List<Routes> getActions(String airportId) throws IOException{
    FileReader routesReader = new FileReader("routes.csv");
    BufferedReader routeFile = new BufferedReader(routesReader);
    String line;
    List<Routes> actions = new ArrayList();
    while((line = routeFile.readLine()) != null){
        String[] lineList = line.split(",");
        String airlineCode = lineList[0];
        String airlineId = lineList[1];
        String startCode = lineList[2];
        String startId = lineList[3];
        String destinationCode = lineList[4];
        String destinationId = lineList[5];
        Integer stops = Integer.parseInt(lineList[7]);

        if(airportId.equals(startId) ){

            actions.add(new Routes(airlineCode, airlineId, startCode, startId, destinationCode, destinationId,stops));
        }
    }
    routeFile.close();
    return actions;
}
}
