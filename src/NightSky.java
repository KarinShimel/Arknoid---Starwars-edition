import biuoop.DrawSurface;

import java.awt.Color;

/**
 * Class Night sky- background.
 *
 * @author Karin Shimel.
 */
public class NightSky implements Sprite {

    /**
     * Drawing the background.
     *
     * @param d - the relevant draw surface.
     */
    public void drawOn(DrawSurface d) {
        Color sky = new Color(0xFF09212D, true);
        sky.getRGB();
        d.setColor(sky);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.WHITE);
        int x = 40;
        int y = 40;
        int x1 = 90;
        int y1 = 50;
        int x2 = 500;
        int y2 = 30;
        for (int i = 0; i < 30; i++) {
            d.fillCircle(x + (i * x), y + (i * y), 1);
            d.fillCircle(x + (i * x), 300 - (i * y), 1);
            d.fillCircle(300 + (i * 70), y1 + (i * 60), 1);
            d.fillCircle(x2 + (i * x1), y2 + (i * y1), 1);
            d.fillCircle(0 + (i * x1), 600 - (i * y1), 1);
            d.fillCircle(70 + (i * x1), 350 - (i * 15), 1);
            d.fillCircle(770 - (i * 60), 600 - (i * 15), 1);
            d.fillCircle(770 - (i * 35), (i * 45), 1);
        }

        d.setColor(Color.WHITE);
        d.fillCircle(400, 160, 102);
        Color moon = new Color(0xFFDCD6DA, true);
        moon.getRGB();
        d.setColor(moon);
        d.fillCircle(400, 160, 100);
        //Moon
        Color moon1 = new Color(0xFFD8D2D6, true);
        moon1.getRGB();
        d.setColor(moon1);
        d.fillCircle(400, 160, 90);
        Color moon2 = new Color(0xFFD3CDD1, true);
        moon2.getRGB();
        d.setColor(moon2);
        d.fillCircle(400, 160, 80);
        Color moon3 = new Color(0xFFCFC9CD, true);
        moon3.getRGB();
        d.setColor(moon3);
        d.fillCircle(400, 160, 70);
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 20);
        d.setColor(Color.BLACK);
        d.drawText(600, 15, "Level: Direct Hit", 20);
    }


    /**
     * Notifying that time has passed.
     */
    public void timePassed() {

    }
}
