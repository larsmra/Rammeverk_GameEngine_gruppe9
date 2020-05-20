package no.hiof.larsmra.GameEngine;

import java.util.HashMap;

/**
 * This class is responsible for movement of entities.
 * Supposed to replace the move() method in Entity (maybe??). Remember to remove this line before delivery :^)
 */
final public class MovementControls {

    private int up = -1, down = -1, left = -1, right = -1;

    public MovementControls() {

    }

    public void bindKeyUp(int keyCode) {
        up = keyCode;
    }

    public void bindKeyDown(int keyCode) {
        down = keyCode;
    }

    public void bindKeyLeft(int keyCode) {
        left = keyCode;
    }

    public void bindKeyRight(int keyCode) {
        right = keyCode;
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
}
