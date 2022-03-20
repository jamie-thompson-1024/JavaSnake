package com.snake.ui.components;

import com.snake.ui.data.UIDataHandler;
import com.snake.ui.data.UIDataListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class SnakeMenu extends JPanel implements ComponentListener, UIDataListener {

    JLabel titleLabel;
    JLabel instructionsLabel;
    JLabel scoreLabel;
    JLabel topScoreLabel;
    JButton playButton;

    JPanel dialogPanel;

    UIDataHandler dataHandler;

    public SnakeMenu(UIDataHandler dataHandler) {
        this.dataHandler = dataHandler;
        this.dataHandler.addInputListener(this);

        addComponentListener(this);
        setLayout(null);

        createComponents();
    }

    private void createComponents() {

        // create dialog panel
        dialogPanel = new JPanel();
        dialogPanel.setLayout(new GridBagLayout());
        add(dialogPanel);

        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.anchor = GridBagConstraints.CENTER;
        gridConstraints.weightx = 1;

        // create title label
        titleLabel = new JLabel("Snake");
        titleLabel.setForeground(new Color(200,200,200));
        gridConstraints.weighty = 0.25;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 2;
        dialogPanel.add(titleLabel, gridConstraints);

        // create instructions label
        instructionsLabel = new JLabel("Snake instructions");
        instructionsLabel.setForeground(new Color(200,200,200));
        gridConstraints.weighty = 1;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 2;
        dialogPanel.add(instructionsLabel, gridConstraints);

        // create score label
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(new Color(200,200,200));
        gridConstraints.weighty = 0.1;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        gridConstraints.gridwidth = 1;
        dialogPanel.add(scoreLabel, gridConstraints);

        // create top score label
        topScoreLabel = new JLabel("High Score: 0");
        topScoreLabel.setForeground(new Color(200,200,200));
        gridConstraints.weighty = 0.1;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        gridConstraints.gridwidth = 1;
        dialogPanel.add(topScoreLabel, gridConstraints);

        // create play button
        playButton = new JButton("Play");
        gridConstraints.weighty = 0.2;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        gridConstraints.gridwidth = 1;
        gridConstraints.gridheight = 2;
        dialogPanel.add(playButton, gridConstraints);

        resizeDialog();
    }

    public void setDialogBackground(Color color) {
        dialogPanel.setBackground(color);
    }

    private void resizeDialog() {
        int dialogWidth = getWidth() / 2;
        int dialogHeight = getHeight() / 2;

        int dialogX = dialogWidth / 2;
        int dialogY = dialogHeight / 2;

        dialogPanel.setBounds(
                dialogX, dialogY,
                dialogWidth, dialogHeight
        );
    }

    @Override
    public void componentResized(ComponentEvent e) {
        resizeDialog();
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
