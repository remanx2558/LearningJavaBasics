package CricBuzz;

import java.util.Random;

class Player extends Person {
    int id;
    PlayerType type;
    BattingScoreCard battingScoreCard;
    BowlingScoreCard bowlingScoreCard;

    Player(){
        //player id generation logic
        Random random = new Random();
        int candidateId;
        do {
            candidateId = random.nextInt(100); // random in [0..100]
        } while (CricBuzzApp.players.containsKey(candidateId));

        id=candidateId;

    }
}
