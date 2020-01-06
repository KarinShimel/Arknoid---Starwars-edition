import biuoop.DrawSurface;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Main class Ass 7 game.
 *
 * @author Karin Shimel.
 */
public class Ass7Game {
    /**
     * Starting the game.
     * Setting a new game flow, initializing the levels and running them.
     *
     * @param args - the arguments.
     */
    public static void main(String[] args) {
        // Setting the high score table
        HighScoresTable highScoresTable = new HighScoresTable(10);
        highScoresTable.loadFromFile(new File("highscores"));
        highScoresTable.sortScore();
        AnimationRunner animationRunner = new AnimationRunner();
        HighScoresAnimation highScoresAnimation = new HighScoresAnimation(highScoresTable, animationRunner);
        while (true) {
            // Setting the menu
            MenuAnimation menu = new MenuAnimation("Arkanoid", animationRunner);
            if (args.length == 0) {
                menu.setLevelPath("definitions/LevelSets.txt");
            } else {
                menu.setLevelPath(args[0]);
            }
            menu.addSubMenu("s", "Game Difficulty",
                    new MenuAnimation("Game Difficulty", animationRunner));
            menu.setHighScoresTable(highScoresTable);
            // Using an Anonymous class to redefine the run method
            menu.addSelection("s", "Start Game",
                    new TaskAnonymous(animationRunner) {
                        public Void run() {
                            animationRunner.run(((MenuAnimation) menu).getSubMenu());
                            Task<Void> task = (Task<Void>) menu.getSubMenu().getStatus();
                            task.run();
                            return null;
                        }
                    });
            menu.addSelection("h", "High Scores",
                    new ShowHiScoresTask(animationRunner, highScoresAnimation));
            // Using an Anonymous class to redefine the run method
            menu.addSelection("q", "Exit",
                    new TaskAnonymous(animationRunner) {
                        public Void run() {
                            // Showing a picture before exiting the game
                            animationRunner.run(new CountdownAnimation(
                                    60, 2, null) {
                                public void doOneFrame(DrawSurface d) {
                                    d.setColor(Color.BLACK);
                                    d.fillRectangle(0, 0, 800, 600);
                                    Image background = null;
                                    InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(
                                            "background_images/Bye.jpg");
                                    try {
                                        background = ImageIO.read(is);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    d.drawImage(0, 0, background);
                                    // Using the sleeper if its not the first number displayed
                                    if (this.getAppearanceTime() != this.getNumOfSeconds() / this.getCountFrom()) {
                                        this.getSleeper().sleepFor(((long) this.getAppearanceTime() / 1000 + 760));
                                    }
                                    this.setCountFrom(this.getCountFrom() - 1);
                                }
                            });
                            System.exit(0);
                            return null;
                        }
                    });
            animationRunner.run(menu);
            Task<Void> task = (Task<Void>) menu.getStatus();
            task.run();
        }
    }
}
