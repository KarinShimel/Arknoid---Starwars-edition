/**
 * Class Show hi scores task.
 *
 * @author Karin Shimel.
 */
public class ShowHiScoresTask implements Task<Void> {
    private AnimationRunner runner;
    private Animation highScoresAnimation;

    /**
     * Constructor.
     * Creates a new Show hi scores task.
     *
     * @param runner              the runner
     * @param highScoresAnimation the high scores animation
     */
    public ShowHiScoresTask(AnimationRunner runner, Animation highScoresAnimation) {
        this.runner = runner;
        this.highScoresAnimation = highScoresAnimation;
    }

    /**
     * Running the high scores animation.
     *
     * @return Void.
     */
    public Void run() {
        this.runner.run(new KeyPressStoppableAnimation(this.runner.getGui().getKeyboardSensor(),
                this.runner.getGui().getKeyboardSensor().SPACE_KEY,
                this.highScoresAnimation));
        return null;
    }
}