package com.snake.ui.scenes;

import com.snake.ui.data.UIDataHandler;
import com.snake.ui.data.UIDataListener;
import com.snake.util.Point;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class MenuScene implements UIDataListener {

    private final Label gameSizeSliderLabel;
    private final Slider gameSizeSlider;
    private final Label highScoreLabel;
    private final Label lastScoreLabel;
    private final Button playButton;

    private Scene scene;

    private UIDataHandler uiDataHandler;

    public MenuScene(UIDataHandler uiDataHandler) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxml/MenuScene.fxml"));

        try {
            scene = new Scene(loader.load());
        } catch(Exception e) {
            System.out.println(e);
            System.exit(1);
        }

        scene.getStylesheets().add(
                getClass().getResource("style/MenuScene.css").toExternalForm());
        scene.getStylesheets().add(
                getClass().getResource("style/Global.css").toExternalForm());

        gameSizeSliderLabel = (Label) scene.lookup("#gameSizeSliderLabel");
        gameSizeSlider = (Slider) scene.lookup("#gameSizeSlider");
        highScoreLabel = (Label) scene.lookup("#highScoreLabel");
        lastScoreLabel = (Label) scene.lookup("#lastScoreLabel");
        playButton = (Button) scene.lookup("#playButton");

        this.uiDataHandler = uiDataHandler;

        playButton.setOnAction((e) -> this.uiDataHandler.onPlay());
    }

    public Scene getScene() {
        return scene;
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
        gameSizeSliderLabel.setText("Game Size: " + width);
    }
}
