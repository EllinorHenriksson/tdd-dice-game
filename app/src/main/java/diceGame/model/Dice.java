package diceGame.model;

import java.util.Random;

public class Dice {

  private int maxFaceValue;
  private Random rand;

  public Dice(int maxFaceValue) {
    setMaxFaceValue(maxFaceValue);
    rand = new Random();
  }

  private void setMaxFaceValue(int maxFaceValue) {
    if (maxFaceValue <= 0) {
      throw new IllegalArgumentException("Max face value must be a positive integer.");
    }

    this.maxFaceValue = maxFaceValue;
  }

  public int roll() {
    return rand.nextInt(maxFaceValue) + 1;
  }
}
