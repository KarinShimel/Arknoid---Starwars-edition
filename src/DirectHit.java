import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Direct hit.
 *
 * @author Karin Shimel.
 */
public class DirectHit implements LevelInformation {

    /**
     * Number of balls.
     *
     * @return number of balls.
     */
    public int numberOfBalls() {
        return 1;
    }


    /**
     * Creating an array of ball velocities.
     *
     * @return velocities.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(new Velocity(0, -3));
        return velocities;
    }


    /**
     * Speed of the paddle.
     *
     * @return speed
     */
    public int paddleSpeed() {
        return 20;
    }

    /**
     * Width of the paddle.
     *
     * @return speed
     */
    public int paddleWidth() {
        return 30;
    }


    /**
     * Level name.
     *
     * @return string level name.
     */
    public String levelName() {
        return "Direct Hit";
    }


    /**
     * Returning the background of the level.
     *
     * @return background.
     */
    public Sprite getBackground() {
        return new NightSky();
    }


    /**
     * Creating and returning an array of all the blocks of the level.
     *
     * @return blocks.
     */
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Rectangle(new Point(360, 270), 80, 30), 1));
        blocks.get(0).setColor(Color.LIGHT_GRAY);
        return blocks;
    }


    /**
     * Blocks left to remove from the level.
     *
     * @return amount of blocks in the level.
     */
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }

    /**
     * For cosmetic reasons to set the color of the background.
     *
     * @return background color.
     */
    public Color getBackgroundColor() {
        Color sky = new Color(0xFF09212D, true);
        sky.getRGB();
        return sky;
    }
}
