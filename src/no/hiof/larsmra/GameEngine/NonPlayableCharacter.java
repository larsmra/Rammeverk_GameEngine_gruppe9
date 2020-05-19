package no.hiof.larsmra.GameEngine;

public abstract class NonPlayableCharacter extends MoveableEntity {

    private Behaviour behaviour;
    private int detectionRadius;

    public NonPlayableCharacter(String tag, Position position, int width, int height, int movementSpeed, int detectionRadius, Behaviour behaviour, Sprite sprite) {
        super(tag, position, width, height, movementSpeed, sprite);
        this.behaviour = behaviour;
        this.detectionRadius = detectionRadius;
    }

    public NonPlayableCharacter(String tag, Position position, int width, int height, int movementSpeed, int detectionRadius, Sprite sprite) {
        super(tag, position, width, height, movementSpeed, sprite);
        this.behaviour = Behaviour.NONE;
        this.detectionRadius = detectionRadius;
    }

    @Override
    public void movement(Game game) {
        Entity player = game.getActiveScene().getLayer(0).getEntity("Player");
        if (behaviour == Behaviour.AGGRESSIVE) {
            trackEntity(player);
        }
        else if (behaviour == Behaviour.INTIMIDATED) {
            moveAwayFromEntity(player);
        }
    }

    public void trackEntity(Entity entity) {
        if (Math.abs(entity.getPosition().getX() - getPosition().getX()) > detectionRadius ||
                Math.abs(entity.getPosition().getY() - getPosition().getY()) > detectionRadius) {

            stopUp();
            stopDown();
            stopLeft();
            stopRight();

            return;
        }

        if (entity.getPosition().getY() > getPosition().getY()) {
            moveDown();
        }
        else if (entity.getPosition().getY() < getPosition().getY()) {
            moveUp();
        }
        if (entity.getPosition().getX() > getPosition().getX()) {
            moveRight();
        }
        else if (entity.getPosition().getX() < getPosition().getX()) {
            moveLeft();
        }
    }

    public void moveAwayFromEntity(Entity entity) {
        if (Math.abs(entity.getPosition().getX() - getPosition().getX()) > detectionRadius ||
            Math.abs(entity.getPosition().getY() - getPosition().getY()) > detectionRadius) {

            stopUp();
            stopDown();
            stopLeft();
            stopRight();

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

    public enum Behaviour {

        NONE,
        AGGRESSIVE,
        INTIMIDATED

    }
}
