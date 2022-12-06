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

  public void clearScore() {
    score = 0;
  }

  public int getScore() {
    return 0;
  }

  public void roll(Dice dice1, Dice dice2) {
    
  }
}
