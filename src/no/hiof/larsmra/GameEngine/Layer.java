package no.hiof.larsmra.GameEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A class for creating a layer in a game.
 */
final public class Layer {

    /**
     * A hash map of the entities in the layer.
     */
    private HashMap<String, Entity> entities = new HashMap<>();
    private List<String> tags = new ArrayList<>();

    private double speed;

    public Layer() {
        speed = 1;
    }

    public Layer(double speed) {
        if (speed >= 0) {
            this.speed = speed;
        }
        else {
            throw new IllegalArgumentException("speed cannot be a negative number.");
        }
    }

    public void addEntity(Entity entity) {
        entities.put(entity.getTag(), entity);
        tags.add(entity.getTag());
    }

    public Entity getEntity(String tag) {
        return entities.get(tag);
    }

    /*
    public HashMap<String, Entity> getEntities() {
        return entities;
    }
     */

    public List<String> getTags() {
        return tags;
    }

    public double getSpeed() {
        return speed;
    }
}
