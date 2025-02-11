package CricBuzz;

import CricBuzz.util.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Over {
    int overNumber;
    int ballsPerOver;
    int totalRuns = 0;
    Player batting;
    Player bowling;
    List<Ball> balls=new ArrayList<>();

    void startOver() {

        System.out.println("Enter Batsman Id to bat: ");
        int batsmanId=Input.nextInt();
        batting=CricBuzzApp.getPlayer(batsmanId);

        System.out.println("Enter Bowler Id to bowl: ");
        int bowlerId=Input.nextInt();
        bowling=CricBuzzApp.getPlayer(batsmanId);

        //now update logic here



        System.out.println("Over Started!");

        for (int j = 1; j <= ballsPerOver; j++) {

            Ball ball=new Ball();
            ball.ballNumber=j;
            ball.startBowlingDelivery(batting, bowling);








            if (ball.ballType == BallType.OUT) {
                //pick another batsmen using player Id
                System.out.println("Player got out!...now other batsmen will come");

            } else if(ball.ballType == BallType.NOBALL)
            {

                totalRuns += runs;
                //get another ball
            }
            else if(ball.ballType == BallType.WIDEBALL){
                totalRuns+=1;
                //get another ball
            }
            else if(ball.ballType== BallType.NORMAL){
                int val=//depends on runtype
                totalRuns +=val;

            }


            balls.add(ball);
        }

    }

    int getTotalRuns(){
        return totalRuns;
    }
}
