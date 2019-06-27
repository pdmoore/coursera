package pdm;

import static org.junit.Assert.*;

import java.util.StringTokenizer;

import org.junit.Test;

public class GraphTest {

	@Test
	public void test() {

		String input = "1 2";
		
		Node actualNode = readNode(input);
		
		Node expectedNode = new Node(1);
		expectedNode.edgeTo(2);
		
		assertEquals(1, actualNode.getId());
		
//		
//		1 2
//		1 3
//		1 4
//		2 3
//		2 4
//		3 4
	}

	private Node readNode(String input) {
		StringTokenizer tok = new StringTokenizer(input);
		Node node = new Node(Integer.parseInt((String) tok.nextElement()));
		node.edgeTo(Integer.parseInt((String) tok.nextElement()));
		return node;
	}

}
