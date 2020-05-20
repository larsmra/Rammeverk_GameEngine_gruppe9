package no.hiof.larsmra.gameengine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * A class for creating a menu for a game.
 */
final public class Menu extends JPanel {

    private static Game game = null;

    private List<JButton> btns;

    private boolean visible = false;
    private GridBagConstraints gbc;

    public Menu() {
        setVisible(false);
        btns = new ArrayList<>();
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
    }

    public void setGame(Game game) {
        Menu.game = game;
    }

    public void addStartButton(String text) {
        JButton startBtn = new JButton(text);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.closeMenu();
            }
        });
        btns.add(startBtn);
        add(startBtn, gbc);
        add(Box.createRigidArea(new Dimension(0, 40)));
    }

    public void addQuitButton(String text) {
        JButton quitBtn = new JButton(text);
        quitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.stop();
            }
        });
        btns.add(quitBtn);
        add(quitBtn, gbc);
        add(Box.createRigidArea(new Dimension(0, 40)));
    }

    public void addButton(String text, ActionListener listener) {
        JButton btn = new JButton(text);
        btn.addActionListener(listener);
        btns.add(btn);
        add(btn, gbc);
        add(Box.createRigidArea(new Dimension(0, 40)));
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
            menu.btns.add(startBtn);
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
            menu.btns.add(quitBtn);
            return this;
        }

        public MenuBuilder addButton(String text, ActionListener actionListener) {
            JButton btn = new JButton(text);
            btn.addActionListener(actionListener);
            menu.btns.add(btn);
            return this;
        }

        public Menu build() {
            Menu menu = new Menu();

            menu.btns.addAll(this.menu.btns);
            for (JButton btn : this.menu.btns) {
                menu.btns.add(btn);
                menu.add(btn, menu.gbc);
                menu.add(Box.createRigidArea(new Dimension(0, 40)));
            }

            this.menu = null;

            return menu;
        }

    }

}
