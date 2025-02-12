package CricBuzz.entities;

import CricBuzz.enums.BallType;
import CricBuzz.enums.RunType;
import CricBuzz.observer.ScoreUpdateNotifier;
import CricBuzz.util.Input;

public class Ball {
    private int ballNumber;
    private BallType ballType;
    private RunType runType;
    private Player playedBy;
    private Player bowledBy;

    // Notifier to update observers after the ball
    private ScoreUpdateNotifier notifier;

    public Ball(int ballNumber, ScoreUpdateNotifier notifier) {
        this.ballNumber = ballNumber;
        this.notifier = notifier;
    }

    public void startBowlingDelivery(Player playedBy, Player bowledBy) {
        this.playedBy = playedBy;
        this.bowledBy = bowledBy;

        System.out.print("Enter runs scored on ball " + ballNumber + " (-1 if out): ");
        int runsInput = Input.nextInt();
        if (runsInput == -1) {
            System.out.println("Batsman is out on ball " + ballNumber);
            runType = RunType.NORUN;
        } else {
            runType = RunType.fromInt(runsInput);
            if (runType == null) {
                System.out.println("Invalid run input. Setting runType to NORUN.");
                runType = RunType.NORUN;
            }
        }

        System.out.print("Enter Ball Type for ball " + ballNumber +
                " (0:Normal, 1:No Ball, 2:Wide Ball, -1:player out): ");
        int ballTypeInput = Input.nextInt();
        if (ballTypeInput == -1) {
            System.out.println("Batsman out indicated by ball type.");
            ballType = BallType.OUT;
        } else {
            ballType = BallType.fromInt(ballTypeInput);
            if (ballType == null) {
                System.out.println("Invalid ball type input. Setting ballType to NORMAL.");
                ballType = BallType.NORMAL;
            }
        }

        if (ballType == BallType.WIDEBALL) {
            runType = RunType.WIDERUN;
        }

        // Notify both batting and bowling observers
        notifier.notifyObservers(playedBy, this);
    }

    // Getters for use in Over or score update logic.
    public int getBallNumber() {
        return ballNumber;
    }

    public BallType getBallType() {
        return ballType;
    }

    public RunType getRunType() {
        return runType;
    }
}
