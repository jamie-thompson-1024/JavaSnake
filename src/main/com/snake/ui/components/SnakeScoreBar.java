package com.snake.ui.components;

import com.snake.ui.data.UIDataHandler;

import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class SnakeScoreBar extends JPanel implements ComponentListener {

    JLabel scoreLabel;
    JLabel topScoreLabel;

    UIDataHandler dataHandler;

    public SnakeScoreBar(UIDataHandler dataHandler) {
        this.dataHandler = dataHandler;
        addComponentListener(this);
        setLayout(null);

        createComponents();
    }

    private void createComponents() {

        // create score label
        scoreLabel = new JLabel();
        add(scoreLabel);

        // create top score label
        topScoreLabel = new JLabel();
        add(topScoreLabel);

        resizeComponents();
    }

    private void resizeComponents() {

        // set score label bounds
        if(scoreLabel != null) scoreLabel.setBounds(
                0, 0,
                0, 0
        );

        // set top score label bounds
        if(topScoreLabel != null) topScoreLabel.setBounds(
                0, 0,
                0, 0
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
