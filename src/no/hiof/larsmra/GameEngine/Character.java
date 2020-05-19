package no.hiof.larsmra.GameEngine;

public abstract class Character extends Entity implements Collidable, Moveable {

    public Character(String tag, Position position, int width, int height, Sprite sprite) {
        super(tag, position, width, height, sprite);
    }

}
