import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class End screen.
 *
 * @author Karin Shimel.
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private ScoreTrackingListener score;
    private LivesIndicator livesIndicator;

    /**
     * Constructor.
     * Creates a new End screen.
     *
     * @param k               the k
     * @param score1          the score 1
     * @param livesIndicator1 the lives indicator 1
     */
    public EndScreen(KeyboardSensor k, ScoreTrackingListener score1, LivesIndicator livesIndicator1) {
        this.keyboard = k;
        this.stop = false;
        this.score = score1;
        this.livesIndicator = livesIndicator1;
    }

    /**
     * Doing one frame of the animation.
     *
     * @param d the draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        // If the player has no more lives, creating the game over screen
        if (this.livesIndicator.getCounter().getAmount() == 0) {
            this.drawLose(d);
            d.setColor(Color.WHITE);
            d.drawText(305, 460, "Your Score: " + this.score.getCurrentScore().getAmount(), 28);
            d.drawText(300, 490, "press space to continue", 20);
            if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
                this.stop = true;
            }
        } else {
            // If the player won, creating the winner screen
            Image background = null;
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(
                    "background_images/Victory.jpg");
            try {
                background = ImageIO.read(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            d.drawImage(0, 0, background);
            d.setColor(Color.white);
            d.drawText(130, 100, "Winner !", 45);
            d.drawText(105, 145, "Your Score: " + this.score.getCurrentScore().getAmount(), 30);
            d.drawText(115, 175, "press space to continue", 20);
            if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
                this.stop = true;
            }
        }
    }


    /**
     * Checking if the animation should stop.
     *
     * @return true / false.
     */
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     * Draw lose.
     * Using pixel art, I made a grid and colored in the specific locations to make
     * the drawing, the gaps are the height & width of each rectangle in the grid and so drawing
     * in a specific location was by using the specific gaps.
     *
     * @param d the d
     */
    public void drawLose(DrawSurface d) {
        int startX = 35;
        int startY = 45;
        int width = 25;
        int height = 20;
        int gap1 = 25;
        int gap = 20;
        Color back = new Color(0xFF151E2B, true);
        back.getRGB();
        d.setColor(back);
        d.fillRectangle(0, 0, 800, 600);
        Color rect = new Color(0xFFF4F1FC, true);
        rect.getRGB();
        d.setColor(rect);
        d.fillRectangle(startX + (gap1 * 4), startY, width * 21, height * 16);
        Color text = new Color(0xFF395D54, true);
        text.getRGB();
        d.setColor(text);
        // G
        d.fillRectangle(startX + (gap1 * 5), startY + (gap * 2), width, height * 4);
        d.fillRectangle(startX + (gap1 * 8), startY + (gap * 3), width, height * 4);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap), width * 3, height);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 6), width * 3, height);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 3), width, height);
        // A
        d.fillRectangle(startX + (gap1 * 10), startY + (gap * 2), width, height * 5);
        d.fillRectangle(startX + (gap1 * 13), startY + (gap * 2), width, height * 5);
        d.fillRectangle(startX + (gap1 * 11), startY + (gap), width * 2, height);
        d.fillRectangle(startX + (gap1 * 11), startY + (gap * 4), width * 2, height);
        // M
        d.fillRectangle(startX + (gap1 * 15), startY + (gap), width, height * 6);
        d.fillRectangle(startX + (gap1 * 19), startY + (gap), width, height * 6);
        d.fillRectangle(startX + (gap1 * 16), startY + (gap * 2), width, height);
        d.fillRectangle(startX + (gap1 * 18), startY + (gap * 2), width, height);
        d.fillRectangle(startX + (gap1 * 17), startY + (gap * 3), width, height);
        // E
        d.fillRectangle(startX + (gap1 * 21), startY + (gap), width, height * 6);
        d.fillRectangle(startX + (gap1 * 22), startY + (gap), width * 2, height);
        d.fillRectangle(startX + (gap1 * 22), startY + (gap * 3), width * 2, height);
        d.fillRectangle(startX + (gap1 * 22), startY + (gap * 6), width * 2, height);
        // O
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 9), width * 2, height);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 14), width * 2, height);
        d.fillRectangle(startX + (gap1 * 5), startY + (gap * 10), width, height * 4);
        d.fillRectangle(startX + (gap1 * 8), startY + (gap * 10), width, height * 4);
        // V
        d.fillRectangle(startX + (gap1 * 10), startY + (gap * 9), width, height * 4);
        d.fillRectangle(startX + (gap1 * 14), startY + (gap * 9), width, height * 4);
        d.fillRectangle(startX + (gap1 * 11), startY + (gap * 13), width, height);
        d.fillRectangle(startX + (gap1 * 12), startY + (gap * 14), width, height);
        d.fillRectangle(startX + (gap1 * 13), startY + (gap * 13), width, height);
        // E
        d.fillRectangle(startX + (gap1 * 16), startY + (gap * 9), width, height * 6);
        d.fillRectangle(startX + (gap1 * 17), startY + (gap * 9), width * 2, height);
        d.fillRectangle(startX + (gap1 * 17), startY + (gap * 11), width * 2, height);
        d.fillRectangle(startX + (gap1 * 17), startY + (gap * 14), width * 2, height);
        // R
        d.fillRectangle(startX + (gap1 * 20), startY + (gap * 9), width, height * 6);
        d.fillRectangle(startX + (gap1 * 23), startY + (gap * 9), width, height * 3);
        d.fillRectangle(startX + (gap1 * 23), startY + (gap * 13), width, height * 2);
        d.fillRectangle(startX + (gap1 * 21), startY + (gap * 9), width * 2, height);
        d.fillRectangle(startX + (gap1 * 21), startY + (gap * 12), width * 2, height);
    }
}
