import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Class Unicorn.
 * A background.
 *
 * @author karin .
 */
public class Unicorn implements Sprite {


    /**
     * Drawing the background.
     * Using pixel art, I made a grid and colored in the specific locations to make
     * the drawing, the gaps are the height & width of each rectangle in the grid and so drawing
     * in a specific location was by using the specific gaps.
     *
     * @param d .
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 20);
        // Drawing the grid
        d.setColor(Color.lightGray);
        d.fillRectangle(25, 45, 750, 540);
        // Rows
        int gap = 20;
        for (int i = 0; i < 27; i++) {
            Line line = new Line(25, 45 + gap * i, 775, 45 + gap * i);
            line.drawLine(line, d, Color.lightGray);
        }
        // Colls
        int gap1 = 25;
        for (int j = 0; j < 30; j++) {
            Line line = new Line(25 + gap1 * j, 45, 25 + gap1 * j, 585);
            line.drawLine(line, d, Color.lightGray);
        }
        int startX = 25;
        int startY = 45;
        int width = 25;
        int height = 20;
        // HORN
        d.setColor(Color.BLACK);
        d.fillRectangle(startX + (gap1 * 5), startY + (gap * 1), width * 2, height);
        d.fillRectangle(startX + (gap1 * 5), startY + (gap * 2), width, height);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 2), width, height);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 3), width, height);
        d.fillRectangle(startX + (gap1 * 8), startY + (gap * 3), width, height);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 4), width, height);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 5), width, height);
        d.fillRectangle(startX + (gap1 * 9), startY + (gap * 4), width, height);
        d.fillRectangle(startX + (gap1 * 9), startY + (gap * 5), width, height);
        d.fillRectangle(startX + (gap1 * 8), startY + (gap * 6), width, height);
        Color horn = new Color(0xFFFFD36C, true);
        horn.getRGB();
        d.setColor(horn);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 2), width, height);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 3), width, height);
        d.fillRectangle(startX + (gap1 * 8), startY + (gap * 4), width, height * 2);
        d.setColor(Color.BLACK);
        // Hat
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 6), width, height);
        d.fillRectangle(startX + (gap1 * 5), startY + (gap * 7), width, height);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 8), width * 4, height);
        d.fillRectangle(startX + (gap1 * 10), startY + (gap * 7), width, height);
        d.fillRectangle(startX + (gap1 * 11), startY + (gap * 6), width, height);
        d.fillRectangle(startX + (gap1 * 12), startY + (gap * 4), width, height * 2);
        d.fillRectangle(startX + (gap1 * 10), startY + (gap * 3), width * 2, height);
        Color hat = new Color(0xFFBC56CA, true);
        hat.getRGB();
        d.setColor(hat);
        d.fillRectangle(startX + (gap1 * 10), startY + (gap * 4), width * 2, height * 2);
        d.fillRectangle(startX + (gap1 * 9), startY + (gap * 6), width * 2, height);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 7), width * 4, height);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 6), width, height);
        d.setColor(Color.BLACK);
        // Nose
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 9), width, height);
        d.fillRectangle(startX + (gap1 * 4), startY + (gap * 10), width * 2, height);
        d.fillRectangle(startX + (gap1 * 3), startY + (gap * 11), width * 3, height);
        d.fillRectangle(startX + (gap1 * 2), startY + (gap * 12), width, height);
        d.fillRectangle(startX + (gap1 * 1), startY + (gap * 13), width, height * 3);
        d.fillRectangle(startX + (gap1 * 2), startY + (gap * 16), width * 2, height);
        d.fillRectangle(startX + (gap1 * 3), startY + (gap * 17), width * 3, height);
        d.fillRectangle(startX + (gap1 * 5), startY + (gap * 12), width, height * 2);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 13), width, height * 4);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 17), width * 4, height);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 16), width * 2, height);
        d.fillRectangle(startX + (gap1 * 8), startY + (gap * 18), width, height * 3);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 21), width, height * 4);
        d.fillRectangle(startX + (gap1 * 8), startY + (gap * 24), width * 9, height);
        Color nose = new Color(0xFFFAAAD4, true);
        nose.getRGB();
        d.setColor(nose);
        d.fillRectangle(startX + (gap1 * 3), startY + (gap * 12), width * 2, height);
        d.fillRectangle(startX + (gap1 * 2), startY + (gap * 13), width * 3, height);
        d.fillRectangle(startX + (gap1 * 2), startY + (gap * 14), width * 4, height * 2);
        d.fillRectangle(startX + (gap1 * 4), startY + (gap * 16), width * 2, height);
        // Eyes
        d.setColor(Color.BLACK);
        d.fillRectangle(startX + (gap1 * 8), startY + (gap * 11), width, height);
        d.fillRectangle(startX + (gap1 * 10), startY + (gap * 10), width, height * 2);
        d.fillRectangle(startX + (gap1 * 9), startY + (gap * 12), width, height);
        // Head
        d.fillRectangle(startX + (gap1 * 13), startY + (gap * 4), width, height);
        d.fillRectangle(startX + (gap1 * 14), startY + (gap * 3), width, height);
        d.fillRectangle(startX + (gap1 * 15), startY + (gap * 2), width, height);
        d.fillRectangle(startX + (gap1 * 16), startY + (gap * 3), width * 5, height);
        d.fillRectangle(startX + (gap1 * 16), startY + (gap * 4), width, height * 5);
        d.fillRectangle(startX + (gap1 * 14), startY + (gap * 6), width * 2, height);
        int doubleWidth = width * 3;
        for (int i = 0; i < 3; i++) {
            d.fillRectangle(startX + (gap1 * 17) + (doubleWidth * i),
                    startY + (gap * 9), width, height * 3);
            d.fillRectangle(startX + (gap1 * 16) + (doubleWidth * i),
                    startY + (gap * 12), width, height);
            if (i == 0) {
                d.fillRectangle(startX + (gap1 * 15), startY + (gap * 13), width, height);
            } else {
                d.fillRectangle(startX + (gap1 * 18) + (doubleWidth * (i - 1)),
                        startY + (gap * 4), width, height * 2);
                d.fillRectangle(startX + (gap1 * 19) + (doubleWidth * (i - 1)),
                        startY + (gap * 6), width, height * 3);
                d.fillRectangle(startX + (gap1 * 16) + (doubleWidth * i),
                        startY + (gap * 13), width, height);
            }
            d.fillRectangle(startX + (gap1 * 14) + (doubleWidth * i), startY + (gap * 20), width, height);
            d.fillRectangle(startX + (gap1 * 15) + (doubleWidth * i), startY + (gap * 21), width, height);
            d.fillRectangle(startX + (gap1 * 16) + (doubleWidth * i), startY + (gap * 22), width, height);
        }
        d.fillRectangle(startX + (gap1 * 14), startY + (gap * 14), width, height);
        d.fillRectangle(startX + (gap1 * 17), startY + (gap * 14), width * 2, height);
        d.fillRectangle(startX + (gap1 * 21), startY + (gap * 14), width, height);
        d.fillRectangle(startX + (gap1 * 13), startY + (gap * 15), width, height * 5);
        d.fillRectangle(startX + (gap1 * 14), startY + (gap * 20), width, height);
        d.fillRectangle(startX + (gap1 * 15), startY + (gap * 21), width, height);
        d.fillRectangle(startX + (gap1 * 16), startY + (gap * 22), width, height);
        d.fillRectangle(startX + (gap1 * 17), startY + (gap * 23), width * 6, height);
        d.fillRectangle(startX + (gap1 * 16), startY + (gap * 15), width, height * 5);
        d.fillRectangle(startX + (gap1 * 19), startY + (gap * 16), width, height * 4);
        d.fillRectangle(startX + (gap1 * 20), startY + (gap * 15), width, height);
        // Hair
        drawHair(d);
        // Dots
        Color dots = new Color(0xFFFAD9EB, true);
        dots.getRGB();
        d.setColor(dots);
        d.fillRectangle(startX + (gap1 * 2), startY + (gap * 6), width, height);
        d.fillRectangle(startX + (gap1 * 24), startY + (gap * 3), width, height);
        d.fillRectangle(startX + (gap1 * 27), startY + (gap * 14), width, height);
        d.fillRectangle(startX + (gap1 * 22), startY + (gap * 17), width, height);
        d.fillRectangle(startX + (gap1 * 1), startY + (gap * 23), width, height);
        d.fillRectangle(startX + (gap1 * 25), startY + (gap * 24), width, height);
        d.fillRectangle(startX + (gap1 * 28), startY + (gap * 21), width, height);
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 20);
        d.setColor(Color.BLACK);
        d.drawText(600, 15, "Level: Final Four", 20);
    }

    /**
     * Draw the hair.
     *
     * @param d - the draw surface.
     */
    public void drawHair(DrawSurface d) {
        int gap = 20;
        int gap1 = 25;
        int startX = 25;
        int startY = 45;
        int width = 25;
        int height = 20;
        int doubleWidth = width * 3;
        for (int k = 0; k < 2; k++) {
            if (k == 0) {
                Color wave = new Color(0xFF53D4FA, true);
                wave.getRGB();
                d.setColor(wave);
            } else {
                Color wave = new Color(0xFFFA7FF4, true);
                wave.getRGB();
                d.setColor(wave);
            }
            d.fillRectangle(startX + (gap1 * 17) + (doubleWidth * k),
                    startY + (gap * 6), width * 2, height * 3);
            d.fillRectangle(startX + (gap1 * 18) + (doubleWidth * k),
                    startY + (gap * 9), width * 2, height * 3);
            d.fillRectangle(startX + (gap1 * 17) + (doubleWidth * k),
                    startY + (gap * 12), width * 2, height * 2);
            if (k == 0) {
                d.fillRectangle(startX + (gap1 * 16), startY + (gap * 13), width, height);
                d.fillRectangle(startX + (gap1 * 17), startY + (gap * 4), width, height * 2);
            } else {
                d.fillRectangle(startX + (gap1 * 18) + (width * (k)),
                        startY + (gap * 4), width * 2, height * 2);
                d.fillRectangle(startX + (gap1 * 19) + (width * (k)),
                        startY + (gap * 14), width, height);
                d.fillRectangle(startX + (gap1 * 18) + (width * (k)),
                        startY + (gap * 15), width, height);

            }
            d.fillRectangle(startX + (gap1 * 15) + (doubleWidth * k),
                    startY + (gap * 14), width * 2, height);
            d.fillRectangle(startX + (gap1 * 14) + (doubleWidth * k),
                    startY + (gap * 15), width * 2, height * 5);
            d.fillRectangle(startX + (gap1 * 15) + (doubleWidth * k),
                    startY + (gap * 20), width * 2, height);
            d.fillRectangle(startX + (gap1 * 16) + (doubleWidth * k),
                    startY + (gap * 21), width * 2, height);
            d.fillRectangle(startX + (gap1 * 17) + (doubleWidth * k),
                    startY + (gap * 22), width * 2, height);
        }
    }

    @Override
    public void timePassed() {

    }
}
