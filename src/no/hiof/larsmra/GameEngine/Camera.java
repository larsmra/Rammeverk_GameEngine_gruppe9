package no.hiof.larsmra.GameEngine;

final public class Camera {

    private Entity target;

    private Position cameraPosition;

    public Camera() {
        cameraPosition = new Position(0, 0);
    }

    /*
    public void trackEntity(String tag) {
        Entity entity = game.getActiveScene().getEntity(tag);

        if (entity == null) {
            return;
        }

        target = entity;
    }
     */

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

    public void setTarget(Entity target) {
        this.target = target;
    }

    public void setTarget(String tag) {
        this.target = Entity.getEntity(tag);
    }
}
