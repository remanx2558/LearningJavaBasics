package CricBuzz;

import CricBuzz.entities.Match;
import CricBuzz.entities.Player;
import CricBuzz.entities.Team;
import CricBuzz.util.Input;

import java.util.HashMap;
import java.util.Map;

public class CricBuzzApp {
    //NOTE: CricBuzz is also called Admin Aoo

    // Global map of players for lookup (e.g. by id)
    public static Map<Integer, Player> players = new HashMap<>();
    public static Map<String, Team> teams = new HashMap<>();
    public static Map<Integer, Match> matchs = new HashMap<>();




    int matchTypeChoice;
    int overs;
    int ballsPerOver;
    int playersPerTeam;

    public void addMatch(){
        // 1. Ask match type.
        System.out.print("Select Match Type (1: T20, 2: One Day): ");
        matchTypeChoice = Input.nextInt();

        // 2. Ask overs and balls.
        System.out.print("Enter number of overs per innings (1-4): ");
        overs = Input.nextInt();

        System.out.print("Enter number of balls per over (1-6): ");
        ballsPerOver = Input.nextInt();

        // 3. Ask number of players per team.
        System.out.print("Enter number of players per team (1-3): ");
        playersPerTeam = Input.nextInt();


        // 6. Create and start the match.
        Match match = new Match(null, null, matchTypeChoice, overs, ballsPerOver);

        matchs.put()

    }




    public void addPlayer(Player player) {
        players.put(player.getId(), player);
    }

    public void addTeam(){
        String teamName = Input.next();
        Team team = new Team();
        team.setTeamName(teamName);
        for (int i = 0; i < playersPerTeam; i++) {
            System.out.print("Enter name of Player " + (i + 1) + " for " + teamName + ": ");
            Player p = new Player();
            p.setName(Input.next());
            addPlayer(p);
            team.getPlayers().add(p);
        }
        teams.put(teamName,team);
    }

    public void startMatch(Team teamA, Team teamB, Match match){
        match.setTeamA(teamA);
        match.setTeamB(teamB);
        match.startMatch();
    }


    public static Player getPlayer(int pid) {
        return players.get(pid);
    }
}
