package com.snake.game;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeGameInitTests {

    SnakeGame game;

    @BeforeEach
    public void initialiseGame() {
        game = new SnakeGame();
    }

    @Test
    public void expect_GameState_ToBe_Ready() {
        assertEquals(
                GameState.READY,
                game.getGameState()
        );
    }

    @Test
    public void expect_Score_ToBe_0() {
        assertEquals(
                0,
                game.getScore()
        );
    }

    @Test
    public void expect_Time_ToBe_0() {
        assertEquals(
                0,
                game.getTime()
        );
    }

    @Test
    public void expect_LastDirection_ToBe_None() {
        assertEquals(
                Direction.NONE,
                game.getLastDirection()
        );
    }

    @Test
    public void expect_SnakeBody_ToBe_LengthOf1() {
        assertEquals(
                1,
                game.getSnakeBody().length
        );
    }

    @Test
    public void expect_FoodPositions_ToBe_LengthOfFoodCount() {
        assertEquals(
                game.getFoodCount(),
                game.getFoodPositions().length
        );
    }

}
