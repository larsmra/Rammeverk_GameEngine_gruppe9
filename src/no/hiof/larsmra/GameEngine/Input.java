package no.hiof.larsmra.GameEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Set;

/**
 * A class for taking user input.
 */
final public class Input implements KeyListener {

    /**
     * A set of keys that are pressed.
     */
    private Set<Integer> pressed;
    private Set<Integer> released;


    public Input() {
        pressed = new HashSet<>();
        released = new HashSet<>();
    }

    /**
     * Checks if a specified key is pressed.
     * @param keyCode the key code of the specified key.
     * @return true if the key code was found in the set, false if it was not found.
     */
    public boolean isPressed(int keyCode) {
        return pressed.contains(keyCode);
    }

    public boolean isReleased(int keyCode) {
        return released.contains(keyCode);
    }

    public void update() {
        released.clear();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        pressed.add(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressed.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressed.remove(e.getKeyCode());
        released.add(e.getKeyCode());
    }

}
