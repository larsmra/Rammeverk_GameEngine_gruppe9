package no.hiof.larsmra.GameEngine;

public abstract class MovableEntity extends Entity {

    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;

    protected int movementSpeed;

    /*
    public MovableEntity(String tag, Position position, int width, int height, int movementSpeed, Sprite sprite) {
        super(tag, position, width, height, sprite);
        this.movementSpeed = movementSpeed;
    }
     */

    public MovableEntity(String tag, Position position) {
        super(tag, position);
        movementSpeed = 0;
    }

    public void moveEntity(Game game) {
        setPrevPosition(new Position(position.getX(), position.getY()));

        movement(game);

        if (up) {
            position.setY(position.getY() - movementSpeed);
        }
        if (down) {
            position.setY(position.getY() + movementSpeed);
        }
        if (left) {
            position.setX(position.getX() - movementSpeed);
        }
        if (right) {
            position.setX(position.getX() + movementSpeed);
        }
    }

    public boolean isMoving() {
        if (!up && !down && !left && !right) {
            return false;
        }
        return true;
    }

    public abstract void movement(Game game);

    public void moveUp() {
        up = true;
        down = false;
    }

    public void moveDown() {
        down = true;
        up = false;
    }

    public void moveLeft() {
        left = true;
        right = false;
    }

    public void moveRight() {
        right = true;
        left = false;
    }

    public void stopUp() {
        up = false;
    }

    public void stopDown() {
        down = false;
    }

    public void stopLeft() {
        left = false;
    }

    public void stopRight() {
        right = false;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
}
