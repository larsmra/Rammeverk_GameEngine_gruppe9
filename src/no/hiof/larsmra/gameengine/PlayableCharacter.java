package no.hiof.larsmra.gameengine;

/**
 * A class for creating a playable character.
 */
public abstract class PlayableCharacter extends MovableEntity {

    protected MovementControls movementControls;

    public PlayableCharacter(String tag, Position position) {
        super(tag, position);
        movementControls = null;
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

    public MovementControls getMovementControls() {
        return movementControls;
    }

    public void setMovementControls(MovementControls movementControls) {
        this.movementControls = movementControls;
    }
}
