package CricBuzz;

import java.util.HashMap;
import java.util.Map;

public class CricBuzzApp {
    static Map<Integer, Player> players=new HashMap<>();
    CricBuzzApp(){
    }

    public void addPlayer(Player player){
        players.put(player.id,player);
    }

    static public Player getPlayer(int pid){
        return players.get(pid);
    }
}
