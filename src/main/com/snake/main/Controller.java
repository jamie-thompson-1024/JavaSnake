package com.snake.main;

import com.snake.game.SnakeGame;
import com.snake.ui.SnakeUI;

public class Controller {

    private SnakeGame game;
    private SnakeUI ui;

    public Controller(SnakeGame game, SnakeUI ui) {
        this.game = game;
        this.ui = ui;
    }

    public Controller run() {
        return this;
    }
}
