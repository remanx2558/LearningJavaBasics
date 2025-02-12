package CricBuzz.controller;

import CricBuzz.entities.Player;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class PlayerBowlerController {
    private Deque<Player> bowlers;
    private Map<Player, Integer> bowlerOverCount;
    private Player currentBowler;

    public PlayerBowlerController(Deque<Player> bowlers) {
        this.bowlers = new LinkedList<>(bowlers);
        this.bowlerOverCount = new HashMap<>();
        for (Player bowler : bowlers) {
            bowlerOverCount.put(bowler, 0);
        }
        currentBowler = bowlers.peek();
    }

    public Player getCurrentBowler() {
        return currentBowler;
    }

    // Update the bowler rotation after an over.
    public void updateBowlerAfterOver() {
        bowlerOverCount.put(currentBowler, bowlerOverCount.get(currentBowler) + 1);
        // Example: use 4 as max overs allowed (could also come from match settings)
        int maxOvers = 4;
        if (bowlerOverCount.get(currentBowler) >= maxOvers) {
            bowlers.poll();
        } else {
            bowlers.offer(bowlers.poll());
        }
        currentBowler = bowlers.peek();
    }
}
