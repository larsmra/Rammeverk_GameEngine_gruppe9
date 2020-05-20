package no.hiof.larsmra.GameEngine;

import java.util.*;
import java.util.List;

/**
 * A class for creating a game scene.
 */
final public class Scene {

    private List<Layer> layers;

    private CollisionHandler collisionHandler;

    public Scene() {

        layers = new ArrayList<>();

        collisionHandler = new CollisionHandler();
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
                Entity entity = l.getEntity(tag);
                if (entity instanceof MovableEntity) {
                    ((MovableEntity) entity).moveEntity(game);
                }
            }

            // Checks for collisions
            for (String tag : tags) {
                Entity entity = l.getEntity(tag);
                if (entity instanceof Collidable) {
                    checkCollision(l, entity);
                }
            }
            collisionHandler.handle();
        }
    }

    /**
     * Checks for collision between entities in a layer.
     *
     * @param layer the layer that the entities are in.
     * @param entity the entity that is checked for collision.
     */
    private void checkCollision(Layer layer, Entity entity) {
        if (entity instanceof Collidable) {
            Collidable c1 = (Collidable) entity;
            for (String tag : layer.getTags()) {
                Entity entity2 = layer.getEntity(tag);
                if (entity2 instanceof Collidable) {
                    Collidable c2 = (Collidable) entity2;
                    if (entity.intersects(entity2)) {
                        collisionHandler.addCollision(c1, c2);
                    }
                }
            }
        }
    }

    public Entity getEntity(String tag) {
        for (Layer layer : layers) {
            Entity entity = layer.getEntity(tag);
            if (entity != null) {
                return entity;
            }
        }
        return null;
    }

    public Layer getLayer(int index) {
        return layers.get(index);
    }

    public List<Layer> getLayers() {
        return layers;
    }

    /**
     * A builder class for building a Scene object.
     */
    public static class SceneBuilder {

        private List<Layer> layers = new ArrayList<>();

        public SceneBuilder() {
        }

        public SceneBuilder addLayer(Layer layer) {
            layers.add(layer);
            return this;
        }

        public Scene build() {
            Scene scene = new Scene();
            scene.layers = layers;
            return scene;
        }
    }
}