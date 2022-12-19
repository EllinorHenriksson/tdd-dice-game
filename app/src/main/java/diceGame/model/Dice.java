package diceGame.model;

import java.util.Random;

public class Dice {

  private int maxFaceValue;
  private Random rand;

  public Dice(int maxFaceValue) {
    this.maxFaceValue = maxFaceValue;
    rand = new Random();
  }

  public int roll() {
    return rand.nextInt(maxFaceValue) + 1;
  }
}
