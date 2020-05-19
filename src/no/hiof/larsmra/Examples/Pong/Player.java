package no.hiof.larsmra.Examples.Pong;

import no.hiof.larsmra.GameEngine.*;

import java.awt.event.KeyEvent;

public class Player extends PlayableCharacter implements Collidable {

    private static final int SPEED = 9;

    public Player(String tag, Position position) {
        super(tag, position, 20, 100, 10, new MovementControls(), new Sprite("C:\\Users\\LarsM\\Documents\\Skole\\hiof\\rammeverk\\testSprites\\player1.png"));
    }

    // Decides how the player moves in the game.

    public void movement(Game game) {
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

    @Override
    public void onLeftCollision() {

    }

    @Override
    public void onRightCollision() {

    }

    @Override
    public void onTopCollision() {

    }

    @Override
    public void onBottomCollision() {

    }

    @Override
    public void onStaticCollision() {

    }

    @Override
    public void onLeftCollisionLeave() {

    }

    @Override
    public void onRightCollisionLeave() {

    }

    @Override
    public void onTopCollisionLeave() {

    }

    @Override
    public void onBottomCollisionLeave() {

    }

    @Override
    public void onStaticCollisionLeave() {

    }
}