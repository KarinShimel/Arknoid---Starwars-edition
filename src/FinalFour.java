
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Final Four.
 *
 * @author Karin Shimel.
 */
public class FinalFour implements LevelInformation {
    /**
     * Number of balls.
     *
     * @return number of balls.
     */
    public int numberOfBalls() {
        return 3;
    }

    /**
     * Creating an array of ball velocities.
     *
     * @return velocities.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(new Velocity(3, 3));
        velocities.add(new Velocity(0, 4));
        velocities.add(new Velocity(-3, 3));
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
        return 150;
    }

    /**
     * Level name.
     *
     * @return string level name.
     */
    public String levelName() {
        return "Final Four";
    }

    /**
     * Returning the background of the level.
     *
     * @return background.
     */
    public Sprite getBackground() {
        return new Unicorn();
    }

    /**
     * Creating and returning an array of all the blocks of the level.
     *
     * @return blocks.
     */
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int x = 25;
        int y = 100;
        int width = 50;
        int height = 30;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 6; j++) {
                Block block = new Block(
                        new Rectangle(new Point(x + (i * width), y + (j * height)), width, height), 1);
                blocks.add(block);
                block.setColor(Color.getHSBColor(
                        60 * (j + 1), 180 * (j + 1), 600 * (j + 1)));
            }
        }
        return blocks;
    }

    /**
     * For cosmetic reasons to set the color of the background.
     *
     * @return background color.
     */
    public Color getBackgroundColor() {
        return Color.lightGray;
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
