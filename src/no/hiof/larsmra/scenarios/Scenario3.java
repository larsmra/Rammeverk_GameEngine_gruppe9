package no.hiof.larsmra.scenarios;

import no.hiof.larsmra.gameengine.*;

import java.awt.event.KeyEvent;

/**
 * Scenario 3:
 *
 * In this scenario, a player entity, and a non-playable character entity is created.
 * Movement controls are set for the player. The movement of the non-playable character
 * is set to follow the player. Both the player and the non-playable character are then
 * added to a layer, which is added to a scene, which is set for the game. Then the game
 * starts.
 */
public class Scenario3 {

    public static void main(String[] args) {

        // Creates movement controls for a player.
        MovementControls mc = new MovementControls.MovementControlsBuilder()
                .bindKeyUp(KeyEvent.VK_W)
                .bindKeyDown(KeyEvent.VK_S)
                .bindKeyLeft(KeyEvent.VK_A)
                .bindKeyRight(KeyEvent.VK_D)
                .build();

        // Creates a player character.
        Player player = new Player("player", new Position(100, 100));
        player.setDimensions(50, 50);
        player.setMovementSpeed(10);
        player.setSprite(new Sprite("resources/ball.png"));

        // Adds the controls to the player.
        player.setMovementControls(mc);

        // Creates an opponent.
        Opponent opponent = new Opponent("opponent", new Position(40, 40));
        opponent.setDimensions(50, 50);
        opponent.setMovementSpeed(5);
        opponent.setDetectionRadius(200);
        opponent.setSprite(new Sprite("resources/square1.png"));

        // Creates a layer and adds the player and the opponent to that layer.
        Layer layer = new Layer.LayerBuilder()
                .addEntity(player)
                .addEntity(opponent)
                .build();

        // Creates a scene and adds the layer to that scene.
        Scene scene = new Scene.SceneBuilder()
                .addLayer(layer)
                .build();

        Game game = new Game();

        // Sets the scene as the active scene in the game.
        game.setActiveScene(scene);

        game.start();

    }

    static class Player extends PlayableCharacter {

        public Player(String tag, Position position) {
            super(tag, position);
        }

    }

    static class Opponent extends NonPlayableCharacter {

        public Opponent(String tag, Position position) {
            super(tag, position);
        }

        @Override
        public void movement(Game game) {
            // Sets the opponent to track the player.
            trackEntity("player");
        }
    }

}
