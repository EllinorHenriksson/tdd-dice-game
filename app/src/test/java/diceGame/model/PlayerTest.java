package diceGame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlayerTest {
  @Test void constructorShouldThrowOnNull() {
    assertThrows(NullPointerException.class, () -> new Player(null));
  }

  @Test void constructorShouldThrowOn2LetterName() {
    assertThrows(IllegalArgumentException.class, () -> new Player("Ab"));
  }

  @Test void constructorShouldNotThrowOn3LetterName() {
    assertDoesNotThrow(() -> new Player("Abc"));
  }

  @Test void constructorShouldThrowOn31LetterName() {
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < 31; i++) {
      buffer.append("a");
    }

    String name = buffer.toString();

    assertThrows(IllegalArgumentException.class, () -> new Player(name));
  }

  @Test void constructorShouldNotThrowOn30LetterName() {
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < 30; i++) {
      buffer.append("a");
    }

    String name = buffer.toString();

    assertDoesNotThrow(() -> new Player(name));
  }

  @Test void constructorShouldThrowOnNonLetterCharacter() {
    String name = "ab3";

    assertThrows(IllegalArgumentException.class, () -> new Player(name));
  }

  @Test void getNameShouldReturnName() {
    String name = "Ellen";
    Player sut = new Player(name);
    assertEquals(name, sut.getName());
  }

  @Test void rollShouldCallRollOnTheDiceSentAsArguments() {
    Player sut = new Player("Ellen");
    Dice dice1 = mock(Dice.class);
    Dice dice2 = mock(Dice.class);
    sut.roll(dice1, dice2);
    verify(dice1).roll();
    verify(dice2).roll();
  }

  @Test void rollShouldAddFaceValuesOfDicesToScore() {
    Player sut = new Player("Ellen");
    Dice dice1 = mock(Dice.class);
    Dice dice2 = mock(Dice.class);
    when(dice1.roll()).thenReturn(1);
    when(dice2.roll()).thenReturn(1);
    sut.roll(dice1, dice2);
    int expected = 2;
    int actual = sut.getScore();
    assertEquals(expected, actual);
  }

  @Test void clearScoreShouldSetScoreToZero() {
    Player sut = new Player("Ellen");
    sut.clearScore();

    int expected = 0;
    int actual = sut.getScore();

    assertEquals(expected, actual);
  }
}
