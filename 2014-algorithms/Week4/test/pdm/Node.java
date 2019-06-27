package pdm;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private int id;
	private List<Integer> edges;

	public Node(int nodeId) {
		this.id = nodeId;
		edges = new ArrayList<Integer>();
	}

	public void edgeTo(int otherNode) {
		edges.add(otherNode);
	}

	public int getId() {
		return this.id;
	}

}
