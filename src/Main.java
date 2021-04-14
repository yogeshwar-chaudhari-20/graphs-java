
public class Main {

	public static void main(String[] args) {
		
		GraphAdjacencyList graph = new GraphAdjacencyList();
		graph.addEdge("1", "2", 7.5);
		graph.addEdge("1", "3", 7.5);
		graph.addEdge("2", "4", 7.5);
		graph.addEdge("3", "1", 7.5);
		
		System.out.println(graph.toString());
	}

}
