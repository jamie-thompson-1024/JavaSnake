package com.snake.main;

import com.snake.game.Direction;
import com.snake.game.GameState;
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

    private int highScore = 0;

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

        dataHandler.updateHighScore(highScore);
        dataHandler.updateScore(0);
        dataHandler.updateSize(game.getWidth(), game.getHeight());
        dataHandler.updateCanvas(game.getFoodPositions(), game.getSnakeBody());
    }

    public void move(Direction direction) {
        if (game.move(direction)) {
            dataHandler.updateCanvas(game.getFoodPositions(), game.getSnakeBody());
            dataHandler.updateScore(game.getScore());
            if(game.getScore() > highScore)
                highScore = game.getScore();
        } else {
            dataHandler.onEnd();
        }
    }

    @Override
    public void directionInput(InputDirection direction) {
        Direction gameDirection = switch (direction) {
            case UP -> Direction.UP;
            case DOWN -> Direction.DOWN;
            case LEFT -> Direction.LEFT;
            case RIGHT -> Direction.RIGHT;
        };

        switch (game.getGameState()) {
            case READY:
                move(gameDirection);
                break;
            case PLAYING:
                move(gameDirection);
                break;
        }
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
        game.resetGame();
    }

    @Override
    public void onEnd() {

    }

    @Override
    public void updateSize(int width, int height) {
        game.setWidth(width);
        game.setHeight(height);
    }
}
