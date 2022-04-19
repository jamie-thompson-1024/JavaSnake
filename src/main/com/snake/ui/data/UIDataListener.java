package com.snake.ui.data;

import com.snake.util.Point;

public interface UIDataListener {
    void updateCanvas(Point[] foodPositions, Point[] snakeBody);
    void updateScore(int score);
    void updateHighScore(int highScore);
    void onPlay();
    void onEnd();
    void updateSize(int width, int height);
    void updateTickDelay(int millis);
    void updateFoodCount(int foodCount);
}
