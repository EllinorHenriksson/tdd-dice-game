package diceGame.model;

public class Player {
  private String name;
  private int score;

  private int minLength = 3;
  private int maxLength = 30;
  private String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

  public Player(String name) {
    setName(name);
  }

  public void setName(String name) {
    if (name.length() < minLength || name.length() > maxLength) {
      throw new IllegalArgumentException("Name must be 3-30 characters long.");
    }

    for (char c : name.toCharArray()) {
      if (allowedChars.indexOf(c) == -1) {
        throw new IllegalArgumentException("Name must only contain English letters.");
      }
    }
  
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void clearScore() {
    score = 0;
  }

  public int getScore() {
    return score;
  }

  public void roll(Dice dice1, Dice dice2) {
    score += dice1.roll();
    score += dice2.roll();
  }
}
