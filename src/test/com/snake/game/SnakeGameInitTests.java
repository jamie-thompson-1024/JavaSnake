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
                game.getGameState(),
                GameState.READY);
    }

    @Test
    public void expect_Score_ToBe_0() {
        Assert.assertEquals(
                game.getScore(),
                0);
    }

    @Test
    public void expect_Time_ToBe_0() {
        Assert.assertEquals(
                game.getTime(),
                0);
    }

    @Test
    public void expect_LastDirection_ToBe_None() {
        Assert.assertEquals(
                game.getLastDirection(),
                Direction.NONE);
    }

    @Test
    public void expect_SnakeBody_ToBe_LengthOf1() {
        Assert.assertEquals(
                game.getSnakeBody().length,
                1);
    }

    @Test
    public void expect_FoodPositions_ToBe_LengthOfFoodCount() {
        Assert.assertEquals(
                game.getFoodPositions().length,
                game.getFoodCount());
    }

}
