package CricBuzz.enums;

public enum BallType {
    OUT,
    NORMAL,    // 0
    NOBALL,    // 1
    WIDEBALL;  // 2

    public static BallType fromInt(int input) {
        switch (input) {
            case 0:
                return NORMAL;
            case 1:
                return NOBALL;
            case 2:
                return WIDEBALL;
            default:
                return OUT;
        }
    }
}