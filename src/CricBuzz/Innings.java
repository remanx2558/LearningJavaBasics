package CricBuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Innings {
    Team battingTeam;
    Team bowlingTeam;
    int oversPerInning;
    int ballsPerOver;
    List<Over> overs = new ArrayList<>();
    int totalRuns = 0;

    void startInnings() {
        System.out.println("Innings started for " + battingTeam.teamName);
        totalRuns=0;

        for (int i = 1; i <= oversPerInning; i++) {
            System.out.println("Over " + i);
            Over over=new Over();
            over.overNumber=i;
            over.ballsPerOver=ballsPerOver;
            over.startOver();
            overs.add(over);
            totalRuns+=over.getTotalRuns();
        }

    }
}
