/**
 * @author Abdul Wahab Abass 
*/

import java.io.* ;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SearchAlgo {

// Setting the start airport and the destination airport to the airport id, the airport name, the
// airport city, the airport country and the iata.
    private Airports startAirport;
    private Airports destinationAirport;
    private FileWriter outputWriter;
/**
 * This function returns the startAirport variable
 * 
 * @return The startAirport object.
 */
    public Airports getStartAirport() {
        return startAirport;
    }

/**
 * This function sets the startAirport variable to the value of the startAirport parameter
 * 
 * @param startAirport The airport where the flight starts
 */
    public void setStartAirport(Airports startAirport) {
        this.startAirport = startAirport;
    }

/**
 * This function returns the destination airport of the flight
 * 
 * @return The destination airport.
 */
    public Airports getDestinationAirport() {
        return destinationAirport;
    }

/**
 * This function sets the destination airport of the flight
 * 
 * @param destinationAirport Airports
 */
    public void setDestinationAirport(Airports destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

 /**
    * Reading the input file and the airport file and then it is splitting the input file into two parts,
    * the start city and the destination city. Then it is reading the airport file and it is splitting
    * the airport file into 5 parts, the airport id, the airport name, the airport city, the airport
    * country and the iata. Then it is checking if the airport city is equal to the start city and if it
    * is then it is setting the start airport to the airport id, the airport name, the airport city, the
    * airport country and the iata. Then it is checking if the airport city is equal to the destination
    * city and if it is then it is setting the destination airport to the airport id, the airport name,
    * the airport city, the airport country and the iata.
 */
    public SearchAlgo(String inputSrc, String outputSrc) throws IOException{
        FileReader inputReader = new FileReader(inputSrc);
        FileReader airportReader = new FileReader("airports.csv");
        outputWriter = new FileWriter(String.format("%s_output.txt",inputSrc.replace(".txt", "")));
        BufferedReader inputData = new BufferedReader(inputReader);
        BufferedReader airportData = new BufferedReader(airportReader);
        String[] startData = inputData.readLine().split(",");
        String[] destData = inputData.readLine().split(",");
        String startCity = startData[0];
        String startCountry = startData[1];
        String destinationCity = destData[0];
        String destinationCountry = destData[1];
        String line;
        while((line = airportData.readLine()) != null){
            String[] lineList = line.split(",");
            Integer airportId = Integer.parseInt(lineList[0]);
            String airportName = lineList[1];
            String airportCity = lineList[2];
            String airportCountry = lineList[3];
            String iata = lineList[4];

            if(airportCity.equals(startCity)){
                startAirport = new Airports(airportId, airportName, airportCity, airportCountry, iata);
            }

            if(airportCity.equals(destinationCity)){
                destinationAirport = new Airports(airportId, airportName, airportCity, airportCountry, iata);
            }
        }
        inputData.close();
        airportData.close();
    }

/**
     * It takes in a start and end airport, and returns a node that contains the path from the start to the
     * end airportq
     * 
     * @param start The starting airport
     * @param end The destination airport
     * @return A node object
 */
    public Node generatePath(Airports start, Airports end) throws IOException{
        HashSet<String> explored = new HashSet<>();
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(new Node(start));
        while(!frontier.isEmpty()){
            Node node = frontier.poll();
            explored.add(node.getState().getIata());
            // Checking if the airport city is equal to the start city and if it is then it is setting
            // the start airport to the airport id, the airport name, the airport city, the airport
            // country and the iata. Then it is checking if the airport city is equal to the
            // destination city and if it is then it is setting the destination airport to the airport
            // id, the airport name, the airport city, the airport country and the iata.
            for(Routes route: DataReader.getActions(Integer.toString(node.getState().getAirportID()))){
                try{
                    System.out.println(route);
                    Node neighbor = new Node(node, route.getAirlineCode(), route.getStops(), DataReader.getAirports(route.getDestinationAirportcode(), route.getDestinationAairportID()));
                    // System.out.println(route.getSourceairportCode());
                    if(neighbor.getState().getIata().equals(end.getIata())){
                        return neighbor;
                    }
                    if(!explored.contains(neighbor.getState().getIata()) && !frontier.contains(neighbor)){
                        frontier.add(neighbor);
                    }
                }catch(NullPointerException npe){
                    npe.printStackTrace();
                }
            
            }

        }
        return null;
    }

/**
 * The main function is the entry point of the program. It creates a new PathFinding object, and then
 * calls the generatePath function to find the shortest path between the start and destination
 * airports. It then prints the solution path to the output file
 */
    public static void main(String[] args) throws Exception {
        try{
        
        SearchAlgo sa = new SearchAlgo("input.txt", "output.txt");

        Stack<Node> solutionStack = sa.generatePath(sa.getStartAirport(), sa.getDestinationAirport()).solutionPath();
        DataWriter.printToFile(solutionStack, sa.outputWriter);
        }
        catch( NullPointerException npe){
            npe.getStackTrace();
        }

        catch(NumberFormatException nfe){
            nfe.getStackTrace();
        }

       
    }
      
    
    
    
    
}
