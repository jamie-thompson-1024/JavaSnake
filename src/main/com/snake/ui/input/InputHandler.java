package com.snake.ui.input;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class InputHandler implements EventHandler<KeyEvent>,InputListener {

    private final List<InputListener> listeners = new ArrayList<>();

    public InputHandler() {
        super();
    }

    public void addInputListener(InputListener listener) {
        listeners.add(listener);
    }

    public void removeInputListener(InputListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void directionInput(InputDirection direction) {
        for(InputListener listener : listeners) {
            listener.directionInput(direction);
        }
    }

    @Override
    public void handle(KeyEvent e) {
        switch (e.getCode()) {
            case W, UP -> directionInput(InputDirection.UP);
            case A, LEFT -> directionInput(InputDirection.LEFT);
            case S, DOWN -> directionInput(InputDirection.DOWN);
            case D, RIGHT -> directionInput(InputDirection.RIGHT);
        }
    }

}
