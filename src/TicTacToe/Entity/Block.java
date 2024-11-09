package TicTacToe.Entity;

public class Block {
    private Player player;

    public Block() {
        this.player = null;
    }

    public boolean isEmpty() {
        return player == null;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
