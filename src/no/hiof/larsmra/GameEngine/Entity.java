package no.hiof.larsmra.GameEngine;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * An abstract class for entities in a game that are supposed to be shown on screen.
 * Used to create custom entities in a game.
 */
public abstract class Entity {

    protected static HashMap<String, Entity> entities = new HashMap<>();

    protected String tag;
    protected Position position;
    protected int width;
    protected int height;
    protected Sprite sprite;

    private Position prevPosition;

    /*
    public Entity(String tag, Position position, int width, int height, Sprite sprite) {
        this.tag = tag;
        this.position = position;
        this.width = width;
        this.height = height;
        this.sprite = sprite;
    }
     */

    public Entity(String tag, Position position) {
        this.tag = tag;
        this.position = position;
        width = 0;
        height = 0;
        sprite = null;

        prevPosition = position;

        entities.put(this.tag, this);
    }

    public boolean intersects(Entity entity) {
        if (this == entity) {
            return false;
        }
        return intersectsVertically(entity) && intersectsHorizontally(entity);
    }

    private boolean intersectsHorizontally(Entity entity) {
        return intersectsHorizontalLeft(entity) && intersectsHorizontalRight(entity);
    }

    private boolean intersectsVertically(Entity entity) {
        return intersectsVerticalTop(entity) && intersectsVerticalBottom(entity);
    }

    private boolean intersectsHorizontalLeft(Entity entity) {
        return (entity.position.getX() + entity.width) >= position.getX();
    }

    private boolean intersectsHorizontalRight(Entity entity) {
        return entity.position.getX() <= (position.getX() + width);
    }

    private boolean intersectsVerticalTop(Entity entity) {
        return (entity.position.getY() + entity.height) >= position.getY();
    }

    private boolean intersectsVerticalBottom(Entity entity) {
        return entity.position.getY() <= (position.getY() + height);
    }

    public String getTag() {
        return tag;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Position getPosition() {
        return position;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Position getPrevPosition() {
        return prevPosition;
    }

    public void setPrevPosition(Position prevPosition) {
        this.prevPosition = prevPosition;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    protected static Entity getEntity(String tag) {
        Entity entity = entities.get(tag);
        if (entity != null) {
            return entity;
        }
        else {
            throw new IllegalArgumentException("Invalid entity tag.");
        }
    }
}
