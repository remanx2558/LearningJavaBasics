package TicTacToe.Entity;

import java.io.IOException;

public class TicTacToeClient {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        try {
            gameManager.startGame();
        } catch (IOException e) {
            System.out.println("Error during game: " + e.getMessage());
        }
    }
}
