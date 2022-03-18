package com.snake.ui.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class InputHandler implements KeyListener,InputListener {

    private final List<InputListener> listeners = new ArrayList<>();

    public InputHandler() {}

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
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> directionInput(InputDirection.UP);
            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> directionInput(InputDirection.LEFT);
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> directionInput(InputDirection.DOWN);
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> directionInput(InputDirection.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
