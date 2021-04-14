import java.util.ArrayList;

/**
 * Graph implementation using Adjacency Matrix
 * To be used when graph is dense and frequent searching is required in constant time.
 * Also when addition is not so frequent as adding missing nodes requires to copy old array increasing the complexity.
 * @author Yogeshwar Chaudhari
 *
 */
public class GraphAdjacencyMatrix {

	boolean nodes [][] = null;
	int numberOfNodes = 0;

	public GraphAdjacencyMatrix(int numberOfNodes) {

		this.numberOfNodes = numberOfNodes;
		this.nodes = new boolean[numberOfNodes][numberOfNodes];
	}

	/**
	 * Adds edge between the given points.
	 * @param startPoint : Node in graph : Must be in graph otherwise, graph needs to be resized.
	 * @param endPoint : Node in graph : Must be in graph otherwise, graph needs to be resized.
	 */
	public void addEdge(int startPoint, int endPoint) {

		try {

			(this.getNodes())[startPoint][endPoint] = true;

		}catch(ArrayIndexOutOfBoundsException ae) {

			// Point to be added in not in the graph
			int max = Math.max(startPoint, endPoint);

			boolean resizedMat[][] = this.resizeGraph(max+1);

			// Update number of nodes and graph itself
			this.setNumberOfNodes(max);
			this.setNodes(resizedMat);

			// Update the edge
			(this.getNodes())[startPoint][endPoint] = true;
		}
	}


	/**
	 * Creates a new graph, using new number of nodes and copies the old graph into the new graph
	 * @param max : Number of nodes in new graph
	 * @return : New graph containing more number of nodes and old connections
	 */
	public boolean[][] resizeGraph(int max) {

		boolean newMatrix[][] = new boolean[max][max];
		for (int i = 0; i < this.getNumberOfNodes(); i++) {
			int j = 0;
			for (boolean isConnected : (this.getNodes())[i]) {
				newMatrix[i][j] = isConnected;
				j++;
			}
		}

		return newMatrix;
	}

	/**
	 * 
	 * @param startPoint : Node in graph
	 * @param endPoint
	 */
	public void removeEdge(int startPoint, int endPoint) {

		try {
			(this.getNodes())[startPoint][endPoint] = false;
		}catch (Exception e) {
			System.err.println("Graph does not have either "+startPoint+" or "+endPoint);
		}

	}

	public void updateEdge(int startPoint, int endPoint, boolean isConnected) {

		try {
			(this.getNodes())[startPoint][endPoint] = isConnected;
		}catch (Exception e) {
			System.err.println("Graph does not have either "+startPoint+" or "+endPoint);
		}

	}

	/**
	 * Returns list of all nodes that are connected to the given point.
	 * i.e if there is true at [i][j]
	 * @param fromNode : The node from which you are looking connected points
	 */
	public ArrayList<Integer> getAllConnectedNodes(int fromNode) {

		ArrayList<Integer> connectedNodes = new ArrayList<Integer>();

		int j = 0;
		for (boolean isConnected : (this.getNodes())[fromNode]) {
			if(isConnected) {
				connectedNodes.add(j);
			}
			j++;
		}
		
		return connectedNodes;

	}

	@Override
	public String toString() {

		StringBuilder s = new StringBuilder();
		for (int i = 0; i < this.getNumberOfNodes(); i++) {
			s.append(i + ": ");
			for (boolean j : (this.getNodes())[i]) {
				s.append((j ? 1 : 0) + " ");
			}
			s.append("\n");
		}

		return s.toString();
	}


	// Getter setter starts here
	public boolean[][] getNodes() {
		return nodes;
	}

	public void setNodes(boolean[][] nodes) {
		this.nodes = nodes;
	}

	public int getNumberOfNodes() {
		return numberOfNodes;
	}

	public void setNumberOfNodes(int numberOfNodes) {
		this.numberOfNodes = numberOfNodes;
	}

	// Getter setter ends here

}
