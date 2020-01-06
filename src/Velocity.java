/**
 * class Velocity.
 *
 * @author Karin Shimel
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Constructor.
     * Setting the Velocity, by using the dx,dy chose in the constructor.
     *
     * @param dx - the change in x.
     * @param dy - the change in y.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * The method returns the double value of the change in x.
     *
     * @return double value of the change in x.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * The method returns the double value of the change in y.
     *
     * @return double value of the change in y.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Setting a velocity using the angle and speed desired.
     * Then calculating the dx and dy accordingly.
     *
     * @param angle - center point.
     * @param speed - r radius of the ball.
     * @return new Velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        // converts the angle and speed of movement along the x and y axis.
        double dx = speed * Math.sin((angle * Math.PI) / 180);
        double dy = speed * Math.cos((angle * Math.PI) / 180);
        return new Velocity(dx, dy);
    }
    /**
     * Setting the velocity's dy field.
     *
     * @param dy1 - the new dy.
     */
    public void setDy(double dy1) {
        this.dy = dy1;
    }
    /**
     * Setting the velocity's dx field.
     *
     * @param dx1 - the change in x.
     */
    public void setDx(double dx1) {
        this.dx = dx1;
    }

    /**
     * Making the change of the velocity on a point.
     * Taking a point with position (x,y) and return a new point
     * with position (x+dx, y+dy)
     * @param p - current point we wish to change.
     * @return nextP - the next point after implementing the velocity.
     */

    public Point applyToPoint(Point p) {
        Point nextP = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return nextP;
    }
}