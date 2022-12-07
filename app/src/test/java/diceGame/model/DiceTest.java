package diceGame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DiceTest {
  @Test void rollShouldReturnRandomIntegerBetween1And6() {
    Dice sut = new Dice();
    int actual = sut.roll();
    assertTrue(actual > 0 && actual < 7);
  }
}
