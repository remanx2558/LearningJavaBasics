package TicTacToe.Entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameManager {
    private Player[] players;
    private Board board;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void startGame() throws IOException {
        initializePlayers();
        initializeBoard();
        playGame();
    }

    private void initializePlayers() throws IOException {
        System.out.print("Enter number of players (2): ");
        int numPlayers = Integer.parseInt(reader.readLine().trim());
        players = new Player[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter symbol for player " + (i + 1) + ": ");
            char symbol = reader.readLine().trim().charAt(0);
            players[i] = new Player(i, symbol);
        }
    }

    private void initializeBoard() throws IOException {
        System.out.print("Enter board size (e.g., 3 for 3x3): ");
        int boardSize = Integer.parseInt(reader.readLine().trim());
        board = new Board(boardSize);
    }

    private void playGame() throws IOException {
        int playerIndex = 0;
        while (true) {
            printBoard();
            Player currentPlayer = players[playerIndex];
            System.out.println("Player " + currentPlayer.getId() + " (" + currentPlayer.getSymbol() + "), enter your move (row and column): ");
            int row = Integer.parseInt(reader.readLine().trim());
            int col = Integer.parseInt(reader.readLine().trim());

            if (isValidMove(row, col)) {
                makeMove(currentPlayer, row, col);
                if (board.checkWin(currentPlayer, row, col)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer.getId() + " (" + currentPlayer.getSymbol() + ") wins!");
                    return;
                } else if (board.isFull()) {
                    printBoard();
                    System.out.println("It's a tie!");
                    return;
                }
                playerIndex = (playerIndex + 1) % players.length;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && col >= 0 && row < board.getSize() && col < board.getSize() && board.getBlock(row, col).isEmpty();
    }

    private void makeMove(Player player, int row, int col) {
        board.getBlock(row, col).setPlayer(player);
    }

    private void printBoard() {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Block block = board.getBlock(i, j);
                System.out.print(block.isEmpty() ? " - " : " " + block.getPlayer().getSymbol() + " ");
            }
            System.out.println();
        }
    }
}
