import biuoop.DrawSurface;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class Background.
 *
 * @author Karin Shimel.
 */
public class Background implements Sprite {
    private Color color = null;
    private String image;
    private String title;

    /**
     * Constructor(1).
     * Creates a new Background.
     *
     * @param color1 the color 1
     * @param name   the name
     */
    public Background(Color color1, String name) {
        this.color = color1;
        this.title = name;
    }

    /**
     * Constructor(2).
     * Creates a new Background.
     *
     * @param image1 the image 1
     * @param name   the name
     */
    public Background(String image1, String name) {
        this.image = image1;
        this.title = name;
    }

    /**
     * Draw on method.
     *
     * @param d - the relevant draw surface.
     */
    public void drawOn(DrawSurface d) {
        // If the color is not set - we will draw the image
        if (this.color == null) {
            // Draw image
            Image background = null;
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(this.image);
            try {
                background = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            d.drawImage(0, 0, background);
            d.setColor(Color.white);
            d.fillRectangle(0, 0, 800, 25);
        } else {
            // Setting background color
            d.setColor(Color.WHITE);
            d.fillRectangle(0, 0, 800, 25);
            d.setColor(this.color);
            d.fillRectangle(0, 25, 800, 600);
        }
        d.setColor(Color.BLACK);
        d.drawText(550, 15, "Level: " + this.title, 20);
    }


    /**
     * Notifying that time has passed.
     */
    public void timePassed() {

    }
}
