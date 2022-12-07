package diceGame.model;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

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

  @Test void rollShouldCallRollOnTheDiceSentAsArguments() {
    Player sut = new Player("Player");
    Dice dice1 = mock(Dice.class);
    Dice dice2 = mock(Dice.class);
    sut.roll(dice1, dice2);
    verify(dice1).roll();
    verify(dice2).roll();
  }

  @Test void rollShouldAddFaceValuesOfDicesToScore() {
    Player sut = new Player("Player");
    Dice dice1 = mock(Dice.class);
    Dice dice2 = mock(Dice.class);
    when(dice1.roll()).thenReturn(1);
    when(dice2.roll()).thenReturn(1);
    sut.roll(dice1, dice2);
    int expected = 2;
    int actual = sut.getScore();
    assertEquals(expected, actual);
  }
}
