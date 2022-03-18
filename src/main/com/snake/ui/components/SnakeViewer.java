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
        canvas.setBackground(Color.CYAN);
        add(canvas);

        // create score bar
        scoreBar = new SnakeScoreBar(dataHandler);
        scoreBar.setBackground(Color.GREEN);
        add(scoreBar);

        resizeComponents();
    }

    private void resizeComponents() {
        int scoreBarHeight = (int) (getHeight() * 0.1);

        // set score bar bounds
        if(scoreBar != null) scoreBar.setBounds(
                0, 0,
                getWidth(), scoreBarHeight
        );

        // set canvas bounds
        if(canvas != null) canvas.setBounds(
                0, scoreBarHeight,
                getWidth(), getHeight() - scoreBarHeight
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
