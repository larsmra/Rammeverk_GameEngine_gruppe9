package no.hiof.larsmra.GameEngine;

public interface Collidable {
    void onLeftCollision();
    void onRightCollision();
    void onTopCollision();
    void onBottomCollision();
    void onStaticCollision();
    void onLeftCollisionLeave();
    void onRightCollisionLeave();
    void onTopCollisionLeave();
    void onBottomCollisionLeave();
    void onStaticCollisionLeave();
}