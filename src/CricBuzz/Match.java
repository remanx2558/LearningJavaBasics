package CricBuzz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Match {
    Team a, b;
    Date date;
    String venue;
    List<Innings> innings=new ArrayList<>();
    MatchType type;
    Team tossWinner;
    int oversPerInning;
    int ballsPerOver;

    void startMatch() {
        System.out.println("Match Started between " + a.teamName + " and " + b.teamName);

        // 8.1   then for ininint 1 , for each over , for each ball ask player scored 0,1,2,3,4,5,6 and if entered -1 then played out
        playInnings(a, b, 1);
        //8.2  similarly for second ininint
        playInnings(b, a, 2);
        //8.3  at the end display the score of each team and the name of the winning team
        displayResult();
    }
    void playInnings(Team batting, Team bowling, int inningNumber) {
        Innings inning = new Innings();
        inning.oversPerInning=oversPerInning;
        inning.ballsPerOver=ballsPerOver;
        inning.battingTeam=batting;
        inning.bowlingTeam=bowling;


        inning.startInnings();
        System.out.println("Total score for " + batting.teamName + " is: " + inning.totalRuns+ "in Inning-"+inningNumber);
        batting.battingScore = inning.totalRuns;
    }

    void displayResult() {
        System.out.println("Match Over! Scores:");
        System.out.println(a.teamName + " Score: " + a.battingScore);
        System.out.println(b.teamName + " Score: " + b.battingScore);
        if (a.battingScore > b.battingScore) {
            System.out.println(a.teamName + " wins!");
        } else if (b.battingScore > a.battingScore) {
            System.out.println(b.teamName + " wins!");
        } else {
            System.out.println("Match Tied!");
        }
    }

}