package com.snake.ui.components;

import com.snake.ui.data.UIDataHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class SnakeViewer extends JPanel implements ComponentListener {

    SnakeCanvas canvas;
    SnakeScoreBar scoreBar;

    UIDataHandler dataHandler;

    public SnakeViewer(UIDataHandler dataHandler) {
        this.dataHandler = dataHandler;
        addComponentListener(this);
        setLayout(null);

        createComponents();
    }

    private void createComponents() {

        // create game canvas
        canvas = new SnakeCanvas(dataHandler);
        canvas.setBackground(Color.DARK_GRAY);
        add(canvas);

        // create score bar
        scoreBar = new SnakeScoreBar(dataHandler);
        scoreBar.setBackground(Color.DARK_GRAY);
        scoreBar.setForeground(Color.LIGHT_GRAY);
        add(scoreBar);

        resizeComponents();
    }

    private void resizeComponents() {

        Insets insets = getInsets();
        int currentWidth = getWidth() - insets.left - insets.right;
        int currentHeight = getHeight() - insets.top - insets.bottom;

        int scoreBarHeight = (int) (currentHeight * 0.1);

        // set score bar bounds
        if(scoreBar != null) scoreBar.setBounds(
                insets.left, insets.top,
                currentWidth, scoreBarHeight
        );

        // set canvas bounds
        if(canvas != null) canvas.setBounds(
                insets.left, insets.top + scoreBarHeight,
                currentWidth, currentHeight - scoreBarHeight
        );
    }

    @Override
    public void componentResized(ComponentEvent e) {
        resizeComponents();
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
