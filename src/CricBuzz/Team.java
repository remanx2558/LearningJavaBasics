package CricBuzz;

import CricBuzz.controller.PlayerBattingController;
import CricBuzz.controller.PlayerBowlerController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Team {
    String teamName;
    int battingScore=0;
    Queue<Player> p11;
    List<Player> bench;
    PlayerBattingController battingController;
    PlayerBowlerController bowlingController;

    public Team(){
        p11=new LinkedList<>();
        bench=new ArrayList<>();
    }


}

