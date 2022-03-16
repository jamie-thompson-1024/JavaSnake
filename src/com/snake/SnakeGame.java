package com.snake;

import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

public class SnakeGame {
    private List<Point> snakeBody = new ArrayList<>();
    private List<Point> foodPositions = new ArrayList<>();

    private int time = 0;
    private int score = 0;
    private GameState gameState = GameState.STOPPED;
    private Direction lastDirection = Direction.NONE;

    private int width = 10;
    private int height = 10;
    private int foodCount = 1;

    public SnakeGame()
    {
        resetGame();
    }

    public void resetGame()
    {
        gameState = GameState.READY;

        snakeBody.clear();
        snakeBody.add(new Point(width / 2, height / 2));

        foodPositions.clear();
        spawnFood();

        time = 0;
        score = 0;
        lastDirection = Direction.NONE;
    }

    public boolean move(Direction direction)
    {
        // set game to playing state if in ready state and direction not none
        // only allow first move with direction that is not NONE
        if(gameState == GameState.READY)
            if(direction == Direction.NONE)
                return false;
            else
                gameState = GameState.PLAYING;

        // only allow move if game is in PLAYING state
        if(gameState == GameState.PLAYING)
            return false;

        switch (direction)
        {
            // set direction to last if is reverse of lastDirection
            case UP:
                if(lastDirection == Direction.DOWN)
                    direction = lastDirection;
                break;
            case RIGHT:
                if(lastDirection == Direction.LEFT)
                    direction = lastDirection;
                break;
            case DOWN:
                if(lastDirection == Direction.UP)
                    direction = lastDirection;
                break;
            case LEFT:
                if(lastDirection == Direction.RIGHT)
                    direction = lastDirection;
                break;
            // set direction to last if is none
            case NONE:
                direction = lastDirection;
        }

        Point newPos;
        Point lastPos = snakeBody.get(0);
        switch (direction)
        {
            case UP:
                newPos = new Point(lastPos.x, lastPos.y - 1);
                break;
            case RIGHT:
                newPos = new Point(lastPos.x + 1, lastPos.y);
                break;
            case DOWN:
                newPos = new Point(lastPos.x, lastPos.y + 1);
                break;
            case LEFT:
                newPos = new Point(lastPos.x - 1, lastPos.y);
                break;
            default:
                // to remove might not be initialized error
                // should be impossible case, I think
                newPos = new Point(0,0);
        }

        // end game if out of bounds
        if(
            newPos.x > width ||
            newPos.x < 0 ||
            newPos.y > height ||
            newPos.y < 0
        )
        {
            gameState = GameState.WALL_COLLISION;
            return false;
        }

        // end game if collision with self
        for(Point pos : snakeBody) {
            if (pos.x == newPos.x && pos.y == newPos.y) {
                gameState = GameState.SELF_COLLISION;
                return false;
            }
        }

        snakeBody.add(0, newPos);

        // check if food eaten
        boolean foodEaten = false;
        for(Point pos : foodPositions) {
            if(pos.x == newPos.x && pos.y == newPos.y) {
                foodEaten = true;
                break;
            }
        }

        if(foodEaten) {
            spawnFood();
            ++score;
        } else {
            snakeBody.remove(snakeBody.size() - 1);
        }

        time++;
        lastDirection = direction;
        return true;
    }

    private void spawnFood()
    {
        // make sure amount of food is equal to foodCount
        while(foodPositions.size() < foodCount) {
            Point newPos = randomPoint();

            // check if new point is available
            boolean isOccupied = false;
            for(Point pos : foodPositions) {
                if(pos.x == newPos.x && pos.y == newPos.y) {
                    isOccupied = true;
                    break;
                }
            }

            if(!isOccupied)
                foodPositions.add(newPos);
        }
    }

    private Point randomPoint()
    {
        return new Point(
                (int) Math.floor(Math.random() * width),
                (int) Math.floor(Math.random() * height)
        );
    }

    public void setHeight(int newHeight) {
        if(gameState != GameState.PLAYING && gameState != GameState.READY)
            height = newHeight;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int newWidth) {
        if(gameState != GameState.PLAYING && gameState != GameState.READY)
            height = newWidth;
    }

    public int getWidth() {
        return width;
    }

    public void setFoodCount(int newFoodCount) {
        if(gameState != GameState.PLAYING && gameState != GameState.READY)
            foodCount = newFoodCount;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public int getTime() {
        return time;
    }

    public int getScore() {
        return score;
    }

    public Direction getLastDirection() {
        return lastDirection;
    }

    public GameState getGameState() {
        return gameState;
    }

    public Point[] getSnakeBody() {
        return snakeBody.toArray(
                new Point[snakeBody.size()]
        );
    }

    public Point[] getFoodPositions() {
        return foodPositions.toArray(
                new Point[foodPositions.size()]
        );
    }
}
