package no.hiof.larsmra.examples.pong;

import no.hiof.larsmra.gameengine.*;

public class Player extends PlayableCharacter implements Collidable {

    public Player(String tag, Position position, MovementControls mc) {
        super(tag, position);
        this.position = position;
        width = 20;
        height = 100;
        movementSpeed = 9;
        movementControls = mc;
        sprite = new Sprite("resources/rect1.png");
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
    public void onCollision() {

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
    public void onCollisionLeave() {

    }
}