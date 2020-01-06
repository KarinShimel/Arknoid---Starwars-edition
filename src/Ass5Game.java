import java.util.ArrayList;
import java.util.List;

/**
 * class Ass5Game.
 *
 * @author Karin Shimel
 */
public class Ass5Game {
    /**
     * Starting the game.
     * Setting a new game, initializing the game and running it.
     * @param args - the arguments.
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        levels.add(new DirectHit());
        levels.add(new WideEasy());
        levels.add( new Green3());
        levels.add(new FinalFour());
        GameFlow gameFlow = new GameFlow();
        gameFlow.runLevels(levels);
    }
}
