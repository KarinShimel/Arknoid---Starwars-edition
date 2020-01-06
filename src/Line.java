import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;

/**
 * class Line.
 *
 * @author Karin Shimel
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * Constructor(1).
     * constructing the line, start and finish points.
     *
     * @param start - point representing the start of the line.
     * @param end   - point representing the end of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Constructor(2).
     * constructing the line, first creating the points and then
     * setting the start and the end points.
     *
     * @param x1 - x, value of start point.
     * @param y1 - y value of start point.
     * @param x2 - x value of end point.
     * @param y2 - y value of end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        Point startP = new Point(x1, y1);
        Point endP = new Point(x2, y2);
        this.start = startP;
        this.end = endP;
    }

    /**
     * Drawing a line.
     *
     * @param l      - line we wish to draw.
     * @param d      - relevant draw surface.
     * @param color1 - the color.
     */
    public void drawLine(Line l, DrawSurface d, Color color1) {
        d.setColor(color1);
        int x1 = (int) l.start().getX();
        int y1 = (int) l.start().getY();
        int x2 = (int) l.end().getX();
        int y2 = (int) l.end().getY();
        d.drawLine(x1, y1, x2, y2);

    }

    /**
     * Drawing a line.
     *
     * @param l - line we wish to draw.
     * @param d - relevant draw surface.
     */
    public void drawLine(Line l, DrawSurface d) {
        int x1 = (int) l.start().getX();
        int y1 = (int) l.start().getY();
        int x2 = (int) l.end().getX();
        int y2 = (int) l.end().getY();
        d.drawLine(x1, y1, x2, y2);

    }

    /**
     * Returning the line.
     *
     * @return line - this line.
     */
    public Line getLine() {
        return this;
    }

    /**
     * Calculating the length of a line.
     *
     * @return this.start.distance(end) - double value of the line's length.
     */
    public double length() {
        return this.start.distance(end);
    }

    /**
     * Calculating the middle point of a line, using average x,y.
     *
     * @return mid - the middle point in the line.
     */
    public Point middle() {
        double midX = ((this.start.getX() + this.end.getX()) / 2);
        double midY = ((this.start.getY() + this.end.getY()) / 2);
        Point mid = new Point(midX, midY);
        return mid;
    }

    /**
     * Checking for the point representing the start of the line.
     *
     * @return start - returns the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * Checking for the point representing the end of the line.
     *
     * @return end - returns the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * Checks if 2 lines intersect.
     * First by sending the lines to a helper, that returns if there is an
     * intersection between the lines, then checking if the intersection is on
     * the lines.
     *
     * @param other - other line to check the intersection.
     * @return boolean - true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        // Finding the intersection in infinite lines.
        Point intersection = infiniteLines(other);
        // If there is no intersection point.
        if (intersection == null) {
            return false;
        }
        // Checking if the point is on the line, if so then they intersect
        if (inLine(this, intersection) && inLine(other, intersection)) {
            return true;
        }
        return false;
    }

    /**
     * Check to find an intersection point in infinite lines.
     * Calculating using the formulas, and returning null value
     * if the lines do not intersect.
     *
     * @param other - other line to check the intersection with.
     * @return intersection - values of the intersection point / null.
     */
    public Point infiniteLines(Line other) {
        // Setting the helper variables
        double y1 = this.start.getY() - this.end.getY();
        double x1 = this.end.getX() - this.start.getX();
        double c1 = y1 * this.end.getX() + x1 * this.end.getY();
        double y2 = other.start.getY() - other.end.getY();
        double x2 = other.end.getX() - other.start.getX();
        double c2 = y2 * other.end.getX() + x2 * other.end.getY();
        // Checking if the lines are parallel
        double slope = y1 * x2 - y2 * x1;
        if (slope == 0) {
            return null;
        }
        // Checking the exact intersection point
        double x = (x2 * c1 - x1 * c2) / slope;
        double y = (y1 * c2 - y2 * c1) / slope;
        // Setting the new point's values
        Point intersection = new Point(x, y);
        return intersection;
    }

    /**
     * Checks if the intersection is in range.
     * A check to see the intersection point we found is in range.
     *
     * @param line - other line.
     * @param p    - the intersection point.
     * @return boolean - true if the lines intersect, false otherwise.
     */
    public boolean inLine(Line line, Point p) {
        // Setting the flag default to be false
        boolean flag = false;
        // Getting the point's values
        double x = p.getX();
        double y = p.getY();
        // Finding the min & max .
        double maxX = Math.max(line.start().getX(), line.end().getX());
        double maxY = Math.max(line.start().getY(), line.end().getY());
        double minX = Math.min(line.start().getX(), line.end().getX());
        double minY = Math.min(line.start().getY(), line.end().getY());
        // Checking if the point is on the line by checking the ranges of x.
        if ((minY <= y && maxY >= y) && (minX <= x && maxX >= x)) {
            flag = true;
        }
        return flag;
    }

    /**
     * Checking if the intersection point exists,
     * using the isIntersecting method. Returning the intersection point
     * or null - if the intersection point does not exist.
     *
     * @param other - other line to check the intersection with.
     * @return intersection - values of the intersection point / null.
     */
    public Point intersectionWith(Line other) {
        if (this.isIntersecting(other)) {
            return this.infiniteLines(other);
        } else {
            return null;
        }
    }

    /**
     * Calculating a lines slope.
     *
     * @return slope/null - double value of the slope / null- if vertical.
     */
    private Double checkSlope() {
        double ySlope = (this.end.getY() - this.start.getY());
        double xSlope = (this.end.getX() - this.start.getX());
        double slope;
        if (ySlope != 0 && xSlope != 0) {
            slope = (ySlope / xSlope);
            return slope;
        }
        if (ySlope == 0) {
            slope = 0;
            return slope;
        }
        // If this is vertical line
        return null;
    }

    /**
     * Checking if 2 lines are equals, first by checking the slope
     * and then by comparing the start and end points.
     *
     * @param other - the other line to check if they are equals.
     * @return boolean value - true if they are equals, false if not.
     */
    public boolean equals(Line other) {
        if (this.checkSlope() == other.checkSlope()) {
            if (this.start.equals(other.start) && this.end.equals(other.end)) {
                return true;
            }
        }
        return false;
    }

    /**
     * A method that checks the intersection points of a line with a rectangle.
     * Using a intersectionPoints method, getting all the intersection points
     * with the rectangle and checking which is the closest.
     *
     * @param rect - the rectangle we wish to check intersections with.
     * @return closestP - the closest intersection.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersections = rect.intersectionPoints(this.getLine());
        if (intersections.size() == 0) {
            return null;
        }
        Point closestP = intersections.get(0);
        double smallestDis = this.start().distance(intersections.get(0));
        for (int i = 0; i < intersections.size(); i++) {
            if (this.start().distance(intersections.get(i)) < smallestDis) {
                smallestDis = this.start().distance(intersections.get(i));
                closestP = intersections.get(i);
            }
        }
        return closestP;
    }
}
