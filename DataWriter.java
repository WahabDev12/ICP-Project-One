import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class DataWriter {
    /**
 * This function takes a stack of nodes as a parameter and writes the flight information of each node
 * to a file called output.txt
 * 
 * @param solution Stack of nodes that represent the solution path
 */
public static void printToFile(Stack<Node> solution, FileWriter outputWriter) throws IOException{
    BufferedWriter file = new BufferedWriter(outputWriter);
    while(!solution.isEmpty()){
        Node node = solution.pop();
        if(node.getParent() != null){
            file.write(node.getFlight() + " from " + node.getParent().getState().getIata() + " to " + node.getState().getIata() + "\n");
        }
    }
    file.close();
}
}
