import biuoop.DrawSurface;

/**
 * class Ball.
 *
 * @author Karin Shimel .
 */
public class Ball implements Sprite {

    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity v;
    // The points representing the limits of the window
    private Point leftUpBound;
    private Point rightDownBound;
    private GameEnvironment gameEnvironment;

    /**
     * Constructor(1).
     * Setting the ball, creating the center point out of x,y and setting the
     * matching values.
     *
     * @param x     - x value of the center point
     * @param y     - y value of the center point.
     * @param r     - r is the value of the radius of the ball.
     * @param color - color of the ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.radius = r;
        this.color = color;
        setVelocity(1, 1);
    }

    /**
     * Constructor(2).
     * Setting the ball, setting the matching values.
     *
     * @param center - center point.
     * @param r      - r radius of the ball.
     * @param color  - color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
        setVelocity(1, 1);
    }

    /**
     * The method returns the integer value of the center's x value.
     *
     * @return integer value of the center's x.
     */
    public double getX() {
        return this.center.getX();
    }

    /**
     * The method returns the integer value of the center's y value.
     *
     * @return integer value of the center's y.
     */
    public double getY() {
        return (double) this.center.getY();
    }

    /**
     * The method returns the value of the radius of the ball.
     *
     * @return integer value of the ball's radius.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * The method returns the color of the ball.
     *
     * @return java.awt.Color - color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Drawing the ball on the given DrawSurface.
     *
     * @param surface - the draw surface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillCircle((int) (this.getX()), (int) (this.getY()), this.getSize());
    }

    /**
     * Method required by the sprite interface, implementing the ball's
     * behavior when time ad passed, activating moveOneStep method.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Setting the velocity of the ball.
     *
     * @param v1 - the desired velocity.
     */
    public void setVelocity(Velocity v1) {
        this.v = v1;
    }

    /**
     * Setting the velocity of the ball, by getting the dx,dy - the
     * change in x, the change in y, and setting the velocity.
     *
     * @param dx - the change in x.
     * @param dy - the change in y.
     */
    public void setVelocity(double dx, double dy) {
        Velocity v1 = new Velocity(dx, dy);
        this.v = v1;
    }

    /**
     * The method returns the velocity of the ball.
     *
     * @return v - velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * The method returns the left up boundary of the ball.
     *
     * @return left up boundary of the ball.
     */
    public Point getLeftUpBound() {
        return this.leftUpBound;
    }

    /**
     * The method returns the right down boundary of the ball.
     *
     * @return right down boundary of the ball.
     */
    public Point getRightDownBound() {
        return this.rightDownBound;
    }

    /**
     * Getting the ball's game environment.
     *
     * @return gameEnvironment - the ball's game environment.
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     * The method sets the left up boundary of the ball.
     * By using the boundary we can check how much can our ball
     * travel in the given window.
     *
     * @param limit - left up boundary of the ball.
     */
    public void setLeftUpBound(Point limit) {
        this.leftUpBound = limit;
    }

    /**
     * The method sets the right down boundary of the ball.
     * By using the boundary we can check how much can our ball
     * travel in the given window.
     *
     * @param limit - right down boundary of the ball.
     */
    public void setRightDownBound(Point limit) {
        this.rightDownBound = limit;
    }

    /**
     * Setting the ball's game environment.
     *
     * @param game - right down boundary of the ball.
     */
    public void setGameEnvironment(GameEnvironment game) {
        this.gameEnvironment = game;
    }

    /**
     * Adding the ball to the game, by adding it to the sprite collection
     * and setting it's game environment.
     *
     * @param g - relevant game.
     */
    public void addToGame(GameLevel g) {
        g.getSprites().addSprite(this);
        this.setGameEnvironment(g.getEnvironment());
    }

    /**
     * Removing the ball from the game.
     *
     * @param game - the Game class.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }

    /**
     * The method is used each time the ball travels in the window.
     * First making a check to see if the ball reached the borders of the
     * window, if so - adjusting the velocity ( correcting the dx/ dy )
     * accordingly, and returning the new velocity. If the ball hasn't reached
     * the limits of the window, it will keep with the current velocity
     * untouched.
     */
    public void moveOneStep() {
        // Setting the trajectory line - round to eliminate cases where double value misses the collision
        Point start = new Point(Math.round(this.getX()),
                Math.round(this.getY()));
        Point end = new Point(Math.round(this.getVelocity().applyToPoint(start).getX()),
                Math.round(this.getVelocity().applyToPoint(start).getY()));
        Line trajectory = new Line(start, end);
        // Setting the gap from the exact collision
        double hitGap = 1;
        // Finding the collision point
        CollisionInfo collision =
                this.gameEnvironment.getClosestCollision(trajectory);
        // If the trajectory has a collision with any collidable objects
        if (collision != null) {
            // Setting the new velocity
            Velocity newVelocity = collision.collisionObject().hit(this,
                    collision.collisionPoint(), this.getVelocity());
            this.setVelocity(newVelocity);
            /*
            Checking for the 'almost' collision point.
            First, if the collision x is before the current center x
             */
            if (collision.collisionPoint().getX() < this.center.getX()) {
                if (collision.collisionPoint().getY() > this.center.getY()) {
                    this.center = new Point(
                            collision.collisionPoint().getX() + hitGap,
                            collision.collisionPoint().getY() - hitGap);
                } else {
                    this.center = new Point(collision.collisionPoint().getX()
                            + hitGap, collision.collisionPoint().getY()
                            + hitGap);
                }
            } else {
                // The collision x is after the current center x
                if (collision.collisionPoint().getY() > this.center.getY()) {
                    this.center = new Point(
                            collision.collisionPoint().getX() - hitGap,
                            collision.collisionPoint().getY() - hitGap);
                } else {
                    this.center = new Point(
                            collision.collisionPoint().getX() - hitGap,
                            collision.collisionPoint().getY() + hitGap);
                }
            }
        } else {
            // If the ball didn't reach any of the boundaries or collidables
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }
}