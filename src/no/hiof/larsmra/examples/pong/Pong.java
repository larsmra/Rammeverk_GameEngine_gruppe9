package no.hiof.larsmra.examples.pong;

import no.hiof.larsmra.gameengine.*;
import no.hiof.larsmra.gameengine.ScoreBoard;

import java.awt.event.KeyEvent;

public class Pong {

    public static void main(String[] args) {

        // Initiates a game.
        Game game = new Game.GameBuilder().setDimensions(900, 500).build();

        Controls controls = game.getControls();

        controls.bindTypedKeyCommand(KeyEvent.VK_E, () -> System.out.println("E"));

        MovementControls mc = new MovementControls();
        mc.bindKeyUp(KeyEvent.VK_W);
        mc.bindKeyDown(KeyEvent.VK_S);

        // Creates entities to put in the game.
        Player player = new Player("player", new Position(50, 200), mc);
        Opponent opponent = new Opponent("opponent", new Position(830, 200));
        Ball ball = new Ball("ball", new Position(440, 240));

        // Gets the default layer that is created when the scene was instantiated.
        Layer layer1 = new Layer();

        // Adds the entities to the layer.
        layer1.addEntity(player);
        layer1.addEntity(opponent);
        layer1.addEntity(ball);

        // Creates scoreboards
        ScoreBoard scoreBoardPlayer = new ScoreBoard("scoreboard player", new Position(90, 20));
        ScoreBoard scoreBoardOpponent = new ScoreBoard("scoreboard opponent", new Position(800, 20));

        // Gets the added layer
        Layer layer2 = new Layer();

        layer2.addEntity(scoreBoardPlayer);
        layer2.addEntity(scoreBoardOpponent);

        // Creates a scene.
        Scene scene = new Scene.SceneBuilder()
                .addLayer(layer1)
                .addLayer(layer2)
                .build();

        // Adds the scene to the game.
        game.addScene(scene);
        game.setActiveScene(0);

        // Start the game.
        game.start();
    }

}