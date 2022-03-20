package com.snake.ui.components;

import com.snake.ui.data.UIDataHandler;
import com.snake.ui.data.UIDataListener;

import javax.swing.*;
import java.awt.*;

public class SnakeCanvas extends JPanel implements UIDataListener {

    static public boolean showGrid = false;
    static public Color gridColor = Color.WHITE;

    UIDataHandler dataHandler;

    Point[] foodPositions = {};
    Point[] snakeBody = {};

    int gameWidth = 10;
    int gameHeight = 10;

    Color boardBackgroundColor = Color.BLACK;
    Color snakeBodyColor = Color.WHITE;
    Color foodColor = Color.RED;

    public SnakeCanvas(UIDataHandler dataHandler) {
        this.dataHandler = dataHandler;
        this.dataHandler.addInputListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Insets insets = getInsets();
        int currentWidth = getWidth() - insets.left - insets.right;
        int currentHeight = getHeight() - insets.top - insets.bottom;

        Point origin = new Point(insets.left, insets.top);

        int squareSizeWidth = currentWidth / gameWidth;
        int squareSizeHeight = currentHeight / gameHeight;
        int squareSize = Math.min(squareSizeWidth, squareSizeHeight);

        int boardPaddingY = (currentHeight - (squareSize * gameHeight)) / 2;
        int boardPaddingX = (currentWidth - (squareSize * gameWidth)) / 2;

        g.setColor(boardBackgroundColor);
        g.fillRect(
                origin.x + boardPaddingX, origin.y + boardPaddingY,
                squareSize * gameWidth, squareSize * gameHeight
        );

        if(showGrid) {
            g.setColor(gridColor);
            for (int y = 0; y < gameHeight; y++) {
                g.drawLine(
                        origin.x, origin.y + (y * squareSize) + boardPaddingY,
                        origin.x + currentWidth, origin.y + (y * squareSize) + boardPaddingY
                );
            }
            for (int x = 0; x < gameWidth; x++) {
                g.drawLine(
                        origin.x + (x * squareSize) + boardPaddingX, origin.y,
                        origin.x + (x * squareSize) + boardPaddingX, origin.y + currentHeight
                );
            }
        }

        g.setColor(foodColor);
        for(Point food : foodPositions) {
            g.fillRect(
                    origin.x + (food.x * squareSize) + boardPaddingX,
                    origin.y + (food.y * squareSize) + boardPaddingY,
                    squareSize, squareSize
            );
        }

        g.setColor(snakeBodyColor);
        for(Point snakeSegment : snakeBody) {
            g.fillRect(
                    origin.x + (snakeSegment.x * squareSize) + boardPaddingX,
                    origin.y + (snakeSegment.y * squareSize) + boardPaddingY,
                    squareSize, squareSize
            );
        }
    }

    @Override
    public void updateCanvas(Point[] foodPositions, Point[] snakeBody) {
        this.foodPositions = foodPositions;
        this.snakeBody = snakeBody;

        invalidate();
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
        gameWidth = width;
        gameHeight = height;

        invalidate();
    }

}
