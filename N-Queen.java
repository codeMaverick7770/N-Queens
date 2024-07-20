// NQueensSolver.java

public class NQueensSolver {
    private int n;
    private int[][] board;
    private int solutionCount;

    public NQueensSolver(int n) {
        this.n = n;
        this.board = new int[n][n];
        this.solutionCount = 0;
    }

    public void solve() {
        solve(0);
        System.out.println("Found " + solutionCount + " solutions.");
    }

    private void solve(int row) {
        if (row == n) {
            printSolution();
            solutionCount++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                board[row][col] = 1;
                solve(row + 1);
                board[row][col] = 0;
            }
        }
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1 ||
                (i - row == board[i][col] - col) ||
                (i + col == board[i][col] + row)) {
                return false;
            }
        }
        return true;
    }

    private void printSolution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java NQueensSolver <N>");
            return;
        }
        
        int n = Integer.parseInt(args[0]);
        NQueensSolver solver = new NQueensSolver(n);
        solver.solve();
    }
}
