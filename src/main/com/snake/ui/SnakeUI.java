package com.snake.ui;

import com.snake.main.Controller;
import com.snake.ui.components.GameScene;
import com.snake.ui.components.MenuScene;
import com.snake.ui.data.UIDataHandler;
import com.snake.ui.data.UIDataListener;
import com.snake.ui.input.InputHandler;

import com.snake.util.Point;
import javafx.stage.Stage;

public class SnakeUI implements UIDataListener {

    private boolean inMenu = true;

    private final InputHandler inputHandler = new InputHandler();
    private final UIDataHandler dataHandler = new UIDataHandler();

    private GameScene gameScene;
    private MenuScene menuScene;

    private Stage stage;

    public SnakeUI(Stage stage) {
        dataHandler.addInputListener(this);

        menuScene = new MenuScene(dataHandler);
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
