package no.hiof.larsmra.Examples.Pong;

import no.hiof.larsmra.GameEngine.*;

public class Opponent extends NonPlayableCharacter implements Collidable {

    public Opponent(String tag, Position position) {
        super(tag);
        this.position = position;
        width = 20;
        height = 100;
        movementSpeed = 6;
        detectionRadius = 450;
        sprite = new Sprite("resources/opponent.png");
    }

    // Sets the movement of the opponent.
    @Override
    public void movement(Game game) {
        Entity entity = game.getActiveScene().getEntity("ball");
        trackEntityVertically(entity);
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
