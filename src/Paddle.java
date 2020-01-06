import java.awt.Color;
import java.util.Random;

import biuoop.KeyboardSensor;
import biuoop.DrawSurface;
import biuoop.GUI;

/**
 * class Paddle.
 *
 * @author Karin Shimel
 */
public class Paddle implements Sprite, Collidable {
    private KeyboardSensor keyboard;
    private Rectangle block;
    private int paddleSpeed;
    private double width;
    private java.awt.Color color;

    /**
     * Constructor.
     * Setting the paddle, creating its location and setting the relevant
     * variables it contains.
     * @param width1 the width.
     * @param speed1 the speed.
     */
    public Paddle(double width1, int speed1) {
        this.block = new Rectangle(new Point(400 - (width1 / 2), 555), width1, 20);
        this.width = width1;
        this.paddleSpeed = speed1;
        this.color = Color.white;
    }

    /**
     * get keyboard.
     *
     * @return keyboard. keyboard
     */
    public KeyboardSensor getKeyboard() {
        return keyboard;
    }

    /**
     * Method to return the width of the paddle.
     *
     * @return width - the width of the paddle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Method to set the keyboard sensor.
     *
     * @param gui - relevant gui.
     */
    public void setKeyboard(GUI gui) {
        this.keyboard = gui.getKeyboardSensor();
    }

    /**
     * Sets keyboard.
     *
     * @param keyboard1 the keyboard
     */
    public void setKeyboard(KeyboardSensor keyboard1) {
        this.keyboard = keyboard1;
    }

    /**
     * Gets speed.
     *
     * @return the speed
     */
    public int getSpeed() {
        return paddleSpeed;
    }

    /**
     * The action of moving left when the left arrow key is pressed,
     * we will move to the left if the paddle is not reaching the coundries.
     * Setting the new paddle rectangle according to the move.
     */
    public void moveLeft() {
        if (this.getCollisionRectangle().getUpperLeft().getX() > 25) {
            this.block = new Rectangle(new Point(this.getCollisionRectangle().getUpperLeft().getX() - this.getSpeed(),
                    this.getCollisionRectangle().getUpperLeft().getY()), this.getCollisionRectangle().getWidth(),
                    this.getCollisionRectangle().getHeight());
        }
    }

    /**
     * The action of moving right when the left arrow key is pressed,
     * we will move to the right if the paddle is not reaching the boundries.
     * Setting the new paddle rectangle according to the move.
     */
    public void moveRight() {
        if (this.getCollisionRectangle().getUpperRight().getX() < 775) {
            this.block = new Rectangle(new Point(
                    this.getCollisionRectangle().getUpperLeft().getX() + this.getSpeed(),
                    this.getCollisionRectangle().getUpperLeft().getY()),
                    this.getCollisionRectangle().getWidth(),
                    this.getCollisionRectangle().getHeight());
        }
    }

    /**
     * The time passed that is required by implementing sprite,
     * Checking if the arrow keys are pressed, if so directing to the
     * relevant method.
     */
    public void timePassed() {
        if (this.getKeyboard().isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (this.getKeyboard().isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * Returning the paddle's color.
     *
     * @return color. color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Method to draw the paddle on to the screen.
     *
     * @param d - the relevant draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.getColor());
        // Drawing the paddle
        d.fillRectangle(
                (int) (this.getCollisionRectangle().getUpperLeft().getX()),
                (int) (this.getCollisionRectangle().getUpperLeft().getY()),
                (int) (this.getCollisionRectangle().getWidth()),
                (int) (this.getCollisionRectangle().getHeight()));
        // Drawing the outlines
        d.setColor(Color.BLACK);
        this.getCollisionRectangle().getUp().drawLine(
                this.getCollisionRectangle().getUp(), d);
        this.getCollisionRectangle().getDown().drawLine(
                this.getCollisionRectangle().getDown(), d);
        this.getCollisionRectangle().getLeft().drawLine(
                this.getCollisionRectangle().getLeft(), d);
        this.getCollisionRectangle().getRight().drawLine(
                this.getCollisionRectangle().getRight(), d);
    }

    /**
     * Setting the color.
     *
     * @param color1 .
     */
    public void setColor(Color color1) {
        this.color = color1;
    }

    /**
     * The method that is required by implementing collidable,
     * returning the paddle's rectangle.
     *
     * @return block - the rectangle of the paddle.
     */
    public Rectangle getCollisionRectangle() {
        return this.block;
    }

    /**
     * Calculates the new velocity of the ball after the collision.
     * Dividing the paddle to 5 regions and checking accordingly.
     *
     * @param hitter          - the hitting ball.
     * @param collisionPoint  - the point of the collision.
     * @param currentVelocity - the ball's current velocity.
     * @return newVelo - the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // Changing the color if hit
        Random ran1 = new Random();
        int x = ran1.nextInt(6) + 70;
        Random ran2 = new Random();
        int x2 = ran2.nextInt(40) + 70;
        Random ran3 = new Random();
        int x3 = ran3.nextInt(100) + 600;
        Color color1 = Color.getHSBColor(x, x2, x3);
        this.setColor(color1);
        Velocity newVelo = currentVelocity;
        /*
        Since we need to split the paddle into 5 regions, we will calculate
        the new velocity for each region.
         */
        double region = (this.getWidth() / 5);
        Point paddleUpperLeft = this.getCollisionRectangle().getUpperLeft();
        Line[] regions = new Line[5];
        regions[0] = new Line(paddleUpperLeft.getX(), paddleUpperLeft.getY(),
                paddleUpperLeft.getX() + region, paddleUpperLeft.getY());
        for (int i = 1; i < 5; i++) {
            regions[i] = new Line((regions[i - 1].end().getX()),
                    (regions[i - 1].end().getY()),
                    (regions[i - 1].end().getX() + region),
                    (regions[i - 1].end().getY()));
        }
        if (this.getCollisionRectangle().getLeft().inLine(
                this.getCollisionRectangle().getLeft(), collisionPoint)
                || this.getCollisionRectangle().getRight().inLine(
                this.getCollisionRectangle().getRight(), collisionPoint)) {
            newVelo.setDx((-1) * (newVelo.getDx()));
        }
        // Calculating the current speed: sqrt((dx * dx) + (dy * dy))
        double speed = Math.sqrt((
                (currentVelocity.getDx() * currentVelocity.getDx())
                        + (currentVelocity.getDy() * currentVelocity.getDy())));
        // Checking region 1
        if (regions[0].inLine(regions[0], collisionPoint)) {
            newVelo = currentVelocity.fromAngleAndSpeed(300, speed);
            newVelo = new Velocity(
                    (newVelo.getDx()), (-1) * (newVelo.getDy()));
        }
        // Checking region 2
        if (regions[1].inLine(regions[1], collisionPoint)) {
            newVelo = currentVelocity.fromAngleAndSpeed(330, speed);
            newVelo = new Velocity(
                    (-1) * (newVelo.getDx()), (-1) * (newVelo.getDy()));
        }
        // Checking region 3
        if (regions[2].inLine(regions[2], collisionPoint)) {
            newVelo = new Velocity(
                    (newVelo.getDx()), (-1) * (newVelo.getDy()));
        }
        // Checking region 4
        if (regions[3].inLine(regions[3], collisionPoint)) {
            newVelo = currentVelocity.fromAngleAndSpeed(30, speed);
            newVelo = new Velocity(
                    (-1) * (newVelo.getDx()), (-1) * (newVelo.getDy()));
        }
        // Checking region 5
        if (regions[4].inLine(regions[4], collisionPoint)) {
            newVelo = currentVelocity.fromAngleAndSpeed(60, speed);
            newVelo = new Velocity(
                    (newVelo.getDx()), (-1) * (newVelo.getDy()));
        }
        return newVelo;
    }


    /**
     * Adding the paddle to the game, to the sprite collection and the
     * game's game environment.
     *
     * @param g - game.
     */
    public void addToGame(GameLevel g) {
        g.getSprites().addSprite(this);
        g.getEnvironment().addCollidable(this);
    }

    /**
     * Removing the paddle from the game.
     *
     * @param game .
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }
}