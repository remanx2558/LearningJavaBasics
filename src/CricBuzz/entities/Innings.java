package CricBuzz.entities;

import java.util.ArrayList;
import java.util.List;

public class Innings {
    private Team battingTeam;
    private Team bowlingTeam;
    private int oversPerInning;
    private int ballsPerOver;
    private List<Over> overs = new ArrayList<>();
    private int totalRuns = 0;

    public Innings(Team battingTeam, Team bowlingTeam, int oversPerInning, int ballsPerOver) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.oversPerInning = oversPerInning;
        this.ballsPerOver = ballsPerOver;
    }

    public void startInnings() {
        System.out.println("Innings started for " + battingTeam.getTeamName());
        totalRuns = 0;
        for (int i = 1; i <= oversPerInning; i++) {
            System.out.println("Over " + i);
            Over over = new Over(i, ballsPerOver);
            over.startOver(battingTeam, bowlingTeam);
            overs.add(over);
            totalRuns += over.getTotalRuns();
        }
        battingTeam.setBattingScore(totalRuns);
    }

    public int getTotalRuns() {
        return totalRuns;
    }
}
