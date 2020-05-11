package no.hiof.larsmra.GameEngine;

/**
 * A class for setting the position of the Gravity Point.
 */
final public class GravityPoint {

    private int x, y;

    public GravityPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
