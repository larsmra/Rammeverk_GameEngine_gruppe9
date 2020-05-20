package no.hiof.larsmra.gameengine;

final public class ScoreBoard extends TextEntity {

    int score;

    public ScoreBoard(String tag, Position position) {
        super(tag, position, "0", 20.0f);
        this.score = 0;
    }

    public ScoreBoard(String tag, Position position, int score, float size) {
        super(tag, position, Integer.toString(score), size);
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
