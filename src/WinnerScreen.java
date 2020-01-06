import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

public class WinnerScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private ScoreTrackingListener score;
    public WinnerScreen(KeyboardSensor k, ScoreTrackingListener score1) {
        this.keyboard = k;
        this.stop = false;
        this.score = score1;
    }
    public void doOneFrame(DrawSurface d) {
        this.drawOn(d);
        d.setColor(Color.BLACK);
        d.drawText(555, 355, "Winner !" , 45);
        d.drawText(530, 400, "Your Score: " + this.score.getCurrentScore().getAmount(), 30);
        d.drawText(540, 430, "press space to continue", 20);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
    public void drawOn(DrawSurface d){d.setColor(Color.lightGray);
        d.fillRectangle(0, 0, 800, 600);
        int startX = 25;
        int startY = 45;
        int width = 25;
        int height = 20;
        int gap1 = 25;
        int gap = 20;
        d.setColor(Color.BLACK);
        d.fillRectangle(startX + (gap1 * 9), startY + (gap * 1),width,height);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 2),width*5,height);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 3),width,height*2);
        d.fillRectangle(startX + (gap1 * 12), startY + (gap * 3),width,height*2);
        d.fillRectangle(startX + (gap1 * 4), startY + (gap * 5),width*11,height);
        d.fillRectangle(startX + (gap1 * 3), startY + (gap * 6),width*2,height);
        d.fillRectangle(startX + (gap1 * 4), startY + (gap * 6),width,height*7);
        d.fillRectangle(startX + (gap1 * 14), startY + (gap * 6),width,height*7);
        d.fillRectangle(startX + (gap1 * 4), startY + (gap * 12),width*2,height);
        d.fillRectangle(startX + (gap1 * 5), startY + (gap * 13),width*2,height);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 14),width*2,height);
        d.fillRectangle(startX + (gap1 * 13), startY + (gap * 12),width*2,height);
        d.fillRectangle(startX + (gap1 * 12), startY + (gap * 13),width*2,height);
        d.fillRectangle(startX + (gap1 * 11), startY + (gap * 14),width*2,height);
        d.fillRectangle(startX + (gap1 * 4), startY + (gap * 12),width*2,height);
        d.fillRectangle(startX + (gap1 * 5), startY + (gap * 13),width*2,height);
        d.fillRectangle(startX + (gap1 * 8), startY + (gap * 15),width,height*5);
        d.fillRectangle(startX + (gap1 * 10), startY + (gap * 15),width,height*5);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 19),width*2,height);
        d.fillRectangle(startX + (gap1 * 10), startY + (gap * 19),width*2,height);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 20),width,height);
        d.fillRectangle(startX + (gap1 * 12), startY + (gap * 20),width,height);
        d.fillRectangle(startX + (gap1 * 4), startY + (gap * 21),width*11,height);
        d.fillRectangle(startX + (gap1 * 4), startY + (gap * 25),width*11,height);
        d.fillRectangle(startX + (gap1 * 4), startY + (gap * 21),width,height*5);
        d.fillRectangle(startX + (gap1 * 14), startY + (gap * 21),width,height*5);
        //Handles - left
        d.fillRectangle(startX + (gap1 * 14), startY + (gap * 6),width*2,height);
        d.fillRectangle(startX + (gap1 * 1), startY + (gap * 7),width*2,height);
        d.fillRectangle(startX + (gap1 * 1), startY + (gap * 8),width,height*2);
        d.fillRectangle(startX + (gap1 * 2), startY + (gap * 10),width,height);
        d.fillRectangle(startX + (gap1 * 3), startY + (gap * 11),width,height);
        // right
        d.fillRectangle(startX + (gap1 * 15), startY + (gap * 6),width,height);
        d.fillRectangle(startX + (gap1 * 16), startY + (gap * 7),width*2,height);
        d.fillRectangle(startX + (gap1 * 17), startY + (gap * 8),width,height*2);
        d.fillRectangle(startX + (gap1 * 16), startY + (gap * 10),width,height);
        d.fillRectangle(startX + (gap1 * 15), startY + (gap * 11),width,height);
        // Coloring
        Color trophy = new Color(0xFFE5B130, true);
        trophy.getRGB();
        d.setColor(trophy);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 3),width*4,height*2);
        d.fillRectangle(startX + (gap1 * 5), startY + (gap * 6),width*8,height*6);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 12),width*6,height);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 13),width*4,height);
        d.fillRectangle(startX + (gap1 * 8), startY + (gap * 14),width*2,height);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap * 20),width*4,height);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 23),width*7,height);
        Color darkYellow = new Color(0xFFCFA02B, true);
        darkYellow.getRGB();
        d.setColor(darkYellow);
        d.fillRectangle(startX + (gap1 * 11), startY + (gap * 3),width,height*2);
        d.fillRectangle(startX + (gap1 * 13), startY + (gap * 6),width,height*6);
        d.fillRectangle(startX + (gap1 * 12), startY + (gap * 12),width,height);
        d.fillRectangle(startX + (gap1 * 11), startY + (gap * 13),width,height);
        d.fillRectangle(startX + (gap1 * 10), startY + (gap * 14),width,height);
        d.fillRectangle(startX + (gap1 * 9), startY + (gap * 15),width,height*5);
        d.fillRectangle(startX + (gap1 * 11), startY + (gap * 20),width,height);
        Color stand = new Color(0xFF643417, true);
        stand.getRGB();
        d.setColor(stand);
        d.fillRectangle(startX + (gap1 * 5), startY + (gap * 22),width*9,height);
        d.fillRectangle(startX + (gap1 * 5), startY + (gap * 24),width*9,height);
        d.fillRectangle(startX + (gap1 * 5), startY + (gap * 23),width,height);
        d.fillRectangle(startX + (gap1 * 13), startY + (gap * 23),width,height);
        d.fillRectangle(startX + (gap1 * 9), startY + (gap * 8),width,height*4);
        d.fillRectangle(startX + (gap1 * 8), startY + (gap * 9),width,height);}
}
