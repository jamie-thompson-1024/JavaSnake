package com.snake.game;

import org.junit.*;

import com.snake.util.Point;

public class SnakeGameMoveTests {

    SnakeGame game;

    @Before
    public void initialise() {
        game = new SnakeGame();
    }

    @Test
    public void on_FirstMove_With_DirectionNone_Expect_Move_ToReturn_False() {
        Assert.assertFalse(
                game.move(Direction.NONE)
        );
    }

    @Test
    public void on_FirstMove_With_DirectionUp_Expect_Move_ToReturn_True() {
        Assert.assertTrue(
                game.move(Direction.UP)
        );
    }

    @Test
    public void on_FirstMove_With_DirectionLeft_Expect_Move_ToReturn_True() {
        Assert.assertTrue(
                game.move(Direction.LEFT)
        );
    }

    @Test
    public void on_FirstMove_With_DirectionDown_Expect_Move_ToReturn_True() {
        Assert.assertTrue(
                game.move(Direction.DOWN)
        );
    }

    @Test
    public void on_FirstMove_With_DirectionRight_Expect_Move_ToReturn_True() {
        Assert.assertTrue(
                game.move(Direction.RIGHT)
        );
    }

    @Test
    public void on_GameStateStopped_Expect_Move_ToReturn_False() {
        game.setHeight(10);
        Assert.assertFalse(
                game.move(Direction.UP)
        );
    }

    @Test
    public void after_FirstMove_Expect_Age_ToBe_1() {
        game.move(Direction.UP);
        Assert.assertEquals(
                1,
                game.getTime()
        );
    }

    @Test
    public void after_MoveUp_Expect_Head_toMove_Up1() {
        Point oldHead = game.getSnakeBody()[0];
        game.move(Direction.UP);
        Point newHead = game.getSnakeBody()[0];
        Assert.assertTrue(
                oldHead.x == newHead.x &&
                        oldHead.y - 1 == newHead.y
        );
    }

    @Test
    public void after_MoveRight_Expect_Head_toMove_Right1() {
        Point oldHead = game.getSnakeBody()[0];
        game.move(Direction.RIGHT);
        Point newHead = game.getSnakeBody()[0];
        Assert.assertTrue(
                oldHead.x + 1 == newHead.x &&
                        oldHead.y == newHead.y
        );
    }

    @Test
    public void after_MoveDown_Expect_Head_toMove_Down1() {
        Point oldHead = game.getSnakeBody()[0];
        game.move(Direction.DOWN);
        Point newHead = game.getSnakeBody()[0];
        Assert.assertTrue(
                oldHead.x == newHead.x &&
                        oldHead.y + 1 == newHead.y
        );
    }

    @Test
    public void after_MoveLeft_Expect_Head_toMove_Left1() {
        Point oldHead = game.getSnakeBody()[0];
        game.move(Direction.LEFT);
        Point newHead = game.getSnakeBody()[0];
        Assert.assertTrue(
                oldHead.x - 1 == newHead.x &&
                        oldHead.y == newHead.y
        );
    }

    @Test
    public void after_MovingOverFood_Expect_SnakeBodyLength_ToBe_2() {
        game.setWidth(3);
        game.setHeight(3);
        game.setFoodCount(9);
        game.resetGame();

        game.move(Direction.UP);
        Assert.assertEquals(
                2,
                game.getSnakeBody().length
        );
    }

    @Test
    public void after_MovingOverFood_Expect_Score_ToBe_1() {
        game.setWidth(3);
        game.setHeight(3);
        game.setFoodCount(9);
        game.resetGame();

        game.move(Direction.UP);
        Assert.assertEquals(
                1,
                game.getScore()
        );
    }

    @Test
    public void on_WallCollision_Expect_Move_ToReturn_False() {
        game.setWidth(3);
        game.setHeight(3);
        game.resetGame();

        game.move(Direction.UP);
        Assert.assertFalse(
                game.move(Direction.UP)
        );
    }

    @Test
    public void on_GameStateWallCollision_Expect_Move_ToReturn_False() {
        game.setWidth(3);
        game.setHeight(3);
        game.resetGame();

        game.move(Direction.UP);
        game.move(Direction.UP);
        Assert.assertFalse(
                game.move(Direction.UP)
        );
    }

    @Test
    public void after_WallCollision_Expect_GameState_ToBe_WallCollision() {
        game.setWidth(3);
        game.setHeight(3);
        game.resetGame();

        game.move(Direction.UP);
        game.move(Direction.UP);
        Assert.assertEquals(
                GameState.WALL_COLLISION,
                game.getGameState()
        );
    }

    @Test
    public void on_SelfCollision_Expect_Move_ToReturn_False() {
        game.setWidth(3);
        game.setHeight(3);
        game.setFoodCount(9);
        game.resetGame();

        game.move(Direction.UP);
        game.move(Direction.LEFT);
        game.move(Direction.DOWN);

        Assert.assertFalse(
                game.move(Direction.RIGHT)
        );
    }

    @Test
    public void on_GameState_SelfCollision_Expect_Move_ToReturn_False() {
        game.setWidth(3);
        game.setHeight(3);
        game.setFoodCount(9);
        game.resetGame();

        game.move(Direction.UP);
        game.move(Direction.LEFT);
        game.move(Direction.DOWN);
        game.move(Direction.RIGHT);

        Assert.assertFalse(
                game.move(Direction.RIGHT)
        );
    }

    @Test
    public void after_SelfCollision_Expect_GameState_ToBe_SelfCollision() {
        game.setWidth(3);
        game.setHeight(3);
        game.setFoodCount(9);
        game.resetGame();

        game.move(Direction.UP);
        game.move(Direction.LEFT);
        game.move(Direction.DOWN);
        game.move(Direction.RIGHT);

        Assert.assertEquals(
                GameState.SELF_COLLISION,
                game.getGameState()
        );
    }
}
