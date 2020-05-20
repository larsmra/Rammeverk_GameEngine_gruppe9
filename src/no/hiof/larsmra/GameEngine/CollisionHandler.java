package no.hiof.larsmra.GameEngine;

import java.util.ArrayList;
import java.util.List;

final public class CollisionHandler {

    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int TOP = 3;
    private static final int BOTTOM = 4;
    private static final int NONE = 0;

    private List<Collision> topCollisions = new ArrayList<>();
    private List<Collision> bottomCollisions = new ArrayList<>();
    private List<Collision> leftCollisions = new ArrayList<>();
    private List<Collision> rightCollisions = new ArrayList<>();
    private List<Collision> staticCollisions = new ArrayList<>();

    private List<Collision> prevTopCollisions = new ArrayList<>();
    private List<Collision> prevBottomCollisions = new ArrayList<>();
    private List<Collision> prevLeftCollisions = new ArrayList<>();
    private List<Collision> prevRightCollisions = new ArrayList<>();
    private List<Collision> prevStaticCollisions = new ArrayList<>();

    public void addCollision(Collidable collider, Collidable collided) {
        int direction = checkRelativeDirection((Entity) collider, (Entity) collided);
        if (direction == LEFT) {
            leftCollisions.add(new Collision(collider, collided));
        }
        if (direction == RIGHT) {
            rightCollisions.add(new Collision(collider, collided));
        }
        if (direction == TOP) {
            topCollisions.add(new Collision(collider, collided));
        }
        if (direction == BOTTOM) {
            bottomCollisions.add(new Collision(collider, collided));
        }
        if (direction == NONE) {
            staticCollisions.add(new Collision(collider, collided));
        }

    }

    private int checkRelativeDirection(Entity collider, Entity collided) {
        Position prevCollider = collider.getPrevPosition();

        Position currentCollided = collided.getPosition();

        if ((prevCollider.getX() + collider.getWidth()) < currentCollided.getX()) {
            return RIGHT;
        }
        if (prevCollider.getX() > (currentCollided.getX() + collided.getWidth())) {
            return LEFT;
        }
        if ((prevCollider.getY() + collider.getHeight()) < currentCollided.getY()) {
            return BOTTOM;
        }
        if (prevCollider.getY() > (currentCollided.getY() + collided.getHeight())) {
            return TOP;
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
        for (Collision collision : staticCollisions) {
            collision.collider.onStaticCollision();
            collision.collided.onStaticCollision();
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
        for (Collision collision : prevStaticCollisions) {
            if (collisionDoesNotExists(collision.collider, collision.collided, staticCollisions)) {
                collision.collider.onStaticCollisionLeave();
                collision.collided.onStaticCollisionLeave();
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
        prevStaticCollisions.clear();
        prevStaticCollisions.addAll(staticCollisions);

        topCollisions.clear();
        bottomCollisions.clear();
        leftCollisions.clear();
        rightCollisions.clear();
        staticCollisions.clear();
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
