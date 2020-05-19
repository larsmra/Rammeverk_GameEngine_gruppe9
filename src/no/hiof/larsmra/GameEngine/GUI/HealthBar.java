package no.hiof.larsmra.GameEngine.GUI;

import no.hiof.larsmra.GameEngine.*;
import no.hiof.larsmra.GameEngine.Character;

public class HealthBar extends Entity {

    private Character character;

    public HealthBar(String tag, Position position, int width, int height, Sprite sprite, Character character) {
        super(tag, position, width, height, sprite);
        this.character = character;
    }

}
