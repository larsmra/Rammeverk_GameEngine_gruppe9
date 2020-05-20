package no.hiof.larsmra.GameEngine.GUI;

import no.hiof.larsmra.GameEngine.Entity;
import no.hiof.larsmra.GameEngine.Game;
import no.hiof.larsmra.GameEngine.Position;

import java.awt.*;

final public class ScoreBoard extends TextEntity {

    int score;

    public ScoreBoard(String tag, Position position) {
        super(tag, "0", 20.0f);
        this.position = position;
        this.score = 0;
    }

    public ScoreBoard(String tag, Position position, int score, float size) {
        super(tag, Integer.toString(score), size);
        this.position = position;
        this.score = score;
    }

    public void incrementScore() {
        score++;
        text = Integer.toString(score);
    }

    public void incrementScore(int points) {
        score += points;
        text = Integer.toString(score);
    }

    public void decrementScore() {
        score--;
        text = Integer.toString(score);
    }

    public void decrementScore(int points) {
        score -= points;
        text = Integer.toString(score);
    }

    public int getScore() {
        return score;
    }

}
