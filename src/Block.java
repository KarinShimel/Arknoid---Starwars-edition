import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * class Block.
 *
 * @author Karin Shimel .
 */
public class Block implements Collidable, Sprite, HitNotifier {
    // Block shape
    private Rectangle block;
    private java.awt.Color color;
    private Color stroke;
    private Fill fill;
    private Map<String, Fill> fillHits;
    private int hit;
    private List<HitListener> hitListeners;
    private boolean isBorder;

    /**
     * Constructor.
     * Setting the block using the given rectangle and the number of
     * this the block has.
     *
     * @param rect - x value of the center point
     * @param hits - number of hits the block has left.
     */
    public Block(Rectangle rect, int hits) {
        this.block = rect;
        this.hit = hits;
        this.hitListeners = new ArrayList<HitListener>();
        this.isBorder = false;
    }

    /**
     * Returning the color of the block.
     *
     * @return color. color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Gets hit.
     *
     * @return the hit
     */
    public int getHit() {
        return hit;
    }

    /**
     * Setting the fill.
     *
     * @param fill1 .
     */
    public void setFill(Fill fill1) {
        this.fill = fill1;
    }

    /**
     * Setting the stroke.
     *
     * @param stroke1 .
     */
    public void setStroke(Color stroke1) {
        this.stroke = stroke1;
    }

    /**
     * Setting the fill-k fills.
     *
     * @param fillHits1 .
     */
    public void setFillHits(Map<String, Fill> fillHits1) {
        this.fillHits = fillHits1;
    }

    /**
     * Sets the block as a border block.
     *
     * @param border the border
     */
    public void setBorder(boolean border) {
        isBorder = border;
    }

    /**
     * Checking if the block is a border block.
     *
     * @return the boolean
     */
    public boolean isBorder() {
        return isBorder;
    }

    /**
     * Drawing the block onto the screen.
     *
     * @param d - the relevant draw surface.
     */
    public void drawOn(DrawSurface d) {
        // Drawing the fill
        if (this.fillHits != null) {
            if ((this.hit == 1) && (this.fillHits.containsKey("fill-1"))) {
                this.fillHits.get("fill-1").setHeight((int) (this.block.getHeight()));
                this.fillHits.get("fill-1").setWidth((int) (this.block.getWidth()));
                this.fillHits.get("fill-1").drawOn(d,
                        (int) (this.block.getUpperLeft().getX()), (int) (this.block.getUpperLeft().getY()));
            } else if ((this.hit == 2) && (this.fillHits.containsKey("fill-2"))) {
                this.fillHits.get("fill-2").setHeight((int) (this.block.getHeight()));
                this.fillHits.get("fill-2").setWidth((int) (this.block.getWidth()));
                this.fillHits.get("fill-2").drawOn(d,
                        (int) (this.block.getUpperLeft().getX()), (int) (this.block.getUpperLeft().getY()));
            } else if ((this.hit == 3) && (this.fillHits.containsKey("fill-3"))) {
                this.fillHits.get("fill-3").setHeight((int) (this.block.getHeight()));
                this.fillHits.get("fill-3").setWidth((int) (this.block.getWidth()));
                this.fillHits.get("fill-3").drawOn(d,
                        (int) (this.block.getUpperLeft().getX()), (int) (this.block.getUpperLeft().getY()));
            } else {
                this.fill.setHeight((int) (this.block.getHeight()));
                this.fill.setWidth((int) (this.block.getWidth()));
                this.fill.drawOn(d, (int) (this.block.getUpperLeft().getX()), (int) (this.block.getUpperLeft().getY()));
            }
        } else {
            this.fill.setHeight((int) (this.block.getHeight()));
            this.fill.setWidth((int) (this.block.getWidth()));
            this.fill.drawOn(d, (int) (this.block.getUpperLeft().getX()), (int) (this.block.getUpperLeft().getY()));
        }
        // Drawing the outlines of the block, not drawing outlines for border blocks
        if (!this.isBorder() && this.stroke != null) {
            d.setColor(this.stroke);
            this.getCollisionRectangle().getUp().drawLine(this.getCollisionRectangle().getUp(), d);
            this.getCollisionRectangle().getDown().drawLine(this.getCollisionRectangle().getDown(), d);
            this.getCollisionRectangle().getLeft().drawLine(this.getCollisionRectangle().getLeft(), d);
            this.getCollisionRectangle().getRight().drawLine(this.getCollisionRectangle().getRight(), d);
        }
    }

    /**
     * Setting the color of the block.
     *
     * @param color1 - the new color.
     */
    public void setColor(Color color1) {
        this.color = color1;
    }

    /**
     * Adding the block to the game, by adding it to the sprite collection
     * and the game environment.
     *
     * @param g - the game.
     */
    public void addToGame(GameLevel g) {
        g.getSprites().addSprite(this);
        g.getEnvironment().addCollidable(this);
    }

    /**
     * Required by the collidable interface, getting the collision's rectangle.
     *
     * @return this.block - collision rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.block;
    }

    /**
     * Remove the block from game.
     *
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * Gets hit points.
     *
     * @return the hit points
     */
    public int getHitPoints() {
        return this.getHit();
    }

    /**
     * Calculates the new velocity after the collision, and notifying the block
     * there was a hit, reducing the remaining hits.
     *
     * @param hitter          - the ball hitting the block.
     * @param currentVelocity - the current velocity.
     * @param collisionPoint  - the collision point.
     * @return newVelocity - the new velocity after the collision.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // Notifying the block it was hit

        this.notifyHit(hitter);
        if (this.hit > 0) {
            this.hit = (this.hit - 1);
        }
        // Setting the new velocity as the current velocity
        Velocity newVelocity = currentVelocity;
        // Checking if the collision is at the top/bottom lines of the block
        if (this.getCollisionRectangle().getUp().inLine(
                this.getCollisionRectangle().getUp(), collisionPoint)
                || this.getCollisionRectangle().getDown().inLine(
                this.getCollisionRectangle().getDown(), collisionPoint)) {
            newVelocity.setDy((-1) * newVelocity.getDy());
        }
        // Checking if the collision is at the left/right lines of the rectangle
        if (this.getCollisionRectangle().getLeft().inLine(
                this.getCollisionRectangle().getLeft(), collisionPoint)
                || this.getCollisionRectangle().getRight().inLine(
                this.getCollisionRectangle().getRight(), collisionPoint)) {
            newVelocity.setDx((-1) * (newVelocity.getDx()));
        }
        return newVelocity;
    }

    /**
     * Required by the sprite interface, what the block does when
     * the time has passed.
     */
    public void timePassed() {
    }

    /**
     * Gets the hit listeners.
     *
     * @return the hit listeners
     */
    public List<HitListener> getHitListeners() {
        return hitListeners;
    }

    /**
     * Sets the hit listeners.
     *
     * @param hitListeners1 the hit listeners
     */
    public void setHitListeners(List<HitListener> hitListeners1) {
        this.hitListeners = hitListeners1;
    }


    /**
     * Adding a hit listener to the hit listeners of the block.
     *
     * @param hl .
     */
    public void addHitListener(HitListener hl) {
        List<HitListener> hitListeners1 = this.getHitListeners();
        hitListeners1.add(hl);
        this.setHitListeners(hitListeners1);
    }

    /**
     * Removing a hit listener to the hit listeners of the block.
     *
     * @param hl .
     */
    public void removeHitListener(HitListener hl) {
        List<HitListener> hitListeners1 = this.getHitListeners();
        hitListeners1.remove(hl);
        this.setHitListeners(hitListeners1);
    }

    /**
     * Notifying all the hit listeners about the hit.
     *
     * @param hitter - the ball that hit the block.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}