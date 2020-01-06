/**
 * Class Task anonymous.
 *
 * @author Karin Shimel.
 */
public class TaskAnonymous implements Task {
    private AnimationRunner runner;

    /**
     * Constructor.
     * Creates a new Task anonymous.
     *
     * @param animationRunner the animation runner
     */
    public TaskAnonymous(AnimationRunner animationRunner) {
        this.runner = animationRunner;
    }

    @Override
    public Void run() {
        return null;
    }
}
