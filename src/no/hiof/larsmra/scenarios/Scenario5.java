package no.hiof.larsmra.scenarios;

import no.hiof.larsmra.gameengine.*;

import java.awt.event.KeyEvent;

public class Scenario5 {

    public static void main(String[] args) {

        Player player = new Player("player");

        Wall wall = new Wall("wall");

        Square square = new Square("Square");

        Layer layerFront = new Layer.LayerBuilder()
                .addEntity(player)
                .addEntity(square)
                .build();

        Layer layerBackground = new Layer.LayerBuilder()
                .setSpeed(0.5)
                .addEntity(wall)
                .build();

        Scene scene = new Scene.SceneBuilder()
                .addLayer(layerBackground)
                .addLayer(layerFront)
                .build();

        Camera camera = new Camera();
        camera.setTarget("player");

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
