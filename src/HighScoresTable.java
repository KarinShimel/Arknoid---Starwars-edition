import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

import java.util.List;

/**
 * The type High scores table.
 */
public class HighScoresTable {
    private List<ScoreInfo> scores;
    private int size;

    /**
     * Constructor.
     * Creates a new High scores table.
     *
     * @param size1 the size 1
     */
    public HighScoresTable(int size1) {
        this.scores = new ArrayList<ScoreInfo>(size);
        this.size = size1;
    }

    /**
     * Add.
     *
     * @param score the score
     */
    public void add(ScoreInfo score) {
        if (this.scores.size() < this.size) {
            this.scores.add(score);
        } else {
            this.sortScore();
            if (this.scores.get(this.size - 1).getScore() < score.getScore()) {
                this.scores.remove(this.size - 1);
                this.scores.add(score);
            }
        }
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return this.size;
    }

    /**
     * Gets high scores.
     *
     * @return the high scores
     */
    public List<ScoreInfo> getHighScores() {
        this.sortScore();
        return this.scores;
    }

    /**
     * Sort score.
     */
    public void sortScore() {
        ScoreInfo[] arr = new ScoreInfo[this.scores.size()];
        int i = 0;
        for (ScoreInfo highScore : scores) {
            arr[i] = highScore;
            i++;
        }
        arr = bubbleSort(arr);
        List<ScoreInfo> scoreInfo = new ArrayList<>();
        for (int j = 0; j < this.scores.size(); j++) {
            scoreInfo.add(arr[j]);
        }
        this.setScores(scoreInfo);
    }

    /**
     * Sets scores.
     *
     * @param scores1 the scores
     */
    public void setScores(List<ScoreInfo> scores1) {
        this.scores = scores1;
    }

    /**
     * Gets rank.
     *
     * @param score the score
     * @return the rank
     */
    public int getRank(int score) {
        int i = 1;
        this.sortScore();
        for (ScoreInfo highScore : this.getHighScores()) {
            if (score > highScore.getScore()) {
                return i;
            } else {
                i++;
            }
        }
        return i;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Clears the table.
     */
    public void clear() {
        this.scores = new ArrayList<ScoreInfo>(this.size);
    }

    /**
     * Loads the table from a file.
     *
     * @param filename the filename
     * @throws IOException the io exception
     */
    public void load(File filename) throws IOException {
        List<ScoreInfo> scoreInfos = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                ScoreInfo scoreInfo = new ScoreInfo(parts[0], Integer.parseInt(parts[1]));
                scoreInfos.add(scoreInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (reader != null) {
            reader.close();
        }
        this.setScores(scoreInfos);
    }

    /**
     * Saving the data into a file.
     *
     * @param filename the filename
     * @throws IOException the io exception
     */
    public void save(File filename) throws IOException {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filename)));
            for (int i = 0; i < this.scores.size(); i++) {
                printIt(this.scores.get(i), printWriter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (printWriter != null) {
            printWriter.close();
        }
    }

    /**
     * Load from a file, or create a new empty table.
     *
     * @param filename the filename
     * @return the high scores table
     */
    public HighScoresTable loadFromFile(File filename) {
        List<ScoreInfo> scoreInfos = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                ScoreInfo scoreInfo = new ScoreInfo(parts[0], Integer.parseInt(parts[1]));
                scoreInfos.add(scoreInfo);
            }
            reader.close();
        } catch (IOException e) {
            return new HighScoresTable(this.size);
        }
        this.setScores(scoreInfos);
        return this;
    }

    /**
     * Print it method to print the score info to the file.
     *
     * @param scoreInfo the score info
     * @param p         the p
     */
    public static void printIt(ScoreInfo scoreInfo, PrintWriter p) {
        p.print(scoreInfo.getName());
        p.print(";");
        p.println(scoreInfo.getScore());
    }


    /**
     * Bubble sort method to sort the high scores.
     *
     * @param arr the arr
     * @return the score info [ ]
     */
    public ScoreInfo[] bubbleSort(ScoreInfo[] arr) {
        int n = this.scores.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].getScore() < arr[j + 1].getScore()) {
                    // swap arr[j+1] and arr[i]
                    ScoreInfo temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
