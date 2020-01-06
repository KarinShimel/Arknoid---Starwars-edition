import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;
import java.util.List;

/**
 * Class Level specification reader.
 *
 * @author Karin Shimel.
 */
public class LevelSpecificationReader {

    /**
     * Creating a levels list from the file.
     *
     * @param reader the reader
     * @return the list
     */
    public List<LevelInformation> fromReader(java.io.BufferedReader reader) {
        String line;
        List<LevelInformation> levels = new ArrayList<>();
        Level newLevel = null;
        try {
            while ((line = reader.readLine()) != null) {
                // Creating each level
                if (line.equals("START_LEVEL")) {
                    newLevel = new Level();
                }
                if (line.equals("END_LEVEL")) {
                    levels.add(newLevel);
                }
                String[] parts = line.split(":");
                if (parts[0].equals("level_name")) {
                    newLevel.setLevelName(parts[1]);
                }
                if (parts[0].equals("ball_velocities")) {
                    List<Velocity> velocities = new ArrayList<>();
                    // angle / speed
                    String[] balls = parts[1].split(" ");
                    for (String ball : balls) {
                        String[] params = ball.split(",");
                        velocities.add(new Velocity(1, 1).fromAngleAndSpeed(
                                Double.parseDouble(params[0]),
                                Double.parseDouble(params[1]) / 100));
                    }
                    newLevel.setVelocities(velocities);
                }
                if (parts[0].equals("background")) {
                    String[] backG = parts[1].split("\\(");
                    if (backG[0].equals("image")) {
                        String[] data = backG[1].split("\\)");
                        newLevel.setBackground(new Background((data[0]),
                                newLevel.levelName()));
                    } else {
                        if (backG[1].equals("RGB")) {
                            String[] data = backG[2].split("\\)");
                            String[] numbers = data[0].split(",");
                            newLevel.setBackground(new Background(new Color(Integer.parseInt(numbers[0]),
                                    Integer.parseInt(numbers[1]),
                                    Integer.parseInt(numbers[2])), newLevel.levelName()));
                        } else {
                            String[] data = backG[1].split("\\)");
                            newLevel.setBackground(new Background(getColor(data[0]),
                                    newLevel.levelName()));
                        }
                    }
                }
                if (parts[0].equals("paddle_speed")) {
                    newLevel.setPaddleSpeed(Integer.parseInt(parts[1]));
                }
                if (parts[0].equals("paddle_width")) {
                    newLevel.setPaddleWidth(Integer.parseInt(parts[1]));
                }
                if (parts[0].equals("block_definitions")) {
                    newLevel.setBlockInformation((parts[1]));
                }
                if (parts[0].equals("blocks_start_x")) {
                    newLevel.setBlocksX(Integer.parseInt(parts[1]));
                }
                if (parts[0].equals("blocks_start_y")) {
                    newLevel.setBlocksY(Integer.parseInt(parts[1]));
                }
                if (parts[0].equals("row_height")) {
                    newLevel.setRowHeight(Integer.parseInt(parts[1]));
                }
                if (parts[0].equals("num_blocks")) {
                    newLevel.setNumBlocks(Integer.parseInt(parts[1]));
                }
                if (parts[0].equals("START_BLOCKS")) {
                    String[] build = new String[20];
                    line = reader.readLine();
                    int i = 0;
                    // Reading the blocks creation pattern and sending them to a relevant method
                    while (!line.equals("END_BLOCKS")) {
                        build[i] = line;
                        line = reader.readLine();
                        i++;
                    }
                    newLevel.setBlocksBuild(build);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return levels;

    }

    /**
     * Gets color.
     *
     * @param col the col
     * @return the color
     */
    public Color getColor(String col) {
        Color color = null;
        switch (col.toLowerCase()) {
            case "black":
                color = Color.BLACK;
                break;
            case "blue":
                color = Color.BLUE;
                break;
            case "cyan":
                color = Color.CYAN;
                break;
            case "darkgray":
                color = Color.DARK_GRAY;
                break;
            case "gray":
                color = Color.GRAY;
                break;
            case "green":
                color = Color.GREEN;
                break;

            case "yellow":
                color = Color.YELLOW;
                break;
            case "lightgray":
                color = Color.LIGHT_GRAY;
                break;
            case "magneta":
                color = Color.MAGENTA;
                break;
            case "orange":
                color = Color.ORANGE;
                break;
            case "pink":
                color = Color.PINK;
                break;
            case "red":
                color = Color.RED;
                break;
            case "white":
                color = Color.WHITE;
                break;
            default:
                break;
        }
        return color;
    }

}