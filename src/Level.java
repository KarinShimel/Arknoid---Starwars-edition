import java.awt.Color;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.LineNumberReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class Level.
 * A class to create levels and setting its values after reading the
 * data from file.
 *
 * @author Karin Shimel.
 */
public class Level implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> velocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks = new ArrayList<>();
    private File blockInformation;
    private int blocksX;
    private int blocksY;
    private int rowHeight;
    private String[] blocksBuild;
    private int numBlocks;
    private Color backgroundColor;
    private BlocksFromSymbolsFactory factory;

    /**
     * Sets number of balls.
     */
    public void setNumberOfBalls() {
        this.numberOfBalls = this.velocities.size();
    }

    /**
     * Sets row height.
     *
     * @param rowHeight1 the row height
     */
    public void setRowHeight(int rowHeight1) {
        this.rowHeight = rowHeight1;
    }

    /**
     * Sets blocks x.
     *
     * @param blocksX1 the blocks x
     */
    public void setBlocksX(int blocksX1) {
        this.blocksX = blocksX1;
    }

    /**
     * Sets blocks y.
     *
     * @param blocksY1 the blocks y
     */
    public void setBlocksY(int blocksY1) {
        this.blocksY = blocksY1;
    }

    /**
     * Sets block information.
     *
     * @param blockInformation1 the block information
     */
    public void setBlockInformation(String blockInformation1) {
        BufferedReader reader;
        BlocksFromSymbolsFactory blocks1 = new BlocksFromSymbolsFactory();
        InputStream is;
        is = ClassLoader.getSystemClassLoader().getResourceAsStream((blockInformation1));
        reader = new LineNumberReader(new BufferedReader(new InputStreamReader(is)));
        BlocksDefinitionReader reader1 = new BlocksDefinitionReader();
        blocks1 = reader1.fromReader(reader);
        this.factory = blocks1;
    }

    /**
     * Sets velocities.
     *
     * @param velocities1 the velocities
     */
    public void setVelocities(List<Velocity> velocities1) {
        this.velocities = velocities1;
        setNumberOfBalls();
    }

    /**
     * Sets background color.
     *
     * @param backgroundColor1 the background color
     */
    public void setBackgroundColor(Color backgroundColor1) {
        backgroundColor = backgroundColor1;
    }

    /**
     * Sets background.
     *
     * @param background1 the background
     */
    public void setBackground(Sprite background1) {
        this.background = background1;
    }

    /**
     * Sets blocks build.
     *
     * @param blocksBuild1 the blocks build
     */
    public void setBlocksBuild(String[] blocksBuild1) {
        List<Block> blocks1 = new ArrayList<>();
        int y;
        // For each irrelevant line, we wish to reduce from the distance of the block creation
        int decrease = 0;
        for (int j = 0; j < 20; j++) {
            String s = blocksBuild1[j];
            if (s == null || s.equals("")) {
                decrease++;
                continue;
            }
            int x = this.blocksX;
            y = this.blocksY + (this.rowHeight * (j - decrease));
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                for (Map.Entry<String, BlockCreators> entry : this.factory.getBlockTypesMap().entrySet()) {
                    if (entry.getKey().equals(String.valueOf(c))) {
                        blocks1.add(this.factory.getBlock((String.valueOf(c)), x, y));
                        x = x + entry.getValue().getWidth();
                    }
                }
                for (Map.Entry<String, Spacer> entry : this.factory.getSpacers().entrySet()) {
                    if (entry.getKey().equals(String.valueOf(c))) {
                        x = x + entry.getValue().getWidth();
                    }
                }
            }
        }
        this.blocks = blocks1;
    }

    /**
     * Sets level name.
     *
     * @param levelName1 the level name
     */
    public void setLevelName(String levelName1) {
        this.levelName = levelName1;
    }

    /**
     * Sets num blocks.
     *
     * @param numBlocks1 the num blocks
     */
    public void setNumBlocks(int numBlocks1) {
        this.numBlocks = numBlocks1;
    }

    /**
     * Sets paddle width.
     *
     * @param paddleWidth1 the paddle width
     */
    public void setPaddleWidth(int paddleWidth1) {
        this.paddleWidth = paddleWidth1;
    }

    /**
     * Sets paddle speed.
     *
     * @param paddleSpeed1 the paddle speed
     */
    public void setPaddleSpeed(int paddleSpeed1) {
        this.paddleSpeed = paddleSpeed1;
    }

    @Override
    public int numberOfBalls() {
        return this.velocities.size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return this.velocities;
    }

    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }

    @Override
    public String levelName() {
        return this.levelName;
    }

    @Override
    public Sprite getBackground() {
        return this.background;
    }

    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    @Override
    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.numBlocks;
    }
}
