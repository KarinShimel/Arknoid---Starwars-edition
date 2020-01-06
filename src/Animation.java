import biuoop.DrawSurface;

/**
 * Interface Animation.
 *
 * @author Karin Shimel.
 */
public interface Animation {
    /**
     * Doing one frame of the animation.
     *
     * @param d the draw surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * Boolean indicating if the animation should stop .
     *
     * @return the boolean
     */
    boolean shouldStop();
}