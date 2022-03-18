package com.snake.main;

import com.snake.game.SnakeGame;
import com.snake.ui.SnakeUI;
import com.snake.ui.data.UIDataHandler;
import com.snake.ui.input.InputDirection;
import com.snake.ui.input.InputListener;

public class Controller implements InputListener {

    private final SnakeGame game;
    private final SnakeUI ui;

    private final UIDataHandler dataHandler;

    public Controller(SnakeGame game, SnakeUI ui) {
        this.game = game;
        this.ui = ui;

        dataHandler = this.ui.getDataHandler();
        this.ui.getInputHandler().addInputListener(this);
    }

    public Controller run() {
        return this;
    }

    @Override
    public void directionInput(InputDirection direction) {

    }
}
