import java.util.HashMap;

public class GraphAdjacencyList {

	HashMap<String, HashMap<String, Double>> nodes = null;

	public GraphAdjacencyList() {
		nodes = new HashMap<String, HashMap<String, Double>>();
	}

	/**
	 * 
	 * @param startPoint : String : Label of the graph node
	 * @param endPoint : String : Label of the graph node
	 * @param weight : double : represents the value between 2 connected nodes
	 */
	public void addEdge(String startPoint, String endPoint, double weight) {

		if(this.getNodes().containsKey(startPoint) == false) {
			this.getNodes().put(startPoint, new HashMap<String, Double>());
		}

		this.getNodes().get(startPoint).put(endPoint, weight);
	}


	/**
	 * @param startPoint : String : Label of the graph node
	 * @param endPoint : String : Label of the graph node
	 */
	public void removeEdge(String startPoint, String endPoint) {

		if(this.getNodes().containsKey(startPoint) == false) {
			System.err.println("Graph has no node as "+startPoint);
			return;
		}

		if ( this.getNodes().get(startPoint).containsKey(endPoint) == false ) {
			System.err.println("Graph has no edge between "+startPoint+" and "+endPoint);
			return;
		}

		this.getNodes().get(startPoint).remove(endPoint);
	}

	
	/**
	 * @param startPoint : String : Label of the graph node
	 * @param endPoint : String : Label of the graph node
	 * @param weight : double : New weight of the edge
	 */
	public void updateWeight(String startPoint, String endPoint, double weight) {

		if(this.getNodes().containsKey(startPoint) == false) {
			System.err.println("Graph has no node as "+startPoint);
			return;
		}

		if ( this.getNodes().get(startPoint).containsKey(endPoint) == false ) {
			System.err.println("Graph has no edge between "+startPoint+" and "+endPoint);
			return;
		}

		this.getNodes().get(startPoint).put(endPoint, weight);
	}


	/**
	 * Returns all the connected nodes from the given point
	 * @param nodeLabel : String : Node whos connected nodes are requirements
	 * @return : HashMap<String, Double> : Connected nodes and respective weights
	 */
	public HashMap<String, Double> getAllConnectedNodes(String nodeLabel) {

		if ( this.getNodes().containsKey(nodeLabel) == false ) {
			return null;
		}

		return this.getNodes().get(nodeLabel);
	}


	@Override
	public String toString() {

		StringBuilder graphString = new StringBuilder();

		for(String node : this.getNodes().keySet()) {

			graphString.append(node).append(" ==> ");

			HashMap<String, Double> linkedNodes = this.getNodes().get(node);

			for(String linkedNode : linkedNodes.keySet()) {
				graphString.append("[").append(linkedNode).append(",").append(linkedNodes.get(linkedNode)).append("]").append(",");
			}

			graphString.append("\n");

		}

		return graphString.toString();
	}

	public HashMap<String, HashMap<String, Double>> getNodes() {
		return nodes;
	}

	public void setNodes(HashMap<String, HashMap<String, Double>> nodes) {
		this.nodes = nodes;
	}




}
