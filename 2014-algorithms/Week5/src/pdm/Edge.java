package pdm;

class Edge {
	int from;
	int to;
	int distance;
	public Edge(int from, int to, int distance) {
		this.from = from;
		this.to = to;
		this.distance = distance;
	}
	
	public String toString() {
		return to + "," + distance;
	}

	public int getSource() {
		return from;
	}

	public int getDestination() {
		return to;
	}

	public int getWeight() {
		return distance;
	}
}