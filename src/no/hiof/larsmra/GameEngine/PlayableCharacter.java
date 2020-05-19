package no.hiof.larsmra.GameEngine;

import java.util.HashMap;

public abstract class PlayableCharacter extends MoveableEntity {

    private MovementControls movementControls;

    private HashMap<Integer, KeyAction> keyActions;

    public PlayableCharacter(String tag, Position position, int width, int height, int movementSpeed, MovementControls movementControls, Sprite sprite) {
        super(tag, position, width, height, movementSpeed, sprite);
        this.movementControls = movementControls;
        keyActions = new HashMap<>();
    }

    public void addKeyAction(int keyCode, KeyAction action) {
        keyActions.put(keyCode, action);
    }

    @Override
    public void movement(Game game) {
        Input input = game.getInput();

        int up = movementControls.getUp();
        int down = movementControls.getDown();
        int left = movementControls.getLeft();
        int right = movementControls.getRight();

        if (input.isPressed(up)) {
            moveUp();
        }
        else {
            stopUp();
        }
        if (input.isPressed(down)) {
            moveDown();
        }
        else {
            stopDown();
        }
        if (input.isPressed(left)) {
            moveLeft();
        }
        else {
            stopLeft();
        }
        if (input.isPressed(right)) {
            moveRight();
        }
        else {
            stopRight();
        }
    }

}
