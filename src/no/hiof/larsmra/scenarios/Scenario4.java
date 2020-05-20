package no.hiof.larsmra.scenarios;

import no.hiof.larsmra.gameengine.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Scenario 4:
 *
 * In this scenario, two menus are created. One menu contains a start, and a quit button,
 * and a button for opening the second menu. The second menu contains buttons for choosing
 * which of the scenes are going to be used, and a button for going back to the first
 * menu.
 */
public class Scenario4 {

    public static void main(String[] args) {

        // Creates text
        TextEntity text1 = new TextEntity("Text1", new Position(50, 50));
        text1.setText("This is scene 1!");
        text1.setSize(20);

        TextEntity text2 = new TextEntity("Text2", new Position(50, 50));
        text2.setText("This is scene 2!");
        text2.setSize(20);

        TextEntity text3 = new TextEntity("Text2", new Position(50, 50));
        text3.setText("This is scene 3!");
        text3.setSize(20);

        // Adds the text to layers in the different scenes.
        Scene scene1 = new Scene.SceneBuilder()
                .addLayer(
                        new Layer.LayerBuilder()
                        .addEntity(text1)
                        .build()
                )
                .build();

        Scene scene2 = new Scene.SceneBuilder()
                .addLayer(
                        new Layer.LayerBuilder()
                        .addEntity(text2)
                        .build()
                )
                .build();

        Scene scene3 = new Scene.SceneBuilder()
                .addLayer(
                        new Layer.LayerBuilder()
                        .addEntity(text3)
                        .build()
                )
                .build();

        // Creates a game and adds the scenes.
        Game game = new Game.GameBuilder()
                .addScene(scene1)
                .addScene(scene2)
                .addScene(scene3)
                .build();

        // Set scene1 to be the currently active scene.
        game.setActiveScene(scene1);

        // Creates a menu with a start and quit button.
        Menu mainMenu = new Menu.MenuBuilder()
                .setStartButton("Start")
                .setQuitButton("Quit")
                .build();

        // Creates a menu for selecting scenes.
        Menu sceneSelectorMenu = new Menu.MenuBuilder()
                .addButton("Scene 1", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        game.setActiveScene(scene1);
                    }
                })
                .addButton("Scene 2", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        game.setActiveScene(scene2);
                    }
                })
                .addButton("Scene 3", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        game.setActiveScene(scene3);
                    }
                })
                .addButton("Back", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        game.openMenu(mainMenu);
                    }
                })
                .build();

        // Adds a new button to the first menu.
        // This button goes to the second menu.
        mainMenu.addButton("Choose scene", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.openMenu(sceneSelectorMenu);
            }
        });

        // Adds the menus to the game.
        game.addMenu(mainMenu);
        game.addMenu(sceneSelectorMenu);

        // Sets a menu to open.
        game.openMenu(mainMenu);

        // Start the game.
        game.start();

    }

}
