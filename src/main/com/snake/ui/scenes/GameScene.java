package com.snake.ui.scenes;

import com.snake.ui.data.UIDataListener;
import com.snake.util.Point;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class GameScene implements UIDataListener {

    private Point[] snakeBody;
    private Point[] foodPositions;

    private int gameSize;

    private Label scoreLabel;
    private Label topScoreLabel;
    private Canvas gameCanvas;

    private Scene scene;

    public GameScene() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxml/GameScene.fxml"));

        try {
            scene = new Scene(loader.load());
        } catch(Exception e) {
            System.out.println(e);
            System.exit(1);
        }

        scene.getStylesheets().add(
                getClass().getResource("style/GameScene.css").toExternalForm());
        scene.getStylesheets().add(
                getClass().getResource("style/Global.css").toExternalForm());

        scoreLabel = (Label) scene.lookup("#scoreLabel");
        topScoreLabel = (Label) scene.lookup("#highScoreLabel");
        gameCanvas = (Canvas) scene.lookup("#gameCanvas");
    }

    public Scene getScene() {
        return scene;
    }

    public void drawGame() {
        GraphicsContext ctx = gameCanvas.getGraphicsContext2D();

        double sqSize = gameCanvas.getWidth() / gameSize;

        ctx.setFill(Color.valueOf("#111"));
        ctx.fillRect(0, 0, sqSize * gameSize, sqSize * gameSize);

        ctx.setFill(Color.valueOf("#F00"));
        for( Point food : foodPositions)
            ctx.fillRect(food.x * sqSize, food.y * sqSize, sqSize, sqSize);

        ctx.setFill(Color.valueOf("#FFF"));
        for( Point snakeSeg : snakeBody)
            ctx.fillRect(snakeSeg.x * sqSize, snakeSeg.y * sqSize, sqSize, sqSize);
    }

    @Override
    public void updateCanvas(Point[] foodPositions, Point[] snakeBody) {
        this.snakeBody = snakeBody;
        this.foodPositions = foodPositions;

        drawGame();
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
        gameSize = width;
    }

    @Override
    public void updateTickDelay(int millis) {

    }

    @Override
    public void updateFoodCount(int foodCount) {

    }
}
