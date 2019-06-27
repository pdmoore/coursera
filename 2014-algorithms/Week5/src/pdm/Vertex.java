package pdm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vertex {
	int ID;
	List<Edge> edges = new ArrayList<Edge>();

	public Vertex(int ID) {
		this.ID = ID;
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}

	public String toString() {
		return "vertex: " + ID + "   has " + edges.size() + " edges";
	}

	public String dumpEdges() {
		StringBuffer buf = new StringBuffer();
		for (Iterator<Edge> iterator = edges.iterator(); iterator.hasNext();) {
			Edge edge = (Edge) iterator.next();
			buf.append(edge.toString());
			buf.append("\n");	
		}

		return buf.toString();
	}

	public int getID() {
		return ID;
	}
}
