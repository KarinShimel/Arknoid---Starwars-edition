import biuoop.DrawSurface;

/**
 * interface Sprite.
 *
 * @author Karin Shimel.
 */
public interface Sprite {
    /**
     * Drawing the sprite on to the screen.
     *
     * @param d - the relevant draw surface.
     */
    void drawOn(DrawSurface d);

    /**
     * Notifying the sprite that the time has passed, each sprite will
     * behave differently.
     */
    void timePassed();
}