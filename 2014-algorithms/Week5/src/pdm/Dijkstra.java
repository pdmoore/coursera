package pdm;
 
public class Dijkstra {
 
  public static void main(String[] args) {
		// construct a graph based a file
		Graph graph1 = new Graph("dijkstraData.txt");
//		Graph graph1 = new Graph("smallGraph.txt");
 
		// call Dijkstra's algorithm
		graph1.pathDijkstra();
 
		// print out results as requested
		graph1.printOut();
	}
}