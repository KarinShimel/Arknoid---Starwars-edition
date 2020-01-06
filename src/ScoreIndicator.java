import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Class Score indicator.
 *
 * @author Karin Shimel .
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * Constructor.
     * Creates a new Score indicator.
     *
     * @param scoreListener the score listener
     */
    public ScoreIndicator(ScoreTrackingListener scoreListener) {
        this.score = scoreListener.getCurrentScore();
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public Counter getScore() {
        return score;
    }

    /**
     * Drawing the scroe to the screen.
     *
     * @param d - the relevant draw surface.
     */
    public void drawOn(DrawSurface d) {
        // Drawing the Block
        d.setColor(Color.LIGHT_GRAY);
        //d.fillRectangle(0, 0, 800, 20);
        Rectangle rect = new Rectangle(new Point(0, 0), 800, 20);
        d.setColor(Color.BLACK);
        d.drawText((int) rect.findRecMid().getX() - 40,
                (int) rect.findRecMid().getY() + 9,
                "Score: " + (this.getScore().getAmount()), 20);
    }


    /**
     * Notifying the object that time has passed.
     */
    public void timePassed() {

    }
}
