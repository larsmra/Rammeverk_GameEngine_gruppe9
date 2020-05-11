package no.hiof.larsmra.Examples.Pong;

import no.hiof.larsmra.GameEngine.*;

public class Opponent extends Entity {

    private static final int SPEED = 9;

    public Opponent(String tag, Position position) {
        super(tag, position, 20, 100);
    }

    // Sets the movement of the opponent.
    @Override
    public void move(Game game) {
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
}
