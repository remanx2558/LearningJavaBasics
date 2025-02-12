package CricBuzz;

import CricBuzz.entities.Match;
import CricBuzz.entities.Player;
import CricBuzz.entities.Team;
import CricBuzz.util.Input;

public class CricBuzzClient {
    public static void main(String[] args) {

        CricBuzzApp cricBuzzApp =new CricBuzzApp();
        cricBuzzApp.addMatch();


        // 4. Create Team 1.
        System.out.print("Enter name of Team 1: ");
       cricBuzzApp.addTeam();

        // 5. Create Team 2.
        System.out.print("Enter name of Team 2: ");
        cricBuzzApp.addTeam();


    }
}
