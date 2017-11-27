import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;
import java.util.Stack;

public class Solver {

    private MinPQ<Node> minPQ;
    private boolean solutionExists;
    private Node solutionNode;

    private class Node {
        Board board;
        Node  parent;

        public Node(Board board, Node parent) {
            this.board  = board;
            this.parent = parent;
        }
    }

    private static Comparator<Node> manhattanComparator = new Comparator<Node>() {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.board.manhattan() - o2.board.manhattan();
        }
    };

    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException();

        minPQ = new MinPQ<Node>(manhattanComparator);
        solutionExists = false;
        solutionNode = null;

        Node root = new Node(initial, null);
        minPQ.insert(root);

//        while (solutionExists == false) {
//            solve(minPQ);
//        }
    }

    private void solve(MinPQ<Node> minPQ) {
        Node current = minPQ.delMin();

        if (current.board.isGoal()) {
            solutionNode = current;
            solutionExists = true;
            return;
        }

        for (Board b : current.board.neighbors()) {

            if (current.parent == null || !b.equals(current.parent.board)) {
                Node neighbor = new Node(b, current);
                minPQ.insert(neighbor);
            }
        }
    }

    public boolean isSolvable() {
        return solutionExists;
    }

    public int moves() {
        if (solutionExists == false) return -1;

        int moves = 0;
        Node node = solutionNode;

        while (node.parent != null) {
            moves++;
            node = node.parent;
        }

        return moves;
    }

    public Iterable<Board> solution() {
        if (solutionExists == false) return null;

        Stack<Board> boardsInSolution = new Stack<>();

        Node node = solutionNode;
        boardsInSolution.push(solutionNode.board);

        while (node.parent != null) {
            boardsInSolution.push(node.parent.board);
            node = node.parent;
        }

        return boardsInSolution;
    }

    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
