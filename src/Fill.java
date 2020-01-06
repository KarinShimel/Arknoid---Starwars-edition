import biuoop.DrawSurface;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class Fill.
 *
 * @author Karin Shimel.
 */
public class Fill implements Sprite {
    private String image;
    private int height;
    private int width;
    private Color color = null;

    /**
     * Sets color.
     *
     * @param color1 the color
     */
    public void setColor(Color color1) {
        this.color = color1;
    }

    /**
     * Sets width.
     *
     * @param width1 the width
     */
    public void setWidth(int width1) {
        this.width = width1;
    }

    /**
     * Sets height.
     *
     * @param height1 the height
     */
    public void setHeight(int height1) {
        this.height = height1;
    }

    /**
     * Sets image.
     *
     * @param image1 the image
     */
    public void setImage(String image1) {
        this.image = image1;
    }

    @Override
    public void drawOn(DrawSurface d) {

    }

    /**
     * Draw on the fill.
     *
     * @param d the d
     * @param x the x
     * @param y the y
     */
    public void drawOn(DrawSurface d, int x, int y) {
        if (this.color == null) {
            Image background = null;
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(this.image);
            try {
                background = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            d.drawImage(x, y, background);
        } else {
            d.setColor(this.color);
            d.fillRectangle(x, y, this.width, this.height);
        }
    }


    /**
     * Notifying that time has passed.
     */
    public void timePassed() {

    }
}
