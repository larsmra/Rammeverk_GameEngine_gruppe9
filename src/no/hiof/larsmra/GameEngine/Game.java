package no.hiof.larsmra.GameEngine;

import no.hiof.larsmra.GameEngine.GUI.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * A class for creating a game.
 */
final public class Game {

    private JFrame frame;
    private DrawPanel drawPanel;
    private Renderer renderer;
    private Input input;
    private Camera camera;

    private Scene activeScene;
    private List<Scene> scenes = new ArrayList<>();

    private Menu activeMenu;
    private List<Menu> menus = new ArrayList<>();

    private boolean running = true;
    private boolean showMenu = true;

    public Game() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        renderer = new Renderer(this);
        input = new Input();
        drawPanel = new DrawPanel();
        camera = new Camera(this);
        frame.add(drawPanel);
        frame.pack();
    }

    public void addMenu(Menu menu) {
        menu.setGame(this);
        menus.add(menu);
        drawPanel.add(menu);
    }

    public void openMenu(int index) {
        this.activeMenu = menus.get(index);
        for (int i = 0; i < menus.size(); i++) {
            if (i == index) {
                menus.get(i).showMenu();
                showMenu = true;
                //pause();
            }
            else {
                menus.get(i).hideMenu();
            }
        }
    }

    public void closeMenu() {
        activeMenu.hideMenu();
        showMenu = false;
    }

    public void addScene(Scene scene) {
        scenes.add(scene);
    }

    public void setActiveScene(int index) {
        this.activeScene = scenes.get(index);
        drawPanel.setPreferredSize(new Dimension(activeScene.getWidth(), activeScene.getHeight()));

        System.out.println("Tracking");
        camera.trackEntity("P2");

        frame.pack();
    }

    /*
    public Entity getEntity(String tag) {
        for (Layer layer : activeScene.getLayers()) {
            Entity entity = layer.getEntity(tag);
            if (entity != null) {
                return entity;
            }
        }
        return null;
    }
     */

    public Camera getCamera() {
        return camera;
    }

    /**
     * Runs the game.
     */
    public void start() {
        // Make the game window visible.
        frame.setVisible(true);

        try {
            while(running) {
                // Game loop that update and redraw the game.
                while (!showMenu) {
                    activeScene.update(this);

                    drawPanel.repaint();
                    Thread.sleep(1000 / 60);
                }
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
            /*
            for (Layer l : activeScene.getLayers()) {
                for (String tag : l.getTags()) {
                    l.getEntity(tag).render(g2d);
                }
            }
             */

            renderer.render(g2d, activeScene, camera);
        }
    }
}
