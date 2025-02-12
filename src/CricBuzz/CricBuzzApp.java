package CricBuzz;

import CricBuzz.entities.Player;

import java.util.HashMap;
import java.util.Map;

public class CricBuzzApp {
    // Global map of players for lookup (e.g. by id)
    public static Map<Integer, Player> players = new HashMap<>();

    public void addPlayer(Player player) {
        players.put(player.getId(), player);
    }

    public static Player getPlayer(int pid) {
        return players.get(pid);
    }
}
