import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Green 3.
 *
 * @author Karin Shimel.
 */
public class Green3 implements LevelInformation {
    /**
     * Number of balls.
     *
     * @return number of balls.
     */
    public int numberOfBalls() {
        return 2;
    }

    /**
     * Creating an array of ball velocities.
     *
     * @return velocities.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(new Velocity(3, 3));
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
        return 100;
    }

    /**
     * Level name.
     *
     * @return string level name.
     */
    public String levelName() {
        return "Green 3";
    }

    /**
     * Returning the background of the level.
     *
     * @return background.
     */
    public Sprite getBackground() {
        return new Green();
    }

    /**
     * Creating and returning an array of all the blocks of the level.
     *
     * @return blocks.
     */
    public List<Block> blocks() {
        // Setting the list
        List<Block> blocks = new ArrayList<>();
        // Setting the variables for the block initialize loop
        double startingX = 775;
        double startingY = 145;
        double width = 60;
        double height = 30;
        int hitTop = 1;
        int hit = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10 - i; j++) {
                Block block;
                double x;
                double y;
                if (i == 0) {
                    if (j == 0) {
                        x = startingX - width;
                        y = startingY;
                        continue;
                    } else {
                        x = startingX - (width * j);
                        y = startingY;
                    }
                    block = new Block(new Rectangle(new Point(x, y), width,
                            height), hitTop);
                    //block.setColor(Color.GRAY);
                    Color white = new Color(0xFFC8DFCD, true);
                    white.getRGB();
                    block.setColor(white);
                } else {
                    if (j == 0) {
                        x = startingX - width;
                        y = startingY + (i * height);
                        continue;
                    } else {
                        x = startingX - (width * j);
                        y = startingY + (i * height);
                        block = new Block(new Rectangle(
                                new Point(x, y), width, height), hit);
                    }
                    if (i % 2 == 1) {
                        Color green2 = new Color(0xFFA5DF81, true);
                        green2.getRGB();
                        block.setColor(green2);
                    } else {
                        Color white = new Color(0xFFC8DFCD, true);
                        white.getRGB();
                        block.setColor(white);
                    }
//                    block.setColor(Color.getHSBColor(
//                            5 * (i + 1), 500 * (i + 1), 300 * (i + 1)));
                }
                // Adding the block to the game
                blocks.add(block);
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
        Color grass = new Color(0xFFB3D0BC, true);
        grass.getRGB();
        return (grass);
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
