package no.hiof.larsmra.GameEngine;

import java.awt.*;

final public class Renderer {

    private Game game;

    public Renderer(Game game) {
        this.game = game;
    }

    public void render(Graphics2D g2d, Scene active, Camera camera) {
        // g2d.drawImage(sprite.getImage(), getPosition().getX(), getPosition().getY(), width, height,null);

        Position camPos = camera.getPosition();
        //System.out.println(camPos.getX() + " , " + camPos.getY());

        for (Layer layer : active.getLayers()) {
            for (String tag : layer.getTags()) {
                Entity entity = layer.getEntity(tag);

                int x = (int) (entity.getPosition().getX() - camPos.getX() * layer.getSpeed());
                int y = (int) ((entity.getPosition().getY() - camPos.getY()) * layer.getSpeed());

                g2d.drawImage(entity.getSprite().getImage(), x, y, entity.getWidth(), entity.getHeight(), null);
            }
        }
    }

}
