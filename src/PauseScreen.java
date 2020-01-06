import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class Pause screen.
 *
 * @author Karin Shimel.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    // Fields for the animation
    private int time = 1;
    private int flag = 0;

    /**
     * Constructor.
     * Creates a new Pause screen.
     *
     * @param k the keyboard sensor
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * Does one frame of the animation.
     * Runs forever by using the key stop class.
     *
     * @param d the draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        this.drawOn(d);
        d.setColor(Color.lightGray);
        d.drawText(230, 400, "press space to continue", 32);
        this.drawAnimation(d);
    }

    /**
     * Drawing the animation of the pause screen.
     *
     * @param d .
     */
    private void drawAnimation(DrawSurface d) {
        Image background = null;
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(
                "animation_images/Darth.png");
        try {
            background = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int gap = 3;
        if (this.time == 0) {
            flag = 0;
            this.time = 0;
        }
        if (this.time > 230) {
            flag = 1;
            this.time = 1;
        }
        if (flag == 0) {
            d.drawImage(10 + (this.time * gap), 520, background);
            this.time = this.time + 1;
        } else {
            d.drawImage(690 - ((this.time) * gap), 520, background);
            this.time = this.time + 1;
            if (690 - ((this.time) * gap) < 12) {
                flag = 0;
                this.time = 0;
            }
        }
        int textGap = this.time * gap;
        if ((this.time > 30) && (this.time < 100)) {
            if (flag == 0) {
                d.drawText(90 + textGap, 540, "You don't know the power of the dark side", 15);
            } else {
                d.drawText(690 - textGap - 250, 540, "You don't know the power of the dark side", 15);
            }
        }
    }

    /**
     * Whether or not the animation should stop.
     *
     * @return true / false.
     */
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     * Draw on.
     * Using pixel art, I made a grid and colored in the specific locations to make
     * the drawing, the gaps are the height & width of each rectangle in the grid and so drawing
     * in a specific location was by using the specific gaps.
     *
     * @param d the d
     */
    public void drawOn(DrawSurface d) {
        Color backGround = new Color(0xFF111110, true);
        backGround.getRGB();
        d.setColor(backGround);
        d.fillRectangle(10, 10, 780, 580);
        int startX = 52;
        int startY = 45;
        int width = 25;
        int height = 20;
        int gap = 20;
        int gap1 = 25;
        // Coloring the box
        d.setColor(Color.BLACK);
        d.fillRectangle(startX + (gap1 * 1) - 1, startY + (gap * 3) - 1,
                width * 26 + 2, height * 8 + 1);
        Color box = new Color(0xFFFFF64E, true);
        box.getRGB();
        d.setColor(box);
        d.fillRectangle(startX + (gap1 * 1), startY + (gap * 3),
                width * 26, height * 8);
        // Writing paused
        Color pause = new Color(0xFF181717, true);
        pause.getRGB();
        d.setColor(pause);
        // P
        d.fillRectangle(startX + (gap1 * 2), startY + (gap * 4), width * 3, height);
        d.fillRectangle(startX + (gap1 * 2), startY + (gap * 7), width * 3, height);
        d.fillRectangle(startX + (gap1 * 2), startY + (gap * 4), width, height * 6);
        d.fillRectangle(startX + (gap1 * 4), startY + (gap * 4), width, height * 4);
        // A
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 4), width, height);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 5), width, height * 5);
        d.fillRectangle(startX + (gap1 * 8), startY + (gap * 5), width, height * 5);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 7), width, height);
        // U
        d.fillRectangle(startX + (gap1 * 10), startY + (gap * 4), width, height * 6);
        d.fillRectangle(startX + (gap1 * 12), startY + (gap * 4), width, height * 6);
        d.fillRectangle(startX + (gap1 * 10), startY + (gap * 4), width, height * 6);
        d.fillRectangle(startX + (gap1 * 11), startY + (gap * 9), width, height);
        // S
        d.fillRectangle(startX + (gap1 * 14), startY + (gap * 4), width * 3, height);
        d.fillRectangle(startX + (gap1 * 14), startY + (gap * 6), width * 3, height);
        d.fillRectangle(startX + (gap1 * 14), startY + (gap * 9), width * 3, height);
        d.fillRectangle(startX + (gap1 * 14), startY + (gap * 4), width, height * 3);
        d.fillRectangle(startX + (gap1 * 16), startY + (gap * 7), width, height * 3);
        // E
        d.fillRectangle(startX + (gap1 * 18), startY + (gap * 4), width, height * 6);
        d.fillRectangle(startX + (gap1 * 19), startY + (gap * 4), width * 2, height);
        d.fillRectangle(startX + (gap1 * 19), startY + (gap * 7), width * 2, height);
        d.fillRectangle(startX + (gap1 * 19), startY + (gap * 9), width * 2, height);
        // D
        d.fillRectangle(startX + (gap1 * 22), startY + (gap * 4), width, height * 6);
        d.fillRectangle(startX + (gap1 * 25), startY + (gap * 5), width, height * 4);
        d.fillRectangle(startX + (gap1 * 23), startY + (gap * 4), width * 2, height);
        d.fillRectangle(startX + (gap1 * 23), startY + (gap * 9), width * 2, height);
    }
}