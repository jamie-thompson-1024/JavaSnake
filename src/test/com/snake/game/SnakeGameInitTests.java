package com.snake.game;

import org.junit.*;

public class SnakeGameInitTests {

    SnakeGame game;

    @Before
    public void initialiseGame() {
        game = new SnakeGame();
    }

    @Test
    public void expectGameStateToBeReady() {
        Assert.assertEquals(
                game.getGameState(),
                GameState.READY);
    }

    @Test
    public void expectScoreToBe0() {
        Assert.assertEquals(
                game.getScore(),
                0);
    }

    @Test
    public void expectTimeToBe0() {
        Assert.assertEquals(
                game.getTime(),
                0);
    }

    @Test
    public void expectLastDirectionToBeNone() {
        Assert.assertEquals(
                game.getLastDirection(),
                Direction.NONE);
    }

    @Test
    public void expectSnakeBodyToBeLength1() {
        Assert.assertEquals(
                game.getSnakeBody().length,
                1);
    }

    @Test
    public void expectFoodPositionsToBeLengthFoodCount() {
        Assert.assertEquals(
                game.getFoodPositions().length,
                game.getFoodCount());
    }

}
