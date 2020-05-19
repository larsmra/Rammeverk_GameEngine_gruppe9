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
final public class Input implements KeyListener, MouseListener {

    /**
     * A set of keys that are pressed.
     */
    private Set<Integer> pressed;

    private Set<Integer> justPressed;


    public Input() {
        pressed = new HashSet<>();
        justPressed = new HashSet<>();
    }

    /**
     * Checks if a specified key is pressed.
     * @param keyCode the key code of the specified key.
     * @return true if the key code was found in the set, false if it was not found.
     */
    public boolean isPressed(int keyCode) {
        return pressed.contains(keyCode);
    }

    /*
    public boolean justPressed(int keyCode) {
        System.out.println(keyCode + " : " + justPressed);
        return justPressed.contains(keyCode);
    }
     */

    /*
    public boolean isPressedFirst(int firstKeyCode, int secondKeyCode) {
        for (int keyCode : pressed) {
            if (firstKeyCode == keyCode) {
                return true;
            }
            else if (secondKeyCode == keyCode) {
                return false;
            }
        }
        return false;
    }
     */

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
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
