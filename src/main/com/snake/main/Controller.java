package com.snake.main;

import com.snake.game.SnakeGame;
import com.snake.ui.SnakeUI;
import com.snake.ui.data.UIDataHandler;
import com.snake.ui.data.UIDataListener;
import com.snake.ui.input.InputDirection;
import com.snake.ui.input.InputListener;
import com.snake.util.Point;

import javafx.application.Application;
import javafx.stage.Stage;

public class Controller extends Application implements InputListener, UIDataListener {

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
        dataHandler.addInputListener(this);
        this.ui.getInputHandler().addInputListener(this);

        setup();
    }

    public void setup() {
        game.resetGame();

        dataHandler.updateHighScore(0);
        dataHandler.updateScore(0);
        dataHandler.updateSize(game.getWidth(), game.getHeight());
        dataHandler.updateCanvas(game.getFoodPositions(), game.getSnakeBody());
    }

    @Override
    public void directionInput(InputDirection direction) {

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

    }

    @Override
    public void onEnd() {

    }

    @Override
    public void updateSize(int width, int height) {

    }
}
