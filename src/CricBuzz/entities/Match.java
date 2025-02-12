package CricBuzz.entities;

import CricBuzz.interfaces.MatchType;
import CricBuzz.factory.MatchTypeFactory;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private Team teamA;
    private Team teamB;
    private List<Innings> innings = new ArrayList<>();
    private MatchType matchType;
    private int oversPerInning;
    private int ballsPerOver;

    // The match type is determined via the factory.
    public Match(Team teamA, Team teamB, int matchTypeChoice, int oversPerInning, int ballsPerOver) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.matchType = MatchTypeFactory.getMatchType(matchTypeChoice);
        this.oversPerInning = oversPerInning;
        this.ballsPerOver = ballsPerOver;
    }

    public void startMatch() {
        System.out.println("Match Started between " + teamA.getTeamName() + " and " + teamB.getTeamName());
        // Initialize controllers for both teams.
        teamA.initControllers();
        teamB.initControllers();

        // First innings: teamA bats, teamB bowls.
        Innings firstInnings = new Innings(teamA, teamB, oversPerInning, ballsPerOver);
        firstInnings.startInnings();
        innings.add(firstInnings);
        System.out.println("Innings 1: " + teamA.getTeamName() + " scored " + firstInnings.getTotalRuns());

        // Second innings: teamB bats, teamA bowls.
        Innings secondInnings = new Innings(teamB, teamA, oversPerInning, ballsPerOver);
        secondInnings.startInnings();
        innings.add(secondInnings);
        System.out.println("Innings 2: " + teamB.getTeamName() + " scored " + secondInnings.getTotalRuns());

        displayResult();
    }

    private void displayResult() {
        System.out.println("Match Over! Final Scores:");
        System.out.println(teamA.getTeamName() + ": " + teamA.getBattingScore());
        System.out.println(teamB.getTeamName() + ": " + teamB.getBattingScore());
        if (teamA.getBattingScore() > teamB.getBattingScore()) {
            System.out.println(teamA.getTeamName() + " wins!");
        } else if (teamB.getBattingScore() > teamA.getBattingScore()) {
            System.out.println(teamB.getTeamName() + " wins!");
        } else {
            System.out.println("Match Tied!");
        }
    }
}
