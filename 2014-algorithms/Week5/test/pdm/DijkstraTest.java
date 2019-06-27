package pdm;

import java.util.StringTokenizer;

import org.junit.Test;

public class DijkstraTest {

	@Test
	public void test() {

		String[] input = new String[] { "1 2,7 3,9 6,14", "2 1,7 3,10 4,15",
				"3 1,9 2,10 4,11 6,2", "4 2,15 3,11 5,6", "5 4,6 6,9",
				"6 1,14 3,2 5,9", };

		Grap_Xh g = new Grap_Xh();
		for (String parsing : input) {
			StringTokenizer tok = new StringTokenizer(parsing);
			Integer nodeID = Integer.parseInt((String) tok.nextElement());
			Vertex v = new Vertex(nodeID);
			while (tok.hasMoreElements()) {
				// create edge from
				String edgePair = (String) tok.nextElement();
				String[] parts = edgePair.split(",");
				Edge edge = new Edge(nodeID, Integer.parseInt(parts[0]),
						Integer.parseInt(parts[1]));

				v.addEdge(edge);
				g.addEdge(edge);
			}
			g.addVertex(v);
		}

	
		
	
	}

}
