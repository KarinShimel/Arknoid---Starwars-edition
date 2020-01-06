import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 * Class Block creators.
 *
 * @author Karin Shimel.
 */
public class BlockCreators implements BlockCreator {
    private String symbol;
    private int height;
    private int width;
    private Color stroke;
    private int hits;
    private Fill fill;
    private Map<String, Fill> fillHit = new HashMap<>();


    /**
     * Gets symbol.
     *
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Gets fill.
     *
     * @return the fill
     */
    public Fill getFill() {
        return fill;
    }

    /**
     * Sets a fill hit - a fill for a different hit amount, by reading a string.
     *
     * @param fillHit1 the fill hit
     */
    public void setStringFillHit(Map<String, String> fillHit1) {
        for (Map.Entry<String, String> entry : fillHit1.entrySet()) {
            Fill fillData = new Fill();
            String[] backG = entry.getValue().split("\\(");
            if (backG[0].equals("image")) {
                String[] data = backG[1].split("\\)");
                fillData.setImage(((data[0])));
            } else {
                if (backG[1].equals("RGB")) {
                    String[] data = backG[2].split("\\)");
                    String[] numbers = data[0].split(",");
                    fillData.setColor((new Color(Integer.parseInt(numbers[0]),
                            Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]))));
                } else {
                    String[] data = backG[1].split("\\)");
                    fillData.setColor((getColor(data[0])));
                }
            }
            if (entry.getKey().equals("fill-1")) {
                this.fillHit.put(entry.getKey(), fillData);
            }
            if (entry.getKey().equals("fill-2")) {
                this.fillHit.put(entry.getKey(), fillData);
            }
            if (entry.getKey().equals("fill-3")) {
                this.fillHit.put(entry.getKey(), fillData);
            }
        }
    }

    /**
     * Sets fill.
     *
     * @param fill1 the fill
     */
    public void setFill(Fill fill1) {
        this.fill = fill1;
    }

    /**
     * Sets the fill from a string.
     *
     * @param str the str
     */
    public void setStringFill(String str) {
        Fill fillData = new Fill();
        String[] backG = str.split("\\(");
        // If it is an image
        if (backG[0].equals("image")) {
            String[] data = backG[1].split("\\)");
            fillData.setImage(((data[0])));
        } else {
            if (backG[1].equals("RGB")) {
                String[] data = backG[2].split("\\)");
                String[] numbers = data[0].split(",");
                fillData.setColor((new Color(Integer.parseInt(numbers[0]),
                        Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]))));
            } else {
                String[] data = backG[1].split("\\)");
                fillData.setColor((getColor(data[0])));
            }
        }
        this.setFill(fillData);
    }

    /**
     * Gets fill hit.
     *
     * @return the fill hit
     */
    public Map<String, Fill> getFillHit() {
        return fillHit;
    }

    /**
     * Gets stroke.
     *
     * @return the stroke
     */
    public Color getStroke() {
        return stroke;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets hits.
     *
     * @return the hits
     */
    public int getHits() {
        return hits;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets height.
     *
     * @param height1 the height
     */
    public void setHeight(int height1) {
        this.height = height1;
    }

    /**
     * Sets hits.
     *
     * @param hits1 the hits
     */
    public void setHits(int hits1) {
        this.hits = hits1;
    }

    /**
     * Sets stroke.
     *
     * @param stroke1 the stroke
     */
    public void setStroke(Color stroke1) {
        this.stroke = stroke1;
    }

    /**
     * Sets symbol.
     *
     * @param symbol1 the symbol
     */
    public void setSymbol(String symbol1) {
        this.symbol = symbol1;
    }

    /**
     * Sets width.
     *
     * @param width1 the width
     */
    public void setWidth(int width1) {
        this.width = width1;
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

    /**
     * Creates the block from the block specs we have, at the x,y given.
     *
     * @param xpos .
     * @param ypos .
     * @return a Blcok.
     */
    public Block create(int xpos, int ypos) {
        Block block = new Block(new Rectangle(new Point(xpos, ypos),
                this.getWidth(), this.getHeight()), this.getHits());
        block.setStroke(this.getStroke());
        block.setFillHits(this.getFillHit());
        block.setFill(this.getFill());
        return block;
    }
}
