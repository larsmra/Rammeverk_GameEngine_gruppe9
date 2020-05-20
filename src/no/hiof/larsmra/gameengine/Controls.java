package no.hiof.larsmra.gameengine;

import java.util.HashMap;

/**
 * This class is handling the user controls of the game.
 */
final public class Controls {

    private HashMap<Integer, Command> pressedCommands = new HashMap<>();
    private HashMap<Integer, Command> typedCommands = new HashMap<>();

    public void bindPressedKeyCommand(int keyCode, Command command) {
        pressedCommands.put(keyCode, command);
    }

    public void bindTypedKeyCommand(int keyCode, Command command) {
        typedCommands.put(keyCode, command);
    }

    public void update(Game game) {
        for (int key : pressedCommands.keySet()) {
            if (game.getInput().isPressed(key)) {
                pressedCommands.get(key).doCommand();
            }
        }
        for (int key : typedCommands.keySet()) {
            if (game.getInput().isReleased(key)) {
                typedCommands.get(key).doCommand();
            }
        }
    }

}
