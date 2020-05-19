package no.hiof.larsmra.GameEngine.GUI;

import no.hiof.larsmra.GameEngine.Entity;
import no.hiof.larsmra.GameEngine.Game;
import no.hiof.larsmra.GameEngine.Position;

import java.awt.*;

final public class ScoreBoard extends Entity {

    int score;

    public ScoreBoard(String tag, Position position) {
        super(tag, position, 0, 0, null);
        this.score = 0;
    }

    public ScoreBoard(String tag, Position position, int score) {
        super(tag, position, 0, 0, null);
        this.score = score;
    }

    public void incrementScore() {
        score++;
    }

    public void decrementScore() {
        score--;
    }

    @Override
    public void render(Graphics2D g2d) {
        Position pos = getPosition();
        Font font = g2d.getFont().deriveFont(20.0f);
        g2d.setFont(font);
        g2d.drawString(String.valueOf(score), pos.getX(), pos.getY());
    }

}
