package no.hiof.larsmra.Examples.Pong;

import no.hiof.larsmra.GameEngine.*;
import no.hiof.larsmra.GameEngine.GUI.ScoreBoard;

import java.awt.*;

public class Ball extends Entity {

    private static final int SPEED = 10;

    private int dirX = SPEED;
    private int dirY = SPEED;

    public Ball(String tag, Position position) {
        super(tag, position, 20, 20, new Sprite("C:\\Users\\LarsM\\Documents\\Skole\\hiof\\rammeverk\\testSprites\\ball1.png"));
        addCollision(new CollisionListener() {
            @Override
            public void onCollision() {
                dirX *= -1;
            }
        });
    }

    // Sets the movement of the ball.

    public void move(Game game) {
        // Set the ball's position to the middle of the board if it hits the left or the right side of the board.
        if (getPosition().getX() <= 0) {
            getPosition().setY(250);
            getPosition().setX(450);
            ScoreBoard scoreBoard = (ScoreBoard) game.getActiveScene().getLayer(1).getEntity("scoreboard opponent");
            scoreBoard.incrementScore();
        }
        else if (getPosition().getX() >= 900) {
            getPosition().setY(250);
            getPosition().setX(450);
            ScoreBoard scoreBoard = (ScoreBoard) game.getActiveScene().getLayer(1).getEntity("scoreboard player");
            scoreBoard.incrementScore();
        }
        // Change the direction of the ball if it hits the top or bottom side of the board.
        if (getPosition().getY() <= 0) {
            dirY = SPEED;
        }
        else if ((getPosition().getY() + getHeight()) >= 500) {
            dirY = -SPEED;
        }

        getPosition().setX(getPosition().getX() + dirX);
        getPosition().setY(getPosition().getY() + dirY);
    }
}
