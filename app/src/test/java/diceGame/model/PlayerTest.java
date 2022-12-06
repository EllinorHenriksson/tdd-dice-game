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
}
