package TicTacToe.Entity;

public class Player {
    private final int id;
    private final char symbol; // Added a symbol for better display (like 'X' or 'O')

    public Player(int id, char symbol) {
        this.id = id;
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public char getSymbol() {
        return symbol;
    }
}
