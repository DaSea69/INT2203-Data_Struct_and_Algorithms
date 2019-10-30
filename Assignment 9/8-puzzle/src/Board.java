import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int[][] tiles;
    private final int hammingDistance;
    private final int manhattanDistance;
    private final int n;

    public Board(int[][] tiles) {
        if (tiles.length != tiles[0].length) {
            throw new IllegalArgumentException();
        }
        this.tiles = tiles;
        this.n = this.tiles.length;

        {
            int distance = 0;

            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.n; j++) {
                    if (tiles[i][j] == 0) {
                        continue;
                    }
                    distance += (tiles[i][j] == i * n + (j + 1)) ? 0 : 1;
                }
            }
            this.hammingDistance = distance;
        }

        {
            int distance = 0;
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.n; j++) {
                    if (tiles[i][j] == 0) {
                        continue;
                    }
                    distance += Math.abs((tiles[i][j] - 1) % this.n - j) + Math.abs((tiles[i][j] - 1) / this.n - i);
                }
            }
            this.manhattanDistance = distance;
        }

    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(Integer.toString(n));
        result.append('\n');
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                result.append(Integer.toString(this.tiles[i][j]));
                result.append(' ');
            }
            result.append('\n');
        }
        return result.toString();
    }

    public int dimension() {
        return this.n;
    }

    public int hamming() {
        return this.hammingDistance;
    }

    public int manhattan() {
        return this.manhattanDistance;
    }

    public boolean isGoal() {
        return this.hammingDistance == 0;
    }

    public boolean equals(Object that) {

        if (that instanceof Board) {
            Board tmp = (Board) that;
            if (this.dimension() != tmp.dimension()) {
                return false;
            }
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.n; j++) {
                    if (this.tiles[i][j] != tmp.tiles[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean canMoveTo(int i, int j) {
        if ((i >= 0 && i < this.n) && (j >= 0 && j < this.n)) {
            return true;
        } else {
            return false;
        }
    }

    private int[][] copyTiles() {
        int[][] result = new int[this.tiles.length][this.tiles.length];
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles.length; j++) {
                result[i][j] = this.tiles[i][j];
            }
        }
        return result;
    }

    private Board createByMove(int row1, int col1, int row2, int col2) {
        int[][] newTiles = this.copyTiles();
        int x1 = this.tiles[row2][col2];
        int x2 = this.tiles[row1][col1];
        newTiles[row1][col1] = x1;
        newTiles[row2][col2] = x2;

        return new Board(newTiles);
    }

    public Iterable<Board> neighbors() {
        final int numberOfNextMove = 4;
        final int[] nextRow = { -1, 0, 0, 1 };
        final int[] nextCol = { 0, -1, 1, 0 };
        int rowOfBlankSquare = 0;
        int colOfBlankSquare = 0;

        List<Board> neighbors = new ArrayList<Board>();

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                if (this.tiles[i][j] == 0) {
                    rowOfBlankSquare = i;
                    colOfBlankSquare = j;
                }
            }
        }

        for (int i = 0; i < numberOfNextMove; i++) {
            if (canMoveTo(rowOfBlankSquare + nextRow[i], colOfBlankSquare + nextCol[i])) {
                neighbors.add(this.createByMove(rowOfBlankSquare, colOfBlankSquare, rowOfBlankSquare + nextRow[i],
                        colOfBlankSquare + nextCol[i]));
            }
        }
        return neighbors;
    }

    public Board twin() {
        if (this.tiles[0][0] != 0 && this.tiles[0][1] != 0) {
            return createByMove(0, 0, 0, 1);
        } else {
            return createByMove(1, 0, 1, 1);
        }

    }

    public static void main(String[] args) {
        int[][] tiles = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
        Board board = new Board(tiles);
        Board board2 = new Board(tiles);

        System.out.println(board.toString());
        System.out.println(board.n);
        System.out.println(board.hamming());
        System.out.println(board.manhattan());
        for (Board x : board.neighbors()) {
            System.out.println(x);
        }

        System.out.println(board.twin());
        System.out.println(board.isGoal());
        System.out.println(board.equals(board2));

    }

}