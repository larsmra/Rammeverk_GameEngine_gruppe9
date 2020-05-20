package no.hiof.larsmra.Examples.Pong;

import no.hiof.larsmra.GameEngine.*;
import no.hiof.larsmra.GameEngine.GUI.ScoreBoard;

public class Ball extends MovableEntity implements Collidable {

    public Ball(String tag, Position position) {
        super(tag);
        this.position = position;
        width = 20;
        height = 20;
        movementSpeed = 7;
        sprite = new Sprite("resources/ball.png");
    }

    @Override
    public void movement(Game game) {
        if (!isMoving()) {
            moveLeft();
            moveDown();
        }

        if (position.getX() <= 0) {
            position = new Position(450, 250);
            ScoreBoard sb = (ScoreBoard) game.getActiveScene().getEntity("scoreboard opponent");
            if (sb != null) {
                sb.incrementScore();
            }
        }
        else if (position.getX() >= game.getWidth()) {
            position = new Position(450, 250);
            ScoreBoard sb = (ScoreBoard) game.getActiveScene().getEntity("scoreboard player");
            if (sb != null) {
                sb.incrementScore();
            }
        }
        if (position.getY() <= 0) {
            moveDown();
        }
        else if (position.getY() >= game.getHeight()) {
            moveUp();
        }
    }

    @Override
    public void onLeftCollision() {
        moveRight();
        System.out.println("left");
    }

    @Override
    public void onRightCollision() {
        moveLeft();
        System.out.println("right");
    }

    @Override
    public void onTopCollision() {
        moveDown();
        System.out.println("top");
    }

    @Override
    public void onBottomCollision() {
        moveUp();
        System.out.println("bottom");
    }

    @Override
    public void onStaticCollision() {

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
    public void onStaticCollisionLeave() {

    }
}
