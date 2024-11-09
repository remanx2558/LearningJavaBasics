package TicTacToe.Entity;

public class Board {
    private final Block[][] grid;
    private final int size;

    public Board(int size) {
        this.size = size;
        this.grid = new Block[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Block();
            }
        }
    }

    public Block getBlock(int row, int col) {
        return grid[row][col];
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(Player player, int row, int col) {
        // Check row, column, and both diagonals for a win
        return checkRow(player, row) || checkColumn(player, col) || checkDiagonals(player);
    }

    private boolean checkRow(Player player, int row) {
        for (int col = 0; col < size; col++) {
            if (grid[row][col].getPlayer() != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(Player player, int col) {
        for (int row = 0; row < size; row++) {
            if (grid[row][col].getPlayer() != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonals(Player player) {
        boolean leftDiagonal = true, rightDiagonal = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][i].getPlayer() != player) {
                leftDiagonal = false;
            }
            if (grid[i][size - i - 1].getPlayer() != player) {
                rightDiagonal = false;
            }
        }
        return leftDiagonal || rightDiagonal;
    }
}
