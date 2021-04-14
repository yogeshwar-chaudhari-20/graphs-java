public class Main {

	public static void main(String[] args) {
		
		GraphAdjacencyList graph = new GraphAdjacencyList();
		graph.addEdge("1", "2", 7.5);
		graph.addEdge("1", "3", 7.5);
		graph.addEdge("2", "4", 7.5);
		graph.addEdge("3", "1", 7.5);
		
		System.out.println(graph.toString());
		
		GraphAdjacencyMatrix matGraph = new GraphAdjacencyMatrix(4);
		matGraph.addEdge(1, 2);
		matGraph.addEdge(1, 3);
		matGraph.addEdge(2, 4);
		matGraph.addEdge(3, 1);
		
		System.out.println(matGraph.toString());
		
		System.out.println(matGraph.getAllConnectedNodes(0));
		System.out.println(matGraph.getAllConnectedNodes(1));
	}

}