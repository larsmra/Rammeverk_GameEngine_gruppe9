package no.hiof.larsmra.scenarios;

import no.hiof.larsmra.gameengine.*;

import java.awt.event.KeyEvent;

public class Scenario2 {

    public static void main(String[] args) {

        Controls controls = new Controls();
        controls.bindTypedKeyCommand(KeyEvent.VK_E, new Command() {
            @Override
            public void doCommand() {
                System.out.println("E typed.");
            }
        });
        controls.bindPressedKeyCommand(KeyEvent.VK_A, new Command() {
            @Override
            public void doCommand() {
                System.out.println("A pressed.");
            }
        });

        Game game = new Game.GameBuilder()
                .setControls(controls)
                .addScene(new Scene())
                .build();

        game.setActiveScene(0);

        game.start();

    }

}
