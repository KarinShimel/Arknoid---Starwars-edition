import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class High scores animation.
 *
 * @author Karin Shimel.
 */
public class HighScoresAnimation implements Animation {
    private boolean stop;
    private HighScoresTable highScoresTable;
    private AnimationRunner runner;
    // Fields for the animation
    private int time = 1;
    private int flag = 0;

    /**
     * Creates a new High scores animation.
     *
     * @param scores          the scores
     * @param animationRunner the animation runner
     */
    public HighScoresAnimation(HighScoresTable scores, AnimationRunner animationRunner) {
        this.highScoresTable = scores;
        this.runner = animationRunner;
        this.stop = false;
    }

    /**
     * Doing one frame.
     *
     * @param d the draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, 800, 600);
        Image background, background1 = null;
        Image backgroundScaled = null;
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(
                "background_images/StarWarsLogo.png");
        InputStream is1 = ClassLoader.getSystemClassLoader().getResourceAsStream(
                "background_images/Space.jpg");
        try {
            background = ImageIO.read(is);
            background1 = ImageIO.read(is1);
            backgroundScaled = background.getScaledInstance(450, 150, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        d.drawImage(0, 0, background1);
        d.drawImage(175, 60, backgroundScaled);
        d.setColor(Color.black);
        d.fillRectangle(250, 210, 300, 600);
        d.setColor(Color.WHITE);
        d.drawText(290, 250, "High Scores", 40);
        this.drawTable(d);
        this.drawAnimation(d);
        if (this.runner.getGui().getKeyboardSensor().isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * Draw table.
     *
     * @param d the d
     */
    public void drawTable(DrawSurface d) {
        this.highScoresTable.sortScore();
        int x = 290;
        int startY = 300;
        int yGap = 30;
        int gap = 170;
        d.setColor(Color.WHITE);
        for (int i = 0; i < this.highScoresTable.getHighScores().size(); i++) {
            d.drawText(x, startY + (yGap * i), this.highScoresTable.getHighScores().get(i).getName(), 20);
            d.drawText(x + gap, startY + (yGap * i),
                    String.valueOf(this.highScoresTable.getHighScores().get(i).getScore()), 20);
        }
    }

    /**
     * Drawing the spaceships animation.
     *
     * @param d - the Draw surface.
     */
    private void drawAnimation(DrawSurface d) {
        Image background;
        Image backgroundScaled = null;
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(
                "animation_images/SpaceShip.png");
        try {
            background = ImageIO.read(is);
            backgroundScaled = background.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int gap = 4;
        if (flag == 0) {
            d.drawImage(10 + (this.time * gap), (this.time * gap), backgroundScaled);
            this.time = this.time + 1;
            if (690 - ((this.time) * gap) < 12) {
                flag = 1;
                this.time = 0;
            }
        } else if (flag == 1) {
            d.drawImage(800 - (this.time * gap), (this.time * gap), backgroundScaled);
            this.time = this.time + 1;
            if (690 - ((this.time) * gap) < 12) {
                flag = 2;
                this.time = 0;
            }
        } else if (flag == 2) {
            d.drawImage(800 - (this.time * gap), 600 - (this.time * gap), backgroundScaled);
            this.time = this.time + 1;
            if (690 - ((this.time) * gap) < 12) {
                flag = 0;
                this.time = 0;
            }
        }
    }


    /**
     * Checking when the animation should stop.
     *
     * @return true/false.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}