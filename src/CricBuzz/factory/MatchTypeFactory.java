package CricBuzz.factory;

import CricBuzz.interfaces.MatchType;
import CricBuzz.entities.OneDayMT;
import CricBuzz.entities.T20MT;


public class MatchTypeFactory {
    public static MatchType getMatchType(int choice) {
        switch(choice) {
            case 1:
                return new T20MT();
            case 2:
                return new OneDayMT();
            default:
                throw new IllegalArgumentException("Invalid match type choice");
        }
    }
}
