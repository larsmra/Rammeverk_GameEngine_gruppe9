package no.hiof.larsmra.gameengine;

import java.awt.*;

/**
 * A class for rendering the game.
 */
final public class Renderer {

    private Game game;

    public Renderer(Game game) {
        this.game = game;
    }

    public void render(Graphics2D g2d) {

        Position camPos = game.getCamera().getPosition();

        for (Layer layer : game.getActiveScene().getLayers()) {
            for (String tag : layer.getTags()) {
                Entity entity = layer.getEntity(tag);

                int x = (int) (entity.getPosition().getX() - camPos.getX() * layer.getSpeed());
                int y = (int) ((entity.getPosition().getY() - camPos.getY()) * layer.getSpeed());

                if (entity instanceof TextEntity) {
                    renderText(g2d, (TextEntity) entity, x, y);
                }
                else {
                    renderSprites(g2d, entity, x, y);
                }
            }
        }
    }

    private void renderSprites(Graphics2D g2d, Entity entity, int x, int y) {
        if (entity.sprite != null) {
            g2d.drawImage(entity.getSprite().getImage(), x, y, entity.getWidth(), entity.getHeight(), null);
        }
    }

    private void renderText(Graphics2D g2d, TextEntity textEntity, int x, int y) {
        Font font = g2d.getFont().deriveFont(textEntity.getSize());
        g2d.setFont(font);
        g2d.drawString(textEntity.getText(), x, y);
    }

}
