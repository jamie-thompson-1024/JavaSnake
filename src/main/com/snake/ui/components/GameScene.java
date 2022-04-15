package com.snake.ui.components;

import com.snake.ui.data.UIDataListener;
import com.snake.util.Point;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

public class GameScene implements UIDataListener {

    private Label scoreLabel;
    private Label topScoreLabel;
    private Canvas gameCanvas;

    private Scene scene;

    public GameScene() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("GameScene.fxml"));

        try {
            scene = new Scene(loader.load());
        } catch(Exception e) {
            System.out.println(e);
            System.exit(1);
        }

        scoreLabel = (Label) scene.lookup("#scoreLabel");
        topScoreLabel = (Label) scene.lookup("#highScoreLabel");
        gameCanvas = (Canvas) scene.lookup("#gameCanvas");
    }

    public Scene getScene() {
        return scene;
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
