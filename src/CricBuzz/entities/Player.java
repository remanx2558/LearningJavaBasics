package CricBuzz.entities;

import CricBuzz.*;
import CricBuzz.enums.PlayerType;

import java.util.Random;

public class Player extends Person {
    private int id;
    private PlayerType type;
    private BattingScoreCard battingScoreCard;
    private BowlingScoreCard bowlingScoreCard;

    public Player() {
        Random random = new Random();
        int candidateId;
        do {
            candidateId = random.nextInt(100);
        } while(CricBuzzApp.players.containsKey(candidateId));
        this.id = candidateId;
        this.battingScoreCard = new BattingScoreCard();
        this.bowlingScoreCard = new BowlingScoreCard();
    }

    public int getId() {
        return id;
    }

    public BattingScoreCard getBattingScoreCard() {
        return battingScoreCard;
    }

    public BowlingScoreCard getBowlingScoreCard() {
        return bowlingScoreCard;
    }
}
