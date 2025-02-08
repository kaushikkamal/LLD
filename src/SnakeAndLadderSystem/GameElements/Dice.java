package SnakeAndLadderSystem.GameElements;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int diceCount;
    private static final int MIN = 1;
    private static final int MAX = 6;


    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int totalSum = 0;
        int diceUsed = 0;

        while (diceUsed != this.diceCount) {
            totalSum += ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
            diceUsed++;
        }

        return totalSum;
    }
}
