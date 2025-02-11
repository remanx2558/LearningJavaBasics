package CricBuzz;

import CricBuzz.util.Input;

class Ball {
    int ballNumber;
    BallType ballType;
    RunType runType;
    Player playedBy;
    Player bowledBy;

    void startBowlingDelivery(Player playedBy, Player bowledBy) {
        this.playedBy = playedBy;
        this.bowledBy = bowledBy;

        // Read runs scored
        System.out.print("Enter runs scored on ball " + ballNumber + " (-1 if out): ");
        int runsInput = Input.nextInt();

        // If runs == -1 => player is out. Otherwise map runs to RunType
        if (runsInput == -1) {
            // Batsman out
            System.out.println("Batsman is out on ball " + ballNumber);
            runType = RunType.NORUN; // or handle out differently
        } else {
            // Map to appropriate RunType
            runType = RunType.fromInt(runsInput);
            if (runType == null) {
                System.out.println("Invalid run input: " + runsInput + ". Setting runType to null.");
            }
        }

        // Read ball type
        System.out.print("Enter Ball Type for ball " + ballNumber
                + " (0:Normal, 1:No Ball, 2:Wide Ball, -1:player out): ");
        int ballTypeInput = Input.nextInt();

        if (ballTypeInput == -1) {
            // Another out scenario or special handling
            System.out.println("Batsman out indicated by ball type as well. "
                    + "Handle logic if needed.");
            ballType = BallType.OUT;
        } else {
            // Map the integer to BallType
            ballType = BallType.fromInt(ballTypeInput);
            if (ballType == null) {
                System.out.println("Invalid ball type input: " + ballTypeInput
                        + ". Setting ballType to null.");
            }
        }

        // Example logic: If the ball is wide, you might force the run type to WIDERUN
        if (ballType == BallType.WIDEBALL) {
            runType = RunType.WIDERUN;
        }

    }
}
