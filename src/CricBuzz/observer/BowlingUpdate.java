package CricBuzz.observer;

public class BowlingUpdate  implements ScoreUpdateObserver {
    public void update() {
        System.out.println("Bowling Score Updated!");
    }
}