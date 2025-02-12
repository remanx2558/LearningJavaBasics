package CricBuzz.entities;

import CricBuzz.*;
import CricBuzz.enums.PlayerType;
import CricBuzz.util.IdGenerator;

import java.util.Random;

public class Player extends Person {
    private int id;
    private PlayerType type;
    private BattingScoreCard battingScoreCard;
    private BowlingScoreCard bowlingScoreCard;

    public Player() {
        this.id= IdGenerator.generateId(CricBuzzApp.players);
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
