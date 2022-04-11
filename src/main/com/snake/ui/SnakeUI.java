package com.snake.ui;

import com.snake.ui.data.UIDataHandler;
import com.snake.ui.data.UIDataListener;
import com.snake.ui.input.InputHandler;

import com.snake.util.Point;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SnakeUI extends Application implements UIDataListener {

    private boolean inMenu = true;

    private final InputHandler inputHandler = new InputHandler();
    private final UIDataHandler dataHandler = new UIDataHandler();

    public SnakeUI() {

        dataHandler.addInputListener(this);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Text text = new Text(10, 40, "Hello World!");
        text.setFont(new Font(40));
        Scene scene = new Scene(new Group(text));

        stage.setTitle("Welcome to JavaFX!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
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
