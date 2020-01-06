/**
 * Class Block remover.
 *
 * @author Karin Shimel.
 */

public class BlockRemover implements HitListener, HitNotifier {
    private GameLevel game;
    private Counter remainingBlocks;
    private HitListener hitListener;

    /**
     * Constructor.
     * Creates a new Block remover.
     *
     * @param game1         the game 1
     * @param removedBlocks the removed blocks
     */
    public BlockRemover(GameLevel game1, Counter removedBlocks) {
        this.game = game1;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Gets remaining blocks.
     *
     * @return the remaining blocks
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public GameLevel getGame() {
        return this.game;
    }

    /**
     * When a block is being hit and is left with only 1 last hits,
     * we will remove it from the game and decrease the number of blocks remaining.
     *
     * @param beingHit - block being hit.
     * @param hitter   - ball hitting the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        // Notifying the score listener
        this.getHitListener().hitEvent(beingHit, hitter);
        // If before reducing the hit count, the hit counter is at 1, it means the block will be destroyed
        if (beingHit.getHitPoints() == 1) {
            beingHit.removeFromGame(this.getGame());
            beingHit.removeHitListener(this);
            this.getRemainingBlocks().decrease(1);
        }
    }

    /**
     * Gets hit listener.
     *
     * @return the hit listener
     */
    public HitListener getHitListener() {
        return this.hitListener;
    }

    /**
     * Sets hit listener.
     * The block remover is a listener to all the blocks, therefore can notify the score listener
     * when a block is being hit.
     *
     * @param hitListener1 the hit listener
     */
    public void setHitListener(HitListener hitListener1) {
        this.hitListener = hitListener1;
    }


    /**
     * Adding a hit listener.
     * The block remover is a listener to all the blocks, therefore can notify the score listener
     * when a block is being hit.
     *
     * @param hl .
     */
    public void addHitListener(HitListener hl) {
        this.setHitListener(hl);
    }

    /**
     * Removing a hit listener.
     *
     * @param hl .
     */
    public void removeHitListener(HitListener hl) {
        this.setHitListener(null);
    }
}