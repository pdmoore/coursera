package pdm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.Test;

public class minCutTest {

	@Test
	public void testParseLineOfNodeAndEdges() {
		HashMap<Integer, List<Integer>> expectedNodes = new HashMap<Integer, List<Integer>>();
		List<Integer> edges = new ArrayList<Integer>();
		edges.add(2);
		edges.add(3);
		edges.add(4);
		edges.add(7);
		expectedNodes.put(1, edges);
	
		HashMap<Integer, List<Integer>> actual = new HashMap<Integer, List<Integer>>();
		String line = "1 2 3 4 7";
		parseLine(line, actual);
		
		assertEquals(expectedNodes.keySet(), actual.keySet());
		assertEquals(expectedNodes.get(1).size(), actual.get(1).size());
	}

	private void parseLine(String line, HashMap<Integer, List<Integer>> actual) {
		StringTokenizer tok = new StringTokenizer(line, " ");
		
		String keyStr = tok.nextToken();
		Integer key = Integer.parseInt(keyStr);
		List<Integer> edges = new ArrayList<Integer>();
		while (tok.hasMoreTokens()) {
			Integer edge = Integer.parseInt(tok.nextToken());
			edges.add(edge);
		}
		actual.put(key,  edges);
	}

	@Test
	public void createDataSet() {
		HashMap<Integer, List<Integer>> actual = new HashMap<Integer, List<Integer>>();
		parseLine("1 2 3 4 7", actual);
		parseLine("2 1 3 4", actual);
		parseLine("3 1 2 4", actual);
		parseLine("4 1 2 3 5", actual);
		parseLine("5 4 6 7 8", actual);
		parseLine("6 5 7 8", actual);
		parseLine("7 1 5 6 8", actual);
		parseLine("8 5 6 7", actual);

		assertEquals(8, actual.keySet().size());
	}
}
