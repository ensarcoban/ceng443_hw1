public abstract class GoldOrder extends Order {
    public GoldOrder(double x, double y, Country sourceCountry) {
        super(x, y, sourceCountry);
    }


    /**
     * This function handles corporation gold order interaction logic.
     * @param corporation is the variable that is interacted with the gold order.
     *
     */
    public abstract void interact(Corporation corporation);
}