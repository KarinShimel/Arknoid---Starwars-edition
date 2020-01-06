import biuoop.DrawSurface;
import biuoop.GUI;

import java.awt.Color;
import java.util.Random;

/**
 * class MultipleFramesBouncingBallsAnimation.
 *
 * @author Karin Shimel
 */
public class MultipleFramesBouncingBallsAnimation {
    /**
     * The main, initiating the surface window and starting the animation.
     * The animation includes 2 surface windows with balls in each surface.
     * And each argument is a size of a ball.
     *
     * @param args .
     */
    public static void main(String[] args) {
        // Setting the variables needed for the animation
        GUI gui = new GUI("MultipleFramesBouncingBallsAnimation",
                600, 600);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();
        Random random = new Random();
        Velocity v;
        int randomX, randomY, size;
        /*
        Creating an array of all the balls, then setting half of the array each
        time. By setting half of the array in a different way, we can set each
        ball's boundary to be different, and limit his trajectory to the window
        he belongs to. In addition we will create each random ball in its
        designated window.
         */
        Ball[] ballArray = new Ball[args.length];
        for (int i = 0; i < args.length; i++) {
            // Setting the first half of the array
            if (i < (args.length) / 2) {
                size = Integer.parseInt(args[i]);
                randomX = random.nextInt(450) + 50;
                randomY = random.nextInt(450) + 50;
                // Setting the velocity according to the ball's size
                if (size < 50) {
                    v = Velocity.fromAngleAndSpeed(random.nextInt(360) + 1,
                            150 / size);
                } else {
                    v = Velocity.fromAngleAndSpeed(random.nextInt(360) + 1,
                            2);
                }
                // For each ball setting the values for each ball
                ballArray[i] = new Ball(randomX, randomY, size, Color.RED);
                ballArray[i].setVelocity(v);
                // Setting the boundary of the ball
                ballArray[i].setRightDownBound(new Point(500, 500));
                ballArray[i].setLeftUpBound(new Point(50, 50));
            } else {
                // Setting the second half of the balls array
                size = Integer.parseInt(args[i]);
                randomX = random.nextInt(150) + 450;
                randomY = random.nextInt(150) + 450;
                // Setting the velocity according to the ball's size
                if (size < 50) {
                    v = Velocity.fromAngleAndSpeed(random.nextInt(360) + 1,
                            150 / size);
                } else {
                    v = Velocity.fromAngleAndSpeed(random.nextInt(360) + 1,
                            2);
                }
                // For each ball setting the values for each ball
                ballArray[i] = new Ball(randomX, randomY, size, Color.RED);
                ballArray[i].setVelocity(v);
                // Setting the boundary of the ball
                ballArray[i].setRightDownBound(new Point(600, 600));
                ballArray[i].setLeftUpBound(new Point(450, 450));
            }
        }
        /*
        For each iteration of the loop, all the balls are drawn to the surface
        and using the moveOneStep method to check their trajectory, each ball
        moves in its own surface, as a result of the boundary points set.
         */
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            d.setColor(Color.GRAY);
            d.fillRectangle(50, 50, 450, 450);
            d.setColor(Color.YELLOW);
            d.fillRectangle(450, 450, 150, 150);
            for (int i = 0; i < args.length; i++) {
                ballArray[i].drawOn(d);
                ballArray[i].moveOneStep();
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}