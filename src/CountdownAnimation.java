import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * Class Countdown animation.
 *
 * @author Karin Shimel.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private double appearanceTime;
    private Sleeper sleeper;

    /**
     * Constructor.
     * Creates a new Countdown animation.
     *
     * @param numOfSeconds1 the num of seconds 1
     * @param countFrom1    the count from 1
     * @param gameScreen1   the game screen 1
     */
    public CountdownAnimation(double numOfSeconds1, int countFrom1,
                              SpriteCollection gameScreen1) {
        this.numOfSeconds = numOfSeconds1;
        this.countFrom = countFrom1;
        this.gameScreen = gameScreen1;
        this.sleeper = new Sleeper();
        this.appearanceTime = (this.numOfSeconds / this.countFrom);
    }

    /**
     * Does one frame of the animation.
     *
     * @param d the draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.BLACK);
        d.fillCircle(400, 270, 52);
        d.setColor(Color.WHITE);
        d.fillCircle(400, 270, 50);
        d.setColor(Color.BLACK);
        // Drawing the number to the screen
        if (this.countFrom != 0) {
            d.setColor(Color.LIGHT_GRAY);
            d.setColor(Color.BLACK);
            d.drawText(378, d.getHeight() / 2, Integer.toString(countFrom), 80);
        }
        // Using the sleeper if its not the first number displayed
        if (appearanceTime != this.numOfSeconds / this.countFrom) {
            this.sleeper.sleepFor(((long) appearanceTime / 1000 + 760));
        }
        this.countFrom--;
    }

    /**
     * Gets the appearance time.
     *
     * @return appearance time.
     */
    public double getAppearanceTime() {
        return appearanceTime;
    }

    /**
     * Gets game screen.
     *
     * @return the game screen
     */
    public SpriteCollection getGameScreen() {
        return gameScreen;
    }

    /**
     * Gets num of seconds.
     *
     * @return the num of seconds
     */
    public double getNumOfSeconds() {
        return numOfSeconds;
    }

    /**
     * Sets count from.
     *
     * @param countFrom1 the count from
     */
    public void setCountFrom(int countFrom1) {
        this.countFrom = countFrom1;
    }

    /**
     * Gets count from.
     *
     * @return the count from
     */
    public int getCountFrom() {
        return countFrom;
    }

    /**
     * Gets sleeper.
     *
     * @return the sleeper
     */
    public Sleeper getSleeper() {
        return sleeper;
    }

    /**
     * Checking when the animation should stop.
     *
     * @return true / false.
     */
    public boolean shouldStop() {
        if (this.countFrom < 0) {
            return true;
        }
        return false;
    }
}