package no.hiof.larsmra.GameEngine.GUI;

import no.hiof.larsmra.GameEngine.Action;
import no.hiof.larsmra.GameEngine.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Menu extends JPanel {

    private static Game game = null;

    private List<Button> btns;

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
            System.out.println("Test 2");
            /*
            startBtn.btn.setVisible(false);
            quitBtn.btn.setVisible(false);
             */
            visible = false;
        }
        //setVisible(false);
    }

    public static class MenuBuilder {

        /*
        private Button startBtn = null;
        private Button quitBtn = null;
         */

        Menu menu;
        List<Button> btns = new ArrayList<>();

        public MenuBuilder() {
            menu = new Menu();
        }

        public MenuBuilder setStartButton(String text) {
            Button startBtn = new Button(text);
            startBtn.onClick(() -> {
                game.closeMenu();
                System.out.println("Test");
                //game.start();
            });
            btns.add(startBtn);
            return this;
        }

        public MenuBuilder setQuitButton(String text) {
            Button quitBtn = new Button(text);
            quitBtn.onClick(() -> game.stop());
            btns.add(quitBtn);
            return this;
        }

        public MenuBuilder addButton(String text) {

            return this;
        }

        public Menu build() {
            Menu menu = new Menu();

            for (Button btn : btns) {
                menu.btns.add(btn);
                menu.add(btn.btn, menu.gbc);
                menu.add(Box.createRigidArea(new Dimension(0, 40)));
            }

            this.menu = null;

            return menu;
        }

    }

    public static class Button {

        private JButton btn;

        public Button(String text) {
            btn = new JButton(text);
        }

        public void onClick(Action action) {
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    action.action();
                }
            });
        }

    }

}