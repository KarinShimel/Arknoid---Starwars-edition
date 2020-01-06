/**
 * Interface Hit listener.
 *
 * @author karin .
 */
public interface HitListener {
    /**
     * When an object is being hit it will trigger a hit event that will notify
     * the hit listeners of the object.
     *
     * @param beingHit the block being hit
     * @param hitter   the hitter ball
     */
    void hitEvent(Block beingHit, Ball hitter);
}