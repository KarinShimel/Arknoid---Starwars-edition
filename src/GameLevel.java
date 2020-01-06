
import java.awt.Image;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import javax.imageio.ImageIO;

/**
 * Class Game Level.
 *
 * @author Karin Shimel.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private ScoreTrackingListener score;
    private Paddle paddle;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation level;
    private LivesIndicator lives;
    // Data for the animation in the last level
    private int time = 1;
    private int flag = 0;


    /**
     * Constructor.
     * Creates a new Game level.
     *
     * @param level1         the level 1
     * @param keyboardSensor the keyboard sensor
     * @param runner1        the runner 1
     * @param livesIndicator the lives indicator
     * @param score1         the score 1
     */
    public GameLevel(LevelInformation level1, KeyboardSensor keyboardSensor, AnimationRunner runner1,
                     LivesIndicator livesIndicator, ScoreTrackingListener score1) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.level = level1;
        this.keyboard = keyboardSensor;
        this.runner = runner1;
        this.score = score1;
        this.lives = livesIndicator;
    }

    /**
     * Adding a collidable to the game environment.
     *
     * @param c - a collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Adding a sprite to the sprite collection.
     *
     * @param s - a collidable.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Gets lives.
     *
     * @return the lives
     */
    public LivesIndicator getLives() {
        return lives;
    }

    /**
     * Getting the game's gui.
     *
     * @return gui - game's gui.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * Setting the game's gui.
     *
     * @param gui1 - game's gui.
     */
    public void setGui(GUI gui1) {
        this.gui = gui1;
    }

    /**
     * Getting the sprite collection.
     *
     * @return Sprite collection.
     */
    public SpriteCollection getSprites() {
        return sprites;
    }

    /**
     * Getting the game environment.
     *
     * @return Game Environment - all the collidables.
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * Sets the GameEnvironment.
     *
     * @param environment1 the environment
     */
    public void setEnvironment(GameEnvironment environment1) {
        this.environment = environment1;
    }

    /**
     * Sets the SpriteCollection.
     *
     * @param sprites1 the sprites
     */
    public void setSprites(SpriteCollection sprites1) {
        this.sprites = sprites1;
    }

    /**
     * Remove collidable from the game.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        java.util.List<Collidable> colliList = this.getEnvironment().getColli();
        colliList.remove(c);
        GameEnvironment game = new GameEnvironment();
        game.setColliList(colliList);
        this.setEnvironment(game);
    }

    /**
     * Remove sprite from the game.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        java.util.List<Sprite> sprites1 = this.getSprites().getSprites();
        sprites1.remove(s);
        SpriteCollection newSprites = new SpriteCollection();
        newSprites.setSprites(sprites1);
        this.setSprites(newSprites);

    }

    /**
     * Sets block remover.
     *
     * @param blockRemover1 the block remover
     */
    public void setBlockRemover(BlockRemover blockRemover1) {
        this.blockRemover = blockRemover1;
    }

    /**
     * Gets block remover.
     *
     * @return the block remover
     */
    public BlockRemover getBlockRemover() {
        return blockRemover;
    }

    /**
     * Gets ball remover.
     *
     * @return the ball remover
     */
    public BallRemover getBallRemover() {
        return ballRemover;
    }

    /**
     * Sets ball remover.
     *
     * @param ballRemover1 the ball remover
     */
    public void setBallRemover(BallRemover ballRemover1) {
        this.ballRemover = ballRemover1;
    }

    /**
     * Gets the score.
     *
     * @return the score
     */
    public ScoreTrackingListener getScore() {
        return score;
    }

    /**
     * Sets the score.
     *
     * @param score1 the score
     */
    public void setScore(ScoreTrackingListener score1) {
        this.score = score1;
    }

    /**
     * Gets keyboard.
     *
     * @return the keyboard
     */
    public KeyboardSensor getKeyboard() {
        return keyboard;
    }

    /**
     * Gets runner.
     *
     * @return the runner
     */
    public AnimationRunner getRunner() {
        return runner;
    }

    /**
     * Sets runner.
     *
     * @param runner1 the runner
     */
    public void setRunner(AnimationRunner runner1) {
        this.runner = runner1;
    }

    /**
     * Gets level.
     *
     * @return the level
     */
    public LevelInformation getLevel() {
        return level;
    }

    /**
     * Initializing the game, Setting balls, blocks and the paddle.
     * Adding each to the game.
     */
    public void initialize() {
        // Setting the background as the first sprite
        this.addSprite(this.getLevel().getBackground());
        this.addSprite(this.lives);
        // Setting the bounds
        Block upBound = new Block(new Rectangle(new Point(0, 20), 800, 25), 0);
        Block downBound = new Block(new Rectangle(new Point(24, 599), 777, 15), 0);
        Block leftBound = new Block(new Rectangle(new Point(0, 45), 25, 555), 0);
        Block rightBound = new Block(new Rectangle(new Point(775, 45), 25, 555), 0);
        Fill fill = new Fill();
        fill.setColor(Color.black);
        upBound.setFill(fill);
        downBound.setFill(fill);
        leftBound.setFill(fill);
        rightBound.setFill(fill);
        upBound.setStroke(Color.BLACK);
        downBound.setStroke(Color.BLACK);
        leftBound.setStroke(Color.BLACK);
        rightBound.setStroke(Color.BLACK);
        upBound.setBorder(true);
        downBound.setBorder(true);
        leftBound.setBorder(true);
        rightBound.setBorder(true);
        List<Block> bounds = new ArrayList<>();
        bounds.add(upBound);
        bounds.add(downBound);
        bounds.add(leftBound);
        bounds.add(rightBound);
        upBound.addToGame(this);
        downBound.addToGame(this);
        leftBound.addToGame(this);
        rightBound.addToGame(this);
        // Setting the ball remover to follow the down border block if its hit
        this.setBallRemover(new BallRemover(this, this.getLevel().numberOfBalls()));
        downBound.addHitListener(this.getBallRemover());
        // Setting the block remover
        this.setBlockRemover(new BlockRemover(this, new Counter(this.getLevel().numberOfBlocksToRemove())));
        // Adding the blocks
        List<Block> blocks = this.getLevel().blocks();
        // Adding all the blocks to the game and setting the listener
        for (Block b1 : blocks) {
            b1.addToGame(this);
            b1.addHitListener(this.getBlockRemover());
        }
        // Creating the score listener and indicator
        this.getBlockRemover().addHitListener(this.getScore());
        ScoreIndicator score1 = new ScoreIndicator(this.getScore());
        this.addSprite(score1);
    }

    /**
     * Creating balls on top of the paddle by using the level's requirements.
     * Locating the balls in a specific location so that if there are an uneven number of balls
     * there will be a ball in the middle of the screen, and the rest will be divided evenly to
     * each side.
     */
    public void createBallsOnTopOfPaddle() {
        this.getBallRemover().setRemainingBalls(new Counter(this.getLevel().numberOfBalls()));
        // Setting the balls
        if (this.getLevel().numberOfBalls() == 1) {
            Ball ball = new Ball(400, 400, 5, Color.WHITE);
            ball.setVelocity((this.level.initialBallVelocities().get(0)));
            ball.addToGame(this);
            ball.setRightDownBound(new Point(775, 575));
            ball.setLeftUpBound(new Point(25, 45));
            return;
        }
        int gap = 300 / this.getLevel().numberOfBalls();
        int ygap = -20;
        int x = 380 - (gap * (this.getLevel().numberOfBalls() / 2));
        for (int i = 0; i < (this.getLevel().numberOfBalls() / 2); i++) {
            Ball ball = new Ball(x + (gap * i), 400 + (ygap * i), 5, Color.white);
            ball.setVelocity((this.level.initialBallVelocities().get(i)));
            ball.addToGame(this);
        }
        int helper = (this.getLevel().numberOfBalls() / 2);
        x = 400 + (400 - (x + (gap * ((this.getLevel().numberOfBalls() / 2) - 1))));
        int y = 400 + (ygap * ((this.getLevel().numberOfBalls() / 2) - 1));
        // If there is an uneven number of balls - placing a ball in the middle
        if (this.getLevel().numberOfBalls() % 2 != 0) {
            Ball ball = new Ball(400, y, 5, Color.white);
            ball.setVelocity((this.level.initialBallVelocities().get(helper)));
            ball.addToGame(this);
            helper++;
        }
        ygap = 20;
        for (int j = 0; j < (this.getLevel().numberOfBalls() / 2); j++) {
            Ball ball = new Ball(x + (gap * j), y + (ygap * j), 5, Color.white);
            ball.setVelocity((this.level.initialBallVelocities().get(helper)));
            ball.addToGame(this);
            helper++;
        }
    }

    /**
     * Playing one turn of the game.
     */
    public void playOneTurn() {
        // Resetting the paddle
        Paddle paddle1 = new Paddle(this.getLevel().paddleWidth(), this.getLevel().paddleSpeed());
        paddle1.setKeyboard(this.getKeyboard());
        paddle1.addToGame(this);
        this.paddle = paddle1;
        // Animation cheat
        if (this.level.levelName().equals("VI")) {
            this.runner.run(new CountdownAnimation(60, 2, this.getSprites()) {
                @Override
                public void doOneFrame(DrawSurface d) {
                    d.setColor(Color.BLACK);
                    d.fillRectangle(0, 0, 800, 600);
                    Image background = null;
                    try {
                        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(
                                "background_images/darth.jpg");
                        background = ImageIO.read(is);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    d.drawImage(0, 0, background);
                    d.setColor(Color.WHITE);
                    d.drawText(180, 250, "To cheat,", 25);
                    d.drawText(210, 300, "press a", 25);
                    // Using the sleeper if its not the first number displayed
                    if (this.getAppearanceTime() != this.getNumOfSeconds() / this.getCountFrom()) {
                        this.getSleeper().sleepFor(((long) this.getAppearanceTime() / 1000 + 760));
                    }
                    this.setCountFrom(this.getCountFrom() - 1);
                }
            });
        }
        // Running the countdown
        this.runner.run(new CountdownAnimation(60, 3, this.getSprites()));
        this.createBallsOnTopOfPaddle();
        this.running = true;
        // Running one turn of the game
        this.getRunner().run(this);
    }

    /**
     * A method to run the game.
     * Playing each turn if the life count is above 0.
     * When the lives end, exiting the game.
     */
    public void run() {
        this.addSprite(this.lives);
        while (this.lives.getCounter().getAmount() > 0) {
            playOneTurn();
        }
        this.getRunner().getGui().close();
    }

    /**
     * Doing one frame of the animation.
     *
     * @param d the draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        // If the player wishes to pause
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.runner.getGui().getKeyboardSensor(),
                    this.runner.getGui().getKeyboardSensor().SPACE_KEY,
                    new PauseScreen(this.runner.getGui().getKeyboardSensor())));
        }
        if (this.keyboard.isPressed("a")) {
            this.getBallRemover().getRemainingBalls().increase(1);
            Ball ball = new Ball(
                    (int) (this.paddle.getCollisionRectangle().findRecMid().getX()), 550, 5, Color.white);
            ball.setVelocity(0, -5);
            ball.addToGame(this);
        }
        if (this.level.levelName().equals("Final War")) {
            drawAttackAnimation(d);
        }

    }

    /**
     * Drawing the attack animation in the last level.
     *
     * @param d .
     */
    private void drawAttackAnimation(DrawSurface d) {
        Image background = null, background1 = null, background2 = null;
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream(
                "animation_images/Darth.png");
        InputStream is1 = ClassLoader.getSystemClassLoader().getResourceAsStream(
                "animation_images/stormtrooper.png");
        InputStream is2 = ClassLoader.getSystemClassLoader().getResourceAsStream(
                "animation_images/obi.png");
        try {
            background = ImageIO.read(is);
            background1 = ImageIO.read(is1);
            background2 = ImageIO.read(is2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int gap = 3;
        if (flag == 2) {
            return;
        }
        int helpTime = this.time;
        if (this.time == 0) {
            flag = 0;
            this.time = 0;
        }
        if (this.time > 230) {
            flag = 1;
            this.time = 1;
        }
        int timing = 30;
        // Drawing the images
        for (int i = 0; i < 6; i++) {
            if (this.time > timing && flag == 0) {
                d.drawImage(10 + (this.time * gap) - (40 * (i + 1)), 540, background1);
            }
            timing = timing + 10;
        }
        if (flag == 0) {
            d.drawImage(10 + (this.time * gap), 520, background);
            this.time = helpTime + 1;
        } else if (flag == 1) {
            d.drawImage(690 - ((this.time) * gap), 520, background2);
            this.time = this.time + 1;
            if (690 - ((this.time) * gap) < 25) {
                flag = 2;
                this.time = 0;
            }
        }
        // Drawing the text
        if (this.time > 30 && this.time < 80) {
            if (flag == 0) {
                d.setColor(Color.black);
                d.fillRectangle(10 + ((this.time) * gap) + 70, 525, 60, 20);
                d.setColor(Color.white);
                d.drawText(10 + ((this.time) * gap) + 80, 540, "Attack", 15);
            } else {
                d.setColor(Color.black);
                d.fillRectangle(690 - ((this.time) * gap) - 40, 525, 60, 20);
                d.setColor(Color.white);
                d.drawText(690 - ((this.time) * gap) - 30, 540, "Whutt", 15);
            }
        }

    }

    /**
     * Checking the conditions to determine if the animation needs to stop.
     *
     * @return true / false .
     */
    public boolean shouldStop() {
        // If all the blocks were removed
        if (this.getBlockRemover().getRemainingBlocks().getAmount() == 0) {
            this.paddle.removeFromGame(this);
            return true;
        }
        // If all the balls were removed
        if (this.getBallRemover().getRemainingBalls().getAmount() == 0) {
            this.paddle.removeFromGame(this);
            this.lives.getCounter().decrease(1);
            return true;
        }
        return false;
    }
}