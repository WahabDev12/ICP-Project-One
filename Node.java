import java.util.Stack;

public class Node {
    private Node parent;
    private String flight;
    private Integer stops;
    private Airports state;
    
    
    public Node(Airports state) {
        this.state = state;
    }
    public Node(Node parent, String flight, Integer stops, Airports state) {
        this.parent = parent;
        this.flight = flight;
        this.stops = stops;
        this.state = state;
    }
    public Node getParent() {
        return parent;
    }
    public String getFlight() {
        return flight;
    }
    public Integer getStops() {
        return stops;
    }
   
    public Airports getState() {
        return state;
    }

   /**
    * It returns a stack of nodes that represents the solution path from the current node to the root
    * node
    * 
    * @return The solution path is being returned.
    */
    public Stack<Node> solutionPath(){
        Node node = this;
        Stack<Node> solution = new Stack<>();
        while(node != null){
            solution.push(node);
            node = node.parent;
        }
        return solution;
    }
    /**
     * The function takes in a list of flights, a list of nodes, and a list of nodes that have been
     * visited. It then creates a new list of nodes that are the children of the nodes in the list of
     * nodes
     * 
     * @return The flight, parent, state, and stops of the node.
     */
    @Override
    public String toString() {
        return "Node [flight=" + flight + ", parent=" + parent + ", state=" + state + ", stops=" + stops + "]";
    }
    /**
     * The hashCode() function returns a unique integer for each unique object
     * 
     * @return The hashcode of the state.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }
   /**
    * If the two objects are the same, return true. If the object is null, return false. If the two
    * objects are not the same class, return false. If the two objects are the same class, return true
    * 
    * @param obj The object to compare with.
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        return true;
    }
}
