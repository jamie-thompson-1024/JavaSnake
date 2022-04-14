package com.snake.ui.components;

import com.snake.ui.data.UIDataListener;
import com.snake.util.Point;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GameScene extends Scene implements UIDataListener {

    private Label scoreLabel;
    private Label topScoreLabel;
    private Canvas gameCanvas;

    public GameScene() {
        super(new GridPane());

        createComponents();
        attachComponents();
    }

    private void createComponents() {
        scoreLabel = new Label("Score: ");

        topScoreLabel = new Label("High Score: ");

        gameCanvas = new Canvas();
    }

    public void attachComponents() {
        GridPane root = (GridPane)getRoot();

        /*
            |   scoreLabel  |   topScoreLabel   |
            |           gameCanvas              |
         */

        root.add(scoreLabel, 0, 0, 1, 1);
        root.add(topScoreLabel, 1, 0, 1, 1);
        root.add(gameCanvas, 0, 1, 2, 1);
    }

    @Override
    public void updateCanvas(Point[] foodPositions, Point[] snakeBody) {

    }

    @Override
    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    @Override
    public void updateHighScore(int highScore) {
        topScoreLabel.setText("High Score: " + highScore);
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
