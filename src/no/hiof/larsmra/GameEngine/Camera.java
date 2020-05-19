package no.hiof.larsmra.GameEngine;

public class Camera {

    //private String targetTag;
    private Entity target;

    private Position cameraPosition;

    private Game game;

    public Camera(Game game) {
        this.game = game;
        cameraPosition = new Position(0, 0);
    }

    public void trackEntity(String tag) {
        Entity entity = game.getActiveScene().getEntity(tag);

        if (entity == null) {
            return;
        }

        //targetTag = tag;
        target = entity;



        //System.out.println(cameraPosition.getX() + " , " + cameraPosition.getY());
    }

    public void update() {
        if (target == null) {
            return;
        }

        int x = (target.getPosition().getX() + (target.getWidth() / 2)) - (game.getActiveScene().getWidth() / 2);
        int y = (target.getPosition().getY() + (target.getHeight() / 2)) - (game.getActiveScene().getHeight() / 2);

        cameraPosition.setX(x);
        cameraPosition.setY(y);
    }

    public Position getPosition() {
        return cameraPosition;
    }
}
