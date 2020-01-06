/**
 * class CollisionInfo.
 *
 * @author Karin Shimel.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * Constructor.
     * Setting the collision parameters.
     *
     * @param collisionPoint1 - the collision point.
     * @param object          - the collision object.
     */
    public CollisionInfo(Point collisionPoint1, Collidable object) {
        this.collisionPoint = collisionPoint1;
        this.collisionObject = object;
    }

    /**
     * Returning the collision point.
     *
     * @return collision point.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * Constructor.
     * Setting the collision parameters.
     *
     * @return object - the object of the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}