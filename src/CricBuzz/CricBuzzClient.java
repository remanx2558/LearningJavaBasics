package CricBuzz;

import CricBuzz.util.Input;

import java.util.Scanner;

public class CricBuzzClient {
    public static void main(String args[]){

        // 1. first ask type of match from user : then user select the type of match which can be t20 or one day
        System.out.print("Select Match Type (1. T20, 2. One Day): ");
        int matchTypeChoice = Input.nextInt();
        MatchType matchType = matchTypeChoice == 1 ? new T20MT() : new OneDayMT();

        // 2. then ask number of overs in each inining like 1 , 2 ,3 , max 4
        System.out.print("Enter number of overs per innings (1-4): ");
        int overs = Input.nextInt();


        // 2.2 then ask number of bolls in each over 1-6

        System.out.print("Enter number of balls per over (1-6): ");
        int ballsPerOver = Input.nextInt();

        //3. then ask number of players each team can be 1,2, max 3 for now
        System.out.print("Enter number of players per team (1-3): ");
        int playersPerTeam = Input.nextInt();


        //4. then ask to tell the name of the team 1
        System.out.print("Enter name of Team 1: ");
        String team1Name = Input.next();
        Team team1 = new Team();
        team1.teamName = team1Name;
        //5.then ask to enter the name of players of teams1
        for (int i = 0; i < playersPerTeam; i++) {
            System.out.print("Enter name of Player " + (i + 1) + " for " + team1Name + ": ");
            Player p = new Player();
            p.name = Input.next();
            team1.p11.add(p);
        }
        //6.then ask the name of team2
        System.out.print("Enter name of Team 2: ");
        String team2Name = Input.next();
        Team team2 = new Team();
        team2.teamName = team2Name;
        //7. then ask to enter the name of players of team2
        for (int i = 0; i < playersPerTeam; i++) {
            System.out.print("Enter name of Player " + (i + 1) + " for " + team2Name + ": ");
            Player p = new Player();
            p.name = Input.next();
            team2.p11.add(p);
        }
        //8. start the match....
        Match match = new Match();
        match.a = team1;
        match.b = team2;
        match.type = matchType;
        match.oversPerInning = overs;
        match.ballsPerOver = ballsPerOver;
        //collect the toss : based on this decide team a and b : secondary requirement
        match.startMatch();



    }
}
