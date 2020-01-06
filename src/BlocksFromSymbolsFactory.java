import java.util.HashMap;
import java.util.Map;

/**
 * The type Blocks from symbols factory.
 */
public class BlocksFromSymbolsFactory {
    private Map<String, BlockCreators> blockTypesMap = new HashMap<>();
    private Map<String, Spacer> spacers = new HashMap<>();

    /**
     * Sets block types map.
     *
     * @param blockTypesMap1 the block types map
     */
    public void setBlockTypesMap(Map<String, BlockCreators> blockTypesMap1) {
        this.blockTypesMap = blockTypesMap1;
    }

    /**
     * Gets block types map.
     *
     * @return the block types map
     */
    public Map<String, BlockCreators> getBlockTypesMap() {
        return blockTypesMap;
    }

    /**
     * Gets spacers.
     *
     * @return the spacers
     */
    public Map<String, Spacer> getSpacers() {
        return spacers;
    }

    /**
     * Sets spacers.
     *
     * @param spacers1 the spacers
     */
    public void setSpacers(Map<String, Spacer> spacers1) {
        this.spacers = spacers1;
    }

    /**
     * Returns true if 's' is a valid space symbol.
     *
     * @param s the s
     * @return the boolean
     */
    public boolean isSpaceSymbol(String s) {
        if (this.spacers.containsKey(s)) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if 's' is a valid block symbol.
     *
     * @param s the s
     * @return the boolean
     */
    public boolean isBlockSymbol(String s) {
        if (this.blockTypesMap.containsKey(s)) {
            return true;
        }
        return false;
    }

    /**
     * Gets the block by getting the relevant block type from the map of symbols.
     * Creating the block in the chosen x,y location.
     *
     * @param s    the s
     * @param xpos the xpos
     * @param ypos the ypos
     * @return the block
     */
    public Block getBlock(String s, int xpos, int ypos) {
        return this.blockTypesMap.get(s).create(xpos, ypos);
    }

    /**
     * Get the space width int.
     *
     * @param s the s
     * @return the int
     */
    public int getSpaceWidth(String s) {
        return this.spacers.get(s).getWidth();
    }
}