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
    private int timeDelay = 600;
    private Direction direction;

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
        dataHandler.updateTickDelay(timeDelay);
        dataHandler.updateFoodCount(game.getFoodCount());
    }

    public boolean move(Direction direction) {
            boolean out = game.move(direction);
            dataHandler.updateCanvas(game.getFoodPositions(), game.getSnakeBody());
            dataHandler.updateScore(game.getScore());
            if(game.getScore() > highScore)
                highScore = game.getScore();
            return out;
    }

    @Override
    public void directionInput(InputDirection direction) {
        Direction gameDirection = switch (direction) {
            case UP -> Direction.UP;
            case DOWN -> Direction.DOWN;
            case LEFT -> Direction.LEFT;
            case RIGHT -> Direction.RIGHT;
        };

        this.direction = gameDirection;

        if(game.getGameState() == GameState.READY) {
            new Thread(() -> startLoop()).start();
        }
    }

    private long getMillis() {
        return System.nanoTime() / 1000000;
    }

    private void startLoop() {
        long lastTime = 0;

        while(true) {
            if(getMillis() - lastTime > timeDelay) {
                if(!move(direction))
                    break;

                direction = Direction.NONE;
                lastTime = getMillis();
            }
        }


        dataHandler.onEnd();
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

    @Override
    public void updateTickDelay(int millis) {
        timeDelay = millis;
    }

    @Override
    public void updateFoodCount(int foodCount) {
        game.setFoodCount(foodCount);
    }
}
