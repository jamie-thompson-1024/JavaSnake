package com.snake.ui;

import com.snake.ui.scenes.GameScene;
import com.snake.ui.scenes.MenuScene;
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

        gameScene.getScene().setOnKeyPressed(inputHandler);

        this.stage = stage;
        this.stage.setTitle("Java Snake");
        setInMenu(true);
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

        stage.setScene(inMenu ? menuScene.getScene() : gameScene.getScene());
        stage.sizeToScene();

        if(!this.inMenu)
            gameScene.drawGame();
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

    @Override
    public void updateTickDelay(int millis) {

    }

    @Override
    public void updateFoodCount(int foodCount) {

    }

}
