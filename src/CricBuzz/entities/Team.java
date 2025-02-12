package CricBuzz.entities;

import CricBuzz.controller.PlayerBattingController;
import CricBuzz.controller.PlayerBowlerController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Deque;

public class Team {
    private String teamName;
    private int battingScore = 0;
    private Queue<Player> players;  // players in playing order
    private List<Player> bench;     // players who are out
    private PlayerBattingController battingController;
    private PlayerBowlerController bowlingController;

    public Team() {
        players = new LinkedList<>();
        bench = new ArrayList<>();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getBattingScore() {
        return battingScore;
    }

    public void setBattingScore(int score) {
        this.battingScore = score;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public List<Player> getBench() {
        return bench;
    }

    // Initialize controllers using the players in the team.
    public void initControllers() {
        battingController = new PlayerBattingController(players);
        Deque<Player> bowlerDeque = new LinkedList<>(players);
        bowlingController = new PlayerBowlerController(bowlerDeque);
    }

    public PlayerBattingController getBattingController() {
        return battingController;
    }

    public PlayerBowlerController getBowlingController() {
        return bowlingController;
    }
}
