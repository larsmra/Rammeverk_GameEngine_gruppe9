package no.hiof.larsmra.Examples.GUITest;

import no.hiof.larsmra.GameEngine.*;
import no.hiof.larsmra.GameEngine.GUI.Menu;

import java.awt.event.KeyEvent;

public class GUITest2 {

    public static void main(String[] args) {

        Game game = new Game();

        Menu.Button btn = new Menu.Button("Test");

        btn.onClick(new Action() {
            @Override
            public void action() {
                System.out.println("Hei");
            }
        });

        Menu menu = new Menu.MenuBuilder()
                .setStartButton("Start")
                .setQuitButton("Quit")
                .build();

        game.addMenu(menu);
        game.openMenu(0);

        MovementControls mc = new MovementControls();
        mc.bindKeyUp(KeyEvent.VK_W);
        mc.bindKeyDown(KeyEvent.VK_S);
        mc.bindKeyLeft(KeyEvent.VK_A);
        mc.bindKeyRight(KeyEvent.VK_D);

        MovementControls mc2 = new MovementControls();
        mc2.bindKeyUp(KeyEvent.VK_UP);
        mc2.bindKeyDown(KeyEvent.VK_DOWN);
        mc2.bindKeyLeft(KeyEvent.VK_LEFT);
        mc2.bindKeyRight(KeyEvent.VK_RIGHT);

        Sprite s = new Sprite("C:\\Users\\LarsM\\Documents\\Skole\\hiof\\rammeverk\\testSprites\\bad_guy1.png");

        Player p = new Player("P1", new Position(10, 10), 50, 50, 5, mc, s);

        Player p2 = new Player("P2", new Position(200, 200), 60, 60, 5, mc2, s);

        Scene scene1 = new Scene.SceneBuilder(500, 500).build();
        Scene scene2 = new Scene.SceneBuilder(400, 400).build();

        Layer l = scene1.getLayer(0);

        l.addEntity(p);
        l.addEntity(p2);

        game.addScene(scene1);
        game.addScene(scene2);

        game.setActiveScene(0);

        game.start();
    }

    static class Player extends PlayableCharacter implements Collidable {

        public Player(String tag, Position position, int width, int height, int movementSpeed, MovementControls movementControls, Sprite sprite) {
            super(tag, position, width, height, movementSpeed, movementControls, sprite);
        }

        @Override
        public void onLeftCollision() {
            System.out.println("left");
        }

        @Override
        public void onRightCollision() {
            System.out.println("right");
        }

        @Override
        public void onTopCollision() {
            System.out.println("top");
        }

        @Override
        public void onBottomCollision() {
            System.out.println("bottom");
        }

        @Override
        public void onStaticCollision() {
            System.out.println("static");
        }

        @Override
        public void onLeftCollisionLeave() {
            System.out.println("left leave");
        }

        @Override
        public void onRightCollisionLeave() {
            System.out.println("right leave");
        }

        @Override
        public void onTopCollisionLeave() {
            System.out.println("top leave");
        }

        @Override
        public void onBottomCollisionLeave() {
            System.out.println("bottom leave");
        }

        @Override
        public void onStaticCollisionLeave() {
            System.out.println("static leave");
        }
    }

}
