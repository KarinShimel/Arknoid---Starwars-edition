import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Class Lives indicator.
 *
 * @author Karin Shimel .
 */
public class LivesIndicator implements Sprite {
    private Counter counter;

    /**
     * Constructor (1).
     * Creates a new Lives indicator.
     *
     * @param counter1 the counter 1
     */
    public LivesIndicator(Counter counter1) {
        this.counter = counter1;
    }

    /**
     * Constructor (2).
     * Creates a new Lives indicator.
     *
     * @param lives the lives
     */
    public LivesIndicator(int lives) {
        this.counter = new Counter(lives);
    }

    /**
     * Gets counter.
     *
     * @return the counter
     */
    public Counter getCounter() {
        return counter;
    }

    /**
     * Drawing the amount of lives left to the screen.
     *
     * @param d - the relevant draw surface.
     */
    public void drawOn(DrawSurface d) {
        Color red = new Color(0xFFB8435B, true);
        red.getRGB();
        d.setColor(red);
        d.fillRectangle(0, 0, 130, 20);
        d.setColor(Color.WHITE);
        d.drawText(30, 15,
                "Lives: " + (this.getCounter().getAmount()), 20);
    }

    /**
     * Notifying that time has passed.
     */
    public void timePassed() {

    }
}
