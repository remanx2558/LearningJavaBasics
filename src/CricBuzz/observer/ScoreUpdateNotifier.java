package CricBuzz.observer;

import CricBuzz.entities.Ball;
import CricBuzz.entities.Player;
import java.util.ArrayList;
import java.util.List;

public class ScoreUpdateNotifier {
    private List<ScoreUpdateObserver> observers = new ArrayList<>();

    public void addObserver(ScoreUpdateObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ScoreUpdateObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Player player, Ball ball) {
        for (ScoreUpdateObserver observer : observers) {
            observer.update(player, ball);
        }
    }
}
