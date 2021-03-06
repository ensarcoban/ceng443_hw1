import java.util.Random;

import static java.lang.Math.abs;

public class ChaseClosest extends State {

    private double speedY;
    private double speedX;
    private Position destination;

    private GoldOrder closestOrder;

    public ChaseClosest(Corporation corporation) {
        super(corporation);
        this.setName("ChaseClosest");
    }

    /**
     * @return closest order to the corporation.
     */
    private Position getClosestGoldOrder() {
        // iterate through all gold orders and find the closest one
        double closestDistance = Double.MAX_VALUE;
        Position closestPosition = null;
        for (Order order : Common.getOrders()) {
            if (order instanceof GoldOrder && getCorporation().position.distanceTo(order.getPosition().getX(), order.getPosition().getY()) < closestDistance) {
                closestDistance = getCorporation().position.distanceTo(order.getPosition().getX(), order.getPosition().getY());
                closestPosition = new Position(order.getPosition().getX(), order.getPosition().getY());
                closestOrder = (GoldOrder) order;
            }
        }
        return closestPosition;
    }

    @Override
    public void update() {
        System.out.println(getCorporation().position.getY());
        Random random = new Random();
        this.destination = getClosestGoldOrder();
        if (destination != null) {
            if (destination.getY() < getCorporation().position.getY()) {
                this.speedY = random.nextInt(3) + 1;
            }
            else {
                this.speedY = -(random.nextInt(3) + 1);
            }
            this.speedX = this.speedY * ((getCorporation().position.getX() - destination.getX()) / (getCorporation().position.getY() - destination.getY()));

            if (abs(getCorporation().position.getY() - destination.getY()) < 50 && abs(getCorporation().position.getX() - destination.getX()) > 50) {
                this.speedX = this.speedX / 10;
                this.speedY = this.speedY / 10;
            }
            if (abs(getCorporation().position.getX() - destination.getX()) < 50 && abs(getCorporation().position.getY() - destination.getY()) > 50) {
                this.speedX = this.speedX / 10;
                this.speedY = this.speedY / 10;
            }

            // Chase end delete the object.
            if (getCorporation().position.distanceTo(destination.getX(), destination.getY()) < 50) {
                closestOrder.interact(this.getCorporation());
                Common.getOrdersToDelete().add(closestOrder);
                this.setStateComplete(true);
            }
            getCorporation().position.setY(getCorporation().position.getY() - speedY/5);
            getCorporation().position.setX(getCorporation().position.getX() - speedX/5);

        }
    }
}