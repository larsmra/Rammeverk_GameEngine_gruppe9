package no.hiof.larsmra.scenarios;

import no.hiof.larsmra.gameengine.*;

public class Scenario1 {

    public static void main(String[] args) {

        Game game = new Game();

        MyEntity entity = new MyEntity("Entity", new Position(225, 225));
        entity.setDimensions(50, 50);
        entity.setSprite(new Sprite("resources/square1.png"));

        Layer layer = new Layer.LayerBuilder()
                .addEntity(entity)
                .build();

        Scene scene = new Scene.SceneBuilder()
                .addLayer(layer)
                .build();

        game.setActiveScene(scene);

        game.start();

    }

    public static class MyEntity extends Entity {

        public MyEntity(String tag, Position position) {
            super(tag, position);
        }

    }

}
