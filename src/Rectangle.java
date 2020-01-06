
import java.util.ArrayList;

/**
 * class Rectangle.
 *
 * @author Karin Shimel
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Constructor(1).
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft - x value of the center point
     * @param width     - y value of the center point.
     * @param height    - r is the value of the radius of the ball.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    // Return a (possibly empty) List of intersection points
    // with the specified line.

    /**
     * Checking the intersections of the rectangle with the given line.
     * By creating 4 lines representing the lines of the rectangle,
     * and checking each for intersection with the line.
     *
     * @param line - the line we wish to check intersections with.
     * @return intersections - array list of intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        // We will create 4 lines representing the rectangle
        Line[] rectangleLines = new Line[4];
        rectangleLines[0] = this.getUp();
        rectangleLines[1] = this.getDown();
        rectangleLines[2] = this.getLeft();
        rectangleLines[3] = this.getRight();
        // Creating a new array of points
        java.util.List<Point> intersections = new ArrayList<Point>();
        for (int i = 0; i < 4; i++) {
            if (rectangleLines[i].isIntersecting(line)) {
                // Adding the intersection point to the list
                intersections.add(rectangleLines[i].intersectionWith(line));
            }
        }
        return intersections;
    }

    /**
     * Return the width of the rectangle.
     *
     * @return this.width - the rectangle's width.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Return the height of the rectangle.
     *
     * @return this.height- the rectangle's height.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returning the upper line of the rectangle.
     *
     * @return new line - the rectangle's upper line.
     */
    public Line getUp() {
        return new Line(this.upperLeft, this.getUpperRight());
    }

    /**
     * Returning the lower line of the rectangle.
     *
     * @return new line - the rectangle's lower line.
     */
    public Line getDown() {
        return new Line(this.getDownLeft(), this.getDownRight());
    }

    /**
     * Returning the left line of the rectangle.
     *
     * @return new line - the rectangle's left line.
     */
    public Line getLeft() {
        return new Line(this.upperLeft, this.getDownLeft());
    }

    /**
     * Returning the right line of the rectangle.
     *
     * @return new line - the rectangle's right line.
     */
    public Line getRight() {
        return new Line(this.getUpperRight(), this.getDownRight());
    }

    /**
     * Returning the upper-left point of the rectangle.
     *
     * @return this.upperLeft.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /**
     * Returning the upper-right point of the rectangle.
     *
     * @return new point - upper right point of the rectangle.
     */
    public Point getUpperRight() {
        return new Point(this.upperLeft.getX() + this.getWidth(),
                this.upperLeft.getY());
    }
    /**
     * Returning the down - left point of the rectangle.
     *
     * @return new point - down left point of the rectangle.
     */
    public Point getDownLeft() {
        return new Point(this.upperLeft.getX(),
                this.upperLeft.getY() + this.getHeight());
    }
    /**
     * Returning the down - right point of the rectangle.
     *
     * @return new point - down right point of the rectangle.
     */
    public Point getDownRight() {
        return new Point(this.upperLeft.getX() + this.getWidth(),
                this.upperLeft.getY() + this.getHeight());
    }
    /**
     * Calculating the middle of the rectangle.
     *
     * @return mid - middle of the rectangle.
     */
    public Point findRecMid() {
        // Creating the diagonals of the rectangle
        Line diagonal1 = new Line(this.getUpperLeft(), this.getDownRight());
        Line diagonal2 = new Line(this.getDownLeft(), this.getUpperRight());
        Point mid = diagonal1.intersectionWith(diagonal2);
        return mid;
    }
}
