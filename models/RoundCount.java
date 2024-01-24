package models;

// Modify RoundCount class
public class RoundCount {
    private static int roundCount = 0;

    public static void RoundCountCalculate() {
        roundCount++; // everytime call this method is called, count + 1
        if (roundCount == 4) {
            roundCount = 0; // Reset count to 0 if count hits 4
            TimePlusConverter.replaceTimeAndPlus(); // Replace Time and Plus every two rounds
        } else {
            return;
        }
    }
}

