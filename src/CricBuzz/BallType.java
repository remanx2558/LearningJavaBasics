package CricBuzz;

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
                // Return null or throw an exception if input is invalid
                return OUT;
        }
    }
}