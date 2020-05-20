package no.hiof.larsmra.scenarios;

import no.hiof.larsmra.gameengine.*;

import java.awt.event.KeyEvent;

/**
 * Scenario 2:
 *
 * In this scenario, a Controls object is created. A key command is bound to the "E"-key
 * and the "A"-key. Then the controls are added to a game, and the game is started.
 */
public class Scenario2 {

    public static void main(String[] args) {

        // Creates controls for the game.
        Controls controls = new Controls();

        // Adds a command for when the "E" key is typed.
        controls.bindTypedKeyCommand(KeyEvent.VK_E, new Command() {
            @Override
            public void doCommand() {
                System.out.println("E typed.");
            }
        });

        // Adds a command for when the "A" key is pressed.
        controls.bindPressedKeyCommand(KeyEvent.VK_A, new Command() {
            @Override
            public void doCommand() {
                System.out.println("A pressed.");
            }
        });

        // Creates a game and adds the controls to that game.
        Game game = new Game.GameBuilder()
                .setControls(controls)
                .addScene(new Scene())
                .build();

        game.setActiveScene(0);

        game.start();

    }

}
