package CricBuzz.entities;

import CricBuzz.enums.BallType;
import CricBuzz.enums.RunType;

public class BowlingScoreCard {
    private int runsGiven;
    private int wicketsTaken;
    private int noBallCount;
    private int wideBallCount;

    public void updateScore(BallType ballType) {
        if (ballType == BallType.WIDEBALL) {
            wideBallCount++;
        } else if (ballType == BallType.OUT) {
            wicketsTaken++;
        } else if (ballType == BallType.NOBALL) {
            noBallCount++;
        }
    }

    public void updateScore(BallType ballType, RunType runType) {
        updateScore(ballType);
        if (ballType == BallType.NORMAL) {
            runsGiven += runType.getRun();
        }
    }

    // Getters can be added as needed.
}
