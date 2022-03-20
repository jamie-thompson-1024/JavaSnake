package com.snake.ui.components;

import com.snake.ui.data.UIDataHandler;
import com.snake.ui.data.UIDataListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class SnakeScoreBar extends JPanel implements ComponentListener, UIDataListener {

    JLabel scoreLabel;
    JLabel topScoreLabel;

    UIDataHandler dataHandler;

    public SnakeScoreBar(UIDataHandler dataHandler) {
        this.dataHandler = dataHandler;
        this.dataHandler.addInputListener(this);

        addComponentListener(this);
        setLayout(null);

        createComponents();
    }

    private void createComponents() {

        // create score label
        scoreLabel = new JLabel("Score: 0");
        add(scoreLabel);

        // create top score label
        topScoreLabel = new JLabel("High score: 0");
        add(topScoreLabel);

        resizeComponents();
    }

    private void resizeComponents() {

        // set score label bounds
        if(scoreLabel != null) scoreLabel.setBounds(
                0, 0,
                getWidth() / 2, getHeight()
        );

        // set top score label bounds
        if(topScoreLabel != null) topScoreLabel.setBounds(
                getWidth() / 2, 0,
                getWidth() / 2, getHeight()
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

    @Override
    public void updateCanvas(Point[] foodPositions, Point[] snakeBody) {

    }

    @Override
    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    @Override
    public void updateHighScore(int highScore) {
        topScoreLabel.setText("High Score: " + highScore);
    }

    @Override
    public void onPlay() {

    }

    @Override
    public void onEnd() {

    }

    @Override
    public void updateSize(int width, int height) {

    }
}
