package no.hiof.larsmra.GameEngine.GUI;

import no.hiof.larsmra.GameEngine.Entity;
import no.hiof.larsmra.GameEngine.Position;

public abstract class TextEntity extends Entity {

    protected String text;
    protected float size;

    public TextEntity(String tag, String text, float size) {
        super(tag);
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
