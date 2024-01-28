package models;

public class PrintRound {
    private static int roundCount = 1; //calculate number of round (each player play 1 time, round + 1)
    private static int playCount = 0; // calculate number of time ( one player play 1 time, time + 1)

    public static void printCurrentRound() {
        playCount++;
        if (playCount == 2){
            playCount = 0;
            roundCount ++;
        }
        System.out.println("Current round: " + roundCount);
    }
}

