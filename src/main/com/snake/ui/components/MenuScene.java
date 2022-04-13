package com.snake.ui.components;

import com.snake.ui.data.UIDataListener;
import com.snake.util.Point;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class MenuScene extends Scene implements UIDataListener {

    private Label titleLabel;
    private Label instructionsLabel;
    private Slider sizeSlider;
    private Label highScoreLabel;
    private Label lastScoreLabel;
    private Button playButton;

    public MenuScene() {
        super(new GridPane());


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
