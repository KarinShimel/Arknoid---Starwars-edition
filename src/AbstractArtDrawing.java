import biuoop.GUI;
import biuoop.DrawSurface;

import java.util.Random;
import java.awt.Color;

/**
 * class AbstractArtDrawing.
 *
 * @author Karin Shimel
 */
public class AbstractArtDrawing {
    /**
     * Creating a window 400x300, creating 10 random lines and drawing them
     * on to the window.
     */
    public void drawRandomLines() {
        GUI gui = new GUI("AbstractArtDrawing", 400, 300);
        DrawSurface d = gui.getDrawSurface();
        // Creating an array of lines
        Line[] randomLines = new Line[10];
        for (int i = 0; i < 10; ++i) {
            // Creating each line and placing it in the array, then drawing it
            randomLines[i] = generateRandomLine(d);
            drawLine(randomLines[i], d);
        }
        // Drawing the middle points and intersections
        drawIntersections(randomLines, d);
        drawMid(randomLines, d);
        gui.show(d);
    }

    /**
     * Finding the middle of each line in the lines array, and drawing
     * it on to the window we set earlier.
     *
     * @param d - represents the draw surface.
     * @param linesArray Line[]- the array of lines.
     */
    public void drawMid(Line[] linesArray, DrawSurface d) {
        d.setColor(Color.BLUE);
        for (int i = 0; i < 10; i++) {
            Point mid = linesArray[i].middle();
            d.fillCircle((int) mid.getX(), (int) mid.getY(), 3);
        }
    }

    /**
     * Finding the middle of each line in the lines array, and drawing
     * it on to the window we set earlier.
     *
     * @param linesArray Line[], d - the array of lines and the draw surface.
     * @param d -  represents the draw surface.
     */
    public void drawIntersections(Line[] linesArray, DrawSurface d) {
        d.setColor(Color.RED);
        for (int i = 0; i < 10; i++) {
            int j = i + 1;
            for (; j < 10; j++) {
                // If the intersection exists,we will look for the intersection
                if (linesArray[i].isIntersecting(linesArray[j])) {
                    Point intersection =
                            linesArray[i].intersectionWith(linesArray[j]);
                    d.fillCircle((int) intersection.getX(),
                            (int) intersection.getY(), 3);
                }
            }
        }
    }

    /**
     * Creating a line.
     * Getting random x,y values and setting a new line.
     *
     * @param d - the draw surface.
     * @return line - new line that was created randomly.
     */
    Line generateRandomLine(DrawSurface d) {
        // create a random-number generator
        Random rand = new Random();
        int x1 = rand.nextInt(400) + 1;
        int y1 = rand.nextInt(300) + 1;
        int x2 = rand.nextInt(400) + 1;
        int y2 = rand.nextInt(300) + 1;
        Line line = new Line(x1, y1, x2, y2);
        return line;
    }

    /**
     * Drawing a line on to the draw surface.
     * First, casting all the x,y values to integers, then drawing the line.
     *
     * @param l - the line we wish to draw.
     * @param d - the draw surface.
     */
    void drawLine(Line l, DrawSurface d) {
        d.setColor(Color.BLACK);
        int x1 = (int) l.start().getX();
        int y1 = (int) l.start().getY();
        int x2 = (int) l.end().getX();
        int y2 = (int) l.end().getY();
        d.drawLine(x1, y1, x2, y2);
    }

    /**
     * The main to start the run, initiating the drawing of random line,
     * intersections and middle points.
     *
     * @param args .
     */
    public static void main(String[] args) {
        AbstractArtDrawing run = new AbstractArtDrawing();
        run.drawRandomLines();
    }
}