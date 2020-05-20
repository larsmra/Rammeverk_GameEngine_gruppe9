package no.hiof.larsmra.scenarios;

import no.hiof.larsmra.gameengine.*;

/**
 * Scenario 1:
 *
 * In this scenario, a game is created. An entity is created, which is added
 * to a layer. This layer is added to a scene. And the scene is added to the
 * game. Then, the game is started.
 */
public class Scenario1 {

    public static void main(String[] args) {

        // Creates a game.
        Game game = new Game();

        // Creates an entity.
        MyEntity entity = new MyEntity("Entity", new Position(225, 225));
        entity.setDimensions(50, 50);
        entity.setSprite(new Sprite("resources/square1.png"));

        // Creates a layer and adds the entity to that layer.
        Layer layer = new Layer.LayerBuilder()
                .addEntity(entity)
                .build();

        // Creates a scene and adds the layer to that scene.
        Scene scene = new Scene.SceneBuilder()
                .addLayer(layer)
                .build();

        // Sets the active scene in the game.
        game.setActiveScene(scene);

        // Starts the game.
        game.start();

    }

    public static class MyEntity extends Entity {

        public MyEntity(String tag, Position position) {
            super(tag, position);
        }

    }

}
