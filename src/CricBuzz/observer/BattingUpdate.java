package CricBuzz.observer;

import CricBuzz.entities.Ball;
import CricBuzz.entities.Player;

public class BattingUpdate implements ScoreUpdateObserver {
    @Override
    public void update(Player player, Ball ball) {
        System.out.println("Batting Score Updated for " + player.getName());
        player.getBattingScoreCard().updateScore(ball.getRunType());
    }
}
