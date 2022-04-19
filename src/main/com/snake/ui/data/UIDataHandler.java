package com.snake.ui.data;

import com.snake.ui.input.InputListener;

import com.snake.util.Point;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;

public class UIDataHandler implements UIDataListener {
    private final List<UIDataListener> listeners = new ArrayList<>();

    public UIDataHandler() {}

    public void addInputListener(UIDataListener listener) {
        listeners.add(listener);
    }

    public void removeInputListener(UIDataListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void updateCanvas(Point[] foodPositions, Point[] snakeBody) {
        Platform.runLater(() -> {
            for (UIDataListener listener : listeners) {
                listener.updateCanvas(foodPositions, snakeBody);
            }
        });
    }

    @Override
    public void updateScore(int score) {
        Platform.runLater(() -> {
            for (UIDataListener listener : listeners) {
                listener.updateScore(score);
            }
        });
    }

    @Override
    public void updateHighScore(int highScore) {
        Platform.runLater(() -> {
            for (UIDataListener listener : listeners) {
                listener.updateHighScore(highScore);
            }
        });
    }

    @Override
    public void onPlay() {
        Platform.runLater(() -> {
            for (UIDataListener listener : listeners) {
                listener.onPlay();
            }
        });
    }

    @Override
    public void onEnd() {
        Platform.runLater(() -> {
            for (UIDataListener listener : listeners) {
                listener.onEnd();
            }
        });
    }

    @Override
    public void updateSize(int width, int height) {
        for (UIDataListener listener : listeners) {
            listener.updateSize(width, height);
        }
    }

    @Override
    public void updateTickDelay(int millis) {
        for (UIDataListener listener : listeners) {
            listener.updateTickDelay(millis);
        }
    }

    @Override
    public void updateFoodCount(int foodCount) {
        for (UIDataListener listener : listeners) {
            listener.updateFoodCount(foodCount);
        }
    }
}
