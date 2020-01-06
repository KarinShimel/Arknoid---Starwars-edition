/**
 * interface Collidable.
 *
 * @author Karin Shimel.
 */
public interface Collidable {
    /**
     * Getting the collision's rectangle.
     *
     * @return Rectangle variable.
     */
    Rectangle getCollisionRectangle();

    /**
     * Getting the collision's rectangle.
     *
     * @param hitter          - the ball hitting the block.
     * @param collisionPoint  - the collision point.
     * @param currentVelocity - the ball's current velocity.
     * @return Velocity - the new velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}