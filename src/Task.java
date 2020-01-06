/**
 * Interface Task.
 *
 * @param <T> the type parameter
 * @author Karin Shimel.
 */
public interface Task<T> {
    /**
     * Run t.
     *
     * @return the t
     */
    T run();
}