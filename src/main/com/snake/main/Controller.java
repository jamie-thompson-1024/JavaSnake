package com.snake.main;

import com.snake.game.SnakeGame;
import com.snake.ui.SnakeUI;
import com.snake.ui.data.UIDataHandler;
import com.snake.ui.input.InputDirection;
import com.snake.ui.input.InputListener;
import javafx.application.Application;
import javafx.stage.Stage;

public class Controller extends Application implements InputListener {

    private SnakeGame game;
    private SnakeUI ui;

    private UIDataHandler dataHandler;

    public Controller() {
        super();
    }

    public static void main(String[] argv) {
        System.out.println("Hello");

        Controller.launch(argv);
    }

    @Override
    public void start(Stage stage) {
        this.game = new SnakeGame();
        this.ui = new SnakeUI(stage);

        dataHandler = this.ui.getDataHandler();
        this.ui.getInputHandler().addInputListener(this);

        setup();
    }

    public void setup() {
        dataHandler.updateScore(0);
        dataHandler.updateHighScore(0);
    }

    @Override
    public void directionInput(InputDirection direction) {

    }
}
