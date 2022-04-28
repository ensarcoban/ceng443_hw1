import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public abstract class Order extends Entity {

    private int amount;
    private double speedY;
    private double speedX;
    private Position destination;

    private Country sourceCountry;

    /**
     * Random destination and random speed is set in this constructor.
     * Reference given to sourceCountry.
     * @param x horizontal position of order.
     * @param y vertical position of order.
     * @param sourceCountry is country that produced @this object.
     */
    public Order(double x, double y, Country sourceCountry) {
        super(x, y);
        Random random = new Random();
        this.destination = new Position(random.nextInt(1920), 100);
        this.amount = random.nextInt(5) + 1;
        this.speedY = random.nextInt(5) + 1;
        this.speedX = this.speedY * ((position.getX() - destination.getX()) / (position.getY() - destination.getY()));
        this.sourceCountry = sourceCountry;
    }

    @Override
    public void draw(Graphics2D g2d) {
        Ellipse2D.Double circle = new Ellipse2D.Double(position.getIntX(), position.getIntY(), 24, 24);
        g2d.fill(circle);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Verdana", Font.PLAIN, 18));
        g2d.drawString(String.valueOf(amount), position.getIntX()+7, position.getIntY()+20);
    }

    @Override
    public void step() {
        position.setY(position.getY() - getSpeedY()/5);
        position.setX(position.getX() - getSpeedX()/5);

        if (position.getY() <= Common.getHorizontalLineY()) {
            executeOrder();
            Common.getOrdersToDelete().add(this);
        }
    }

    /**
     * @return amount
     */
    public int getAmount() {
        return amount;
    }

    public double getSpeedY() {
        return speedY;
    }

    public double getSpeedX() {
        return speedX;
    }


    public Position getDestination() {
        return destination;
    }

    public Country getSourceCountry() {
        return sourceCountry;
    }


    /**
     * This function is used in Country class. That way, country objects creates orders,
     * but they don't know type of the order.
     * @param sourceCountry is the country that creates the order
     */
    public static void orderFactory(Country sourceCountry) {
        Random random = new Random();
        Order order;
        int randInt;
        if (sourceCountry.getHappiness() <= 50) {
            randInt = random.nextInt(2);
            if (randInt == 0) {
                order = new ElectronicsOrder(sourceCountry.position.getX(), sourceCountry.position.getY(), sourceCountry);
            } else {
                order = new FoodOrder(sourceCountry.position.getX(), sourceCountry.position.getY(), sourceCountry);
            }
            Common.orders.add(order);
        }
        randInt = random.nextInt(2);
        if (randInt == 0) {
            order = new BuyGoldOrder(sourceCountry.position.getX(), sourceCountry.position.getY(), sourceCountry);
        } else {
            order = new SellGoldOrder(sourceCountry.position.getX(), sourceCountry.position.getY(), sourceCountry);
        }
        Common.orders.add(order);
    }


    /**
     * This function handles horizontalLine execution logic for all order types.
     * All orders implements this according to their different logics.
     */
    public abstract void executeOrder();
}