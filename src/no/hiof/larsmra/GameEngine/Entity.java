package no.hiof.larsmra.GameEngine;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * An abstract class for entities in a game that are supposed to be shown on screen.
 * Used to create custom entities in a game.
 */
public abstract class Entity {

    private String tag;
    private Position position;
    private int width;
    private int height;

    private List<CollisionListener> listeners = new ArrayList<>();
    private HashMap<String, Entity> overlappingEntities = new HashMap<>();

    public Entity(String tag, Position position, int width, int height) {
        this.tag = tag;
        this.position = position;
        this.width = width;
        this.height = height;
    }

    /**
     * A method for checking if an entity just collided with another entity. If the entity, exists in the
     * overlappingEntities hash map, it means that the entities have already collided, and the method returns false.
     * @param entity the entity that is checked for overlap.
     * @return true if the entities just collided with each other, false if they did not.
     */
    public boolean collisionWith(Entity entity) {
        if (entity.position.getX() <= (position.getX() + width) &&
                (entity.position.getX() + entity.width) >= position.getX() &&
                entity.position.getY() <= (position.getY() + height) &&
                (entity.position.getY() + entity.height) >= position.getY()) {

            if (overlappingEntities.containsValue(entity)) {
                return false;
            }

            overlappingEntities.put(entity.getTag(), entity);
            return true;
        }
        else if (overlappingEntities.containsValue(entity)) {
            overlappingEntities.remove(entity.getTag());
        }
        return false;
    }

    /**
     * A method for setting the movement of the entity.
     * @param game the game object, which is useful to get information such as input,
     *             and the placement of other entities in the game.
     */
    public abstract void move(Game game);

    /**
     * A method for adding a CollisionListener to the entity.
     * @param listener the CollisionListener that is added.
     */
    public void addCollision(CollisionListener listener) {
        listeners.add(listener);
    }

    public List<CollisionListener> getCollisions() {
        return listeners;
    }

    /**
     * A method for rendering the entity.
     * @param g2d a Graphics2D object used to render the entity.
     */
    public void render(Graphics2D g2d) {
        g2d.fillRect(position.getX(), position.getY(), width, height);
    }

    public String getTag() {
        return tag;
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
}
