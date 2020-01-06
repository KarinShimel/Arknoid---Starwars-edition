
import java.util.List;
import java.util.ArrayList;

/**
 * class GameEnvironment.
 *
 * @author Karin Shimel
 */
public class GameEnvironment {
    private java.util.List<Collidable> colliList;

    /**
     * Constructor.
     * Setting the game environment.
     */
    public GameEnvironment() {
        this.colliList = new ArrayList<Collidable>();
    }

    /**
     * Adding collidable to the game environment.
     *
     * @param c - a collidable.
     */
    public void addCollidable(Collidable c) {
        this.colliList.add(c);
    }

    /**
     * Getting the collidables list.
     *
     * @return collidables list.
     */
    public java.util.List<Collidable> getColli() {
        return this.colliList;
    }

    /**
     * Setting the collidable list.
     *
     * @param colliList1 .
     */
    public void setColliList(List<Collidable> colliList1) {
        this.colliList = colliList1;
    }

    /**
     * The method checks the closest collision point to the beginning of
     * the line. If there is not collision, returning null.
     *
     * @param trajectory - the line representing the ball's trajectory.
     * @return Collision info - information about the closest collision found.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        // Creating the lists for intersections and the collidables
        List<Point> intersections = new ArrayList<Point>();
        List<Collidable> objects = new ArrayList<Collidable>();
        // If there are no collidables
        if (this.getColli().isEmpty()) {
            return null;
        }
        // A loop to create a list containing all the intersection points
        for (int i = 0; i < this.getColli().size(); i++) {
            Point flag = trajectory.closestIntersectionToStartOfLine(this.getColli().get(i).getCollisionRectangle());
            // If there is no collision point, we wont add it to the intersection list
            if (flag != null) {
                intersections.add(flag);
                objects.add(this.getColli().get(i));
            }
        }
        // If there are no intersections
        if (intersections.size() == 0) {
            return null;
        }
        /*
        Checking for the closest intersection, setting min intersection point
        and the closest object. Then checking the distance of each
        intersection point, and eventually returning the closest intersection.
        */
        Point closestP = intersections.get(0);
        double smallestDis = trajectory.start().distance(intersections.get(0));
        Collidable closestObject = objects.get(0);
        for (int i = 1; i < intersections.size(); i++) {
            if (trajectory.start().distance(intersections.get(i)) < smallestDis) {
                smallestDis = trajectory.start().distance(intersections.get(i));
                closestP = intersections.get(i);
                closestObject = objects.get(i);
            }
        }
        return new CollisionInfo(closestP, closestObject);
    }
}