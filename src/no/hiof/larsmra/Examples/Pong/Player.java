package no.hiof.larsmra.Examples.Pong;

import no.hiof.larsmra.GameEngine.*;

import java.awt.event.KeyEvent;

public class Player extends Entity {

    private static final int SPEED = 9;

    public Player(String tag, Position position) {
        super(tag, position, 20, 100);
    }

    // Decides how the player moves in the game.
    @Override
    public void move(Game game) {
        if (getPosition().getY() > 0) {
            // If the W key or the UP key is pressed, the player moves up.
            if (game.getInput().isPressed(KeyEvent.VK_W) || game.getInput().isPressed(KeyEvent.VK_UP)) {
                getPosition().setY(getPosition().getY() - SPEED);
            }
        }
        if (getPosition().getY() < (500 - getHeight())) {
            // If the S key or the DOWN key is pressed, the player moves down.
            if (game.getInput().isPressed(KeyEvent.VK_S) || game.getInput().isPressed(KeyEvent.VK_DOWN)) {
                getPosition().setY(getPosition().getY() + SPEED);
            }
        }
    }
}