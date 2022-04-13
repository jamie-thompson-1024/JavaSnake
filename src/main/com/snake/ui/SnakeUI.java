package com.snake.ui;

import com.snake.ui.components.GameScene;
import com.snake.ui.components.MenuScene;
import com.snake.ui.data.UIDataHandler;
import com.snake.ui.data.UIDataListener;
import com.snake.ui.input.InputHandler;

import com.snake.util.Point;
import javafx.application.Application;
import javafx.stage.Stage;

public class SnakeUI extends Application implements UIDataListener {

    private boolean inMenu = true;

    private final InputHandler inputHandler = new InputHandler();
    private final UIDataHandler dataHandler = new UIDataHandler();

    private GameScene gameScene;
    private MenuScene menuScene;

    private Stage stage;

    public SnakeUI() {
        dataHandler.addInputListener(this);
    }

    public void run() {
        launch();
    }

    @Override
    public void init() {

    }

    @Override
    public void start(Stage stage) throws Exception {

        menuScene = new MenuScene();
        gameScene = new GameScene();

        dataHandler.addInputListener(menuScene);
        dataHandler.addInputListener(gameScene);

        gameScene.setOnKeyPressed(inputHandler);

        this.stage = stage;
        this.stage.setTitle("Java Snake");
        this.stage.setScene(inMenu ? menuScene : gameScene);
        this.stage.sizeToScene();
        this.stage.show();
    }

    @Override
    public void stop() {

    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }
    public UIDataHandler getDataHandler() {
        return dataHandler;
    }

    public void setInMenu(boolean inMenu) {
        this.inMenu = inMenu;

        stage.setScene(inMenu ? menuScene : gameScene);
        stage.sizeToScene();
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
