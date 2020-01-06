/**
 * class Point.
 *
 * @author Karin Shimel
 */
public class Point {
    private double x;
    private double y;

    /**
     * Constructor.
     * constructing the point, and setting the x,y parameters.
     *
     * @param x - double value of x.
     * @param y - double value of y.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * calculates the distance of this point to the other point, and returns it
     * by using the equation of distance between 2 points.
     *
     * @param other - double valued numbers.
     * @return distance - double value.
     */
    public double distance(Point other) {
        double distanceX = Math.pow((this.getX() - other.getX()), 2);
        double distanceY = Math.pow((this.getY() - other.getY()), 2);
        return Math.sqrt(distanceY + distanceX);
    }
    /**
     * Setting the point's new x value.
     *
     * @param x1 - double value of x.
     */
    public void setX(double x1) {
        this.x = x1;
    }
    /**
     * Setting the point's new y value.
     *
     * @param y1 - double value of y.
     */
    public void setY(double y1) {
        this.y = y1;
    }

    /**
     * The method checks if 2 points are equal
     * by comparing their x and y values.
     *
     * @param other - Point that contains x,y values.
     * @return boolean - true if equals / false if not equals.
     */
    public boolean equals(Point other) {
        if (this.getX() == other.getX() && this.getY() == other.getY()) {
            return true;
        }
        return false;
    }

    /**
     * The method returns the value of the point's x value.
     *
     * @return this.x - double value of the point's x.
     */
    public double getX() {
        return this.x;
    }

    /**
     * The method returns the value of the point's y value.
     *
     * @return this.y - double value of the point's y.
     */
    public double getY() {
        return this.y;
    }
}
