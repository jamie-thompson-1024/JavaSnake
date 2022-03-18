package com.snake.ui.components;

import com.snake.ui.data.UIDataHandler;

import javax.swing.*;
import java.awt.*;

public class SnakeCanvas extends JPanel {

    UIDataHandler dataHandler;

    public SnakeCanvas(UIDataHandler dataHandler) {
        this.dataHandler = dataHandler;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
