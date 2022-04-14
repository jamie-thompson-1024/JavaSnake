package com.snake.ui.components;

import com.snake.ui.data.UIDataHandler;
import com.snake.ui.data.UIDataListener;
import com.snake.util.Point;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class MenuScene extends Scene implements UIDataListener {

    private Label titleLabel;
    private Label instructionsLabel;
    private Label sizeSliderLabel;
    private Slider sizeSlider;
    private Label highScoreLabel;
    private Label lastScoreLabel;
    private Button playButton;

    private UIDataHandler uiDataHandler;

    public MenuScene(UIDataHandler uiDataHandler) {
        super(new GridPane());

        this.uiDataHandler = uiDataHandler;

        createComponents();
        attachComponents();
    }

    private void createComponents() {
        titleLabel = new Label("Snake Game");

        instructionsLabel = new Label(" ~ ~ ~ Instructions ~ ~ ~ ");

        sizeSliderLabel = new Label();

        sizeSlider = new Slider();

        highScoreLabel = new Label("High Score: ");

        lastScoreLabel = new Label("Last Score: ");

        playButton = new Button("Play");
        playButton.setOnAction(arg0 -> uiDataHandler.onPlay());
    }

    public void attachComponents() {
        GridPane root = (GridPane)getRoot();

        /*
            |   titleLabel              |
            |   instructionsLabel       |
            |   sizeSliderLabel         |
            |   sizeSlider              |
            |   highScore   |   Play    |
            |   lastScore   |   Play    |
        */

        root.add(titleLabel, 0, 0, 2, 1);
        root.add(instructionsLabel, 0, 1, 2, 1);
        root.add(sizeSliderLabel, 0, 2, 2, 1);
        root.add(sizeSlider, 0, 3, 2, 1);
        root.add(highScoreLabel, 0, 4, 1, 1);
        root.add(lastScoreLabel, 0, 5, 1, 1);
        root.add(playButton, 1, 4, 1, 2);
    }

    @Override
    public void updateCanvas(Point[] foodPositions, Point[] snakeBody) {

    }

    @Override
    public void updateScore(int score) {
        lastScoreLabel.setText("Score: " + score);
    }

    @Override
    public void updateHighScore(int highScore) {
        highScoreLabel.setText("High Score: " + highScore);
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
