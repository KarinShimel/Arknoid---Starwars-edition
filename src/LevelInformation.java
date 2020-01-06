import java.awt.Color;
import java.util.List;

/**
 * Interface Level information.
 *
 * @author Karin Shimel.
 */
public interface LevelInformation {
    /**
     * Number of balls in the level.
     *
     * @return the int
     */
    int numberOfBalls();

    /**
     * Initial ball velocities list, initialize velocity of each ball.
     *
     * @return the list
     */
    List<Velocity> initialBallVelocities();

    /**
     * Paddle speed .
     *
     * @return the speed
     */
    int paddleSpeed();

    /**
     * Paddle width .
     *
     * @return the width
     */
    int paddleWidth();

    /**
     * Level name .
     *
     * @return the name
     */
    String levelName();

    /**
     * Gets background.
     *
     * @return the background
     */
    Sprite getBackground();

    /**
     * Creating and returning the blocks of the level.
     *
     * @return the list
     */
    List<Block> blocks();

    /**
     * Gets background color.
     *
     * @return the background color
     */
    Color getBackgroundColor();

    /**
     * Number of blocks left to remove.
     *
     * @return the int
     */
    int numberOfBlocksToRemove();
}