package CricBuzz.entities;

import CricBuzz.enums.RunType;

public class BattingScoreCard {
    private int totalRuns;
    private int totalBallsPlayed;
    private int total4s;
    private int total6s;

    public void updateScore(RunType runType) {
        totalBallsPlayed++;
        totalRuns += runType.getRun();
        if (runType.getRun() == 6) {
            total6s++;
        } else if (runType.getRun() == 4) {
            total4s++;
        }
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    // Additional getters for balls, boundaries etc. can be added as needed.
}
