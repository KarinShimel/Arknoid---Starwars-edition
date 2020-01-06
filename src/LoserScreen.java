import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.*;

public class LoserScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private ScoreTrackingListener score;
    public LoserScreen(KeyboardSensor k, ScoreTrackingListener score1) {
        this.keyboard = k;
        this.stop = false;
        this.score = score1;
    }
    public void doOneFrame(DrawSurface d) {
        this.drawOn(d);
        d.setColor(Color.WHITE);
        //d.drawText(340, 430, "Hi Loser" , 35);
        d.drawText(320, 460, "Your Score: " + this.score.getCurrentScore().getAmount(), 28);
        d.drawText(300, 490, "press space to continue", 20);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
    public void drawOn(DrawSurface d) {
        int startX = 35;
        int startY = 45;
        int width = 25;
        int height = 20;
        int gap1 = 25;
        int gap = 20;
        Color back = new Color(0xFF151E2B, true);
        back.getRGB();
        d.setColor(back);
        d.fillRectangle(0, 0, 800, 600);
        Color rect = new Color(0xFFF4F1FC, true);
        rect.getRGB();
        d.setColor(rect);
        d.fillRectangle(startX + (gap1 * 4), startY ,width*21,height*16);
        Color text = new Color(0xFF395D54, true);
        text.getRGB();
        d.setColor(text);
        // G
        d.fillRectangle(startX + (gap1 * 5), startY + (gap * 2),width,height*4);
        d.fillRectangle(startX + (gap1 * 8), startY + (gap * 3),width,height*4);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap),width*3,height);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap*6),width*3,height);
        d.fillRectangle(startX + (gap1 * 7), startY + (gap*3),width,height);
        // A
        d.fillRectangle(startX + (gap1 * 10), startY + (gap * 2),width,height*5);
        d.fillRectangle(startX + (gap1 * 13), startY + (gap * 2),width,height*5);
        d.fillRectangle(startX + (gap1 * 11), startY + (gap),width*2,height);
        d.fillRectangle(startX + (gap1 * 11), startY + (gap * 4),width*2,height);
        // M
        d.fillRectangle(startX + (gap1 * 15), startY + (gap),width,height*6);
        d.fillRectangle(startX + (gap1 * 19), startY + (gap),width,height*6);
        d.fillRectangle(startX + (gap1 * 16), startY + (gap*2),width,height);
        d.fillRectangle(startX + (gap1 * 18), startY + (gap*2),width,height);
        d.fillRectangle(startX + (gap1 * 17), startY + (gap*3),width,height);
        // E
        d.fillRectangle(startX + (gap1 * 21), startY + (gap),width,height*6);
        d.fillRectangle(startX + (gap1 * 22), startY + (gap),width*2,height);
        d.fillRectangle(startX + (gap1 * 22), startY + (gap * 3),width*2,height);
        d.fillRectangle(startX + (gap1 * 22), startY + (gap * 6),width*2,height);
        // O
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 9),width*2,height);
        d.fillRectangle(startX + (gap1 * 6), startY + (gap * 14),width*2,height);
        d.fillRectangle(startX + (gap1 * 5), startY + (gap * 10),width,height*4);
        d.fillRectangle(startX + (gap1 * 8), startY + (gap * 10),width,height*4);
        // V
        d.fillRectangle(startX + (gap1 * 10), startY + (gap * 9),width,height*4);
        d.fillRectangle(startX + (gap1 * 14), startY + (gap * 9),width,height*4);
        d.fillRectangle(startX + (gap1 * 11), startY + (gap*13),width,height);
        d.fillRectangle(startX + (gap1 * 12), startY + (gap*14),width,height);
        d.fillRectangle(startX + (gap1 * 13), startY + (gap*13),width,height);
        // E
        d.fillRectangle(startX + (gap1 * 16), startY + (gap*9),width,height*6);
        d.fillRectangle(startX + (gap1 * 17), startY + (gap*9),width*2,height);
        d.fillRectangle(startX + (gap1 * 17), startY + (gap*11),width*2,height);
        d.fillRectangle(startX + (gap1 * 17), startY + (gap*14),width*2,height);
        // R
        d.fillRectangle(startX + (gap1 * 20), startY + (gap*9),width,height*6);
        d.fillRectangle(startX + (gap1 * 23), startY + (gap*9),width,height*3);
        d.fillRectangle(startX + (gap1 * 23), startY + (gap*13),width,height*2);
        d.fillRectangle(startX + (gap1 * 21), startY + (gap*9),width*2,height);
        d.fillRectangle(startX + (gap1 * 21), startY + (gap*12),width*2,height);
    }
}
