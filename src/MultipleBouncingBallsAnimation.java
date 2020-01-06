import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;
import java.util.Random;

/**
 * class MultipleBouncingBallsAnimation.
 *
 * @author Karin Shimel
 */
public class MultipleBouncingBallsAnimation {
    /**
     * The main, initiating the surface window and starting the animation.
     * The animation includes balls in the window, the args contain the size
     * of the balls.
     *
     * @param args .
     */
    public static void main(String[] args) {
        // Setting the variables needed for the animation
        GUI gui = new GUI("MultipleBouncingBallsAnimation", 200, 200);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        Random random = new Random();
        Velocity v;
        int randomX, randomY, size;
        // Creating an array of balls, so we can run on each ball every frame
        Ball[] ballArray = new Ball[args.length];
        /*
        For each ball, creating random x,y values, representing the center of the ball.
        And setting the correct velocity by checking the ball's size.
         */
        for (int i = 0; i < args.length; i++) {
            size = Integer.parseInt(args[i]);
            randomX = random.nextInt(200) + 1;
            randomY = random.nextInt(200) + 1;
            if (size < 50) {
                v = Velocity.fromAngleAndSpeed(random.nextInt(360) + 1,
                        150 / size);
            } else {
                v = Velocity.fromAngleAndSpeed(random.nextInt(360) + 1,
                        2);
            }
            // For each ball setting the values for each ball
            ballArray[i] = new Ball(randomX, randomY, size, Color.BLACK);
            ballArray[i].setVelocity(v);
            // Setting the boundary of the ball
            ballArray[i].setRightDownBound(new Point(200, 200));
            ballArray[i].setLeftUpBound(new Point(0, 0));
        }
        /*
        For each iteration of the loop, all the balls are drawn to the surface
        and using the moveOneStep method to check their trajectory.
         */
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            for (int i = 0; i < args.length; i++) {
                ballArray[i].drawOn(d);
                ballArray[i].moveOneStep();
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
