package CricBuzz.enums;

public enum RunType {
    NORUN(0),
    ONE(1),       // 1
    TWO(2),       // 2
    THREE(3),     // 3
    FOUR(4),      // 4
    FIVE(5),
    SIX(6),       // 6
    WIDERUN(1);   // used when the ball is a WIDEBALL, etc.

    int run;

    RunType(int run){
        this.run=run;
    }

    public int getRun(){
        return run;
    }

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
            case 5:
                return FIVE;
            case 6:
                return SIX;
            default:
                // Could return null or throw an exception if runs are invalid
                return NORUN;
        }
    }
}