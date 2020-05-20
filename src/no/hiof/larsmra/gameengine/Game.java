package no.hiof.larsmra.gameengine;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

/**
 * A class for creating a game.
 *
 * @author Lars Martin Randem
 */
final public class Game {

    private JFrame frame;
    private DrawPanel drawPanel;
    private Renderer renderer;
    private Input input;

    private Controls controls;
    private Camera camera;

    private int width = 500;
    private int height = 500;

    private Scene activeScene;
    private List<Scene> scenes = new ArrayList<>();

    private Menu activeMenu;
    private List<Menu> menus = new ArrayList<>();

    private boolean showMenu = false;

    public Game() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        renderer = new Renderer(this);
        input = new Input();
        controls = new Controls();
        camera = new Camera();
        drawPanel = new DrawPanel();
        frame.add(drawPanel);
    }

    /**
     * Adds a menu to the game.
     *
     * @param menu the menu that is added.
     */
    public void addMenu(Menu menu) {
        menu.setGame(this);
        menus.add(menu);
        drawPanel.add(menu);
    }

    /**
     * Opens the chosen menu.
     *
     * @param index the menu's index in the menu list.
     */
    public void openMenu(int index) {
        for (int i = 0; i < menus.size(); i++) {
            if (i == index) {
                activeMenu = menus.get(index);
                activeMenu.showMenu();
                showMenu = true;
            }
            else {
                menus.get(i).hideMenu();
            }
        }
    }

    /**
     * Opens the chosen menu.
     *
     * @param menu the chosen menu.
     */
    public void openMenu(Menu menu) {
        if (!menus.contains(menu)) {
            menus.add(menu);
        }
        for (Menu m : menus) {
            m.hideMenu();
        }
        activeMenu = menu;
        activeMenu.showMenu();
        showMenu = true;
        System.out.println(activeMenu);
    }

    /**
     * Closes the menu.
     */
    public void closeMenu() {
        //activeMenu.hideMenu();
        drawPanel.remove(activeMenu);
        showMenu = false;
    }

    /**
     * Adds a scene to the game's list of scenes.
     *
     * @param scene the scene that are added to the list.
     */
    public void addScene(Scene scene) {
        scenes.add(scene);
    }

    /**
     * Sets the scene that is currently being shown in the game.
     *
     * @param index the scene's index in the scene array.
     */
    public void setActiveScene(int index) {
        this.activeScene = scenes.get(index);
    }

    /**
     * Sets the scene that is currently being shown in the game.
     *
     * @param activeScene the scene that is being shown.
     */
    public void setActiveScene(Scene activeScene) {
        if (!scenes.contains(activeScene)) {
            scenes.add(activeScene);
        }
        this.activeScene = activeScene;
    }

    /**
     * Runs the game.
     */
    public void start() {
        if (activeScene != null) {
            // Sets the size of the game window.
            drawPanel.setPreferredSize(new Dimension(width, height));
            frame.pack();
            // Make the game window visible.
            frame.setVisible(true);

            try {
                // Game loop that updates and redraws the game.
                while (true) {
                    if (!showMenu) {

                        controls.update(this);
                        activeScene.update(this);
                        camera.update(this);
                        drawPanel.repaint();

                    }
                    input.update();

                    Thread.sleep(1000 / 60);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            throw new NullPointerException("Missing scene. The game requires an active scene.");
        }
    }

    /**
     * Stops the game.
     */
    public void stop() {
        System.exit(0);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Input getInput() {
        return input;
    }

    public Scene getActiveScene() {
        return activeScene;
    }

    public Camera getCamera() {
        return camera;
    }

    public Controls getControls() {
        return controls;
    }

    /**
     * A builder class for creating games.
     */
    public static class GameBuilder {

        private Game game;

        public GameBuilder() {
            game = new Game();
        }

        public GameBuilder addScene(Scene scene) {
            game.scenes.add(scene);
            return this;
        }

        public GameBuilder addMenu(Menu menu) {
            game.menus.add(menu);
            return this;
        }

        /**
         * Sets the dimensions of the game window.
         *
         * @param width the width of the window.
         * @param height the height of the window.
         * @return this object.
         */
        public GameBuilder setDimensions(int width, int height) {
            game.width = width;
            game.height = height;
            return this;
        }

        /**
         * Sets the controls for the game.
         *
         * @param controls the controls.
         * @return this object.
         */
        public GameBuilder setControls(Controls controls) {
            game.controls = controls;
            return this;
        }

        /**
         * Sets the camera for the game.
         *
         * @param camera the camera.
         * @return this object.
         */
        public GameBuilder setCamera(Camera camera) {
            game.camera = camera;
            return this;
        }

        /**
         * Builds a game with the specifications that are set.
         *
         * @return the game.
         */
        public Game build() {
            Game game = new Game();
            game.width = this.game.width;
            game.height = this.game.height;
            game.scenes.addAll(this.game.scenes);
            game.menus.addAll(this.game.menus);
            game.controls = this.game.controls;
            game.camera = this.game.camera;

            this.game = null;

            return game;
        }

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

            renderer.render(g2d);
        }
    }
}
