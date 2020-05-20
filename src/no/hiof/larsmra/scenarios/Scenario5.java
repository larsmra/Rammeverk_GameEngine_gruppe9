package no.hiof.larsmra.scenarios;

import no.hiof.larsmra.gameengine.*;

import java.awt.event.KeyEvent;

/**
 * Scenario 5:
 *
 * In this scenario, a player is created, and movement controls are set for the player. The player
 * together with another entity, are placed in a layer, while a Wall entity is placed in a background
 * layer. A camera object is added to the game, and the camera is set to focus on the player. This focuses
 * the view on the player, which means that the player is always centered in the middle of the window.
 * When the player moves, the other entities in the game will move relative to player. The background layer
 * is set to move at half the speed of the player.
 */
public class Scenario5 {

    public static void main(String[] args) {

        // Creates a player.
        Player player = new Player("player");

        // Creates a Wall entity.
        Wall wall = new Wall("wall");

        // Creates a Square entity.
        Square square = new Square("Square");

        // Adds the player and the square to the front layer.
        Layer layerFront = new Layer.LayerBuilder()
                .addEntity(player)
                .addEntity(square)
                .build();

        // Adds the wall to the background layer.
        // Slowed the speed of the layer to half of the player speed.
        Layer layerBackground = new Layer.LayerBuilder()
                .setSpeed(0.5)
                .addEntity(wall)
                .build();

        // Creates a scene and adds the layers to the scene.
        Scene scene = new Scene.SceneBuilder()
                .addLayer(layerBackground)
                .addLayer(layerFront)
                .build();

        // Creates a camera.
        Camera camera = new Camera();

        // Sets the camera to track the player.
        camera.setTarget("player");

        // Creates a game and adds the camera and the scene to that game.
        Game game = new Game.GameBuilder()
                .setCamera(camera)
                .addScene(scene)
                .build();

        game.setActiveScene(scene);

        game.start();

    }

    static class Player extends PlayableCharacter {

        public Player(String tag) {
            super(tag, new Position(900, 550));
            width = 50;
            height = 50;
            sprite = new Sprite("resources/ball.png");
            movementSpeed = 10;

            // Sets movement controls of the player.
            movementControls = new MovementControls.MovementControlsBuilder()
                    .bindKeyUp(KeyEvent.VK_W)
                    .bindKeyDown(KeyEvent.VK_S)
                    .bindKeyLeft(KeyEvent.VK_A)
                    .bindKeyRight(KeyEvent.VK_D)
                    .build();
        }

    }

    static class Square extends Entity {

        public Square(String tag) {
            super(tag, new Position(750, 500));
            width = 50;
            height = 50;
            sprite = new Sprite("resources/square1.png");
        }
    }

    static class Wall extends Entity {

        public Wall(String tag) {
            super(tag, new Position(0, 0));
            width = 1920;
            height = 1080;
            sprite = new Sprite("resources/wall.png");
        }
    }

}
