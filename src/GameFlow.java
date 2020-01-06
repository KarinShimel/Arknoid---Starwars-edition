import biuoop.DialogManager;
import biuoop.KeyboardSensor;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Game flow.
 *
 * @author Karin Shimel.
 */
public class GameFlow {

    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private ScoreTrackingListener score;
    private LivesIndicator lives;
    private HighScoresTable highScores;

    /**
     * Constructor (1).
     * Creates a new Game flow.
     *
     * @param ar the animation runner
     */
    public GameFlow(AnimationRunner ar) {
        this.animationRunner = ar;
        this.keyboardSensor = this.animationRunner.getGui().getKeyboardSensor();
        this.score = new ScoreTrackingListener(new Counter(0));
        this.lives = new LivesIndicator(new Counter(2));
    }

    /**
     * Constructor (1).
     * Creates a new Game flow.
     */
    public GameFlow() {
        this.animationRunner = new AnimationRunner();
        this.keyboardSensor = this.animationRunner.getGui().getKeyboardSensor();
        this.score = new ScoreTrackingListener(new Counter(0));
        this.lives = new LivesIndicator(new Counter(2));
    }

    /**
     * Setting the high scores table.
     *
     * @param highScores1 .
     */
    public void setHighScores(HighScoresTable highScores1) {
        this.highScores = highScores1;
    }

    /**
     * Run levels.
     *
     * @param levels the levels
     */
    public void runLevels(List<LevelInformation> levels) {
        int levelsAmount = levels.size() - 1;
        int flag = 0;
        // Running for each level in the levels array
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo,
                    this.keyboardSensor,
                    this.animationRunner, lives, score);

            // The score listener needs to be set with each game level, to keep tracking score
            this.score.setGame(level);
            level.initialize();
            // Running while level still has blocks and the player has more lives
            while ((level.getBlockRemover().getRemainingBlocks().getAmount() > 0)
                    && (this.lives.getCounter().getAmount() > 0)) {
                level.playOneTurn();
            }
            // When there are no more lives
            if (this.lives.getCounter().getAmount() == 0 || flag == levelsAmount) {
                // Checking if the score can be in the high scores
                if (this.highScores.getRank(this.score.getCurrentScore().getAmount())
                        < this.highScores.getSize()) {
                    DialogManager dialog = this.animationRunner.getGui().getDialogManager();
                    String name = dialog.showQuestionDialog("Name", "What is your name?", "");
                    this.highScores.add(new ScoreInfo(name, this.score.getCurrentScore().getAmount()));
                }
                break;
            }
            flag++;
        }
        // Entering the end screen with all the relevant information
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, this.keyboardSensor.SPACE_KEY,
                new EndScreen(this.keyboardSensor, this.score, lives)));
        // Seeing the high scores
        this.animationRunner.run(new KeyPressStoppableAnimation(animationRunner.getGui().getKeyboardSensor(),
                animationRunner.getGui().getKeyboardSensor().SPACE_KEY,
                new HighScoresAnimation(this.highScores, this.animationRunner)));
        try {
            this.highScores.save(new File("highscores"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    /**
     * Creating a list of levels from the file.
     *
     * @param filename .
     * @return a list of levels.
     */
    public List<LevelInformation> readLevels(String filename) {
        List<LevelInformation> levels = new ArrayList<>();
        LevelSpecificationReader levelsReader = new LevelSpecificationReader();
        BufferedReader reader;
        InputStream is;
        try {
            is = ClassLoader.getSystemClassLoader().getResourceAsStream((filename));
            assert is != null;
            reader = (new BufferedReader(new InputStreamReader(is)));
            levels = levelsReader.fromReader(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return levels;
    }
}