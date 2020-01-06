import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Image;
import java.awt.Color;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.LineNumberReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;


/**
 * Class Menu animation.
 *
 * @author Karin Shimel.
 */
public class MenuAnimation implements Menu {
    private boolean stop;
    private String title;
    private Object status = null;
    private KeyboardSensor keyboard;
    private Map<String, String> selectionPrint;
    private Map<String, Object> selectionTask;
    private AnimationRunner animationRunner;
    private MenuAnimation subMenu;
    private Map<String, String> keyPath = new HashMap<>();
    private HighScoresTable highScoresTable;
    private String levelPath;

    /**
     * Constructor.
     * Creates a new Menu animation.
     *
     * @param menuTitle        the menu title
     * @param animationRunner1 the animation runner 1
     */
    public MenuAnimation(String menuTitle, AnimationRunner animationRunner1) {
        this.title = menuTitle;
        this.stop = false;
        this.keyboard = animationRunner1.getGui().getKeyboardSensor();
        this.animationRunner = animationRunner1;
        this.selectionPrint = new LinkedHashMap<>();
        this.selectionTask = new HashMap<>();
    }

    /**
     * Sets high scores table.
     *
     * @param highScoresTable1 the high scores table 1
     */
    public void setHighScoresTable(HighScoresTable highScoresTable1) {
        this.highScoresTable = highScoresTable1;
    }

    /**
     * Gets selection task.
     *
     * @return the selection task
     */
    public Map<String, Object> getSelectionTask() {
        return selectionTask;
    }

    /**
     * Sets selection print.
     *
     * @param selectionPrint1 the selection print
     */
    public void setSelectionPrint(Map<String, String> selectionPrint1) {
        this.selectionPrint = selectionPrint1;
    }

    /**
     * Gets high scores table.
     *
     * @return the high scores table
     */
    public HighScoresTable getHighScoresTable() {
        return highScoresTable;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets sub menu.
     *
     * @param subMenu1 the sub menu
     */
    public void setSubMenu(MenuAnimation subMenu1) {
        this.subMenu = subMenu1;
    }

    /**
     * Adding a selection to the menu.
     *
     * @param key       the key
     * @param message   the message
     * @param returnVal the return val
     */
    public void addSelection(String key, String message, Object returnVal) {
        this.selectionPrint.put(key, message);
        this.selectionTask.put(key, (returnVal));
    }

    /**
     * Gets selection print.
     *
     * @return the selection print
     */
    public Map<String, String> getSelectionPrint() {
        return selectionPrint;
    }

    /**
     * Getting the status.
     *
     * @return status
     */
    public Object getStatus() {
        return this.status;
    }

    /**
     * Gets key path.
     *
     * @return the key path
     */
    public Map<String, String> getKeyPath() {
        return keyPath;
    }

    /**
     * Set the path to the level set file.
     * @param keyPath1 .
     */
    public void setLevelPath(String keyPath1) {
        this.levelPath = keyPath1;
    }

    /**
     * Adding a submenu to our current menu.
     *
     * @param key      the key
     * @param message  the message
     * @param subMenu1 the sub menu
     */
    public void addSubMenu(String key, String message, Menu subMenu1) {
        Map<String, String> keyLevel = new HashMap<>();
        String line;
        BufferedReader reader;
        MenuAnimation subMenu2 = new MenuAnimation("Game Difficulty", animationRunner);
        InputStream is;
        try {
            is = ClassLoader.getSystemClassLoader().getResourceAsStream(this.levelPath);
            reader = new LineNumberReader(new BufferedReader(new InputStreamReader(is)));
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(":");
                ((MenuAnimation) subMenu2).getSelectionPrint().put(split[0], split[1]);
                line = reader.readLine();
                ((MenuAnimation) subMenu2).getKeyPath().put(split[0], line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, String> entry : ((MenuAnimation) subMenu2).getSelectionPrint().entrySet()) {
            subMenu2.addSelection(entry.getKey(), entry.getValue(), new TaskAnonymous(animationRunner) {
                public Void run() {
                    GameFlow gameFlow = new GameFlow(animationRunner);
                    gameFlow.setHighScores(highScoresTable);
                    String s = String.valueOf(subMenu2.keyPath.get(entry.getKey()));
                    File f = new File(s);
                    gameFlow.runLevels(gameFlow.readLevels(s));
                    return null;
                }
            });
        }
        this.subMenu = subMenu2;
        ((MenuAnimation) subMenu2).setHighScoresTable(this.highScoresTable);
    }

    /**
     * Gets sub menu.
     *
     * @return the sub menu
     */
    public Menu getSubMenu() {
        return subMenu;
    }

    /**
     * Doing one frame of the menu animation.
     *
     * @param d the draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        Image background = null;
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(
                "background_images/menubackground1.jpg");
        try {
            background = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        d.drawImage(0, 0, background);
        d.setColor(Color.WHITE);
        d.drawText(100, 120, this.title, 45);
        d.drawText(100, 150, "Star Wars Edition", 25);
        d.drawText(100, 270, "Please select an option: ", 23);
        int i = 0;
        for (Map.Entry<String, String> key : this.selectionPrint.entrySet()) {
            d.drawText(100, 300 + (i * 30), "(" + key.getKey() + ") " + key.getValue(), 20);
            i++;
        }
        for (String key : this.selectionPrint.keySet()) {
            if (this.keyboard.isPressed(key)) {
                this.stop = true;
                this.status = this.selectionTask.get(key);
            }
        }

    }

    /**
     * Sets status.
     *
     * @param status1 the status
     */
    public void setStatus(Object status1) {
        this.status = status1;
    }

    /**
     * Checking if the animation should stop.
     *
     * @return true/false.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
