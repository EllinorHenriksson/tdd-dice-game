package diceGame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DiceTest {
  @Test void constructorShouldThrowOnNegativeMaxFaceValue() {
    assertThrows(IllegalArgumentException.class, () -> new Dice(-1));
  }

  @Test void constructorShouldThrowOnZeroMaxFaceValue() {
    assertThrows(IllegalArgumentException.class, () -> new Dice(0));
  }

  @Test void constructorShouldNotThrowOnPositiveMaxFaceValue() {
    assertDoesNotThrow(() -> new Dice(1));
  }
  
  @Test void rollShouldReturnRandomIntegerBetween1And6For6SidedDice() {
    Dice sut = new Dice(6);
    int actual = sut.roll();
    assertTrue(actual > 0 && actual < 7);
  }
}
