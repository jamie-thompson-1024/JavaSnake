package com.snake.ui;

import com.snake.ui.data.UIDataHandler;
import com.snake.ui.data.UIDataListener;
import com.snake.ui.input.InputHandler;

import java.awt.*;

public class SnakeUI implements UIDataListener {

    private boolean inMenu = true;

    private final InputHandler inputHandler = new InputHandler();
    private final UIDataHandler dataHandler = new UIDataHandler();

    public SnakeUI() {

        dataHandler.addInputListener(this);
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }
    public UIDataHandler getDataHandler() {
        return dataHandler;
    }

    public void setInMenu(boolean inMenu) {
        this.inMenu = inMenu;
    }

    @Override
    public void updateCanvas(Point[] foodPositions, Point[] snakeBody) {

    }

    @Override
    public void updateScore(int score) {

    }

    @Override
    public void updateHighScore(int highScore) {

    }

    @Override
    public void onPlay() {
        setInMenu(false);
    }

    @Override
    public void onEnd() {
        setInMenu(true);
    }

    @Override
    public void updateSize(int width, int height) {

    }
}
