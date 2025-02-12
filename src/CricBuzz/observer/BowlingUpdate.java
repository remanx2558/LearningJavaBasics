package CricBuzz.observer;

import CricBuzz.entities.Ball;
import CricBuzz.entities.Player;

public class BowlingUpdate implements ScoreUpdateObserver {
    @Override
    public void update(Player player, Ball ball) {
        System.out.println("Bowling Score Updated for " + player.getName());
        player.getBowlingScoreCard().updateScore(ball.getBallType(), ball.getRunType());
    }
}
