package CricBuzz.entities;

import CricBuzz.interfaces.MatchType;

public class T20MT implements MatchType {
    public int numberOfOvers() { return 20; }
    public int maxOverAllowed() { return 4; }
}