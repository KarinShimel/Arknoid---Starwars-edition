/**
 * Class Score tracking listener.
 *
 * @author Karin Shimel .
 */
public class ScoreTrackingListener implements HitListener {
    private GameLevel game;
    private Counter currentScore;

    /**
     * Constructor (1).
     * Creates a new Score tracking listener.
     *
     * @param game1        the game 1
     * @param scoreCounter the score counter
     */
    public ScoreTrackingListener(GameLevel game1, Counter scoreCounter) {
        this.game = game1;
        this.currentScore = scoreCounter;
    }

    /**
     * Constructor (2).
     * Setting the score tracking listener.
     *
     * @param scoreCounter1 .
     */
    public ScoreTrackingListener(Counter scoreCounter1) {
        this.currentScore = scoreCounter1;
    }

    /**
     * Setting the game level.
     *
     * @param game1 .
     */
    public void setGame(GameLevel game1) {
        this.game = game1;
    }

    /**
     * Gets current score.
     *
     * @return the current score
     */
    public Counter getCurrentScore() {
        return currentScore;
    }

    /**
     * Sets current score.
     *
     * @param currentScore1 the current score
     */
    public void setCurrentScore(Counter currentScore1) {
        this.currentScore = currentScore1;
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public GameLevel getGame() {
        return game;
    }

    /**
     * Checking the hit info in order to give the right score.
     *
     * @param beingHit the block being hit
     * @param hitter   the hitter ball
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        // If all the blocks are destroyed - can also be modified to access from the Game
        if (this.getGame().getBlockRemover().getRemainingBlocks().getAmount() == 1) {
            // For finishing the level and for the last block destroyed
            this.getCurrentScore().increase(100);
        }
        // If a block is being destroyed
        if (beingHit.getHitPoints() == 1) {
            this.getCurrentScore().increase(15);
        }
        // If the block is hit
        if (beingHit.getHitPoints() > 1) {
            this.getCurrentScore().increase(5);
        }
    }
}