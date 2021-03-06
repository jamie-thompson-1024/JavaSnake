package com.snake.game;

import com.snake.util.Point;

import java.util.List;
import java.util.ArrayList;

public class SnakeGame {
    private final List<Point> snakeBody = new ArrayList<>();
    private final List<Point> foodPositions = new ArrayList<>();

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
        if(gameState != GameState.PLAYING)
            return false;

        direction = switch (direction)
        {
            // set direction to last if is reverse of lastDirection
            case UP -> (lastDirection == Direction.DOWN) ? lastDirection : direction;
            case RIGHT -> (lastDirection == Direction.LEFT) ? lastDirection : direction;
            case DOWN -> (lastDirection == Direction.UP) ? lastDirection : direction;
            case LEFT -> (lastDirection == Direction.RIGHT) ? lastDirection : direction;
            // set direction to last if is none
            case NONE -> lastDirection;
        };

        Point newPos;
        Point lastPos = snakeBody.get(0);
        newPos = switch (direction) {
            case UP -> new Point(lastPos.x, lastPos.y - 1);
            case RIGHT -> new Point(lastPos.x + 1, lastPos.y);
            case DOWN -> new Point(lastPos.x, lastPos.y + 1);
            case LEFT -> new Point(lastPos.x - 1, lastPos.y);
            // to remove might not be initialized error
            // should be impossible case, I think
            default -> new Point(0, 0);
        };

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
        Point foodEaten = null;
        for(Point pos : foodPositions) {
            if(pos.x == newPos.x && pos.y == newPos.y) {
                foodEaten = pos;
                break;
            }
        }

        if(foodEaten != null) {
            foodPositions.remove(foodEaten);
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

        int validFoodPositionCount = (width * height) - snakeBody.size();

        // make sure amount of food is equal to foodCount or validFoodPositionCount
        while(foodPositions.size() < foodCount && foodPositions.size() < validFoodPositionCount) {
            Point newPos = randomPoint();

            // check if new point is available
            boolean isOccupied = false;
            for(Point pos : foodPositions) {
                if(pos.x == newPos.x && pos.y == newPos.y) {
                    isOccupied = true;
                    break;
                }
            }
            for(Point pos : snakeBody) {
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
        if(gameState != GameState.PLAYING) {
            if(gameState == GameState.READY)
                gameState = GameState.STOPPED;

            height = newHeight;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int newWidth) {
        if(gameState != GameState.PLAYING) {
            if(gameState == GameState.READY)
                gameState = GameState.STOPPED;

            width = newWidth;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setFoodCount(int newFoodCount) {
        if(gameState != GameState.PLAYING) {
            if(gameState == GameState.READY)
                gameState = GameState.STOPPED;

            foodCount = newFoodCount;
        }
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
                new Point[0]
        );
    }

    public Point[] getFoodPositions() {
        return foodPositions.toArray(
                new Point[0]
        );
    }
}
