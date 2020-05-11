package no.hiof.larsmra.GameEngine;

import java.util.*;
import java.util.List;

/**
 * A class for creating a game scene.
 */
final public class Scene {

    private int width;
    private int height;

    private Gravity gravity;
    private List<Layer> layers;

    public Scene(int width, int height) {
        this.width = width;
        this.height = height;

        layers = new ArrayList<>();
        layers.add(0, new Layer());
    }

    /**
     * Updates the scene.
     * @param game the game object that the scene is used in.
     */
    public void update(Game game) {
        for (Layer l : layers) {
            List<String> tags = l.getTags();

            // Moves the entities
            for (String tag : tags) {
                l.getEntity(tag).move(game);
            }

            // Checks for collisions
            for (String tag : tags) {
                collision(l, l.getEntity(tag));
            }
        }
    }

    /**
     * Checks for collision between entities.
     * @param layer the layer that the entities are in.
     * @param entity the entity that is checked for collision.
     */
    private void collision(Layer layer, Entity entity) {
        for (String tag : layer.getTags()) {
            Entity entity2 = layer.getEntity(tag);
            if (entity.collisionWith(entity2) && entity != entity2) {
                for (CollisionListener c : entity.getCollisions()) {
                    c.onCollision();
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Layer getLayer(int index) {
        return layers.get(index);
    }

    public Gravity getGravity() {
        return gravity;
    }

    public List<Layer> getLayers() {
        return layers;
    }

    /**
     * A builder class for building a Scene object.
     */
    public static class SceneBuilder {

        private int width;
        private int height;

        private Gravity gravity;
        private List<Layer> layers = new ArrayList<>();

        public SceneBuilder(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public SceneBuilder setGravity(Gravity gravity) {
            this.gravity = gravity;
            return this;
        }

        public SceneBuilder addLayers(int numLayers) {
            for (int i = 0; i < numLayers; i++) {
                layers.add(new Layer());
            }
            return this;
        }

        public Scene build() {
            Scene scene = new Scene(width, height);
            scene.gravity = gravity;
            scene.layers.addAll(layers);
            return scene;
        }
    }
}