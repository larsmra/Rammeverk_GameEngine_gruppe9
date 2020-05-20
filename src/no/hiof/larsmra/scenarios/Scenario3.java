package no.hiof.larsmra.scenarios;

import no.hiof.larsmra.gameengine.*;

import java.awt.event.KeyEvent;

public class Scenario3 {

    public static void main(String[] args) {

        MovementControls mc = new MovementControls.MovementControlsBuilder()
                .bindKeyUp(KeyEvent.VK_W)
                .bindKeyDown(KeyEvent.VK_S)
                .bindKeyLeft(KeyEvent.VK_A)
                .bindKeyRight(KeyEvent.VK_D)
                .build();

        Player player = new Player("player", new Position(100, 100));
        player.setDimensions(50, 50);
        player.setMovementSpeed(10);
        player.setSprite(new Sprite("resources/ball.png"));
        player.setMovementControls(mc);

        Opponent opponent = new Opponent("opponent", new Position(40, 40));
        opponent.setDimensions(50, 50);
        opponent.setMovementSpeed(5);
        opponent.setDetectionRadius(200);
        opponent.setSprite(new Sprite("resources/square1.png"));

        Layer layer = new Layer.LayerBuilder()
                .addEntity(player)
                .addEntity(opponent)
                .build();

        Scene scene = new Scene.SceneBuilder()
                .addLayer(layer)
                .build();

        Game game = new Game();

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
            trackEntity("player");
        }
    }

}