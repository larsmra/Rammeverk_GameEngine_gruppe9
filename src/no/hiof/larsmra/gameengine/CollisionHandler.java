package no.hiof.larsmra.gameengine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class for collision handling.
 */
final public class CollisionHandler {

    private static final int TOP = 1;
    private static final int LEFT = 2;
    private static final int RIGHT = 3;
    private static final int BOTTOM = 4;
    private static final int NONE = 0;

    private List<Collision> topCollisions = new ArrayList<>();
    private List<Collision> bottomCollisions = new ArrayList<>();
    private List<Collision> leftCollisions = new ArrayList<>();
    private List<Collision> rightCollisions = new ArrayList<>();
    private List<Collision> collisions = new ArrayList<>();

    private List<Collision> prevTopCollisions = new ArrayList<>();
    private List<Collision> prevBottomCollisions = new ArrayList<>();
    private List<Collision> prevLeftCollisions = new ArrayList<>();
    private List<Collision> prevRightCollisions = new ArrayList<>();
    private List<Collision> prevCollisions = new ArrayList<>();

    public void addCollision(Collidable collider, Collidable collided) {
        int direction = checkRelativeDirection((Entity) collider, (Entity) collided);
        if (direction == LEFT) {
            leftCollisions.add(new Collision(collider, collided));
            collisions.add(new Collision(collider, collided));
        }
        if (direction == RIGHT) {
            rightCollisions.add(new Collision(collider, collided));
            collisions.add(new Collision(collider, collided));
        }
        if (direction == TOP) {
            topCollisions.add(new Collision(collider, collided));
            collisions.add(new Collision(collider, collided));
        }
        if (direction == BOTTOM) {
            bottomCollisions.add(new Collision(collider, collided));
            collisions.add(new Collision(collider, collided));
        }
        if (direction == NONE) {
            collisions.add(new Collision(collider, collided));
        }
    }

    private int checkRelativeDirection(Entity collider, Entity collided) {
        Position prevCollider = collider.getPrevPosition();
        Position currentCollided = collided.getPosition();

        if (prevCollider.getY() > (currentCollided.getY() + collided.height)) {
            return TOP;
        }
        if (prevCollider.getX() > (currentCollided.getX() + collided.width)) {
            return LEFT;
        }
        if ((prevCollider.getX() + collider.width) < currentCollided.getX()) {
            return RIGHT;
        }
        if ((prevCollider.getY() + collider.height) < currentCollided.getY()) {
            return BOTTOM;
        }

        return 0;
    }

    public void handle() {
        for (Collision collision : topCollisions) {
            collision.collider.onTopCollision();
            collision.collided.onBottomCollision();
        }
        for (Collision collision : bottomCollisions) {
            collision.collider.onBottomCollision();
            collision.collided.onTopCollision();
        }
        for (Collision collision : leftCollisions) {
            collision.collider.onLeftCollision();
            collision.collided.onRightCollision();
        }
        for (Collision collision : rightCollisions) {
            collision.collider.onRightCollision();
            collision.collided.onLeftCollision();
        }
        for (Collision collision : collisions) {
            collision.collider.onCollision();
            collision.collided.onCollision();
        }

        handleLeaveCollisions();

        refreshCollisions();
    }

    private void handleLeaveCollisions() {
        for (Collision collision : prevTopCollisions) {
            if (collisionDoesNotExists(collision.collider, collision.collided, topCollisions)) {
                collision.collider.onTopCollisionLeave();
                collision.collided.onBottomCollisionLeave();
            }
        }
        for (Collision collision : prevBottomCollisions) {
            if (collisionDoesNotExists(collision.collider, collision.collided, bottomCollisions)) {
                collision.collider.onBottomCollisionLeave();
                collision.collided.onTopCollisionLeave();
            }
        }
        for (Collision collision : prevLeftCollisions) {
            if (collisionDoesNotExists(collision.collider, collision.collided, leftCollisions)) {
                collision.collider.onLeftCollisionLeave();
                collision.collided.onRightCollisionLeave();
            }
        }
        for (Collision collision : prevRightCollisions) {
            if (collisionDoesNotExists(collision.collider, collision.collided, rightCollisions)) {
                collision.collider.onRightCollisionLeave();
                collision.collided.onLeftCollisionLeave();
            }
        }
        for (Collision collision : prevCollisions) {
            if (collisionDoesNotExists(collision.collider, collision.collided, collisions)) {
                collision.collider.onCollisionLeave();
                collision.collided.onCollisionLeave();
            }
        }
    }

    private void refreshCollisions() {
        prevTopCollisions.clear();
        prevTopCollisions.addAll(topCollisions);
        prevBottomCollisions.clear();
        prevBottomCollisions.addAll(bottomCollisions);
        prevLeftCollisions.clear();
        prevLeftCollisions.addAll(leftCollisions);
        prevRightCollisions.clear();
        prevRightCollisions.addAll(rightCollisions);
        prevCollisions.clear();
        prevCollisions.addAll(collisions);

        topCollisions.clear();
        bottomCollisions.clear();
        leftCollisions.clear();
        rightCollisions.clear();
        collisions.clear();
    }

    private boolean collisionDoesNotExists(Collidable collider, Collidable collided, List<Collision> collisions) {
        for (Collision collision : collisions) {
            if (collision.collider == collider && collision.collided == collided) {
                return false;
            }
        }
        return true;
    }

    private static class Collision {

        private Collidable collider;
        private Collidable collided;

        public Collision(Collidable collider, Collidable collided) {
            this.collider = collider;
            this.collided = collided;
        }
    }

}
