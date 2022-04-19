package com.snake.game;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeGameSetterTests {

    SnakeGame game;

    @BeforeEach
    public void initialiseGame() {
        game = new SnakeGame();
    }

    @Test
    public void expect_SetWidth_ToChange_GameState_From_Ready_To_Stopped() {
        game.setWidth(
                game.getWidth() + 10
        );
        assertEquals(
                GameState.STOPPED,
                game.getGameState()
        );
    }

    @Test
    public void expect_SetHeight_ToChange_GameState_From_Ready_To_Stopped() {
        game.setHeight(
                game.getHeight() + 10
        );
        assertEquals(
                GameState.STOPPED,
                game.getGameState()
        );
    }

    @Test
    public void expect_SetFoodCount_ToChange_GameState_From_Ready_To_Stopped() {
        game.setFoodCount(
                game.getFoodCount() + 5
        );
        assertEquals(
                GameState.STOPPED,
                game.getGameState()
        );
    }

    @Test
    public void on_gameState_Playing_Expect_SetFoodCount_NotToChange_FoodCount() {
        game.move(Direction.UP);
        int expected = game.getFoodCount();

        game.setFoodCount(
                game.getFoodCount() + 5
        );
        assertEquals(
                expected,
                game.getFoodCount()
        );
    }

    @Test
    public void on_gameState_Playing_Expect_SetWidth_NotToChange_Width() {
        game.move(Direction.UP);
        int expected = game.getWidth();

        game.setWidth(
                game.getWidth() + 5
        );
        assertEquals(
                expected,
                game.getWidth()
        );
    }

    @Test
    public void on_gameState_Playing_Expect_SetHeight_NotToChange_Height() {
        game.move(Direction.UP);
        int expected = game.getHeight();

        game.setHeight(
                game.getHeight() + 5
        );
        assertEquals(
                expected,
                game.getHeight()
        );
    }

    @Test
    public void expect_SetWidth_ToSet_Width_To_Expected() {
        int expected = game.getWidth() + 10;
        game.setWidth(
                expected
        );
        assertEquals(
                expected,
                game.getWidth()
        );
    }

    @Test
    public void expect_SetHeight_ToSet_Height_To_Expected() {
        int expected = game.getHeight() + 10;
        game.setHeight(
                expected
        );
        assertEquals(
                expected,
                game.getHeight()
        );
    }

    @Test
    public void expect_SetFoodCount_ToSet_FoodCount_To_Expected() {
        int expected = game.getFoodCount() + 10;
        game.setFoodCount(
                expected
        );
        assertEquals(
                expected,
                game.getFoodCount()
        );
    }
}
