import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * class BouncingBallAnimation.
 *
 * @author Karin Shimel
 */
public class BouncingBallAnimation {
    /**
     * The main, initiating the surface window and starting the animation.
     * The animation includes 1 ball in the window.
     *
     * @param args .
     */
    public static void main(String[] args) {
        // Setting the variables needed for the animation
        GUI gui = new GUI("BouncingBallAnimation", 200, 200);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        Ball ball = new Ball(0, 0, 30, java.awt.Color.BLACK);
        ball.setVelocity(Velocity.fromAngleAndSpeed(90, 2));
        // Setting the boundaries of the surface window
        ball.setLeftUpBound(new Point(0, 0));
        ball.setRightDownBound(new Point(200, 200));
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
