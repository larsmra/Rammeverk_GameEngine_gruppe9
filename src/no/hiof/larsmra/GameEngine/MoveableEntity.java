package no.hiof.larsmra.GameEngine;

public abstract class MoveableEntity extends Entity {


    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;

    private int movementSpeed;

    private int xSpeed;
    private int ySpeed;

    public MoveableEntity(String tag, Position position, int width, int height, int movementSpeed, Sprite sprite) {
        super(tag, position, width, height, sprite);
        this.movementSpeed = movementSpeed;

        xSpeed = movementSpeed;
        ySpeed = movementSpeed;
    }

    public void moveEntity(Game game) {
        setPrevPosition(new Position(getPosition().getX(), getPosition().getY()));
        movement(game);

        if (up) {
            getPosition().setY(getPosition().getY() - ySpeed);
        }
        if (down) {
            getPosition().setY(getPosition().getY() + ySpeed);
        }
        if (left) {
            getPosition().setX(getPosition().getX() - xSpeed);
        }
        if (right) {
            getPosition().setX(getPosition().getX() + xSpeed);
        }
    }

    /*
    public void moveDiagonallyTowardsEntity(Entity entity) {
        Position thisPos = getPosition();
        Position otherPos = entity.getPosition();

        int height = Math.abs(thisPos.getY() - otherPos.getY());
        int width = Math.abs(thisPos.getX() - otherPos.getX());

        if (height < width) {
            int steps = width / movementSpeed;
            ySpeed = height / steps;
        }
        else {
            int steps = height / movementSpeed;
            xSpeed = width / steps;
        }

    }
     */

    public abstract void movement(Game game);

    public void moveUp() {
        //getPosition().setY(getPosition().getY() - movementSpeed);
        up = true;
        down = false;
    }

    public void moveDown() {
        //getPosition().setY(getPosition().getY() + movementSpeed);
        down = true;
        up = false;
    }

    public void moveLeft() {
        //getPosition().setX(getPosition().getX() - movementSpeed);
        left = true;
        right = false;
    }

    public void moveRight() {
        //getPosition().setX(getPosition().getX() + movementSpeed);
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

}
