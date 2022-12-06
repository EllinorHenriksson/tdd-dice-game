package diceGame.model;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameTest {
  @Test void constructorShouldCreateTwoPlayerObjects() {
    try (MockedConstruction<Player> mock = mockConstruction(Player.class)) {
      Game sut = new Game();
      int expeced = 2;
      int actual = mock.constructed().size();
      assertEquals(expeced, actual, "The number of instantiated Player objects should be " + expeced);
    }
  }
}
