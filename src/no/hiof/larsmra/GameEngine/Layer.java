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

    public void addEntity(Entity entity) {
        entities.put(entity.getTag(), entity);
        tags.add(entity.getTag());
    }

    public Entity getEntity(String tag) {
        return entities.get(tag);
    }

    public List<String> getTags() {
        return tags;
    }
}
