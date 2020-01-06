/**
 * Class Counter.
 *
 * @author Karin Shimel.
 */
public class Counter {
    private int amount;

    /**
     * Constructor (1).
     * Creates a new Counter.
     */
    public Counter() {
        this.amount = 0;
    }

    /**
     * Constructor (2).
     * Creates a new Counter.
     *
     * @param amount1 the amount 1
     */
    public Counter(int amount1) {
        this.amount = amount1;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount1 the amount 1
     */
    public void setAmount(int amount1) {
        this.amount = amount1;
    }

    /**
     * Increase the amount of the counter by the number given.
     *
     * @param number the number
     */
    void increase(int number) {
        this.setAmount(this.getAmount() + number);
    }

    /**
     * Decrease the amount of the counter by the number given.
     *
     * @param number the number
     */
    void decrease(int number) {
        this.setAmount(this.getAmount() - number);
    }
}