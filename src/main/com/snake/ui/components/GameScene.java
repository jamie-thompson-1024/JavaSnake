package com.snake.ui.components;

import com.snake.ui.data.UIDataListener;
import com.snake.util.Point;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class GameScene extends Scene implements UIDataListener {

    private Label scoreLabel;
    private Label topScoreLabel;
    private Canvas gameCanvas;

    public GameScene() {
        super(new StackPane());

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
