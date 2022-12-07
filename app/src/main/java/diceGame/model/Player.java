package diceGame.model;

public class Player {
  private String name;
  private int score;

  public Player(String name) {
    if (name.length() < 3) {
      throw new IllegalArgumentException("Name must be at least 3 characters long.");
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
    
  }
}
