import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class Blocks definition reader.
 *
 * @author Karin Shimel.
 */
public class BlocksDefinitionReader {

    /**
     * Creating a block factory from the file.
     *
     * @param reader the reader
     * @return the blocks from symbols factory
     */
    public BlocksFromSymbolsFactory fromReader(java.io.BufferedReader reader) {
        BlocksFromSymbolsFactory blocks = new BlocksFromSymbolsFactory();
        Map<String, Spacer> spacers = new HashMap<>();
        Map<String, BlockCreators> blockTypes = new HashMap<>();
        Map<String, String> defaultMap = new HashMap<>();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                // If the line is blank or a comment line
                if (line.equals("") || parts[0].equals("#")) {
                    continue;
                }
                // Reading the default settings, entering them to the map
                if (parts[0].equals("default")) {
                    defaultMap = new HashMap<>();
                    for (String str : parts) {
                        if (str.equals("default")) {
                            continue;
                        }
                        String[] params = str.split(":");
                        defaultMap.put(params[0], params[1]);
                    }
                }
                // Reading the block definition settings, entering them to the map
                if (parts[0].equals("bdef")) {
                    Map<String, String> bdefMap = new HashMap<>();
                    for (String str : parts) {
                        if (str.equals("bdef")) {
                            continue;
                        }
                        String[] params = str.split(":");
                        bdefMap.put(params[0], params[1]);
                    }
                    BlockCreators newType = new BlockCreators();
                    Map<String, String> fillHit = new HashMap<>();
                    // For each entry in the map we will add the relevant quality to the new level
                    for (Map.Entry<String, String> entry : defaultMap.entrySet()) {
                        if (entry.getKey().equals("height")) {
                            newType.setHeight(Integer.parseInt(entry.getValue()));
                        }
                        if (entry.getKey().equals("width")) {
                            newType.setWidth(Integer.parseInt(entry.getValue()));
                        }
                        if (entry.getKey().equals("stroke")) {
                            String[] params = entry.getValue().split("\\(");
                            String[] colorName = params[1].split("\\)");
                            newType.setStroke(getColor(colorName[0]));
                        }
                        if (entry.getKey().equals("hit_points")) {
                            newType.setHits(Integer.parseInt(entry.getValue()));
                        }
                        if (entry.getKey().equals("fill")) {
                            newType.setStringFill(entry.getValue());
                        }
                        if (entry.getKey().equals("fill-3")) {
                            fillHit.put(entry.getKey(), entry.getValue());
                        }
                        if (entry.getKey().equals("fill-2")) {
                            fillHit.put(entry.getKey(), entry.getValue());
                        }
                        if (entry.getKey().equals("fill-1")) {
                            fillHit.put(entry.getKey(), entry.getValue());
                        }
                    }
                    // For each entry in the map we will add the relevant quality to the new level
                    for (Map.Entry<String, String> entry : bdefMap.entrySet()) {
                        if (entry.getKey().equals("height")) {
                            newType.setHeight(Integer.parseInt(entry.getValue()));
                        }
                        if (entry.getKey().equals("width")) {
                            newType.setWidth(Integer.parseInt(entry.getValue()));
                        }
                        if (entry.getKey().equals("symbol")) {
                            newType.setSymbol((entry.getValue()));
                        }
                        if (entry.getKey().equals("stroke")) {
                            String[] params = entry.getValue().split("\\(");
                            String[] colorName = params[1].split("\\)");
                            newType.setStroke(getColor(colorName[0]));
                        }
                        if (entry.getKey().equals("hit_points")) {
                            newType.setHits(Integer.parseInt(entry.getValue()));
                        }
                        if (entry.getKey().equals("fill")) {
                            newType.setStringFill(entry.getValue());
                        }

                        if (entry.getKey().equals("fill-3")) {
                            fillHit.put(entry.getKey(), entry.getValue());
                        }
                        if (entry.getKey().equals("fill-2")) {
                            fillHit.put(entry.getKey(), entry.getValue());
                        }
                        if (entry.getKey().equals("fill-1")) {
                            fillHit.put(entry.getKey(), entry.getValue());
                        }
                    }
                    newType.setStringFillHit(fillHit);
                    blockTypes.put(newType.getSymbol(), newType);
                }
                // Reading the spacer definitions settings, entering them to the map
                if (parts[0].equals("sdef")) {
                    Spacer spacer = new Spacer();
                    for (String str : parts) {
                        if (str.equals("sdef")) {
                            continue;
                        }
                        String[] params = str.split(":");
                        if (params[0].equals("symbol")) {
                            spacer.setSymbol(params[1]);
                        }
                        if (params[0].equals("width")) {
                            spacer.setWidth(Integer.parseInt(params[1]));
                        }
                    }
                    spacers.put(spacer.getSymbol(), spacer);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        blocks.setBlockTypesMap(blockTypes);
        blocks.setSpacers(spacers);
        return blocks;
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