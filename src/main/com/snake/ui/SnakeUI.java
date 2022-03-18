package com.snake.ui;

import com.snake.ui.components.SnakeMenu;
import com.snake.ui.components.SnakeViewer;
import com.snake.ui.data.UIDataHandler;
import com.snake.ui.input.InputHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class SnakeUI extends JFrame implements ComponentListener {

    private boolean inMenu = true;

    private final InputHandler inputHandler = new InputHandler();
    private final UIDataHandler dataHandler = new UIDataHandler();

    private SnakeMenu menu;
    private SnakeViewer game;

    public SnakeUI() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point screenCenter = new Point(screenSize.width / 2, screenSize.height / 2);
        int frameSize = (int) (Math.min(screenSize.height, screenSize.width) * 0.65);

        setBounds(
                screenCenter.x - (frameSize / 2), screenCenter.y - (frameSize / 2),
                frameSize, frameSize
        );
        setTitle("Snake");
        setIconImage(null);
        setLayout(null);
        addComponentListener(this);

        createComponents();

        setVisible(true);

        addKeyListener(inputHandler);
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    private void createComponents() {

        // Create menu panel
        menu = new SnakeMenu(dataHandler);
        menu.setBackground(new Color(33,33,33,33));
        menu.setDialogBackground(new Color(33,33,33));
        menu.setVisible(inMenu);
        add(menu);

        // Create game panel
        game = new SnakeViewer(dataHandler);
        add(game);

        resizeComponents();
    }

    public void setInMenu(boolean inMenu) {
        this.inMenu = inMenu;
        menu.setVisible(this.inMenu);
    }

    public UIDataHandler getDataHandler() {
        return dataHandler;
    }

    private void resizeComponents() {
        Dimension frameSize = getSize();
        if(menu != null) menu.setSize(frameSize);
        if(game != null) game.setSize(frameSize);
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
