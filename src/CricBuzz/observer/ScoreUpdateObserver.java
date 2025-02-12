package CricBuzz.observer;

import CricBuzz.entities.Ball;
import CricBuzz.entities.Player;

public interface ScoreUpdateObserver {
    void update(Player player, Ball ball);
}
