package CricBuzz.entities;

import CricBuzz.interfaces.MatchType;

public class OneDayMT implements MatchType {
    public int numberOfOvers() { return 50; }
    public int maxOverAllowed() { return 10; }
}
