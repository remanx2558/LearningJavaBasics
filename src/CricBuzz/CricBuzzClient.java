package CricBuzz;

import CricBuzz.entities.Match;
import CricBuzz.entities.Player;
import CricBuzz.entities.Team;
import CricBuzz.util.Input;

public class CricBuzzClient {
    public static void main(String[] args) {
        // 1. Ask match type.
        System.out.print("Select Match Type (1: T20, 2: One Day): ");
        int matchTypeChoice = Input.nextInt();

        // 2. Ask overs and balls.
        System.out.print("Enter number of overs per innings (1-4): ");
        int overs = Input.nextInt();
        System.out.print("Enter number of balls per over (1-6): ");
        int ballsPerOver = Input.nextInt();

        // 3. Ask number of players per team.
        System.out.print("Enter number of players per team (1-3): ");
        int playersPerTeam = Input.nextInt();

        // 4. Create Team 1.
        System.out.print("Enter name of Team 1: ");
        String team1Name = Input.next();
        Team team1 = new Team();
        team1.setTeamName(team1Name);
        for (int i = 0; i < playersPerTeam; i++) {
            System.out.print("Enter name of Player " + (i + 1) + " for " + team1Name + ": ");
            Player p = new Player();
            p.setName(Input.next());
            new CricBuzzApp().addPlayer(p);
            team1.getPlayers().add(p);
        }

        // 5. Create Team 2.
        System.out.print("Enter name of Team 2: ");
        String team2Name = Input.next();
        Team team2 = new Team();
        team2.setTeamName(team2Name);
        for (int i = 0; i < playersPerTeam; i++) {
            System.out.print("Enter name of Player " + (i + 1) + " for " + team2Name + ": ");
            Player p = new Player();
            p.setName(Input.next());
            new CricBuzzApp().addPlayer(p);
            team2.getPlayers().add(p);
        }

        // 6. Create and start the match.
        Match match = new Match(team1, team2, matchTypeChoice, overs, ballsPerOver);
        match.startMatch();
    }
}
