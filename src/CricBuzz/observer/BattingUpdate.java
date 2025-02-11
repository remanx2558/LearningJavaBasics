package CricBuzz.observer;

class BattingUpdate implements ScoreUpdateObserver {
    public void update() {
        System.out.println("Batting Score Updated!");
    }
}