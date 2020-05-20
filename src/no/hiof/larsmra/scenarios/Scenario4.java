package no.hiof.larsmra.scenarios;

import no.hiof.larsmra.gameengine.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scenario4 {

    public static void main(String[] args) {

        TextEntity text1 = new TextEntity("Text1", new Position(50, 50));
        text1.setText("This is scene 1!");
        text1.setSize(20);

        TextEntity text2 = new TextEntity("Text2", new Position(50, 50));
        text2.setText("This is scene 2!");
        text2.setSize(20);

        TextEntity text3 = new TextEntity("Text2", new Position(50, 50));
        text3.setText("This is scene 3!");
        text3.setSize(20);

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

        Game game = new Game.GameBuilder()
                .addScene(scene1)
                .addScene(scene2)
                .addScene(scene3)
                .build();

        game.setActiveScene(scene1);

        Menu mainMenu = new Menu.MenuBuilder()
                .setStartButton("Start")
                .setQuitButton("Quit")
                .build();

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

        mainMenu.addButton("Choose scene", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.openMenu(sceneSelectorMenu);
            }
        });

        game.addMenu(mainMenu);
        game.addMenu(sceneSelectorMenu);
        game.openMenu(mainMenu);
        game.start();

    }

}
