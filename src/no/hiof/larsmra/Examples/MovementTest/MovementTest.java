package no.hiof.larsmra.Examples.MovementTest;

import no.hiof.larsmra.GameEngine.*;

import java.awt.event.KeyEvent;

public class MovementTest {

    public static void main(String[] args) {

        MovementControls movementControls = new MovementControls();

        movementControls.bindKeyUp(KeyEvent.VK_W);
        movementControls.bindKeyDown(KeyEvent.VK_S);
        movementControls.bindKeyLeft(KeyEvent.VK_A);
        movementControls.bindKeyRight(KeyEvent.VK_D);


        Sprite p1Sprite = new Sprite("C:\\Users\\LarsM\\Documents\\Skole\\hiof\\rammeverk\\testSprites\\person1_looking_left.png");
        Player p1 = new Player("Player", new Position(10, 10), 50, 50, 5, movementControls, p1Sprite);

        Sprite opponentSprite = new Sprite("C:\\Users\\LarsM\\Documents\\Skole\\hiof\\rammeverk\\testSprites\\bad_guy1.png");
        Opponent opponent = new Opponent("Opponent", new Position(250, 250), 50, 50, 2, 200, NonPlayableCharacter.Behaviour.INTIMIDATED, opponentSprite);

        Game game = new Game();

        Scene scene = new Scene.SceneBuilder(500, 500).build();

        Layer layer = scene.getLayer(0);
        layer.addEntity(p1);
        layer.addEntity(opponent);

        game.addScene(scene);
        game.setActiveScene(0);

        game.start();

        Input in = new Input();

    }

}
