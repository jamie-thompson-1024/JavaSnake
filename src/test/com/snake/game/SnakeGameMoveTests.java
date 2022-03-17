package com.snake.game;

import org.junit.*;

public class SnakeGameMoveTests {

    SnakeGame game;

    @Before
    public void initialise() {
        game = new SnakeGame();
    }

    @Test
    public void on_FirstMove_With_DirectionNone_Expect_Move_ToReturn_False() {
        Assert.assertEquals(
                game.move(Direction.NONE),
                false
        );
    }

    @Test
    public void on_FirstMove_With_DirectionUp_Expect_Move_ToReturn_True() {
        Assert.assertEquals(
                game.move(Direction.UP),
                true
        );
    }

    @Test
    public void on_FirstMove_With_DirectionLeft_Expect_Move_ToReturn_True() {
        Assert.assertEquals(
                game.move(Direction.LEFT),
                true
        );
    }

    @Test
    public void on_FirstMove_With_DirectionDown_Expect_Move_ToReturn_True() {
        Assert.assertEquals(
                game.move(Direction.DOWN),
                true
        );
    }

    @Test
    public void on_FirstMove_With_DirectionRight_Expect_Move_ToReturn_True() {
        Assert.assertEquals(
                game.move(Direction.RIGHT),
                true
        );
    }

    @Test
    public void on_GameStateStopped_Expect_Move_ToReturn_False() {
        game.setHeight(10);
        Assert.assertEquals(
                game.move(Direction.UP),
                false
        );
    }

    @Test
    public void on_GameStateWallCollision_Expect_Move_ToReturn_False() {
        game.setWidth(3);
        game.setHeight(3);
        game.resetGame();

        game.move(Direction.UP);
        game.move(Direction.UP);
        Assert.assertEquals(
                game.move(Direction.UP),
                false
        );
    }

    @Test
    public void on_GameStateSelfCollision_Expect_Move_ToReturn_False() {
        game.setWidth(3);
        game.setHeight(3);
        game.setFoodCount(8);
        game.resetGame();

        game.move(Direction.UP);
        game.move(Direction.LEFT);
        game.move(Direction.DOWN);
        game.move(Direction.RIGHT);
        Assert.assertEquals(
                game.move(Direction.RIGHT),
                false
        );
    }
}
