package CricBuzz;

public enum RunType {
    NORUN,
    ONE,       // 1
    TWO,       // 2
    THREE,     // 3
    FOUR,      // 4
    SIX,       // 6
    WIDERUN;   // used when the ball is a WIDEBALL, etc.

    public static RunType fromInt(int runs) {
        switch (runs) {
            case 1:
                return ONE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 6:
                return SIX;
            default:
                // Could return null or throw an exception if runs are invalid
                return NORUN;
        }
    }
}