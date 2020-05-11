package no.hiof.larsmra.GameEngine;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * A class for creating a game.
 */
final public class Game {

    private JFrame frame;
    private DrawPanel drawPanel;
    private Input input;

    private Scene activeScene;
    private List<Scene> scenes = new ArrayList<>();


    public Game() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input = new Input();
        drawPanel = new DrawPanel();
        frame.add(drawPanel);
        frame.pack();
    }

    public void addScene(Scene scene) {
        scenes.add(scene);
    }

    public void setActiveScene(int index) {
        this.activeScene = scenes.get(index);
        drawPanel.setPreferredSize(new Dimension(activeScene.getWidth(), activeScene.getHeight()));

        frame.pack();
    }

    /**
     * Runs the game.
     */
    public void start() {
        // Make the game window visible.
        frame.setVisible(true);

        try {
            // Game loop that update and redraw the game.
            while (true) {
                activeScene.update(this);

                drawPanel.repaint();
                Thread.sleep(1000 / 60);

            }
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Stops the game.
     */
    public void stop() {
        System.exit(0);
    }

    public Input getInput() {
        return input;
    }

    public Scene getActiveScene() {
        return activeScene;
    }

    /**
     * A panel used to draw the game on.
     */
    private class DrawPanel extends JPanel {

        public DrawPanel() {
            setFocusable(true);
            addKeyListener(input);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Goes through all of the layers and draws the entities in each layer.
            for (Layer l : activeScene.getLayers()) {
                for (String tag : l.getTags()) {
                    l.getEntity(tag).render(g2d);
                }
            }
        }
    }
}
