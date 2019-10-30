import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

public class Solver {
    private final MinPQ<SearchNode> minPQ;
    private final int minimumMove;
    private final List<Board> stepSolution;
    private final boolean canSolver;

    private class SearchNode implements Comparable<SearchNode> {

        final Board board;
        final SearchNode prevNode;
        final int move;

        public SearchNode(Board board, SearchNode prevNode) {
            this.board = board;
            this.prevNode = prevNode;
            if (prevNode == null) {
                move = 0;
            } else {
                move = prevNode.move + 1;
            }
        }

        public int manhattan() {
            return this.board.manhattan();
        }

        @Override
        public int compareTo(SearchNode that) {
            int proirityDistance = (this.manhattan() + this.move) - (that.manhattan() + that.move);
            return proirityDistance == 0 ? this.manhattan() - that.manhattan() : proirityDistance;
        }
    }

    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }

        minPQ = new MinPQ<SearchNode>(11);

        minPQ.insert(new SearchNode(initial, null));
        minPQ.insert(new SearchNode(initial.twin(), null));

        while (!minPQ.min().board.isGoal()) {
            SearchNode node = minPQ.delMin();
            if (node.board.isGoal()) {
            } else {
                for (Board board : node.board.neighbors()) {
                    if (!(node.prevNode != null && board.equals(node.prevNode.board))) {
                        minPQ.insert(new SearchNode(board, node));
                    }
                }
            }
        }

        this.minimumMove = minPQ.min().move;

        Stack<SearchNode> solution = new Stack<SearchNode>();
        solution.push(minPQ.min());
        while (solution.peek().prevNode != null) {
            solution.push(solution.peek().prevNode);
        }

        List<Board> stepBoards = new ArrayList<Board>();
        while (!solution.isEmpty()) {
            stepBoards.add(solution.pop().board);
        }

        this.stepSolution = stepBoards;
        if (stepBoards.get(0).equals(initial)) {
            canSolver = true;
        } else {
            canSolver = false;
        }
    }

    public boolean isSolvable() {
        return canSolver;
    }

    public int moves() {
        return canSolver ? this.minimumMove : -1;
    }

    public Iterable<Board> solution() {
        return canSolver ? this.stepSolution : null;
    }

    public static void main(String[] args) {

        int[][] titles = { { 0, 1, 3 }, { 4, 2, 5 }, { 7, 8, 6 } };
        Solver solver = new Solver(new Board(titles));
        System.out.println(solver.moves());
        for (Board board : solver.solution()) {
            System.out.println(board);
        }
    }

}