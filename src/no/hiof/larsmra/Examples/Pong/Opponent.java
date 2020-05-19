package no.hiof.larsmra.Examples.Pong;

import no.hiof.larsmra.GameEngine.*;

public class Opponent extends PlayableCharacter implements Collidable {

    private static final int SPEED = 9;

    public Opponent(String tag, Position position) {
        super(tag, position, 20, 100, 10, new MovementControls(), new Sprite("C:\\Users\\LarsM\\Documents\\Skole\\hiof\\rammeverk\\testSprites\\opponent1.png"));
    }

    // Sets the movement of the opponent.

    public void movement(Game game) {
        Layer layer = game.getActiveScene().getLayer(0);
        for (String tag : layer.getTags()) {
            Entity e = layer.getEntity(tag);
            if (e.getPosition().getX() > 450) {
                if (e.getPosition().getY() < getPosition().getY() && getPosition().getY() > 0) {
                    getPosition().setY(getPosition().getY() - SPEED);
                }
                if ((e.getPosition().getY() + e.getHeight()) > (getPosition().getY() + getHeight()) &&
                        (getPosition().getY() + getHeight()) < 500) {
                    getPosition().setY(getPosition().getY() + SPEED);
                }
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
