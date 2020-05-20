package no.hiof.larsmra.examples.pong;

import no.hiof.larsmra.gameengine.*;

public class Opponent extends NonPlayableCharacter implements Collidable {

    public Opponent(String tag, Position position) {
        super(tag, position);
        this.position = position;
        width = 20;
        height = 100;
        movementSpeed = 9;
        detectionRadius = 450;
        sprite = new Sprite("resources/rect2.png");
    }

    // Sets the movement of the opponent.
    @Override
    public void movement(Game game) {
        trackEntityVertically("ball");
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
