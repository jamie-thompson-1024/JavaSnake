package com.snake.game;

import org.junit.*;

public class SnakeGameInitTests {

    SnakeGame game;

    @Before
    public void initialiseGame() {
        game = new SnakeGame();
    }

    @Test
    public void expect_GameState_ToBe_Ready() {
        Assert.assertEquals(
                GameState.READY,
                game.getGameState()
        );
    }

    @Test
    public void expect_Score_ToBe_0() {
        Assert.assertEquals(
                0,
                game.getScore()
        );
    }

    @Test
    public void expect_Time_ToBe_0() {
        Assert.assertEquals(
                0,
                game.getTime()
        );
    }

    @Test
    public void expect_LastDirection_ToBe_None() {
        Assert.assertEquals(
                Direction.NONE,
                game.getLastDirection()
        );
    }

    @Test
    public void expect_SnakeBody_ToBe_LengthOf1() {
        Assert.assertEquals(
                1,
                game.getSnakeBody().length
        );
    }

    @Test
    public void expect_FoodPositions_ToBe_LengthOfFoodCount() {
        Assert.assertEquals(
                game.getFoodCount(),
                game.getFoodPositions().length
        );
    }

}
