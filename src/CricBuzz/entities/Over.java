package CricBuzz.entities;

import CricBuzz.enums.BallType;
import CricBuzz.observer.ScoreUpdateNotifier;
import CricBuzz.observer.BattingUpdate;
import CricBuzz.observer.BowlingUpdate;
import CricBuzz.util.Input;
import java.util.ArrayList;
import java.util.List;

public class Over {
    private int overNumber;
    private int ballsPerOver;
    private int totalRuns = 0;
    private List<Ball> balls = new ArrayList<>();
    private ScoreUpdateNotifier notifier;

    public Over(int overNumber, int ballsPerOver) {
        this.overNumber = overNumber;
        this.ballsPerOver = ballsPerOver;
        notifier = new ScoreUpdateNotifier();
        // Register observers for both batting and bowling.
        notifier.addObserver(new BattingUpdate());
        notifier.addObserver(new BowlingUpdate());
    }

    // Start an over using the team controllers.
    public void startOver(Team battingTeam, Team bowlingTeam) {
        // Retrieve the striker and current bowler from the teams’ controllers.
        Player striker = battingTeam.getBattingController().getStriker();
        Player bowler = bowlingTeam.getBowlingController().getCurrentBowler();
        System.out.println("Striker: " + striker.getName() + ", Bowler: " + bowler.getName());
        System.out.println("Over " + overNumber + " Started!");

        for (int j = 1; j <= ballsPerOver; j++) {
            Ball ball = new Ball(j, notifier);
            ball.startBowlingDelivery(striker, bowler);

            // Update runs based on ball type.
            if (ball.getBallType() == BallType.OUT) {
                System.out.println("Player " + striker.getName() + " is out!");
                System.out.print("Enter next batsman id: ");
                int newBatsmanId = Input.nextInt();
                battingTeam.getBattingController().batsmanOut();
                striker = battingTeam.getBattingController().getStriker();
                if (striker == null) {
                    System.out.println("No more batsmen available!");
                    break;
                }
            } else if (ball.getBallType() == BallType.NOBALL) {
                totalRuns += ball.getRunType().getRun();
                j--; // No-ball: extra ball to be bowled.
            } else if (ball.getBallType() == BallType.WIDEBALL) {
                totalRuns += 1;
                j--; // Wide ball: extra ball.
            } else if (ball.getBallType() == BallType.NORMAL) {
                totalRuns += ball.getRunType().getRun();
            }

            balls.add(ball);
        }
        // At the over’s end, switch strike.
        battingTeam.getBattingController().switchStrike();
    }

    public int getTotalRuns() {
        return totalRuns;
    }
}
