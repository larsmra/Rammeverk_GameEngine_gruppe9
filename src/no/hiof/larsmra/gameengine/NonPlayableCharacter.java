package no.hiof.larsmra.gameengine;

public abstract class NonPlayableCharacter extends MovableEntity {

    protected int detectionRadius;

    /*
    public NonPlayableCharacter(String tag, Position position, int width, int height, int movementSpeed, int detectionRadius, Sprite sprite) {
        super(tag, position, width, height, movementSpeed, sprite);
        this.detectionRadius = detectionRadius;
    }
     */

    public NonPlayableCharacter(String tag, Position position) {
        super(tag, position);
        detectionRadius = 0;
    }

    public void trackEntityVertically(String tag) {
        Entity entity = getEntity(tag);
        if (isOutsideRadius(entity)) {
            return;
        }
        if (entity.getPosition().getY() > getPosition().getY()) {
            moveDown();
        }
        else if (entity.getPosition().getY() < getPosition().getY()) {
            moveUp();
        }
        else {
            stopUp();
            stopDown();
        }
    }

    public void trackEntityHorizontally(String tag) {
        Entity entity = getEntity(tag);
        if (isOutsideRadius(entity)) {
            return;
        }
        if (entity.getPosition().getX() > getPosition().getX()) {
            moveRight();
        }
        else if (entity.getPosition().getX() < getPosition().getX()) {
            moveLeft();
        }
        else {
            stopLeft();
            stopRight();
        }
    }

    public void trackEntity(String tag) {
        Entity entity = getEntity(tag);
        if (isOutsideRadius(entity)) {
            return;
        }
        trackEntityVertically(tag);
        trackEntityHorizontally(tag);
    }

    public void moveAwayFromEntity(Entity entity) {
        if (isOutsideRadius(entity)) {
            return;
        }

        if (entity.getPosition().getY() > getPosition().getY()) {
            moveUp();
        }
        else if (entity.getPosition().getY() < getPosition().getY()) {
            moveDown();
        }
        if (entity.getPosition().getX() > getPosition().getX()) {
            moveLeft();
        }
        else if (entity.getPosition().getX() < getPosition().getX()) {
            moveRight();
        }
    }

    private boolean isOutsideRadius(Entity entity) {
        int entityCenter = entity.getPosition().getX() + (entity.getWidth() / 2) + (entity.getHeight() / 2);
        int thisCenter = getPosition().getX() + (getWidth() / 2) + (getHeight() / 2);
        if (Math.abs(entityCenter - thisCenter) > detectionRadius ||
                Math.abs(entity.getPosition().getY() - getPosition().getY()) > detectionRadius) {

            stopUp();
            stopDown();
            stopLeft();
            stopRight();

            return true;
        }
        return false;
    }

    public int getDetectionRadius() {
        return detectionRadius;
    }

    public void setDetectionRadius(int detectionRadius) {
        this.detectionRadius = detectionRadius;
    }
}
