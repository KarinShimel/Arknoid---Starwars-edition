/**
 * Class BallRemover.
 *
 * @author Karin Shimel.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Constructor.
     * Creates a new ball remover.
     *
     * @param game1           the game 1
     * @param remainingBalls1 the remaining balls 1
     */
    public BallRemover(GameLevel game1, int remainingBalls1) {
        this.game = game1;
        this.remainingBalls = new Counter(remainingBalls1);
    }

    /**
     * Gets remaining balls.
     *
     * @return the remaining balls
     */
    public Counter getRemainingBalls() {
        return this.remainingBalls;
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
     * Sets remaining balls.
     *
     * @param remainingBalls1 the remaining balls
     */
    public void setRemainingBalls(Counter remainingBalls1) {
        this.remainingBalls = remainingBalls1;
    }

    /**
     * When the block is hit the ball is being removed from the game and
     * we are decreasing the number of balls remaining.
     *
     * @param beingHit - the blcok being hit.
     * @param hitter   - the ball that hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.getGame());
        this.getRemainingBalls().decrease(1);
    }
}
