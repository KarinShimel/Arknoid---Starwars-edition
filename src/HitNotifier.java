/**
 * Interface Hit notifier.
 *
 * @author karin .
 */
public interface HitNotifier {
    /**
     * Add a hit listener.
     *
     * @param hl the hl
     */
    void addHitListener(HitListener hl);

    /**
     * Remove a hit listener.
     *
     * @param hl the hl
     */
    void removeHitListener(HitListener hl);
}