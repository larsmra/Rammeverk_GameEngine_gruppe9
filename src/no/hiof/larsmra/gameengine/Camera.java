package no.hiof.larsmra.gameengine;

/**
 * A camera class.
 * Is used to track entities in a game.
 */
final public class Camera {

    private Entity target;

    private Position cameraPosition;

    public Camera() {
        cameraPosition = new Position(0, 0);
    }

    public void update(Game game) {
        if (target == null) {
            return;
        }

        int x = (target.getPosition().getX() + (target.getWidth() / 2)) - (game.getWidth() / 2);
        int y = (target.getPosition().getY() + (target.getHeight() / 2)) - (game.getHeight() / 2);

        cameraPosition.setX(x);
        cameraPosition.setY(y);
    }

    public Position getPosition() {
        return cameraPosition;
    }

    /**
     * Sets the focusing target.
     *
     * @param tag the tag of the entity.
     */
    public void setTarget(String tag) {
        this.target = Entity.getEntity(tag);
    }
}
