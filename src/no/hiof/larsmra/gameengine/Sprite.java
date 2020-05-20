package no.hiof.larsmra.gameengine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A class for creating a sprite.
 */
final public class Sprite {

    private BufferedImage image;

    public Sprite(String imagePath) {
        try {
            this.image = ImageIO.read(new File(imagePath));
        }
        catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public BufferedImage getImage() {
        return image;
    }
}
