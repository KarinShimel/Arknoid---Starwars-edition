import biuoop.DrawSurface;

import java.awt.Color;
import java.util.Random;

/**
 * Class Sunset -  background.
 *
 * @author Karin Shimel.
 */
public class Sunset implements Sprite {

    /**
     * Drawing the background.
     *
     * @param d - the relevant draw surface.
     */
    public void drawOn(DrawSurface d) {
        // Drawing the grid
        d.setColor(Color.WHITE);
        d.fillRectangle(25, 45, 750, 555);
        // Night sky
        Color colorSky = new Color(0x0A3461);
        colorSky.getRGB();
        d.setColor(colorSky);
        d.fillRectangle(25, 25, 750, 310);
        // Stars - Creating a random start each time, ending up to look like a star animation with each draw
        d.setColor(Color.WHITE);
        Random ran1 = new Random();
        int x = ran1.nextInt(750) + 25;
        Random ran2 = new Random();
        int y = ran2.nextInt(250) + 45;
        d.fillCircle(x, y, 3);
        // Sun
        drawSun(d);
        // Water
        Color colorWater = new Color(0xFF6EA2AB, true);
        colorWater.getRGB();
        d.setColor(colorWater);
        d.fillRectangle(25, 310, 750, 320);
        // Sun reflection
        int startX = 300;
        int startY = 320;
        int xDiff = 7;
        int xDiff2 = 15;
        int yDiff = 12;
        int width = 200;
        int widthDiff = 5;
        for (int i = 0; i < 15; i++) {
            Color color1, color2;
            if (i % 2 == 0) {
                color1 = new Color(0xFFF12F2B, true);
                color1.getRGB();
                color2 = new Color(0xFFBF6620, true);
                color2.getRGB();
            } else {
                color1 = new Color(0xFFBF945C, true);
                color1.getRGB();
                color2 = new Color(0xFFE1CC73, true);
                color2.getRGB();
            }
            d.setColor(color1);
            d.drawLine(startX + (i * xDiff), startY + (i * yDiff),
                    startX + width - (i * xDiff), startY + (i * yDiff));
            d.setColor(color2);
            d.drawLine(startX + (i * xDiff), startY + (i * yDiff) + 4,
                    startX + width - (i * xDiff), startY + (i * yDiff) + 4);
        }
        // Waves
        d.setColor(Color.WHITE);
        for (int k = 0; k < 5; k++) {
            int x1, y1;
            if (k == 0) {
                x1 = 600;
                y1 = 370;
            } else if (k == 1) {
                x1 = 160;
                y1 = 350;
            } else if (k == 2) {
                x1 = 410;
                y1 = 565;
            } else if (k == 3) {
                x1 = 700;
                y1 = 460;
            } else {
                x1 = 100;
                y1 = 500;
            }
            d.drawLine(x1, y1, x1 + 10, y1 - 7);
            d.drawLine(x1 + 10, y1 - 7, x1 + 15, y1 - 7);
            d.drawLine(x1 + 15, y1 - 7, x1 + 25, y1);
            d.drawLine(x1 + 25, y1, x1 + 30, y1 - 4);
        }
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 20);
        d.setColor(Color.BLACK);
        d.drawText(600, 15, "Level: Wide Easy", 20);
    }

    /**
     * Draw sun.
     *
     * @param d .
     */
    public void drawSun(DrawSurface d) {
        // Sun shade
        Color sunShade = new Color(0xFFEADCA1, true);
        sunShade.getRGB();
        d.setColor(sunShade);
        d.fillCircle(400, 270, 121);
        // Sun
        Color colorSun1 = new Color(0xFFEAC55F, true);
        colorSun1.getRGB();
        d.setColor(colorSun1);
        d.fillCircle(400, 270, 120);
        Color colorSun = new Color(0xFFEAB94D, true);
        colorSun.getRGB();
        d.setColor(colorSun);
        d.fillCircle(400, 270, 110);
        Color colorSun2 = new Color(0xFFEAB648, true);
        colorSun2.getRGB();
        d.setColor(colorSun2);
        d.fillCircle(400, 270, 90);
    }


    /**
     * Notifying that time has passed.
     */
    public void timePassed() {

    }
}
