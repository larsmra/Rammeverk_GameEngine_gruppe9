package no.hiof.larsmra.Examples.Pong;

import no.hiof.larsmra.GameEngine.*;

import java.awt.event.KeyEvent;

public class Player extends PlayableCharacter implements Collidable {

    public Player(String tag, Position position, MovementControls mc) {
        super(tag);
        this.position = position;
        width = 20;
        height = 100;
        movementSpeed = 6;
        movementControls = mc;
        sprite = new Sprite("resources/player.png");
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