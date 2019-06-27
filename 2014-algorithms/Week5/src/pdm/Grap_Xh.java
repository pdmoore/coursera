package pdm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Grap_Xh {

	List<Vertex> vertices = new ArrayList<Vertex>();
	List<Edge> edges = new ArrayList<Edge>();

	public void addVertex(Vertex v) {
		vertices.add(v);
	}

	public void addEdge(Edge e) {
		edges.add(e);
	}

	public Collection<Vertex> getVertexes() {
		return vertices;
	}

	public Collection<Edge> getEdges() {
		return edges;
	}

}
