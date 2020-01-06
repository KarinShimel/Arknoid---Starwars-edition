import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * Class Key press stoppable animation.
 *
 * @author Karin Shimel.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String string;
    private Animation animation;
    private boolean stopAnimation;
    private boolean isAlreadyPressed;

    /**
     * Constructor.
     * Creates a new Key press stoppable animation.
     *
     * @param sensor     the sensor
     * @param key        the key
     * @param animation1 the animation 1
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation1) {
        this.keyboardSensor = sensor;
        this.string = key;
        this.animation = animation1;
        this.stopAnimation = false;
        this.isAlreadyPressed = true;
    }


    /**
     * Doing one frame of the animation until the relevant key is pressed.
     *
     * @param d the draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.keyboardSensor.isPressed(this.string) && !this.isAlreadyPressed) {
            this.stopAnimation = true;
        }
        if (!this.keyboardSensor.isPressed(this.string)) {
            this.isAlreadyPressed = false;
        }
    }

    /**
     * Checking if the animation should stop.
     *
     * @return true / false.
     */
    public boolean shouldStop() {
        return this.stopAnimation;
    }
}