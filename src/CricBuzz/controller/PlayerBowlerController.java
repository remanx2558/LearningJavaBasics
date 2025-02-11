package CricBuzz.controller;

import CricBuzz.Player;

import java.util.Deque;
import java.util.Map;

class PlayerBowlerController {
    Deque<Player> bowler;
    Map<Player, Integer> bowlerVsOverCount;
    Player currentBowler;
}
