package no.hiof.larsmra.scenarios;

import no.hiof.larsmra.gameengine.*;

public class Scenario6 {

    public static void main(String[] args) {

        Rectangle rect1 = new Rectangle("Rectangle 1", new Position(130, 200));
        rect1.setSprite(new Sprite("resources/rect1.png"));

        Rectangle rect2 = new Rectangle("Rectangle 2", new Position(350, 200));
        rect2.setSprite(new Sprite("resources/rect2.png"));

        Ball ball = new Ball("Ball");
        ball.setMovementSpeed(5);

        Layer layer = new Layer.LayerBuilder()
                .addEntity(rect1)
                .addEntity(rect2)
                .addEntity(ball)
                .build();

        Scene scene = new Scene.SceneBuilder()
                .addLayer(layer)
                .build();

        Game game = new Game.GameBuilder()
                .addScene(scene)
                .build();

        game.setActiveScene(scene);

        game.start();

    }

    static class Rectangle extends Entity implements Collidable {

        public Rectangle(String tag, Position position) {
            super(tag, position);
            width = 20;
            height = 100;
        }

        @Override
        public void onLeftCollision() {

        }

        @Override
        public void onRightCollision() {

        }

        @Override
        public void onTopCollision() {

        }

        @Override
        public void onBottomCollision() {

        }

        @Override
        public void onCollision() {

        }

        @Override
        public void onLeftCollisionLeave() {

        }

        @Override
        public void onRightCollisionLeave() {

        }

        @Override
        public void onTopCollisionLeave() {

        }

        @Override
        public void onBottomCollisionLeave() {

        }

        @Override
        public void onCollisionLeave() {

        }
    }

    static class Ball extends MovableEntity implements Collidable {

        public Ball(String tag) {
            super(tag, new Position(240, 240));
            width = 20;
            height = 20;
            sprite = new Sprite("resources/ball.png");
        }

        @Override
        public void movement(Game game) {
            if (!isMoving()) {
                moveLeft();
            }
        }

        @Override
        public void onLeftCollision() {
            moveRight();
            System.out.println("ball left collision");
        }

        @Override
        public void onRightCollision() {
            moveLeft();
            System.out.println("ball right collision");
        }

        @Override
        public void onTopCollision() {

        }

        @Override
        public void onBottomCollision() {

        }

        @Override
        public void onCollision() {

        }

        @Override
        public void onLeftCollisionLeave() {

        }

        @Override
        public void onRightCollisionLeave() {

        }

        @Override
        public void onTopCollisionLeave() {

        }

        @Override
        public void onBottomCollisionLeave() {

        }

        @Override
        public void onCollisionLeave() {

        }
    }

}
