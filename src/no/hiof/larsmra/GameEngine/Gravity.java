package no.hiof.larsmra.GameEngine;

/**
 * Gravity for a game scene.
 */
final public class Gravity {

    private GravityPoint gravityPoint;
    private double strength;

    /**
     * Create a gravity object with a specific gravity point.
     * @param gravityPoint the gravity point.
     * @param strength the gravity force.
     */
    public Gravity(GravityPoint gravityPoint, double strength) {
        this.gravityPoint = gravityPoint;
        this.strength = strength;
    }
}
