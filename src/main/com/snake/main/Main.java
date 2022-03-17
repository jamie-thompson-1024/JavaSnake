package com.snake.main;

import com.snake.game.SnakeGame;
import com.snake.ui.SnakeUI;

public class Main {

    public static void main(String[] argv) {
        System.out.println("Hello");

        Controller controller = new Controller(
                new SnakeGame(),
                new SnakeUI()
        ).run();
    }
}
