/**
 * Interface Block Creator.
 *
 * @author Karin Shimel.
 */
public interface BlockCreator {
    /**
     * Creating a block in a specific location.
     *
     * @param xpos .
     * @param ypos .
     * @return Block type.
     */
    Block create(int xpos, int ypos);
}