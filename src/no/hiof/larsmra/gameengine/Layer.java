package no.hiof.larsmra.gameengine;

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
            throw new IllegalArgumentException("Speed cannot be less than 0.");
        }
    }

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

    public double getSpeed() {
        return speed;
    }

    public static class LayerBuilder {

        private Layer layer;

        public LayerBuilder() {
            layer = new Layer();
        }

        public LayerBuilder setSpeed(double speed) {
            if (speed >= 0) {
                layer.speed = speed;
            }
            else {
                throw new IllegalArgumentException("Speed cannot be less than 0.");
            }
            return this;
        }

        public LayerBuilder addEntity(Entity entity) {
            layer.entities.put(entity.tag, entity);
            layer.tags.add(entity.tag);
            return this;
        }

        public Layer build() {
            Layer layer = new Layer();
            layer.speed = this.layer.speed;
            layer.entities.putAll(this.layer.entities);
            layer.tags.addAll(this.layer.tags);

            this.layer = null;

            return layer;
        }
    }
}
