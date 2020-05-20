package no.hiof.larsmra.gameengine;

/**
 * A class for text entities.
 * It can be used to add text to a game.
 */
public class TextEntity extends Entity {

    protected String text;
    protected float size;

    public TextEntity(String tag, Position position) {
        super(tag, position);
        text = "";
        size = 0;
    }

    public TextEntity(String tag, Position position, String text, float size) {
        super(tag, position);
        this.text = text;
        this.size = size;
    }

    public String getText() {
        return text;
    }

    public float getSize() {
        return size;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSize(float size) {
        this.size = size;
    }
}
