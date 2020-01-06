/**
 * Class Score info.
 *
 * @author Karin Shimel.
 */
public class ScoreInfo {
    private String name;
    private int score;

    /**
     * Constructor.
     * Creates a new Score info.
     *
     * @param name1  the name 1
     * @param score1 the score 1
     */
    public ScoreInfo(String name1, int score1) {
        this.name = name1;
        this.score = score1;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }
}