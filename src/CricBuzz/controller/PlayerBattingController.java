package CricBuzz.controller;

import CricBuzz.entities.Player;
import java.util.LinkedList;
import java.util.Queue;

public class PlayerBattingController {
    private Queue<Player> waitingPlayers;
    private Player striker;
    private Player nonStriker;

    // Construct from a Queue (batting order)
    public PlayerBattingController(Queue<Player> players) {
        this.waitingPlayers = new LinkedList<>(players);
        if (!waitingPlayers.isEmpty()) {
            striker = waitingPlayers.poll();
        }
        if (!waitingPlayers.isEmpty()) {
            nonStriker = waitingPlayers.poll();
        }
    }

    public Player getStriker() {
        return striker;
    }

    public Player getNonStriker() {
        return nonStriker;
    }

    // When striker gets out, pull the next player.
    public void batsmanOut() {
        striker = waitingPlayers.poll();
    }

    // Switch strike at the over’s end.
    public void switchStrike() {
        Player temp = striker;
        striker = nonStriker;
        nonStriker = temp;
    }

    public boolean hasBatsman() {
        return striker != null;
    }
}
