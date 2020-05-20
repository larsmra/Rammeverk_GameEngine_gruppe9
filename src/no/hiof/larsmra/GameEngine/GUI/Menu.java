package no.hiof.larsmra.GameEngine.GUI;

import no.hiof.larsmra.GameEngine.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

final public class Menu extends JPanel {

    private static Game game = null;

    private List<JButton> btns;

    private boolean visible = false;
    GridBagConstraints gbc;

    public Menu() {
        btns = new ArrayList<>();
        //menu = new JPanel();
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
    }

    public void setGame(Game game) {
        Menu.game = game;
    }

    public void addButton() {

    }

    public void showMenu() {
        if (!visible) {
            setVisible(true);
            /*
            startBtn.btn.setVisible(true);
            quitBtn.btn.setVisible(true);
             */
            visible = true;
        }
        //setVisible(true);
    }

    public void hideMenu() {
        if (visible) {
            setVisible(false);
            /*
            startBtn.btn.setVisible(false);
            quitBtn.btn.setVisible(false);
             */
            visible = false;
        }
        //setVisible(false);
    }

    public static class MenuBuilder {

        Menu menu;
        List<JButton> btns = new ArrayList<>();

        public MenuBuilder() {
            menu = new Menu();
        }

        public MenuBuilder setStartButton(String text) {
            JButton startBtn = new JButton(text);
            startBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    game.closeMenu();
                }
            });
            btns.add(startBtn);
            return this;
        }

        public MenuBuilder setQuitButton(String text) {
            JButton quitBtn = new JButton(text);
            quitBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    game.stop();
                }
            });
            btns.add(quitBtn);
            return this;
        }

        public MenuBuilder addButton(String text, ActionListener actionListener) {
            JButton btn = new JButton(text);
            btn.addActionListener(actionListener);
            return this;
        }

        public Menu build() {
            Menu menu = new Menu();

            for (JButton btn : btns) {
                menu.btns.add(btn);
                menu.add(btn, menu.gbc);
                menu.add(Box.createRigidArea(new Dimension(0, 40)));
            }

            this.menu = null;

            return menu;
        }

    }

}
