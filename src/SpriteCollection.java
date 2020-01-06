import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * class SpriteCollection.
 *
 * @author Karin Shimel.
 */
public class SpriteCollection {
    private java.util.List<Sprite> sprites;

    /**
     * Constructor.
     * Setting the array list of the sprites.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * Getting the array list of the sprites.
     *
     * @return this.sprites - the sprite collection.
     */
    public List<Sprite> getSprites() {
        return this.sprites;
    }

    /**
     * Setting the sprites.
     *
     * @param sprites1 .
     */
    public void setSprites(List<Sprite> sprites1) {
        this.sprites = sprites1;
    }

    /**
     * Adding the sprite to the sprite collection.
     *
     * @param s - a sprite object.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * Notifying all the sprites in the collection that the time has passed.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.sprites.size(); i++) {
            this.sprites.get(i).timePassed();
        }
    }

    /**
     * Notifying all the sprites in the collection that the time has passed.
     *
     * @param d -
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.sprites.size(); i++) {
            this.sprites.get(i).drawOn(d);
        }
    }
}