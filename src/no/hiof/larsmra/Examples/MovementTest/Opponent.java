package no.hiof.larsmra.Examples.MovementTest;

import no.hiof.larsmra.GameEngine.Collidable;
import no.hiof.larsmra.GameEngine.NonPlayableCharacter;
import no.hiof.larsmra.GameEngine.Position;
import no.hiof.larsmra.GameEngine.Sprite;

public class Opponent extends NonPlayableCharacter implements Collidable {
    public Opponent(String tag, Position position, int width, int height, int movementSpeed, int detectionRadius, Behaviour behaviour, Sprite sprite) {
        super(tag, position, width, height, movementSpeed, detectionRadius, behaviour, sprite);
    }

    @Override
    public void onLeftCollision() {
        System.out.println("Left side of " + getTag() + " collided");
    }

    @Override
    public void onRightCollision() {
        System.out.println("Right side of " + getTag() + " collided");
    }

    @Override
    public void onTopCollision() {
        System.out.println("Top side of " + getTag() + " collided");
    }

    @Override
    public void onBottomCollision() {
        System.out.println("Bottom side of " + getTag() + " collided");
    }

    @Override
    public void onStaticCollision() {
        System.out.println(getTag() + " collision");
    }

    @Override
    public void onLeftCollisionLeave() {
        System.out.println(getTag() + " departed from entity on its left");
    }

    @Override
    public void onRightCollisionLeave() {
        System.out.println(getTag() + " departed from entity on its right");
    }

    @Override
    public void onTopCollisionLeave() {
        System.out.println(getTag() + " departed from entity on its top");
    }

    @Override
    public void onBottomCollisionLeave() {
        System.out.println(getTag() + " departed from entity on its bottom");
    }

    @Override
    public void onStaticCollisionLeave() {
        System.out.println(getTag() + " departed!");
    }
}
