import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Wide Easy.
 *
 * @author Karin Shimel.
 */
public class WideEasy implements LevelInformation {
    /**
     * Number of balls.
     *
     * @return number of balls.
     */
    public int numberOfBalls() {
        return 10;
    }

    /**
     * Creating an array of ball velocities.
     *
     * @return velocities.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        int diffDirection = 1;
        for (int i = 0; i < numberOfBalls(); i++) {
            if (i > 4) {
                diffDirection = -1;
            }
            velocities.add(new Velocity(3 * diffDirection, 3));
        }
        return velocities;
    }

    /**
     * Speed of the paddle.
     *
     * @return speed
     */
    public int paddleSpeed() {
        return 10;
    }

    /**
     * Width of the paddle.
     *
     * @return speed
     */
    public int paddleWidth() {
        return 650;
    }

    /**
     * Level name.
     *
     * @return string level name.
     */
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * Returning the background of the level.
     *
     * @return background.
     */
    public Sprite getBackground() {
        return new Sunset();
    }

    /**
     * Creating and returning an array of all the blocks of the level.
     *
     * @return blocks.
     */
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int blocksAmount = 15;
        int width = 50;
        int height = 30;
        for (int i = 0; i < blocksAmount; i++) {
            blocks.add(new Block(new Rectangle(new Point(25 + (width * i), 200), width, height), 1));
            //blocks.get(i).setColor(Color.getHSBColor(
            //30 * (i + 1), 70 * (i + 1), 600 * (i + 1)));
            blocks.get(i).setColor(Color.LIGHT_GRAY);
        }
        return blocks;
    }

    /**
     * For cosmetic reasons to set the color of the background.
     *
     * @return background color.
     */
    public Color getBackgroundColor() {
        Color colorWater = new Color(0xFF6EA2AB, true);
        colorWater.getRGB();
        return (colorWater);
    }

    /**
     * Blocks left to remove from the level.
     *
     * @return amount of blocks in the level.
     */
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
