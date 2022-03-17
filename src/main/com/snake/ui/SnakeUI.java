package com.snake.ui;

import javax.swing.*;
import java.awt.*;

public class SnakeUI {

    private boolean inMenu = true;

    final private Toolkit awtToolkit = Toolkit.getDefaultToolkit();

    private JFrame frame;
    private JPanel menu;
    private JPanel game;

    public SnakeUI() {

        // Create window
        frame = new JFrame();

        Dimension screenSize = awtToolkit.getScreenSize();
        Point screenCenter = new Point(screenSize.width / 2, screenSize.height / 2);
        int frameSize = (int) (Math.min(screenSize.height, screenSize.width) * 0.65);

        frame.setBounds(
                screenCenter.x - (frameSize / 2), screenCenter.y - (frameSize / 2),
                frameSize, frameSize
        );
        frame.setTitle("Snake");
        frame.setIconImage(null);
        frame.setLayout(null);
        frame.setVisible(true);

        // Create menu panel
        menu = new JPanel();
        menu.setBackground(Color.BLUE);
        menu.setSize(frameSize, frameSize);
        menu.setVisible(inMenu);
        frame.add(menu);

        // Create game panel
        game = new JPanel();
        game.setBackground(Color.RED);
        game.setSize(frameSize, frameSize);
        game.setVisible(!inMenu);
        frame.add(game);
    }

    private void resize() {
        Dimension frameSize = frame.getSize();
        menu.setSize(frameSize);
        game.setSize(frameSize);
    }
}
