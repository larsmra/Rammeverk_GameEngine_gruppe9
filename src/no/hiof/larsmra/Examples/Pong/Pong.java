package no.hiof.larsmra.Examples.Pong;

import no.hiof.larsmra.GameEngine.*;
import no.hiof.larsmra.GameEngine.GUI.ScoreBoard;

public class Pong {

    public static void main(String[] args) {

        // Initiates a game.
        Game game = new Game();

        // Creates entities to put in the game.
        Player player = new Player("player", new Position(50, 200));
        Opponent opponent = new Opponent("opponent", new Position(830, 200));
        Ball ball = new Ball("ball", new Position(440, 240));

        // Creates a scene.
        Scene scene = new Scene.SceneBuilder(900, 500).addLayers(1).build();

        // Gets the default layer that is created when the scene was instantiated.
        Layer layer1 = scene.getLayer(0);

        // Adds the entities to the layer.
        layer1.addEntity(player);
        layer1.addEntity(opponent);
        layer1.addEntity(ball);

        // Creates scoreboards
        ScoreBoard scoreBoardPlayer = new ScoreBoard("scoreboard player", new Position(90, 20));
        ScoreBoard scoreBoardOpponent = new ScoreBoard("scoreboard opponent", new Position(800, 20));

        // Gets the added layer
        Layer layer2 = scene.getLayer(1);

        layer2.addEntity(scoreBoardPlayer);
        layer2.addEntity(scoreBoardOpponent);

        // Adds the scene to the game.
        game.addScene(scene);
        game.setActiveScene(0);

        // Start the game.
        game.start();
    }

}